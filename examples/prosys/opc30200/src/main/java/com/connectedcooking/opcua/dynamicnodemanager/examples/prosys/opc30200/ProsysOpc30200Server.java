package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200;

import com.connectedcooking.opcua.dynamicnodemanager.adaptor.prosys.ProsysDynNodeManagerAdaptor;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynNodeManager;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;
import com.connectedcooking.opcua.dynamicnodemanager.core.datatype.DynLocalizedText;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.server.CommercialKitchenEquipmentServerInformationModel;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.server.DIServerInformationModel;
import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.UserTokenPolicies;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.core.ApplicationDescription;
import com.prosysopc.ua.stack.core.ApplicationType;
import com.prosysopc.ua.stack.transport.security.SecurityMode;

import java.util.List;
import java.util.stream.Stream;

import static com.connectedcooking.opcua.dynamicnodemanager.core.datatype.BasicTypeDefinitions.AnalogItemType;
import static java.util.stream.Collectors.toList;

public class ProsysOpc30200Server {

    public static final String NAMESPACE_URI = "http://connectedcooking.com/OPCUA/CKE/";
    private static final String NAMESPACE_VERSION = "1.0-SNAPSHOT";

    private final UaServer server;
    private final DeviceService deviceService;

    private int nsIndex;

    public ProsysOpc30200Server(int port) throws Exception {
        server = new UaServer();
        server.setPort(port);
        server.setServerName("OPCUA/CKE");
        server.getSecurityModes().add(SecurityMode.NONE);
        server.setUserTokenPolicies(UserTokenPolicies.SECURE_USERNAME_PASSWORD_BASIC128RSA15);
        var appDescription = new ApplicationDescription();
        appDescription.setApplicationName(new LocalizedText("CKE Dynamic Server"));
        appDescription.setApplicationUri("urn:connectedcooking:opcua:cke");
        appDescription.setProductUri("https://connectedcooking.com/opcua/cke");
        appDescription.setApplicationType(ApplicationType.Server);
        server.setApplicationIdentity(ApplicationIdentity.createCertificate(appDescription, "CKE", 512));

        deviceService = new DeviceService();
    }

    public void start() throws Exception {
        server.start();
        initialize();
    }

    public int getNsIndex() {
        return nsIndex;
    }

