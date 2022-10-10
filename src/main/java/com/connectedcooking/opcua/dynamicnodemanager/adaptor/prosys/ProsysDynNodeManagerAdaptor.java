package com.connectedcooking.opcua.dynamicnodemanager.adaptor.prosys;

import com.connectedcooking.opcua.dynamicnodemanager.core.*;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaReference;
import com.prosysopc.ua.nodes.UaReferenceType;
import com.prosysopc.ua.nodes.UaValueNode;
import com.prosysopc.ua.server.*;
import com.prosysopc.ua.stack.builtintypes.*;
import com.prosysopc.ua.stack.common.NamespaceTable;
import com.prosysopc.ua.stack.common.ServiceResultException;
import com.prosysopc.ua.stack.core.*;
import com.prosysopc.ua.stack.utils.NumericRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * Prosys adaptor for Dynamic NodeManager.
 */
public class ProsysDynNodeManagerAdaptor extends NodeManager {

    private static Logger log = LoggerFactory.getLogger(ProsysDynNodeManagerAdaptor.class);

    private final DynNodeManager dynNodeManager;

    private final NamespaceTable namespaceTable;
    private final NodeManagerTable opcuaNodeManagerTable;

    private final int namespaceIndex;

    /**
     * Creates a new adaptor.
     *
     * @param server       the Prosys server
     * @param namespaceUri the dynamic node manager namespace URI
     */
    public ProsysDynNodeManagerAdaptor(UaServer server, String namespaceUri) {
        this(server, namespaceUri, null, new DynNodeManager());
    }

    /**
     * Creates a new adaptor.
     *
     * @param server                  the Prosys server
     * @param namespaceUri            the dynamic node manager namespace URI
     * @param nodeManagersToIntercept the other node managers to intercept by the adaptor
     */
    public ProsysDynNodeManagerAdaptor(UaServer server, String namespaceUri, Collection<NodeManager> nodeManagersToIntercept) {
        this(server, namespaceUri, nodeManagersToIntercept, new DynNodeManager());
    }

    /**
     * Creates a new adaptor.
     *
     * @param server         the Prosys server
     * @param namespaceUri   the dynamic node manager namespace URI
     * @param dynNodeManager the dynamic node manager to use
     */
    public ProsysDynNodeManagerAdaptor(UaServer server, String namespaceUri, DynNodeManager dynNodeManager) {
        this(server, namespaceUri, null, dynNodeManager);
    }

    /**
     * Creates a new adaptor.
     *
     * @param server                  the Prosys server
     * @param namespaceUri            the dynamic node manager namespace URI
     * @param nodeManagersToIntercept the other node managers to intercept by the adaptor
     * @param dynNodeManager          the dynamic node manager to use
     */
    public ProsysDynNodeManagerAdaptor(UaServer server, String namespaceUri, Collection<NodeManager> nodeManagersToIntercept, DynNodeManager dynNodeManager) {
        super(server, namespaceUri);
        this.dynNodeManager = dynNodeManager;
        this.namespaceTable = server.getNamespaceTable();
        this.opcuaNodeManagerTable = server.getNodeManagerUaServer().getNodeManagerTable();
        this.namespaceIndex = getNamespaceIndex();

        new DynamicIoManager(this);

        var dynamicNodeManagerListener = new DynamicNodeManagerListener();
        addListener(dynamicNodeManagerListener);
        if (nodeManagersToIntercept != null) {
            nodeManagersToIntercept.forEach(nm -> nm.addListener(dynamicNodeManagerListener));
        }
    }

    @Override
    public boolean hasNode(NodeId nodeId) {
        return namespaceIndex == nodeId.getNamespaceIndex()
                && nodeId.getValue() instanceof String && dynNodeManager.hasNode((String) nodeId.getValue());
    }

    @Override
    protected QualifiedName getBrowseName(ExpandedNodeId expandedNodeId, UaNode uaNode) {
        var nodeIdStr = (String) expandedNodeId.getValue();
        return dynNodeManager.findNode(nodeIdStr)
                .map(dnode -> dnode.attributes().browseName(new DynRequest(null, nodeIdStr)))
                .filter(res -> res.getStatus().isGood())
                .map(res -> new QualifiedName(res.getValue().stringValue()))
                .orElse(null);
    }

