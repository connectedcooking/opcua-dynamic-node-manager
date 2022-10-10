// Generated by Prosys OPC UA Java SDK Codegen
//
package com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.server;

import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.BeverageSMLEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.ChamberModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CoffeeMachineModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CombiSteamerModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CommercialKitchenEquipmentDataTypeDictionaryHelper;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CommercialKitchenEquipmentSerializers;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CookingKettleModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.CurrentStateEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.EnergySourceEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.FryerModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.FryingPanModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.GrillingZoneStateEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.HygieneModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.MultiFunctionPanModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.OperatingModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.OperationModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.PastaCookerModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.PlatenPositionStateEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.PressureCookingKettleModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.ProgramModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.SignalModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.SpecialCookingModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.SpecialFunctionModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.StatusEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.TrayModeEnumeration;
import com.connectedcooking.opcua.dynamicnodemanager.examples.prosys.opc30200.model.cke.TrayTypeEnumeration;
import com.prosysopc.ua.server.ServerCodegenModel;
import com.prosysopc.ua.server.ServerCodegenModelProvider;
import java.lang.Override;
import java.lang.RuntimeException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Generated on 2022-10-10 10:21:34
 */
public class CommercialKitchenEquipmentServerInformationModel implements ServerCodegenModelProvider {
  public static final ServerCodegenModel MODEL;

  static {
    ServerCodegenModel.Builder b = ServerCodegenModel.builder();
    b.addClass(BatchInformationTypeNode.class);
    b.addClass(KitchenDeviceHAConfigTypeNode.class);
    b.addClass(KitchenDeviceParameterTypeNode.class);
    b.addClass(ChamberTypeNode.class);
    b.addClass(CoffeeMachineParameterTypeNode.class);
    b.addClass(CoffeeMachineRecipeParameterTypeNode.class);
    b.addClass(CombiSteamerParameterTypeNode.class);
    b.addClass(CookingKettleParameterTypeNode.class);
    b.addClass(CookingZoneParameterTypeNode.class);
    b.addClass(DishWashingMachineProgramParameterTypeNode.class);
    b.addClass(FryerParameterTypeNode.class);
    b.addClass(FryingAndGrillingParameterTypeNode.class);
    b.addClass(FryingPanParameterTypeNode.class);
    b.addClass(IceMachineParameterTypeNode.class);
    b.addClass(MicrowaveCombiOvenParameterTypeNode.class);
    b.addClass(MultiFunctionPanParameterTypeNode.class);
    b.addClass(PastaCookerParameterTypeNode.class);
    b.addClass(PressureCookingKettleParameterTypeNode.class);
    b.addClass(TrayTypeNode.class);
    b.addClass(CommercialKitchenDeviceTypeNode.class);
    b.addClass(CoffeeMachineDeviceTypeNode.class);
    b.addClass(CombiSteamerDeviceTypeNode.class);
    b.addClass(CookingKettleDeviceTypeNode.class);
    b.addClass(CookingZoneDeviceTypeNode.class);
    b.addClass(DishWashingMachineDeviceTypeNode.class);
    b.addClass(FryerDeviceTypeNode.class);
    b.addClass(FryingAndGrillingDeviceTypeNode.class);
    b.addClass(FryingPanDeviceTypeNode.class);
    b.addClass(IceMachineDeviceTypeNode.class);
    b.addClass(MicrowaveCombiOvenDeviceTypeNode.class);
    b.addClass(MultiFunctionPanDeviceTypeNode.class);
    b.addClass(OvenDeviceTypeNode.class);
    b.addClass(PastaCookerDeviceTypeNode.class);
    b.addClass(PressureCookingKettleDeviceTypeNode.class);
    b.addClass(ServeryCounterDeviceTypeNode.class);
    b.addSerializers(CommercialKitchenEquipmentSerializers.SERIALIZERS);
    b.setDataTypeDictionary(CommercialKitchenEquipmentDataTypeDictionaryHelper.createDataTypeDictionary());
    b.addEnumerationSpecification(BeverageSMLEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(ChamberModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(CoffeeMachineModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(CombiSteamerModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(CookingKettleModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(CurrentStateEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(EnergySourceEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(FryerModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(FryingPanModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(GrillingZoneStateEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(HygieneModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(MultiFunctionPanModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(OperatingModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(OperationModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(PastaCookerModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(PlatenPositionStateEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(PressureCookingKettleModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(ProgramModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(SignalModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(SpecialCookingModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(SpecialFunctionModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(StatusEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(TrayModeEnumeration.SPECIFICATION);
    b.addEnumerationSpecification(TrayTypeEnumeration.SPECIFICATION);
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