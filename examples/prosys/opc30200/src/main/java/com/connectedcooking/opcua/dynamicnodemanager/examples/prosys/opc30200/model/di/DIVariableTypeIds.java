// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import java.util.Set;

/**
 * Generated on 2024-09-09 10:35:45
 */
public interface DIVariableTypeIds {
  ExpandedNodeId LifetimeVariableType = DIUaIds.LifetimeVariableType.asExpandedNodeId();

  ExpandedNodeId UIElementType = DIUaIds.UIElementType.asExpandedNodeId();

  static Set<ExpandedNodeId> allVariableTypeIdentifiers() {
    return InternalDIVariableTypeIdsHelper.ALL_VARIABLETYPE_IDENTIFIERS;
  }
}
