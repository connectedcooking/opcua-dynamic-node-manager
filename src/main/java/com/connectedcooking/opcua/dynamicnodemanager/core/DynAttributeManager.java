package com.connectedcooking.opcua.dynamicnodemanager.core;

import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;

import java.util.Optional;

/* *
 * Dynamic attribute manager.
 * Holds dynamic attribute resolving functions.
 */
public class DynAttributeManager implements DynAttributes {

    private DynRequest.Full<RealNodeId> nodeId;
    private DynRequest.Full<NodeClasses> nodeClass;
    private DynRequest.Full<DynQualifiedName> browseName;
    private DynRequest.Full<DynLocalizedText> displayName;
    private DynRequest.Full<DynLocalizedText> description;
    private DynRequest.Full<Object> value;
    private DynRequest.FullWrite<Object> valueWrite;
    private DynRequest.Full<RealNodeId> dataType;
    private DynRequest.Full<ValueRanks> valueRank;
    private DynRequest.Full<Integer[]> arrayDimensions;
    private DynRequest.Full<AccessLevels[]> accessLevel;
    private DynRequest.Full<AccessLevels[]> userAccessLevel;
    private DynRequest.Full<Double> minimumSamplingInterval;
    private DynRequest.Full<Boolean> isHistorizing;
    private DynRequest.Full<Object> dataTypeDefinition;
    private DynRequest.Full<AccessRestrictions[]> accessRestrictions;
    private DynRequest.Full<AccessLevelExs[]> accessLevelEx;

    private final DynNode node;

    public DynAttributeManager() {
        this(null);
    }

    public DynAttributeManager(DynNode node) {
        this.node = node;
    }

    /**
     * Returns a new attribute manager with a reference to a dynamic node.
     *
     * @param node the referenced dynamic node
     * @return the attribute manager
     */
    public DynAttributeManager with(DynNode node) {
        return copy(node);
    }

    @Override
    public DynResponse<RealNodeId> nodeId(DynRequest req) {
        if (nodeId != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, nodeId.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new RealNodeId(req.getNodeId()));
    }

    public void setNodeId(DynRequest.Full<RealNodeId> nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public DynResponse<NodeClasses> nodeClass(DynRequest req) {
        if (nodeClass != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, nodeClass.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, NodeClasses.Unspecified);
    }

    public void setNodeClass(DynRequest.Full<NodeClasses> nodeClass) {
        this.nodeClass = nodeClass;
    }

    @Override
    public DynResponse<DynQualifiedName> browseName(DynRequest req) {
        if (browseName != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, browseName.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new DynQualifiedName(lastPath(req.getNodeId())));
    }

    public void setBrowseName(DynRequest.Full<DynQualifiedName> browseName) {
        this.browseName = browseName;
    }

    @Override
    public DynResponse<DynLocalizedText> displayName(DynRequest req) {
        if (displayName != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, displayName.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new DynLocalizedText(lastPath(req.getNodeId())));
    }

    public void setDisplayName(DynRequest.Full<DynLocalizedText> displayName) {
        this.displayName = displayName;
    }

    @Override
    public DynResponse<DynLocalizedText> description(DynRequest req) {
        if (description != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, description.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new DynLocalizedText(""));
    }

    public void setDescription(DynRequest.Full<DynLocalizedText> description) {
        this.description = description;
    }

    @Override
    public DynResponse<Integer> writeMask(DynRequest req) {
        // writing not supported
        return new DynResponse<>(DynResponse.StatusCodes.Good, 0);
    }

    @Override
    public DynResponse<Integer> userWriteMask(DynRequest req) {
        // writing not supported
        return new DynResponse<>(DynResponse.StatusCodes.Good, 0);
    }

    @Override
    public DynResponse<Boolean> isAbstract(DynRequest req) {
        return new DynResponse<>(DynResponse.StatusCodes.Good, false);
    }

    @Override
    public DynResponse<Boolean> isSymmetric(DynRequest req) {
        return new DynResponse<>(DynResponse.StatusCodes.Good, true);
    }

    @Override
    public DynResponse<String> inverseName(DynRequest req) {
        return new DynResponse<>(DynResponse.StatusCodes.Good, null);
    }

    @Override
    public DynResponse<Boolean> containsNoLoops(DynRequest req) {
        return new DynResponse<>(DynResponse.StatusCodes.Good, true);
    }

    @Override
    public DynResponse<EventNotifiers[]> eventNotifier(DynRequest req) {
        // not supported
        return new DynResponse<>(DynResponse.StatusCodes.Good, new EventNotifiers[0]);
    }

    @Override
    public DynResponse<Object> value(DynRequest req) {
        if (value != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, unpackOptional(value.apply(req.getUserContext(), req.getNodeId(), node)));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, null);
    }

    public void setValue(DynRequest.Full<Object> value) {
        this.value = value;
    }

