// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.ConnectionPointType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Override;

/**
 * Represents the interface (interface card) of a Device to a Network.
 * <p>
 * Generated on 2024-06-17 14:43:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6308")
public abstract class ConnectionPointTypeNodeBase extends TopologyElementTypeNode implements ConnectionPointType {
  private static GeneratedNodeInitializer<ConnectionPointTypeNode> f_connectionPointTypeNodeInitializer;

  protected ConnectionPointTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getNetworkAddressNode());
    GeneratedNodeInitializer<ConnectionPointTypeNode> impl = getConnectionPointTypeNodeInitializer();
    if(impl != null) {
      impl.init((ConnectionPointTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<ConnectionPointTypeNode> getConnectionPointTypeNodeInitializer() {
    return f_connectionPointTypeNodeInitializer;
  }

  public static void setConnectionPointTypeNodeInitializer(GeneratedNodeInitializer<ConnectionPointTypeNode> f_connectionPointTypeNodeInitializerNewValue) {
    f_connectionPointTypeNodeInitializer=f_connectionPointTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public FunctionalGroupTypeNode getNetworkAddressNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "NetworkAddress");
    return (FunctionalGroupTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
