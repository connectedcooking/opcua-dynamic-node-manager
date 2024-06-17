// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes;

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.stack.builtintypes.UnsignedByte;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import com.prosysopc.ua.types.opcua.FiniteStateMachineType;
import java.lang.String;

/**
 * Generated on 2024-06-17 14:43:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=213")
public interface PrepareForUpdateStateMachineType extends FiniteStateMachineType {
  String PERCENT_COMPLETE = "PercentComplete";

  String PREPARE = "Prepare";

  String ABORT = "Abort";

  String RESUME = "Resume";

  @Optional
  BaseDataVariableType getPercentCompleteNode();

  @Optional
  UnsignedByte getPercentComplete();

  @Optional
  void setPercentComplete(UnsignedByte value) throws StatusException;

  @Mandatory
  UaMethod getPrepareNode();

  void prepare() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getAbortNode();

  void abort() throws StatusException, ServiceException;

  @Optional
  UaMethod getResumeNode();

  void resume() throws StatusException, ServiceException;
}
