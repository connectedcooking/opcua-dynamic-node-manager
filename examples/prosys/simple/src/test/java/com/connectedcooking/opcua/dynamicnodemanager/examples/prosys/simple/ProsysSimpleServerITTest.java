package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.simple;

import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.UserIdentity;
import com.prosysopc.ua.client.UaClient;
import com.prosysopc.ua.stack.builtintypes.*;
import com.prosysopc.ua.stack.core.*;
import com.prosysopc.ua.stack.transport.security.SecurityMode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProsysSimpleServerITTest {

    private static final String USERNAME = "123";   // will generate three devices
    private static final String PASSWORD = "Secret123!";

    private static ProsysSimpleServer server;
    private static UaClient client;

    @BeforeAll
    static void setup() throws Exception {
        // create server
        server = new ProsysSimpleServer(4841);
        server.start();

        // create client
        client = new UaClient("opc.tcp://127.0.0.1:4841/OPCUA/Simple");
        client.setApplicationIdentity(new ApplicationIdentity());
        client.setSecurityMode(SecurityMode.NONE);
        client.setUserIdentity(new UserIdentity(USERNAME, PASSWORD));
    }

    @BeforeEach
    void connect() throws ServiceException {
        client.connect();
    }

    @AfterEach
    void disconnect() {
        if (client.isConnected()) {
            client.disconnect();
        }
    }

    @Test
    void reads_server_node() throws Exception {
        DataValue value = client.readValue(Identifiers.Server_ServerStatus_State);

        assertThat(value.getStatusCode().getValue()).isEqualTo(StatusCodes.Good);
    }

    @Test
    void reads_namespace() {
        var namespaces = client.getNamespaceTable();
        var index = namespaces.getIndex(ProsysSimpleServer.NAMESPACE_URI);

        assertThat(index).isEqualTo(2);
    }

    @Test
    void reads_objects_node() throws Exception {
        var node = client.getAddressSpace().getNode(ObjectIdentifiers.ObjectsFolder);
        assertThat(node.getBrowseName().getName()).isEqualTo("Objects");
    }

    @Test
    void browses_objects_node() throws Exception {
        var references = client.getAddressSpace().browse(ObjectIdentifiers.ObjectsFolder);

        assertThat(references).hasSize(4);

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).contains("Server", "Aliases", "DeviceSet", "Locations");
    }

    @Test
    void browses_deviceSet_node() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(server.getNsIndex(), "DeviceSet"));

        assertThat(references).hasSize(3);

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).contains("Device_1", "Device_2", "Device_3");
    }

    @Test
    void reads_device_attributes_NodeClass() throws Exception {
        var nodeClass = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1"), Attributes.NodeClass);

        assertAll(
                () -> assertThat(nodeClass.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Object.getValue())
        );
    }

    @Test
    void reads_device_attributes() throws Exception {
        var browseName = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1"), Attributes.BrowseName);

        assertAll(
                () -> assertThat(browseName.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("Device_1")
        );
    }

    @Test
    void browses_device_node() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(server.getNsIndex(), "Device_1"));

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).containsExactlyInAnyOrder(
                "SerialNumber", "BooleanNode", "ByteNode", "ShortNode", "IntegerNode", "FloatNode", "DoubleNode", "GuiNode", "BytesNode", "LocalDateTimeNode", "ZonedDateTimeNode", "LocalDateNode", "DurationNode", "DateNode");
    }

    @Test
    void cannot_browses_device_node_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(server.getNsIndex(), "Device_4"));
        assertThat(references).isEmpty();
    }

    @Test
    void cannot_browses_device_node_attributes() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(server.getNsIndex(), "Device4"), Attributes.BrowseName));
    }

    @Test
    void cannot_browses_device_node_attributes2() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(server.getNsIndex(), "Device4"), Attributes.DisplayName));
    }

    @Test
    void cannot_browses_device_node_attributes3() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(server.getNsIndex(), "Device4"), Attributes.DataType));
    }

    @Test
    void cannot_browses_device_subnode_attributes() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(server.getNsIndex(), "Device4/SerialNumber"), Attributes.BrowseName));
    }

    @Test
    void cannot_browses_device_subnode_attributes2() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(server.getNsIndex(), "Device4/SerialNumber"), Attributes.DisplayName));
    }

    @Test
    void cannot_browses_device_subnode_attributes3() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(server.getNsIndex(), "Device4/SerialNumber"), Attributes.DataType));
    }

    @Test
    void cannot_browses_device_subnode_value() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readValue(new NodeId(server.getNsIndex(), "Device4/SerialNumber")));
    }

    @Test
    void reads_serialNumber_value_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/SerialNumber"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String)
        );
    }

    @Test
    void reads_serialNumber_attributes() throws Exception {
        var browseName = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/SerialNumber"), Attributes.BrowseName);

        assertAll(
                () -> assertThat(browseName.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("SerialNumber")
        );
    }

    @Test
    void reads_serialNumber_user_attributes() throws Exception {
        var userAccessLevel = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/SerialNumber"), Attributes.UserAccessLevel);

        assertAll(
                () -> assertThat(userAccessLevel.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(userAccessLevel.getValue().getValue()).isEqualTo(
                        AccessLevelType.of(AccessLevelType.Options.CurrentRead, AccessLevelType.Options.CurrentWrite).getValue())
        );
    }

    @Test
    void reads_serialNumber_attributes_NodeClass() throws Exception {
        var nodeClass = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/SerialNumber"), Attributes.NodeClass);

        assertAll(
                () -> assertThat(nodeClass.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue())
        );
    }

    @Test
    void reads_serialNumber_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_2/SerialNumber"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo("SERNUM2")
        );
    }

    @Test
    void writes_serialNumber_value() throws Exception {
        var writeValue = client.writeValue(new NodeId(server.getNsIndex(), "Device_3/SerialNumber"), "UPDATED3");
        assertThat(writeValue).isTrue();

        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_3/SerialNumber"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo("UPDATED3")
        );
    }

    @Test
    void reads_booleanNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/BooleanNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void reads_booleanNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/BooleanNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Boolean)
        );
    }

    @Test
    void reads_byteNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/ByteNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(Byte.MAX_VALUE)
        );
    }

    @Test
    void reads_byteNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/ByteNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Byte)
        );
    }

    @Test
    void reads_shortNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/ShortNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(Short.MAX_VALUE)
        );
    }

    @Test
    void reads_shortNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/ShortNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Int16)
        );
    }

    @Test
    void reads_integerNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/IntegerNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(Integer.MAX_VALUE)
        );
    }

    @Test
    void reads_integerNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/IntegerNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Int32)
        );
    }

    @Test
    void reads_floatNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/FloatNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(Float.MAX_VALUE)
        );
    }

    @Test
    void reads_floatNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/FloatNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Float)
        );
    }

    @Test
    void reads_doubleNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/DoubleNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(Double.MAX_VALUE)
        );
    }

    @Test
    void reads_doubleNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/DoubleNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Double)
        );
    }

    @Test
    void reads_guiNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/GuiNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(UUID.fromString("8598c388-a1d1-4608-a0a2-0eb5d42c1099"))
        );
    }

    @Test
    void reads_guiNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/GuiNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Guid)
        );
    }

    @Test
    void reads_bytesNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/BytesNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(((ByteString) value.getValue().getValue()).getValue()).isEqualTo("abc".getBytes())
        );
    }

    @Test
    void reads_bytesNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/BytesNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.ByteString)
        );
    }

    @Test
    void reads_localDateTimeNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/LocalDateTimeNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(LocalDateTime.ofInstant(((DateTime) value.getValue().getValue()).toInstant(), ZoneId.systemDefault())).isEqualTo(
                        LocalDateTime.of(2022, 06, 03, 11, 25, 01, 00))
        );
    }

    @Test
    void reads_localDateTimeNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/LocalDateTimeNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.DateTime)
        );
    }

    @Test
    void reads_zonedDateTimeNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/ZonedDateTimeNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(ZonedDateTime.ofInstant(((DateTime) value.getValue().getValue()).toInstant(), ZoneId.systemDefault())).isEqualTo(
                        ZonedDateTime.of(2022, 06, 03, 11, 25, 01, 00, ZoneId.of("Europe/Berlin")))
        );
    }

    @Test
    void reads_zonedDateTimeNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/ZonedDateTimeNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.UtcTime)
        );
    }

    @Test
    void reads_localDateNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/LocalDateNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(LocalDate.ofInstant(((DateTime) value.getValue().getValue()).toInstant(), ZoneId.systemDefault())).isEqualTo(
                        LocalDate.of(2022, 06, 03))
        );
    }

    @Test
    void reads_localDateNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/LocalDateNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.DateTime)
        );
    }

    @Test
    void reads_durationNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/DurationNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(value.getValue().getValue()).isEqualTo(123000.0)   // in milliseconds
        );
    }

    @Test
    void reads_durationNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/DurationNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Duration)
        );
    }

    @Test
    void reads_dateNode_value() throws Exception {
        var value = client.readValue(new NodeId(server.getNsIndex(), "Device_1/DateNode"));

        assertAll(
                () -> assertThat(value.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(((DateTime) value.getValue().getValue()).getTimeInMillis()).isEqualTo(new Date(123456789000L).getTime())
        );
    }

    @Test
    void reads_dateNode_attribute_dataType() throws Exception {
        var dataType = client.readAttribute(new NodeId(server.getNsIndex(), "Device_1/DateNode"), Attributes.DataType);

        assertAll(
                () -> assertThat(dataType.getStatusCode().getValue().getValue()).isEqualTo(StatusCodes.Good.getValue()),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.DateTime)
        );
    }
}
