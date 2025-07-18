// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.stack.builtintypes.DateTime;
import com.prosysopc.ua.stack.core.TimeZoneDataType;
import com.prosysopc.ua.types.opcua.BaseObjectType;
import java.lang.String;

/**
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1002")
public interface BatchInformationType extends BaseObjectType {
  String BATCH_ID = "BatchId";

  String LOCAL_TIME = "LocalTime";

  String ORDER_ID = "OrderId";

  String SYSTEM_TIME = "SystemTime";

  @Mandatory
  UaProperty getBatchIdNode();

  @Mandatory
  String getBatchId();

  @Mandatory
  void setBatchId(String value) throws StatusException;

  @Optional
  UaProperty getLocalTimeNode();

  @Optional
  TimeZoneDataType getLocalTime();

  @Optional
  void setLocalTime(TimeZoneDataType value) throws StatusException;

  @Mandatory
  UaProperty getOrderIdNode();

  @Mandatory
  String getOrderId();

  @Mandatory
  void setOrderId(String value) throws StatusException;

  @Mandatory
  UaProperty getSystemTimeNode();

  @Mandatory
  DateTime getSystemTime();

  @Mandatory
  void setSystemTime(DateTime value) throws StatusException;
}
