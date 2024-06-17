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
class InternalDIVariableIdsHelper {
  public static final Set<ExpandedNodeId> ALL_VARIABLE_IDENTIFIERS;

  static {
    Set<ExpandedNodeId> allIds = new HashSet<ExpandedNodeId>();
    allIds.add(DIVariableIds.TopologyElementType_Lock_LockingClient);
    allIds.add(DIVariableIds.TopologyElementType_ParameterSet_ParameterIdentifier);
    allIds.add(DIVariableIds.TopologyElementType_Lock_Locked);
    allIds.add(DIVariableIds.TopologyElementType_Lock_InitLock_InputArguments);
    allIds.add(DIVariableIds.TopologyElementType_Lock_InitLock_OutputArguments);
    allIds.add(DIVariableIds.TopologyElementType_Lock_RemainingLockTime);
    allIds.add(DIVariableIds.TopologyElementType_Lock_RenewLock_OutputArguments);
    allIds.add(DIVariableIds.TopologyElementType_Lock_BreakLock_OutputArguments);
    allIds.add(DIVariableIds.TopologyElementType_Lock_LockingUser);
    allIds.add(DIVariableIds.TopologyElementType_Lock_ExitLock_OutputArguments);
    allIds.add(DIVariableIds.IVendorNameplateType_ProductInstanceUri);
    allIds.add(DIVariableIds.IVendorNameplateType_PatchIdentifiers);
    allIds.add(DIVariableIds.IVendorNameplateType_ManufacturerUri);
    allIds.add(DIVariableIds.IVendorNameplateType_RevisionCounter);
    allIds.add(DIVariableIds.IVendorNameplateType_DeviceRevision);
    allIds.add(DIVariableIds.IVendorNameplateType_SoftwareReleaseDate);
    allIds.add(DIVariableIds.IVendorNameplateType_SoftwareRevision);
    allIds.add(DIVariableIds.IVendorNameplateType_Manufacturer);
    allIds.add(DIVariableIds.IVendorNameplateType_DeviceManual);
    allIds.add(DIVariableIds.IVendorNameplateType_ProductCode);
    allIds.add(DIVariableIds.IVendorNameplateType_DeviceClass);
    allIds.add(DIVariableIds.IVendorNameplateType_HardwareRevision);
    allIds.add(DIVariableIds.IVendorNameplateType_Model);
    allIds.add(DIVariableIds.IVendorNameplateType_SerialNumber);
    allIds.add(DIVariableIds.ITagNameplateType_AssetId);
    allIds.add(DIVariableIds.ITagNameplateType_ComponentName);
    allIds.add(DIVariableIds.IDeviceHealthType_DeviceHealth);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Size);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Read_OutputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Write_InputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_Documentation_DocumentIdentifier);
    allIds.add(DIVariableIds.ISupportInfoType_ImageSet_ImageIdentifier);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Read_InputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_SetPosition_InputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_GetPosition_InputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Open_InputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_ProtocolSupport_ProtocolSupportIdentifier);
    allIds.add(DIVariableIds.ISupportInfoType_DeviceTypeImage_ImageIdentifier);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Close_InputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Writable);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Open_OutputArguments);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_OpenCount);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_UserWritable);
    allIds.add(DIVariableIds.ISupportInfoType_DocumentationFiles_DocumentFileId_GetPosition_OutputArguments);
    allIds.add(DIVariableIds.ComponentType_RevisionCounter);
    allIds.add(DIVariableIds.ComponentType_DeviceRevision);
    allIds.add(DIVariableIds.ComponentType_ManufacturerUri);
    allIds.add(DIVariableIds.ComponentType_HardwareRevision);
    allIds.add(DIVariableIds.ComponentType_SoftwareRevision);
    allIds.add(DIVariableIds.ComponentType_ProductInstanceUri);
    allIds.add(DIVariableIds.ComponentType_AssetId);
    allIds.add(DIVariableIds.ComponentType_ComponentName);
    allIds.add(DIVariableIds.ComponentType_ProductCode);
    allIds.add(DIVariableIds.ComponentType_DeviceClass);
    allIds.add(DIVariableIds.ComponentType_Model);
    allIds.add(DIVariableIds.ComponentType_SerialNumber);
    allIds.add(DIVariableIds.ComponentType_Manufacturer);
    allIds.add(DIVariableIds.ComponentType_DeviceManual);
    allIds.add(DIVariableIds.DeviceType_HardwareRevision);
    allIds.add(DIVariableIds.DeviceType_SoftwareRevision);
    allIds.add(DIVariableIds.DeviceType_Documentation_DocumentIdentifier);
    allIds.add(DIVariableIds.DeviceType_ManufacturerUri);
    allIds.add(DIVariableIds.DeviceType_DeviceClass);
    allIds.add(DIVariableIds.DeviceType_DeviceHealth);
    allIds.add(DIVariableIds.DeviceType_ProtocolSupport_ProtocolSupportIdentifier);
    allIds.add(DIVariableIds.DeviceType_DeviceRevision);
    allIds.add(DIVariableIds.DeviceType_Manufacturer);
    allIds.add(DIVariableIds.DeviceType_SerialNumber);
    allIds.add(DIVariableIds.DeviceType_DeviceManual);
    allIds.add(DIVariableIds.DeviceType_ProductInstanceUri);
    allIds.add(DIVariableIds.DeviceType_ProductCode);
    allIds.add(DIVariableIds.DeviceType_DeviceTypeImage_ImageIdentifier);
    allIds.add(DIVariableIds.DeviceType_RevisionCounter);
    allIds.add(DIVariableIds.DeviceType_Model);
    allIds.add(DIVariableIds.DeviceType_ImageSet_ImageIdentifier);
    allIds.add(DIVariableIds.SoftwareType_SoftwareRevision);
    allIds.add(DIVariableIds.SoftwareType_Manufacturer);
    allIds.add(DIVariableIds.SoftwareType_Model);
    allIds.add(DIVariableIds.BlockType_RevisionCounter);
    allIds.add(DIVariableIds.BlockType_ActualMode);
    allIds.add(DIVariableIds.BlockType_TargetMode);
    allIds.add(DIVariableIds.BlockType_NormalMode);
    allIds.add(DIVariableIds.BlockType_PermittedMode);
    allIds.add(DIVariableIds.LifetimeVariableType_WarningValues);
    allIds.add(DIVariableIds.LifetimeVariableType_StartValue);
    allIds.add(DIVariableIds.LifetimeVariableType_LimitValue);
    allIds.add(DIVariableIds.LifetimeVariableType_Indication);
    allIds.add(DIVariableIds.FunctionalGroupType_GroupIdentifier_UIElement);
    allIds.add(DIVariableIds.FunctionalGroupType_UIElement);
    allIds.add(DIVariableIds.DeviceHealthEnumeration_EnumStrings);
    allIds.add(DIVariableIds.IOperationCounterType_OperationDuration);
    allIds.add(DIVariableIds.IOperationCounterType_PowerOnDuration);
    allIds.add(DIVariableIds.IOperationCounterType_OperationCycleCounter);
    allIds.add(DIVariableIds.NetworkType_Lock_RemainingLockTime);
    allIds.add(DIVariableIds.NetworkType_Lock_RenewLock_OutputArguments);
    allIds.add(DIVariableIds.NetworkType_Lock_InitLock_InputArguments);
    allIds.add(DIVariableIds.NetworkType_Lock_LockingClient);
    allIds.add(DIVariableIds.NetworkType_Lock_InitLock_OutputArguments);
    allIds.add(DIVariableIds.NetworkType_Lock_LockingUser);
    allIds.add(DIVariableIds.NetworkType_Lock_Locked);
    allIds.add(DIVariableIds.NetworkType_Lock_BreakLock_OutputArguments);
    allIds.add(DIVariableIds.NetworkType_Lock_ExitLock_OutputArguments);
    allIds.add(DIVariableIds.FetchResultDataType_DefaultXml_FetchResultDataType);
    allIds.add(DIVariableIds.FetchResultDataType_DefaultBinary_FetchResultDataType);
    allIds.add(DIVariableIds.TransferResultErrorDataType_DefaultBinary_TransferResultErrorDataType);
    allIds.add(DIVariableIds.TransferResultErrorDataType_DefaultXml_TransferResultErrorDataType);
    allIds.add(DIVariableIds.TransferResultDataDataType_DefaultBinary_TransferResultDataDataType);
    allIds.add(DIVariableIds.TransferResultDataDataType_DefaultXml_TransferResultDataDataType);
    allIds.add(DIVariableIds.ParameterResultDataType_DefaultBinary_ParameterResultDataType);
    allIds.add(DIVariableIds.ParameterResultDataType_DefaultXml_ParameterResultDataType);
    allIds.add(DIVariableIds.TransferServicesType_FetchTransferResultData_InputArguments);
    allIds.add(DIVariableIds.TransferServicesType_TransferToDevice_OutputArguments);
    allIds.add(DIVariableIds.TransferServicesType_FetchTransferResultData_OutputArguments);
    allIds.add(DIVariableIds.TransferServicesType_TransferFromDevice_OutputArguments);
    allIds.add(DIVariableIds.LockingServicesType_DefaultInstanceBrowseName);
    allIds.add(DIVariableIds.LockingServicesType_LockingUser);
    allIds.add(DIVariableIds.LockingServicesType_InitLock_InputArguments);
    allIds.add(DIVariableIds.LockingServicesType_BreakLock_OutputArguments);
    allIds.add(DIVariableIds.LockingServicesType_InitLock_OutputArguments);
    allIds.add(DIVariableIds.LockingServicesType_Locked);
    allIds.add(DIVariableIds.LockingServicesType_LockingClient);
    allIds.add(DIVariableIds.LockingServicesType_RemainingLockTime);
    allIds.add(DIVariableIds.LockingServicesType_ExitLock_OutputArguments);
    allIds.add(DIVariableIds.LockingServicesType_RenewLock_OutputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_PrepareForUpdate_CurrentState);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_GenerateFileForWrite_InputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_Confirmation_CurrentState_Id);
    allIds.add(DIVariableIds.SoftwareUpdateType_PrepareForUpdate_CurrentState_Id);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_GenerateFileForWrite_OutputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_Confirmation_CurrentState);
    allIds.add(DIVariableIds.SoftwareUpdateType_Installation_CurrentState_Id);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_CloseAndCommit_InputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_Installation_CurrentState);
    allIds.add(DIVariableIds.SoftwareUpdateType_VendorErrorCode);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_GenerateFileForRead_OutputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_CloseAndCommit_OutputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_GenerateFileForRead_InputArguments);
    allIds.add(DIVariableIds.SoftwareUpdateType_Parameters_ClientProcessingTimeout);
    allIds.add(DIVariableIds.SoftwareUpdateType_PowerCycle_CurrentState_Id);
    allIds.add(DIVariableIds.SoftwareUpdateType_UpdateStatus);
    allIds.add(DIVariableIds.SoftwareUpdateType_PowerCycle_CurrentState);
    allIds.add(DIVariableIds.SoftwareUpdateType_Confirmation_ConfirmationTimeout);
    allIds.add(DIVariableIds.SoftwareUpdateType_DefaultInstanceBrowseName);
    allIds.add(DIVariableIds.SoftwareLoadingType_UpdateKey);
    allIds.add(DIVariableIds.PackageLoadingType_CurrentVersion_Manufacturer);
    allIds.add(DIVariableIds.PackageLoadingType_CurrentVersion_SoftwareRevision);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_CloseAndCommit_OutputArguments);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_CloseAndCommit_InputArguments);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_GenerateFileForWrite_OutputArguments);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_GenerateFileForWrite_InputArguments);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_ClientProcessingTimeout);
    allIds.add(DIVariableIds.PackageLoadingType_CurrentVersion_ManufacturerUri);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_GenerateFileForRead_OutputArguments);
    allIds.add(DIVariableIds.PackageLoadingType_WriteBlockSize);
    allIds.add(DIVariableIds.PackageLoadingType_ErrorMessage);
    allIds.add(DIVariableIds.PackageLoadingType_FileTransfer_GenerateFileForRead_InputArguments);
    allIds.add(DIVariableIds.DirectLoadingType_UpdateBehavior);
    allIds.add(DIVariableIds.DirectLoadingType_WriteTimeout);
    allIds.add(DIVariableIds.CachedLoadingType_FallbackVersion_Manufacturer);
    allIds.add(DIVariableIds.CachedLoadingType_GetUpdateBehavior_InputArguments);
    allIds.add(DIVariableIds.CachedLoadingType_FallbackVersion_SoftwareRevision);
    allIds.add(DIVariableIds.CachedLoadingType_PendingVersion_Manufacturer);
    allIds.add(DIVariableIds.CachedLoadingType_FallbackVersion_ManufacturerUri);
    allIds.add(DIVariableIds.CachedLoadingType_GetUpdateBehavior_OutputArguments);
    allIds.add(DIVariableIds.CachedLoadingType_PendingVersion_SoftwareRevision);
    allIds.add(DIVariableIds.CachedLoadingType_PendingVersion_ManufacturerUri);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_CreateFile_InputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_GetUpdateBehavior_InputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_CreateFile_OutputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_MoveOrCopy_InputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_ValidateFiles_OutputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_GetUpdateBehavior_OutputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_CreateDirectory_InputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_ValidateFiles_InputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_CreateDirectory_OutputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_DeleteFileSystemObject_InputArguments);
    allIds.add(DIVariableIds.FileSystemLoadingType_FileSystem_MoveOrCopy_OutputArguments);
    allIds.add(DIVariableIds.SoftwareVersionType_ManufacturerUri);
    allIds.add(DIVariableIds.SoftwareVersionType_Hash);
    allIds.add(DIVariableIds.SoftwareVersionType_PatchIdentifiers);
    allIds.add(DIVariableIds.SoftwareVersionType_SoftwareRevision);
    allIds.add(DIVariableIds.SoftwareVersionType_ChangeLogReference);
    allIds.add(DIVariableIds.SoftwareVersionType_Manufacturer);
    allIds.add(DIVariableIds.SoftwareVersionType_ReleaseDate);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_Resuming_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparedForUpdateToResuming_PreparedForUpdate_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparedForUpdateToResuming_Resuming_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_IdleToPreparing_Preparing_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparingToIdle_Preparing_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_IdleToPreparing_Idle_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_ResumingToIdle_Resuming_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparingToIdle_TransitionNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_IdleToPreparing_TransitionNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_Preparing_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparingToPreparedForUpdate_TransitionNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparingToPreparedForUpdate_Preparing_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparingToPreparedForUpdate_PreparedForUpdate_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparingToIdle_Idle_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PercentComplete);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_ResumingToIdle_TransitionNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_Idle_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparedForUpdate_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_ResumingToIdle_Idle_StateNumber);
    allIds.add(DIVariableIds.PrepareForUpdateStateMachineType_PreparedForUpdateToResuming_TransitionNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallingToIdle_Idle_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallationDelay);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallingToError_TransitionNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_IdleToInstalling_TransitionNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_ErrorToIdle_TransitionNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallFiles_InputArguments);
    allIds.add(DIVariableIds.InstallationStateMachineType_ErrorToIdle_Idle_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallSoftwarePackage_InputArguments);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallingToIdle_Installing_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallingToError_Error_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_Idle_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_IdleToInstalling_Installing_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_IdleToInstalling_Idle_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_PercentComplete);
    allIds.add(DIVariableIds.InstallationStateMachineType_Installing_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallingToError_Installing_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_ErrorToIdle_Error_StateNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_InstallingToIdle_TransitionNumber);
    allIds.add(DIVariableIds.InstallationStateMachineType_Error_StateNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_NotWaitingForPowerCycleToWaitingForPowerCycle_WaitingForPowerCycle_StateNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_WaitingForPowerCycleToNotWaitingForPowerCycle_TransitionNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_WaitingForPowerCycleToNotWaitingForPowerCycle_WaitingForPowerCycle_StateNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_NotWaitingForPowerCycle_StateNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_NotWaitingForPowerCycleToWaitingForPowerCycle_TransitionNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_WaitingForPowerCycleToNotWaitingForPowerCycle_NotWaitingForPowerCycle_StateNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_NotWaitingForPowerCycleToWaitingForPowerCycle_NotWaitingForPowerCycle_StateNumber);
    allIds.add(DIVariableIds.PowerCycleStateMachineType_WaitingForPowerCycle_StateNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_NotWaitingForConfirm_StateNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_NotWaitingForConfirmToWaitingForConfirm_WaitingForConfirm_StateNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_NotWaitingForConfirmToWaitingForConfirm_TransitionNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_WaitingForConfirmToNotWaitingForConfirm_WaitingForConfirm_StateNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_ConfirmationTimeout);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_WaitingForConfirmToNotWaitingForConfirm_TransitionNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_NotWaitingForConfirmToWaitingForConfirm_NotWaitingForConfirm_StateNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_WaitingForConfirmToNotWaitingForConfirm_NotWaitingForConfirm_StateNumber);
    allIds.add(DIVariableIds.ConfirmationStateMachineType_WaitingForConfirm_StateNumber);
    allIds.add(DIVariableIds.SoftwareVersionFileType_EnumStrings);
    allIds.add(DIVariableIds.UpdateBehavior_OptionSetValues);
    ALL_VARIABLE_IDENTIFIERS = Collections.unmodifiableSet(allIds);
  }
}
