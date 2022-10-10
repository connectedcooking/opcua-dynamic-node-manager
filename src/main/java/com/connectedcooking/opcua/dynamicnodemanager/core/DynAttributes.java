package com.connectedcooking.opcua.dynamicnodemanager.core;

import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;

/**
 * Accessor for dynamic attributes.
 */
public interface DynAttributes {

    /**
     * Access levels.
     */
    enum AccessLevels {
        CurrentRead, CurrentWrite, HistoryRead, HistoryWrite, SemanticChange, StatusWrite, TimestampWrite
    }

    /**
     * Node classes.
     */
    enum NodeClasses {
        Unspecified, Object, Variable, Method, ObjectType, VariableType, ReferenceType, DataType, View
    }

    /**
     * AccessRestriction types
     */
    enum AccessRestrictions {
        SigningRequired, EncryptionRequired, SessionRequired
    }

    /**
     * AccessLevelEx types to indicate how the Value of a Variable can be accessed (read/write),
     * if it contains current and/or historic data and its atomicity.
     */
    enum AccessLevelExs {
        NonatomicRead, NonatomicWrite, WriteFullArrayOnly
    }

    /**
     * EventNotifier types
     */
    enum EventNotifiers {
        SubscribeToEvents, HistoryRead, HistoryWrite;
    }

    /**
     * ValueRank types
     */
    enum ValueRanks {
        Any, Scalar, ScalarOrOneDimension, OneDimension, OneOrMoreDimensions
    }

    /**
     * The canonical namespace-less identifier for the node.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<RealNodeId> nodeId(DynRequest req);

    /**
     * The class of the node.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynAttributes.NodeClasses> nodeClass(DynRequest req);

    /**
     * A non-localized, human-readable name for the node.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynQualifiedName> browseName(DynRequest req);

    /**
     * A localized, human-readable name for the node.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynLocalizedText> displayName(DynRequest req);

    /**
     * A localized description for the node.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynLocalizedText> description(DynRequest req);

    /**
     * Indicates which attributes are writable.
     * https://reference.opcfoundation.org/v104/Core/DataTypes/AttributeWriteMask/
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Integer> writeMask(DynRequest req);

    /**
     * Indicates which attributes are writable by the current user.
     * https://reference.opcfoundation.org/v104/Core/DataTypes/AttributeWriteMask/
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Integer> userWriteMask(DynRequest req);

    /**
     * Indicates that a type node may not be instantiated.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Boolean> isAbstract(DynRequest req);

    /**
     * Indicates that forward and inverse references have the same meaning.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Boolean> isSymmetric(DynRequest req);

    /**
     * The browse name for an inverse reference.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<String> inverseName(DynRequest req);

    /**
     * Indicates that following forward references within a view will not cause a loop.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Boolean> containsNoLoops(DynRequest req);

    /**
     * Indicates that the node can be used to subscribe to events.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<EventNotifiers[]> eventNotifier(DynRequest req);

    /**
     * The value of a variable.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Object> value(DynRequest req);

    /**
     * The value of a variable writing.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Object> valueWrite(DynRequest req);

    /**
     * The node id of the data type for the variable value.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<RealNodeId> dataType(DynRequest req);

    /**
     * The number of dimensions in the value.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynAttributes.ValueRanks> valueRank(DynRequest req);

    /**
     * The length for each dimension of an array value.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Integer[]> arrayDimensions(DynRequest req);

    /**
     * How a variable may be accessed.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynAttributes.AccessLevels[]> accessLevel(DynRequest req);

    /**
     * How a variable may be accessed after taking the user's access rights into account.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynAttributes.AccessLevels[]> userAccessLevel(DynRequest req);

    /**
     * Specifies (in milliseconds) how fast the server can reasonably sample the value for changes.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Double> minimumSamplingInterval(DynRequest req);

    /**
     * Specifies whether the server is actively collecting historical data for the variable.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Boolean> isHistorizing(DynRequest req);

    /**
     * Whether the method can be called.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Boolean> isExecutable(DynRequest req);

    /**
     * Whether the method can be called by the current user.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Boolean> isUserExecutable(DynRequest req);

    /**
     * Provides the metadata and encoding information for custom DataTypes like Structures and Enumerations.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Object> dataTypeDefinition(DynRequest req);

    /**
     * The permissions for the node granted to roles.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Object> rolePermissions(DynRequest req);

    /**
     * The subset of permissions available for the roles available to the current session.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<Object> userRolePermissions(DynRequest req);

    /**
     * The access restrictions assigned to the node.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<AccessRestrictions[]> accessRestrictions(DynRequest req);

    /**
     * How a variable may be accessed.
     *
     * @param req the dynamic request
     * @return the dynamic response
     */
    DynResponse<DynAttributes.AccessLevelExs[]> accessLevelEx(DynRequest req);
}