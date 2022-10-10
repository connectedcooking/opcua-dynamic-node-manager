package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DeviceService {

    public List<Device> listDevices(String user) {
        // generate as many device as many characters the username hat:
        return IntStream.range(1, user.length() + 1)
                .mapToObj(i -> generateDevice(i))
                .collect(Collectors.toList());
    }

    public Optional<Device> getDevice(String user, Long id) {
        if (id > user.length()) {
            // the user does not own a device with this ID
            return Optional.empty();
        }
        return Optional.of(generateDevice(id.intValue()));
    }

    private Device generateDevice(int i) {
        return new Device(Long.valueOf(i), "Test Device " + i, "SERNUM" + i);
    }

    public static class Device {

        public final Long id;
        public final String name;
        public final String sernum;

        public Device(Long id, String name, String sernum) {
            this.id = id;
            this.name = name;
            this.sernum = sernum;
        }
    }
}
