// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.UaNodeId;

/**
 * Generated on 2025-04-16 18:27:23
 */
class DIUaReferenceTypeIdsInit {
  static UaNodeId initConnectsTo() {
    return UaNodeId.numeric(DIUaIdsInitHelper.NAMESPACE, 6030L);
  }

  static UaNodeId initConnectsToParent() {
    return UaNodeId.numeric(DIUaIdsInitHelper.NAMESPACE, 6467L);
  }

  static UaNodeId initIsOnline() {
    return UaNodeId.numeric(DIUaIdsInitHelper.NAMESPACE, 6031L);
  }
}
