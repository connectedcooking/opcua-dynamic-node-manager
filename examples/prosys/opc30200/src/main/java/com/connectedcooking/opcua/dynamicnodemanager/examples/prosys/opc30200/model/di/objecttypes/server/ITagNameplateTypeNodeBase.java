// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.ITagNameplateType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.BaseInterfaceTypeNode;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * Generated on 2023-09-26 10:56:50
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15048")
public abstract class ITagNameplateTypeNodeBase extends BaseInterfaceTypeNode implements ITagNameplateType {
  private static GeneratedNodeInitializer<ITagNameplateTypeNode> f_iTagNameplateTypeNodeInitializer;

  protected ITagNameplateTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<ITagNameplateTypeNode> impl = getITagNameplateTypeNodeInitializer();
    if(impl != null) {
      impl.init((ITagNameplateTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<ITagNameplateTypeNode> getITagNameplateTypeNodeInitializer() {
    return f_iTagNameplateTypeNodeInitializer;
  }

  public static void setITagNameplateTypeNodeInitializer(GeneratedNodeInitializer<ITagNameplateTypeNode> f_iTagNameplateTypeNodeInitializerNewValue) {
    f_iTagNameplateTypeNodeInitializer=f_iTagNameplateTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public UaProperty getAssetIdNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "AssetId");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public String getAssetId() {
    UaVariable node = getAssetIdNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Optional
  @Override
  public void setAssetId(String value) {
    UaVariable node = getAssetIdNode();
    if (node == null) {
      throw new RuntimeException("Setting AssetId failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting AssetId failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public UaProperty getComponentNameNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ComponentName");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public LocalizedText getComponentName() {
    UaVariable node = getComponentNameNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Optional
  @Override
  public void setComponentName(LocalizedText value) {
    UaVariable node = getComponentNameNode();
    if (node == null) {
      throw new RuntimeException("Setting ComponentName failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ComponentName failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}