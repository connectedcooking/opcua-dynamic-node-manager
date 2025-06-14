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
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3020")
public enum TrayTypeEnumeration implements Enumeration {
  Generic(0),

  HeaterPlate(1),

  CoolingPlate(2),

  CombiPlate(3),

  BainMarie(4),

  HeaterCabinet(5),

  CoolingCabinet(6),

  HeatBridge(7),

  CombiCabinet(8),

  RegenCabinet(9);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<TrayTypeEnumeration> NONE = EnumSet.noneOf(TrayTypeEnumeration.class);

  public static final EnumSet<TrayTypeEnumeration> ALL = EnumSet.allOf(TrayTypeEnumeration.class);

  private static final Map<Integer, TrayTypeEnumeration> map;

  static {
    map = new HashMap<Integer,TrayTypeEnumeration>();
    for (TrayTypeEnumeration i : TrayTypeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("TrayTypeEnumeration");
    b.setJavaClass(TrayTypeEnumeration.class);
    b.setTypeId(CommercialKitchenEquipmentUaIds.TrayTypeEnumeration);
    b.addMapping(0, "Generic");
    b.addMapping(1, "HeaterPlate");
    b.addMapping(2, "CoolingPlate");
    b.addMapping(3, "CombiPlate");
    b.addMapping(4, "BainMarie");
    b.addMapping(5, "HeaterCabinet");
    b.addMapping(6, "CoolingCabinet");
    b.addMapping(7, "HeatBridge");
    b.addMapping(8, "CombiCabinet");
    b.addMapping(9, "RegenCabinet");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return TrayTypeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(TrayTypeEnumeration.class, SPECIFICATION);
  }

  private final int value;

  TrayTypeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static TrayTypeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static TrayTypeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static TrayTypeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static TrayTypeEnumeration[] valueOf(int[] value) {
    TrayTypeEnumeration[] result = new TrayTypeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static TrayTypeEnumeration[] valueOf(Integer[] value) {
    TrayTypeEnumeration[] result = new TrayTypeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static TrayTypeEnumeration[] valueOf(UnsignedInteger[] value) {
    TrayTypeEnumeration[] result = new TrayTypeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(TrayTypeEnumeration... list) {
    int result = 0;
    for (TrayTypeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<TrayTypeEnumeration> list) {
    int result = 0;
    for (TrayTypeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<TrayTypeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<TrayTypeEnumeration> getSet(int mask) {
    List<TrayTypeEnumeration> res = new ArrayList<TrayTypeEnumeration>();
    for (TrayTypeEnumeration l : TrayTypeEnumeration.values()) {
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
    private TrayTypeEnumeration value;

    private Builder() {
    }

    @Override
    public TrayTypeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=TrayTypeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum TrayTypeEnumeration int value: " + value);
      }
      return this;
    }
  }
}
