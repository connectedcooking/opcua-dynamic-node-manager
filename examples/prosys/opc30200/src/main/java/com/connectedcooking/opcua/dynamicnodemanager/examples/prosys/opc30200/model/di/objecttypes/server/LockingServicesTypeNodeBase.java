// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.LockingServicesType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaMethod;
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
import com.prosysopc.ua.types.opcua.server.BaseObjectTypeNode;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * An interface for Locking.
 * <p>
 * Generated on 2024-06-17 14:43:47
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6388")
public abstract class LockingServicesTypeNodeBase extends BaseObjectTypeNode implements LockingServicesType {
  private static GeneratedNodeInitializer<LockingServicesTypeNode> f_lockingServicesTypeNodeInitializer;

  private static LockingServicesTypeInitLockMethod f_initLockMethodImplementation;

  private static LockingServicesTypeRenewLockMethod f_renewLockMethodImplementation;

  private static LockingServicesTypeExitLockMethod f_exitLockMethodImplementation;

  private static LockingServicesTypeBreakLockMethod f_breakLockMethodImplementation;

  protected LockingServicesTypeNodeBase(UaNode.Parameters parameters) {
    super(parameters);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<LockingServicesTypeNode> impl = getLockingServicesTypeNodeInitializer();
    if(impl != null) {
      impl.init((LockingServicesTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<LockingServicesTypeNode> getLockingServicesTypeNodeInitializer() {
    return f_lockingServicesTypeNodeInitializer;
  }

  public static void setLockingServicesTypeNodeInitializer(GeneratedNodeInitializer<LockingServicesTypeNode> f_lockingServicesTypeNodeInitializerNewValue) {
    f_lockingServicesTypeNodeInitializer=f_lockingServicesTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public UaProperty getLockedNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Locked");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Boolean isLocked() {
    UaVariable node = getLockedNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Locked does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Boolean) value;
  }

  @Mandatory
  @Override
  public void setLocked(Boolean value) {
    UaVariable node = getLockedNode();
    if (node == null) {
      throw new RuntimeException("Setting Locked failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Locked failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getLockingClientNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "LockingClient");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getLockingClient() {
    UaVariable node = getLockingClientNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node LockingClient does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setLockingClient(String value) {
    UaVariable node = getLockingClientNode();
    if (node == null) {
      throw new RuntimeException("Setting LockingClient failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting LockingClient failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getLockingUserNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "LockingUser");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getLockingUser() {
    UaVariable node = getLockingUserNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node LockingUser does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setLockingUser(String value) {
    UaVariable node = getLockingUserNode();
    if (node == null) {
      throw new RuntimeException("Setting LockingUser failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting LockingUser failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getRemainingLockTimeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "RemainingLockTime");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Double getRemainingLockTime() {
    UaVariable node = getRemainingLockTimeNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node RemainingLockTime does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Double) value;
  }

  @Mandatory
  @Override
  public void setRemainingLockTime(Double value) {
    UaVariable node = getRemainingLockTimeNode();
    if (node == null) {
      throw new RuntimeException("Setting RemainingLockTime failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting RemainingLockTime failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "InitLock"), methodId)) {
      return new Variant[]{new Variant(doInitLock(serviceContext, (String) inputArguments[0].getValue()))};
    }
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "RenewLock"), methodId)) {
      return new Variant[]{new Variant(doRenewLock(serviceContext))};
    }
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "ExitLock"), methodId)) {
      return new Variant[]{new Variant(doExitLock(serviceContext))};
    }
    if (isComponentMatch(getQualifiedName("http://opcfoundation.org/UA/DI/", "BreakLock"), methodId)) {
      return new Variant[]{new Variant(doBreakLock(serviceContext))};
    }
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }

  @Mandatory
  @Override
  public UaMethod getInitLockNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "InitLock");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract Integer onInitLock(ServiceContext serviceContext, String f_context) throws
      StatusException;

  @Override
  public Integer initLock(String f_context) throws StatusException {
    return doInitLock(ServiceContext.INTERNAL_OPERATION_CONTEXT, f_context);
  }

  private Integer doInitLock(ServiceContext serviceContext, String f_context) throws
      StatusException {
    LockingServicesTypeInitLockMethod impl = getInitLockMethodImplementation();
    if(impl != null) {
      return impl.initLock(serviceContext, (LockingServicesTypeNode)this, f_context);
    } else {
      return onInitLock(serviceContext, f_context);
    }
  }

  public static LockingServicesTypeInitLockMethod getInitLockMethodImplementation() {
    return f_initLockMethodImplementation;
  }

  public static void setInitLockMethodImplementation(LockingServicesTypeInitLockMethod f_initLockMethodImplementationNewValue) {
    f_initLockMethodImplementation=f_initLockMethodImplementationNewValue;
  }

  @Mandatory
  @Override
  public UaMethod getRenewLockNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "RenewLock");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract Integer onRenewLock(ServiceContext serviceContext) throws StatusException;

  @Override
  public Integer renewLock() throws StatusException {
    return doRenewLock(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private Integer doRenewLock(ServiceContext serviceContext) throws StatusException {
    LockingServicesTypeRenewLockMethod impl = getRenewLockMethodImplementation();
    if(impl != null) {
      return impl.renewLock(serviceContext, (LockingServicesTypeNode)this);
    } else {
      return onRenewLock(serviceContext);
    }
  }

  public static LockingServicesTypeRenewLockMethod getRenewLockMethodImplementation() {
    return f_renewLockMethodImplementation;
  }

  public static void setRenewLockMethodImplementation(LockingServicesTypeRenewLockMethod f_renewLockMethodImplementationNewValue) {
    f_renewLockMethodImplementation=f_renewLockMethodImplementationNewValue;
  }

  @Mandatory
  @Override
  public UaMethod getExitLockNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ExitLock");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract Integer onExitLock(ServiceContext serviceContext) throws StatusException;

  @Override
  public Integer exitLock() throws StatusException {
    return doExitLock(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private Integer doExitLock(ServiceContext serviceContext) throws StatusException {
    LockingServicesTypeExitLockMethod impl = getExitLockMethodImplementation();
    if(impl != null) {
      return impl.exitLock(serviceContext, (LockingServicesTypeNode)this);
    } else {
      return onExitLock(serviceContext);
    }
  }

  public static LockingServicesTypeExitLockMethod getExitLockMethodImplementation() {
    return f_exitLockMethodImplementation;
  }

  public static void setExitLockMethodImplementation(LockingServicesTypeExitLockMethod f_exitLockMethodImplementationNewValue) {
    f_exitLockMethodImplementation=f_exitLockMethodImplementationNewValue;
  }

  @Mandatory
  @Override
  public UaMethod getBreakLockNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "BreakLock");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract Integer onBreakLock(ServiceContext serviceContext) throws StatusException;

  @Override
  public Integer breakLock() throws StatusException {
    return doBreakLock(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private Integer doBreakLock(ServiceContext serviceContext) throws StatusException {
    LockingServicesTypeBreakLockMethod impl = getBreakLockMethodImplementation();
    if(impl != null) {
      return impl.breakLock(serviceContext, (LockingServicesTypeNode)this);
    } else {
      return onBreakLock(serviceContext);
    }
  }

  public static LockingServicesTypeBreakLockMethod getBreakLockMethodImplementation() {
    return f_breakLockMethodImplementation;
  }

  public static void setBreakLockMethodImplementation(LockingServicesTypeBreakLockMethod f_breakLockMethodImplementationNewValue) {
    f_breakLockMethodImplementation=f_breakLockMethodImplementationNewValue;
  }
}
