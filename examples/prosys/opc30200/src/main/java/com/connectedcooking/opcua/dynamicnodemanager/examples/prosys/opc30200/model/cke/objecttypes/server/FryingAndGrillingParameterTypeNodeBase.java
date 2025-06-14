// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.GrillingZoneStateEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.PlatenPositionStateEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.FryingAndGrillingParameterType;
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
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.List;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1031")
public abstract class FryingAndGrillingParameterTypeNodeBase extends KitchenDeviceParameterTypeNode implements FryingAndGrillingParameterType {
  private static GeneratedNodeInitializer<FryingAndGrillingParameterTypeNode> f_fryingAndGrillingParameterTypeNodeInitializer;

  protected FryingAndGrillingParameterTypeNodeBase(Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getCurrentStateNode());
    callAfterCreateIfExists(getGrillingZoneNameNode());
    callAfterCreateIfExists(getIsWithPlatenNode());
    callAfterCreateIfExists(getPlatenPositionStateNode());
    callAfterCreateIfExists(getRemainingProcessTimeNode());
    callAfterCreateIfExists(getSetProcessTimeNode());
    GeneratedNodeInitializer<FryingAndGrillingParameterTypeNode> impl = getFryingAndGrillingParameterTypeNodeInitializer();
    if(impl != null) {
      impl.init((FryingAndGrillingParameterTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<FryingAndGrillingParameterTypeNode> getFryingAndGrillingParameterTypeNodeInitializer() {
    return f_fryingAndGrillingParameterTypeNodeInitializer;
  }

  public static void setFryingAndGrillingParameterTypeNodeInitializer(GeneratedNodeInitializer<FryingAndGrillingParameterTypeNode> f_fryingAndGrillingParameterTypeNodeInitializerNewValue) {
    f_fryingAndGrillingParameterTypeNodeInitializer=f_fryingAndGrillingParameterTypeNodeInitializerNewValue;
  }

  public List<? extends AnalogItemType> getActualGrillTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6560");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getActualPlatenTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6564");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getCurrentStateNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "CurrentState");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public GrillingZoneStateEnumeration getCurrentState() {
    UaVariable node = getCurrentStateNode();
    if (node == null) {
      return null;
    }
    Variant value = node.getValue().getValue();
    return (GrillingZoneStateEnumeration) value.asEnum(GrillingZoneStateEnumeration.class);
  }

  @Optional
  @Override
  public void setCurrentState(GrillingZoneStateEnumeration value) {
    UaVariable node = getCurrentStateNode();
    if (node == null) {
      throw new RuntimeException("Setting CurrentState failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting CurrentState failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getGrillingZoneNameNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "GrillingZoneName");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public String getGrillingZoneName() {
    UaVariable node = getGrillingZoneNameNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Optional
  @Override
  public void setGrillingZoneName(String value) {
    UaVariable node = getGrillingZoneNameNode();
    if (node == null) {
      throw new RuntimeException("Setting GrillingZoneName failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting GrillingZoneName failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getIsWithPlatenNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "IsWithPlaten");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Boolean isIsWithPlaten() {
    UaVariable node = getIsWithPlatenNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IsWithPlaten does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
  @Override
  public void setIsWithPlaten(Boolean value) {
    UaVariable node = getIsWithPlatenNode();
    if (node == null) {
      throw new RuntimeException("Setting IsWithPlaten failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IsWithPlaten failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getPlatenPositionStateNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "PlatenPositionState");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public PlatenPositionStateEnumeration getPlatenPositionState() {
    UaVariable node = getPlatenPositionStateNode();
    if (node == null) {
      return null;
    }
    Variant value = node.getValue().getValue();
    return (PlatenPositionStateEnumeration) value.asEnum(PlatenPositionStateEnumeration.class);
  }

  @Optional
  @Override
  public void setPlatenPositionState(PlatenPositionStateEnumeration value) {
    UaVariable node = getPlatenPositionStateNode();
    if (node == null) {
      throw new RuntimeException("Setting PlatenPositionState failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting PlatenPositionState failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public AnalogItemTypeNode getRemainingProcessTimeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "RemainingProcessTime");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getRemainingProcessTime() {
    UaVariable node = getRemainingProcessTimeNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setRemainingProcessTime(Integer value) {
    UaVariable node = getRemainingProcessTimeNode();
    if (node == null) {
      throw new RuntimeException("Setting RemainingProcessTime failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting RemainingProcessTime failed unexpectedly", e);
    }
  }

  public List<? extends AnalogItemType> getSetGrillTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6562");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  public List<? extends AnalogItemType> getSetPlatenTemperature__No__Nodes() {
    ExpandedNodeId placheholderId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=6566");
    ExpandedNodeId referenceTypeId = ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=47");
    return findPlaceholders(AnalogItemType.class, placheholderId, referenceTypeId);
  }

  @Optional
  @Override
  public AnalogItemTypeNode getSetProcessTimeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "SetProcessTime");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public Integer getSetProcessTime() {
    UaVariable node = getSetProcessTimeNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setSetProcessTime(Integer value) {
    UaVariable node = getSetProcessTimeNode();
    if (node == null) {
      throw new RuntimeException("Setting SetProcessTime failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SetProcessTime failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
