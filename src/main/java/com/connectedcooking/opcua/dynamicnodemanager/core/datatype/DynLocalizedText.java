package com.connectedcooking.opcua.dynamicnodemanager.core.datatype;

import java.util.Objects;

/**
 * Localized Text
 */
public class DynLocalizedText {

    private final static DynLocalizedText EMPTY = new DynLocalizedText("");

    /**
     * Return the empty localized text.
     *
     * @return the empty instance
     */
    public static DynLocalizedText empty() {
        return EMPTY;
    }

    private final String value;

    public DynLocalizedText(String value) {
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
        DynLocalizedText that = (DynLocalizedText) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "DynLocalizedText{" + value + '}';
    }
}
