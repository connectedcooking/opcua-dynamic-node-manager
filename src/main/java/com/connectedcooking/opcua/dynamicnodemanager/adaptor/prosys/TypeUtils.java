package com.connectedcooking.opcua.dynamicnodemanager.adaptor.prosys;

import com.connectedcooking.opcua.dynamicnodemanager.core.*;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.BasicValueDataTypes;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;
import com.prosysopc.ua.ValueRanks;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.*;
import com.prosysopc.ua.stack.core.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Bunch of converting utilities.
 */
class TypeUtils {

    private TypeUtils() {
    }

    public static NodeId toNodeId(RealNodeId realNodeId, int nsIndex) {
        var ns = realNodeId.isLocal() ? nsIndex : realNodeId.namespaceIndex();
        var identifier = realNodeId.identifier();
        if (identifier instanceof Integer) {
            return new NodeId(ns, (int) identifier);
        }
        if (identifier instanceof String) {
            return new NodeId(ns, (String) identifier);
        }
        return new NodeId(ns, identifier.toString());
    }

    public static ExpandedNodeId toExpandedNodeId(RealNodeId realNodeId, int nsIndex) {
        var ns = realNodeId.isLocal() ? nsIndex : realNodeId.namespaceIndex();
        return new ExpandedNodeId(null, ns, realNodeId.identifier());
    }

    public static DynRequest toDynRequest(ExpandedNodeId nodeId) {
        return new DynRequest(null, (String) nodeId.getValue());
    }

    public static DynRequest toDynRequest(NodeId nodeId, ServiceContext serviceContext, Object value) {
        return new DynRequest(toUserContext(serviceContext), (String) nodeId.getValue(), value);
    }

    public static DynRequest toDynRequest(NodeId nodeId, ServiceContext serviceContext) {
        return toDynRequest(nodeId, serviceContext, null);
    }

    public static UserContext toUserContext(ServiceContext serviceContext) {
        if (serviceContext == null) {
            return new UserContext();
        }
        var session = serviceContext.getSession();
        var identity = session.getUserIdentity();
        var username = identity != null ? identity.getName() : null;
        var password = identity != null ? identity.getPassword() : null;
        return new UserContext(username, password, session.getSessionName());
    }

    public static NodeClass toNodeClass(DynAttributes.NodeClasses nodeClass) {
        switch (nodeClass) {
            case Unspecified:
                return NodeClass.Unspecified;
            case Object:
                return NodeClass.Object;
            case Variable:
                return NodeClass.Variable;
            case Method:
                return NodeClass.Method;
            case ObjectType:
                return NodeClass.ObjectType;
            case VariableType:
                return NodeClass.VariableType;
            case ReferenceType:
                return NodeClass.ReferenceType;
            case DataType:
                return NodeClass.DataType;
            case View:
                return NodeClass.View;
        }
        throw new IllegalArgumentException("Cannot convert NodeClass " + nodeClass);
    }

    public static UnsignedByte toAccessLevel(DynAttributes.AccessLevels[] accessLevel) {
        return AccessLevelType.of(Arrays.stream(accessLevel)
                .map(TypeUtils::toAccessLevel)
                .collect(Collectors.toSet())
                .toArray(new AccessLevelType[0])).getAsBuiltInType();
    }

    public static AccessLevelType toAccessLevel(DynAttributes.AccessLevels accessLevel) {
        switch (accessLevel) {
            case CurrentRead:
                return AccessLevelType.CurrentRead;
            case CurrentWrite:
                return AccessLevelType.CurrentWrite;
            case HistoryRead:
                return AccessLevelType.HistoryRead;
            case HistoryWrite:
                return AccessLevelType.HistoryWrite;
            case SemanticChange:
                return AccessLevelType.SemanticChange;
            case StatusWrite:
                return AccessLevelType.StatusWrite;
            case TimestampWrite:
                return AccessLevelType.TimestampWrite;
        }
        throw new IllegalArgumentException("Cannot convert AccessLevel " + accessLevel);
    }

    public static UnsignedShort toAccessRestriction(DynAttributes.AccessRestrictions[] accessRestrictions) {
        return AccessRestrictionType.of(Arrays.stream(accessRestrictions)
                .map(TypeUtils::toAccessRestriction)
                .collect(Collectors.toSet())
                .toArray(new AccessRestrictionType[0])).getAsBuiltInType();
    }

    public static AccessRestrictionType toAccessRestriction(DynAttributes.AccessRestrictions accessRestriction) {
        switch (accessRestriction) {
            case SigningRequired:
                return AccessRestrictionType.SigningRequired;
            case EncryptionRequired:
                return AccessRestrictionType.EncryptionRequired;
            case SessionRequired:
                return AccessRestrictionType.SessionRequired;
        }
        throw new IllegalArgumentException("Cannot convert AccessRestriction " + accessRestriction);
    }

