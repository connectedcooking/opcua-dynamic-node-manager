package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;

/**
 * Representation of a real node ID.
 * A real node is a concrete or static node either not managed by a dynamic node manager or already resolved.
 * <p>
 * Example: a dynamic node ID "Device*\/Errors/Err*" can be resolved as a real node ID "Device123/Errors/Err456".
 */
public class RealNodeId {

    private final Integer namespaceIndex;
    private final Object identifier;

    /**
     * Creates a new real node ID.
     *
     * @param namespaceIndex the namespace index
     * @param identifier     the identifier
     */
    public RealNodeId(int namespaceIndex, Object identifier) {
        this.identifier = identifier;
        this.namespaceIndex = namespaceIndex > -1 ? namespaceIndex : null;
    }

    /**
     * Creates a new real node ID.
     *
     * @param identifier the identifier
     */
    public RealNodeId(Object identifier) {
        this.identifier = identifier;
        this.namespaceIndex = null;
    }

    /**
     * Creates a new real node ID from partial paths.
     *
     * @param parent the parent path
     * @param child  the child path
     */
    public RealNodeId(String parent, String child) {
        this(parent + "/" + child);
    }

    /**
     * Creates a new real node ID from partial real node IDs.
     *
     * @param parent the parent real node ID
     * @param child  the child real node ID
     */
    public RealNodeId(RealNodeId parent, RealNodeId child) {
        this(parent.namespaceIndex != null ? parent.namespaceIndex : -1, parent.identifier + "/" + child.identifier);
    }

    /**
     * Creates a new real node ID from a partial real node ID and a path.
     *
     * @param parent the parent real node ID
     * @param child  the child path
     */
    public RealNodeId(RealNodeId parent, String child) {
        this(parent.namespaceIndex, parent.identifier + "/" + child);
    }

    /**
     * Creates a new real node ID from partial paths.
     *
     * @param namespaceIndex the namespace index
     * @param parent         the parent path
     * @param child          the child path
     */
    public RealNodeId(int namespaceIndex, String parent, String child) {
        this(namespaceIndex, parent + "/" + child);
    }

    /**
     * Getter for the namespace index.
     *
     * @return the namespace index
     */
    public int namespaceIndex() {
        return namespaceIndex != null ? namespaceIndex : -1;
    }

    /**
     * Getter for the identifier.
     *
     * @return the identifier
     */
    public Object identifier() {
        return identifier;
    }

    /**
     * Indicates whether the node ID represents a local node.
     * A local node is a node without a namespace, typically managed by a dynamic node manager.
     *
     * @return true if local, false otherwise
     */
    public boolean isLocal() {
        return namespaceIndex == null;
    }

    /**
     * Creates a new real node ID by assigning this to a namespace.
     *
     * @param namespaceIndex the namespace index
     * @return the namespaced real node ID.
     */
    public RealNodeId withNamespace(int namespaceIndex) {
        return new RealNodeId(namespaceIndex, identifier);
    }

    /**
     * Creates a new real node ID by assigning this to a parent.
     *
     * @param parent the parent
     * @return the real node ID with the parent.
     */
    public RealNodeId withParent(String parent) {
        return new RealNodeId(parent + "/" + identifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealNodeId that = (RealNodeId) o;
        if (!Objects.equals(namespaceIndex, that.namespaceIndex)) return false;
        if (identifier instanceof Comparable && that.identifier instanceof Comparable) {
            return ((Comparable) identifier).compareTo(that.identifier) == 0;
        }
        return identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespaceIndex, identifier);
    }

    @Override
    public String toString() {
        return "RealNodeId{" + namespaceIndex + "," + identifier + '}';
    }
}
