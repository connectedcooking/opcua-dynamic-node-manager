// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.UaNodeId;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Generated on 2025-04-16 18:27:23
 */
class InternalDIUaMethodIdsHelper {
  public static final Set<UaNodeId> ALL_METHOD_IDENTIFIERS;

  static {
    Set<UaNodeId> allIds = new HashSet<UaNodeId>();
    allIds.add(DIUaMethodIds.TopologyElementType_Lock_BreakLock);
    allIds.add(DIUaMethodIds.TopologyElementType_Lock_InitLock);
    allIds.add(DIUaMethodIds.TopologyElementType_Lock_ExitLock);
    allIds.add(DIUaMethodIds.TopologyElementType_Lock_RenewLock);
    allIds.add(DIUaMethodIds.ISupportInfoType_DocumentationFiles_DocumentFileId_SetPosition);
    allIds.add(DIUaMethodIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Open);
    allIds.add(DIUaMethodIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Close);
    allIds.add(DIUaMethodIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Write);
    allIds.add(DIUaMethodIds.ISupportInfoType_DocumentationFiles_DocumentFileId_GetPosition);
    allIds.add(DIUaMethodIds.ISupportInfoType_DocumentationFiles_DocumentFileId_Read);
    allIds.add(DIUaMethodIds.NetworkType_Lock_BreakLock);
    allIds.add(DIUaMethodIds.NetworkType_Lock_RenewLock);
    allIds.add(DIUaMethodIds.NetworkType_Lock_ExitLock);
    allIds.add(DIUaMethodIds.NetworkType_Lock_InitLock);
    allIds.add(DIUaMethodIds.TransferServicesType_TransferFromDevice);
    allIds.add(DIUaMethodIds.TransferServicesType_TransferToDevice);
    allIds.add(DIUaMethodIds.TransferServicesType_FetchTransferResultData);
    allIds.add(DIUaMethodIds.LockingServicesType_ExitLock);
    allIds.add(DIUaMethodIds.LockingServicesType_InitLock);
    allIds.add(DIUaMethodIds.LockingServicesType_BreakLock);
    allIds.add(DIUaMethodIds.LockingServicesType_RenewLock);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_PrepareForUpdate_Abort);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_Installation_Resume);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_Parameters_CloseAndCommit);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_Confirmation_Confirm);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_PrepareForUpdate_Prepare);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_Parameters_GenerateFileForWrite);
    allIds.add(DIUaMethodIds.SoftwareUpdateType_Parameters_GenerateFileForRead);
    allIds.add(DIUaMethodIds.PackageLoadingType_FileTransfer_GenerateFileForWrite);
    allIds.add(DIUaMethodIds.PackageLoadingType_FileTransfer_CloseAndCommit);
    allIds.add(DIUaMethodIds.PackageLoadingType_FileTransfer_GenerateFileForRead);
    allIds.add(DIUaMethodIds.CachedLoadingType_GetUpdateBehavior);
    allIds.add(DIUaMethodIds.FileSystemLoadingType_FileSystem_CreateDirectory);
    allIds.add(DIUaMethodIds.FileSystemLoadingType_FileSystem_MoveOrCopy);
    allIds.add(DIUaMethodIds.FileSystemLoadingType_FileSystem_DeleteFileSystemObject);
    allIds.add(DIUaMethodIds.FileSystemLoadingType_FileSystem_CreateFile);
    allIds.add(DIUaMethodIds.FileSystemLoadingType_GetUpdateBehavior);
    allIds.add(DIUaMethodIds.FileSystemLoadingType_ValidateFiles);
    allIds.add(DIUaMethodIds.PrepareForUpdateStateMachineType_Abort);
    allIds.add(DIUaMethodIds.PrepareForUpdateStateMachineType_Resume);
    allIds.add(DIUaMethodIds.PrepareForUpdateStateMachineType_Prepare);
    allIds.add(DIUaMethodIds.InstallationStateMachineType_InstallFiles);
    allIds.add(DIUaMethodIds.InstallationStateMachineType_Resume);
    allIds.add(DIUaMethodIds.InstallationStateMachineType_InstallSoftwarePackage);
    allIds.add(DIUaMethodIds.ConfirmationStateMachineType_Confirm);
    ALL_METHOD_IDENTIFIERS = Collections.unmodifiableSet(allIds);
  }
}
