# OPC UA Dynamic Node Manager

Java library for modeling and integration of dynamic OPC UA information models.

Implements a dynamic node manager that responses dynamically based on the user context.

Aims to be easily integrated with [Prosys OPC UA SDK](https://www.prosysopc.com/products/opc-ua-java-sdk/) and [Eclipse Milo™](https://github.com/eclipse/milo) &sup1; OPC UA server SDK libraries.

&sup1; planed for Eclipse Milo™ 2.0

## Quick Start

Add necessary dependencies:

```xml
<dependency>
  <groupId>com.connectedcooking.opcua</groupId>
  <artifactId>opcua-dynamic-node-manager</artifactId>
  <version>...</version>
</dependency>
<dependency>
  <groupId>com.prosysopc.ua</groupId>
  <artifactId>prosys-opc-ua-sdk-client-server</artifactId>
  <version>4.9.0-43</version>
</dependency>
```

Create and register dynamic nodes:

```java
// create a new dynamic node manager
DynNodeManager dynNodeManager = new DynNodeManager();

// create and register the parent "Device{id}" node 
DynNode device = dynNodeManager.nodeBuilder()
    .object("Device<ID>")
    .registerAndGet();

// create and register the variable "SerialNumber" 
dynNodeManager.nodeBuilder()
    .childVariable("SerialNumber")
    .asProperty(device) // as a property of the parent
    .valueById(this::getSernum) // get the value dynamically
    .register();

// ...

// retrieve a value based on the request
String getSernum(UserContext ctx, Long deviceId) {
    if (!login(ctx.getUsername(), ctx.getCredentials())) {
        return null;
    }
    return deviceService.getDevice(deviceIde).getSernum();
}
```

Integrate the dynamic node manager via the adaptor:

```java
// get the vendor's OPC UA Server instance
UaServer server = getOpcUaServer();

// register the dynamic node manager under a namespace
String namespaceUri = "http://example.com/OPCUA/";
new ProsysDynNodeManagerAdaptor(server, namespaceUri, dynNodeManager);
```

The dynamic node will be then resolved to nodes such as `(ns=http://example.com/OPCUA/,s=Device123/SerialNumber)`.

See [examples](examples) for more details.

## Use Case

OPC UA is designed as an interface allowing a standardized read and write access to current data in automation devices.

Today, a lot of cloud-based IoT platforms are around to simplify the access to the data of devices via remote and centralized interfaces. Such platforms can profit of the benefits of OPC UA as well not only by gathering data but also by providing data via standardized OPC UA interfaces.

Such an approach would mean a little or no changes in the established client processes. The IoT platform would serve as an OPC UA umbrella over heterogeneous data from potentially different sources.

Another benefit for the operator would be a single set of OPC UA APIs to remotely access all data from multiple device with no need to establish a new connection to each device. 

![Use Case for Dynamic Node Manager](doc/Dynamic-Node-Manager-UseCase.png)

As such a platform is typically a multi-tenant and multi-user system, we need to bring dynamic not only to data but to the information model as well. The obvious requirement is confidentiality of data and meta-data; that means, not only must not a user see data of other users, event the structure (e.g. which device are in possession) must remain confident. The platform cannot simply hide the nodes by a different organization (views), it must ensure no information is available even by guessing node IDs by an unauthorized user.

Another requirement is the possibility to add and remove nodes dynamically based on the current user session.

### Example

Consider a cloud OPC UA server providing OPC UA interfaces for kitchen devices based on the Commercial Kitchen Equipment (OPC 30200) standard. The user Alice has two restaurants each with one combi steamer connected to the platform. By browsing the node DeviceSet should display two components of type definition CombiSteamerDeviceType:

```
DeviceSet
|_ Combi Steamer in Baker Street
\_ Combi Steamer in Elm Street
```

User Bob runs a cafe with three coffee machines. The cloud OPC UA server should respond with the DeviceSet node containing the following components of type definition CoffeeMachineDeviceType:  

```
DeviceSet
|_ Coffee Machine Bar 1
|_ Coffee Machine Bar 2
\_ Coffee Machine Kitchen
```

The platform must not show any combi steamers to Bob or coffee machines to Alice. That is, valid Node IDs must be different the Alice's session context than in Bob's.

## Dynamic Node Manager

The solution for the use case above is a dynamic node manager that is able to respond with a different information model based on the user session.

The dynamic node manager is set up by dynamic node definitions that specify nodes to browse based on the user context. 

First, create a new instance of the dynamic node manager:

```java
DynNodeManager dynNodeManager = new DynNodeManager();
```

Dynamic nodes IDs are based on variable parameters known to the user and therefore easy to guess such as internal IDs or serial numbers: 

```java
DynNode deviceNode = dynNodeManager.nodeBuilder()
  .object("Device_<ID>", CombiSteamerDeviceType)
  .canBrowseById((ctx, deviceId) -> hasDevice(ctx.getUsername(), deviceId))
  .registerAndGet();
```

The dynamic node ID is based on the internal device ID that will be parsed and used as a dynamic parameter together with the current user:

```java
// will be called for the node ID, e.g. (s="Device_123")
boolean hasDevice(String user, Long deviceId) {
  var userDevices = getDevicesFor(user);  
  return userDevices.contains(deviceId);
}
```

Depending on the return value of `hasDevice` the node is or is not browsable for the current user.

Next, we assign the dynamic Device_&lt;ID&gt; node to the pre-defined DeviceSet node (from the DI namespace):
```java
dynNodeManager.assignSet(
  new RealNodeId(DI, 5001), // references a node in the DI standard       
  deviceNode.nodeId(),      // our dynamic device node
  (ctx, nodeId) -> getUserDeviceIds(ctx.getUsername(), nodeId));
```

We have to specify the function to get the particular device IDs (and node IDs accordingly) the user has access to:

```java
List<Long> getUserDeviceIds(String user, DynNodeId deviceNodeId) {
  var userDevices = getDevicesFor(user);
  return userDevices
        .map(deviceId -> deviceNodeId.toReal(deviceId))   // resolve real node IDs
        .collect(toList());
}
```

The references of the node must contain only concrete "real" node IDs; they are resolved from the dynamic node IDs by applying the concrete device IDs to the name pattern:

```java
RealNodeId realNodeId = new DynNodeId("Device_<ID>").toReal(123);

"Device_123".equals(realNodeId.identifier()); // true
```

Further, we can add some property to the device node:

```java
dynNodeManager.nodeBuilder()
  .childVariable("SerialNumber")
  .asProperty(deviceNode)
  .valueById((ctx, deviceId) -> getSernum(ctx.getUsername(), deviceId))
  .register();

String getSernum(String user, Long deviceId) {
  var userDevice = getDeviceFor(user, deviceId);
  return userDevice.getSernum();
}
```

Similar for object and variable components.

The last step is to initialize the adaptor for a specific OPC UA SDK, e.g. Prosys. Because we need to intercept calls to the DI information model (to fill DeviceSet dynamically), we need to reference its node manager in the dynamic node manager as well:

```java
UaServer server = startProsysUaServer();
NodeManager diNodeManager = server.getAddressSpace().getNodeManager(DI);

new ProsysDynNodeManagerAdaptor(
      server, NS_URI, NS_VERSION, dynNodeManager, List.of(diNodeManager));
```

See the whole source code for the Commercial Kitchen Equipment (OPC 30200) standard in [examples](examples/prosys/opc30200/src/main/java/com/connectedcooking/opcua/dynamicnodemanager/examples/prosys/opc30200/ProsysOpc30200Server.java).

### Dynamic Node Definitions

Dynamic nodes are specified by a set of definition objects that is vendor-independent. That is, we can use the very same dynamic node definitions with different SDKs just by switching the adaptors:

```java
var dynNodeManager = setupDynNodeDefinitions();

// integration with the Prosys Server SDK:
var prosysServer = startProsysServer();
new ProsysDynNodeManagerAdaptor(prosysServer, ns, dynNodeManager);

// integration with the Eclipse Milo Server SDK:
var miloServer = startMiloServer();
new MiloDynNodeManagerAdaptor(miloServer, ns, dynNodeManager);
```

#### Dynamic vs. Real Node IDs

A dynamic node ID is a core attribute of a dynamic node. It is a compound of a namespace index and a string pattern. The pattern is a base for a node ID identifier when resolved to a concrete browsable node ID. It contains zero or more placeholders closed in angle brackets `<>` to be replaces with concrete parameters.

Dynamic and resolved node IDs are represented with the classes `DynNodeId` and `RealNodeId` respectively:

```java
DynNodeId dynNodeId = new DynNodeId("Device<ID>");
RealNodeId realNodeId = dynNodeId.toReal(123);

"Device123".equals(realNodeId.identifier()); // true
```

The dynamic node manager search for dynamic node IDs matching the requested real node ID and return the first found dynamic node with resolved ID from request parameters.

All nodes that are not managed by the dynamic node manager must be referenced by real node IDs.

#### Partial Node IDs

Partial node IDs are dynamic node IDs that are not unique in the namespace and cannot exist without a parent node with a unique node ID. Partial node IDs are prefixed with the parent node ID (or IDs when the parent node ID is partial as well) separated by a slash `/`.

```java
new PartialNodeId("Device<SerNum>/Errors/Err<ID>/Msg");
```

#### Dynamic Nodes Builders

The dynamic node manager provides a convenient way to create dynamic node definition via fluent builders:

```java
var dynNode = dynNodeManager.nodeBuilder()
    .object("MyNode")
    .registerAndGet();
```

The above listed code is equivalent to the following definition withou usage of builders:

```java
var dynAttrs = new DynAttributeManager();
dynAttrs.setNodeId((ctx, nid, dnode) -> new RealNodeId("MyNode));
dynAttrs.setNodeClass((ctx, nid, dnode) -> DynAttributes.NodeClasses.Object);
dynAttrs.setBrowseName((ctx, nid, dnode) -> new DynQualifiedName("MyNode"));
dynAttrs.setDisplayName((ctx, nid, dnode) -> new DynLocalizedText("MyNode"));

var dynRefs = new DynReferenceManager();
dynRefs.add(HasTypeDefinition, (ctx, nid, dnode) -> new RealNodeId(0, 58));   // BaseObjectType

var dynNodeId = new DynNodeId("MyNode");

var dynNode = new BaseDynNode(dynNodeId, null, dynAttrs, dynRefs);

dynNodeManager.registerNode(dynNode);
```

#### Dynamic Object Components

```java                
dynNodeManager.nodeBuilder()
    .childObject("ChidNode")
    .asComponent(parentNode)
    .register();
```

Such a child node will have a composed node ID `MyNode/ChidNode`.

#### Dynamic Variables and Properties

```java
dynNodeManager.nodeBuilder()
    .childVariable("MyVariable")
    .asComponent(parentNode)
    .value((ctx, nid, dnode) -> 123)
    .register();

dynNodeManager.nodeBuilder()
    .childVariable("MyProperty")
    .asProperty(parentNode)
    .value("Test")
    .register();
```

#### Assigning Dynamic Nodes

To create a starting point for browsing we have to assign a dynamic node to a standard real node e.g. the Objects folder:

```java
var objectsNodeId = new RealNodeId(0, 85);

var dynNodeId = new DynNodeId("Device<ID>");

dynNodeManager.assign(objectsNodeId, dynNodeId, (ctx, nid) -> nid.toReal());
```

## Metrics

There are basic micrometer.io metrics included:

- Counter `dynNodeManager.hasNode`
- Counter `dynNodeManager.hasNode.hits`
- Timer `dynNodeManager.readValue`
- Timer `dynNodeManager.readNonValue`

## Limitations

- Java version >= 11.
- Writing attributes not supported.
- Method execution not supported.
- Historizing not supported.
- Event notifications not supported.
- Only string-based node ID identifiers supported.
- Only username authentication is supported.
- Localization not supported.
- Role permissions not supported.
- Only not-abstract symmetric references are supported.
- Loops in references not supported (`containsNoLoops` is always true).

## Release Notes

No release yet

## Development

### Build

```shell
./mvnw clean install
```

### Architecture

The overall architecture of the Dynamic Node Manager consists from three logical components:

- Vendor Server SDK
- Vendor-specific Adaptor
- Node Manager with Dynamic Node definitions

The Adaptor implements the Server Interface to intercept the request to a specific namespace and provides a response by calling the Dynamic Node Manager.

![Dynamic Node Manager Architecture](doc/Dynamic-Node-Manager-Architecture.png)

#### Dynamic Node Manager

The Dynamic Node Manager is free of any vendor-specific details and can be used in multiple vendor Adaptors without change.

It holds a set of definitions of Dynamic Nodes which looks up when serving a request.

A Dynamic Node with a dynamic node ID, dynamic attribute, and dynamic reference resolvers.

The dynamic node ID, attributes, and references are resolved to concrete ones upon the request based on the client context. 

## License

[MIT](https://github.com/connectedcooking/opcua-dynamic-node-manager/blob/main/LICENSE)

### TODO

- EventNotifier
- Milo adaptor (for Milo 2.0)