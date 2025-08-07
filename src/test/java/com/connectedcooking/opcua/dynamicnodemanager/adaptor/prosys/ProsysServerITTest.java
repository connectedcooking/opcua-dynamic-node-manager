package com.connectedcooking.opcua.dynamicnodemanager.adaptor.prosys;

import com.connectedcooking.opcua.dynamicnodemanager.core.*;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;
import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.UserIdentity;
import com.prosysopc.ua.UserTokenPolicies;
import com.prosysopc.ua.client.UaClient;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.stack.builtintypes.DataValue;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.core.*;
import com.prosysopc.ua.stack.transport.security.SecurityMode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
class ProsysServerITTest {

    private static final String NAMESPACE_URI = "http://connectedcooking.com/OPCUA/Test/";
    private static final String NAMESPACE_VERSION = "1.0-SNAPSHOT";

    private static final String SET_NODE_ID = "DeviceSet";

    private static final String DEVICE_NODE_ID = "Device<ID>";
    private static final String DEVICE_NODE_ID_REAL_1 = "Device1";
    private static final String DEVICE_NODE_ID_REAL_2 = "Device2";

    private static final String SERNUM_NODE_ID = "SerialNumber";

    private static final String USERNAME = "TestUser1";
    private static final String PASSWORD = "Secret123!";

    private static UaServer server;
    private static UaClient client;

    private static ProsysDynNodeManagerAdaptor prosysAdaptor;
    private static DynNodeManager dynNodeManager;
    private static int nsIndex;

    private static String currentValue = "TEST123";

    @BeforeAll
    static void setup() throws Exception {
        // create server
        server = new UaServer();
        server.setPort(14840);
        server.setServerName("OPCUA/Test");
        server.getSecurityModes().add(SecurityMode.NONE);
        server.setUserTokenPolicies(UserTokenPolicies.SECURE_USERNAME_PASSWORD_BASIC128RSA15);
        var appDescription = new ApplicationDescription();
        appDescription.setApplicationName(new LocalizedText("TestServer"));
        appDescription.setApplicationUri("urn:test:opcua");
        appDescription.setProductUri("https://connectedcooking.com/opcua");
        appDescription.setApplicationType(ApplicationType.Server);
        server.setApplicationIdentity(ApplicationIdentity.createCertificate(appDescription, "Test", 512));

        server.start();

        // init server - dynamic node manager
        dynNodeManager = new DynNodeManager();
        prosysAdaptor = new ProsysDynNodeManagerAdaptor(server, NAMESPACE_URI, NAMESPACE_VERSION, dynNodeManager, List.of(server.getNodeManagerRoot()));
        nsIndex = prosysAdaptor.getNamespaceIndex();

        // create client
        client = new UaClient("opc.tcp://127.0.0.1:14840/OPCUA/Test");
        client.setApplicationIdentity(new ApplicationIdentity());
        client.setSecurityMode(SecurityMode.NONE);
        client.setUserIdentity(new UserIdentity(USERNAME, PASSWORD));
        client.setTimeout(10, TimeUnit.MINUTES);

        setupDynamicNodeManager();
    }

