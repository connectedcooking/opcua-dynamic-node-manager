package com.connectedcooking.opcua.dynamicnodemanager.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DynNodeManagerTest {

    @Test
    void multipleAssignedChildrenSet() {
        var parent = new RealNodeId("Parent");
        var dynNode1 = new DynNodeId("DynNodeA_<No.>");
        var dynNode2 = new DynNodeId("DynNodeB_<No.>");

        var dnm = new DynNodeManager();

        dnm.assignSet(parent, dynNode1, (ctx, nodeId) -> List.of(
                new RealNodeId("DynNodeA_1")));

        dnm.assignSet(parent, dynNode2, (ctx, nodeId) -> List.of(
                new RealNodeId("DynNodeB_1"), new RealNodeId("DynNodeB_2")));

        var references = dnm.assignedChildren(parent, null).stream()
                .map(DynReference::targetId)
                .map(RealNodeId::identifier)
                .collect(Collectors.toList());

        assertThat(references).containsExactlyInAnyOrder("DynNodeA_1", "DynNodeB_1", "DynNodeB_2");
    }
}