    public static UnsignedInteger toAccessLevelExs(DynAttributes.AccessLevelExs[] accessLevelExs) {
        return AccessLevelExType.of(Arrays.stream(accessLevelExs)
                .map(TypeUtils::toAccessLevelExs)
                .collect(Collectors.toSet())
                .toArray(new AccessLevelExType[0])).getAsBuiltInType();
    }

    public static AccessLevelExType toAccessLevelExs(DynAttributes.AccessLevelExs accessLevelEx) {
        switch (accessLevelEx) {
            case NonatomicRead:
                return AccessLevelExType.NonatomicRead;
            case NonatomicWrite:
                return AccessLevelExType.NonatomicWrite;
            case WriteFullArrayOnly:
                return AccessLevelExType.WriteFullArrayOnly;
        }
        throw new IllegalArgumentException("Cannot convert AccessLevelExs " + accessLevelEx);
    }

    public static NodeId toReferenceTypeId(DynReferences.Types type) {
        switch (type) {
            case References:
                return ReferenceTypeIdentifiers.References;
            case NonHierarchicalReferences:
                return ReferenceTypeIdentifiers.NonHierarchicalReferences;
            case HierarchicalReferences:
                return ReferenceTypeIdentifiers.HierarchicalReferences;
            case HasChild:
                return ReferenceTypeIdentifiers.HasChild;
            case Organizes:
                return ReferenceTypeIdentifiers.Organizes;
            case HasEventSource:
                return ReferenceTypeIdentifiers.HasEventSource;
            case HasModellingRule:
                return ReferenceTypeIdentifiers.HasModellingRule;
            case HasEncoding:
                return ReferenceTypeIdentifiers.HasEncoding;
            case HasDescription:
                return ReferenceTypeIdentifiers.HasDescription;
            case HasTypeDefinition:
                return ReferenceTypeIdentifiers.HasTypeDefinition;
            case GeneratesEvent:
                return ReferenceTypeIdentifiers.GeneratesEvent;
            case Aggregates:
                return ReferenceTypeIdentifiers.Aggregates;
            case HasSubtype:
                return ReferenceTypeIdentifiers.HasSubtype;
            case HasProperty:
                return ReferenceTypeIdentifiers.HasProperty;
            case HasComponent:
                return ReferenceTypeIdentifiers.HasComponent;
            case HasNotifier:
                return ReferenceTypeIdentifiers.HasNotifier;
            case HasOrderedComponent:
                return ReferenceTypeIdentifiers.HasOrderedComponent;
            case FromState:
                return ReferenceTypeIdentifiers.FromState;
            case ToState:
                return ReferenceTypeIdentifiers.ToState;
            case HasCause:
                return ReferenceTypeIdentifiers.HasCause;
            case HasEffect:
                return ReferenceTypeIdentifiers.HasEffect;
            case HasHistoricalConfiguration:
                return ReferenceTypeIdentifiers.HasHistoricalConfiguration;
            case HasSubStateMachine:
                return ReferenceTypeIdentifiers.HasSubStateMachine;
            case HasArgumentDescription:
                return ReferenceTypeIdentifiers.HasArgumentDescription;
            case HasOptionalInputArgumentDescription:
                return ReferenceTypeIdentifiers.HasOptionalInputArgumentDescription;
            case AlwaysGeneratesEvent:
                return ReferenceTypeIdentifiers.AlwaysGeneratesEvent;
            case HasTrueSubState:
                return ReferenceTypeIdentifiers.HasTrueSubState;
            case HasFalseSubState:
                return ReferenceTypeIdentifiers.HasFalseSubState;
            case HasCondition:
                return ReferenceTypeIdentifiers.HasCondition;
            case HasPubSubConnection:
                return ReferenceTypeIdentifiers.HasPubSubConnection;
            case DataSetToWriter:
                return ReferenceTypeIdentifiers.DataSetToWriter;
            case HasGuard:
                return ReferenceTypeIdentifiers.HasGuard;
            case HasDataSetWriter:
                return ReferenceTypeIdentifiers.HasDataSetWriter;
            case HasDataSetReader:
                return ReferenceTypeIdentifiers.HasDataSetReader;
            case HasAlarmSuppressionGroup:
                return ReferenceTypeIdentifiers.HasAlarmSuppressionGroup;
            case AlarmGroupMember:
                return ReferenceTypeIdentifiers.AlarmGroupMember;
            case HasEffectDisable:
                return ReferenceTypeIdentifiers.HasEffectDisable;
            case HasDictionaryEntry:
                return ReferenceTypeIdentifiers.HasDictionaryEntry;
            case HasInterface:
                return ReferenceTypeIdentifiers.HasInterface;
            case HasAddIn:
                return ReferenceTypeIdentifiers.HasAddIn;
            case HasEffectEnable:
                return ReferenceTypeIdentifiers.HasEffectEnable;
            case HasEffectSuppressed:
                return ReferenceTypeIdentifiers.HasEffectSuppressed;
            case HasEffectUnsuppressed:
                return ReferenceTypeIdentifiers.HasEffectUnsuppressed;
            case HasWriterGroup:
                return ReferenceTypeIdentifiers.HasWriterGroup;
            case HasReaderGroup:
                return ReferenceTypeIdentifiers.HasReaderGroup;
            case AliasFor:
                return ReferenceTypeIdentifiers.AliasFor;
        }
        throw new IllegalArgumentException("Cannot convert ReferenceTypeId " + type);
    }

