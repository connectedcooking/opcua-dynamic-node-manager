// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.UaNodeId;
import java.util.Set;

/**
 * Generated on 2025-04-16 18:27:23
 */
public interface DIUaMethodIds {
  UaNodeId TopologyElementType_Lock_BreakLock = DIUaMethodIdsInit.initTopologyElementType_Lock_BreakLock();

  UaNodeId TopologyElementType_Lock_InitLock = DIUaMethodIdsInit.initTopologyElementType_Lock_InitLock();

  UaNodeId TopologyElementType_Lock_ExitLock = DIUaMethodIdsInit.initTopologyElementType_Lock_ExitLock();

  UaNodeId TopologyElementType_Lock_RenewLock = DIUaMethodIdsInit.initTopologyElementType_Lock_RenewLock();

  UaNodeId ISupportInfoType_DocumentationFiles_DocumentFileId_SetPosition = DIUaMethodIdsInit.initISupportInfoType_DocumentationFiles_DocumentFileId_SetPosition();

  UaNodeId ISupportInfoType_DocumentationFiles_DocumentFileId_Open = DIUaMethodIdsInit.initISupportInfoType_DocumentationFiles_DocumentFileId_Open();

  UaNodeId ISupportInfoType_DocumentationFiles_DocumentFileId_Close = DIUaMethodIdsInit.initISupportInfoType_DocumentationFiles_DocumentFileId_Close();

  UaNodeId ISupportInfoType_DocumentationFiles_DocumentFileId_Write = DIUaMethodIdsInit.initISupportInfoType_DocumentationFiles_DocumentFileId_Write();

  UaNodeId ISupportInfoType_DocumentationFiles_DocumentFileId_GetPosition = DIUaMethodIdsInit.initISupportInfoType_DocumentationFiles_DocumentFileId_GetPosition();

  UaNodeId ISupportInfoType_DocumentationFiles_DocumentFileId_Read = DIUaMethodIdsInit.initISupportInfoType_DocumentationFiles_DocumentFileId_Read();

  UaNodeId NetworkType_Lock_BreakLock = DIUaMethodIdsInit.initNetworkType_Lock_BreakLock();

  UaNodeId NetworkType_Lock_RenewLock = DIUaMethodIdsInit.initNetworkType_Lock_RenewLock();

  UaNodeId NetworkType_Lock_ExitLock = DIUaMethodIdsInit.initNetworkType_Lock_ExitLock();

  UaNodeId NetworkType_Lock_InitLock = DIUaMethodIdsInit.initNetworkType_Lock_InitLock();

  UaNodeId TransferServicesType_TransferFromDevice = DIUaMethodIdsInit.initTransferServicesType_TransferFromDevice();

  UaNodeId TransferServicesType_TransferToDevice = DIUaMethodIdsInit.initTransferServicesType_TransferToDevice();

  UaNodeId TransferServicesType_FetchTransferResultData = DIUaMethodIdsInit.initTransferServicesType_FetchTransferResultData();

  UaNodeId LockingServicesType_ExitLock = DIUaMethodIdsInit.initLockingServicesType_ExitLock();

  UaNodeId LockingServicesType_InitLock = DIUaMethodIdsInit.initLockingServicesType_InitLock();

  UaNodeId LockingServicesType_BreakLock = DIUaMethodIdsInit.initLockingServicesType_BreakLock();

  UaNodeId LockingServicesType_RenewLock = DIUaMethodIdsInit.initLockingServicesType_RenewLock();

  UaNodeId SoftwareUpdateType_PrepareForUpdate_Abort = DIUaMethodIdsInit.initSoftwareUpdateType_PrepareForUpdate_Abort();

  UaNodeId SoftwareUpdateType_Installation_Resume = DIUaMethodIdsInit.initSoftwareUpdateType_Installation_Resume();

  UaNodeId SoftwareUpdateType_Parameters_CloseAndCommit = DIUaMethodIdsInit.initSoftwareUpdateType_Parameters_CloseAndCommit();

  UaNodeId SoftwareUpdateType_Confirmation_Confirm = DIUaMethodIdsInit.initSoftwareUpdateType_Confirmation_Confirm();

  UaNodeId SoftwareUpdateType_PrepareForUpdate_Prepare = DIUaMethodIdsInit.initSoftwareUpdateType_PrepareForUpdate_Prepare();

  UaNodeId SoftwareUpdateType_Parameters_GenerateFileForWrite = DIUaMethodIdsInit.initSoftwareUpdateType_Parameters_GenerateFileForWrite();

  UaNodeId SoftwareUpdateType_Parameters_GenerateFileForRead = DIUaMethodIdsInit.initSoftwareUpdateType_Parameters_GenerateFileForRead();

  UaNodeId PackageLoadingType_FileTransfer_GenerateFileForWrite = DIUaMethodIdsInit.initPackageLoadingType_FileTransfer_GenerateFileForWrite();

  UaNodeId PackageLoadingType_FileTransfer_CloseAndCommit = DIUaMethodIdsInit.initPackageLoadingType_FileTransfer_CloseAndCommit();

  UaNodeId PackageLoadingType_FileTransfer_GenerateFileForRead = DIUaMethodIdsInit.initPackageLoadingType_FileTransfer_GenerateFileForRead();

  UaNodeId CachedLoadingType_GetUpdateBehavior = DIUaMethodIdsInit.initCachedLoadingType_GetUpdateBehavior();

  UaNodeId FileSystemLoadingType_FileSystem_CreateDirectory = DIUaMethodIdsInit.initFileSystemLoadingType_FileSystem_CreateDirectory();

  UaNodeId FileSystemLoadingType_FileSystem_MoveOrCopy = DIUaMethodIdsInit.initFileSystemLoadingType_FileSystem_MoveOrCopy();

  UaNodeId FileSystemLoadingType_FileSystem_DeleteFileSystemObject = DIUaMethodIdsInit.initFileSystemLoadingType_FileSystem_DeleteFileSystemObject();

  UaNodeId FileSystemLoadingType_FileSystem_CreateFile = DIUaMethodIdsInit.initFileSystemLoadingType_FileSystem_CreateFile();

  UaNodeId FileSystemLoadingType_GetUpdateBehavior = DIUaMethodIdsInit.initFileSystemLoadingType_GetUpdateBehavior();

  UaNodeId FileSystemLoadingType_ValidateFiles = DIUaMethodIdsInit.initFileSystemLoadingType_ValidateFiles();

  UaNodeId PrepareForUpdateStateMachineType_Abort = DIUaMethodIdsInit.initPrepareForUpdateStateMachineType_Abort();

  UaNodeId PrepareForUpdateStateMachineType_Resume = DIUaMethodIdsInit.initPrepareForUpdateStateMachineType_Resume();

  UaNodeId PrepareForUpdateStateMachineType_Prepare = DIUaMethodIdsInit.initPrepareForUpdateStateMachineType_Prepare();

  UaNodeId InstallationStateMachineType_InstallFiles = DIUaMethodIdsInit.initInstallationStateMachineType_InstallFiles();

  UaNodeId InstallationStateMachineType_Resume = DIUaMethodIdsInit.initInstallationStateMachineType_Resume();

  UaNodeId InstallationStateMachineType_InstallSoftwarePackage = DIUaMethodIdsInit.initInstallationStateMachineType_InstallSoftwarePackage();

  UaNodeId ConfirmationStateMachineType_Confirm = DIUaMethodIdsInit.initConfirmationStateMachineType_Confirm();

  static Set<UaNodeId> allMethodIdentifiers() {
    return InternalDIUaMethodIdsHelper.ALL_METHOD_IDENTIFIERS;
  }
}
