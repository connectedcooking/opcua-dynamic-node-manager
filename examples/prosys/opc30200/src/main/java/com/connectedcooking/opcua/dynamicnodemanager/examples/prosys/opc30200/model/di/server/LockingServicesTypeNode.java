// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.server;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.core.StatusCodes;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;

/**
 * An interface for Locking.
 * <p>
 * Generated on 2022-10-10 10:21:30
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6388")
public class LockingServicesTypeNode extends LockingServicesTypeNodeBase {
  protected LockingServicesTypeNode(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    // Use this method to initialize the nodes, when they are all created.
    // Note that 'super.afterCreate()' performs default initializations, so consider
    // whether your own initializations should be done before or after it.
    super.afterCreate();
  }

  @Override
  protected Integer onInitLock(ServiceContext serviceContext, String f_context) throws
      StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setInitLockMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }

  @Override
  protected Integer onRenewLock(ServiceContext serviceContext) throws StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setRenewLockMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }

  @Override
  protected Integer onExitLock(ServiceContext serviceContext) throws StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setExitLockMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }

  @Override
  protected Integer onBreakLock(ServiceContext serviceContext) throws StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setBreakLockMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }
}