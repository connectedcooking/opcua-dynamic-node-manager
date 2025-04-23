package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.simple;

import com.connectedcooking.opcua.dynamicnodemanager.adaptor.prosys.ProsysDynNodeManagerAdaptor;
import com.connectedcooking.opcua.dynamicnodemanager.core.DynNodeManager;
import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;
import com.prosysopc.ua.ApplicationIdentity;
import com.prosysopc.ua.UserTokenPolicies;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.server.UaServerException;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.core.ApplicationDescription;
import com.prosysopc.ua.stack.core.ApplicationType;
import com.prosysopc.ua.stack.core.ObjectIdentifiers;
import com.prosysopc.ua.stack.transport.security.SecurityMode;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.connectedcooking.opcua.dynamicnodemanager.core.DynAttributes.AccessLevels.*;
import static java.util.stream.Collectors.toList;

public class ProsysSimpleServer {

    public static final String NAMESPACE_URI = "http://connectedcooking.com/OPCUA/Simple/";
    public static final String NAMESPACE_VERSION = "1.0-SNAPSHOT";

    private static final String SET_NODE_ID = "DeviceSet";
    private static final String DEVICE_NODE_ID = "Device_<Id>";

    private final UaServer server;
    private final DeviceService deviceService;

    private int nsIndex;

    public ProsysSimpleServer(int port) throws Exception {
        server = new UaServer();
        server.setPort(port);
        server.setServerName("OPCUA/Simple");
        server.getSecurityModes().add(SecurityMode.NONE);
        server.setUserTokenPolicies(UserTokenPolicies.SECURE_USERNAME_PASSWORD_BASIC128RSA15);
        var appDescription = new ApplicationDescription();
        appDescription.setApplicationName(new LocalizedText("Simple Dynamic Server"));
        appDescription.setApplicationUri("urn:connectedcooking:opcua:simple");
        appDescription.setProductUri("https://connectedcooking.com/opcua/simple");
        appDescription.setApplicationType(ApplicationType.Server);
        server.setApplicationIdentity(ApplicationIdentity.createCertificate(appDescription, "Simple", 512));

        deviceService = new DeviceService();
    }

    private void initialize() {
        var rootNodeManager = server.getNodeManagerRoot();
        var dynNodeManager = new DynNodeManager();
        var prosysAdaptor = new ProsysDynNodeManagerAdaptor(server, NAMESPACE_URI, NAMESPACE_VERSION, dynNodeManager, List.of(rootNodeManager));

        var device = dynNodeManager.nodeBuilder()
                .object(DEVICE_NODE_ID)
                .canBrowseById((ctx, deviceId) -> deviceService.hasDevice(ctx.getUsername(), deviceId))
                .registerAndGet();

        var deviceSet = dynNodeManager.nodeBuilder()
                .object(SET_NODE_ID)
                .hasComponents((ctx, nid, node) -> deviceService.listDevices(ctx.getUsername()).stream()
                        .map(d -> device.realNodeId(d.id)).collect(toList()))
                .registerAndGet();

        var objectsId = new RealNodeId(ObjectIdentifiers.ObjectsFolder.getNamespaceIndex(), ObjectIdentifiers.ObjectsFolder.getValue());

        dynNodeManager.assign(objectsId, deviceSet.nodeId(), deviceSet.realNodeId());

        dynNodeManager.nodeBuilder()
                .childVariable("SerialNumber")
                .asProperty(device)
                .valueById((ctx, deviceId) -> getSernum(ctx.getUsername(), deviceId),
                           (ctx, deviceId, newSernum) -> setSernum(ctx.getUsername(), deviceId, (String) newSernum))
                .accessLevel(CurrentRead, CurrentWrite)
                .userAccessLevel(CurrentRead, HistoryRead, CurrentWrite)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("BooleanNode")
                .asProperty(device)
                .value(true)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("ByteNode")
                .asProperty(device)
                .value(Byte.MAX_VALUE)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("ShortNode")
                .asProperty(device)
                .value(Short.MAX_VALUE)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("IntegerNode")
                .asProperty(device)
                .value(Integer.MAX_VALUE)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("FloatNode")
                .asProperty(device)
                .value(Float.MAX_VALUE)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("DoubleNode")
                .asProperty(device)
                .value(Double.MAX_VALUE)
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("GuiNode")
                .asProperty(device)
                .value(UUID.fromString("8598c388-a1d1-4608-a0a2-0eb5d42c1099"))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("BytesNode")
                .asProperty(device)
                .value("abc".getBytes())
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("LocalDateTimeNode")
                .asProperty(device)
                .value(LocalDateTime.of(2022, 06, 03, 11, 25, 01, 00))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("ZonedDateTimeNode")
                .asProperty(device)
                .value(ZonedDateTime.of(2022, 06, 03, 11, 25, 01, 00, ZoneId.of("Europe/Berlin")))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("LocalDateNode")
                .asProperty(device)
                .value(LocalDate.of(2022, 06, 03))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("DurationNode")
                .asProperty(device)
                .value(Duration.ofSeconds(123))
                .register();

        dynNodeManager.nodeBuilder()
                .childVariable("DateNode")
                .asProperty(device)
                .value(new Date(123456789000L))
                .register();

        nsIndex = server.getNamespaceTable().getIndex(NAMESPACE_URI);
        System.out.println("Initialized. Namespace index: " + nsIndex);
    }

    private String getSernum(String user, Long deviceId) {
        return deviceService.getDevice(user, deviceId).map(d -> d.sernum).orElse("N/A");
    }

    private String setSernum(String user, Long deviceId, String value) {
        deviceService.getDevice(user, deviceId).ifPresent(d -> d.sernum = value);
        return value;
    }

    public void start() throws UaServerException {
        server.start();
        initialize();
    }

    public int getNsIndex() {
        return nsIndex;
    }
}