    static UnsignedInteger toStatusCode(DynResponse.StatusCodes status) {
        switch (status) {
            case Good:
                return StatusCodes.Good;
            case Bad:
                return StatusCodes.Bad;
            case Bad_NodeIdRejected:
                return StatusCodes.Bad_NodeIdRejected;
            case Bad_NodeIdUnknown:
                return StatusCodes.Bad_NodeIdUnknown;
            case Bad_AttributeIdInvalid:
                return StatusCodes.Bad_AttributeIdInvalid;
            case Bad_NotFound:
                return StatusCodes.Bad_NotFound;
            case Bad_NotSupported:
                return StatusCodes.Bad_NotSupported;
            case Bad_NotImplemented:
                return StatusCodes.Bad_NotImplemented;
        }
        return StatusCodes.Bad;
    }

    static UnsignedByte toEventNotifiers(DynAttributes.EventNotifiers[] eventNotifiers) {
        return EventNotifierType.of(Arrays.stream(eventNotifiers)
                .map(TypeUtils::toEventNotifier)
                .collect(Collectors.toSet())
                .toArray(new EventNotifierType[0])).getAsBuiltInType();
    }

    static EventNotifierType toEventNotifier(DynAttributes.EventNotifiers eventNotifier) {
        switch (eventNotifier) {
            case SubscribeToEvents:
                return EventNotifierType.SubscribeToEvents;
            case HistoryRead:
                return EventNotifierType.HistoryRead;
            case HistoryWrite:
                return EventNotifierType.HistoryWrite;
        }
        throw new IllegalArgumentException("Cannot convert EventNotifier " + eventNotifier);
    }

    static int toValueRank(DynAttributes.ValueRanks valueRank) {
        switch (valueRank) {
            case Any:
                return ValueRanks.Any;
            case Scalar:
                return ValueRanks.Scalar;
            case ScalarOrOneDimension:
                return ValueRanks.ScalarOrOneDimension;
            case OneDimension:
                return ValueRanks.OneDimension;
            case OneOrMoreDimensions:
                return ValueRanks.OneOrMoreDimensions;
        }
        throw new IllegalArgumentException("Cannot convert ValueRank " + valueRank);
    }

    static UnsignedInteger[] toArrayDimensions(Integer[] arrayDimensions) {
        if (arrayDimensions == null) {
            return null;
        }
        return Arrays.stream(arrayDimensions)
                .map(UnsignedInteger::valueOf).toArray(UnsignedInteger[]::new);
    }

    static RealNodeId guessValueDataType(Object value) {
        if (value instanceof Boolean) {
            return BasicValueDataTypes.Boolean;
        } else if (value instanceof String) {
            return BasicValueDataTypes.String;
        } else if (value instanceof Byte) {
            return BasicValueDataTypes.Byte;
        } else if (value instanceof Short) {
            return BasicValueDataTypes.Int16;
        } else if (value instanceof Integer) {
            return BasicValueDataTypes.Int32;
        } else if (value instanceof Long) {
            return BasicValueDataTypes.Int64;
        } else if (value instanceof Float) {
            return BasicValueDataTypes.Float;
        } else if (value instanceof Double) {
            return BasicValueDataTypes.Double;
        } else if (value instanceof UUID) {
            return BasicValueDataTypes.Guid;
        } else if (value instanceof byte[]) {
            return BasicValueDataTypes.ByteString;
        } else if (value instanceof NodeId) {
            return BasicValueDataTypes.NodeId;
        } else if (value instanceof ExpandedNodeId) {
            return BasicValueDataTypes.ExpandedNodeId;
        } else if (value instanceof QualifiedName) {
            return BasicValueDataTypes.QualifiedName;
        } else if (value instanceof LocalizedText) {
            return BasicValueDataTypes.LocalizedText;
        } else if (value instanceof Enumeration) {
            return BasicValueDataTypes.Enumeration;
        } else if (value instanceof BigDecimal) {
            return BasicValueDataTypes.Decimal;
        } else if (value instanceof BigInteger) {
            return BasicValueDataTypes.Integer;
        } else if (value instanceof Date || value instanceof LocalDateTime || value instanceof ZonedDateTime) {
            return BasicValueDataTypes.DateTime;
        } else if (value instanceof LocalDate) {
            return BasicValueDataTypes.Date;
        } else if (value instanceof LocalTime) {
            return BasicValueDataTypes.Time;
        } else if (value instanceof Duration) {
            return BasicValueDataTypes.Duration;
        } else if (value instanceof DynQualifiedName) {
            return BasicValueDataTypes.QualifiedName;
        } else if (value instanceof DynLocalizedText) {
            return BasicValueDataTypes.LocalizedText;
        }
        return null;
    }
}
