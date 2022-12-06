package com.connectedcooking.opcua.dynamicnodemanager.core.datatype;

import java.util.Objects;

/**
 * Qualified Name
 */
public class DynQualifiedName {

    private final String value;

    public DynQualifiedName(String value) {
        this.value = value;
    }

    /**
     * Returns the string value.
     *
     * @return the string value
     */
    public String stringValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynQualifiedName that = (DynQualifiedName) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "DynQualifiedName{" + value + '}';
    }
}
