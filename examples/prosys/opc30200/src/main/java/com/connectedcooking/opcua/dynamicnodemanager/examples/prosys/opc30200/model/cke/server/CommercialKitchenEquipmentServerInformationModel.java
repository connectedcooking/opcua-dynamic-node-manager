// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CommercialKitchenEquipmentCommonInformationModel;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CommercialKitchenEquipmentDataTypeDictionaryHelper;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.objecttypes.server.CommercialKitchenEquipmentServerObjectTypesInformationModel;
import com.prosysopc.ua.server.ServerCodegenModel;
import com.prosysopc.ua.server.ServerCodegenModelProvider;
import java.lang.Override;
import java.lang.RuntimeException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Generated on 2023-09-26 10:56:54
 */
public class CommercialKitchenEquipmentServerInformationModel implements ServerCodegenModelProvider {
  public static final ServerCodegenModel MODEL;

  static {
    ServerCodegenModel.Builder b = ServerCodegenModel.builder();
    b.addAll(CommercialKitchenEquipmentServerObjectTypesInformationModel.MODEL);
    b.setDataTypeDictionary(CommercialKitchenEquipmentDataTypeDictionaryHelper.createDataTypeDictionary());
    b.addAll(CommercialKitchenEquipmentCommonInformationModel.MODEL);
    MODEL = b.build();
  }

  @Override
  public ServerCodegenModel get() {
    return MODEL;
  }

  /**
   * Returns URI for the NodeSet XML file 'Opc.Ua.CommercialKitchenEquipment.NodeSet2.xml', assuming it is put into classpath next to classfile of this class. You can use the 'server_model' codegen target to do it automatically as part of the code generation. If the file is not found this method will throw RuntimeException.
   */
  public static URI getLocationURI() {
    URL nodeset = CommercialKitchenEquipmentServerInformationModel.class.getResource("Opc.Ua.CommercialKitchenEquipment.NodeSet2.xml");
    if (nodeset == null) {
      throw new RuntimeException("Cannot find nodeset 'Opc.Ua.CommercialKitchenEquipment.NodeSet2.xml' in classpath next to "+CommercialKitchenEquipmentServerInformationModel.class);
    }
    try {
      return nodeset.toURI();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
