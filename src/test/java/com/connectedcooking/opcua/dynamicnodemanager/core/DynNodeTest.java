package com.connectedcooking.opcua.dynamicnodemanager.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DynNodeTest {
    
    @Mock
    private DynAttributeManager attributes;
    @Mock
    private DynReferenceManager references;
    
    @Test
    void equals_with_parent() {
        var node1 = new BaseDynNode(new DynNodeId("A"), new DynNodeId("P"), attributes, references);
        var node2 = new BaseDynNode(new DynNodeId("A"), new DynNodeId("P"), attributes, references);
        assertThat(node1.equals(node2)).isTrue();
    }

    @Test
    void equals_not_without_parent() {
        var node1 = new BaseDynNode(new DynNodeId("A"), new DynNodeId("P"), attributes, references);
        var node2 = new BaseDynNode(new DynNodeId("A"), null, attributes, references);
        assertThat(node1.equals(node2)).isFalse();
    }

    @Test
    void equals_not_with_different_parent() {
        var node1 = new BaseDynNode(new DynNodeId("A"), new DynNodeId("P1"), attributes, references);
        var node2 = new BaseDynNode(new DynNodeId("A"), new DynNodeId("P2"), attributes, references);
        assertThat(node1.equals(node2)).isFalse();
    }
}
