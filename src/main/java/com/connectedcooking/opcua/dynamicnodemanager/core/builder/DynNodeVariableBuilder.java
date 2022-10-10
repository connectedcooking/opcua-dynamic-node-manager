package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynAttributes;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

/**
 * Methods for a variable-based dynamic node builder.
 */
public interface DynNodeVariableBuilder extends DynNodeBaseBuilder {

    DynNodeVariableBuilder value(DynRequest.Full<Object> value);

    DynNodeVariableBuilder valueBy(DynRequest.Resolved<Object> value);

    DynNodeVariableBuilder valueBy(DynRequest.ResolvedTwo<Object> value);

    DynNodeVariableBuilder valueById(DynRequest.Id<Object> value);

    DynNodeVariableBuilder valueById(DynRequest.Ids<Object> value);

    DynNodeVariableBuilder value(Object value);

    DynNodeVariableBuilder value(Object value, RealNodeId dataType);

    <V> DynNodeVariableBuilder value(DynRequest.Full<V> read, DynRequest.FullWrite<V> write);

    <V> DynNodeVariableBuilder valueBy(DynRequest.Resolved<V> read, DynRequest.ResolvedWrite<V> write);

    <V> DynNodeVariableBuilder valueBy(DynRequest.ResolvedTwo<V> read, DynRequest.ResolvedTwoWrite<V> write);

    <V> DynNodeVariableBuilder valueById(DynRequest.Id<V> read, DynRequest.IdWrite<V> write);

    <V> DynNodeVariableBuilder valueById(DynRequest.Ids<V> read, DynRequest.IdsWrite<V> write);

    DynNodeVariableBuilder dataType(DynRequest.Full<RealNodeId> dataType);

    DynNodeVariableBuilder dataType(RealNodeId dataType);

    DynNodeVariableBuilder valueRank(DynRequest.Full<DynAttributes.ValueRanks> valueRank);

    DynNodeVariableBuilder valueRank(DynAttributes.ValueRanks valueRank);

    DynNodeVariableBuilder arrayDimensions(DynRequest.Full<Integer[]> arrayDimensions);

    DynNodeVariableBuilder arrayDimensions(Integer[] arrayDimensions);

    DynNodeVariableBuilder accessLevel(DynRequest.Full<DynAttributes.AccessLevels[]> accessLevel);

    DynNodeVariableBuilder accessLevel(DynAttributes.AccessLevels accessLevel, DynAttributes.AccessLevels... accessLevels);

    DynNodeVariableBuilder userAccessLevel(DynRequest.Full<DynAttributes.AccessLevels[]> userAccessLevel);

    DynNodeVariableBuilder userAccessLevel(DynAttributes.AccessLevels accessLevel, DynAttributes.AccessLevels... accessLevels);

    DynNodeBaseBuilder isHistorizing(DynRequest.Full<Boolean> isHistorizing);
}