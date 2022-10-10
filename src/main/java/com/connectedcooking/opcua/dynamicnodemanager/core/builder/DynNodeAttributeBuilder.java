package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;

/**
 * Attribute building methods for a dynamic node builder.
 */
public interface DynNodeAttributeBuilder {

    /**
     * Sets the browse and display name.
     *
     * @param name the browse and display name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder name(DynRequest.Full<String> name);

    /**
     * Sets the browse and display name.
     *
     * @param name the browse and display name constant value
     * @return this builder
     */
    DynNodeBaseBuilder name(String name);

    /**
     * Sets the browse name.
     *
     * @param browseName the browse name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder browseName(DynRequest.Full<String> browseName);

    /**
     * Sets the browse name.
     *
     * @param browseName the browse name constant value
     * @return this builder
     */
    DynNodeBaseBuilder browseName(String browseName);

    /**
     * Sets the browse name by the resolved value.
     *
     * @param browseName the browse name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder browseNameBy(DynRequest.Resolved<String> browseName);

    /**
     * Sets the browse name by the resolved values.
     *
     * @param browseName the browse name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder browseNameBy(DynRequest.ResolvedTwo<String> browseName);

    /**
     * Sets the browse name by the resolved ID.
     *
     * @param browseName the browse name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder browseNameById(DynRequest.Id<String> browseName);

    /**
     * Sets the browse name by the resolved IDs.
     *
     * @param browseName the browse name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder browseNameById(DynRequest.Ids<String> browseName);

    /**
     * Sets the display name.
     *
     * @param displayName the display name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder displayName(DynRequest.Full<String> displayName);

    /**
     * Sets the display name.
     *
     * @param displayName the display name constant value
     * @return this builder
     */
    DynNodeBaseBuilder displayName(String displayName);

    /**
     * Sets the display name by the resolved value.
     *
     * @param displayName the display name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder displayNameBy(DynRequest.Resolved<String> displayName);

    /**
     * Sets the display name by the resolved values.
     *
     * @param displayName the display name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder displayNameBy(DynRequest.ResolvedTwo<String> displayName);

    /**
     * Sets the display name by the resolved ID.
     *
     * @param displayName the display name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder displayNameById(DynRequest.Id<String> displayName);

    /**
     * Sets the display name by the resolved IDs.
     *
     * @param displayName the display name dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder displayNameById(DynRequest.Ids<String> displayName);

    /**
     * Sets the description.
     *
     * @param description the description dynamic request
     * @return this builder
     */
    DynNodeBaseBuilder description(DynRequest.Full<String> description);

    /**
     * Sets the description.
     *
     * @param description the description constant value
     * @return this builder
     */
    DynNodeBaseBuilder description(String description);
}