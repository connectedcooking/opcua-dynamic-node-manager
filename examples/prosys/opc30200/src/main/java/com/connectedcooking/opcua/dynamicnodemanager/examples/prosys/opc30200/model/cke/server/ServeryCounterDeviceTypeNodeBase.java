// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.ServeryCounterDeviceType;
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
 * Generated on 2022-10-10 10:21:34
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1028")
public abstract class ServeryCounterDeviceTypeNodeBase extends CommercialKitchenDeviceTypeNode implements ServeryCounterDeviceType {
  private static GeneratedNodeInitializer<ServeryCounterDeviceTypeNode> f_serveryCounterDeviceTypeNodeInitializer;

  protected ServeryCounterDeviceTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<ServeryCounterDeviceTypeNode> impl = getServeryCounterDeviceTypeNodeInitializer();
    if(impl != null) {
      impl.init((ServeryCounterDeviceTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<ServeryCounterDeviceTypeNode> getServeryCounterDeviceTypeNodeInitializer() {
    return f_serveryCounterDeviceTypeNodeInitializer;
  }

  public static void setServeryCounterDeviceTypeNodeInitializer(GeneratedNodeInitializer<ServeryCounterDeviceTypeNode> f_serveryCounterDeviceTypeNodeInitializerNewValue) {
    f_serveryCounterDeviceTypeNodeInitializer=f_serveryCounterDeviceTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}