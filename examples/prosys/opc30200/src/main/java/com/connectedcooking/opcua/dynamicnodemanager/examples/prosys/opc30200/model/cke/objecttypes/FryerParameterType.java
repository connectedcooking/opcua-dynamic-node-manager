// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.FryerModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.SignalModeEnumeration;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.types.opcua.AnalogItemType;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;

/**
 * Generated on 2024-09-09 10:35:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1006")
public interface FryerParameterType extends KitchenDeviceParameterType {
  String ACTUAL_TEMPERATURE = "ActualTemperature";

  String IS_LIFT_UP = "IsLiftUp";

  String PROGRAM_MODE = "ProgramMode";

  String SET_PROCESS_TIME = "SetProcessTime";

  String SET_TEMPERATURE = "SetTemperature";

  String SIGNAL_MODE = "SignalMode";

  String TIME_REMAINING = "TimeRemaining";

  @Mandatory
  AnalogItemType getActualTemperatureNode();

  @Mandatory
  Float getActualTemperature();

  @Mandatory
  void setActualTemperature(Float value) throws StatusException;

  @Optional
  BaseDataVariableType getIsLiftUpNode();

  @Optional
  Boolean isIsLiftUp();

  @Optional
  void setIsLiftUp(Boolean value) throws StatusException;

  @Mandatory
  BaseDataVariableType getProgramModeNode();

  @Mandatory
  FryerModeEnumeration getProgramMode();

  @Mandatory
  void setProgramMode(FryerModeEnumeration value) throws StatusException;

  @Mandatory
  AnalogItemType getSetProcessTimeNode();

  @Mandatory
  Integer getSetProcessTime();

  @Mandatory
  void setSetProcessTime(Integer value) throws StatusException;

  @Mandatory
  AnalogItemType getSetTemperatureNode();

  @Mandatory
  Float getSetTemperature();

  @Mandatory
  void setSetTemperature(Float value) throws StatusException;

  @Mandatory
  BaseDataVariableType getSignalModeNode();

  @Mandatory
  SignalModeEnumeration getSignalMode();

  @Mandatory
  void setSignalMode(SignalModeEnumeration value) throws StatusException;

  @Mandatory
  AnalogItemType getTimeRemainingNode();

  @Mandatory
  Integer getTimeRemaining();

  @Mandatory
  void setTimeRemaining(Integer value) throws StatusException;
}
