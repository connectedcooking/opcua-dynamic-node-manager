// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.CombiSteamerModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.SpecialCookingModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.CombiSteamerParameterType;
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
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1010")
public abstract class CombiSteamerParameterTypeNodeBase extends KitchenDeviceParameterTypeNode implements CombiSteamerParameterType {
  private static GeneratedNodeInitializer<CombiSteamerParameterTypeNode> f_combiSteamerParameterTypeNodeInitializer;

  protected CombiSteamerParameterTypeNodeBase(Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getActualHumidityNode());
    callAfterCreateIfExists(getCombiSteamerModeNode());
    callAfterCreateIfExists(getIsDoorOpenNode());
    callAfterCreateIfExists(getIsEnergySavingActiveNode());
    callAfterCreateIfExists(getIsLoaActiveNode());
    callAfterCreateIfExists(getIsSteamExhaustSystemActiveNode());
    callAfterCreateIfExists(getSetExternalCoreTemperatureNode());
    callAfterCreateIfExists(getSetHumidityNode());
    callAfterCreateIfExists(getSetInternalCoreTemperatureNode());
    callAfterCreateIfExists(getSetProcessTimeProgramNode());
    callAfterCreateIfExists(getSetProcessTimeStepNode());
    callAfterCreateIfExists(getSetTemperatureNode());
    callAfterCreateIfExists(getSpecialCookingModeNode());
    callAfterCreateIfExists(getTimeRemainingProgramNode());
    callAfterCreateIfExists(getTimeRemainingStepNode());
    GeneratedNodeInitializer<CombiSteamerParameterTypeNode> impl = getCombiSteamerParameterTypeNodeInitializer();
    if(impl != null) {
      impl.init((CombiSteamerParameterTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<CombiSteamerParameterTypeNode> getCombiSteamerParameterTypeNodeInitializer() {
    return f_combiSteamerParameterTypeNodeInitializer;
  }

  public static void setCombiSteamerParameterTypeNodeInitializer(GeneratedNodeInitializer<CombiSteamerParameterTypeNode> f_combiSteamerParameterTypeNodeInitializerNewValue) {
    f_combiSteamerParameterTypeNodeInitializer=f_combiSteamerParameterTypeNodeInitializerNewValue;
  }

  public List<? extends AnalogItemType> getActualExternalCoreTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6119");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  @Optional
  @Override
  public AnalogItemTypeNode getActualHumidityNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "ActualHumidity");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getActualHumidity() {
    UaVariable node = getActualHumidityNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setActualHumidity(Integer value) {
    UaVariable node = getActualHumidityNode();
    if (node == null) {
      throw new RuntimeException("Setting ActualHumidity failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ActualHumidity failed unexpectedly", e);
    }
  }

  public List<? extends AnalogItemType> getActualInternalCoreTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6115");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualTemperatureChamber__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6107");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getCombiSteamerModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "CombiSteamerMode");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public CombiSteamerModeEnumeration getCombiSteamerMode() {
    UaVariable node = getCombiSteamerModeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node CombiSteamerMode does not exist");
    }
    Variant value = node.getValue().getValue();
    return (CombiSteamerModeEnumeration) value.asEnum(CombiSteamerModeEnumeration.class);
  }

