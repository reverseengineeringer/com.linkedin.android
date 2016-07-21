package com.linkedin.android.pegasus.gen.pemberly.text;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Attribute
  implements FissileDataModel<Attribute>, RecordTemplate<Attribute>
{
  public static final AttributeBuilder BUILDER = AttributeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasLength;
  public final boolean hasStart;
  public final boolean hasType;
  public final int length;
  public final int start;
  public final AttributeType type;
  
  Attribute(int paramInt1, int paramInt2, AttributeType paramAttributeType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    start = paramInt1;
    length = paramInt2;
    type = paramAttributeType;
    hasStart = paramBoolean1;
    hasLength = paramBoolean2;
    hasType = paramBoolean3;
    _cachedId = null;
  }
  
  public final Attribute accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStart)
    {
      paramDataProcessor.startRecordField$505cff1c("start");
      paramDataProcessor.processInt(start);
    }
    if (hasLength)
    {
      paramDataProcessor.startRecordField$505cff1c("length");
      paramDataProcessor.processInt(length);
    }
    AttributeType localAttributeType = null;
    boolean bool = false;
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localAttributeType = type.accept(paramDataProcessor);
      if (localAttributeType == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasStart) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "start");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAttributeType = (AttributeType)paramDataProcessor.processDataTemplate(type);
      break;
    }
    label165:
    if (!hasLength) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "length");
    }
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "type");
    }
    return new Attribute(start, length, localAttributeType, hasStart, hasLength, bool);
    label229:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Attribute)paramObject;
      if (start != start) {
        return false;
      }
      if (length != length) {
        return false;
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasStart) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasLength) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasType)
    {
      i = j + 1;
      if (type._cachedId == null) {
        break label99;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(type._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label99:
      i += type.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int j = start;
    int k = length;
    if (type != null) {}
    for (int i = type.hashCode();; i = 0)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Attribute");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label158:
    label261:
    label271:
    label296:
    label304:
    label306:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(508115185);
        if (hasStart)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(start);
          if (!hasLength) {
            break label261;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(length);
          if (!hasType) {
            break label296;
          }
          localByteBuffer.put((byte)1);
          if (type._cachedId == null) {
            break label271;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, type._cachedId);
          type.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label304;
          }
          if (str != null) {
            break label306;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
          localByteBuffer.put((byte)1);
          type.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<Attribute>
  {
    public boolean hasLength = false;
    public boolean hasStart = false;
    public boolean hasType = false;
    public int length = 0;
    public int start = 0;
    public AttributeType type = null;
    
    public final Attribute build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Attribute.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Attribute(start, length, type, hasStart, hasLength, hasType);
        if (!hasStart) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "start");
        }
        if (!hasLength) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "length");
        }
      } while (hasType);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "type");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.Attribute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */