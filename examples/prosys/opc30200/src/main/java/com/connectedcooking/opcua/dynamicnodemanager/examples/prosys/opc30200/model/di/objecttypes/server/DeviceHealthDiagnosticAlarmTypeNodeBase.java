// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.DeviceHealthDiagnosticAlarmType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.InstrumentDiagnosticAlarmTypeNode;
import java.lang.Override;

/**
 * Generated on 2023-09-26 10:56:50
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15143")
public abstract class DeviceHealthDiagnosticAlarmTypeNodeBase extends InstrumentDiagnosticAlarmTypeNode implements DeviceHealthDiagnosticAlarmType {
  private static GeneratedNodeInitializer<DeviceHealthDiagnosticAlarmTypeNode> f_deviceHealthDiagnosticAlarmTypeNodeInitializer;

  protected DeviceHealthDiagnosticAlarmTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<DeviceHealthDiagnosticAlarmTypeNode> impl = getDeviceHealthDiagnosticAlarmTypeNodeInitializer();
    if(impl != null) {
      impl.init((DeviceHealthDiagnosticAlarmTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<DeviceHealthDiagnosticAlarmTypeNode> getDeviceHealthDiagnosticAlarmTypeNodeInitializer() {
    return f_deviceHealthDiagnosticAlarmTypeNodeInitializer;
  }

  public static void setDeviceHealthDiagnosticAlarmTypeNodeInitializer(GeneratedNodeInitializer<DeviceHealthDiagnosticAlarmTypeNode> f_deviceHealthDiagnosticAlarmTypeNodeInitializerNewValue) {
    f_deviceHealthDiagnosticAlarmTypeNodeInitializer=f_deviceHealthDiagnosticAlarmTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}