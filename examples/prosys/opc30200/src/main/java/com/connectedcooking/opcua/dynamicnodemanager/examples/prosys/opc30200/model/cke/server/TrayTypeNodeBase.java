// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.TrayModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.TrayType;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.TrayTypeEnumeration;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.AnalogItemTypeNode;
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * Generated on 2022-10-10 10:21:34
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1027")
public abstract class TrayTypeNodeBase extends KitchenDeviceParameterTypeNode implements TrayType {
  private static GeneratedNodeInitializer<TrayTypeNode> f_trayTypeNodeInitializer;

  protected TrayTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId, QualifiedName browseName,
      LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getActiveSinceNode());
    callAfterCreateIfExists(getActualTemperatureNode());
    callAfterCreateIfExists(getOperatingCounterNode());
    callAfterCreateIfExists(getProgramModeNode());
    callAfterCreateIfExists(getSetTemperatureNode());
    callAfterCreateIfExists(getTypeNode());
    GeneratedNodeInitializer<TrayTypeNode> impl = getTrayTypeNodeInitializer();
    if(impl != null) {
      impl.init((TrayTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<TrayTypeNode> getTrayTypeNodeInitializer() {
    return f_trayTypeNodeInitializer;
  }

  public static void setTrayTypeNodeInitializer(GeneratedNodeInitializer<TrayTypeNode> f_trayTypeNodeInitializerNewValue) {
    f_trayTypeNodeInitializer=f_trayTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public UaProperty getNameNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "Name");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getName() {
    UaVariable node = getNameNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Name does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setName(String value) {
    UaVariable node = getNameNode();
    if (node == null) {
      throw new RuntimeException("Setting Name failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Name failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getActiveSinceNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "ActiveSince");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Integer getActiveSince() {
    UaVariable node = getActiveSinceNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node ActiveSince does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Mandatory
  @Override
  public void setActiveSince(Integer value) {
    UaVariable node = getActiveSinceNode();
    if (node == null) {
      throw new RuntimeException("Setting ActiveSince failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ActiveSince failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getActualTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "ActualTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getActualTemperature() {
    UaVariable node = getActualTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node ActualTemperature does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setActualTemperature(Float value) {
    UaVariable node = getActualTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting ActualTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ActualTemperature failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getOperatingCounterNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "OperatingCounter");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Integer getOperatingCounter() {
    UaVariable node = getOperatingCounterNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node OperatingCounter does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Mandatory
  @Override
  public void setOperatingCounter(Integer value) {
    UaVariable node = getOperatingCounterNode();
    if (node == null) {
      throw new RuntimeException("Setting OperatingCounter failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting OperatingCounter failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getProgramModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "ProgramMode");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public TrayModeEnumeration getProgramMode() {
    UaVariable node = getProgramModeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node ProgramMode does not exist");
    }
    Variant value = node.getValue().getValue();
    return (TrayModeEnumeration) value.asEnum(TrayModeEnumeration.class);
  }

  @Mandatory
  @Override
  public void setProgramMode(TrayModeEnumeration value) {
    UaVariable node = getProgramModeNode();
    if (node == null) {
      throw new RuntimeException("Setting ProgramMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ProgramMode failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getSetTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getSetTemperature() {
    UaVariable node = getSetTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node SetTemperature does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setSetTemperature(Float value) {
    UaVariable node = getSetTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetTemperature failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getTypeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "Type");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public TrayTypeEnumeration getType() {
    UaVariable node = getTypeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Type does not exist");
    }
    Variant value = node.getValue().getValue();
    return (TrayTypeEnumeration) value.asEnum(TrayTypeEnumeration.class);
  }

  @Mandatory
  @Override
  public void setType(TrayTypeEnumeration value) {
    UaVariable node = getTypeNode();
    if (node == null) {
      throw new RuntimeException("Setting Type failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Type failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}