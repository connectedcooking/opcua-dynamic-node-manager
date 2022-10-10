package com.connectedcooking.opcua.dynamicnodemanager.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PartialNodeIdTest {

    @Test
    void isPartial_always_true() {
        var dynNodeId = new PartialNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThat(dynNodeId.isPartial()).isTrue();
    }
}
