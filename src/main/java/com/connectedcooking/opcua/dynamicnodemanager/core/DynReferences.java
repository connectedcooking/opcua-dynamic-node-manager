package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Collection;
import java.util.Optional;

/**
 * Accessor for dynamic references.
 */
public interface DynReferences {

    /**
     * Types of the reference.
     */
    enum Types {
        References,
        NonHierarchicalReferences,
        HierarchicalReferences,
        HasChild,
        Organizes,
        HasEventSource,
        HasModellingRule,
        HasEncoding,
        HasDescription,
        HasTypeDefinition,
        GeneratesEvent,
        Aggregates,
        HasSubtype,
        HasProperty,
        HasComponent,
        HasNotifier,
        HasOrderedComponent,
        FromState,
        ToState,
        HasCause,
        HasEffect,
        HasHistoricalConfiguration,
        HasSubStateMachine,
        HasArgumentDescription,
        HasOptionalInputArgumentDescription,
        AlwaysGeneratesEvent,
        HasTrueSubState,
        HasFalseSubState,
        HasCondition,
        HasPubSubConnection,
        DataSetToWriter,
        HasGuard,
        HasDataSetWriter,
        HasDataSetReader,
        HasAlarmSuppressionGroup,
        AlarmGroupMember,
        HasEffectDisable,
        HasDictionaryEntry,
        HasInterface,
        HasAddIn,
        HasEffectEnable,
        HasEffectSuppressed,
        HasEffectUnsuppressed,
        HasWriterGroup,
        HasReaderGroup,
        AliasFor
    }

    /**
     * Retrieves all resolved references.
     *
     * @param req the request
     * @return a collection of resolved references
     */
    Collection<DynReference> all(DynRequest req);

    /**
     * Retrieves all resolved references by type.
     *
     * @param type the requested reference type
     * @param req  the request
     * @return a collection of resolved references
     */
    Collection<DynReference> byType(Types type, DynRequest req);

    /**
     * Retrieves a single (first) resolved reference by type.
     *
     * @param type the requested reference type
     * @param req  the request
     * @return the resolved reference optionally
     */
    Optional<DynReference> byTypeSingle(Types type, DynRequest req);

    /**
     * Adds a new dynamic reference resolving function.
     *
     * @param type the reference type
     * @param fn   the resolving function
     */
    void add(Types type, DynRequest.Full<RealNodeId> fn);

    /**
     * Adds a new dynamic multiple reference resolving function.
     *
     * @param type the reference type
     * @param fn   the resolving function
     */
    void addAll(Types type, DynRequest.Full<Collection<RealNodeId>> fn);

    /**
     * Replaces a dynamic reference resolving function of the particular type.
     *
     * @param type the reference type
     * @param fn   the resolving function
     */
    void replace(Types type, DynRequest.Full<RealNodeId> fn);
}
