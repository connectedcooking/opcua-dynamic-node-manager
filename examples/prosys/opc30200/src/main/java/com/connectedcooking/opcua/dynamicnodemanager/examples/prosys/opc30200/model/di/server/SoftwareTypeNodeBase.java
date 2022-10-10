// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.SoftwareType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * Generated on 2022-10-10 10:21:30
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15106")
public abstract class SoftwareTypeNodeBase extends ComponentTypeNode implements SoftwareType {
  private static GeneratedNodeInitializer<SoftwareTypeNode> f_softwareTypeNodeInitializer;

  protected SoftwareTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<SoftwareTypeNode> impl = getSoftwareTypeNodeInitializer();
    if(impl != null) {
      impl.init((SoftwareTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<SoftwareTypeNode> getSoftwareTypeNodeInitializer() {
    return f_softwareTypeNodeInitializer;
  }

  public static void setSoftwareTypeNodeInitializer(GeneratedNodeInitializer<SoftwareTypeNode> f_softwareTypeNodeInitializerNewValue) {
    f_softwareTypeNodeInitializer=f_softwareTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public UaProperty getManufacturerNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Manufacturer");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getManufacturer() {
    UaVariable node = getManufacturerNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Manufacturer does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setManufacturer(LocalizedText value) {
    UaVariable node = getManufacturerNode();
    if (node == null) {
      throw new RuntimeException("Setting Manufacturer failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Manufacturer failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getModelNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Model");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getModel() {
    UaVariable node = getModelNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Model does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setModel(LocalizedText value) {
    UaVariable node = getModelNode();
    if (node == null) {
      throw new RuntimeException("Setting Model failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Model failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getSoftwareRevisionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "SoftwareRevision");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getSoftwareRevision() {
    UaVariable node = getSoftwareRevisionNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node SoftwareRevision does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setSoftwareRevision(String value) {
    UaVariable node = getSoftwareRevisionNode();
    if (node == null) {
      throw new RuntimeException("Setting SoftwareRevision failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SoftwareRevision failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}