    static void setupDynamicNodeManager() {
        var objects = new RealNodeId(ObjectIdentifiers.ObjectsFolder.getNamespaceIndex(), ObjectIdentifiers.ObjectsFolder.getValue());

        var deviceSetAttrs = new DynAttributeManager();
        deviceSetAttrs.setNodeId((ctx, nid, dnode) -> new RealNodeId(nid));
        deviceSetAttrs.setNodeClass((ctx, nid, dnode) -> DynAttributes.NodeClasses.Object);
        deviceSetAttrs.setBrowseName((ctx, nid, dnode) -> new DynQualifiedName(nid));
        deviceSetAttrs.setDisplayName((ctx, nid, dnode) -> new DynLocalizedText(nid));
        var deviceSetRefs = new DynReferenceManager();
        deviceSetRefs.add(DynReferences.Types.HasTypeDefinition, (ctx, nid, dnode) -> new RealNodeId(0, 58));   // BaseObjectType
        deviceSetRefs.add(DynReferences.Types.HasComponent, (ctx, nid, dnode) -> new RealNodeId(DEVICE_NODE_ID_REAL_1));
        deviceSetRefs.add(DynReferences.Types.HasComponent, (ctx, nid, dnode) -> new RealNodeId(DEVICE_NODE_ID_REAL_2));
        var deviceSet = new BaseDynNode(new DynNodeId(SET_NODE_ID), null, deviceSetAttrs, deviceSetRefs);
        dynNodeManager.registerNode(deviceSet);
        dynNodeManager.assign(objects, deviceSet.nodeId(), (ctx, nodeId) -> new RealNodeId(SET_NODE_ID));

        var deviceAttrs = new DynAttributeManager();
        deviceAttrs.setNodeId((ctx, nid, dnode) -> new RealNodeId(nid));
        deviceAttrs.setNodeClass((ctx, nid, dnode) -> DynAttributes.NodeClasses.Object);
        deviceAttrs.setBrowseName((ctx, nid, dnode) -> new DynQualifiedName(nid));
        deviceAttrs.setDisplayName((ctx, nid, dnode) -> new DynLocalizedText(nid));
        var deviceRefs = new DynReferenceManager();
        deviceRefs.add(DynReferences.Types.HasTypeDefinition, (ctx, nid, dnode) -> new RealNodeId(0, 58));   // BaseObjectType
        deviceRefs.add(DynReferences.Types.HasProperty, (ctx, nid, dnode) -> new RealNodeId(nid, SERNUM_NODE_ID));
        deviceRefs.addInverse(DynReferences.Types.HasComponent, (ctx, nid, dnode) -> new RealNodeId(SET_NODE_ID));
        var device = new BaseDynNode(new DynNodeId(DEVICE_NODE_ID), null, deviceAttrs, deviceRefs);
        dynNodeManager.registerNode(device);

        var sernumAttrs = new DynAttributeManager();
        sernumAttrs.setNodeId((ctx, nid, dnode) -> new RealNodeId(nid));
        sernumAttrs.setNodeClass((ctx, nid, dnode) -> DynAttributes.NodeClasses.Variable);
        sernumAttrs.setBrowseName((ctx, nid, dnode) -> new DynQualifiedName(SERNUM_NODE_ID));
        sernumAttrs.setDisplayName((ctx, nid, dnode) -> new DynLocalizedText(SERNUM_NODE_ID));
        sernumAttrs.setValue((ctx, nid, dnode) -> currentValue);
        sernumAttrs.setValueWrite((ctx, nid, dnode, value) -> currentValue = (String) value);
        sernumAttrs.setAccessLevel((ctx, nid, dnode) -> new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead, DynAttributes.AccessLevels.CurrentWrite});
        var sernumRefs = new DynReferenceManager();
        sernumRefs.add(DynReferences.Types.HasTypeDefinition, (ctx, nid, dnode) -> new RealNodeId(0, 63));   // BaseDataVariableType
        sernumRefs.addInverse(DynReferences.Types.HasProperty, (ctx, nid, dnode) -> device.nodeId().toRealById(nid));
        var sernum = new BaseDynNode(new PartialNodeId(SERNUM_NODE_ID), device.nodeId(), sernumAttrs, sernumRefs);
        dynNodeManager.registerNode(sernum);
    }

    @BeforeEach
    void connect() throws ServiceException {
        client.connect();
    }

    @AfterEach
    void disconnect() {
        if (client.isConnected()) {
            client.disconnect();
        }
    }

    @Test
    void reads_server_node() throws Exception {
        DataValue value = client.readValue(Identifiers.Server_ServerStatus_State);

        assertThat(value.getStatusCode().getValue()).isEqualTo(StatusCodes.Good);
    }

    @Test
    void reads_namespace() {
        var namespaces = client.getNamespaceTable();
        var index = namespaces.getIndex(NAMESPACE_URI);

        assertThat(index).isEqualTo(2);
    }

    @Test
    void reads_namespace_metadata() throws Exception {
        var valueUri = client.readValue(new NodeId(nsIndex, "NamespaceMetadata/NamespaceUri"));
        var valueVersion = client.readValue(new NodeId(nsIndex, "NamespaceMetadata/NamespaceVersion"));

        assertAll(
                () -> assertThat(valueUri.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(valueUri.getValue().getValue()).isEqualTo(NAMESPACE_URI),
                () -> assertThat(valueVersion.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(valueVersion.getValue().getValue()).isEqualTo(NAMESPACE_VERSION)
        );
    }

    @Test
    void reads_objects_node() throws Exception {
        var node = client.getAddressSpace().getNode(ObjectIdentifiers.ObjectsFolder);
        assertThat(node.getBrowseName().getName()).isEqualTo("Objects");
    }

    @Test
    void browses_objects_node() throws Exception {
        var references = client.getAddressSpace().browse(ObjectIdentifiers.ObjectsFolder);

        assertThat(references).hasSize(4);

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).contains("Server", "Aliases", "DeviceSet", "Locations");
    }

    @Test
    void browses_deviceSet_node() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(nsIndex, "DeviceSet"));

        assertThat(references).hasSize(2);

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).contains("Device1", "Device2");
    }

    @Test
    void reads_device_attributes() throws Exception {
        var browseName = client.readAttribute(new NodeId(nsIndex, DEVICE_NODE_ID_REAL_1), Attributes.BrowseName);

        assertAll(
                () -> assertThat(browseName.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("Device1")
        );
    }

    @Test
    void browses_device_node() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(nsIndex, "Device123"));

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).contains("SerialNumber");
    }

    @Test
    void reads_serialNumber_attributes() throws Exception {
        var browseName = client.readAttribute(new NodeId(nsIndex, "Device1/SerialNumber"), Attributes.BrowseName);

        assertAll(
                () -> assertThat(browseName.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("SerialNumber")
        );
    }

    @Test
    void reads_serialNumber_value() throws Exception {
        var value = client.readValue(new NodeId(nsIndex, "Device1/SerialNumber"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(currentValue)
        );
    }

    @Test
    void writes_serialNumber_value() throws Exception {
        var value = client.writeValue(new NodeId(nsIndex, "Device1/SerialNumber"), "Updated");

        assertAll(
                () -> assertThat(value).isTrue(),
                () -> assertThat(currentValue).isEqualTo("Updated")
        );
    }
}
