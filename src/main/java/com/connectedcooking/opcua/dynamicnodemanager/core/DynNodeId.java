package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Representation of a dynamic node ID.
 * A dynamic node is a node managed by a dynamic node manager.
 * A dynamic node can have a variable part to be resolved based on a concrete request.
 * <p>
 * Example: a dynamic node ID with a variable part "Device*\/Errors/Err*" can be resolved as a real node ID "Device123/Errors/Err456".
 */
public class DynNodeId {

    protected static final Pattern PATTERN_FOR_REGEX_ELEMENTS = Pattern.compile("\\([^/]+\\)");

    protected final Pattern identifier;

    /**
     * Creates a new object based on an identifier with a simple placeholder-based string.
     * Every placeholder in the identifier is replaced with a regex word (non-zero length sequence of alpha-digital chars).
     *
     * @param identifier the placeholder-based identifier
     */
    public DynNodeId(String identifier) {
        this(Pattern.compile(identifier.replaceAll("<([^<>])+>", "([\\\\w_]+)")));
    }

    /**
     * Creates a new object based on a regex pattern identifier.
     * IMPORTANT: All regex elements must be enclosed in parentheses! Example: {@code Device(\w+)/Errors([1-5])}
     * IMPORTANT: Each path element (separated with a slash char) can contain maximal one regex element.
     * IMPORTANT: Regex element cannot contain a slash char.
     *
     * @param identifier the identifier
     */
    public DynNodeId(Pattern identifier) {
        this.identifier = identifier;
    }

    /**
     * Indicates whether the nodeId matches this dynamic node identifier.
     *
     * @param nodeId the nodeId to match
     * @return true if matches, false otherwise
     */
    boolean matches(String nodeId) {
        return identifier.matcher(nodeId).matches();
    }

    /**
     * Return a real node ID from this dynamic node ID with a namespace index.
     *
     * @param namespaceIndex the namespace index
     * @param replacements   the replacing values
     * @return the real node ID
     */
    public RealNodeId toRealNs(int namespaceIndex, Object... replacements) {
        return new RealNodeId(namespaceIndex, realize(replacements));
    }

    /**
     * Return a real node ID from this dynamic node ID.
     *
     * @param replacements the replacing values
     * @return the real node ID
     */
    public RealNodeId toReal(Object... replacements) {
        return new RealNodeId(realize(replacements));
    }

    /**
     * Return a real node ID from this dynamic node ID by a requested node ID.
     *
     * @param nodeId the requested node ID
     * @return the real node ID
     */
    public RealNodeId toRealById(String nodeId) {
        var matcher = identifier.matcher(nodeId);
        if (matcher.find()) {
            return new RealNodeId(matcher.group());
        }
        throw new IllegalArgumentException(String.format("Cannot parse nodeId %s.", nodeId));
    }

    /**
     * Replaces all regex elements with concrete values.
     *
     * @param replacements the replacing values
     * @return the realized identifier
     */
    protected String realize(Object... replacements) {
        var pattern = identifier.pattern();
        var matcher = PATTERN_FOR_REGEX_ELEMENTS.matcher(pattern);
        var builder = new StringBuilder();
        var start = 0;
        var i = 0;
        while (matcher.find()) {
            if (i >= replacements.length) {
                throw new IllegalArgumentException(String.format("Count of replacements %s is insufficient for %s.", replacements.length, this));
            }
            var replacement = replacements[i].toString();
            var regex = matcher.group();
            if (!Pattern.matches(regex, replacement)) {
                throw new IllegalArgumentException(String.format("Replacement %s do not match the wanted pattern %s for %s", replacement, regex, this));
            }
            builder.append(pattern, start, matcher.start()).append(replacement);
            start = matcher.end();
            i++;
        }
        if (replacements.length > i) {
            throw new IllegalArgumentException(String.format("Count of replacements %s is undue.", replacements.length));
        }
        if (start < pattern.length()) {
            builder.append(pattern.substring(start));
        }
        return builder.toString();
    }

    /**
     * Indicates whether this is a partial node ID (a path element).
     *
     * @return true if this is a partial node ID, false otherwise
     */
    public boolean isPartial() {
        return false;
    }

    /**
     * Composes this node ID with a partial node ID.
     *
     * @param child the partial node ID
     * @return the composed node ID
     */
    public PartialNodeId compose(PartialNodeId child) {
        return new PartialNodeId(identifier.pattern() + "/" + child.identifier.pattern());
    }

    /**
     * Parses this ID to an array of String values of variable parts.
     *
     * @param nodeId the index of a variable part
     * @return the array of values
     */
    public String[] parse(String nodeId) {
        var matcher = Pattern.compile(identifier.pattern() + "($|/.+)?").matcher(nodeId);
        var groups = matcher.groupCount() - 1;
        var values = new String[groups];
        if (matcher.matches()) {
            for (int i = 0; i < groups; i++) {
                values[i] = matcher.group(i + 1);
            }
        }
        return values;
    }

    /**
     * Parses this ID to an array of Integer values of variable parts.
     * See {@link #parse(String)}
     */
    public Integer[] parseInt(String nodeId) {
        var res = parse(nodeId);
        var values = new Integer[res.length];
        for (int i = 0; i < res.length; i++) {
            values[i] = Integer.valueOf(res[i]);
        }
        return values;
    }

    /**
     * Parses this ID to an array of Long values of variable parts.
     * See {@link #parse(String)}
     */
    public Long[] parseLong(String nodeId) {
        var res = parse(nodeId);
        var values = new Long[res.length];
        for (int i = 0; i < res.length; i++) {
            values[i] = Long.valueOf(res[i]);
        }
        return values;
    }

    /**
     * Parses this ID to an array of values of variable parts.
     *
     * @param nodeId the index of a variable part
     * @param idx    the index of a variable part
     * @return the value under the index
     */
    public String parse(String nodeId, int idx) {
        var matcher = Pattern.compile(identifier.pattern() + "($|/.+)?").matcher(nodeId);
        if (matcher.matches()) {
            return matcher.group(idx + 1);
        }
        return null;
    }

    /**
     * Parses this ID to an array of Integer values of variable parts.
     * See {@link #parse(String, int)}
     *
     * @param nodeId the index of a variable part
     * @param idx    the index of a variable part
     * @return the value under the index
     */
    public Integer parseInt(String nodeId, int idx) {
        var value = parse(nodeId, idx);
        return value != null ? Integer.valueOf(value) : null;
    }

    /**
     * Parses this ID to an array of Long values of variable parts.
     * See {@link #parse(String, int)}
     */
    public Long parseLong(String nodeId, int idx) {
        var value = parse(nodeId, idx);
        return value != null ? Long.valueOf(value) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(identifier.pattern(), ((DynNodeId) o).identifier.pattern());
    }

    @Override
    public int hashCode() {
        return identifier.pattern().hashCode();
    }

    @Override
    public String toString() {
        return "DyNodeId{" + identifier + '}';
    }
}
