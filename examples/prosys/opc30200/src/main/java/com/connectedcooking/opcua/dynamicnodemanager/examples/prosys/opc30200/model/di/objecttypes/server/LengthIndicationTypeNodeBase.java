// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.LengthIndicationType;
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
 * Indicates the abraded length, for example of a drill.
 * <p>
 * Generated on 2024-09-09 10:35:45
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=477")
public abstract class LengthIndicationTypeNodeBase extends BaseLifetimeIndicationTypeNode implements LengthIndicationType {
  private static GeneratedNodeInitializer<LengthIndicationTypeNode> f_lengthIndicationTypeNodeInitializer;

  protected LengthIndicationTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<LengthIndicationTypeNode> impl = getLengthIndicationTypeNodeInitializer();
    if(impl != null) {
      impl.init((LengthIndicationTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<LengthIndicationTypeNode> getLengthIndicationTypeNodeInitializer() {
    return f_lengthIndicationTypeNodeInitializer;
  }

  public static void setLengthIndicationTypeNodeInitializer(GeneratedNodeInitializer<LengthIndicationTypeNode> f_lengthIndicationTypeNodeInitializerNewValue) {
    f_lengthIndicationTypeNodeInitializer=f_lengthIndicationTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
