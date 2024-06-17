// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Generated on 2024-06-17 14:43:47
 */
class InternalDIObjectTypeIdsHelper {
  public static final Set<ExpandedNodeId> ALL_OBJECTTYPE_IDENTIFIERS;

  static {
    Set<ExpandedNodeId> allIds = new HashSet<ExpandedNodeId>();
    allIds.add(DIObjectTypeIds.TopologyElementType);
    allIds.add(DIObjectTypeIds.IVendorNameplateType);
    allIds.add(DIObjectTypeIds.ITagNameplateType);
    allIds.add(DIObjectTypeIds.IDeviceHealthType);
    allIds.add(DIObjectTypeIds.ISupportInfoType);
    allIds.add(DIObjectTypeIds.ComponentType);
    allIds.add(DIObjectTypeIds.DeviceType);
    allIds.add(DIObjectTypeIds.SoftwareType);
    allIds.add(DIObjectTypeIds.BlockType);
    allIds.add(DIObjectTypeIds.DeviceHealthDiagnosticAlarmType);
    allIds.add(DIObjectTypeIds.FailureAlarmType);
    allIds.add(DIObjectTypeIds.CheckFunctionAlarmType);
    allIds.add(DIObjectTypeIds.OffSpecAlarmType);
    allIds.add(DIObjectTypeIds.MaintenanceRequiredAlarmType);
    allIds.add(DIObjectTypeIds.ConfigurableObjectType);
    allIds.add(DIObjectTypeIds.BaseLifetimeIndicationType);
    allIds.add(DIObjectTypeIds.TimeIndicationType);
    allIds.add(DIObjectTypeIds.NumberOfPartsIndicationType);
    allIds.add(DIObjectTypeIds.NumberOfUsagesIndicationType);
    allIds.add(DIObjectTypeIds.LengthIndicationType);
    allIds.add(DIObjectTypeIds.DiameterIndicationType);
    allIds.add(DIObjectTypeIds.SubstanceVolumeIndicationType);
    allIds.add(DIObjectTypeIds.FunctionalGroupType);
    allIds.add(DIObjectTypeIds.ProtocolType);
    allIds.add(DIObjectTypeIds.IOperationCounterType);
    allIds.add(DIObjectTypeIds.NetworkType);
    allIds.add(DIObjectTypeIds.ConnectionPointType);
    allIds.add(DIObjectTypeIds.TransferServicesType);
    allIds.add(DIObjectTypeIds.LockingServicesType);
    allIds.add(DIObjectTypeIds.SoftwareUpdateType);
    allIds.add(DIObjectTypeIds.SoftwareLoadingType);
    allIds.add(DIObjectTypeIds.PackageLoadingType);
    allIds.add(DIObjectTypeIds.DirectLoadingType);
    allIds.add(DIObjectTypeIds.CachedLoadingType);
    allIds.add(DIObjectTypeIds.FileSystemLoadingType);
    allIds.add(DIObjectTypeIds.SoftwareVersionType);
    allIds.add(DIObjectTypeIds.PrepareForUpdateStateMachineType);
    allIds.add(DIObjectTypeIds.InstallationStateMachineType);
    allIds.add(DIObjectTypeIds.PowerCycleStateMachineType);
    allIds.add(DIObjectTypeIds.ConfirmationStateMachineType);
    ALL_OBJECTTYPE_IDENTIFIERS = Collections.unmodifiableSet(allIds);
  }
}
