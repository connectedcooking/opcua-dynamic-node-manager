package com.connectedcooking.opcua.dynamicnodemanager.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DynNodeIdTest {

    @Test
    void matches_successfully() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThat(dynNodeId.matches("Device123/Errors/ErrE456/Msg")).isTrue();
    }

    @Test
    void matches_not() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThat(dynNodeId.matches("Device123/Errors/Msg")).isFalse();
    }

    @Test
    void realize_replaces_all_placeholders() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThat(dynNodeId.realize(123L, "E456")).isEqualTo("Device123/Errors/ErrE456/Msg");
    }

    @Test
    void realize_throws_for_insufficient_replacements_length() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThrows(IllegalArgumentException.class, () -> dynNodeId.realize(123L));
    }

    @Test
    void realize_throws_for_undue_replacements_length() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThrows(IllegalArgumentException.class, () -> dynNodeId.realize(123L, "E456", "XYZ"));
    }

    @Test
    void toReal_from_nodeId() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>");
        assertThat(dynNodeId.toReal("Device123/Errors/ErrE456/Msg").identifier()).isEqualTo("Device123/Errors/ErrE456");
    }

    @Test
    void toReal_from_nodeId2() {
        var dynNodeId = new DynNodeId("Device<Index>");
        assertThat(dynNodeId.toReal("Device123/Errors/ErrE456/Msg").identifier()).isEqualTo("Device123");
    }

    @Test
    void toReal_from_nodeId_throws_for_wrong_nodeId() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThrows(IllegalArgumentException.class, () -> dynNodeId.toReal("Device/Errors/ErrE/Msg"));
    }

    @Test
    void toReal_return_a_real_node_id() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        var realNodeId = dynNodeId.toReal(123L, "E456");
        assertAll(
                () -> assertThat(realNodeId.identifier()).isEqualTo("Device123/Errors/ErrE456/Msg"),
                () -> assertThat(realNodeId.isLocal()).isTrue()
        );
    }

    @Test
    void toReal_return_a_real_node_id_with_namespace() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        var realNodeId = dynNodeId.toRealNs(9, 123L, "E456");
        assertAll(
                () -> assertThat(realNodeId.identifier()).isEqualTo("Device123/Errors/ErrE456/Msg"),
                () -> assertThat(realNodeId.namespaceIndex()).isEqualTo(9),
                () -> assertThat(realNodeId.isLocal()).isFalse()
        );
    }

    @Test
    void compose_returns_parent_with_child() {
        var parentId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        var childId = new PartialNodeId("Detail<detail_id>/Status");
        var composed = parentId.compose(childId).realize(1, 2, 3);
        assertThat(composed).isEqualTo("Device1/Errors/Err2/Msg/Detail3/Status");
    }

    @Test
    void isPartial_always_false() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        assertThat(dynNodeId.isPartial()).isFalse();
    }

    @Test
    void parse_placeholders_with_special_chars() {
        var dynNodeId = new DynNodeId("Device<Index_with-spec #chars 1.>/Errors/Err<ID*$1!@#$%^&*()_üöáěř,';.-+>/Msg");
        var parts = dynNodeId.parse("Device123/Errors/Err456/Msg");
        assertAll(
                () -> assertThat(parts).hasSize(2),
                () -> assertThat(parts[0]).isEqualTo("123"),
                () -> assertThat(parts[1]).isEqualTo("456")
        );
    }

    @Test
    void parse_values_with_special_chars() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        var parts = dynNodeId.parse("DeviceIdx_123/Errors/Err456_err/Msg");
        assertAll(
                () -> assertThat(parts).hasSize(2),
                () -> assertThat(parts[0]).isEqualTo("Idx_123"),
                () -> assertThat(parts[1]).isEqualTo("456_err")
        );
    }

    @Test
    void parse_idx() {
        var dynNodeId = new DynNodeId("Device<Index>/Errors/Err<ID>/Msg");
        var id = dynNodeId.parse("Device123/Errors/Err456/Msg", 0);
        assertThat(id).isEqualTo("123");
    }

    @Test
    void parse_partial() {
        var partialNodeId = new PartialNodeId("Device<Index>/Errors/Err<ID>/Msg");
        var parts = partialNodeId.parse("Device123/Errors/Err456/Msg");
        assertAll(
                () -> assertThat(parts).hasSize(2),
                () -> assertThat(parts[0]).isEqualTo("123"),
                () -> assertThat(parts[1]).isEqualTo("456")
        );
    }

    @Test
    void parse_parent() {
        var dynNodeId = new DynNodeId("Device<Index>");
        var parts = dynNodeId.parse("Device123/Errors/Err456/Msg");
        assertAll(
                () -> assertThat(parts).hasSize(1),
                () -> assertThat(parts[0]).isEqualTo("123")
        );
    }

    @Test
    void parse_idx_parent() {
        var dynNodeId = new DynNodeId("Device<Index>");
        var id = dynNodeId.parse("Device123/Errors/Err456/Msg", 0);
        assertThat(id).isEqualTo("123");
    }
}
