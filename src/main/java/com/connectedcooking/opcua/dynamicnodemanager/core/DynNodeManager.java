package com.connectedcooking.opcua.dynamicnodemanager.core;

import com.connectedcooking.opcua.dynamicnodemanager.core.builder.DynNodeGenericBuilder;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Dynamic node manager.
 */
public class DynNodeManager {

    protected final List<DynNode> nodes = new LinkedList<>();

    protected final Map<RealNodeId, AssignedChild> assignedChildren = new HashMap<>();
    protected final Map<DynNodeId, DynRequest.Full<Boolean>> canBrowse = new HashMap<>();

    /**
     * Indicates whether a node is managed by the manager by its real ID representation.
     *
     * @param nodeId the node ID
     * @return true if the node is managed, false otherwise
     */
    public boolean hasNode(String nodeId) {
        return nodes.stream()
                .anyMatch(n -> n.nodeId().matches(nodeId));
    }

    /**
     * Finds a node by its real ID representation.
     *
     * @param nodeId the node ID
     * @return the node optionally
     */
    public Optional<DynNode> findNode(String nodeId) {
        return nodes.stream()
                .filter(n -> n.nodeId().matches(nodeId))
                .findAny();
    }

    /**
     * Finds a node by its dynamic ID.
     *
     * @param nodeId the dynamic node ID
     * @return the node optionally
     */
    public Optional<DynNode> findNode(DynNodeId nodeId) {
        return nodes.stream()
                .filter(n -> n.nodeId().equals(nodeId))
                .findAny();
    }

    /**
     * Register a dynamic node to the manager.
     *
     * @param node the node to register
     */
    public void registerNode(DynNode node) {
        registerNode(node, null);
    }

    /**
     * Register a dynamic node to the manager.
     *
     * @param node      the node to register
     * @param canBrowse the function to indicate permissions to browse the node
     */
    public void registerNode(DynNode node, DynRequest.Full<Boolean> canBrowse) {
        nodes.add(node);
        if (canBrowse != null) {
            this.canBrowse.put(node.nodeId(), canBrowse);
        }
    }

    /**
     * Removes all registered nodes from the manager.
     */
    public void deregisterAll() {
        nodes.clear();
    }

    /**
     * Assigns a dynamic node to a static parent node.
     * This intends to be used only for static models. For assigning into a dynamic parent node, use a HasComponent reference.
     *
     * @param parentId    the parent node ID from a static node set
     * @param childNodeId the dynamic node ID
     * @param fn          the function to compute an assigned real node
     */
    public void assign(RealNodeId parentId, DynNodeId childNodeId, BiFunction<UserContext, DynNodeId, RealNodeId> fn) {
        assignSet(parentId, childNodeId, (ctx, dynNodeId) -> List.of(fn.apply(ctx, dynNodeId)));
    }

    /**
     * Assigns a dynamic node to a static parent node.
     * See {@link #assign(RealNodeId, DynNodeId, BiFunction)}
     */
    public void assign(RealNodeId parentId, DynNodeId childNodeId, RealNodeId childRealNodeId) {
        assign(parentId, childNodeId, (ctx, dynNodeId) -> childRealNodeId);
    }

    /**
     * Assigns a set of dynamic nodes to a static parent node.
     * See {@link #assign(RealNodeId, DynNodeId, BiFunction)}
     */
    public void assignSet(RealNodeId parentId, DynNodeId nodeId, BiFunction<UserContext, DynNodeId, Collection<RealNodeId>> fn) {
        assignedChildren.compute(parentId, (k, fns) -> {
            if (fns == null) {
                fns = new AssignedChild(nodeId);
            }
            fns.fns.add(fn);
            return fns;
        });
    }

    /**
     * Returns a list of HasComponent references for a real node.
     *
     * @param parentId    the parent real node ID
     * @param userContext the user context
     * @return list of references
     */
    public List<DynReference> assignedChildren(RealNodeId parentId, UserContext userContext) {
        List<DynReference> references = new LinkedList<>();
        if (assignedChildren != null) {
            var assigned = assignedChildren.get(parentId);
            if (assigned != null) {
                assigned.fns.forEach(fn -> fn.apply(userContext, assigned.childNodeId)
                        .forEach(rid -> references.add(new DynReference.HasComponentRef(parentId, rid))));
            }
        }
        return Collections.unmodifiableList(references);
    }

    /**
     * Indicates whether the request has sufficient permission to browse the dynamic node with all parent.
     *
     * @param request the dynamic request
     * @return true if the request can browse the node, false otherwise
     */
    public boolean canBrowse(DynRequest request) {
        return findNode(request.getNodeId())
                .map(node -> canBrowse(node, request.getUserContext(), request.getNodeId()))
                .orElse(false);
    }

    private boolean canBrowse(DynNode node, UserContext userContext, String nodeId) {
        var fn = canBrowse.get(node.nodeId());
        if (fn != null && !fn.apply(userContext, nodeId, node)) {
            return false;
        }
        if (node.parentId() != null) {
            return findNode(node.parentId())
                    .map(parent -> canBrowse(parent, userContext, nodeId))
                    .orElse(false);
        }
        return true;
    }

    /**
     * Creates a new generic dynamic node builder.
     *
     * @return the builder
     */
    public DynNodeGenericBuilder nodeBuilder() {
        return new DynNodeBuilder(this);
    }

    private static class AssignedChild {

        final DynNodeId childNodeId;
        final List<BiFunction<UserContext, DynNodeId, Collection<RealNodeId>>> fns = new LinkedList<>();

        public AssignedChild(DynNodeId childNodeId) {
            this.childNodeId = childNodeId;
        }
    }
}
