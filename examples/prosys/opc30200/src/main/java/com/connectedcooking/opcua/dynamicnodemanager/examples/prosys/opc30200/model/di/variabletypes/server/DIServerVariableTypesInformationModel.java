// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.variabletypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.DIUaIds;
import com.prosysopc.ua.server.ServerCodegenModel;

/**
 * Generated on 2024-09-09 10:35:45
 */
public class DIServerVariableTypesInformationModel {
  public static final ServerCodegenModel MODEL;

  static {
    ServerCodegenModel.Builder b = ServerCodegenModel.builder();
    //LifetimeVariableType, nsu=http://opcfoundation.org/UA/DI/;i=468
    b.addClass(DIUaIds.LifetimeVariableType, LifetimeVariableTypeNode::new);
    //UIElementType, nsu=http://opcfoundation.org/UA/DI/;i=6246
    b.addClass(DIUaIds.UIElementType, UIElementTypeNode::new);
    MODEL = b.build();
  }
}
