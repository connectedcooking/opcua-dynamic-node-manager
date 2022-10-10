package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.regex.Pattern;

/**
 * Representation of a partial dynamic node ID.
 * A partial node ID needs to be resolved by add a parent node ID as a suffix.
 * Example: a partial node ID "Error" with a parent node with node ID "Device123" will be resolved as "Device123/Error".
 */
public class PartialNodeId extends DynNodeId {

    /**
     * See {@link DynNodeId#DynNodeId(String)}
     */
    public PartialNodeId(String identifier) {
        super(identifier);
    }

    /**
     * See {@link DynNodeId#DynNodeId(Pattern)}
     */
    public PartialNodeId(Pattern identifier) {
        super(identifier);
    }

    /**
     * {@inheritDoc}
     *
     * @return always true
     */
    @Override
    public boolean isPartial() {
        return true;
    }
}
