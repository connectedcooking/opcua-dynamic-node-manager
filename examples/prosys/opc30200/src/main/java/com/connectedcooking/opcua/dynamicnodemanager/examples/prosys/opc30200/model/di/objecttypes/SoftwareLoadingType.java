// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import com.prosysopc.ua.types.opcua.BaseObjectType;
import java.lang.String;

/**
 * Generated on 2025-04-16 18:27:23
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=135")
public interface SoftwareLoadingType extends BaseObjectType {
  String UPDATE_KEY = "UpdateKey";

  @Optional
  BaseDataVariableType getUpdateKeyNode();

  @Optional
  String getUpdateKey();

  @Optional
  void setUpdateKey(String value) throws StatusException;
}
