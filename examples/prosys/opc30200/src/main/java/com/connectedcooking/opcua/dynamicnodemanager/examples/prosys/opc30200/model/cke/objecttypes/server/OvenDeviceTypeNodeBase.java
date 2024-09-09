// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.OvenDeviceType;
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
 * Generated on 2024-09-09 10:35:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1013")
public abstract class OvenDeviceTypeNodeBase extends CommercialKitchenDeviceTypeNode implements OvenDeviceType {
  private static GeneratedNodeInitializer<OvenDeviceTypeNode> f_ovenDeviceTypeNodeInitializer;

  protected OvenDeviceTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<OvenDeviceTypeNode> impl = getOvenDeviceTypeNodeInitializer();
    if(impl != null) {
      impl.init((OvenDeviceTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<OvenDeviceTypeNode> getOvenDeviceTypeNodeInitializer() {
    return f_ovenDeviceTypeNodeInitializer;
  }

  public static void setOvenDeviceTypeNodeInitializer(GeneratedNodeInitializer<OvenDeviceTypeNode> f_ovenDeviceTypeNodeInitializerNewValue) {
    f_ovenDeviceTypeNodeInitializer=f_ovenDeviceTypeNodeInitializerNewValue;
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
