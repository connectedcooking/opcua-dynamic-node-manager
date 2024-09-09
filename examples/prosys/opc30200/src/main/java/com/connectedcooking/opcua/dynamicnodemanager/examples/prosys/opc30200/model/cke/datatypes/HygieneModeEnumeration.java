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
 * Generated on 2024-09-09 10:35:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3017")
public enum HygieneModeEnumeration implements Enumeration {
  HygieneOperationOFF(0),

  HygieneA0(1),

  HygieneHUE(2),

  HygieneMU(3),

  HygieneThermolable(4),

  HygieneA0_TD(5);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<HygieneModeEnumeration> NONE = EnumSet.noneOf(HygieneModeEnumeration.class);

  public static final EnumSet<HygieneModeEnumeration> ALL = EnumSet.allOf(HygieneModeEnumeration.class);

  private static final Map<Integer, HygieneModeEnumeration> map;

  static {
    map = new HashMap<Integer,HygieneModeEnumeration>();
    for (HygieneModeEnumeration i : HygieneModeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("HygieneModeEnumeration");
    b.setJavaClass(HygieneModeEnumeration.class);
    b.setTypeId(CommercialKitchenEquipmentUaIds.HygieneModeEnumeration);
    b.addMapping(0, "HygieneOperationOFF");
    b.addMapping(1, "HygieneA0");
    b.addMapping(2, "HygieneHUE");
    b.addMapping(3, "HygieneMU");
    b.addMapping(4, "HygieneThermolable");
    b.addMapping(5, "HygieneA0_TD");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return HygieneModeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(HygieneModeEnumeration.class, SPECIFICATION);
  }

  private final int value;

  HygieneModeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static HygieneModeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static HygieneModeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static HygieneModeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static HygieneModeEnumeration[] valueOf(int[] value) {
    HygieneModeEnumeration[] result = new HygieneModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static HygieneModeEnumeration[] valueOf(Integer[] value) {
    HygieneModeEnumeration[] result = new HygieneModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static HygieneModeEnumeration[] valueOf(UnsignedInteger[] value) {
    HygieneModeEnumeration[] result = new HygieneModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(HygieneModeEnumeration... list) {
    int result = 0;
    for (HygieneModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<HygieneModeEnumeration> list) {
    int result = 0;
    for (HygieneModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<HygieneModeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<HygieneModeEnumeration> getSet(int mask) {
    List<HygieneModeEnumeration> res = new ArrayList<HygieneModeEnumeration>();
    for (HygieneModeEnumeration l : HygieneModeEnumeration.values()) {
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
    private HygieneModeEnumeration value;

    private Builder() {
    }

    @Override
    public HygieneModeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=HygieneModeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum HygieneModeEnumeration int value: " + value);
      }
      return this;
    }
  }
}
