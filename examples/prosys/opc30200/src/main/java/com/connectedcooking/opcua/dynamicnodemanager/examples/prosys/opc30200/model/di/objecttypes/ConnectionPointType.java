// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes;

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import java.lang.String;

/**
 * Represents the interface (interface card) of a Device to a Network.
 * <p>
 * Generated on 2024-09-09 10:35:45
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6308")
public interface ConnectionPointType extends TopologyElementType {
  String NETWORK_ADDRESS = "NetworkAddress";

  String PROFILE_IDENTIFIER = "<ProfileIdentifier>";

  @Mandatory
  FunctionalGroupType getNetworkAddressNode();
}