  @Mandatory
  @Override
  public void setCombiSteamerMode(CombiSteamerModeEnumeration value) {
    UaVariable node = getCombiSteamerModeNode();
    if (node == null) {
      throw new RuntimeException("Setting CombiSteamerMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting CombiSteamerMode failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getIsDoorOpenNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsDoorOpen");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Boolean isIsDoorOpen() {
    UaVariable node = getIsDoorOpenNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IsDoorOpen does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
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
  public BaseDataVariableTypeNode getIsEnergySavingActiveNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsEnergySavingActive");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Boolean isIsEnergySavingActive() {
    UaVariable node = getIsEnergySavingActiveNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Optional
  @Override
  public void setIsEnergySavingActive(Boolean value) {
    UaVariable node = getIsEnergySavingActiveNode();
    if (node == null) {
      throw new RuntimeException("Setting IsEnergySavingActive failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsEnergySavingActive failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getIsLoaActiveNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsLoaActive");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Boolean isIsLoaActive() {
    UaVariable node = getIsLoaActiveNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Optional
  @Override
  public void setIsLoaActive(Boolean value) {
    UaVariable node = getIsLoaActiveNode();
    if (node == null) {
      throw new RuntimeException("Setting IsLoaActive failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsLoaActive failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getIsSteamExhaustSystemActiveNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsSteamExhaustSystemActive");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Boolean isIsSteamExhaustSystemActive() {
    UaVariable node = getIsSteamExhaustSystemActiveNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Optional
  @Override
  public void setIsSteamExhaustSystemActive(Boolean value) {
    UaVariable node = getIsSteamExhaustSystemActiveNode();
    if (node == null) {
      throw new RuntimeException("Setting IsSteamExhaustSystemActive failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsSteamExhaustSystemActive failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetExternalCoreTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetExternalCoreTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetExternalCoreTemperature() {
    UaVariable node = getSetExternalCoreTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetExternalCoreTemperature(Float value) {
    UaVariable node = getSetExternalCoreTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetExternalCoreTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetExternalCoreTemperature failed unexpectedly", e);
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
  public Integer getSetHumidity() {
    UaVariable node = getSetHumidityNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setSetHumidity(Integer value) {
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
  public AnalogItemTypeNode getSetInternalCoreTemperatureNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetInternalCoreTemperature");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Float getSetInternalCoreTemperature() {
    UaVariable node = getSetInternalCoreTemperatureNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Optional
  @Override
  public void setSetInternalCoreTemperature(Float value) {
    UaVariable node = getSetInternalCoreTemperatureNode();
    if (node == null) {
      throw new RuntimeException("Setting SetInternalCoreTemperature failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetInternalCoreTemperature failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getSetProcessTimeProgramNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetProcessTimeProgram");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Integer getSetProcessTimeProgram() {
    UaVariable node = getSetProcessTimeProgramNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node SetProcessTimeProgram does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Mandatory
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
  public AnalogItemTypeNode getSetProcessTimeStepNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetProcessTimeStep");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getSetProcessTimeStep() {
    UaVariable node = getSetProcessTimeStepNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setSetProcessTimeStep(Integer value) {
    UaVariable node = getSetProcessTimeStepNode();
    if (node == null) {
      throw new RuntimeException("Setting SetProcessTimeStep failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetProcessTimeStep failed unexpectedly", e);
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

  @Optional
  @Override
  public BaseDataVariableTypeNode getSpecialCookingModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SpecialCookingMode");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public SpecialCookingModeEnumeration getSpecialCookingMode() {
    UaVariable node = getSpecialCookingModeNode();
    if (node == null) {
      return null;
    }
    Variant value = node.getValue().getValue();
    return (SpecialCookingModeEnumeration) value.asEnum(SpecialCookingModeEnumeration.class);
  }

  @Optional
  @Override
  public void setSpecialCookingMode(SpecialCookingModeEnumeration value) {
    UaVariable node = getSpecialCookingModeNode();
    if (node == null) {
      throw new RuntimeException("Setting SpecialCookingMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SpecialCookingMode failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getTimeRemainingProgramNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "TimeRemainingProgram");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Integer getTimeRemainingProgram() {
    UaVariable node = getTimeRemainingProgramNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node TimeRemainingProgram does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Mandatory
  @Override
  public void setTimeRemainingProgram(Integer value) {
    UaVariable node = getTimeRemainingProgramNode();
    if (node == null) {
      throw new RuntimeException("Setting TimeRemainingProgram failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting TimeRemainingProgram failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getTimeRemainingStepNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "TimeRemainingStep");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getTimeRemainingStep() {
    UaVariable node = getTimeRemainingStepNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setTimeRemainingStep(Integer value) {
    UaVariable node = getTimeRemainingStepNode();
    if (node == null) {
      throw new RuntimeException("Setting TimeRemainingStep failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting TimeRemainingStep failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
