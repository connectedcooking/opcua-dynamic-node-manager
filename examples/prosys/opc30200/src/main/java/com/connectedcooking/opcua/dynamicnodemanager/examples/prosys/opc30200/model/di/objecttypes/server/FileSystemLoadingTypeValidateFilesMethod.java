// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.FileSystemLoadingType;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.NodeId;

public abstract interface FileSystemLoadingTypeValidateFilesMethod {
  FileSystemLoadingType.ValidateFilesMethodOutputs validateFiles(ServiceContext serviceContext,
      FileSystemLoadingTypeNode node, NodeId[] f_nodeIds) throws StatusException;
}