// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.DIIds;
import com.prosysopc.ua.StructureUtils;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.UaArrayDimensions;
import com.prosysopc.ua.UaIds;
import com.prosysopc.ua.UaNodeId;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.utils.AbstractStructure;
import com.prosysopc.ua.typedictionary.FieldSpecification;
import com.prosysopc.ua.typedictionary.StructureSpecification;
import java.lang.Class;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Generated on 2023-09-26 10:56:50
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6525")
public class ParameterResultDataType extends AbstractStructure {
  @Deprecated
  public static final ExpandedNodeId BINARY = DIIds.ParameterResultDataType_DefaultBinary;

  @Deprecated
  public static final ExpandedNodeId XML = DIIds.ParameterResultDataType_DefaultXml;

  @Deprecated
  public static final ExpandedNodeId JSON = DIIds.ParameterResultDataType_DefaultJson;

  @Deprecated
  public static final ExpandedNodeId ID = DIIds.ParameterResultDataType;

  public static final StructureSpecification SPECIFICATION;

  static {
    StructureSpecification.Builder<Structure.Builder> b = StructureSpecification.builder();
    b.addField(Fields.NodePath);
    b.addField(Fields.StatusCode);
    b.addField(Fields.Diagnostics);
    b.setBinaryEncodeId(UaNodeId.fromLocal(BINARY));
    b.setXmlEncodeId(UaNodeId.fromLocal(XML));
    b.setJsonEncodeId(UaNodeId.fromLocal(JSON));
    b.setTypeId(UaNodeId.fromLocal(ID));
    b.addSuperTypeId(UaIds.Structure);
    b.setName("ParameterResultDataType");
    b.setJavaClass(ParameterResultDataType.class);
    b.setStructureType(StructureSpecification.StructureType.NORMAL);
    b.setBuilderSupplier(Builder::new);
    SPECIFICATION = b.build();
  }

  private QualifiedName[] f_nodePath;

  private StatusCode f_statusCode;

  private DiagnosticInfo f_diagnostics;

  public ParameterResultDataType() {
  }

  public ParameterResultDataType(QualifiedName[] f_nodePath, StatusCode f_statusCode,
      DiagnosticInfo f_diagnostics) {
    this.f_nodePath = f_nodePath;
    this.f_statusCode = f_statusCode;
    this.f_diagnostics = f_diagnostics;
  }

  public QualifiedName[] getNodePath() {
    return this.f_nodePath;
  }

  public void setNodePath(QualifiedName[] f_nodePath) {
    this.f_nodePath=f_nodePath;
  }

  public StatusCode getStatusCode() {
    return this.f_statusCode;
  }

  public void setStatusCode(StatusCode f_statusCode) {
    this.f_statusCode=f_statusCode;
  }

  public DiagnosticInfo getDiagnostics() {
    return this.f_diagnostics;
  }

  public void setDiagnostics(DiagnosticInfo f_diagnostics) {
    this.f_diagnostics=f_diagnostics;
  }

  @Override
  public ParameterResultDataType clone() {
    ParameterResultDataType result = (ParameterResultDataType) super.clone();
    result.f_nodePath = StructureUtils.clone(this.f_nodePath);
    result.f_statusCode = StructureUtils.clone(this.f_statusCode);
    result.f_diagnostics = StructureUtils.clone(this.f_diagnostics);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ParameterResultDataType other = (ParameterResultDataType) obj;
    if (!StructureUtils.scalarOrArrayEquals(getNodePath(), other.getNodePath())) {
      return false;
    }
    if (!StructureUtils.scalarOrArrayEquals(getStatusCode(), other.getStatusCode())) {
      return false;
    }
    if (!StructureUtils.scalarOrArrayEquals(getDiagnostics(), other.getDiagnostics())) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return StructureUtils.hashCode(this.getNodePath(), this.getStatusCode(), this.getDiagnostics());
  }

