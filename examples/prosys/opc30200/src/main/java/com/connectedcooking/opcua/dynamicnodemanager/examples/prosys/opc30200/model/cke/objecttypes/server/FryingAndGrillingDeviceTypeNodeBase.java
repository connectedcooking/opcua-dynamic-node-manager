// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes.EnergySourceEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.FryingAndGrillingDeviceType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Generated on 2023-09-26 10:56:54
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1032")
public abstract class FryingAndGrillingDeviceTypeNodeBase extends CommercialKitchenDeviceTypeNode implements FryingAndGrillingDeviceType {
  private static GeneratedNodeInitializer<FryingAndGrillingDeviceTypeNode> f_fryingAndGrillingDeviceTypeNodeInitializer;

  protected FryingAndGrillingDeviceTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<FryingAndGrillingDeviceTypeNode> impl = getFryingAndGrillingDeviceTypeNodeInitializer();
    if(impl != null) {
      impl.init((FryingAndGrillingDeviceTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<FryingAndGrillingDeviceTypeNode> getFryingAndGrillingDeviceTypeNodeInitializer() {
    return f_fryingAndGrillingDeviceTypeNodeInitializer;
  }

  public static void setFryingAndGrillingDeviceTypeNodeInitializer(GeneratedNodeInitializer<FryingAndGrillingDeviceTypeNode> f_fryingAndGrillingDeviceTypeNodeInitializerNewValue) {
    f_fryingAndGrillingDeviceTypeNodeInitializer=f_fryingAndGrillingDeviceTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public UaProperty getEnergySourceNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/CommercialKitchenEquipment/", "EnergySource");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public EnergySourceEnumeration getEnergySource() {
    UaVariable node = getEnergySourceNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node EnergySource does not exist");
    }
    Variant value = node.getValue().getValue();
    return (EnergySourceEnumeration) value.asEnum(EnergySourceEnumeration.class);
  }

  @Mandatory
  @Override
  public void setEnergySource(EnergySourceEnumeration value) {
    UaVariable node = getEnergySourceNode();
    if (node == null) {
      throw new RuntimeException("Setting EnergySource failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting EnergySource failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}