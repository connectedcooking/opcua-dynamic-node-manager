// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.BeverageSMLEnumeration;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.stack.builtintypes.UnsignedInteger;
import com.prosysopc.ua.types.opcua.AnalogItemType;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import com.prosysopc.ua.types.opcua.MultiStateDiscreteType;
import java.lang.Float;
import java.lang.String;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1023")
public interface CoffeeMachineRecipeParameterType extends KitchenDeviceParameterType {
  String BEVERAGE_SIZE = "BeverageSize";

  String BEVERAGE_S_M_L = "BeverageSML";

  String COFFEE_TYPE = "CoffeeType";

  String CONTAINER = "Container";

  String FOAM_AMOUNT = "FoamAmount";

  String GROUNDS_AMOUNT = "GroundsAmount";

  String GROUNDS_WATER = "GroundsWater";

  String MILK_AMOUNT = "MilkAmount";

  String POWDER_AMOUNT = "PowderAmount";

  String RCP_TYPE = "RcpType";

  @Mandatory
  AnalogItemType getBeverageSizeNode();

  @Mandatory
  Float getBeverageSize();

  @Mandatory
  void setBeverageSize(Float value) throws StatusException;

  @Mandatory
  BaseDataVariableType getBeverageSMLNode();

  @Mandatory
  BeverageSMLEnumeration getBeverageSML();

  @Mandatory
  void setBeverageSML(BeverageSMLEnumeration value) throws StatusException;

  @Mandatory
  MultiStateDiscreteType getCoffeeTypeNode();

  @Mandatory
  UnsignedInteger getCoffeeType();

  @Mandatory
  void setCoffeeType(UnsignedInteger value) throws StatusException;

  @Mandatory
  MultiStateDiscreteType getContainerNode();

  @Mandatory
  UnsignedInteger getContainer();

  @Mandatory
  void setContainer(UnsignedInteger value) throws StatusException;

  @Mandatory
  AnalogItemType getFoamAmountNode();

  @Mandatory
  Float getFoamAmount();

  @Mandatory
  void setFoamAmount(Float value) throws StatusException;

  @Mandatory
  AnalogItemType getGroundsAmountNode();

  @Mandatory
  Float getGroundsAmount();

  @Mandatory
  void setGroundsAmount(Float value) throws StatusException;

  @Mandatory
  AnalogItemType getGroundsWaterNode();

  @Mandatory
  Float getGroundsWater();

  @Mandatory
  void setGroundsWater(Float value) throws StatusException;

  @Mandatory
  AnalogItemType getMilkAmountNode();

  @Mandatory
  Float getMilkAmount();

  @Mandatory
  void setMilkAmount(Float value) throws StatusException;

  @Mandatory
  AnalogItemType getPowderAmountNode();

  @Mandatory
  Float getPowderAmount();

  @Mandatory
  void setPowderAmount(Float value) throws StatusException;

  @Mandatory
  MultiStateDiscreteType getRcpTypeNode();

  @Mandatory
  UnsignedInteger getRcpType();

  @Mandatory
  void setRcpType(UnsignedInteger value) throws StatusException;
}
