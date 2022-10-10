package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.simple;

public class ProsysSimpleApplication {

    public static void main(String[] args) throws Exception {
        var server = new ProsysSimpleServer(4840);
        server.start();
    }
}
