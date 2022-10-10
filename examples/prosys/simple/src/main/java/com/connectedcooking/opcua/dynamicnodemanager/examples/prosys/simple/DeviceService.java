package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DeviceService {

    // in-memory database of devices (generated on the fly)
    private static final Map<Long, Device> DB = new HashMap<>();

    public boolean hasDevice(String user, Long id) {
        return id > 0 && id <= user.length();
    }

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
        return Optional.of(DB.computeIfAbsent(id, (_id) -> generateDevice(id.intValue())));
    }

    private Device generateDevice(int i) {
        return new Device(Long.valueOf(i), "Test Device " + i, "SERNUM" + i);
    }

    public static class Device {

        public Long id;
        public String name;
        public String sernum;

        public Device(Long id, String name, String sernum) {
            this.id = id;
            this.name = name;
            this.sernum = sernum;
        }
    }
}
