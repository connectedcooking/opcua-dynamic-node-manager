// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.datatypes;

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
 * Generated on 2023-09-26 10:56:54
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3008")
public enum ChamberModeEnumeration implements Enumeration {
  NoSpecialMode(0),

  Off(1),

  Autostart(2),

  Standby(3),

  PreHeat(4),

  CoolDown(5),

  Working(6),

  Cleaning(7),

  EnergySave(8),

  ServiceMode(9),

  QuickCool(10),

  FlashFreeze(11),

  ProofingInterruption(12),

  ProofingDelay(13),

  Proofing(14),

  Setting(15),

  Defrost(16),

  Baking(17),

  Steaming(18);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<ChamberModeEnumeration> NONE = EnumSet.noneOf(ChamberModeEnumeration.class);

  public static final EnumSet<ChamberModeEnumeration> ALL = EnumSet.allOf(ChamberModeEnumeration.class);

  private static final Map<Integer, ChamberModeEnumeration> map;

  static {
    map = new HashMap<Integer,ChamberModeEnumeration>();
    for (ChamberModeEnumeration i : ChamberModeEnumeration.values()) {
      map.put(i.value, i);
    }
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("ChamberModeEnumeration");
    b.setJavaClass(ChamberModeEnumeration.class);
    b.setTypeId(UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/CommercialKitchenEquipment/;i=3008")));
    b.addMapping(0, "NoSpecialMode");
    b.addMapping(1, "Off");
    b.addMapping(2, "Autostart");
    b.addMapping(3, "Standby");
    b.addMapping(4, "PreHeat");
    b.addMapping(5, "CoolDown");
    b.addMapping(6, "Working");
    b.addMapping(7, "Cleaning");
    b.addMapping(8, "EnergySave");
    b.addMapping(9, "ServiceMode");
    b.addMapping(10, "QuickCool");
    b.addMapping(11, "FlashFreeze");
    b.addMapping(12, "ProofingInterruption");
    b.addMapping(13, "ProofingDelay");
    b.addMapping(14, "Proofing");
    b.addMapping(15, "Setting");
    b.addMapping(16, "Defrost");
    b.addMapping(17, "Baking");
    b.addMapping(18, "Steaming");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return ChamberModeEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
  }

  private final int value;

  ChamberModeEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static ChamberModeEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static ChamberModeEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static ChamberModeEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static ChamberModeEnumeration[] valueOf(int[] value) {
    ChamberModeEnumeration[] result = new ChamberModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static ChamberModeEnumeration[] valueOf(Integer[] value) {
    ChamberModeEnumeration[] result = new ChamberModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static ChamberModeEnumeration[] valueOf(UnsignedInteger[] value) {
    ChamberModeEnumeration[] result = new ChamberModeEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(ChamberModeEnumeration... list) {
    int result = 0;
    for (ChamberModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<ChamberModeEnumeration> list) {
    int result = 0;
    for (ChamberModeEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<ChamberModeEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<ChamberModeEnumeration> getSet(int mask) {
    List<ChamberModeEnumeration> res = new ArrayList<ChamberModeEnumeration>();
    for (ChamberModeEnumeration l : ChamberModeEnumeration.values()) {
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
    private ChamberModeEnumeration value;

    private Builder() {
    }

    @Override
    public ChamberModeEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=ChamberModeEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum ChamberModeEnumeration int value: " + value);
      }
      return this;
    }
  }
}