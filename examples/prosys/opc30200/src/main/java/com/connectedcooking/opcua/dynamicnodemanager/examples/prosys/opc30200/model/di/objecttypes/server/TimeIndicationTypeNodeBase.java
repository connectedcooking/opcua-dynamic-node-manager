// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.TimeIndicationType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Override;

/**
 * Indicates the time the entity has been in use or can still be used
 * <p>
 * Generated on 2023-09-26 10:56:50
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=474")
public abstract class TimeIndicationTypeNodeBase extends BaseLifetimeIndicationTypeNode implements TimeIndicationType {
  private static GeneratedNodeInitializer<TimeIndicationTypeNode> f_timeIndicationTypeNodeInitializer;

  protected TimeIndicationTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<TimeIndicationTypeNode> impl = getTimeIndicationTypeNodeInitializer();
    if(impl != null) {
      impl.init((TimeIndicationTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<TimeIndicationTypeNode> getTimeIndicationTypeNodeInitializer() {
    return f_timeIndicationTypeNodeInitializer;
  }

  public static void setTimeIndicationTypeNodeInitializer(GeneratedNodeInitializer<TimeIndicationTypeNode> f_timeIndicationTypeNodeInitializerNewValue) {
    f_timeIndicationTypeNodeInitializer=f_timeIndicationTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}