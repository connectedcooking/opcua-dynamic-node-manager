// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes;

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.types.opcua.BaseObjectType;
import java.lang.String;

/**
 * Represents the communication means for Devices that are connected to it.
 * <p>
 * Generated on 2024-09-09 10:35:45
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6247")
public interface NetworkType extends BaseObjectType {
  String PROFILE_IDENTIFIER = "<ProfileIdentifier>";

  String LOCK = "Lock";

  @Optional
  LockingServicesType getLockNode();
}
