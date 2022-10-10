package com.connectedcooking.opcua.dynamicnodemanager.core;

import com.connectedcooking.opcua.dynamicnodemanager.core.builder.*;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.connectedcooking.opcua.dynamicnodemanager.core.datatype.BasicTypeDefinitions.*;

/**
 * Dynamic node builder.
 * A set of convenient methods to build a dynamic node.
 */
public class DynNodeBuilder implements DynNodeGenericBuilder, DynNodeObjectBuilder, DynNodeVariableBuilder, DynNodePartialVariableBuilder, DynNodePartialObjectBuilder {

    protected final DynNodeManager nodeManager;

    protected final DynAttributeManager attributeManager;
    protected final DynReferenceManager referenceManager;

    protected final List<DynRequest.Full<Collection<RealNodeId>>> parentProperties = new LinkedList<>();
    protected final List<DynRequest.Full<Collection<RealNodeId>>> parentComponents = new LinkedList<>();

    protected DynNodeId nodeId;
    protected DynNode parentNode;

    protected DynRequest.Full<Boolean> canBrowse;

    /**
     * Creates a new dynamic node builder for a dynamic node manager.
     *
     * @param nodeManager the dynamic node manager
     */
    protected DynNodeBuilder(DynNodeManager nodeManager) {
        this.nodeManager = nodeManager;
        this.attributeManager = new DynAttributeManager();
        this.referenceManager = new DynReferenceManager();
    }

    @Override
    public void register() {
        registerAndGet();
    }

    @Override
    public DynNode registerAndGet() {
        if (nodeId == null) {
            throw new IllegalStateException("Dynamic node ID must be set!");
        }
        var node = new BaseDynNode(nodeId, parentNode != null ? parentNode.nodeId() : null, attributeManager.copy(), referenceManager.copy());

        if (parentNode != null) {
            parentProperties.forEach(fn -> parentNode.references().addAll(DynReferences.Types.HasProperty, fn));
            parentComponents.forEach(fn -> parentNode.references().addAll(DynReferences.Types.HasComponent, fn));
        }

        nodeManager.registerNode(node, canBrowse);
        return node;
    }

    @Override
    public DynNodeBuilder canBrowse(DynRequest.Full<Boolean> canBrowse) {
        this.canBrowse = canBrowse;
        return this;
    }

