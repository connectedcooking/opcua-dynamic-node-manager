// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.DishWashingMachineDeviceType;
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
 * Generated on 2024-06-17 14:43:51
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1026")
public abstract class DishWashingMachineDeviceTypeNodeBase extends CommercialKitchenDeviceTypeNode implements DishWashingMachineDeviceType {
  private static GeneratedNodeInitializer<DishWashingMachineDeviceTypeNode> f_dishWashingMachineDeviceTypeNodeInitializer;

  protected DishWashingMachineDeviceTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getParametersNode());
    GeneratedNodeInitializer<DishWashingMachineDeviceTypeNode> impl = getDishWashingMachineDeviceTypeNodeInitializer();
    if(impl != null) {
      impl.init((DishWashingMachineDeviceTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<DishWashingMachineDeviceTypeNode> getDishWashingMachineDeviceTypeNodeInitializer() {
    return f_dishWashingMachineDeviceTypeNodeInitializer;
  }

  public static void setDishWashingMachineDeviceTypeNodeInitializer(GeneratedNodeInitializer<DishWashingMachineDeviceTypeNode> f_dishWashingMachineDeviceTypeNodeInitializerNewValue) {
    f_dishWashingMachineDeviceTypeNodeInitializer=f_dishWashingMachineDeviceTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public DishWashingMachineProgramParameterTypeNode getParametersNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "Parameters");
    return (DishWashingMachineProgramParameterTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
