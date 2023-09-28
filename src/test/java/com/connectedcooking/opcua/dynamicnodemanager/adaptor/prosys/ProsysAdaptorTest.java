package com.connectedcooking.opcua.dynamicnodemanager.adaptor.prosys;

import com.connectedcooking.opcua.dynamicnodemanager.core.*;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynQualifiedName;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.ValueRanks;
import com.prosysopc.ua.nodes.UaReference;
import com.prosysopc.ua.server.NodeManagerTable;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.server.Session;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.stack.builtintypes.*;
import com.prosysopc.ua.stack.core.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProsysAdaptorTest {

    private static final String NS_URI = "http://connectedcooking.com/OPCUA/";
    private static final int NS_INDEX = 3;

    private static final String NODE_ID = "Device*/Errors/Err*";
    private static final String NODE_ID_REAL = "Device123/Errors/Err456";

    @Mock
    private DynNodeManager dynNodeManager;
    @Mock
    private DynNode dynNode;
    @Mock
    private DynAttributeManager dynAttributeManager;
    @Mock
    private DynReferenceManager dynReferenceManager;
    @Mock
    private UaServer mockUaServer;
    @Mock
    private NodeManagerTable mockNodeManagerTable;
    @Mock
    private UaServer.NodeManagerUaServer mockNodeManagerUaServer;
    @Mock
    private ServiceContext mockServiceContext;
    @Mock
    private Session mockSession;

    private ProsysDynNodeManagerAdaptor adaptor;

    @BeforeEach
    void setup() {
        when(mockUaServer.getNodeManagerUaServer()).thenReturn(mockNodeManagerUaServer);
        when(mockUaServer.getAddressSpace()).thenReturn(mockNodeManagerTable);

        when(mockNodeManagerUaServer.getNodeManagerTable()).thenReturn(mockNodeManagerTable);

        when(mockNodeManagerTable.addNodeManager(eq(-1), any())).thenReturn(NS_INDEX);

        adaptor = new ProsysDynNodeManagerAdaptor(mockUaServer, NS_URI, null, dynNodeManager);
    }

    @Test
    void manager_hasNode() {
        when(dynNodeManager.hasNode(NODE_ID_REAL)).thenReturn(true);
        assertThat(adaptor.hasNode(new NodeId(NS_INDEX, NODE_ID_REAL))).isTrue();
    }

    @Test
    void manager_hasNode_not() {
        when(dynNodeManager.hasNode(NODE_ID_REAL)).thenReturn(false);
        assertThat(adaptor.hasNode(new NodeId(NS_INDEX, NODE_ID_REAL))).isFalse();
    }

    @Test
    void manager_hasNode_not_different_namespace() {
        assertThat(adaptor.hasNode(new NodeId(NS_INDEX + 1, NODE_ID_REAL))).isFalse();
    }

    @Test
    void manager_hasNode_not_identifier_different_from_string() {
        assertThat(adaptor.hasNode(new NodeId(NS_INDEX, 123))).isFalse();
    }

    @Test
    void manager_getBrowseName() {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.browseName(new DynRequest(null, NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynQualifiedName("TestBrowseName")));

        var res = adaptor.getBrowseName(new ExpandedNodeId(null, NS_INDEX, NODE_ID), null);
        assertThat(res.getName()).isEqualTo("TestBrowseName");
    }

    @Test
    void manager_getDisplayName() {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.displayName(new DynRequest(null, NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynLocalizedText("TestDisplayName")));

        var res = adaptor.getDisplayName(new ExpandedNodeId(null, NS_INDEX, NODE_ID), null, null);
        assertThat(res.getText()).isEqualTo("TestDisplayName");
    }

    @Test
    void manager_getNodeClass() {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.nodeClass(new DynRequest(null, NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, DynAttributes.NodeClasses.Object));

        var res = adaptor.getNodeClass(new NodeId(NS_INDEX, NODE_ID), null);
        assertThat(res).isEqualTo(NodeClass.Object);
    }

    @Test
    void manager_getTypeDefinition() {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNode.references()).thenReturn(dynReferenceManager);
        when(dynReferenceManager.byTypeSingle(DynReferences.Types.HasTypeDefinition, new DynRequest(null, NODE_ID)))
                .thenReturn(Optional.of(new DynReference(DynReferences.Types.HasTypeDefinition,
                        new RealNodeId(NS_INDEX, NODE_ID),
                        new RealNodeId(0, 999))));

        var res = adaptor.getTypeDefinition(new ExpandedNodeId(null, NS_INDEX, NODE_ID), null);
        assertThat(res).isEqualTo(new ExpandedNodeId(null, 0, 999));
    }

    @Test
    void manager_getVariableDataType() throws StatusException {
        var res = adaptor.getVariableDataType(new NodeId(NS_INDEX, NODE_ID), null);
        assertThat(res).isNull();
    }

    @Test
    void ioManager_readNonValue_Bad() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.nodeId(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Bad, null));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.NodeId, null, DateTime.currentTime());
        assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Bad);
    }

    @Test
    void ioManager_readValue_Good() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead}));
        when(dynAttributeManager.value(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, "TestValue"));


        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Value, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo("TestValue")
        );
    }

    @Test
    void ioManager_readValue_access_denied() {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Bad, null));

        assertThrows(StatusException.class, () -> adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Value, null, DateTime.currentTime()));
    }

    @Test
    void ioManager_readValue_insufficient_rights() {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.StatusWrite}));

        assertThrows(StatusException.class, () -> adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Value, null, DateTime.currentTime()));
    }

    @Test
    void ioManager_readAttribute_NodeId() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.nodeId(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new RealNodeId(NODE_ID_REAL)));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.NodeId, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(new NodeId(NS_INDEX, NODE_ID_REAL))
        );
    }

    @Test
    void ioManager_readAttribute_NodeClass() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.nodeClass(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, DynAttributes.NodeClasses.Variable));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.NodeClass, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue())
        );
    }

    @Test
    void ioManager_readAttribute_BrowseName() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.browseName(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynQualifiedName("TestBrowseName")));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.BrowseName, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((QualifiedName) dataValue.getValue().getValue()).getName()).isEqualTo("TestBrowseName")
        );
    }

    @Test
    void ioManager_readAttribute_DisplayName() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.displayName(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynLocalizedText("TestDisplayName")));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.DisplayName, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((LocalizedText) dataValue.getValue().getValue()).getText()).isEqualTo("TestDisplayName")
        );
    }

    @Test
    void ioManager_readAttribute_Description() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.description(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynLocalizedText("TestDescription")));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Description, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((LocalizedText) dataValue.getValue().getValue()).getText()).isEqualTo("TestDescription")
        );
    }

    @Test
    void ioManager_readAttribute_AccessLevel() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.AccessLevel, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(AccessLevelType.of(AccessLevelType.Options.CurrentRead).getValue())
        );
    }

    @Test
    void ioManager_readAttribute_UserAccessLevel() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.userAccessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserAccessLevel, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(AccessLevelType.of(AccessLevelType.Options.CurrentRead).getValue())
        );
    }

    @Test
    void ioManager_readAttribute_UserAccessLevel_is_retained_by_AccessLevel() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentWrite}));
        when(dynAttributeManager.userAccessLevel(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevels[]{DynAttributes.AccessLevels.CurrentRead}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserAccessLevel, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(AccessLevelType.of(/*empty*/).getValue())
        );
    }

    @Test
    void ioManager_readAttribute_Executable() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Executable, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void ioManager_readAttribute_Executable2() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, false));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Executable, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(false)
        );
    }

    @Test
    void ioManager_readAttribute_UserExecutable() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));
        when(dynAttributeManager.isUserExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserExecutable, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void ioManager_readAttribute_UserExecutable_respects_Executable() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, false));
        when(dynAttributeManager.isUserExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserExecutable, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(false)
        );
    }

    @Test
    void ioManager_readAttribute_UserExecutable_respects_Executable2() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Bad, null));
        when(dynAttributeManager.isUserExecutable(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserExecutable, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(false)
        );
    }

    @Test
    void ioManager_readAttribute_WriteMask() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.writeMask(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, 0b0001_0001));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.WriteMask, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((UnsignedInteger) dataValue.getValue().getValue()).getValue()).isEqualTo(0b0001_0001)
        );
    }

    @Test
    void ioManager_readAttribute_UserWriteMask() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.writeMask(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, 0b1111_1111));
        when(dynAttributeManager.userWriteMask(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, 0b0001_0001));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserWriteMask, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((UnsignedInteger) dataValue.getValue().getValue()).getValue()).isEqualTo(0b0001_0001)
        );
    }

    @Test
    void ioManager_readAttribute_UserWriteMask_respects_WriteMask() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.writeMask(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, 0b0001_0001));
        when(dynAttributeManager.userWriteMask(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, 0b0000_1111));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.UserWriteMask, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((UnsignedInteger) dataValue.getValue().getValue()).getValue()).isEqualTo(0b0000_0001)
        );
    }

    @Test
    void ioManager_readAttribute_IsAbstract() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isAbstract(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.IsAbstract, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void ioManager_readAttribute_Symmetric() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isSymmetric(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Symmetric, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void ioManager_readAttribute_InverseName() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.inverseName(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, "TestInverseName"));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.InverseName, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(((LocalizedText) dataValue.getValue().getValue()).getText()).isEqualTo("TestInverseName")
        );
    }

    @Test
    void ioManager_readAttribute_ContainsNoLoops() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.containsNoLoops(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.ContainsNoLoops, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void ioManager_readAttribute_EventNotifier() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.eventNotifier(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.EventNotifiers[]{DynAttributes.EventNotifiers.SubscribeToEvents}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.EventNotifier, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(EventNotifierType.of(EventNotifierType.Options.SubscribeToEvents).getValue())
        );
    }

    @Test
    void ioManager_readAttribute_DataType() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.dataType(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new RealNodeId(999, 123)));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.DataType, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(new NodeId(999, 123))
        );
    }

    @Test
    void ioManager_readAttribute_ValueRank() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.valueRank(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, DynAttributes.ValueRanks.OneDimension));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.ValueRank, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(ValueRanks.OneDimension)
        );
    }

    @Test
    void ioManager_readAttribute_ArrayDimensions() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.arrayDimensions(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new Integer[]{123, 456}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.ArrayDimensions, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(UnsignedInteger.arrayOf(123, 456))
        );
    }

    @Test
    void ioManager_readAttribute_MinimumSamplingInterval() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.minimumSamplingInterval(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, 12.3));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.MinimumSamplingInterval, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(12.3)
        );
    }

    @Test
    void ioManager_readAttribute_Historizing() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.isHistorizing(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, true));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.Historizing, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void ioManager_readAttribute_DataTypeDefinition() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.dataTypeDefinition(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, "TestDataTypeDefinition"));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.DataTypeDefinition, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo("TestDataTypeDefinition")
        );
    }

    @Test
    void ioManager_readAttribute_AccessRestrictions() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessRestrictions(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessRestrictions[]{DynAttributes.AccessRestrictions.EncryptionRequired}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.AccessRestrictions, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(AccessRestrictionType.of(AccessRestrictionType.Options.EncryptionRequired).getValue())
        );
    }

    @Test
    void ioManager_readAttribute_AccessLevelEx() throws StatusException {
        when(dynNodeManager.findNode(NODE_ID)).thenReturn(Optional.of(dynNode));
        when(dynNodeManager.canBrowse(any())).thenReturn(true);
        when(dynNode.attributes()).thenReturn(dynAttributeManager);
        when(dynAttributeManager.accessLevelEx(new DynRequest(any(), NODE_ID)))
                .thenReturn(new DynResponse<>(DynResponse.StatusCodes.Good, new DynAttributes.AccessLevelExs[]{DynAttributes.AccessLevelExs.NonatomicRead}));

        var dataValue = adaptor.getIoManager().readAttribute(
                new NodeId(NS_INDEX, NODE_ID), Attributes.AccessLevelEx, null, DateTime.currentTime());
        assertAll(
                () -> assertThat(dataValue.getStatusCode().getValue()).isEqualTo(StatusCodes.Good),
                () -> assertThat(dataValue.getValue().getValue()).isEqualTo(AccessLevelExType.of(AccessLevelExType.Options.NonatomicRead).getValue())
        );
    }

    @Test
    void listener_onGetReferences() {
        when(mockServiceContext.getSession()).thenReturn(mockSession);
        when(dynNodeManager.assignedChildren(any(), any())).thenReturn(List.of(
                new DynReference(DynReferences.Types.HasTypeDefinition, new RealNodeId(NS_INDEX, NODE_ID_REAL), new RealNodeId(0, 999))));

        var listener = adaptor.new DynamicNodeManagerListener();
        var references = new ArrayList<UaReference>();

        listener.onGetReferences(mockServiceContext, null, new NodeId(NS_INDEX, NODE_ID_REAL), null, references);

        assertAll(
                () -> assertThat(references).hasSize(1),
                () -> assertThat(references.get(0).getReferenceTypeId()).isEqualTo(Identifiers.HasTypeDefinition),
                () -> assertThat(references.get(0).getSourceId()).isEqualTo(new ExpandedNodeId(null, NS_INDEX, NODE_ID_REAL)),
                () -> assertThat(references.get(0).getTargetId()).isEqualTo(new ExpandedNodeId(null, 0, 999))
        );
    }

    @Test
    void listener_onBrowseNode() {
        when(mockServiceContext.getSession()).thenReturn(mockSession);
        when(dynNodeManager.hasNode(NODE_ID_REAL)).thenReturn(true);
        when(dynNodeManager.canBrowse(any())).thenReturn(true);

        var listener = adaptor.new DynamicNodeManagerListener();

        var canBrowse = listener.onBrowseNode(mockServiceContext, null, new NodeId(NS_INDEX, NODE_ID_REAL), null, null);

        assertThat(canBrowse).isTrue();
    }

    @Test
    void listener_onBrowseNode_has_not_node() {
        when(dynNodeManager.hasNode(NODE_ID_REAL)).thenReturn(false);

        var listener = adaptor.new DynamicNodeManagerListener();

        var canBrowse = listener.onBrowseNode(mockServiceContext, null, new NodeId(NS_INDEX, NODE_ID_REAL), null, null);

        assertThat(canBrowse).isTrue();
    }

    @Test
    void listener_onBrowseNode_cannot_find_node() {
        when(mockServiceContext.getSession()).thenReturn(mockSession);
        when(dynNodeManager.hasNode(NODE_ID_REAL)).thenReturn(true);

        var listener = adaptor.new DynamicNodeManagerListener();

        var canBrowse = listener.onBrowseNode(mockServiceContext, null, new NodeId(NS_INDEX, NODE_ID_REAL), null, null);

        assertThat(canBrowse).isFalse();
    }

    @Test
    void listener_onBrowseNode_cannot_browse() {
        when(mockServiceContext.getSession()).thenReturn(mockSession);
        when(dynNodeManager.hasNode(NODE_ID_REAL)).thenReturn(true);
        when(dynNodeManager.canBrowse(any())).thenReturn(false);

        var listener = adaptor.new DynamicNodeManagerListener();

        var canBrowse = listener.onBrowseNode(mockServiceContext, null, new NodeId(NS_INDEX, NODE_ID_REAL), null, null);

        assertThat(canBrowse).isFalse();
    }
}
