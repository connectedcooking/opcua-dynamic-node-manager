package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200;

import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.UserIdentity;
import com.prosysopc.ua.client.UaClient;
import com.prosysopc.ua.stack.builtintypes.*;
import com.prosysopc.ua.stack.core.*;
import com.prosysopc.ua.stack.transport.security.SecurityMode;
import com.prosysopc.ua.types.opcua.ReferenceTypeIds;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProsysOpc30200ServerITTest {

    private static final int NS_DI = 2;
    private static final int NS_CKE = 3;
    private static final int NS = 4;

    private static final String USERNAME = "123";   // will generate three devices
    private static final String PASSWORD = "Secret123!";

    private static UaClient client;

    @BeforeAll
    static void setup() throws Exception {
        // create server
        var server = new ProsysOpc30200Server(4842);
        server.start();

        // create client
        client = new UaClient("opc.tcp://127.0.0.1:4842/OPCUA/CKE");
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
    void reads_objects_node() throws Exception {
        var node = client.getAddressSpace().getNode(ObjectIdentifiers.ObjectsFolder);
        assertThat(node.getBrowseName().getName()).isEqualTo("Objects");
    }

    @Test
    void reads_namespaces() {
        var namespaces = client.getNamespaceTable();
        var index = namespaces.getIndex(ProsysOpc30200Server.NAMESPACE_URI);
        var di = namespaces.getIndex("http://opcfoundation.org/UA/DI/");
        var cke = namespaces.getIndex("http://opcfoundation.org/UA/CommercialKitchenEquipment/");

        assertAll(
                () -> assertThat(index).isEqualTo(NS),
                () -> assertThat(di).isEqualTo(NS_DI),
                () -> assertThat(cke).isEqualTo(NS_CKE)
        );
    }

    @Test
    void browses_objects_node() throws Exception {
        var references = client.getAddressSpace().browse(ObjectIdentifiers.ObjectsFolder);

        var displayNames = references.stream()
                .map(ReferenceDescription::getDisplayName)
                .map(LocalizedText::getText)
                .collect(Collectors.toSet());
        assertThat(displayNames).containsExactlyInAnyOrder("Server", "Aliases", "DeviceSet", "NetworkSet", "DeviceTopology", "Locations");
    }

    @Test
    void DeviceSet_hasComponents() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS_DI, 5001));

        var browseNames = references.stream()
                .map(ReferenceDescription::getBrowseName)
                .map(QualifiedName::getName)
                .collect(Collectors.toSet());
        assertThat(browseNames).contains("CombiSteamerDevice_1", "CombiSteamerDevice_2", "CombiSteamerDevice_3");
    }

    @Test
    void CombiSteamerDevice_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(NS_CKE, 1011)));
    }

    @Test
    void CombiSteamerDevice_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1"));

        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/ErrorConditions"), new NodeId(0, 58), references)).isTrue().describedAs("ErrorConditions");
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/InformationConditions"), new NodeId(0, 58), references)).isTrue().describedAs("InformationConditions");
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer"), new NodeId(NS_CKE, 1010), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/EnergySource"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/IsWithAutomaticCleaning"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/IsWithExternalCoreTempSensor"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/IsWithInternalCoreTempSensor"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/IsWithSousvideTempSensor"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/DeviceClass"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/Manufacturer"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/Model"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/HardwareRevision"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/SoftwareRevision"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/DeviceRevision"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/DeviceManual"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/SerialNumber"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
        assertThat(containsReference(ReferenceTypeIds.HasProperty, new NodeId(NS, "CombiSteamerDevice_1/RevisionCounter"), new NodeId(0, 68), references)).isTrue().describedAs("CombiSteamer");
    }

    @Test
    void CombiSteamerDevice_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Object.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("CombiSteamerDevice_1"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("Test Device 1"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo("")
        );
    }

    @Test
    void EnergySource_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/EnergySource"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void EnergySource_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/EnergySource"));

        assertThat(references).isEmpty();
    }

    @Test
    void EnergySource_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/EnergySource");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("EnergySource"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("EnergySource"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(new NodeId(NS_CKE, 3002)),
                () -> assertThat(value.getValue().getValue()).isEqualTo(1)
        );
    }

    @Test
    void IsWithAutomaticCleaning_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/IsWithAutomaticCleaning"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void IsWithAutomaticCleaning_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/IsWithAutomaticCleaning"));

        assertThat(references).isEmpty();
    }

    @Test
    void IsWithAutomaticCleaning_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/IsWithAutomaticCleaning");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("IsWithAutomaticCleaning"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("IsWithAutomaticCleaning"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Boolean),
                () -> assertThat(value.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void IsWithExternalCoreTempSensor_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/IsWithExternalCoreTempSensor"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void IsWithExternalCoreTempSensor_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/IsWithExternalCoreTempSensor"));

        assertThat(references).isEmpty();
    }

    @Test
    void IsWithExternalCoreTempSensor_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/IsWithExternalCoreTempSensor");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("IsWithExternalCoreTempSensor"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("IsWithExternalCoreTempSensor"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Boolean),
                () -> assertThat(value.getValue().getValue()).isEqualTo(false)
        );
    }

    @Test
    void IsWithInternalCoreTempSensor_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/IsWithInternalCoreTempSensor"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void IsWithInternalCoreTempSensor_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/IsWithInternalCoreTempSensor"));

        assertThat(references).isEmpty();
    }

    @Test
    void IsWithInternalCoreTempSensor_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/IsWithInternalCoreTempSensor");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("IsWithInternalCoreTempSensor"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("IsWithInternalCoreTempSensor"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Boolean),
                () -> assertThat(value.getValue().getValue()).isEqualTo(false)
        );
    }

    @Test
    void IsWithSousvideTempSensor_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/IsWithSousvideTempSensor"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void IsWithSousvideTempSensor_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/IsWithSousvideTempSensor"));

        assertThat(references).isEmpty();
    }

    @Test
    void IsWithSousvideTempSensor_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/IsWithSousvideTempSensor");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("IsWithSousvideTempSensor"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("IsWithSousvideTempSensor"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Boolean),
                () -> assertThat(value.getValue().getValue()).isEqualTo(false)
        );
    }

    @Test
    void DeviceClass_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/DeviceClass"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void DeviceClass_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/DeviceClass"));

        assertThat(references).isEmpty();
    }

    @Test
    void DeviceClass_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/DeviceClass");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("1:DeviceClass"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("DeviceClass"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String),
                () -> assertThat(value.getValue().getValue()).isEqualTo("Combi Steamer")
        );
    }

    @Test
    void Manufacturer_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/Manufacturer"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void Manufacturer_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/Manufacturer"));

        assertThat(references).isEmpty();
    }

    @Test
    void Manufacturer_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/Manufacturer");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("Manufacturer"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("Manufacturer"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.LocalizedText),
                () -> assertThat(((LocalizedText) value.getValue().getValue()).getText()).isEqualTo("Test Manufacturer")
        );
    }

    @Test
    void Model_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/Model"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void Model_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/Model"));

        assertThat(references).isEmpty();
    }

    @Test
    void Model_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/Model");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("Model"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("Model"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.LocalizedText),
                () -> assertThat(((LocalizedText)value.getValue().getValue()).getText()).isEqualTo("Test Model")
        );
    }

    @Test
    void HardwareRevision_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/HardwareRevision"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void HardwareRevision_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/HardwareRevision"));

        assertThat(references).isEmpty();
    }

    @Test
    void HardwareRevision_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/HardwareRevision");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("HardwareRevision"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("HardwareRevision"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String),
                () -> assertThat(value.getValue().getValue()).isEqualTo("Test HardwareRevision")
        );
    }

    @Test
    void SoftwareRevision_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/SoftwareRevision"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void SoftwareRevision_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/SoftwareRevision"));

        assertThat(references).isEmpty();
    }

    @Test
    void SoftwareRevision_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/SoftwareRevision");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("SoftwareRevision"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("SoftwareRevision"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String),
                () -> assertThat(value.getValue().getValue()).isEqualTo("Test SoftwareRevision")
        );
    }

    @Test
    void DeviceRevision_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/DeviceRevision"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void DeviceRevision_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/DeviceRevision"));

        assertThat(references).isEmpty();
    }

    @Test
    void DeviceRevision_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/DeviceRevision");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("DeviceRevision"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("DeviceRevision"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String),
                () -> assertThat(value.getValue().getValue()).isEqualTo("Test DeviceRevision")
        );
    }

    @Test
    void DeviceManual_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/DeviceManual"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void DeviceManual_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/DeviceManual"));

        assertThat(references).isEmpty();
    }

    @Test
    void DeviceManual_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/DeviceManual");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("DeviceManual"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("DeviceManual"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String),
                () -> assertThat(value.getValue().getValue()).isEqualTo("Test DeviceManual")
        );
    }

    @Test
    void SerialNumber_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/SerialNumber"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void SerialNumber_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/SerialNumber"));

        assertThat(references).isEmpty();
    }

    @Test
    void SerialNumber_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/SerialNumber");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("SerialNumber"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("SerialNumber"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.String),
                () -> assertThat(value.getValue().getValue()).isEqualTo("SERNUM1")
        );
    }

    @Test
    void RevisionCounter_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/RevisionCounter"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 68)));
    }

    @Test
    void RevisionCounter_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/RevisionCounter"));

        assertThat(references).isEmpty();
    }

    @Test
    void RevisionCounter_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/RevisionCounter");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("RevisionCounter"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("RevisionCounter"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Int32),
                () -> assertThat(value.getValue().getValue()).isEqualTo(123)
        );
    }

    @Test
    void ErrorConditions_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/ErrorConditions"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 58)));
    }

    @Test
    void ErrorConditions_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/ErrorConditions"));

        assertThat(references).isEmpty();
    }

    @Test
    void ErrorConditions_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/ErrorConditions");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Object.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("ErrorConditions"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("ErrorConditions"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo("")
        );
    }

    @Test
    void InformationConditions_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/InformationConditions"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 58)));
    }

    @Test
    void InformationConditions_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/InformationConditions"));

        assertThat(references).isEmpty();
    }

    @Test
    void InformationConditions_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/InformationConditions");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Object.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("InformationConditions"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("InformationConditions"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo("")
        );
    }

    @Test
    void CombiSteamer_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(NS_CKE, 1010)));
    }

    @Test
    void CombiSteamer_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer"));

        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_0"), new NodeId(0, 2368), references)).isTrue();
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_1"), new NodeId(0, 2368), references)).isTrue();
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/CombiSteamerMode"), new NodeId(0, 63), references)).isTrue();
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/IsDoorOpen"), new NodeId(0, 63), references)).isTrue();
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetProcessTimeProgram"), new NodeId(0, 2368), references)).isTrue();
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetTemperature"), new NodeId(0, 2368), references)).isTrue();
        assertThat(containsReference(ReferenceTypeIds.HasComponent, new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/TimeRemainingProgram"), new NodeId(0, 2368), references)).isTrue();
    }

    @Test
    void CombiSteamer_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Object.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("CombiSteamer"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("CombiSteamer"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo("")
        );
    }

    @Test
    void CombiSteamer_ActualTemperatureChamber_0_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_0"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 2368)));
    }

    @Test
    void CombiSteamer_ActualTemperatureChamber_0_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_0"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_ActualTemperatureChamber_0_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_0");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("ActualTemperatureChamber_0"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("ActualTemperatureChamber_0"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Float),
                () -> assertThat(value.getValue().getValue()).isEqualTo(12.3f)
        );
    }

    @Test
    void CombiSteamer_ActualTemperatureChamber_1_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_1"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 2368)));
    }

    @Test
    void CombiSteamer_ActualTemperatureChamber_1_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_1"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_ActualTemperatureChamber_1_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_1");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("ActualTemperatureChamber_1"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("ActualTemperatureChamber_1"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Float),
                () -> assertThat(value.getValue().getValue()).isEqualTo(12.3f * 2)
        );
    }

    @Test
    @Disabled
    void CombiSteamer_ActualTemperatureChamber_X_attributes_cannot_read() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/ActualTemperatureChamber_2");

        assertThrows(StatusException.class, () -> client.readAttribute(browseId, Attributes.NodeId));
    }

    @Test
    void CombiSteamer_CombiSteamerMode_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/CombiSteamerMode"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 63)));
    }

    @Test
    void CombiSteamer_CombiSteamerMode_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/CombiSteamerMode"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_CombiSteamerMode_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/CombiSteamerMode");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("CombiSteamerMode"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("CombiSteamerMode"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(new NodeId(NS_CKE, 3006)),
                () -> assertThat(value.getValue().getValue()).isEqualTo(1)
        );
    }

    @Test
    void CombiSteamer_IsDoorOpen_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/IsDoorOpen"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 63)));
    }

    @Test
    void CombiSteamer_IsDoorOpen_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/IsDoorOpen"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_IsDoorOpen_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/IsDoorOpen");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("IsDoorOpen"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("IsDoorOpen"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Boolean),
                () -> assertThat(value.getValue().getValue()).isEqualTo(true)
        );
    }

    @Test
    void CombiSteamer_SetProcessTimeProgram_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetProcessTimeProgram"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 2368)));
    }

    @Test
    void CombiSteamer_SetProcessTimeProgram_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetProcessTimeProgram"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_SetProcessTimeProgram_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetProcessTimeProgram");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("SetProcessTimeProgram"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("SetProcessTimeProgram"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Int32),
                () -> assertThat(value.getValue().getValue()).isEqualTo(789)
        );
    }

    @Test
    void CombiSteamer_SetTemperature_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetTemperature"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 2368)));
    }

    @Test
    void CombiSteamer_SetTemperature_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetTemperature"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_SetTemperature_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/SetTemperature");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("SetTemperature"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("SetTemperature"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Float),
                () -> assertThat(value.getValue().getValue()).isEqualTo(741.123f)
        );
    }

    @Test
    void CombiSteamer_TimeRemainingProgram_TypeDefinition() throws Exception {
        var typeDefinition = client.getAddressSpace().getTypeDefinition(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/TimeRemainingProgram"));

        assertThat(typeDefinition).isEqualTo(new ExpandedNodeId(new NodeId(0, 2368)));
    }

    @Test
    void CombiSteamer_TimeRemainingProgram_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/TimeRemainingProgram"));

        assertThat(references).isEmpty();
    }

    @Test
    void CombiSteamer_TimeRemainingProgram_attributes() throws Exception {
        var browseId = new NodeId(NS, "CombiSteamerDevice_1/CombiSteamer/TimeRemainingProgram");

        var nodeId = client.readAttribute(browseId, Attributes.NodeId);
        var nodeClass = client.readAttribute(browseId, Attributes.NodeClass);
        var browseName = client.readAttribute(browseId, Attributes.BrowseName);
        var displayName = client.readAttribute(browseId, Attributes.DisplayName);
        var description = client.readAttribute(browseId, Attributes.Description);
        var dataType = client.readAttribute(browseId, Attributes.DataType);
        var value = client.readAttribute(browseId, Attributes.Value);

        assertAll(
                () -> assertThat(nodeId.getValue().getValue()).isEqualTo(browseId),
                () -> assertThat(nodeClass.getValue().getValue()).isEqualTo(NodeClass.Variable.getValue()),
                () -> assertThat(((QualifiedName) browseName.getValue().getValue()).getName()).isEqualTo("TimeRemainingProgram"),
                () -> assertThat(((LocalizedText) displayName.getValue().getValue()).getText()).isEqualTo("TimeRemainingProgram"),
                () -> assertThat(((LocalizedText) description.getValue().getValue()).getText()).isEqualTo(""),
                () -> assertThat(dataType.getValue().getValue()).isEqualTo(DataTypeIdentifiers.Int32),
                () -> assertThat(value.getValue().getValue()).isEqualTo(852)
        );
    }

    @Test
    void cannot_browses_device_node_references() throws Exception {
        var references = client.getAddressSpace().browse(new NodeId(NS, "CombiSteamerDevice_4"));
        assertThat(references).isEmpty();
    }

    @Test
    void cannot_browses_device_node_attributes() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(NS, "CombiSteamerDevice_4"), Attributes.BrowseName));
    }

    @Test
    void cannot_browses_device_node_attributes2() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(NS, "CombiSteamerDevice_4"), Attributes.DisplayName));
    }

    @Test
    void cannot_browses_device_node_attributes3() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(NS, "CombiSteamerDevice_4"), Attributes.DataType));
    }

    @Test
    void cannot_browses_device_subnode_attributes() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(NS, "CombiSteamerDevice_4/SerialNumber"), Attributes.BrowseName));
    }

    @Test
    void cannot_browses_device_subnode_attributes2() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(NS, "CombiSteamerDevice_4/SerialNumber"), Attributes.DisplayName));
    }

    @Test
    void cannot_browses_device_subnode_attributes3() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readAttribute(new NodeId(NS, "CombiSteamerDevice_4/SerialNumber"), Attributes.DataType));
    }

    @Test
    void cannot_browses_device_subnode_value() throws Exception {
        assertThrows(StatusException.class, () ->
                client.readValue(new NodeId(NS, "CombiSteamerDevice_4/SerialNumber")));
    }

    private boolean containsReference(ExpandedNodeId referenceTypeId, NodeId nodeId, NodeId typeDefinition, List<ReferenceDescription> references) {
        return references.stream().anyMatch(r -> r.getReferenceTypeId().equals(referenceTypeId)
                && r.getNodeId().equals(nodeId) && r.getTypeDefinition().equals(typeDefinition));
    }
}
