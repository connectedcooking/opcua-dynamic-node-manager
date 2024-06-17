// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes;

import com.prosysopc.ua.InternalUaDataTypeSpecificationMappings;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.UaNodeId;
import com.prosysopc.ua.stack.builtintypes.Enumeration;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.UnsignedInteger;
import com.prosysopc.ua.typedictionary.EnumerationSpecification;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Override;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated on 2024-06-17 14:43:51
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3024")
public enum StatusEnumeration implements Enumeration {
  INIT(0),

  WATER_PURGE(1),

  PRE_CHILL(2),

  FREEZE(3),

  HARVEST(4),

  BIN_FULL(5),

  CLEAN(6),

  OFF(7),

  SLEEP_MODE(8),

  STANDBY(9),

  SAFE_MODE(10),

  WATER_OUTAGE(11),

  HPCO_DELAY_ACTIVE(12),

  CURTAIN_OPEN(13),

  PRODUCTION_TEST(14),

  SAFE_MODE_PRECHILL(15),

  SAFE_MODE_FREEZE(16),

  SAFE_MODE_HARVEST(17),

  SAFE_MODE_FULL_BIN(18);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<StatusEnumeration> NONE = EnumSet.noneOf(StatusEnumeration.class);

  public static final EnumSet<StatusEnumeration> ALL = EnumSet.allOf(StatusEnumeration.class);

  private static final Map<Integer, StatusEnumeration> map;

  static {
    map = new HashMap<Integer,StatusEnumeration>();
    for (StatusEnumeration i : StatusEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("StatusEnumeration");
    b.setJavaClass(StatusEnumeration.class);
    b.setTypeId(UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3024")));
    b.addMapping(0, "INIT");
    b.addMapping(1, "WATER_PURGE");
    b.addMapping(2, "PRE_CHILL");
    b.addMapping(3, "FREEZE");
    b.addMapping(4, "HARVEST");
    b.addMapping(5, "BIN_FULL");
    b.addMapping(6, "CLEAN");
    b.addMapping(7, "OFF");
    b.addMapping(8, "SLEEP_MODE");
    b.addMapping(9, "STANDBY");
    b.addMapping(10, "SAFE_MODE");
    b.addMapping(11, "WATER_OUTAGE");
    b.addMapping(12, "HPCO_DELAY_ACTIVE");
    b.addMapping(13, "CURTAIN_OPEN");
    b.addMapping(14, "PRODUCTION_TEST");
    b.addMapping(15, "SAFE_MODE_PRECHILL");
    b.addMapping(16, "SAFE_MODE_FREEZE");
    b.addMapping(17, "SAFE_MODE_HARVEST");
    b.addMapping(18, "SAFE_MODE_FULL_BIN");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return StatusEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(StatusEnumeration.class, SPECIFICATION);
  }

  private final int value;

  StatusEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static StatusEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static StatusEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static StatusEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static StatusEnumeration[] valueOf(int[] value) {
    StatusEnumeration[] result = new StatusEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static StatusEnumeration[] valueOf(Integer[] value) {
    StatusEnumeration[] result = new StatusEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static StatusEnumeration[] valueOf(UnsignedInteger[] value) {
    StatusEnumeration[] result = new StatusEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(StatusEnumeration... list) {
    int result = 0;
    for (StatusEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<StatusEnumeration> list) {
    int result = 0;
    for (StatusEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<StatusEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<StatusEnumeration> getSet(int mask) {
    List<StatusEnumeration> res = new ArrayList<StatusEnumeration>();
    for (StatusEnumeration l : StatusEnumeration.values()) {
      if ((mask & l.value) == l.value) {
        res.add(l);
      }
    }
    return EnumSet.copyOf(res);
  }

  @Override
  public int getValue() {
    return value;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    Builder b = builder();
    b.setValue(this.getValue());
    return b;
  }

  public static class Builder implements Enumeration.Builder {
    private StatusEnumeration value;

    private Builder() {
    }

    @Override
    public StatusEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=StatusEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum StatusEnumeration int value: " + value);
      }
      return this;
    }
  }
}
