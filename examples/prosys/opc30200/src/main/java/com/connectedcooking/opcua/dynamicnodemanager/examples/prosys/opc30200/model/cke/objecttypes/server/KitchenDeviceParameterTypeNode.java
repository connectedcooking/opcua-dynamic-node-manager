// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server;

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.UaNode;
import java.lang.Override;

/**
 * Generated on 2024-09-09 10:35:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=1004")
public class KitchenDeviceParameterTypeNode extends KitchenDeviceParameterTypeNodeBase {
  protected KitchenDeviceParameterTypeNode(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    // Use this method to initialize the nodes, when they are all created.
    // Note that 'super.afterCreate()' performs default initializations, so consider
    // whether your own initializations should be done before or after it.
    super.afterCreate();
  }
}
