// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.DIUaIds;
import com.prosysopc.ua.server.ServerCodegenModel;

/**
 * Generated on 2025-04-16 18:27:23
 */
public class DIServerObjectTypesInformationModel {
  public static final ServerCodegenModel MODEL;

  static {
    ServerCodegenModel.Builder b = ServerCodegenModel.builder();
    //TopologyElementType, nsu=http://opcfoundation.org/UA/DI/;i=1001
    b.addClass(DIUaIds.TopologyElementType, t -> new TopologyElementTypeNode(t));
    //IVendorNameplateType, nsu=http://opcfoundation.org/UA/DI/;i=15035
    b.addClass(DIUaIds.IVendorNameplateType, t -> new IVendorNameplateTypeNode(t));
    //ITagNameplateType, nsu=http://opcfoundation.org/UA/DI/;i=15048
    b.addClass(DIUaIds.ITagNameplateType, t -> new ITagNameplateTypeNode(t));
    //IDeviceHealthType, nsu=http://opcfoundation.org/UA/DI/;i=15051
    b.addClass(DIUaIds.IDeviceHealthType, t -> new IDeviceHealthTypeNode(t));
    //ISupportInfoType, nsu=http://opcfoundation.org/UA/DI/;i=15054
    b.addClass(DIUaIds.ISupportInfoType, t -> new ISupportInfoTypeNode(t));
    //ComponentType, nsu=http://opcfoundation.org/UA/DI/;i=15063
    b.addClass(DIUaIds.ComponentType, t -> new ComponentTypeNode(t));
    //DeviceType, nsu=http://opcfoundation.org/UA/DI/;i=1002
    b.addClass(DIUaIds.DeviceType, t -> new DeviceTypeNode(t));
    //SoftwareType, nsu=http://opcfoundation.org/UA/DI/;i=15106
    b.addClass(DIUaIds.SoftwareType, t -> new SoftwareTypeNode(t));
    //BlockType, nsu=http://opcfoundation.org/UA/DI/;i=1003
    b.addClass(DIUaIds.BlockType, t -> new BlockTypeNode(t));
    //DeviceHealthDiagnosticAlarmType, nsu=http://opcfoundation.org/UA/DI/;i=15143
    b.addClass(DIUaIds.DeviceHealthDiagnosticAlarmType, t -> new DeviceHealthDiagnosticAlarmTypeNode(t));
    //FailureAlarmType, nsu=http://opcfoundation.org/UA/DI/;i=15292
    b.addClass(DIUaIds.FailureAlarmType, t -> new FailureAlarmTypeNode(t));
    //CheckFunctionAlarmType, nsu=http://opcfoundation.org/UA/DI/;i=15441
    b.addClass(DIUaIds.CheckFunctionAlarmType, t -> new CheckFunctionAlarmTypeNode(t));
    //OffSpecAlarmType, nsu=http://opcfoundation.org/UA/DI/;i=15590
    b.addClass(DIUaIds.OffSpecAlarmType, t -> new OffSpecAlarmTypeNode(t));
    //MaintenanceRequiredAlarmType, nsu=http://opcfoundation.org/UA/DI/;i=15739
    b.addClass(DIUaIds.MaintenanceRequiredAlarmType, t -> new MaintenanceRequiredAlarmTypeNode(t));
    //ConfigurableObjectType, nsu=http://opcfoundation.org/UA/DI/;i=1004
    b.addClass(DIUaIds.ConfigurableObjectType, t -> new ConfigurableObjectTypeNode(t));
    //BaseLifetimeIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=473
    b.addClass(DIUaIds.BaseLifetimeIndicationType, t -> new BaseLifetimeIndicationTypeNode(t));
    //TimeIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=474
    b.addClass(DIUaIds.TimeIndicationType, t -> new TimeIndicationTypeNode(t));
    //NumberOfPartsIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=475
    b.addClass(DIUaIds.NumberOfPartsIndicationType, t -> new NumberOfPartsIndicationTypeNode(t));
    //NumberOfUsagesIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=476
    b.addClass(DIUaIds.NumberOfUsagesIndicationType, t -> new NumberOfUsagesIndicationTypeNode(t));
    //LengthIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=477
    b.addClass(DIUaIds.LengthIndicationType, t -> new LengthIndicationTypeNode(t));
    //DiameterIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=478
    b.addClass(DIUaIds.DiameterIndicationType, t -> new DiameterIndicationTypeNode(t));
    //SubstanceVolumeIndicationType, nsu=http://opcfoundation.org/UA/DI/;i=479
    b.addClass(DIUaIds.SubstanceVolumeIndicationType, t -> new SubstanceVolumeIndicationTypeNode(t));
    //FunctionalGroupType, nsu=http://opcfoundation.org/UA/DI/;i=1005
    b.addClass(DIUaIds.FunctionalGroupType, t -> new FunctionalGroupTypeNode(t));
    //ProtocolType, nsu=http://opcfoundation.org/UA/DI/;i=1006
    b.addClass(DIUaIds.ProtocolType, t -> new ProtocolTypeNode(t));
    //IOperationCounterType, nsu=http://opcfoundation.org/UA/DI/;i=480
    b.addClass(DIUaIds.IOperationCounterType, t -> new IOperationCounterTypeNode(t));
    //NetworkType, nsu=http://opcfoundation.org/UA/DI/;i=6247
    b.addClass(DIUaIds.NetworkType, t -> new NetworkTypeNode(t));
    //ConnectionPointType, nsu=http://opcfoundation.org/UA/DI/;i=6308
    b.addClass(DIUaIds.ConnectionPointType, t -> new ConnectionPointTypeNode(t));
    //TransferServicesType, nsu=http://opcfoundation.org/UA/DI/;i=6526
    b.addClass(DIUaIds.TransferServicesType, t -> new TransferServicesTypeNode(t));
    //LockingServicesType, nsu=http://opcfoundation.org/UA/DI/;i=6388
    b.addClass(DIUaIds.LockingServicesType, t -> new LockingServicesTypeNode(t));
    //SoftwareUpdateType, nsu=http://opcfoundation.org/UA/DI/;i=1
    b.addClass(DIUaIds.SoftwareUpdateType, t -> new SoftwareUpdateTypeNode(t));
    //SoftwareLoadingType, nsu=http://opcfoundation.org/UA/DI/;i=135
    b.addClass(DIUaIds.SoftwareLoadingType, t -> new SoftwareLoadingTypeNode(t));
    //PackageLoadingType, nsu=http://opcfoundation.org/UA/DI/;i=137
    b.addClass(DIUaIds.PackageLoadingType, t -> new PackageLoadingTypeNode(t));
    //DirectLoadingType, nsu=http://opcfoundation.org/UA/DI/;i=153
    b.addClass(DIUaIds.DirectLoadingType, t -> new DirectLoadingTypeNode(t));
    //CachedLoadingType, nsu=http://opcfoundation.org/UA/DI/;i=171
    b.addClass(DIUaIds.CachedLoadingType, t -> new CachedLoadingTypeNode(t));
    //FileSystemLoadingType, nsu=http://opcfoundation.org/UA/DI/;i=192
    b.addClass(DIUaIds.FileSystemLoadingType, t -> new FileSystemLoadingTypeNode(t));
    //SoftwareVersionType, nsu=http://opcfoundation.org/UA/DI/;i=212
    b.addClass(DIUaIds.SoftwareVersionType, t -> new SoftwareVersionTypeNode(t));
    //PrepareForUpdateStateMachineType, nsu=http://opcfoundation.org/UA/DI/;i=213
    b.addClass(DIUaIds.PrepareForUpdateStateMachineType, t -> new PrepareForUpdateStateMachineTypeNode(t));
    //InstallationStateMachineType, nsu=http://opcfoundation.org/UA/DI/;i=249
    b.addClass(DIUaIds.InstallationStateMachineType, t -> new InstallationStateMachineTypeNode(t));
    //PowerCycleStateMachineType, nsu=http://opcfoundation.org/UA/DI/;i=285
    b.addClass(DIUaIds.PowerCycleStateMachineType, t -> new PowerCycleStateMachineTypeNode(t));
    //ConfirmationStateMachineType, nsu=http://opcfoundation.org/UA/DI/;i=307
    b.addClass(DIUaIds.ConfirmationStateMachineType, t -> new ConfirmationStateMachineTypeNode(t));
    MODEL = b.build();
  }
}
