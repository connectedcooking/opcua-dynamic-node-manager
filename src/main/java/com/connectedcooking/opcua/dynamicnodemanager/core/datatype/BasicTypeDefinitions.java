package com.connectedcooking.opcua.dynamicnodemanager.core.datatype;

import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

/**
 * Some useful basic type definitions as real node IDs.
 * https://reference.opcfoundation.org/v104/Core/docs/Part5/7.1/
 */
public interface BasicTypeDefinitions {

    RealNodeId BaseObjectType = new RealNodeId(0, 58);
    RealNodeId BaseVariableType = new RealNodeId(0, 62);
    RealNodeId BaseDataVariableType = new RealNodeId(0, 63);
    RealNodeId PropertyType = new RealNodeId(0, 68);

    RealNodeId AnalogItemType = new RealNodeId(0, 2368);

    RealNodeId NamespaceMetadataType = new RealNodeId(0, 11616);
}
