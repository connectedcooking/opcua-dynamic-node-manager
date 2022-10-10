package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;

/**
 * Request for an attribute to a dynamic node manager.
 */
public class DynRequest {

    /**
     * Full request.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface Full<T> {

        T apply(UserContext userContext, String nodeId, DynNode dynNode);
    }

    /**
     * Full request for writing.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface FullWrite<T> {

        T apply(UserContext userContext, String nodeId, DynNode dynNode, Object value);
    }

    /**
     * Request with the first resolved part.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface Resolved<T> {

        T apply(UserContext userContext, String id);
    }

    /**
     * Request with the first resolved part for writing.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface ResolvedWrite<T> {

        T apply(UserContext userContext, String id, Object value);
    }

    /**
     * Request with two first resolved parts.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface ResolvedTwo<T> {

        T apply(UserContext userContext, String id1, String id2);
    }

    /**
     * Request with two first resolved parts for writing.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface ResolvedTwoWrite<T> {

        T apply(UserContext userContext, String id1, String id2, Object value);
    }

    /**
     * Request with the first resolved ID of type Long.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface Id<T> {

        T apply(UserContext userContext, Long id);
    }

    /**
     * Request with the first resolved ID of type Long for writing.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface IdWrite<T> {

        T apply(UserContext userContext, Long id, Object value);
    }

    /**
     * Request with two first resolved IDs of type Long.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface Ids<T> {

        T apply(UserContext userContext, Long id1, Long id2);
    }

    /**
     * Request with two first resolved IDs of type Long for writing.
     *
     * @param <T> the return type
     */
    @FunctionalInterface
    public interface IdsWrite<T> {

        T apply(UserContext userContext, Long id1, Long id2, Object value);
    }

    private final UserContext userContext;
    private final String nodeId;
    private final Object value;

    /**
     * Creates a new request.
     *
     * @param userContext the user context
     * @param nodeId      the requested node ID
     * @param value       the requested value
     */
    public DynRequest(UserContext userContext, String nodeId, Object value) {
        this.userContext = userContext;
        this.nodeId = nodeId;
        this.value = value;
    }

    /**
     * Creates a new request.
     *
     * @param userContext the user context
     * @param nodeId      the requested node ID
     */
    public DynRequest(UserContext userContext, String nodeId) {
        this(userContext, nodeId, null);
    }

    /**
     * Getter for the user context
     *
     * @return the user context
     */
    public UserContext getUserContext() {
        return userContext;
    }

    /**
     * Getter for the requested node ID.
     *
     * @return the requested node ID
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * Getter for the requested value.
     *
     * @return the requested value
     */
    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynRequest that = (DynRequest) o;
        return Objects.equals(userContext, that.userContext) && nodeId.equals(that.nodeId) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userContext, nodeId, value);
    }

    @Override
    public String toString() {
        return "DynRequest{nodeId='" + nodeId + "', userContext=" + userContext + "', value=" + value + '}';
    }
}
