// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di;

import com.prosysopc.ua.StructureSerializer;
import com.prosysopc.ua.StructureUtils;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.UaNodeId;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.encoding.EncoderContext;
import com.prosysopc.ua.typedictionary.FieldSpecification;
import com.prosysopc.ua.typedictionary.StructureSpecification;
import java.lang.Class;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Generated on 2022-10-10 10:21:30
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15888")
public class TransferResultErrorDataType extends FetchResultDataType {
  @Deprecated
  public static final ExpandedNodeId BINARY = DIIds.TransferResultErrorDataType_DefaultBinary;

  @Deprecated
  public static final ExpandedNodeId XML = DIIds.TransferResultErrorDataType_DefaultXml;

  @Deprecated
  public static final ExpandedNodeId JSON = DIIds.TransferResultErrorDataType_DefaultJson;

  @Deprecated
  public static final ExpandedNodeId ID = DIIds.TransferResultErrorDataType;

  public static final StructureSpecification SPECIFICATION;

  static {
    StructureSpecification.Builder b = StructureSpecification.builder();
    b.addField(Fields.Status.getSpecification());
    b.addField(Fields.Diagnostics.getSpecification());
    b.setBinaryEncodeId(UaNodeId.fromLocal(BINARY));
    b.setXmlEncodeId(UaNodeId.fromLocal(XML));
    b.setJsonEncodeId(UaNodeId.fromLocal(JSON));
    b.setTypeId(UaNodeId.fromLocal(ID));
    b.setName("TransferResultErrorDataType");
    b.setJavaClass(TransferResultErrorDataType.class);
    b.setStructureType(StructureSpecification.StructureType.NORMAL);
    b.setSerializerSupplier(new StructureSpecification.StructureSerializerSupplier() {
      @Override
      public StructureSerializer get(StructureSpecification specification, EncoderContext ctx) {
        return new DISerializers.TransferResultErrorDataTypeSerializer();
      }
    });
    b.setBuilderSupplier(new StructureSpecification.StructureBuilderSupplier() {
      @Override
      public Structure.Builder get() {
        return TransferResultErrorDataType.builder();
      }
    });
    SPECIFICATION = b.build();
  }

  private Integer f_status;

  private DiagnosticInfo f_diagnostics;

  public TransferResultErrorDataType() {
  }

  public TransferResultErrorDataType(Integer f_status, DiagnosticInfo f_diagnostics) {
    this.f_status = f_status;
    this.f_diagnostics = f_diagnostics;
  }

  public Integer getStatus() {
    return this.f_status;
  }

  public void setStatus(Integer f_status) {
    this.f_status=f_status;
  }

  public DiagnosticInfo getDiagnostics() {
    return this.f_diagnostics;
  }

  public void setDiagnostics(DiagnosticInfo f_diagnostics) {
    this.f_diagnostics=f_diagnostics;
  }

  @Override
  public TransferResultErrorDataType clone() {
    TransferResultErrorDataType result = (TransferResultErrorDataType) super.clone();
    result.f_status = StructureUtils.clone(this.f_status);
    result.f_diagnostics = StructureUtils.clone(this.f_diagnostics);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TransferResultErrorDataType other = (TransferResultErrorDataType) obj;
    if (!StructureUtils.scalarOrArrayEquals(getStatus(), other.getStatus())) {
      return false;
    }
    if (!StructureUtils.scalarOrArrayEquals(getDiagnostics(), other.getDiagnostics())) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return StructureUtils.hashCode(this.getStatus(), this.getDiagnostics());
  }

  @Override
  public void clear() {
    super.clear();
    this.f_status = null;
    this.f_diagnostics = null;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getBinaryEncodeId() {
    return BINARY;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getXmlEncodeId() {
    return XML;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getJsonEncodeId() {
    return JSON;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getTypeId() {
    return ID;
  }

  @Override
  public StructureSpecification specification() {
    return SPECIFICATION;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Object get(FieldSpecification field) {
    if (Fields.Status.getSpecification().equals(field)) {
      return getStatus();
    }
    if (Fields.Diagnostics.getSpecification().equals(field)) {
      return getDiagnostics();
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public void set(FieldSpecification field, Object value) {
    if (Fields.Status.getSpecification().equals(field)) {
      setStatus((Integer) value);
      return;
    }
    if (Fields.Diagnostics.getSpecification().equals(field)) {
      setDiagnostics((DiagnosticInfo) value);
      return;
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public Builder toBuilder() {
    Builder b = TransferResultErrorDataType.builder();
    b.setStatus(getStatus());
    b.setDiagnostics(getDiagnostics());
    return b;
  }

  public enum Fields {
    Status("Status", Integer.class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=6")), -1, false),

    Diagnostics("Diagnostics", DiagnosticInfo.class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=25")), -1, false);

    private final FieldSpecification value;

    Fields(String name, Class<?> javaClass, boolean isOptional, UaNodeId dataTypeId, int valueRank,
        boolean allowSubTypes) {
      FieldSpecification.Builder b = FieldSpecification.builder();
      b.setName(name);
      b.setJavaClass(javaClass);
      b.setIsOptional(isOptional);
      b.setDataTypeId(dataTypeId);
      b.setValueRank(valueRank);
      b.setAllowSubTypes(allowSubTypes);
      this.value = b.build();
    }

    public FieldSpecification getSpecification() {
      return value;
    }
  }

  public static class Builder extends FetchResultDataType.Builder {
    private Integer f_status;

    private DiagnosticInfo f_diagnostics;

    protected Builder() {
    }

    public Builder setStatus(Integer f_status) {
      this.f_status=f_status;
      return this;
    }

    public Builder setDiagnostics(DiagnosticInfo f_diagnostics) {
      this.f_diagnostics=f_diagnostics;
      return this;
    }

    @Override
    public Builder set(FieldSpecification field, Object value) {
      if (Fields.Status.getSpecification().equals(field)) {
        setStatus((Integer) value);
        return this;
      }
      if (Fields.Diagnostics.getSpecification().equals(field)) {
        setDiagnostics((DiagnosticInfo) value);
        return this;
      }
      throw new IllegalArgumentException("Unknown field: " + field);
    }

    @Override
    public StructureSpecification specification() {
      return TransferResultErrorDataType.SPECIFICATION;
    }

    @Override
    public TransferResultErrorDataType build() {
      return new TransferResultErrorDataType(f_status, f_diagnostics);
    }
  }
}
