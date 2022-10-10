package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynNode;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

import java.util.Collection;

public interface DynNodePartialObjectBuilder {

    DynNodeObjectBuilder asComponent(DynNode parent);

    DynNodeObjectBuilder asComponent(DynNode parent, DynRequest.Full<RealNodeId> request);

    DynNodeObjectBuilder asComponentBy(DynNode parent, DynRequest.Resolved<RealNodeId> request);

    DynNodeObjectBuilder asComponentBy(DynNode parent, DynRequest.ResolvedTwo<RealNodeId> request);

    DynNodeObjectBuilder asComponentById(DynNode parent, DynRequest.Id<RealNodeId> request);

    DynNodeObjectBuilder asComponentById(DynNode parent, DynRequest.Ids<RealNodeId> request);

    DynNodeObjectBuilder asComponents(DynNode parent, DynRequest.Full<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asComponentsBy(DynNode parent, DynRequest.Resolved<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asComponentsBy(DynNode parent, DynRequest.ResolvedTwo<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asComponentsById(DynNode parent, DynRequest.Id<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asComponentsById(DynNode parent, DynRequest.Ids<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asProperty(DynNode parent);

    DynNodeObjectBuilder asProperty(DynNode parent, DynRequest.Full<RealNodeId> request);

    DynNodeObjectBuilder asPropertyBy(DynNode parent, DynRequest.Resolved<RealNodeId> request);

    DynNodeObjectBuilder asPropertyBy(DynNode parent, DynRequest.ResolvedTwo<RealNodeId> request);

    DynNodeObjectBuilder asPropertyById(DynNode parent, DynRequest.Id<RealNodeId> request);

    DynNodeObjectBuilder asPropertyById(DynNode parent, DynRequest.Ids<RealNodeId> request);

    DynNodeObjectBuilder asProperties(DynNode parent, DynRequest.Full<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asPropertiesBy(DynNode parent, DynRequest.Resolved<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asPropertiesBy(DynNode parent, DynRequest.ResolvedTwo<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asPropertiesById(DynNode parent, DynRequest.Id<Collection<RealNodeId>> request);

    DynNodeObjectBuilder asPropertiesById(DynNode parent, DynRequest.Ids<Collection<RealNodeId>> request);
}
