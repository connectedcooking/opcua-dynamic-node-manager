package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200;

public class ProsysOpc30200Application {

    public static void main(String[] args) throws Exception {
        var server = new ProsysOpc30200Server(4840);
        server.start();
    }
}
