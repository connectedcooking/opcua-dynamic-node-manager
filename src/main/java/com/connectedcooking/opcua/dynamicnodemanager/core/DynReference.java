package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;

/**
 * Dynamic reference definition.
 */
public class DynReference {

    /**
     * Convenient subclass for the reference type HasComponent.
     */
    static class HasComponentRef extends DynReference {

        /**
         * {@inheritDoc}
         */
        public HasComponentRef(RealNodeId sourceId, RealNodeId targetId) {
            super(DynReferences.Types.HasComponent, sourceId, targetId);
        }
    }

    private final DynReferences.Types type;
    private final RealNodeId sourceId;
    private final RealNodeId targetId;

    /**
     * Creates a new dynamic reference.
     *
     * @param type     the reference type
     * @param sourceId the source node ID
     * @param targetId the target node ID
     */
    public DynReference(DynReferences.Types type, RealNodeId sourceId, RealNodeId targetId) {
        this.type = type;
        this.sourceId = sourceId;
        this.targetId = targetId;
    }

    /**
     * Gets the reference type.
     *
     * @return the reference type
     */
    public DynReferences.Types type() {
        return type;
    }

    /**
     * Gets the source node ID.
     *
     * @return the source node ID
     */
    public RealNodeId sourceId() {
        return sourceId;
    }

    /**
     * Gets the target node ID.
     *
     * @return the target node ID
     */
    public RealNodeId targetId() {
        return targetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynReference that = (DynReference) o;
        return type == that.type && sourceId.equals(that.sourceId) && targetId.equals(that.targetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sourceId, targetId);
    }

    @Override
    public String toString() {
        return "DynReference{" + type + ", sourceId=" + sourceId + ", targetId=" + targetId + '}';
    }
}