    @Override
    protected LocalizedText getDisplayName(ExpandedNodeId expandedNodeId, UaNode uaNode, Locale locale) {
        var nodeIdStr = (String) expandedNodeId.getValue();
        return dynNodeManager.findNode(nodeIdStr)
                .map(dnode -> dnode.attributes().displayName(new DynRequest(null, nodeIdStr)))
                .filter(res -> res.getStatus().isGood())
                .map(res -> new LocalizedText(res.getValue().stringValue()))
                .orElse(null);
    }

    @Override
    protected NodeClass getNodeClass(NodeId nodeId, UaNode uaNode) {
        var nodeIdStr = (String) nodeId.getValue();
        return dynNodeManager.findNode(nodeIdStr)
                .map(dnode -> dnode.attributes().nodeClass(new DynRequest(null, nodeIdStr)))
                .filter(res -> res.getStatus().isGood())
                .map(res -> TypeUtils.toNodeClass(res.getValue()))
                .orElse(null);
    }

    @Override
    protected ExpandedNodeId getTypeDefinition(ExpandedNodeId expandedNodeId, UaNode uaNode) {
        var nodeIdStr = (String) expandedNodeId.getValue();
        return dynNodeManager.findNode(nodeIdStr)
                .flatMap(dnode -> dnode.references().byTypeSingle(DynReferences.Types.HasTypeDefinition, TypeUtils.toDynRequest(expandedNodeId)))
                .map(ref -> TypeUtils.toExpandedNodeId(ref.targetId(), namespaceIndex))
                .orElse(null);
    }

    @Override
    protected UaReference[] getReferences(NodeId nodeId, UaNode uaNode) {
        return new UaReference[0];
    }

    @Override
    public NodeId getVariableDataType(NodeId nodeId, UaValueNode uaValueNode) throws StatusException {
        var nodeIdStr = (String) nodeId.getValue();
        return dynNodeManager.findNode(nodeIdStr)
                .map(dnode -> dnode.attributes().dataType(new DynRequest(null, nodeIdStr)))
                .filter(res -> res.getStatus().isGood())
                .map(res -> TypeUtils.toNodeId(res.getValue(), namespaceIndex))
                .orElse(null);
    }

    /**
     * Dynamic implementation of a reference.
     */
    private class DynamicReference extends UaReference {

        private final NodeId referenceTypeId;
        private final ExpandedNodeId sourceId;
        private final ExpandedNodeId targetId;

        public DynamicReference(NodeId referenceTypeId, ExpandedNodeId sourceId, ExpandedNodeId targetId) {
            this.referenceTypeId = referenceTypeId;
            this.sourceId = sourceId;
            this.targetId = targetId;
        }

        @Override
        public void delete() {
            throw new RuntimeException("StatusCodes.Bad_NotImplemented");
        }

