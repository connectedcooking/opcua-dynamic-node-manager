// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.UaNodeId;
import java.util.Set;

/**
 * Generated on 2024-09-09 10:35:45
 */
public interface DIUaVariableTypeIds {
  UaNodeId LifetimeVariableType = DIUaVariableTypeIdsInit.initLifetimeVariableType();

  UaNodeId UIElementType = DIUaVariableTypeIdsInit.initUIElementType();

  static Set<UaNodeId> allVariableTypeIdentifiers() {
    return InternalDIUaVariableTypeIdsHelper.ALL_VARIABLETYPE_IDENTIFIERS;
  }
}
