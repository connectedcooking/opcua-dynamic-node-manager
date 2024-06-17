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
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3012")
public enum SpecialFunctionModeEnumeration implements Enumeration {
  LidUpDown(0),

  PanTilt(1),

  WaterSupply(2),

  DrainOnOff(3);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<SpecialFunctionModeEnumeration> NONE = EnumSet.noneOf(SpecialFunctionModeEnumeration.class);

  public static final EnumSet<SpecialFunctionModeEnumeration> ALL = EnumSet.allOf(SpecialFunctionModeEnumeration.class);

  private static final Map<Integer, SpecialFunctionModeEnumeration> map;

  static {
    map = new HashMap<Integer,SpecialFunctionModeEnumeration>();
    for (SpecialFunctionModeEnumeration i : SpecialFunctionModeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("SpecialFunctionModeEnumeration");
    b.setJavaClass(SpecialFunctionModeEnumeration.class);
    b.setTypeId(UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3012")));
    b.addMapping(0, "LidUpDown");
    b.addMapping(1, "PanTilt");
    b.addMapping(2, "WaterSupply");
    b.addMapping(3, "DrainOnOff");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return SpecialFunctionModeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(SpecialFunctionModeEnumeration.class, SPECIFICATION);
  }

  private final int value;

  SpecialFunctionModeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static SpecialFunctionModeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static SpecialFunctionModeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static SpecialFunctionModeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static SpecialFunctionModeEnumeration[] valueOf(int[] value) {
    SpecialFunctionModeEnumeration[] result = new SpecialFunctionModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static SpecialFunctionModeEnumeration[] valueOf(Integer[] value) {
    SpecialFunctionModeEnumeration[] result = new SpecialFunctionModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static SpecialFunctionModeEnumeration[] valueOf(UnsignedInteger[] value) {
    SpecialFunctionModeEnumeration[] result = new SpecialFunctionModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(SpecialFunctionModeEnumeration... list) {
    int result = 0;
    for (SpecialFunctionModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<SpecialFunctionModeEnumeration> list) {
    int result = 0;
    for (SpecialFunctionModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<SpecialFunctionModeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<SpecialFunctionModeEnumeration> getSet(int mask) {
    List<SpecialFunctionModeEnumeration> res = new ArrayList<SpecialFunctionModeEnumeration>();
    for (SpecialFunctionModeEnumeration l : SpecialFunctionModeEnumeration.values()) {
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
    private SpecialFunctionModeEnumeration value;

    private Builder() {
    }

    @Override
    public SpecialFunctionModeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=SpecialFunctionModeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum SpecialFunctionModeEnumeration int value: " + value);
      }
      return this;
    }
  }
}
