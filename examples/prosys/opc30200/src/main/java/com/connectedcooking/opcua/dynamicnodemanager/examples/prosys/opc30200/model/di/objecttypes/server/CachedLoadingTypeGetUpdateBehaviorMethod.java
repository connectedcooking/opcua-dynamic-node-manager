// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.objecttypes.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.di.datatypes.UpdateBehavior;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.server.ServiceContext;
import java.lang.String;

public abstract interface CachedLoadingTypeGetUpdateBehaviorMethod {
  UpdateBehavior getUpdateBehavior(ServiceContext serviceContext, CachedLoadingTypeNode node,
      String f_manufacturerUri, String f_softwareRevision, String[] f_patchIdentifiers) throws
      StatusException;
}
