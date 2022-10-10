package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.*;

/**
 * Dynamic reference manager.
 * Holds dynamic reference resolving functions.
 */
public class DynReferenceManager implements DynReferences {

    private final Map<Types, List<DynRequest.Full<Collection<RealNodeId>>>> references = new HashMap<>();
    private final Map<Types, List<DynRequest.Full<Collection<RealNodeId>>>> inverseReferences = new HashMap<>();

    private DynNode node;

    /**
     * Returns this reference manager with a reference to a dynamic node.
     *
     * @param node the referenced dynamic node
     * @return the reference manager
     */
    public DynReferenceManager with(DynNode node) {  // TODO not happy about this, is there any "immutable" way to get the node reference?
        this.node = node;
        return this;
    }

    @Override
    public void add(Types type, DynRequest.Full<RealNodeId> fn) {
        references.compute(type, (k, fns) -> {
            if (fns == null) {
                fns = new LinkedList<>();
            }
            fns.add((c, n, node) -> List.of(fn.apply(c, n, node)));
            return fns;
        });
    }

    @Override
    public void replace(Types type, DynRequest.Full<RealNodeId> fn) {
        references.remove(type);   // remove current
        add(type, fn);
    }

    @Override
    public void addAll(Types type, DynRequest.Full<Collection<RealNodeId>> fn) {
        references.compute(type, (k, fns) -> {
            if (fns == null) {
                fns = new LinkedList<>();
            }
            fns.add(fn);
            return fns;
        });
    }

    /**
     * Adds a new dynamic inverse reference resolving function.
     *
     * @param type the reference type
     * @param fn   the inverse resolving function
     */
    public void addInverse(Types type, DynRequest.Full<RealNodeId> fn) {
        inverseReferences.compute(type, (k, fns) -> {
            if (fns == null) {
                fns = new LinkedList<>();
            }
            fns.add((c, n, node) -> List.of(fn.apply(c, n, node)));
            return fns;
        });
    }

    /**
     * Adds a new dynamic multiple inverse reference resolving function.
     *
     * @param type the reference type
     * @param fn   the inverse resolving function
     */
    public void addAllInverse(Types type, DynRequest.Full<Collection<RealNodeId>> fn) {
        inverseReferences.compute(type, (k, fns) -> {
            if (fns == null) {
                fns = new LinkedList<>();
            }
            fns.add(fn);
            return fns;
        });
    }

    @Override
    public Collection<DynReference> all(DynRequest req) {
        var all = new LinkedList<DynReference>();
        for (var entry : references.entrySet()) {
            fill(entry.getKey(), req, entry.getValue(), all, false);
        }
        for (var entry : inverseReferences.entrySet()) {
            fill(entry.getKey(), req, entry.getValue(), all, true);
        }
        return Collections.unmodifiableList(all);
    }

    @Override
    public Collection<DynReference> byType(Types type, DynRequest req) {
        var refs = new LinkedList<DynReference>();
        fill(type, req, references.get(type), refs, false);
        fill(type, req, inverseReferences.get(type), refs, true);
        return refs;
    }

    @Override
    public Optional<DynReference> byTypeSingle(Types type, DynRequest req) {
        var res = byType(type, req);
        if (res != null && !res.isEmpty()) {
            return Optional.of(res.iterator().next());
        }
        return Optional.empty();
    }

    private void fill(Types type, DynRequest req,
                      List<DynRequest.Full<Collection<RealNodeId>>> fns, Collection<DynReference> refs,
                      boolean inverse) {
        if (fns != null) {
            var realNodeId = new RealNodeId(req.getNodeId());
            fns.forEach(fn -> {
                var rids = fn.apply(req.getUserContext(), req.getNodeId(), node);
                if (rids != null) {
                    rids.forEach(rid ->
                            refs.add(inverse
                                    ? new DynReference(type, rid, realNodeId)
                                    : new DynReference(type, realNodeId, rid)
                            )
                    );
                }
            });
        }
    }

    /**
     * Returns a deep copy of this dynamic reference manager.
     *
     * @return the copy
     */
    protected DynReferenceManager copy() {
        var copy = new DynReferenceManager();
        for (var r : references.entrySet()) {
            copy.references.put(r.getKey(), new LinkedList<>(r.getValue()));
        }
        for (var r : inverseReferences.entrySet()) {
            copy.inverseReferences.put(r.getKey(), new LinkedList<>(r.getValue()));
        }
        return copy;
    }
}
