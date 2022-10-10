package com.connectedcooking.opcua.dynamicnodemanager.core.builder;

import com.connectedcooking.opcua.dynamicnodemanager.core.DynAttributes;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynRequest;

/**
 * Supplementary methods for a dynamic node builder.
 */
public interface DynNodeSupplementaryBuilder {

    DynNodeBaseBuilder writeMask(DynRequest.Full<Integer> writeMask);

    DynNodeBaseBuilder userWriteMask(DynRequest.Full<Integer> userWriteMask);

    DynNodeBaseBuilder isAbstract(DynRequest.Full<Boolean> isAbstract);

    DynNodeBaseBuilder isSymmetric(DynRequest.Full<Boolean> isSymmetric);

    DynNodeBaseBuilder inverseName(DynRequest.Full<String> inverseName);

    DynNodeBaseBuilder containsNoLoops(DynRequest.Full<Boolean> containsNoLoops);

    DynNodeBaseBuilder eventNotifier(DynRequest.Full<DynAttributes.EventNotifiers[]> eventNotifier);

    DynNodeBaseBuilder minimumSamplingInterval(DynRequest.Full<Double> minimumSamplingInterval);

    DynNodeBaseBuilder isExecutable(DynRequest.Full<Boolean> isExecutable);

    DynNodeBaseBuilder isUserExecutable(DynRequest.Full<Boolean> isUserExecutable);

    DynNodeBaseBuilder rolePermissions(DynRequest.Full<Object> rolePermissions);

    DynNodeBaseBuilder userRolePermissions(DynRequest.Full<Object> userRolePermissions);

    DynNodeBaseBuilder accessRestrictions(DynRequest.Full<DynAttributes.AccessRestrictions[]> accessRestrictions);

    DynNodeBaseBuilder accessLevelEx(DynRequest.Full<DynAttributes.AccessLevelExs[]> accessLevelEx);

}