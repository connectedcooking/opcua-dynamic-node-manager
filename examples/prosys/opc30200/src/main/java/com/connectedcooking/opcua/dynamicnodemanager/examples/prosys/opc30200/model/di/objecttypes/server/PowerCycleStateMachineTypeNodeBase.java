// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.PowerCycleStateMachineType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.FiniteStateMachineTypeNode;
import java.lang.Override;

/**
 * Generated on 2024-09-09 10:35:45
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=285")
public abstract class PowerCycleStateMachineTypeNodeBase extends FiniteStateMachineTypeNode implements PowerCycleStateMachineType {
  private static GeneratedNodeInitializer<PowerCycleStateMachineTypeNode> f_powerCycleStateMachineTypeNodeInitializer;

  protected PowerCycleStateMachineTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<PowerCycleStateMachineTypeNode> impl = getPowerCycleStateMachineTypeNodeInitializer();
    if(impl != null) {
      impl.init((PowerCycleStateMachineTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<PowerCycleStateMachineTypeNode> getPowerCycleStateMachineTypeNodeInitializer() {
    return f_powerCycleStateMachineTypeNodeInitializer;
  }

  public static void setPowerCycleStateMachineTypeNodeInitializer(GeneratedNodeInitializer<PowerCycleStateMachineTypeNode> f_powerCycleStateMachineTypeNodeInitializerNewValue) {
    f_powerCycleStateMachineTypeNodeInitializer=f_powerCycleStateMachineTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