  @Override
  public void clear() {
    super.clear();
    this.f_nodePath = null;
    this.f_statusCode = null;
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
  public Map<FieldSpecification, Object> toFieldsMap() {
    Map<FieldSpecification,Object> data = new LinkedHashMap<>();
    data.put(Fields.NodePath, this.getNodePath());
    data.put(Fields.StatusCode, this.getStatusCode());
    data.put(Fields.Diagnostics, this.getDiagnostics());
    return Collections.unmodifiableMap(data);
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
    if (Fields.NodePath.equals(field)) {
      return getNodePath();
    }
    if (Fields.StatusCode.equals(field)) {
      return getStatusCode();
    }
    if (Fields.Diagnostics.equals(field)) {
      return getDiagnostics();
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public void set(FieldSpecification field, Object value) {
    if (Fields.NodePath.equals(field)) {
      setNodePath((QualifiedName[]) value);
      return;
    }
    if (Fields.StatusCode.equals(field)) {
      setStatusCode((StatusCode) value);
      return;
    }
    if (Fields.Diagnostics.equals(field)) {
      setDiagnostics((DiagnosticInfo) value);
      return;
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public Builder toBuilder() {
    Builder b = ParameterResultDataType.builder();
    b.setNodePath(StructureUtils.clone(getNodePath()));
    b.setStatusCode(StructureUtils.clone(getStatusCode()));
    b.setDiagnostics(StructureUtils.clone(getDiagnostics()));
    return b;
  }

  public enum Fields implements FieldSpecification {
    NodePath("NodePath", QualifiedName[].class, false, UaIds.QualifiedName, 1, UaArrayDimensions.valueOf(0), false),

    StatusCode("StatusCode", StatusCode.class, false, UaIds.StatusCode, -1, null, false),

    Diagnostics("Diagnostics", DiagnosticInfo.class, false, UaIds.DiagnosticInfo, -1, null, false);

    private final FieldSpecification delegate;

    Fields(String name, Class<?> javaClass, boolean isOptional, UaNodeId dataTypeId, int valueRank,
        UaArrayDimensions arrayDimensions, boolean allowSubTypes) {
      FieldSpecification.Builder b = FieldSpecification.builder();
      b.setName(name);
      b.setJavaClass(javaClass);
      b.setIsOptional(isOptional);
      b.setDataTypeId(dataTypeId);
      b.setValueRank(valueRank);
      b.setArrayDimensions(arrayDimensions);
      b.setAllowSubTypes(allowSubTypes);
      this.delegate = b.build();
    }

    /**
     * @deprecated use 'this' instead, as FieldSpecification as an interface is now implemented directly */
    @Deprecated
    public FieldSpecification getSpecification() {
      return this;
    }

    @Override
    public UaArrayDimensions getArrayDimensions() {
      return delegate.getArrayDimensions();
    }

    @Override
    public UaNodeId getDataTypeId() {
      return delegate.getDataTypeId();
    }

    @Override
    public String getDescription() {
      return delegate.getDescription();
    }

    @Override
    public Class<?> getJavaClass() {
      return delegate.getJavaClass();
    }

    @Override
    public int getMaxStringLength() {
      return delegate.getMaxStringLength();
    }

    @Override
    public String getName() {
      return delegate.getName();
    }

    @Override
    public int getValueRank() {
      return delegate.getValueRank();
    }

    @Override
    public boolean isAllowSubTypes() {
      return delegate.isAllowSubTypes();
    }

    @Override
    public boolean isArray() {
      return delegate.isArray();
    }

    @Override
    public boolean isOptional() {
      return delegate.isOptional();
    }
  }

  public static class Builder extends AbstractStructure.Builder {
    private QualifiedName[] f_nodePath;

    private StatusCode f_statusCode;

    private DiagnosticInfo f_diagnostics;

    protected Builder() {
    }

    public QualifiedName[] getNodePath() {
      return this.f_nodePath;
    }

    public Builder setNodePath(QualifiedName[] f_nodePath) {
      this.f_nodePath=f_nodePath;
      return this;
    }

    public StatusCode getStatusCode() {
      return this.f_statusCode;
    }

    public Builder setStatusCode(StatusCode f_statusCode) {
      this.f_statusCode=f_statusCode;
      return this;
    }

    public DiagnosticInfo getDiagnostics() {
      return this.f_diagnostics;
    }

    public Builder setDiagnostics(DiagnosticInfo f_diagnostics) {
      this.f_diagnostics=f_diagnostics;
      return this;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Builder other = (Builder) obj;
      if (!StructureUtils.scalarOrArrayEquals(getNodePath(), other.getNodePath())) {
        return false;
      }
      if (!StructureUtils.scalarOrArrayEquals(getStatusCode(), other.getStatusCode())) {
        return false;
      }
      if (!StructureUtils.scalarOrArrayEquals(getDiagnostics(), other.getDiagnostics())) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      return StructureUtils.hashCode(this.getNodePath(), this.getStatusCode(), this.getDiagnostics());
    }

    @Override
    public Object get(FieldSpecification field) {
      if (Fields.NodePath.equals(field)) {
        return getNodePath();
      }
      if (Fields.StatusCode.equals(field)) {
        return getStatusCode();
      }
      if (Fields.Diagnostics.equals(field)) {
        return getDiagnostics();
      }
      throw new IllegalArgumentException("Unknown field: " + field);
    }

    @Override
    public Builder set(FieldSpecification field, Object value) {
      if (Fields.NodePath.equals(field)) {
        setNodePath((QualifiedName[]) value);
        return this;
      }
      if (Fields.StatusCode.equals(field)) {
        setStatusCode((StatusCode) value);
        return this;
      }
      if (Fields.Diagnostics.equals(field)) {
        setDiagnostics((DiagnosticInfo) value);
        return this;
      }
      throw new IllegalArgumentException("Unknown field: " + field);
    }

    @Override
    public Builder clear() {
      super.clear();
      this.f_nodePath = null;
      this.f_statusCode = null;
      this.f_diagnostics = null;
      return this;
    }

    @Override
    public StructureSpecification specification() {
      return ParameterResultDataType.SPECIFICATION;
    }

    @Override
    public ParameterResultDataType build() {
      return new ParameterResultDataType(f_nodePath, f_statusCode, f_diagnostics);
    }
  }
}