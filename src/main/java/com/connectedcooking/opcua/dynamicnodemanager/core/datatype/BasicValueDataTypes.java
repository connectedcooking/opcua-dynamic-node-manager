package com.connectedcooking.opcua.dynamicnodemanager.core.datatype;

import com.connectedcooking.opcua.dynamicnodemanager.core.RealNodeId;

/**
 * Some useful basic data types as real node IDs.
 * https://reference.opcfoundation.org/v104/Core/docs/Part6/5.1.2/
 */
public interface BasicValueDataTypes {

    RealNodeId Boolean = new RealNodeId(0, 1);
    RealNodeId SByte = new RealNodeId(0, 2);
    RealNodeId Byte = new RealNodeId(0, 3);
    RealNodeId Int16 = new RealNodeId(0, 4);
    RealNodeId UInt16 = new RealNodeId(0, 5);
    RealNodeId Int32 = new RealNodeId(0, 6);
    RealNodeId UInt32 = new RealNodeId(0, 7);
    RealNodeId Int64 = new RealNodeId(0, 8);
    RealNodeId UInt64 = new RealNodeId(0, 9);
    RealNodeId Float = new RealNodeId(0, 10);
    RealNodeId Double = new RealNodeId(0, 11);
    RealNodeId String = new RealNodeId(0, 12);
    RealNodeId DateTime = new RealNodeId(0, 13);
    RealNodeId Guid = new RealNodeId(0, 14);
    RealNodeId ByteString = new RealNodeId(0, 15);
    RealNodeId XmlElement = new RealNodeId(0, 16);
    RealNodeId NodeId = new RealNodeId(0, 17);
    RealNodeId ExpandedNodeId = new RealNodeId(0, 18);
    RealNodeId StatusCode = new RealNodeId(0, 19);
    RealNodeId QualifiedName = new RealNodeId(0, 20);
    RealNodeId LocalizedText = new RealNodeId(0, 21);
    RealNodeId ExtensionObject = new RealNodeId(0, 22);
    RealNodeId DataValue = new RealNodeId(0, 23);
    RealNodeId Variant = new RealNodeId(0, 24);
    RealNodeId DiagnosticInfo = new RealNodeId(0, 25);
    RealNodeId Number = new RealNodeId(0, 26);
    RealNodeId Integer = new RealNodeId(0, 27);
    RealNodeId Enumeration = new RealNodeId(0, 29);
    RealNodeId Image = new RealNodeId(0, 30);
    RealNodeId Decimal = new RealNodeId(0, 50);
    RealNodeId StructureType = new RealNodeId(0, 98);
    RealNodeId StructureField = new RealNodeId(0, 101);
    RealNodeId EnumField = new RealNodeId(0, 102);
    RealNodeId IdType = new RealNodeId(0, 256);
    RealNodeId Counter = new RealNodeId(0, 289);
    RealNodeId Duration = new RealNodeId(0, 290);
    RealNodeId NumericRange = new RealNodeId(0, 291);
    RealNodeId Time = new RealNodeId(0, 292);
    RealNodeId Date = new RealNodeId(0, 293);
    RealNodeId LocaleId = new RealNodeId(0, 295);
}
