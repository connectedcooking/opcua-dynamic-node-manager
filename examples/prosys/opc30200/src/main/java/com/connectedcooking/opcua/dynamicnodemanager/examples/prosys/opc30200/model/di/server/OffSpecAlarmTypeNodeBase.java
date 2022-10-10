// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.OffSpecAlarmType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Override;

/**
 * Generated on 2022-10-10 10:21:30
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15590")
public abstract class OffSpecAlarmTypeNodeBase extends DeviceHealthDiagnosticAlarmTypeNode implements OffSpecAlarmType {
  private static GeneratedNodeInitializer<OffSpecAlarmTypeNode> f_offSpecAlarmTypeNodeInitializer;

  protected OffSpecAlarmTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<OffSpecAlarmTypeNode> impl = getOffSpecAlarmTypeNodeInitializer();
    if(impl != null) {
      impl.init((OffSpecAlarmTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<OffSpecAlarmTypeNode> getOffSpecAlarmTypeNodeInitializer() {
    return f_offSpecAlarmTypeNodeInitializer;
  }

  public static void setOffSpecAlarmTypeNodeInitializer(GeneratedNodeInitializer<OffSpecAlarmTypeNode> f_offSpecAlarmTypeNodeInitializerNewValue) {
    f_offSpecAlarmTypeNodeInitializer=f_offSpecAlarmTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}