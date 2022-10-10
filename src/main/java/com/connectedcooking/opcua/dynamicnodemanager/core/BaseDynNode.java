package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;

/**
 * Base dynamic node implementation.
 */
public class BaseDynNode implements DynNode {

    protected final DynNodeId nodeId;
    protected final DynNodeId parentId;

    protected final DynAttributeManager attributes;
    protected final DynReferenceManager references;

    /**
     * Creates a base dynamic node.
     *
     * @param nodeId     the node ID
     * @param parentId   the nullable parent ID
     * @param attributes the dynamic attributes manager
     * @param references the dynamic references manager
     */
    public BaseDynNode(DynNodeId nodeId, DynNodeId parentId, DynAttributeManager attributes, DynReferenceManager references) {
        this.nodeId = nodeId;
        this.parentId = parentId;
        this.attributes = attributes.with(this);
        this.references = references.with(this);
    }

    @Override
    public DynNodeId nodeId() {
        if (nodeId instanceof PartialNodeId && parentId != null) {
            return parentId.compose((PartialNodeId) nodeId);
        }
        return nodeId;
    }

    @Override
    public RealNodeId realNodeId(Object... replacements) {
        return nodeId().toReal(replacements);
    }

    @Override
    public RealNodeId realNodeId(int namespaceIndex, Object... replacements) {
        return nodeId().toReal(namespaceIndex, replacements);
    }

    @Override
    public DynNodeId parentId() {
        return parentId;
    }

    @Override
    public DynAttributes attributes() {
        return attributes;
    }

    @Override
    public DynReferences references() {
        return references;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDynNode that = (BaseDynNode) o;
        return nodeId.equals(that.nodeId) && Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId, parentId);
    }

    @Override
    public String toString() {
        return "BaseDynNode{" + nodeId + '}';
    }
}
