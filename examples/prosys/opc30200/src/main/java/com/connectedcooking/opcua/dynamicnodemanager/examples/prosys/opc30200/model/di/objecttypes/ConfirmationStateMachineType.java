// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes;

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import com.prosysopc.ua.types.opcua.FiniteStateMachineType;
import java.lang.Double;
import java.lang.String;

/**
 * Generated on 2024-09-09 10:35:45
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=307")
public interface ConfirmationStateMachineType extends FiniteStateMachineType {
  String CONFIRMATION_TIMEOUT = "ConfirmationTimeout";

  String CONFIRM = "Confirm";

  @Mandatory
  BaseDataVariableType getConfirmationTimeoutNode();

  @Mandatory
  Double getConfirmationTimeout();

  @Mandatory
  void setConfirmationTimeout(Double value) throws StatusException;

  @Mandatory
  UaMethod getConfirmNode();

  void confirm() throws StatusException, ServiceException;
}
