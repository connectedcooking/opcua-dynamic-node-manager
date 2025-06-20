// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CommercialKitchenEquipmentUaIds;
import com.prosysopc.ua.InternalUaDataTypeSpecificationMappings;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.stack.builtintypes.Enumeration;
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
 * Generated on 2025-04-16 18:27:26
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3011")
public enum MultiFunctionPanModeEnumeration implements Enumeration {
  Off(0),

  On(1),

  Preheat(2),

  StandBy(3),

  PressureCooking(4),

  SoftCooking(5),

  Cooking(6),

  Grilling(7),

  Frying(8),

  Regenerate(9),

  DeltaTcooking(10),

  ZoneGrilling(11),

  ZoneCooking(12),

  Cleaning(13),

  PresetStart(14),

  Error(15);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<MultiFunctionPanModeEnumeration> NONE = EnumSet.noneOf(MultiFunctionPanModeEnumeration.class);

  public static final EnumSet<MultiFunctionPanModeEnumeration> ALL = EnumSet.allOf(MultiFunctionPanModeEnumeration.class);

  private static final Map<Integer, MultiFunctionPanModeEnumeration> map;

  static {
    map = new HashMap<Integer,MultiFunctionPanModeEnumeration>();
    for (MultiFunctionPanModeEnumeration i : MultiFunctionPanModeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("MultiFunctionPanModeEnumeration");
    b.setJavaClass(MultiFunctionPanModeEnumeration.class);
    b.setTypeId(CommercialKitchenEquipmentUaIds.MultiFunctionPanModeEnumeration);
    b.addMapping(0, "Off");
    b.addMapping(1, "On");
    b.addMapping(2, "Preheat");
    b.addMapping(3, "StandBy");
    b.addMapping(4, "PressureCooking");
    b.addMapping(5, "SoftCooking");
    b.addMapping(6, "Cooking");
    b.addMapping(7, "Grilling");
    b.addMapping(8, "Frying");
    b.addMapping(9, "Regenerate");
    b.addMapping(10, "DeltaTcooking");
    b.addMapping(11, "ZoneGrilling");
    b.addMapping(12, "ZoneCooking");
    b.addMapping(13, "Cleaning");
    b.addMapping(14, "PresetStart");
    b.addMapping(15, "Error");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return MultiFunctionPanModeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(MultiFunctionPanModeEnumeration.class, SPECIFICATION);
  }

  private final int value;

  MultiFunctionPanModeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static MultiFunctionPanModeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static MultiFunctionPanModeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static MultiFunctionPanModeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static MultiFunctionPanModeEnumeration[] valueOf(int[] value) {
    MultiFunctionPanModeEnumeration[] result = new MultiFunctionPanModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static MultiFunctionPanModeEnumeration[] valueOf(Integer[] value) {
    MultiFunctionPanModeEnumeration[] result = new MultiFunctionPanModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static MultiFunctionPanModeEnumeration[] valueOf(UnsignedInteger[] value) {
    MultiFunctionPanModeEnumeration[] result = new MultiFunctionPanModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(MultiFunctionPanModeEnumeration... list) {
    int result = 0;
    for (MultiFunctionPanModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<MultiFunctionPanModeEnumeration> list) {
    int result = 0;
    for (MultiFunctionPanModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<MultiFunctionPanModeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<MultiFunctionPanModeEnumeration> getSet(int mask) {
    List<MultiFunctionPanModeEnumeration> res = new ArrayList<MultiFunctionPanModeEnumeration>();
    for (MultiFunctionPanModeEnumeration l : MultiFunctionPanModeEnumeration.values()) {
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
    private MultiFunctionPanModeEnumeration value;

    private Builder() {
    }

    @Override
    public MultiFunctionPanModeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=MultiFunctionPanModeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum MultiFunctionPanModeEnumeration int value: " + value);
      }
      return this;
    }
  }
}
