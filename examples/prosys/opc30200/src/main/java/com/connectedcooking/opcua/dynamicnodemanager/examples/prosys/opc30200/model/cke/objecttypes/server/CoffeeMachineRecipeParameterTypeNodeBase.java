// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.BeverageSMLEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.CoffeeMachineRecipeParameterType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.UnsignedInteger;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.AnalogItemTypeNode;
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import com.prosysopc.ua.types.opcua.server.MultiStateDiscreteTypeNode;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Generated on 2023-09-26 10:56:54
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1023")
public abstract class CoffeeMachineRecipeParameterTypeNodeBase extends KitchenDeviceParameterTypeNode implements CoffeeMachineRecipeParameterType {
  private static GeneratedNodeInitializer<CoffeeMachineRecipeParameterTypeNode> f_coffeeMachineRecipeParameterTypeNodeInitializer;

  protected CoffeeMachineRecipeParameterTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getBeverageSizeNode());
    callAfterCreateIfExists(getBeverageSMLNode());
    callAfterCreateIfExists(getCoffeeTypeNode());
    callAfterCreateIfExists(getContainerNode());
    callAfterCreateIfExists(getFoamAmountNode());
    callAfterCreateIfExists(getGroundsAmountNode());
    callAfterCreateIfExists(getGroundsWaterNode());
    callAfterCreateIfExists(getMilkAmountNode());
    callAfterCreateIfExists(getPowderAmountNode());
    callAfterCreateIfExists(getRcpTypeNode());
    GeneratedNodeInitializer<CoffeeMachineRecipeParameterTypeNode> impl = getCoffeeMachineRecipeParameterTypeNodeInitializer();
    if(impl != null) {
      impl.init((CoffeeMachineRecipeParameterTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<CoffeeMachineRecipeParameterTypeNode> getCoffeeMachineRecipeParameterTypeNodeInitializer() {
    return f_coffeeMachineRecipeParameterTypeNodeInitializer;
  }

  public static void setCoffeeMachineRecipeParameterTypeNodeInitializer(GeneratedNodeInitializer<CoffeeMachineRecipeParameterTypeNode> f_coffeeMachineRecipeParameterTypeNodeInitializerNewValue) {
    f_coffeeMachineRecipeParameterTypeNodeInitializer=f_coffeeMachineRecipeParameterTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getBeverageSizeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "BeverageSize");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getBeverageSize() {
    UaVariable node = getBeverageSizeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node BeverageSize does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setBeverageSize(Float value) {
    UaVariable node = getBeverageSizeNode();
    if (node == null) {
      throw new RuntimeException("Setting BeverageSize failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting BeverageSize failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getBeverageSMLNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "BeverageSML");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public BeverageSMLEnumeration getBeverageSML() {
    UaVariable node = getBeverageSMLNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node BeverageSML does not exist");
    }
    Variant value = node.getValue().getValue();
    return (BeverageSMLEnumeration) value.asEnum(BeverageSMLEnumeration.class);
  }

  @Mandatory
  @Override
  public void setBeverageSML(BeverageSMLEnumeration value) {
    UaVariable node = getBeverageSMLNode();
    if (node == null) {
      throw new RuntimeException("Setting BeverageSML failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting BeverageSML failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public MultiStateDiscreteTypeNode getCoffeeTypeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "CoffeeType");
    return (MultiStateDiscreteTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public UnsignedInteger getCoffeeType() {
    UaVariable node = getCoffeeTypeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node CoffeeType does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (UnsignedInteger) value;
  }

  @Mandatory
  @Override
  public void setCoffeeType(UnsignedInteger value) {
    UaVariable node = getCoffeeTypeNode();
    if (node == null) {
      throw new RuntimeException("Setting CoffeeType failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting CoffeeType failed unexpectedly", e);
    }
  }

  public void setCoffeeType(long value) {
    setCoffeeType(UnsignedInteger.valueOf(value));
  }

  @Mandatory
  @Override
  public MultiStateDiscreteTypeNode getContainerNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "Container");
    return (MultiStateDiscreteTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public UnsignedInteger getContainer() {
    UaVariable node = getContainerNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Container does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (UnsignedInteger) value;
  }

  @Mandatory
  @Override
  public void setContainer(UnsignedInteger value) {
    UaVariable node = getContainerNode();
    if (node == null) {
      throw new RuntimeException("Setting Container failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Container failed unexpectedly", e);
    }
  }

  public void setContainer(long value) {
    setContainer(UnsignedInteger.valueOf(value));
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getFoamAmountNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "FoamAmount");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getFoamAmount() {
    UaVariable node = getFoamAmountNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node FoamAmount does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setFoamAmount(Float value) {
    UaVariable node = getFoamAmountNode();
    if (node == null) {
      throw new RuntimeException("Setting FoamAmount failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting FoamAmount failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getGroundsAmountNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "GroundsAmount");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getGroundsAmount() {
    UaVariable node = getGroundsAmountNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node GroundsAmount does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setGroundsAmount(Float value) {
    UaVariable node = getGroundsAmountNode();
    if (node == null) {
      throw new RuntimeException("Setting GroundsAmount failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting GroundsAmount failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getGroundsWaterNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "GroundsWater");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getGroundsWater() {
    UaVariable node = getGroundsWaterNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node GroundsWater does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setGroundsWater(Float value) {
    UaVariable node = getGroundsWaterNode();
    if (node == null) {
      throw new RuntimeException("Setting GroundsWater failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting GroundsWater failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getMilkAmountNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "MilkAmount");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getMilkAmount() {
    UaVariable node = getMilkAmountNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node MilkAmount does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setMilkAmount(Float value) {
    UaVariable node = getMilkAmountNode();
    if (node == null) {
      throw new RuntimeException("Setting MilkAmount failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting MilkAmount failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public AnalogItemTypeNode getPowderAmountNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "PowderAmount");
    return (AnalogItemTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public Float getPowderAmount() {
    UaVariable node = getPowderAmountNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node PowderAmount does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Float) value;
  }

  @Mandatory
  @Override
  public void setPowderAmount(Float value) {
    UaVariable node = getPowderAmountNode();
    if (node == null) {
      throw new RuntimeException("Setting PowderAmount failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting PowderAmount failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public MultiStateDiscreteTypeNode getRcpTypeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "RcpType");
    return (MultiStateDiscreteTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public UnsignedInteger getRcpType() {
    UaVariable node = getRcpTypeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node RcpType does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (UnsignedInteger) value;
  }

  @Mandatory
  @Override
  public void setRcpType(UnsignedInteger value) {
    UaVariable node = getRcpTypeNode();
    if (node == null) {
      throw new RuntimeException("Setting RcpType failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting RcpType failed unexpectedly", e);
    }
  }

  public void setRcpType(long value) {
    setRcpType(UnsignedInteger.valueOf(value));
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}