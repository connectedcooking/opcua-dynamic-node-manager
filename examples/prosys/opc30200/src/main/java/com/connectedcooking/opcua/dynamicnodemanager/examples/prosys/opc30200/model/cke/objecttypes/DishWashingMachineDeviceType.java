// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes;

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import java.lang.String;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1026")
public interface DishWashingMachineDeviceType extends CommercialKitchenDeviceType {
  String PARAMETERS = "Parameters";

  @Mandatory
  DishWashingMachineProgramParameterType getParametersNode();
}
