// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes;

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import java.lang.String;

/**
 * Generated on 2024-06-17 14:43:51
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1034")
public interface MicrowaveCombiOvenDeviceType extends CommercialKitchenDeviceType {
  String MICROWAVE_COMBI_OVEN = "MicrowaveCombiOven";

  @Mandatory
  MicrowaveCombiOvenParameterType getMicrowaveCombiOvenNode();
}
