// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.ChamberModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.ChamberType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.AnalogItemType;
import com.prosysopc.ua.types.opcua.server.AnalogItemTypeNode;
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.util.List;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1012")
public abstract class ChamberTypeNodeBase extends KitchenDeviceParameterTypeNode implements ChamberType {
  private static GeneratedNodeInitializer<ChamberTypeNode> f_chamberTypeNodeInitializer;

  protected ChamberTypeNodeBase(Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getIsDoorOpenNode());
    callAfterCreateIfExists(getIsProgramEndNode());
    callAfterCreateIfExists(getIsReadyToStartNode());
    callAfterCreateIfExists(getOperationModeNode());
    callAfterCreateIfExists(getSetBoilerTemperatureNode());
    callAfterCreateIfExists(getSetBottomTemperatureNode());
    callAfterCreateIfExists(getSetChamberTemperatureNode());
    callAfterCreateIfExists(getSetCoreTemperatureNode());
    callAfterCreateIfExists(getSetFanSpeedNode());
    callAfterCreateIfExists(getSetHumidityNode());
    callAfterCreateIfExists(getSetProcessTimeProgramNode());
    callAfterCreateIfExists(getSetTopTemperatureNode());
    callAfterCreateIfExists(getTimeRemainingNode());
    GeneratedNodeInitializer<ChamberTypeNode> impl = getChamberTypeNodeInitializer();
    if(impl != null) {
      impl.init((ChamberTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<ChamberTypeNode> getChamberTypeNodeInitializer() {
    return f_chamberTypeNodeInitializer;
  }

  public static void setChamberTypeNodeInitializer(GeneratedNodeInitializer<ChamberTypeNode> f_chamberTypeNodeInitializerNewValue) {
    f_chamberTypeNodeInitializer=f_chamberTypeNodeInitializerNewValue;
  }

  public List<? extends AnalogItemType> getActualBoilerTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6192");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualBottomTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6188");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualChamberTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6182");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualCoreTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6190");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualFanSpeed__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6201");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualHumidity__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6196");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualTopTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6186");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getIsDoorOpenNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsDoorOpen");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Boolean isIsDoorOpen() {
    UaVariable node = getIsDoorOpenNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Optional
  @Override
  public void setIsDoorOpen(Boolean value) {
    UaVariable node = getIsDoorOpenNode();
    if (node == null) {
      throw new RuntimeException("Setting IsDoorOpen failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsDoorOpen failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getIsProgramEndNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsProgramEnd");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Boolean isIsProgramEnd() {
    UaVariable node = getIsProgramEndNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Optional
  @Override
  public void setIsProgramEnd(Boolean value) {
    UaVariable node = getIsProgramEndNode();
    if (node == null) {
      throw new RuntimeException("Setting IsProgramEnd failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsProgramEnd failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getIsReadyToStartNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsReadyToStart");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Boolean isIsReadyToStart() {
    UaVariable node = getIsReadyToStartNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Optional
  @Override
  public void setIsReadyToStart(Boolean value) {
    UaVariable node = getIsReadyToStartNode();
    if (node == null) {
      throw new RuntimeException("Setting IsReadyToStart failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsReadyToStart failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getOperationModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "OperationMode");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public ChamberModeEnumeration getOperationMode() {
    UaVariable node = getOperationModeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node OperationMode does not exist");
    }
    Variant value = node.getValue().getValue();
    return (ChamberModeEnumeration) value.asEnum(ChamberModeEnumeration.class);
  }

  @Mandatory
  @Override
  public void setOperationMode(ChamberModeEnumeration value) {
    UaVariable node = getOperationModeNode();
    if (node == null) {
      throw new RuntimeException("Setting OperationMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting OperationMode failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetBoilerTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetBoilerTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetBoilerTemperature() {
    UaVariable node = getSetBoilerTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetBoilerTemperature(Float value) {
    UaVariable node = getSetBoilerTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetBoilerTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetBoilerTemperature failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetBottomTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetBottomTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetBottomTemperature() {
    UaVariable node = getSetBottomTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetBottomTemperature(Float value) {
    UaVariable node = getSetBottomTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetBottomTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetBottomTemperature failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetChamberTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetChamberTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetChamberTemperature() {
    UaVariable node = getSetChamberTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetChamberTemperature(Float value) {
    UaVariable node = getSetChamberTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetChamberTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetChamberTemperature failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetCoreTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetCoreTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetCoreTemperature() {
    UaVariable node = getSetCoreTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetCoreTemperature(Float value) {
    UaVariable node = getSetCoreTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetCoreTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetCoreTemperature failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetFanSpeedNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetFanSpeed");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getSetFanSpeed() {
    UaVariable node = getSetFanSpeedNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setSetFanSpeed(Integer value) {
    UaVariable node = getSetFanSpeedNode();
    if (node == null) {
      throw new RuntimeException("Setting SetFanSpeed failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetFanSpeed failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetHumidityNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetHumidity");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetHumidity() {
    UaVariable node = getSetHumidityNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetHumidity(Float value) {
    UaVariable node = getSetHumidityNode();
    if (node == null) {
      throw new RuntimeException("Setting SetHumidity failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetHumidity failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetProcessTimeProgramNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetProcessTimeProgram");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getSetProcessTimeProgram() {
    UaVariable node = getSetProcessTimeProgramNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setSetProcessTimeProgram(Integer value) {
    UaVariable node = getSetProcessTimeProgramNode();
    if (node == null) {
      throw new RuntimeException("Setting SetProcessTimeProgram failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetProcessTimeProgram failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetTopTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetTopTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetTopTemperature() {
    UaVariable node = getSetTopTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetTopTemperature(Float value) {
    UaVariable node = getSetTopTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetTopTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetTopTemperature failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getTimeRemainingNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "TimeRemaining");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getTimeRemaining() {
    UaVariable node = getTimeRemainingNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setTimeRemaining(Integer value) {
    UaVariable node = getTimeRemainingNode();
    if (node == null) {
      throw new RuntimeException("Setting TimeRemaining failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting TimeRemaining failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
