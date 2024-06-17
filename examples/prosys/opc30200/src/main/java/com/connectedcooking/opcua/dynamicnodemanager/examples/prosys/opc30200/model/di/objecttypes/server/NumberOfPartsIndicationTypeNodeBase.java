// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.NumberOfPartsIndicationType;
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
 * Indicates the total number of parts that have been produced or can still be produced.
 * <p>
 * Generated on 2024-06-17 14:43:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=475")
public abstract class NumberOfPartsIndicationTypeNodeBase extends BaseLifetimeIndicationTypeNode implements NumberOfPartsIndicationType {
  private static GeneratedNodeInitializer<NumberOfPartsIndicationTypeNode> f_numberOfPartsIndicationTypeNodeInitializer;

  protected NumberOfPartsIndicationTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<NumberOfPartsIndicationTypeNode> impl = getNumberOfPartsIndicationTypeNodeInitializer();
    if(impl != null) {
      impl.init((NumberOfPartsIndicationTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<NumberOfPartsIndicationTypeNode> getNumberOfPartsIndicationTypeNodeInitializer() {
    return f_numberOfPartsIndicationTypeNodeInitializer;
  }

  public static void setNumberOfPartsIndicationTypeNodeInitializer(GeneratedNodeInitializer<NumberOfPartsIndicationTypeNode> f_numberOfPartsIndicationTypeNodeInitializerNewValue) {
    f_numberOfPartsIndicationTypeNodeInitializer=f_numberOfPartsIndicationTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
