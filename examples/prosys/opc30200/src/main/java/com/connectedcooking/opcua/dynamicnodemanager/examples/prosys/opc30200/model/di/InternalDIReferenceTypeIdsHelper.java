// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Generated on 2025-04-16 18:27:23
 */
class InternalDIReferenceTypeIdsHelper {
  public static final Set<ExpandedNodeId> ALL_REFERENCETYPE_IDENTIFIERS;

  static {
    Set<ExpandedNodeId> allIds = new HashSet<ExpandedNodeId>();
    allIds.add(DIReferenceTypeIds.ConnectsTo);
    allIds.add(DIReferenceTypeIds.ConnectsToParent);
    allIds.add(DIReferenceTypeIds.IsOnline);
    ALL_REFERENCETYPE_IDENTIFIERS = Collections.unmodifiableSet(allIds);
  }
}
