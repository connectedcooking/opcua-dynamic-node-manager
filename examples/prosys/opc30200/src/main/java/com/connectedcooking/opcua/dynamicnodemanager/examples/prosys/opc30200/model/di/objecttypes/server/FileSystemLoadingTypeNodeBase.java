// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes.UpdateBehavior;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.FileSystemLoadingType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.FileDirectoryTypeNode;
import java.lang.Override;

/**
 * Generated on 2025-04-16 18:27:23
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=192")
public abstract class FileSystemLoadingTypeNodeBase extends SoftwareLoadingTypeNode implements FileSystemLoadingType {
  private static GeneratedNodeInitializer<FileSystemLoadingTypeNode> f_fileSystemLoadingTypeNodeInitializer;

  private static FileSystemLoadingTypeGetUpdateBehaviorMethod f_getUpdateBehaviorMethodImplementation;

  private static FileSystemLoadingTypeValidateFilesMethod f_validateFilesMethodImplementation;

  protected FileSystemLoadingTypeNodeBase(Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getFileSystemNode());
    GeneratedNodeInitializer<FileSystemLoadingTypeNode> impl = getFileSystemLoadingTypeNodeInitializer();
    if(impl != null) {
      impl.init((FileSystemLoadingTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<FileSystemLoadingTypeNode> getFileSystemLoadingTypeNodeInitializer() {
    return f_fileSystemLoadingTypeNodeInitializer;
  }

  public static void setFileSystemLoadingTypeNodeInitializer(GeneratedNodeInitializer<FileSystemLoadingTypeNode> f_fileSystemLoadingTypeNodeInitializerNewValue) {
    f_fileSystemLoadingTypeNodeInitializer=f_fileSystemLoadingTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public FileDirectoryTypeNode getFileSystemNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/", "FileSystem");
    return (FileDirectoryTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "GetUpdateBehavior"), methodId)) {
      return new Variant[]{new Variant(doGetUpdateBehavior(serviceContext, (NodeId[]) inputArguments[0].getValue()))};
    }
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "ValidateFiles"), methodId)) {
      return doValidateFiles(serviceContext, (NodeId[]) inputArguments[0].getValue()).asVariantArray();
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
      NodeId[] f_nodeIds) throws StatusException;

  @Override
  public UpdateBehavior getUpdateBehavior(NodeId[] f_nodeIds) throws StatusException {
    return doGetUpdateBehavior(ServiceContext.INTERNAL_OPERATION_CONTEXT, f_nodeIds);
  }

  private UpdateBehavior doGetUpdateBehavior(ServiceContext serviceContext, NodeId[] f_nodeIds)
      throws StatusException {
    FileSystemLoadingTypeGetUpdateBehaviorMethod impl = getGetUpdateBehaviorMethodImplementation();
    if(impl != null) {
      return impl.getUpdateBehavior(serviceContext, (FileSystemLoadingTypeNode)this, f_nodeIds);
    } else {
      return onGetUpdateBehavior(serviceContext, f_nodeIds);
    }
  }

  public static FileSystemLoadingTypeGetUpdateBehaviorMethod getGetUpdateBehaviorMethodImplementation() {
    return f_getUpdateBehaviorMethodImplementation;
  }

  public static void setGetUpdateBehaviorMethodImplementation(FileSystemLoadingTypeGetUpdateBehaviorMethod f_getUpdateBehaviorMethodImplementationNewValue) {
    f_getUpdateBehaviorMethodImplementation=f_getUpdateBehaviorMethodImplementationNewValue;
  }

  @Optional
  @Override
  public UaMethod getValidateFilesNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ValidateFiles");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract ValidateFilesMethodOutputs onValidateFiles(ServiceContext serviceContext,
      NodeId[] f_nodeIds) throws StatusException;

  @Override
  public ValidateFilesMethodOutputs validateFiles(NodeId[] f_nodeIds) throws
      StatusException {
    return doValidateFiles(ServiceContext.INTERNAL_OPERATION_CONTEXT, f_nodeIds);
  }

  private ValidateFilesMethodOutputs doValidateFiles(ServiceContext serviceContext,
      NodeId[] f_nodeIds) throws StatusException {
    FileSystemLoadingTypeValidateFilesMethod impl = getValidateFilesMethodImplementation();
    if(impl != null) {
      return impl.validateFiles(serviceContext, (FileSystemLoadingTypeNode)this, f_nodeIds);
    } else {
      return onValidateFiles(serviceContext, f_nodeIds);
    }
  }

  public static FileSystemLoadingTypeValidateFilesMethod getValidateFilesMethodImplementation() {
    return f_validateFilesMethodImplementation;
  }

  public static void setValidateFilesMethodImplementation(FileSystemLoadingTypeValidateFilesMethod f_validateFilesMethodImplementationNewValue) {
    f_validateFilesMethodImplementation=f_validateFilesMethodImplementationNewValue;
  }
}
