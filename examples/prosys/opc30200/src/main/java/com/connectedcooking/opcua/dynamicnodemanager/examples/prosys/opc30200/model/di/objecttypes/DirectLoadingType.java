// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes.UpdateBehavior;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import java.lang.Double;
import java.lang.String;

/**
 * Generated on 2025-04-16 18:27:23
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=153")
public interface DirectLoadingType extends PackageLoadingType {
  String WRITE_TIMEOUT = "WriteTimeout";

  String UPDATE_BEHAVIOR = "UpdateBehavior";

  @Optional
  UaProperty getWriteTimeoutNode();

  @Optional
  Double getWriteTimeout();

  @Optional
  void setWriteTimeout(Double value) throws StatusException;

  @Mandatory
  BaseDataVariableType getUpdateBehaviorNode();

  @Mandatory
  UpdateBehavior getUpdateBehavior();

  @Mandatory
  void setUpdateBehavior(UpdateBehavior value) throws StatusException;
}
