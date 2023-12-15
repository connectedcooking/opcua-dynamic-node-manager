// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes.DeviceHealthEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.IDeviceHealthType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import com.prosysopc.ua.types.opcua.server.BaseInterfaceTypeNode;
import com.prosysopc.ua.types.opcua.server.FolderTypeNode;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Generated on 2023-09-26 10:56:50
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15051")
public abstract class IDeviceHealthTypeNodeBase extends BaseInterfaceTypeNode implements IDeviceHealthType {
  private static GeneratedNodeInitializer<IDeviceHealthTypeNode> f_iDeviceHealthTypeNodeInitializer;

  protected IDeviceHealthTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getDeviceHealthNode());
    callAfterCreateIfExists(getDeviceHealthAlarmsNode());
    GeneratedNodeInitializer<IDeviceHealthTypeNode> impl = getIDeviceHealthTypeNodeInitializer();
    if(impl != null) {
      impl.init((IDeviceHealthTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<IDeviceHealthTypeNode> getIDeviceHealthTypeNodeInitializer() {
    return f_iDeviceHealthTypeNodeInitializer;
  }

  public static void setIDeviceHealthTypeNodeInitializer(GeneratedNodeInitializer<IDeviceHealthTypeNode> f_iDeviceHealthTypeNodeInitializerNewValue) {
    f_iDeviceHealthTypeNodeInitializer=f_iDeviceHealthTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getDeviceHealthNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "DeviceHealth");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public DeviceHealthEnumeration getDeviceHealth() {
    UaVariable node = getDeviceHealthNode();
    if (node == null) {
      return null;
    }
    Variant value = node.getValue().getValue();
    return (DeviceHealthEnumeration) value.asEnum(DeviceHealthEnumeration.class);
  }

  @Optional
  @Override
  public void setDeviceHealth(DeviceHealthEnumeration value) {
    UaVariable node = getDeviceHealthNode();
    if (node == null) {
      throw new RuntimeException("Setting DeviceHealth failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting DeviceHealth failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public FolderTypeNode getDeviceHealthAlarmsNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "DeviceHealthAlarms");
    return (FolderTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}