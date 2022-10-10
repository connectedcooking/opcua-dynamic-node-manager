package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynAttributes;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynNodeId;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

/**
 * Generic dynamic node builder to start building of a dynamic node with by a type.
 */
public interface DynNodeGenericBuilder extends DynNodeBaseBuilder {

    DynNodeGenericBuilder base(DynNodeId nodeId);

    DynNodeGenericBuilder base(String nodeId);

    DynNodeGenericBuilder nodeClass(DynAttributes.NodeClasses nodeClass);

    DynNodeGenericBuilder typeDefinition(RealNodeId typeDefinition);

    DynNodeObjectBuilder object(DynNodeId nodeId);

    DynNodeObjectBuilder object(String nodeId);

    DynNodeObjectBuilder object(DynNodeId nodeId, String name);

    DynNodeObjectBuilder object(String nodeId, String name);

    DynNodeObjectBuilder object(DynNodeId nodeId, RealNodeId typeDefinition);

    DynNodeObjectBuilder object(String nodeId, RealNodeId typeDefinition);

    DynNodeObjectBuilder object(String nodeId, String name, RealNodeId typeDefinition);

    DynNodeObjectBuilder object(DynNodeId nodeId, String name, RealNodeId typeDefinition);

    DynNodePartialObjectBuilder childObject(String nodeId);

    DynNodePartialObjectBuilder childObject(String nodeId, String name);

    DynNodePartialObjectBuilder childObject(String nodeId, RealNodeId typeDefinition);

    DynNodePartialObjectBuilder childObject(String nodeId, String name, RealNodeId typeDefinition);

    DynNodeVariableBuilder variable(DynNodeId nodeId);

    DynNodeVariableBuilder variable(String nodeId);

    DynNodeVariableBuilder variable(DynNodeId nodeId, String name);

    DynNodeVariableBuilder variable(String nodeId, String name);

    DynNodeVariableBuilder variable(DynNodeId nodeId, RealNodeId typeDefinition);

    DynNodeVariableBuilder variable(String nodeId, RealNodeId typeDefinition);

    DynNodeVariableBuilder variable(DynNodeId nodeId, Object value);

    DynNodeVariableBuilder variable(String nodeId, Object value);

    DynNodeVariableBuilder variable(DynNodeId nodeId, String name, RealNodeId typeDefinition);

    DynNodeVariableBuilder variable(String nodeId, String name, RealNodeId typeDefinition);

    DynNodeVariableBuilder variable(DynNodeId nodeId, String name, Object value);

    DynNodeVariableBuilder variable(String nodeId, String name, Object value);

    DynNodeVariableBuilder variable(String nodeId, String name, RealNodeId typeDefinition, Object value);

    DynNodeVariableBuilder variable(DynNodeId nodeId, String name, RealNodeId typeDefinition, Object value);

    DynNodePartialVariableBuilder childVariable(String nodeId);

    DynNodePartialVariableBuilder childVariable(String nodeId, String name);

    DynNodePartialVariableBuilder childVariable(String nodeId, RealNodeId typeDefinition);

    DynNodePartialVariableBuilder childVariable(String nodeId, Object value);

    DynNodePartialVariableBuilder childVariable(String nodeId, String name, RealNodeId typeDefinition);

    DynNodePartialVariableBuilder childVariable(String nodeId, String name, Object value);

    DynNodePartialVariableBuilder childVariable(String nodeId, String name, RealNodeId typeDefinition, Object value);
}