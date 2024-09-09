// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Generated on 2024-09-09 10:35:45
 */
class InternalDIDataTypeIdsHelper {
  public static final Set<ExpandedNodeId> ALL_DATATYPE_IDENTIFIERS;

  static {
    Set<ExpandedNodeId> allIds = new HashSet<ExpandedNodeId>();
    allIds.add(DIDataTypeIds.DeviceHealthEnumeration);
    allIds.add(DIDataTypeIds.FetchResultDataType);
    allIds.add(DIDataTypeIds.TransferResultErrorDataType);
    allIds.add(DIDataTypeIds.TransferResultDataDataType);
    allIds.add(DIDataTypeIds.ParameterResultDataType);
    allIds.add(DIDataTypeIds.SoftwareVersionFileType);
    allIds.add(DIDataTypeIds.UpdateBehavior);
    ALL_DATATYPE_IDENTIFIERS = Collections.unmodifiableSet(allIds);
  }
}
