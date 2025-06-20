// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes.UpdateBehavior;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.DirectLoadingType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Generated on 2025-04-16 18:27:23
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=153")
public abstract class DirectLoadingTypeNodeBase extends PackageLoadingTypeNode implements DirectLoadingType {
  private static GeneratedNodeInitializer<DirectLoadingTypeNode> f_directLoadingTypeNodeInitializer;

  protected DirectLoadingTypeNodeBase(Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getUpdateBehaviorNode());
    GeneratedNodeInitializer<DirectLoadingTypeNode> impl = getDirectLoadingTypeNodeInitializer();
    if(impl != null) {
      impl.init((DirectLoadingTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<DirectLoadingTypeNode> getDirectLoadingTypeNodeInitializer() {
    return f_directLoadingTypeNodeInitializer;
  }

  public static void setDirectLoadingTypeNodeInitializer(GeneratedNodeInitializer<DirectLoadingTypeNode> f_directLoadingTypeNodeInitializerNewValue) {
    f_directLoadingTypeNodeInitializer=f_directLoadingTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public UaProperty getWriteTimeoutNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "WriteTimeout");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public Double getWriteTimeout() {
    UaVariable node = getWriteTimeoutNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Double) value;
  }

  @Optional
  @Override
  public void setWriteTimeout(Double value) {
    UaVariable node = getWriteTimeoutNode();
    if (node == null) {
      throw new RuntimeException("Setting WriteTimeout failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting WriteTimeout failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseDataVariableTypeNode getUpdateBehaviorNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "UpdateBehavior");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public UpdateBehavior getUpdateBehavior() {
    UaVariable node = getUpdateBehaviorNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node UpdateBehavior does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (UpdateBehavior) value;
  }

  @Mandatory
  @Override
  public void setUpdateBehavior(UpdateBehavior value) {
    UaVariable node = getUpdateBehaviorNode();
    if (node == null) {
      throw new RuntimeException("Setting UpdateBehavior failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting UpdateBehavior failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
