package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;

/**
 * Response of an attribute request to a dynamic node manager.
 *
 * @param <T> the result type
 */
public class DynResponse<T> {

    /**
     * Possible status codes.
     * Note: the list is not a complete representation of all statuses defined by OPC UA.
     */
    public enum StatusCodes {

        Good,
        Bad,
        Bad_NodeIdRejected,
        Bad_NodeIdUnknown,
        Bad_AttributeIdInvalid,
        Bad_NotFound,
        Bad_NotSupported,
        Bad_NotImplemented,
        Uncertain;

        /**
         * Indicates whether the response is successful.
         *
         * @return true if successful, false otherwise
         */
        public boolean isGood() {
            return this == Good;
        }
    }

    private final StatusCodes status;
    private final T value;

    /**
     * Creates a new dynamic response.
     *
     * @param status the response status
     * @param value  the response value
     */
    public DynResponse(StatusCodes status, T value) {
        this.status = status;
        this.value = value;
    }

    /**
     * Getter for the response status.
     *
     * @return the response status
     */
    public StatusCodes getStatus() {
        return status;
    }

    /**
     * Getter for the response value.
     *
     * @return the response value
     */
    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynResponse<?> that = (DynResponse<?>) o;
        return status == that.status && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, value);
    }

    @Override
    public String toString() {
        return "DynResponse{status=" + status + ", value=" + value + '}';
    }
}
