// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.NetworkType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.BaseObjectTypeNode;
import java.lang.Override;

/**
 * Represents the communication means for Devices that are connected to it.
 * <p>
 * Generated on 2024-06-17 14:43:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6247")
public abstract class NetworkTypeNodeBase extends BaseObjectTypeNode implements NetworkType {
  private static GeneratedNodeInitializer<NetworkTypeNode> f_networkTypeNodeInitializer;

  protected NetworkTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getLockNode());
    GeneratedNodeInitializer<NetworkTypeNode> impl = getNetworkTypeNodeInitializer();
    if(impl != null) {
      impl.init((NetworkTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<NetworkTypeNode> getNetworkTypeNodeInitializer() {
    return f_networkTypeNodeInitializer;
  }

  public static void setNetworkTypeNodeInitializer(GeneratedNodeInitializer<NetworkTypeNode> f_networkTypeNodeInitializerNewValue) {
    f_networkTypeNodeInitializer=f_networkTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public LockingServicesTypeNode getLockNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Lock");
    return (LockingServicesTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
