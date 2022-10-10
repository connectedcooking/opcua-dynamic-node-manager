package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynNode;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

import java.util.Collection;

public interface DynNodePartialVariableBuilder {

    DynNodeVariableBuilder asComponent(DynNode parent);

    DynNodeVariableBuilder asComponent(DynNode parent, DynRequest.Full<RealNodeId> request);

    DynNodeVariableBuilder asComponentBy(DynNode parent, DynRequest.Resolved<RealNodeId> request);

    DynNodeVariableBuilder asComponentBy(DynNode parent, DynRequest.ResolvedTwo<RealNodeId> request);

    DynNodeVariableBuilder asComponentById(DynNode parent, DynRequest.Id<RealNodeId> request);

    DynNodeVariableBuilder asComponentById(DynNode parent, DynRequest.Ids<RealNodeId> request);

    DynNodeVariableBuilder asComponents(DynNode parent, DynRequest.Full<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asComponentsBy(DynNode parent, DynRequest.Resolved<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asComponentsBy(DynNode parent, DynRequest.ResolvedTwo<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asComponentsById(DynNode parent, DynRequest.Id<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asComponentsById(DynNode parent, DynRequest.Ids<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asProperty(DynNode parent);

    DynNodeVariableBuilder asProperty(DynNode parent, DynRequest.Full<RealNodeId> request);

    DynNodeVariableBuilder asPropertyBy(DynNode parent, DynRequest.Resolved<RealNodeId> request);

    DynNodeVariableBuilder asPropertyBy(DynNode parent, DynRequest.ResolvedTwo<RealNodeId> request);

    DynNodeVariableBuilder asPropertyById(DynNode parent, DynRequest.Id<RealNodeId> request);

    DynNodeVariableBuilder asPropertyById(DynNode parent, DynRequest.Ids<RealNodeId> request);

    DynNodeVariableBuilder asProperties(DynNode parent, DynRequest.Full<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asPropertiesBy(DynNode parent, DynRequest.Resolved<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asPropertiesBy(DynNode parent, DynRequest.ResolvedTwo<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asPropertiesById(DynNode parent, DynRequest.Id<Collection<RealNodeId>> request);

    DynNodeVariableBuilder asPropertiesById(DynNode parent, DynRequest.Ids<Collection<RealNodeId>> request);
}
