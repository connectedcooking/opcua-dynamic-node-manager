// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.ChamberModeEnumeration;
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
import java.util.List;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1012")
public interface ChamberType extends KitchenDeviceParameterType {
  String ACTUAL_BOILER_TEMPERATURE___NO__ = "ActualBoilerTemperature_<No.>";

  String ACTUAL_BOTTOM_TEMPERATURE___NO__ = "ActualBottomTemperature_<No.>";

  String ACTUAL_CHAMBER_TEMPERATURE___NO__ = "ActualChamberTemperature_<No.>";

  String ACTUAL_CORE_TEMPERATURE___NO__ = "ActualCoreTemperature_<No.>";

  String ACTUAL_FAN_SPEED___NO__ = "ActualFanSpeed_<No.>";

  String ACTUAL_HUMIDITY___NO__ = "ActualHumidity_<No.>";

  String ACTUAL_TOP_TEMPERATURE___NO__ = "ActualTopTemperature_<No.>";

  String IS_DOOR_OPEN = "IsDoorOpen";

  String IS_PROGRAM_END = "IsProgramEnd";

  String IS_READY_TO_START = "IsReadyToStart";

  String OPERATION_MODE = "OperationMode";

  String SET_BOILER_TEMPERATURE = "SetBoilerTemperature";

  String SET_BOTTOM_TEMPERATURE = "SetBottomTemperature";

  String SET_CHAMBER_TEMPERATURE = "SetChamberTemperature";

  String SET_CORE_TEMPERATURE = "SetCoreTemperature";

  String SET_FAN_SPEED = "SetFanSpeed";

  String SET_HUMIDITY = "SetHumidity";

  String SET_PROCESS_TIME_PROGRAM = "SetProcessTimeProgram";

  String SET_TOP_TEMPERATURE = "SetTopTemperature";

  String TIME_REMAINING = "TimeRemaining";

  List<? extends AnalogItemType> getActualBoilerTemperature__No__Nodes();

  List<? extends AnalogItemType> getActualBottomTemperature__No__Nodes();

  List<? extends AnalogItemType> getActualChamberTemperature__No__Nodes();

  List<? extends AnalogItemType> getActualCoreTemperature__No__Nodes();

  List<? extends AnalogItemType> getActualFanSpeed__No__Nodes();

  List<? extends AnalogItemType> getActualHumidity__No__Nodes();

  List<? extends AnalogItemType> getActualTopTemperature__No__Nodes();

  @Optional
  BaseDataVariableType getIsDoorOpenNode();

  @Optional
  Boolean isIsDoorOpen();

  @Optional
  void setIsDoorOpen(Boolean value) throws StatusException;

  @Optional
  BaseDataVariableType getIsProgramEndNode();

  @Optional
  Boolean isIsProgramEnd();

  @Optional
  void setIsProgramEnd(Boolean value) throws StatusException;

  @Optional
  BaseDataVariableType getIsReadyToStartNode();

  @Optional
  Boolean isIsReadyToStart();

  @Optional
  void setIsReadyToStart(Boolean value) throws StatusException;

  @Mandatory
  BaseDataVariableType getOperationModeNode();

  @Mandatory
  ChamberModeEnumeration getOperationMode();

  @Mandatory
  void setOperationMode(ChamberModeEnumeration value) throws StatusException;

  @Optional
  AnalogItemType getSetBoilerTemperatureNode();

  @Optional
  Float getSetBoilerTemperature();

  @Optional
  void setSetBoilerTemperature(Float value) throws StatusException;

  @Optional
  AnalogItemType getSetBottomTemperatureNode();

  @Optional
  Float getSetBottomTemperature();

  @Optional
  void setSetBottomTemperature(Float value) throws StatusException;

  @Optional
  AnalogItemType getSetChamberTemperatureNode();

  @Optional
  Float getSetChamberTemperature();

  @Optional
  void setSetChamberTemperature(Float value) throws StatusException;

  @Optional
  AnalogItemType getSetCoreTemperatureNode();

  @Optional
  Float getSetCoreTemperature();

  @Optional
  void setSetCoreTemperature(Float value) throws StatusException;

  @Optional
  AnalogItemType getSetFanSpeedNode();

  @Optional
  Integer getSetFanSpeed();

  @Optional
  void setSetFanSpeed(Integer value) throws StatusException;

  @Optional
  AnalogItemType getSetHumidityNode();

  @Optional
  Float getSetHumidity();

  @Optional
  void setSetHumidity(Float value) throws StatusException;

  @Optional
  AnalogItemType getSetProcessTimeProgramNode();

  @Optional
  Integer getSetProcessTimeProgram();

  @Optional
  void setSetProcessTimeProgram(Integer value) throws StatusException;

  @Optional
  AnalogItemType getSetTopTemperatureNode();

  @Optional
  Float getSetTopTemperature();

  @Optional
  void setSetTopTemperature(Float value) throws StatusException;

  @Optional
  AnalogItemType getTimeRemainingNode();

  @Optional
  Integer getTimeRemaining();

  @Optional
  void setTimeRemaining(Integer value) throws StatusException;
}
