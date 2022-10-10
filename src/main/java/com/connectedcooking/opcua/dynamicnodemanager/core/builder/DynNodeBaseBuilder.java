package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynNode;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;

/**
 * Base methods for a dynamic node builder.
 */
public interface DynNodeBaseBuilder extends DynNodeAttributeBuilder, DynNodeReferenceBuilder, DynNodeSupplementaryBuilder {

    /**
     * Registers a new dynamic node in the dynamic node manager.
     */
    void register();

    /**
     * Registers a new dynamic node in the dynamic node manager and returns it.
     *
     * @return the dynamic node
     */
    DynNode registerAndGet();

    /**
     * Indicates whether the request has sufficient permission to browse the dynamic node.
     *
     * @param canBrowse the dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder canBrowse(DynRequest.Full<Boolean> canBrowse);

    /**
     * See {@link #canBrowse(DynRequest.Full)}
     */
    DynNodeBaseBuilder canBrowseBy(DynRequest.Resolved<Boolean> canBrowse);

    /**
     * See {@link #canBrowse(DynRequest.Full)}
     */
    DynNodeBaseBuilder canBrowseById(DynRequest.Id<Boolean> canBrowse);
}