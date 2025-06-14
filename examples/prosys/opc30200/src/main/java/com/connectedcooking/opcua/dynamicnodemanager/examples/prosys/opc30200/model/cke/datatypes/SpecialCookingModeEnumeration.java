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
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3007")
public enum SpecialCookingModeEnumeration implements Enumeration {
  NoSpecialMode(0),

  Baking(1),

  SousVide(2),

  RestStage(3),

  Humidification(4),

  PerfectHold(5),

  InfoStep(6),

  Smoking(7),

  LowTemp_Cooking(8),

  DeltaTSteaming(9);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<SpecialCookingModeEnumeration> NONE = EnumSet.noneOf(SpecialCookingModeEnumeration.class);

  public static final EnumSet<SpecialCookingModeEnumeration> ALL = EnumSet.allOf(SpecialCookingModeEnumeration.class);

  private static final Map<Integer, SpecialCookingModeEnumeration> map;

  static {
    map = new HashMap<Integer,SpecialCookingModeEnumeration>();
    for (SpecialCookingModeEnumeration i : SpecialCookingModeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("SpecialCookingModeEnumeration");
    b.setJavaClass(SpecialCookingModeEnumeration.class);
    b.setTypeId(CommercialKitchenEquipmentUaIds.SpecialCookingModeEnumeration);
    b.addMapping(0, "NoSpecialMode");
    b.addMapping(1, "Baking");
    b.addMapping(2, "SousVide");
    b.addMapping(3, "RestStage");
    b.addMapping(4, "Humidification");
    b.addMapping(5, "PerfectHold");
    b.addMapping(6, "InfoStep");
    b.addMapping(7, "Smoking");
    b.addMapping(8, "LowTemp_Cooking");
    b.addMapping(9, "DeltaTSteaming");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return SpecialCookingModeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(SpecialCookingModeEnumeration.class, SPECIFICATION);
  }

  private final int value;

  SpecialCookingModeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static SpecialCookingModeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static SpecialCookingModeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static SpecialCookingModeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static SpecialCookingModeEnumeration[] valueOf(int[] value) {
    SpecialCookingModeEnumeration[] result = new SpecialCookingModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static SpecialCookingModeEnumeration[] valueOf(Integer[] value) {
    SpecialCookingModeEnumeration[] result = new SpecialCookingModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static SpecialCookingModeEnumeration[] valueOf(UnsignedInteger[] value) {
    SpecialCookingModeEnumeration[] result = new SpecialCookingModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(SpecialCookingModeEnumeration... list) {
    int result = 0;
    for (SpecialCookingModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<SpecialCookingModeEnumeration> list) {
    int result = 0;
    for (SpecialCookingModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<SpecialCookingModeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<SpecialCookingModeEnumeration> getSet(int mask) {
    List<SpecialCookingModeEnumeration> res = new ArrayList<SpecialCookingModeEnumeration>();
    for (SpecialCookingModeEnumeration l : SpecialCookingModeEnumeration.values()) {
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
    private SpecialCookingModeEnumeration value;

    private Builder() {
    }

    @Override
    public SpecialCookingModeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=SpecialCookingModeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum SpecialCookingModeEnumeration int value: " + value);
      }
      return this;
    }
  }
}