    @Override
    public DynResponse<Object> valueWrite(DynRequest req) {
        if (valueWrite != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, unpackOptional(valueWrite.apply(req.getUserContext(), req.getNodeId(), node, req.getValue())));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, null);
    }

    public void setValueWrite(DynRequest.FullWrite<Object> valueWrite) {
        this.valueWrite = valueWrite;
    }

    private Object unpackOptional(Object value) {
        if (value instanceof Optional) {
            return ((Optional) value).orElse(null);
        }
        return value;
    }

    @Override
    public DynResponse<RealNodeId> dataType(DynRequest req) {
        if (dataType != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, dataType.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Bad_AttributeIdInvalid, null);
    }

    public void setDataType(DynRequest.Full<RealNodeId> dataType) {
        this.dataType = dataType;
    }

    @Override
    public DynResponse<ValueRanks> valueRank(DynRequest req) {
        if (valueRank != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, valueRank.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, ValueRanks.Scalar);
    }

    public void setValueRank(DynRequest.Full<ValueRanks> valueRank) {
        this.valueRank = valueRank;
    }

    @Override
    public DynResponse<Integer[]> arrayDimensions(DynRequest req) {
        if (arrayDimensions != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, arrayDimensions.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, null);
    }

    public void setArrayDimensions(DynRequest.Full<Integer[]> arrayDimensions) {
        this.arrayDimensions = arrayDimensions;
    }

    @Override
    public DynResponse<AccessLevels[]> accessLevel(DynRequest req) {
        if (accessLevel != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, accessLevel.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new AccessLevels[0]);
    }

    public void setAccessLevel(DynRequest.Full<AccessLevels[]> accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public DynResponse<AccessLevels[]> userAccessLevel(DynRequest req) {
        if (userAccessLevel != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, userAccessLevel.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new AccessLevels[0]);
    }

    public void setUserAccessLevel(DynRequest.Full<AccessLevels[]> userAccessLevel) {
        this.userAccessLevel = userAccessLevel;
    }

    @Override
    public DynResponse<Double> minimumSamplingInterval(DynRequest req) {
        if (minimumSamplingInterval != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, minimumSamplingInterval.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, -1.0);
    }

    public void setMinimumSamplingInterval(DynRequest.Full<Double> minimumSamplingInterval) {
        this.minimumSamplingInterval = minimumSamplingInterval;
    }

    @Override
    public DynResponse<Boolean> isHistorizing(DynRequest req) {
        if (isHistorizing != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, isHistorizing.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, false);
    }

    public void setIsHistorizing(DynRequest.Full<Boolean> isHistorizing) {
        this.isHistorizing = isHistorizing;
    }

    @Override
    public DynResponse<Boolean> isExecutable(DynRequest req) {
        // not supported
        return new DynResponse<>(DynResponse.StatusCodes.Good, false);
    }

    @Override
    public DynResponse<Boolean> isUserExecutable(DynRequest req) {
        // not supported
        return new DynResponse<>(DynResponse.StatusCodes.Good, false);
    }

    @Override
    public DynResponse<Object> dataTypeDefinition(DynRequest req) {
        if (dataTypeDefinition != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, dataTypeDefinition.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, null);
    }

    public void setDataTypeDefinition(DynRequest.Full<Object> dataTypeDefinition) {
        this.dataTypeDefinition = dataTypeDefinition;
    }

    @Override
    public DynResponse<Object> rolePermissions(DynRequest req) {
        // not supported
        return new DynResponse<>(DynResponse.StatusCodes.Bad_AttributeIdInvalid, null);
    }

    @Override
    public DynResponse<Object> userRolePermissions(DynRequest req) {
        // not supported
        return new DynResponse<>(DynResponse.StatusCodes.Bad_AttributeIdInvalid, null);
    }

    @Override
    public DynResponse<AccessRestrictions[]> accessRestrictions(DynRequest req) {
        if (accessRestrictions != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, accessRestrictions.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new AccessRestrictions[0]);   // default
    }

    public void setAccessRestrictions(DynRequest.Full<AccessRestrictions[]> accessRestrictions) {
        this.accessRestrictions = accessRestrictions;
    }

    @Override
    public DynResponse<AccessLevelExs[]> accessLevelEx(DynRequest req) {
        if (accessLevelEx != null) {
            return new DynResponse<>(DynResponse.StatusCodes.Good, accessLevelEx.apply(req.getUserContext(), req.getNodeId(), node));
        }
        return new DynResponse<>(DynResponse.StatusCodes.Good, new AccessLevelExs[0]);
    }

    public void setAccessLevelEx(DynRequest.Full<AccessLevelExs[]> accessLevelEx) {
        this.accessLevelEx = accessLevelEx;
    }

    private String lastPath(String nodeId) {
        if (nodeId != null) {
            var idx = nodeId.lastIndexOf('/');
            if (idx > -1 && nodeId.length() > idx + 1) {
                return nodeId.substring(idx + 1);
            }
        }
        return nodeId;
    }

    /**
     * Returns a deep copy of this dynamic attribute manager.
     *
     * @return the copy
     */
    protected DynAttributeManager copy() {
        return copy(null);
    }

    private DynAttributeManager copy(DynNode node) {
        var copy = new DynAttributeManager(node);
        copy.nodeId = nodeId;
        copy.nodeClass = nodeClass;
        copy.browseName = browseName;
        copy.displayName = displayName;
        copy.description = description;
        copy.value = value;
        copy.valueWrite = valueWrite;
        copy.dataType = dataType;
        copy.valueRank = valueRank;
        copy.arrayDimensions = arrayDimensions;
        copy.accessLevel = accessLevel;
        copy.userAccessLevel = userAccessLevel;
        copy.minimumSamplingInterval = minimumSamplingInterval;
        copy.isHistorizing = isHistorizing;
        copy.dataTypeDefinition = dataTypeDefinition;
        copy.accessRestrictions = accessRestrictions;
        copy.accessLevelEx = accessLevelEx;
        return copy;
    }
}