        @Override
        public boolean getIsInverse(NodeId nodeId) {
            try {
                if (nodeId.equals(namespaceTable.toNodeId(sourceId))) {
                    return false;
                }
                if (nodeId.equals(namespaceTable.toNodeId(targetId))) {
                    return true;
                }
            } catch (ServiceResultException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("not a source nor target");
        }

        @Override
        public boolean getIsInverse(UaNode node) {
            return getIsInverse(node.getNodeId());
        }

        @Override
        public UaReferenceType getReferenceType() {
            try {
                return (UaReferenceType) opcuaNodeManagerTable.getNode(getReferenceTypeId());
            } catch (StatusException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public NodeId getReferenceTypeId() {
            return referenceTypeId;
        }

        @Override
        public ExpandedNodeId getSourceId() {
            return sourceId;
        }

        @Override
        public UaNode getSourceNode() {
            return null; // new UaExternalNodeImpl(nodeManager, sourceId);
        }

        @Override
        public ExpandedNodeId getTargetId() {
            return targetId;
        }

        @Override
        public UaNode getTargetNode() {
            return null; // new UaExternalNodeImpl(nodeManager, targetId);
        }
    }

    /**
     * Dynamic IO manager. Intercepts responses for attributes (including the value attribute).
     */
    private class DynamicIoManager extends IoManager {

        public DynamicIoManager(NodeManager nodeManager) {
            super(nodeManager);
        }

        @Override
        protected void readAttribute(ServiceContext serviceContext, Object operationContext, NodeId nodeId, UnsignedInteger attributeId, NumericRange numericRange, TimestampsToReturn timestampsToReturn, DateTime dateTime, DataValue dataValue) throws StatusException {
            // these attributes must be handled explicitly because the origin impl expects a Node object which is in our case null
            if (attributeId.equals(Attributes.UserAccessLevel)
                    || attributeId.equals(Attributes.UserExecutable)
                    || attributeId.equals(Attributes.UserWriteMask)) {
                readNonValue(serviceContext, operationContext, nodeId, null, attributeId, dataValue);
                return;
            }
            super.readAttribute(serviceContext, operationContext, nodeId, attributeId, numericRange, timestampsToReturn, dateTime, dataValue);
        }

        @Override
        protected void readNonValue(ServiceContext serviceContext, Object operationContext, NodeId nodeId, UaNode node,
                                    UnsignedInteger attributeId, DataValue dataValue) throws StatusException {
            log.debug("readNonValue: {}, attributeId {}", nodeId, attributeId);
            var request = TypeUtils.toDynRequest(nodeId, serviceContext);
            if (!dynNodeManager.canBrowse(request)) {
                dataValue.setValue(new Variant(null));
                dataValue.setStatusCode(StatusCodes.Bad_NodeIdRejected);
                return;
            }

            var nodeIdStr = (String) nodeId.getValue();
            var dnodeOpt = dynNodeManager.findNode(nodeIdStr);

            if (dnodeOpt.isEmpty()) {
                dataValue.setValue(new Variant(null));
                dataValue.setStatusCode(StatusCodes.Bad_NodeIdUnknown);
                return;
            }

            var attributes = dnodeOpt.get().attributes();

            if (attributeId.equals(Attributes.NodeId)) {
                processResponse(attributes.nodeId(request), dataValue, nid -> TypeUtils.toNodeId(nid, namespaceIndex));
            } else if (attributeId.equals(Attributes.NodeClass)) {
                processResponse(attributes.nodeClass(request), dataValue, TypeUtils::toNodeClass);
            } else if (attributeId.equals(Attributes.BrowseName)) {
                processResponse(attributes.browseName(request), dataValue, bn -> new QualifiedName(bn.stringValue()));
            } else if (attributeId.equals(Attributes.DisplayName)) {
                processResponse(attributes.displayName(request), dataValue, dn -> new LocalizedText(dn.stringValue()));
            } else if (attributeId.equals(Attributes.Description)) {
                processResponse(attributes.description(request), dataValue, d -> new LocalizedText(d.stringValue()));
            } else if (attributeId.equals(Attributes.WriteMask)) {
                processResponse(attributes.writeMask(request), dataValue, UnsignedInteger::valueOf);
            } else if (attributeId.equals(Attributes.UserWriteMask)) {
                readUserWriteMask(request, attributes, serviceContext, operationContext, nodeId, dataValue);
            } else if (attributeId.equals(Attributes.IsAbstract)) {
                processResponse(attributes.isAbstract(request), dataValue);
            } else if (attributeId.equals(Attributes.Symmetric)) {
                processResponse(attributes.isSymmetric(request), dataValue);
            } else if (attributeId.equals(Attributes.InverseName)) {
                processResponse(attributes.inverseName(request), dataValue, LocalizedText::new);
            } else if (attributeId.equals(Attributes.ContainsNoLoops)) {
                processResponse(attributes.containsNoLoops(request), dataValue);
            } else if (attributeId.equals(Attributes.EventNotifier)) {
                processResponse(attributes.eventNotifier(request), dataValue, TypeUtils::toEventNotifiers);
            } else if (attributeId.equals(Attributes.DataType)) {
                readDataType(request, attributes, dataValue);
            } else if (attributeId.equals(Attributes.ValueRank)) {
                processResponse(attributes.valueRank(request), dataValue, TypeUtils::toValueRank);
            } else if (attributeId.equals(Attributes.ArrayDimensions)) {
                processResponse(attributes.arrayDimensions(request), dataValue, TypeUtils::toArrayDimensions);
            } else if (attributeId.equals(Attributes.AccessLevel)) {
                processResponse(attributes.accessLevel(request), dataValue, TypeUtils::toAccessLevel);
            } else if (attributeId.equals(Attributes.UserAccessLevel)) {
                readUserAccessLevel(request, attributes, serviceContext, operationContext, nodeId, dataValue);
            } else if (attributeId.equals(Attributes.MinimumSamplingInterval)) {
                processResponse(attributes.minimumSamplingInterval(request), dataValue);
            } else if (attributeId.equals(Attributes.Historizing)) {
                processResponse(attributes.isHistorizing(request), dataValue);
            } else if (attributeId.equals(Attributes.Executable)) {
                processResponse(attributes.isExecutable(request), dataValue);
            } else if (attributeId.equals(Attributes.UserExecutable)) {
                readUserExecutable(request, attributes, serviceContext, operationContext, nodeId, dataValue);
            } else if (attributeId.equals(Attributes.DataTypeDefinition)) {
                processResponse(attributes.dataTypeDefinition(request), dataValue);
            } else if (attributeId.equals(Attributes.RolePermissions)) {
                processResponse(attributes.rolePermissions(request), dataValue);
            } else if (attributeId.equals(Attributes.UserRolePermissions)) {
                processResponse(attributes.userRolePermissions(request), dataValue);
            } else if (attributeId.equals(Attributes.AccessRestrictions)) {
                processResponse(attributes.accessRestrictions(request), dataValue, TypeUtils::toAccessRestriction);
            } else if (attributeId.equals(Attributes.AccessLevelEx)) {
                processResponse(attributes.accessLevelEx(request), dataValue, TypeUtils::toAccessLevelExs);
            }
            setServerTimestamp(null, dataValue);
        }

        @Override
        protected void readValue(ServiceContext serviceContext, Object operationContext, NodeId nodeId, UaValueNode node,
                                 NumericRange indexRange, TimestampsToReturn timestampsToReturn, DateTime minTimestamp, DataValue dataValue) throws StatusException {
            log.debug("readValue: {}", nodeId);
            var request = TypeUtils.toDynRequest(nodeId, serviceContext);
            if (!dynNodeManager.canBrowse(request)) {
                dataValue.setValue(new Variant(null));
                dataValue.setStatusCode(StatusCodes.Bad_NodeIdRejected);
                return;
            }

            var nodeIdStr = (String) nodeId.getValue();
            var dnodeOpt = dynNodeManager.findNode(nodeIdStr);

            if (dnodeOpt.isEmpty()) {
                dataValue.setValue(new Variant(null));
                dataValue.setStatusCode(StatusCodes.Bad_NodeIdUnknown);

            } else {
                var attributes = dnodeOpt.get().attributes();

                var response = attributes.value(request);

                processResponse(response, dataValue);
            }

            setServerTimestamp(minTimestamp, dataValue);
            applyIndexRangeToReadValue(dataValue, indexRange);
        }

        @Override
        protected boolean writeValue(ServiceContext serviceContext, Object operationContext, NodeId nodeId, UaValueNode node, NumericRange indexRange, DataValue dataValue) throws StatusException {
            var request = TypeUtils.toDynRequest(nodeId, serviceContext, dataValue.getValue().getValue());
            if (!dynNodeManager.canBrowse(request)) {
                dataValue.setValue(new Variant(null));
                dataValue.setStatusCode(StatusCodes.Bad_NodeIdRejected);
                return false;
            }

            var nodeIdStr = (String) nodeId.getValue();
            var dnodeOpt = dynNodeManager.findNode(nodeIdStr);

            if (dnodeOpt.isEmpty()) {
                dataValue.setValue(new Variant(null));
                dataValue.setStatusCode(StatusCodes.Bad_NodeIdUnknown);
                return false;
            }

            var attributes = dnodeOpt.get().attributes();

            var response = attributes.valueWrite(request);
            processResponse(response, dataValue);

            setServerTimestamp(null, dataValue);
            applyIndexRangeToReadValue(dataValue, indexRange);

            return true;
        }

        @Override
        protected void checkDataType(NodeId nodeId, UaValueNode node, DataValue dataValue) throws StatusException {
            NodeId dataType = getVariableDataType(nodeId, node);
            if (dataType == null) {
                // when data type is not set explicitly, we will try to guess it anyway
                return;
            }
            dataValue.setValue(autoConvert(dataValue.getValue(), dataType));
            if (!dataTypeEquals(dataValue.getValue(), dataType)) {
                throw new StatusException(StatusCodes.Bad_TypeMismatch);
            }
        }

        private void setServerTimestamp(DateTime minTimestamp, DataValue dataValue) {
            if (dataValue.getServerTimestamp() == null ||
                    (minTimestamp != null && dataValue.getServerTimestamp().getMilliSeconds() < minTimestamp.getMilliSeconds())) {
                long currentTime = DateTime.currentTime().getMilliSeconds();
                dataValue.setServerTimestamp(new DateTime(currentTime * 10000L));
            }
        }

        private void readDataType(DynRequest request, DynAttributes attributes, DataValue dataValue) {
            var res = attributes.dataType(request);
            if (res.getStatus().isGood() && res.getValue() != null) {
                processResponse(res, dataValue, nid -> TypeUtils.toNodeId(nid, namespaceIndex));
            } else {
                // try to guess the data type
                var value = attributes.value(request);
                if (value.getStatus().isGood() && value.getValue() != null) {
                    var dataType = TypeUtils.guessValueDataType(value.getValue());
                    if (dataType != null) {
                        processResponse(DynResponse.StatusCodes.Good, dataType, dataValue, nid -> TypeUtils.toNodeId(nid, namespaceIndex));
                    } else {
                        processResponse(DynResponse.StatusCodes.Bad_AttributeIdInvalid, null, dataValue, null);
                    }
                }
            }
        }

        private void readUserWriteMask(DynRequest request, DynAttributes attributes, ServiceContext serviceContext, Object operationContext, NodeId nodeId, DataValue dataValue) throws StatusException {
            // user attributes must be an intersection with global ones
            var writeMask = getWriteMask(serviceContext, operationContext, nodeId, null);
            var res = attributes.userWriteMask(request);
            if (res.getStatus().isGood() && res.getValue() != null) {
                var userWriteMask = AttributeWriteMask.of(UnsignedInteger.valueOf(res.getValue()));
                if (writeMask != null) {
                    var set = AttributeWriteMask.of(userWriteMask).toSet();
                    set.retainAll(writeMask.toSet());
                    processResponse(DynResponse.StatusCodes.Good, AttributeWriteMask.of(set), dataValue, null);
                } else {
                    processResponse(DynResponse.StatusCodes.Good, userWriteMask, dataValue, null);
                }
            } else if (writeMask != null) {
                processResponse(DynResponse.StatusCodes.Good, writeMask, dataValue, null);
            }
        }

        private void readUserAccessLevel(DynRequest request, DynAttributes attributes, ServiceContext serviceContext, Object operationContext, NodeId nodeId, DataValue dataValue) throws StatusException {
            // user attributes must be an intersection with global ones
            var accessLevel = getAccessLevel(serviceContext, operationContext, nodeId, null);
            var res = attributes.userAccessLevel(request);
            if (res.getStatus().isGood() && res.getValue() != null) {
                var userAccessLevel = TypeUtils.toAccessLevel(res.getValue());
                if (accessLevel != null) {
                    var set = AccessLevelType.of(userAccessLevel).toSet();
                    set.retainAll(accessLevel.toSet());
                    processResponse(DynResponse.StatusCodes.Good, AccessLevelType.of(set), dataValue, null);
                } else {
                    processResponse(DynResponse.StatusCodes.Good, userAccessLevel, dataValue, null);
                }
            } else if (accessLevel != null) {
                processResponse(DynResponse.StatusCodes.Good, accessLevel, dataValue, null);
            }
        }

        private void readUserExecutable(DynRequest request, DynAttributes attributes, ServiceContext serviceContext, Object operationContext, NodeId nodeId, DataValue dataValue) throws StatusException {
            // user attributes must be an intersection with global ones
            var executable = getExecutable(serviceContext, operationContext, nodeId, null);
            var res = attributes.isUserExecutable(request);
            if (res.getStatus().isGood() && res.getValue() != null) {
                var userExecutable = res.getValue();
                processResponse(DynResponse.StatusCodes.Good, executable && userExecutable, dataValue, null);
            } else {
                processResponse(DynResponse.StatusCodes.Good, executable, dataValue, null);
            }
        }

        private <T> void processResponse(DynResponse<T> response, DataValue dataValue) {
            processResponse(response, dataValue, null);
        }

        private <T> void processResponse(DynResponse<T> response, DataValue dataValue, Function<T, Object> wrap) {
            if (response != null) {
                processResponse(response.getStatus(), response.getValue(), dataValue, wrap);
            }
        }

        private <T> void processResponse(DynResponse.StatusCodes statusCode, T value, DataValue dataValue, Function<T, Object> wrap) {
            var v = wrap != null && value != null ? wrap.apply(value) : value;
            dataValue.setValue(new Variant(convertValueToStandard(v)));
            dataValue.setStatusCode(TypeUtils.toStatusCode(statusCode));
        }

        private Object convertValueToStandard(Object value) {
            if (value instanceof Date) {
                return DateTime.fromMillis(((Date) value).getTime());
            }
            if (value instanceof LocalDate) {
                return DateTime.fromMillis(((LocalDate) value).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            }
            if (value instanceof LocalDateTime) {
                return DateTime.fromMillis(((LocalDateTime) value).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            }
            if (value instanceof ZonedDateTime) {
                return DateTime.fromMillis(((ZonedDateTime) value).toInstant().toEpochMilli());
            }
            if (value instanceof Duration) {
                return ((Duration) value).toMillis() + 0.0;
            }
            if (value instanceof DynQualifiedName) {
                return new QualifiedName(((DynQualifiedName) value).stringValue());
            }
            if (value instanceof DynLocalizedText) {
                return new LocalizedText(((DynLocalizedText) value).stringValue());
            }
            return value;
        }
    }

    /**
     * Listener for references (with service context) and other NodeManages that should be intercepted by dynamic functionality.
     */
    class DynamicNodeManagerListener implements NodeManagerListener {

        /**
         * Adds dynamic nodes if the node is a parent node.
         */
        @Override
        public void onGetReferences(ServiceContext serviceContext, ViewDescription viewDescription, NodeId nodeId, UaNode uaNode, List<UaReference> references) {
            log.debug("onGetReferences: {}, ref {}", nodeId, references);

            var dynReferences = dynNodeManager.assignedChildren(
                    new RealNodeId(nodeId.getNamespaceIndex(), nodeId.getValue()), TypeUtils.toUserContext(serviceContext));
            dynReferences.stream()
                    .map(this::toUaReference)
                    .forEach(references::add);

            if (hasNode(nodeId) && dynNodeManager.canBrowse(TypeUtils.toDynRequest(nodeId, serviceContext))) {
                var nodeIdStr = (String) nodeId.getValue();
                dynNodeManager.findNode(nodeIdStr)
                        .map(DynNode::references)
                        .ifPresent(refs -> refs.all(TypeUtils.toDynRequest(nodeId, serviceContext)).stream()
                                .map(this::toUaReference)
                                .forEach(references::add));
            }
        }

        private UaReference toUaReference(DynReference ref) {
            var referenceType = TypeUtils.toReferenceTypeId(ref.type());
            var sourceNodeId = TypeUtils.toExpandedNodeId(ref.sourceId(), namespaceIndex);
            var targetNodeId = TypeUtils.toExpandedNodeId(ref.targetId(), namespaceIndex);
            return new DynamicReference(referenceType, sourceNodeId, targetNodeId);
        }

        /**
         * Checks and returns false for all NodeIds that should not be visible.
         */
        @Override
        public boolean onBrowseNode(ServiceContext serviceContext, ViewDescription viewDescription, NodeId nodeId, UaNode uaNode, UaReference uaReference) {
            return !hasNode(nodeId) || dynNodeManager.canBrowse(TypeUtils.toDynRequest(nodeId, serviceContext));
        }

        @Override
        public void onAfterAddNode(ServiceContext serviceContext, NodeId nodeId, UaNode uaNode, NodeId nodeId1, UaNode uaNode1, NodeClass nodeClass, QualifiedName qualifiedName, NodeAttributes nodeAttributes, UaReferenceType uaReferenceType, ExpandedNodeId expandedNodeId, UaNode uaNode2) throws StatusException {
        }

        @Override
        public void onAfterAddReference(ServiceContext serviceContext, NodeId nodeId, UaNode uaNode, ExpandedNodeId expandedNodeId, UaNode uaNode1, NodeId nodeId1, UaReferenceType uaReferenceType, boolean b) throws StatusException {
        }

        @Override
        public void onAfterCreateMonitoredDataItem(ServiceContext serviceContext, Subscription subscription, MonitoredDataItem monitoredDataItem) {
        }

        @Override
        public void onAfterDeleteMonitoredDataItem(ServiceContext serviceContext, Subscription subscription, MonitoredDataItem monitoredDataItem) {
        }

        @Override
        public void onAfterModifyMonitoredDataItem(ServiceContext serviceContext, Subscription subscription, MonitoredDataItem monitoredDataItem) {
        }

        @Override
        public void onAddNode(ServiceContext serviceContext, NodeId nodeId, UaNode uaNode, NodeId nodeId1, NodeClass nodeClass, QualifiedName qualifiedName, NodeAttributes nodeAttributes, UaReferenceType uaReferenceType, ExpandedNodeId expandedNodeId, UaNode uaNode1) throws StatusException {
        }

        @Override
        public void onAddReference(ServiceContext serviceContext, NodeId nodeId, UaNode uaNode, ExpandedNodeId expandedNodeId, UaNode uaNode1, NodeId nodeId1, UaReferenceType uaReferenceType, boolean b) throws StatusException {
        }

        @Override
        public void onCreateMonitoredDataItem(ServiceContext serviceContext, Subscription subscription, NodeId nodeId, UaNode uaNode, UnsignedInteger unsignedInteger, NumericRange numericRange, MonitoringParameters monitoringParameters, MonitoringFilter monitoringFilter, AggregateFilterResult aggregateFilterResult, MonitoringMode monitoringMode) throws StatusException {
        }

        @Override
        public void onDeleteMonitoredDataItem(ServiceContext serviceContext, Subscription subscription, MonitoredDataItem monitoredDataItem) {
        }

        @Override
        public void onDeleteNode(ServiceContext serviceContext, NodeId nodeId, UaNode uaNode, boolean b) throws StatusException {
        }

        @Override
        public void onDeleteReference(ServiceContext serviceContext, NodeId nodeId, UaNode uaNode, ExpandedNodeId expandedNodeId, UaNode uaNode1, NodeId nodeId1, UaReferenceType uaReferenceType, boolean b, boolean b1) throws StatusException {
        }

        @Override
        public void onModifyMonitoredDataItem(ServiceContext serviceContext, Subscription subscription, MonitoredDataItem monitoredDataItem, UaNode uaNode, MonitoringParameters monitoringParameters, MonitoringFilter monitoringFilter, AggregateFilterResult aggregateFilterResult) throws StatusException {
        }
    }
}
