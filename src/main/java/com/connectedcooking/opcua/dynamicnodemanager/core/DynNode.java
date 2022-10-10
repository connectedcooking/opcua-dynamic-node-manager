package com.connectedcooking.opcua.dynamicnodemanager.core;

/**
 * Dynamic node.
 */
public interface DynNode {

    /**
     * Returns the dynamic node ID of this dynamic node.
     *
     * @return the dynamic node ID
     */
    DynNodeId nodeId();

    /**
     * Computes a real node ID of this dynamic node.
     *
     * @param replacements the replacements in the dynamic node ID
     * @return the real node ID
     */
    RealNodeId realNodeId(Object... replacements);

    /**
     * Computes a real node ID of this dynamic node.
     *
     * @param namespaceIndex the namespace index of the real node
     * @param replacements   the replacements in the dynamic node ID
     * @return the real node ID
     */
    RealNodeId realNodeId(int namespaceIndex, Object... replacements);

    /**
     * Returns a node ID of a parent dynamic node if there is any.
     *
     * @return the dynamic node ID of a parent or null
     */
    DynNodeId parentId();

    /**
     * Returns dynamic attributes of this node.
     *
     * @return the dynamic attributes
     */
    DynAttributes attributes();

    /**
     * Returns dynamic references of this node.
     *
     * @return the dynamic references
     */
    DynReferences references();

    /**
     * Return a nullable value of this variable node.
     *
     * @param request the dynamic request
     * @return the dynamic response with a nullable variable value
     */
    default DynResponse<Object> value(DynRequest request) {
        return attributes().value(request);
    }
}
