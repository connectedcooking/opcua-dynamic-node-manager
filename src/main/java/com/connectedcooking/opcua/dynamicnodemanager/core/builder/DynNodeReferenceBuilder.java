package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynNodeBuilder;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

import java.util.Collection;

/**
 * Reference building methods for a dynamic node builder.
 */
public interface DynNodeReferenceBuilder {

    DynNodeBaseBuilder hasComponents(DynRequest.Full<Collection<RealNodeId>> hasComponent);

    DynNodeBaseBuilder hasComponent(DynRequest.Full<RealNodeId> hasComponent);

    DynNodeBaseBuilder hasComponent(RealNodeId componentId, RealNodeId... componentIds);

    DynNodeBaseBuilder hasComponent(String componentId, String... componentIds);

    DynNodeBaseBuilder hasComponentsBy(DynRequest.Resolved<Collection<RealNodeId>> hasComponent);

    DynNodeBaseBuilder hasComponentsBy(DynRequest.ResolvedTwo<Collection<RealNodeId>> hasComponent);

    DynNodeBaseBuilder hasComponentsById(DynRequest.Id<Collection<RealNodeId>> hasComponent);

    DynNodeBaseBuilder hasComponentsByIds(DynRequest.Ids<Collection<RealNodeId>> hasComponent);

    DynNodeBaseBuilder hasComponentBy(DynRequest.Resolved<RealNodeId> hasComponent);

    DynNodeBaseBuilder hasComponentBy(DynRequest.ResolvedTwo<RealNodeId> hasComponent);

    DynNodeBaseBuilder hasComponentById(DynRequest.Id<RealNodeId> hasComponent);

    DynNodeBaseBuilder hasComponentByIds(DynRequest.Ids<RealNodeId> hasComponent);

    DynNodeBaseBuilder hasInverseComponents(DynRequest.Full<Collection<RealNodeId>> hasInverseComponent);

    DynNodeBaseBuilder hasInverseComponent(DynRequest.Full<RealNodeId> hasInverseComponent);

    DynNodeBaseBuilder hasInverseComponent(RealNodeId inverseComponent);

    /**
     * Sets a reference as well as an inverse reference.
     *
     * @param component        the component real node id
     * @param inverseComponent the inverse component real node id
     * @return this builder
     */
    DynNodeBaseBuilder hasComponentWithInverse(RealNodeId component, RealNodeId inverseComponent);

    DynNodeBaseBuilder hasProperty(RealNodeId property, RealNodeId... properties);

    DynNodeBaseBuilder hasProperty(String property, String... properties);

    DynNodeBaseBuilder hasProperty(DynRequest.Full<RealNodeId> hasProperty);

    DynNodeBaseBuilder hasProperties(DynRequest.Full<Collection<RealNodeId>> hasProperty);

    DynNodeBuilder hasInterface(RealNodeId hasInterface, RealNodeId... hasInterfaces);
}