    @Override
    public DynNodeBuilder canBrowseBy(DynRequest.Resolved<Boolean> canBrowse) {
        return canBrowse((ctx, nid, node) -> canBrowse.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder canBrowseById(DynRequest.Id<Boolean> canBrowse) {
        return canBrowse((ctx, nid, node) -> canBrowse.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder base(DynNodeId nodeId) {
        this.nodeId = nodeId;
        attributeManager.setNodeId((ctx, nid, node) -> new RealNodeId(nid));
        return this;
    }

    @Override
    public DynNodeBuilder base(String nodeId) {
        return base(new DynNodeId(nodeId));
    }

    @Override
    public DynNodeBuilder object(DynNodeId nodeId) {
        return object(nodeId, null, null);
    }

    @Override
    public DynNodeBuilder object(String nodeId) {
        return object(new DynNodeId(nodeId));
    }

    @Override
    public DynNodeBuilder object(DynNodeId nodeId, String name) {
        return object(nodeId, name, null);
    }

    @Override
    public DynNodeBuilder object(String nodeId, String name) {
        return object(new DynNodeId(nodeId), name);
    }

    @Override
    public DynNodeBuilder object(DynNodeId nodeId, RealNodeId typeDefinition) {
        return object(nodeId, null, typeDefinition);
    }

    @Override
    public DynNodeBuilder object(String nodeId, RealNodeId typeDefinition) {
        return object(new DynNodeId(nodeId), null, typeDefinition);
    }

    @Override
    public DynNodeBuilder object(String nodeId, String name, RealNodeId typeDefinition) {
        return object(new DynNodeId(nodeId), name, typeDefinition);
    }

    @Override
    public DynNodeBuilder object(DynNodeId nodeId, String name, RealNodeId typeDefinition) {
        base(nodeId);
        nodeClass(DynAttributes.NodeClasses.Object);
        if (name != null) name(name);
        if (typeDefinition != null) {
            typeDefinition(typeDefinition);
        } else {
            typeDefinition(BaseObjectType);
        }
        return this;
    }

    @Override
    public DynNodeBuilder childObject(String nodeId) {
        return object(new PartialNodeId(nodeId));
    }

    @Override
    public DynNodeBuilder childObject(String nodeId, String name) {
        return object(new PartialNodeId(nodeId), name);
    }

    @Override
    public DynNodeBuilder childObject(String nodeId, RealNodeId typeDefinition) {
        return object(new PartialNodeId(nodeId), nodeId, typeDefinition);
    }

    @Override
    public DynNodeBuilder childObject(String nodeId, String name, RealNodeId typeDefinition) {
        return object(new PartialNodeId(nodeId), name, typeDefinition);
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId) {
        return variable(nodeId, null, null, null);
    }

    @Override
    public DynNodeBuilder variable(String nodeId) {
        return variable(new DynNodeId(nodeId));
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId, String name) {
        return variable(nodeId, name, null, null);
    }

    @Override
    public DynNodeBuilder variable(String nodeId, String name) {
        return variable(new DynNodeId(nodeId), name);
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId, RealNodeId typeDefinition) {
        return variable(nodeId, null, typeDefinition, null);
    }

    @Override
    public DynNodeBuilder variable(String nodeId, RealNodeId typeDefinition) {
        return variable(new DynNodeId(nodeId), typeDefinition);
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId, Object value) {
        return variable(nodeId, null, null, value);
    }

    @Override
    public DynNodeBuilder variable(String nodeId, Object value) {
        return variable(new DynNodeId(nodeId), value);
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId, String name, RealNodeId typeDefinition) {
        return variable(nodeId, name, typeDefinition, null);
    }

    @Override
    public DynNodeBuilder variable(String nodeId, String name, RealNodeId typeDefinition) {
        return variable(new DynNodeId(nodeId), name, typeDefinition);
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId, String name, Object value) {
        return variable(nodeId, name, null, value);
    }

    @Override
    public DynNodeBuilder variable(String nodeId, String name, Object value) {
        return variable(new DynNodeId(nodeId), name, value);
    }

    @Override
    public DynNodeBuilder variable(String nodeId, String name, RealNodeId typeDefinition, Object value) {
        return variable(new DynNodeId(nodeId), name, typeDefinition, value);
    }

    @Override
    public DynNodeBuilder variable(DynNodeId nodeId, String name, RealNodeId typeDefinition, Object value) {
        base(nodeId);
        nodeClass(DynAttributes.NodeClasses.Variable);
        typeDefinition(typeDefinition != null ? typeDefinition : BaseDataVariableType);
        accessLevel(DynAttributes.AccessLevels.CurrentRead);
        userAccessLevel(DynAttributes.AccessLevels.CurrentRead);
        if (name != null) name(name);
        if (value != null) value(value);
        return this;
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId) {
        return variable(new PartialNodeId(nodeId));
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId, String name) {
        return variable(new PartialNodeId(nodeId), name);
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId, RealNodeId typeDefinition) {
        return variable(new PartialNodeId(nodeId), typeDefinition);
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId, Object value) {
        return variable(new PartialNodeId(nodeId), value);
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId, String name, RealNodeId typeDefinition) {
        return variable(new PartialNodeId(nodeId), name, typeDefinition);
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId, String name, Object value) {
        return variable(new PartialNodeId(nodeId), name, value);
    }

    @Override
    public DynNodeBuilder childVariable(String nodeId, String name, RealNodeId typeDefinition, Object value) {
        return variable(new PartialNodeId(nodeId), name, typeDefinition, value);
    }

    @Override
    public DynNodeBuilder typeDefinition(RealNodeId typeDefinition) {
        referenceManager.replace(DynReferences.Types.HasTypeDefinition, (ctx, nid, node) -> typeDefinition);
        return this;
    }

    @Override
    public DynNodeBuilder nodeClass(DynAttributes.NodeClasses nodeClass) {
        attributeManager.setNodeClass((ctx, nid, node) -> nodeClass);
        return this;
    }

    @Override
    public DynNodeBuilder name(String name) {
        return name((ctx, nid, node) -> name);
    }

    @Override
    public DynNodeBuilder name(DynRequest.Full<String> name) {
        browseName(name);
        displayName(name);
        return this;
    }

    @Override
    public DynNodeBuilder browseName(DynRequest.Full<String> browseName) {
        attributeManager.setBrowseName((ctx, nid, node) -> new DynQualifiedName(browseName.apply(ctx, nid, node)));
        return this;
    }

    @Override
    public DynNodeBuilder browseName(String browseName) {
        return browseName((ctx, nid, node) -> browseName);
    }

    @Override
    public DynNodeBaseBuilder browseNameBy(DynRequest.Resolved<String> browseName) {
        return browseName((ctx, nid, node) -> browseName.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBaseBuilder browseNameBy(DynRequest.ResolvedTwo<String> browseName) {
        return browseName((ctx, nid, node) -> browseName.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBaseBuilder browseNameById(DynRequest.Id<String> browseName) {
        return browseName((ctx, nid, node) -> browseName.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBaseBuilder browseNameById(DynRequest.Ids<String> browseName) {
        return browseName((ctx, nid, node) -> browseName.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBaseBuilder displayName(DynRequest.Full<String> displayName) {
        attributeManager.setDisplayName((ctx, nid, node) -> new DynLocalizedText(displayName.apply(ctx, nid, node)));
        return this;
    }

    @Override
    public DynNodeBaseBuilder displayName(String displayName) {
        return displayName((ctx, nid, node) -> displayName);
    }

    @Override
    public DynNodeBaseBuilder displayNameBy(DynRequest.Resolved<String> displayName) {
        return displayName((ctx, nid, node) -> displayName.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBaseBuilder displayNameBy(DynRequest.ResolvedTwo<String> displayName) {
        return displayName((ctx, nid, node) -> displayName.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBaseBuilder displayNameById(DynRequest.Id<String> displayName) {
        return displayName((ctx, nid, node) -> displayName.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBaseBuilder displayNameById(DynRequest.Ids<String> displayName) {
        return displayName((ctx, nid, node) -> displayName.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBaseBuilder description(DynRequest.Full<String> description) {
        attributeManager.setDescription((ctx, nid, node) -> new DynLocalizedText(description.apply(ctx, nid, node)));
        return this;
    }

    @Override
    public DynNodeBaseBuilder description(String description) {
        return description((ctx, nid, node) -> description);
    }

    @Override
    public DynNodeBuilder value(Object value) {
        return value((ctx, nid, node) -> value);
    }

    @Override
    public DynNodeBuilder value(Object value, RealNodeId dataType) {
        value((ctx, nid, node) -> value);
        dataType((ctx, nid, node) -> dataType);
        return this;
    }

    @Override
    public DynNodeBuilder value(DynRequest.Full<Object> value) {
        attributeManager.setValue(value);
        attributeManager.setAccessLevel((ctx, nid, node) -> new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead});
        return this;
    }

    @Override
    public DynNodeBuilder valueBy(DynRequest.Resolved<Object> value) {
        return value((ctx, nid, node) -> value.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder valueBy(DynRequest.ResolvedTwo<Object> value) {
        return value((ctx, nid, node) -> value.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder valueById(DynRequest.Id<Object> value) {
        return value((ctx, nid, node) -> value.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder valueById(DynRequest.Ids<Object> value) {
        return value((ctx, nid, node) -> value.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public <V> DynNodeVariableBuilder value(DynRequest.Full<V> read, DynRequest.FullWrite<V> write) {
        attributeManager.setValue((DynRequest.Full<Object>) read);
        attributeManager.setValueWrite((DynRequest.FullWrite<Object>) write);
        attributeManager.setAccessLevel((ctx, nid, node) -> new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead, DynAttributes.AccessLevels.CurrentWrite});
        return this;
    }

    @Override
    public <V> DynNodeVariableBuilder valueBy(DynRequest.Resolved<V> read, DynRequest.ResolvedWrite<V> write) {
        return value((ctx, nid, node) -> read.apply(ctx, node.nodeId().parse(nid, 0)),
                (ctx, nid, node, value) -> write.apply(ctx, node.nodeId().parse(nid, 0), value));
    }

    @Override
    public <V> DynNodeVariableBuilder valueBy(DynRequest.ResolvedTwo<V> read, DynRequest.ResolvedTwoWrite<V> write) {
        return value((ctx, nid, node) -> read.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)),
                (ctx, nid, node, value) -> write.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1), value));
    }

    @Override
    public <V> DynNodeVariableBuilder valueById(DynRequest.Id<V> read, DynRequest.IdWrite<V> write) {
        return value((ctx, nid, node) -> read.apply(ctx, node.nodeId().parseLong(nid, 0)),
                (ctx, nid, node, value) -> write.apply(ctx, node.nodeId().parseLong(nid, 0), value));
    }

    @Override
    public <V> DynNodeVariableBuilder valueById(DynRequest.Ids<V> read, DynRequest.IdsWrite<V> write) {
        return value((ctx, nid, node) -> read.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)),
                (ctx, nid, node, value) -> write.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1), value));
    }

    @Override
    public DynNodeBuilder dataType(DynRequest.Full<RealNodeId> dataType) {
        attributeManager.setDataType(dataType);
        return this;
    }

    @Override
    public DynNodeBuilder dataType(RealNodeId dataType) {
        return dataType((ctx, nid, node) -> dataType);
    }

    @Override
    public DynNodeBuilder valueRank(DynRequest.Full<DynAttributes.ValueRanks> valueRank) {
        attributeManager.setValueRank(valueRank);
        return this;
    }

    @Override
    public DynNodeBuilder valueRank(DynAttributes.ValueRanks valueRank) {
        return valueRank((ctx, nid, node) -> valueRank);
    }

    @Override
    public DynNodeBuilder arrayDimensions(DynRequest.Full<Integer[]> arrayDimensions) {
        attributeManager.setArrayDimensions(arrayDimensions);
        return this;
    }

    @Override
    public DynNodeBuilder arrayDimensions(Integer[] arrayDimensions) {
        return arrayDimensions((ctx, nid, node) -> arrayDimensions);
    }

    @Override
    public DynNodeBuilder accessLevel(DynAttributes.AccessLevels accessLevel, DynAttributes.AccessLevels... accessLevels) {
        return accessLevel((ctx, nid, node) -> toArray(accessLevel, accessLevels));
    }

    @Override
    public DynNodeBuilder accessLevel(DynRequest.Full<DynAttributes.AccessLevels[]> accessLevel) {
        attributeManager.setAccessLevel(accessLevel);
        return this;
    }

    @Override
    public DynNodeBuilder userAccessLevel(DynAttributes.AccessLevels accessLevel, DynAttributes.AccessLevels... accessLevels) {
        return userAccessLevel((ctx, nid, node) -> toArray(accessLevel, accessLevels));
    }

    private DynAttributes.AccessLevels[] toArray(DynAttributes.AccessLevels accessLevel, DynAttributes.AccessLevels... accessLevels) {
        var size = 1 + (accessLevels != null ? accessLevels.length : 0);
        var array = new DynAttributes.AccessLevels[size];
        array[0] = accessLevel;
        if (accessLevels != null) {
            System.arraycopy(accessLevels, 0, array, 1, accessLevels.length);
        }
        return array;
    }

    @Override
    public DynNodeBaseBuilder isHistorizing(DynRequest.Full<Boolean> isHistorizing) {
        attributeManager.setIsHistorizing(isHistorizing);
        return this;
    }

    @Override
    public DynNodeBuilder userAccessLevel(DynRequest.Full<DynAttributes.AccessLevels[]> accessLevel) {
        attributeManager.setUserAccessLevel(accessLevel);
        return this;
    }

    @Override
    public DynNodeBuilder hasComponents(DynRequest.Full<Collection<RealNodeId>> hasComponents) {
        referenceManager.addAll(DynReferences.Types.HasComponent, hasComponents);
        return this;
    }

    @Override
    public DynNodeBuilder hasComponent(DynRequest.Full<RealNodeId> hasComponent) {
        referenceManager.add(DynReferences.Types.HasComponent, hasComponent);
        return this;
    }

    @Override
    public DynNodeBuilder hasComponent(RealNodeId componentId, RealNodeId... componentIds) {
        hasComponent((ctx, nid, node) -> componentId);
        if (componentIds != null) {
            for (var c : componentIds) {
                hasComponent((ctx, nid, node) -> c);
            }
        }
        return this;
    }

    @Override
    public DynNodeBuilder hasComponent(String componentId, String... componentIds) {
        hasComponent(new RealNodeId(componentId));
        if (componentIds != null) {
            for (var c : componentIds) {
                hasComponent(new RealNodeId(c));
            }
        }
        return this;
    }

    @Override
    public DynNodeBuilder hasComponentsBy(DynRequest.Resolved<Collection<RealNodeId>> hasComponent) {
        return hasComponents((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder hasComponentsBy(DynRequest.ResolvedTwo<Collection<RealNodeId>> hasComponent) {
        return hasComponents((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder hasComponentsById(DynRequest.Id<Collection<RealNodeId>> hasComponent) {
        return hasComponents((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder hasComponentsByIds(DynRequest.Ids<Collection<RealNodeId>> hasComponent) {
        return hasComponents((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBuilder hasComponentBy(DynRequest.Resolved<RealNodeId> hasComponent) {
        return hasComponent((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder hasComponentBy(DynRequest.ResolvedTwo<RealNodeId> hasComponent) {
        return hasComponent((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder hasComponentById(DynRequest.Id<RealNodeId> hasComponent) {
        return hasComponent((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder hasComponentByIds(DynRequest.Ids<RealNodeId> hasComponent) {
        return hasComponent((ctx, nid, node) -> hasComponent.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBuilder hasInverseComponent(RealNodeId inverseComponent) {
        return hasInverseComponent((ctx, nid, node) -> inverseComponent);
    }

    @Override
    public DynNodeBuilder hasInverseComponent(DynRequest.Full<RealNodeId> hasInverseComponent) {
        referenceManager.addInverse(DynReferences.Types.HasComponent, hasInverseComponent);
        return this;
    }

    @Override
    public DynNodeBuilder hasInverseComponents(DynRequest.Full<Collection<RealNodeId>> hasInverseComponents) {
        referenceManager.addAllInverse(DynReferences.Types.HasComponent, hasInverseComponents);
        return this;
    }

    @Override
    public DynNodeBuilder hasComponentWithInverse(RealNodeId component, RealNodeId inverseComponent) {
        hasComponent(component);
        hasInverseComponent(inverseComponent);
        return this;
    }

    @Override
    public DynNodeBuilder hasProperty(RealNodeId property, RealNodeId... properties) {
        hasProperty((ctx, nid, node) -> property);
        if (properties != null) {
            for (var p : properties) {
                hasProperty((ctx, nid, node) -> p);
            }
        }
        return this;
    }

    @Override
    public DynNodeBuilder hasProperty(String property, String... properties) {
        hasProperty(new RealNodeId(property));
        if (properties != null) {
            for (var p : properties) {
                hasProperty(new RealNodeId(p));
            }
        }
        return this;
    }

    @Override
    public DynNodeBuilder hasProperty(DynRequest.Full<RealNodeId> hasProperty) {
        referenceManager.add(DynReferences.Types.HasProperty, hasProperty);
        return this;
    }

    @Override
    public DynNodeBuilder hasProperties(DynRequest.Full<Collection<RealNodeId>> hasProperty) {
        referenceManager.addAll(DynReferences.Types.HasProperty, hasProperty);
        return this;
    }

    @Override
    public DynNodeBuilder hasInterface(RealNodeId hasInterface, RealNodeId... hasInterfaces) {
        referenceManager.add(DynReferences.Types.HasInterface, (ctx, nid, node) -> hasInterface);
        if (hasInterfaces != null) {
            for (var i : hasInterfaces) {
                referenceManager.add(DynReferences.Types.HasInterface, (ctx, nid, node) -> i);
            }
        }
        return this;
    }

    @Override
    public DynNodeBuilder writeMask(DynRequest.Full<Integer> writeMask) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder userWriteMask(DynRequest.Full<Integer> userWriteMask) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder isAbstract(DynRequest.Full<Boolean> isAbstract) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder isSymmetric(DynRequest.Full<Boolean> isSymmetric) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder inverseName(DynRequest.Full<String> inverseName) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder containsNoLoops(DynRequest.Full<Boolean> containsNoLoops) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder eventNotifier(DynRequest.Full<DynAttributes.EventNotifiers[]> eventNotifier) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder minimumSamplingInterval(DynRequest.Full<Double> minimumSamplingInterval) {
        attributeManager.setMinimumSamplingInterval(minimumSamplingInterval);
        return this;
    }

    @Override
    public DynNodeBuilder isExecutable(DynRequest.Full<Boolean> isExecutable) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder isUserExecutable(DynRequest.Full<Boolean> isUserExecutable) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder rolePermissions(DynRequest.Full<Object> rolePermissions) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder userRolePermissions(DynRequest.Full<Object> userRolePermissions) {
        // TODO not supported yet
        return this;
    }

    @Override
    public DynNodeBuilder accessRestrictions(DynRequest.Full<DynAttributes.AccessRestrictions[]> accessRestrictions) {
        attributeManager.setAccessRestrictions(accessRestrictions);
        return this;
    }

    @Override
    public DynNodeBuilder accessLevelEx(DynRequest.Full<DynAttributes.AccessLevelExs[]> accessLevelEx) {
        attributeManager.setAccessLevelEx(accessLevelEx);
        return this;
    }

    @Override
    public DynNodeBuilder asComponent(DynNode parent, DynRequest.Full<RealNodeId> request) {
        return asComponents(parent, (ctx, nid, node) -> List.of(request.apply(ctx, nid, node)));
    }

    @Override
    public DynNodeBuilder asComponent(DynNode parent) {
        return asComponent(parent, (ctx, nid, n) -> nodeId.toReal().withParent(nid));
    }

    @Override
    public DynNodeBuilder asComponentBy(DynNode parent, DynRequest.Resolved<RealNodeId> request) {
        return asComponent(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder asComponentBy(DynNode parent, DynRequest.ResolvedTwo<RealNodeId> request) {
        return asComponent(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder asComponentById(DynNode parent, DynRequest.Id<RealNodeId> request) {
        return asComponent(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder asComponentById(DynNode parent, DynRequest.Ids<RealNodeId> request) {
        return asComponent(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBuilder asComponents(DynNode parent, DynRequest.Full<Collection<RealNodeId>> request) {
        parentNode = parent;
        parentComponents.add(request);
        return this;
    }

    @Override
    public DynNodeBuilder asComponentsBy(DynNode parent, DynRequest.Resolved<Collection<RealNodeId>> request) {
        return asComponents(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder asComponentsBy(DynNode parent, DynRequest.ResolvedTwo<Collection<RealNodeId>> request) {
        return asComponents(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder asComponentsById(DynNode parent, DynRequest.Id<Collection<RealNodeId>> request) {
        return asComponents(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder asComponentsById(DynNode parent, DynRequest.Ids<Collection<RealNodeId>> request) {
        return asComponents(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBuilder asProperty(DynNode parent, DynRequest.Full<RealNodeId> request) {
        return asProperties(parent, (ctx, nid, node) -> List.of(request.apply(ctx, nid, node)));
    }

    @Override
    public DynNodeBuilder asProperty(DynNode parent) {
        return asProperty(parent, (ctx, nid, n) -> nodeId.toReal().withParent(nid));
    }

    @Override
    public DynNodeBuilder asPropertyBy(DynNode parent, DynRequest.Resolved<RealNodeId> request) {
        return asProperty(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder asPropertyBy(DynNode parent, DynRequest.ResolvedTwo<RealNodeId> request) {
        return asProperty(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder asPropertyById(DynNode parent, DynRequest.Id<RealNodeId> request) {
        return asProperty(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder asPropertyById(DynNode parent, DynRequest.Ids<RealNodeId> request) {
        return asProperty(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }

    @Override
    public DynNodeBuilder asProperties(DynNode parent, DynRequest.Full<Collection<RealNodeId>> request) {
        parentNode = parent;
        parentProperties.add(request);
        typeDefinition(PropertyType);
        return this;
    }

    @Override
    public DynNodeBuilder asPropertiesBy(DynNode parent, DynRequest.Resolved<Collection<RealNodeId>> request) {
        return asProperties(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0)));
    }

    @Override
    public DynNodeBuilder asPropertiesBy(DynNode parent, DynRequest.ResolvedTwo<Collection<RealNodeId>> request) {
        return asProperties(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parse(nid, 0), node.nodeId().parse(nid, 1)));
    }

    @Override
    public DynNodeBuilder asPropertiesById(DynNode parent, DynRequest.Id<Collection<RealNodeId>> request) {
        return asProperties(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0)));
    }

    @Override
    public DynNodeBuilder asPropertiesById(DynNode parent, DynRequest.Ids<Collection<RealNodeId>> request) {
        return asProperties(parent, (ctx, nid, node) -> request.apply(ctx, node.nodeId().parseLong(nid, 0), node.nodeId().parseLong(nid, 1)));
    }
}
