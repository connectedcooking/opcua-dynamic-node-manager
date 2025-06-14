// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.DIUaIds;
import com.prosysopc.ua.InternalUaDataTypeSpecificationMappings;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.UaArrayDimensions;
import com.prosysopc.ua.UaIds;
import com.prosysopc.ua.UaNodeId;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.utils.InternalStructureUtils;
import com.prosysopc.ua.stack.utils.MultiDimensionArrayUtils;
import com.prosysopc.ua.typedictionary.FieldSpecification;
import com.prosysopc.ua.typedictionary.StructureSpecification;
import com.prosysopc.ua.typedictionary.UaDataTypeSpecification;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 * Generated on 2025-04-16 18:27:23
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15889")
public class TransferResultDataDataType extends FetchResultDataType {
  public static final StructureSpecification SPECIFICATION;

  static {
    StructureSpecification.Builder<Structure.Builder> b = StructureSpecification.builder();
    b.addField(Fields.SequenceNumber);
    b.addField(Fields.EndOfResults);
    b.addField(Fields.ParameterDefs);
    b.setBinaryEncodeId(DIUaIds.TransferResultDataDataType_DefaultBinary);
    b.setXmlEncodeId(DIUaIds.TransferResultDataDataType_DefaultXml);
    b.setJsonEncodeId(DIUaIds.TransferResultDataDataType_DefaultJson);
    b.setTypeId(DIUaIds.TransferResultDataDataType);
    b.addSuperTypeId(UaIds.Structure);
    b.addSuperTypeId(DIUaIds.FetchResultDataType);
    b.setName("TransferResultDataDataType");
    b.setJavaClass(TransferResultDataDataType.class);
    b.setAbstract(false);
    b.setStructureType(StructureSpecification.StructureType.NORMAL);
    b.setBuilderSupplier(t -> new Builder(t, () -> new TransferResultDataDataType(t)));
    SPECIFICATION = b.build();
    InternalUaDataTypeSpecificationMappings.put(TransferResultDataDataType.class, SPECIFICATION);
  }

  public TransferResultDataDataType() {
    super((UaDataTypeSpecification)SPECIFICATION);
  }

  protected TransferResultDataDataType(UaDataTypeSpecification specification) {
    super(specification);
  }

  public TransferResultDataDataType(Integer f_sequenceNumber, Boolean f_endOfResults,
      ParameterResultDataType[] f_parameterDefs) {
    super((UaDataTypeSpecification)SPECIFICATION);
    this.setSequenceNumber(f_sequenceNumber);
    this.setEndOfResults(f_endOfResults);
    this.setParameterDefs(f_parameterDefs);
  }

  public Integer getSequenceNumber() {
    return this.indexGet(0);
  }

  public void setSequenceNumber(Integer value) {
    this.indexSet(value, 0);
  }

  public Boolean getEndOfResults() {
    return this.indexGet(1);
  }

  public void setEndOfResults(Boolean value) {
    this.indexSet(value, 1);
  }

  public ParameterResultDataType[] getParameterDefs() {
    return this.indexGet(2);
  }

  public void setParameterDefs(ParameterResultDataType[] value) {
    this.indexSet(value, 2);
  }

  @Override
  public TransferResultDataDataType clone() {
    return (TransferResultDataDataType) super.clone();
  }

  public static Builder builder() {
    return new Builder(SPECIFICATION, () -> new TransferResultDataDataType());
  }

  @Override
  public Builder toBuilder() {
    return (Builder) super.toBuilder();
  }

  public enum Fields implements FieldSpecification {
    SequenceNumber(0, "SequenceNumber", Integer.class, false, UaIds.Int32, -1, null, false, 0),

    EndOfResults(1, "EndOfResults", Boolean.class, false, UaIds.Boolean, -1, null, false, 0),

    ParameterDefs(2, "ParameterDefs", ParameterResultDataType[].class, false, DIUaIds.ParameterResultDataType, 1, UaArrayDimensions.valueOf(0), false, 1);

    private final int fieldIndex;

    private final String name;

    private final Class<?> javaClass;

    private final boolean isOptional;

    private final UaNodeId dataTypeId;

    private final int valueRank;

    private final UaArrayDimensions arrayDimensions;

    private final boolean allowSubTypes;

    private final int javaClassDimensions;

    private final Class<?> compositeClass;

    private final UaNodeId encodeTypeId;

    Fields(int fieldIndex, String name, Class<?> javaClass, boolean isOptional, UaNodeId dataTypeId,
        int valueRank, UaArrayDimensions arrayDimensions, boolean allowSubTypes,
        int javaClassDimensions) {
      this.fieldIndex = fieldIndex;
      this.name = name;
      this.javaClass = javaClass;
      this.isOptional = isOptional;
      this.dataTypeId = dataTypeId;
      this.valueRank = valueRank;
      this.arrayDimensions = arrayDimensions;
      this.allowSubTypes = allowSubTypes;
      this.javaClassDimensions = javaClassDimensions;
      this.compositeClass = MultiDimensionArrayUtils.getComponentType(javaClass);
      this.encodeTypeId = InternalStructureUtils.encodeTypeFor(this.compositeClass, allowSubTypes, dataTypeId);
    }

    @Override
    public UaArrayDimensions getArrayDimensions() {
      return arrayDimensions;
    }

    @Override
    public Class<?> getCompositeClass() {
      return compositeClass;
    }

    @Override
    public UaNodeId getDataTypeId() {
      return dataTypeId;
    }

    @Override
    public String getDescription() {
      return null;
    }

    @Override
    public UaNodeId getEncodeTypeId() {
      return encodeTypeId;
    }

    @Override
    public int getFieldIndex() {
      return fieldIndex;
    }

    @Override
    public Class<?> getJavaClass() {
      return javaClass;
    }

    @Override
    public int getJavaClassDimensions() {
      return javaClassDimensions;
    }

    @Override
    public int getMaxStringLength() {
      return 0;
    }

    @Override
    public String getName() {
      return name;
    }

    @Override
    public int getValueRank() {
      return valueRank;
    }

    @Override
    public boolean isAllowSubTypes() {
      return allowSubTypes;
    }

    @Override
    public boolean isArray() {
      return javaClassDimensions != 0;
    }

    @Override
    public boolean isOptional() {
      return isOptional;
    }
  }

  public static class Builder extends FetchResultDataType.Builder {
    protected Builder(UaDataTypeSpecification specification,
        Supplier<? extends Structure> emptyInstanceSupplier) {
      super(specification, emptyInstanceSupplier);
    }

    public Integer getSequenceNumber() {
      return this.indexGet(0);
    }

    public Builder setSequenceNumber(Integer value) {
      this.indexSet(value, 0);
      return this;
    }

    public Boolean getEndOfResults() {
      return this.indexGet(1);
    }

    public Builder setEndOfResults(Boolean value) {
      this.indexSet(value, 1);
      return this;
    }

    public ParameterResultDataType[] getParameterDefs() {
      return this.indexGet(2);
    }

    public Builder setParameterDefs(ParameterResultDataType[] value) {
      this.indexSet(value, 2);
      return this;
    }

    @Override
    public TransferResultDataDataType build() {
      return (TransferResultDataDataType)super.build();
    }
  }
}