    private void initialize() throws Exception {
        // load model
        server.registerAndLoadModel(
                DIServerInformationModel.MODEL,
                DIServerInformationModel.getLocationURI());
        server.registerAndLoadModel(
                CommercialKitchenEquipmentServerInformationModel.MODEL,
                CommercialKitchenEquipmentServerInformationModel.getLocationURI());

        var di = server.getAddressSpace().getNamespaceTable().getIndex("http://opcfoundation.org/UA/DI/");
        var cke = server.getAddressSpace().getNamespaceTable().getIndex("http://opcfoundation.org/UA/CommercialKitchenEquipment/");

        var diNodeManager = server.getAddressSpace().getNodeManager(di);
        var ckeNodeManager = server.getAddressSpace().getNodeManager(cke);

        var dynNodeManager = new DynNodeManager();
        var prosysAdaptor = new ProsysDynNodeManagerAdaptor(server, NAMESPACE_URI, NAMESPACE_VERSION, dynNodeManager, List.of(diNodeManager));

        // https://reference.opcfoundation.org/v104/CommercialKitchenEquipment/v100/ObjectTypes/CombiSteamerDeviceType/
        var CombiSteamerDeviceType = new RealNodeId(cke, 1011);
        var CombiSteamerParameterType = new RealNodeId(cke, 1010);

        var ISupportInfoType = new RealNodeId(di, 15054);
        var IDeviceHealthType = new RealNodeId(di, 15051);
        var IVendorNameplateType = new RealNodeId(di, 15035);
        var ITagNameplateType = new RealNodeId(di, 15048);

        var EnergySourceEnumeration = new RealNodeId(cke, 3002);
        var CombiSteamerModeEnumeration = new RealNodeId(cke, 3006);

        var deviceSetId = new RealNodeId(di, 5001);

        var combiSteamerDevice = dynNodeManager.nodeBuilder()
                .object("CombiSteamerDevice_<Id>", CombiSteamerDeviceType)
                .canBrowseById((ctx, deviceId) -> hasDevice(ctx.getUsername(), deviceId))
                .hasInterface(ISupportInfoType, IDeviceHealthType, IVendorNameplateType, ITagNameplateType)
                .displayNameById((ctx, deviceId) -> getName("Anonymous", deviceId)) // prosys provides no context here
                .registerAndGet();

        dynNodeManager.assignSet(deviceSetId, combiSteamerDevice.nodeId(),
                (ctx, nodeId) -> getDeviceIds(ctx.getUsername()).map(nodeId::toReal).collect(toList()));

        dynNodeManager.nodeBuilder()
                .childVariable("EnergySource")
                .asProperty(combiSteamerDevice)
                .dataType(EnergySourceEnumeration)
                .valueById((ctx, deviceId) -> getEnergySource(ctx.getUsername(), deviceId))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("IsWithAutomaticCleaning")
                .asProperty(combiSteamerDevice)
                .value(true)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("IsWithExternalCoreTempSensor")
                .asProperty(combiSteamerDevice)
                .value(false)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("IsWithInternalCoreTempSensor")
                .asProperty(combiSteamerDevice)
                .value(false)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("IsWithSousvideTempSensor")
                .asProperty(combiSteamerDevice)
                .value(false)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("DeviceClass")
                .asProperty(combiSteamerDevice)
                .value("Combi Steamer")
                .browseName("1:DeviceClass")
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("Manufacturer")
                .asProperty(combiSteamerDevice)
                .value(new DynLocalizedText("Test Manufacturer"))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("Model")
                .asProperty(combiSteamerDevice)
                .value(new DynLocalizedText("Test Model"))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("HardwareRevision")
                .asProperty(combiSteamerDevice)
                .value("Test HardwareRevision")
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("SoftwareRevision")
                .asProperty(combiSteamerDevice)
                .value("Test SoftwareRevision")
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("DeviceRevision")
                .asProperty(combiSteamerDevice)
                .value("Test DeviceRevision")
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("DeviceManual")
                .asProperty(combiSteamerDevice)
                .value("Test DeviceManual")
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("SerialNumber")
                .asProperty(combiSteamerDevice)
                .valueById((ctx, deviceId) -> getSernum(ctx.getUsername(), deviceId))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("RevisionCounter")
                .asProperty(combiSteamerDevice)
                .value(123)
                .register();

        dynNodeManager.nodeBuilder()
                .childObject("ErrorConditions")
                .asComponent(combiSteamerDevice)
                .register();

        dynNodeManager.nodeBuilder()
                .childObject("InformationConditions")
                .asComponent(combiSteamerDevice)
                .register();

        var combiSteamer = dynNodeManager.nodeBuilder()
                .childObject("CombiSteamer", CombiSteamerParameterType)
                .asComponent(combiSteamerDevice)
                .registerAndGet();

        dynNodeManager.nodeBuilder()
                .childVariable("ActualTemperatureChamber_<No.>", AnalogItemType)
                .asComponents(combiSteamer, (ctx, nid, node) -> List.of(
                        new RealNodeId(nid, "ActualTemperatureChamber_0"),
                        new RealNodeId(nid, "ActualTemperatureChamber_1")))
                .valueBy((cxt, deviceId, chamberNo) -> getActualTemperatureChamber(cxt.getUsername(), Long.valueOf(deviceId), Integer.parseInt(chamberNo)))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("CombiSteamerMode")
                .asComponent(combiSteamer)
                .dataType(CombiSteamerModeEnumeration)
                .value(1 /* On */)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("IsDoorOpen")
                .asComponent(combiSteamer)
                .value(true)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("SetProcessTimeProgram", AnalogItemType)
                .asComponent(combiSteamer)
                .value(789)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("SetTemperature", AnalogItemType)
                .asComponent(combiSteamer)
                .value(741.123f)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("TimeRemainingProgram", AnalogItemType)
                .asComponent(combiSteamer)
                .value(852)
                .register();

        nsIndex = server.getNamespaceTable().getIndex(NAMESPACE_URI);
        System.out.println("Initialized. Namespace index: " + nsIndex);
    }

    private Stream<Long> getDeviceIds(String user) {
        return deviceService.listDevices(user).stream().map(d -> d.id);
    }

    private boolean hasDevice(String user, Long deviceId) {
        return deviceService.listDevices(user).stream().map(d -> d.id).anyMatch(deviceId::equals);
    }

    private String getName(String user, Long deviceId) {
        return deviceService.getDevice(user, deviceId).map(d -> d.name).orElse("N/A");
    }

    private String getSernum(String user, Long deviceId) {
        return deviceService.getDevice(user, deviceId).map(d -> d.sernum).orElse("N/A");
    }

    private Integer getEnergySource(String user, Long deviceId) {
        return 1;   // Gas
    }

    private Float getActualTemperatureChamber(String user, Long deviceId, int chamberNo) {
        if (chamberNo <= 1) {   // we have only two chambers
            return 12.3f * (chamberNo + 1);
        }
        return null;
    }

    private List<?> getErrorConditions(String user, Long deviceId) {
        return List.of();   // TODO
    }
}
