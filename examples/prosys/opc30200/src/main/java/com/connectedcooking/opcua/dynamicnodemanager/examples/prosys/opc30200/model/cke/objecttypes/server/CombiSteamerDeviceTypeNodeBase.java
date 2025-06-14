// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.EnergySourceEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.CombiSteamerDeviceType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1011")
public abstract class CombiSteamerDeviceTypeNodeBase extends CommercialKitchenDeviceTypeNode implements CombiSteamerDeviceType {
  private static GeneratedNodeInitializer<CombiSteamerDeviceTypeNode> f_combiSteamerDeviceTypeNodeInitializer;

  protected CombiSteamerDeviceTypeNodeBase(Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getCombiSteamerNode());
    GeneratedNodeInitializer<CombiSteamerDeviceTypeNode> impl = getCombiSteamerDeviceTypeNodeInitializer();
    if(impl != null) {
      impl.init((CombiSteamerDeviceTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<CombiSteamerDeviceTypeNode> getCombiSteamerDeviceTypeNodeInitializer() {
    return f_combiSteamerDeviceTypeNodeInitializer;
  }

  public static void setCombiSteamerDeviceTypeNodeInitializer(GeneratedNodeInitializer<CombiSteamerDeviceTypeNode> f_combiSteamerDeviceTypeNodeInitializerNewValue) {
    f_combiSteamerDeviceTypeNodeInitializer=f_combiSteamerDeviceTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public UaProperty getEnergySourceNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "EnergySource");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public EnergySourceEnumeration getEnergySource() {
    UaVariable node = getEnergySourceNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node EnergySource does not exist");
    }
    Variant value = node.getValue().getValue();
    return (EnergySourceEnumeration) value.asEnum(EnergySourceEnumeration.class);
  }

  @Mandatory
  @Override
  public void setEnergySource(EnergySourceEnumeration value) {
    UaVariable node = getEnergySourceNode();
    if (node == null) {
      throw new RuntimeException("Setting EnergySource failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting EnergySource failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getIsWithAutomaticCleaningNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsWithAutomaticCleaning");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Boolean isIsWithAutomaticCleaning() {
    UaVariable node = getIsWithAutomaticCleaningNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IsWithAutomaticCleaning does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
  @Override
  public void setIsWithAutomaticCleaning(Boolean value) {
    UaVariable node = getIsWithAutomaticCleaningNode();
    if (node == null) {
      throw new RuntimeException("Setting IsWithAutomaticCleaning failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsWithAutomaticCleaning failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getIsWithExternalCoreTempSensorNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsWithExternalCoreTempSensor");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Boolean isIsWithExternalCoreTempSensor() {
    UaVariable node = getIsWithExternalCoreTempSensorNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IsWithExternalCoreTempSensor does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
  @Override
  public void setIsWithExternalCoreTempSensor(Boolean value) {
    UaVariable node = getIsWithExternalCoreTempSensorNode();
    if (node == null) {
      throw new RuntimeException("Setting IsWithExternalCoreTempSensor failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsWithExternalCoreTempSensor failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getIsWithInternalCoreTempSensorNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsWithInternalCoreTempSensor");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Boolean isIsWithInternalCoreTempSensor() {
    UaVariable node = getIsWithInternalCoreTempSensorNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IsWithInternalCoreTempSensor does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
  @Override
  public void setIsWithInternalCoreTempSensor(Boolean value) {
    UaVariable node = getIsWithInternalCoreTempSensorNode();
    if (node == null) {
      throw new RuntimeException("Setting IsWithInternalCoreTempSensor failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsWithInternalCoreTempSensor failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getIsWithSousvideTempSensorNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsWithSousvideTempSensor");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Boolean isIsWithSousvideTempSensor() {
    UaVariable node = getIsWithSousvideTempSensorNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IsWithSousvideTempSensor does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
  @Override
  public void setIsWithSousvideTempSensor(Boolean value) {
    UaVariable node = getIsWithSousvideTempSensorNode();
    if (node == null) {
      throw new RuntimeException("Setting IsWithSousvideTempSensor failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsWithSousvideTempSensor failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public CombiSteamerParameterTypeNode getCombiSteamerNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "CombiSteamer");
    return (CombiSteamerParameterTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
