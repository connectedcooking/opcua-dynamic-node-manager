// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.CachedLoadingType;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.UpdateBehavior;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import java.lang.Override;
import java.lang.String;

/**
 * Generated on 2022-10-10 10:21:30
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=171")
public abstract class CachedLoadingTypeNodeBase extends PackageLoadingTypeNode implements CachedLoadingType {
  private static GeneratedNodeInitializer<CachedLoadingTypeNode> f_cachedLoadingTypeNodeInitializer;

  private static CachedLoadingTypeGetUpdateBehaviorMethod f_getUpdateBehaviorMethodImplementation;

  protected CachedLoadingTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getPendingVersionNode());
    callAfterCreateIfExists(getFallbackVersionNode());
    GeneratedNodeInitializer<CachedLoadingTypeNode> impl = getCachedLoadingTypeNodeInitializer();
    if(impl != null) {
      impl.init((CachedLoadingTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<CachedLoadingTypeNode> getCachedLoadingTypeNodeInitializer() {
    return f_cachedLoadingTypeNodeInitializer;
  }

  public static void setCachedLoadingTypeNodeInitializer(GeneratedNodeInitializer<CachedLoadingTypeNode> f_cachedLoadingTypeNodeInitializerNewValue) {
    f_cachedLoadingTypeNodeInitializer=f_cachedLoadingTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public SoftwareVersionTypeNode getPendingVersionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "PendingVersion");
    return (SoftwareVersionTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public SoftwareVersionTypeNode getFallbackVersionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "FallbackVersion");
    return (SoftwareVersionTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "GetUpdateBehavior"), methodId)) {
      return new Variant[]{new Variant(doGetUpdateBehavior(serviceContext, (String) inputArguments[0].getValue(), (String) inputArguments[1].getValue(), (String[]) inputArguments[2].getValue()))};
    }
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }

  @Mandatory
  @Override
  public UaMethod getGetUpdateBehaviorNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "GetUpdateBehavior");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract UpdateBehavior onGetUpdateBehavior(ServiceContext serviceContext,
      String f_manufacturerUri, String f_softwareRevision, String[] f_patchIdentifiers) throws
      StatusException;

  @Override
  public UpdateBehavior getUpdateBehavior(String f_manufacturerUri, String f_softwareRevision,
      String[] f_patchIdentifiers) throws StatusException {
    return doGetUpdateBehavior(ServiceContext.INTERNAL_OPERATION_CONTEXT, f_manufacturerUri, f_softwareRevision, f_patchIdentifiers);
  }

  private UpdateBehavior doGetUpdateBehavior(ServiceContext serviceContext,
      String f_manufacturerUri, String f_softwareRevision, String[] f_patchIdentifiers) throws
      StatusException {
    CachedLoadingTypeGetUpdateBehaviorMethod impl = getGetUpdateBehaviorMethodImplementation();
    if(impl != null) {
      return impl.getUpdateBehavior(serviceContext, (CachedLoadingTypeNode)this, f_manufacturerUri, f_softwareRevision, f_patchIdentifiers);
    } else {
      return onGetUpdateBehavior(serviceContext, f_manufacturerUri, f_softwareRevision, f_patchIdentifiers);
    }
  }

  public static CachedLoadingTypeGetUpdateBehaviorMethod getGetUpdateBehaviorMethodImplementation() {
    return f_getUpdateBehaviorMethodImplementation;
  }

  public static void setGetUpdateBehaviorMethodImplementation(CachedLoadingTypeGetUpdateBehaviorMethod f_getUpdateBehaviorMethodImplementationNewValue) {
    f_getUpdateBehaviorMethodImplementation=f_getUpdateBehaviorMethodImplementationNewValue;
  }
}