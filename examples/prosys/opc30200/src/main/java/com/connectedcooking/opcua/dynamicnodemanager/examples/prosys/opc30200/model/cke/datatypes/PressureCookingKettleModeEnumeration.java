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
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3009")
public enum PressureCookingKettleModeEnumeration implements Enumeration {
  Off(0),

  Preheat(1),

  SoftCook(2),

  Cook(3),

  CookSlow(4),

  Pressure(5),

  KeepWarming(6),

  PresetStart(7),

  Error(8);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<PressureCookingKettleModeEnumeration> NONE = EnumSet.noneOf(PressureCookingKettleModeEnumeration.class);

  public static final EnumSet<PressureCookingKettleModeEnumeration> ALL = EnumSet.allOf(PressureCookingKettleModeEnumeration.class);

  private static final Map<Integer, PressureCookingKettleModeEnumeration> map;

  static {
    map = new HashMap<Integer,PressureCookingKettleModeEnumeration>();
    for (PressureCookingKettleModeEnumeration i : PressureCookingKettleModeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("PressureCookingKettleModeEnumeration");
    b.setJavaClass(PressureCookingKettleModeEnumeration.class);
    b.setTypeId(UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3009")));
    b.addMapping(0, "Off");
    b.addMapping(1, "Preheat");
    b.addMapping(2, "SoftCook");
    b.addMapping(3, "Cook");
    b.addMapping(4, "CookSlow");
    b.addMapping(5, "Pressure");
    b.addMapping(6, "KeepWarming");
    b.addMapping(7, "PresetStart");
    b.addMapping(8, "Error");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return PressureCookingKettleModeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(PressureCookingKettleModeEnumeration.class, SPECIFICATION);
  }

  private final int value;

  PressureCookingKettleModeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static PressureCookingKettleModeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static PressureCookingKettleModeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static PressureCookingKettleModeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static PressureCookingKettleModeEnumeration[] valueOf(int[] value) {
    PressureCookingKettleModeEnumeration[] result = new PressureCookingKettleModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static PressureCookingKettleModeEnumeration[] valueOf(Integer[] value) {
    PressureCookingKettleModeEnumeration[] result = new PressureCookingKettleModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static PressureCookingKettleModeEnumeration[] valueOf(UnsignedInteger[] value) {
    PressureCookingKettleModeEnumeration[] result = new PressureCookingKettleModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(PressureCookingKettleModeEnumeration... list) {
    int result = 0;
    for (PressureCookingKettleModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<PressureCookingKettleModeEnumeration> list) {
    int result = 0;
    for (PressureCookingKettleModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<PressureCookingKettleModeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<PressureCookingKettleModeEnumeration> getSet(int mask) {
    List<PressureCookingKettleModeEnumeration> res = new ArrayList<PressureCookingKettleModeEnumeration>();
    for (PressureCookingKettleModeEnumeration l : PressureCookingKettleModeEnumeration.values()) {
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
    private PressureCookingKettleModeEnumeration value;

    private Builder() {
    }

    @Override
    public PressureCookingKettleModeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=PressureCookingKettleModeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum PressureCookingKettleModeEnumeration int value: " + value);
      }
      return this;
    }
  }
}
