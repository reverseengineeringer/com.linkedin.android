package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PropsCollectionMetadata
  implements FissileDataModel<PropsCollectionMetadata>, RecordTemplate<PropsCollectionMetadata>
{
  public static final PropsCollectionMetadataBuilder BUILDER = PropsCollectionMetadataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasLastModifiedAt;
  public final boolean hasNumNewProps;
  public final long lastModifiedAt;
  public final int numNewProps;
  
  PropsCollectionMetadata(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    numNewProps = paramInt;
    lastModifiedAt = paramLong;
    hasNumNewProps = paramBoolean1;
    hasLastModifiedAt = paramBoolean2;
    _cachedId = null;
  }
  
  private PropsCollectionMetadata accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumNewProps)
    {
      paramDataProcessor.startRecordField$505cff1c("numNewProps");
      paramDataProcessor.processInt(numNewProps);
    }
    if (hasLastModifiedAt)
    {
      paramDataProcessor.startRecordField$505cff1c("lastModifiedAt");
      paramDataProcessor.processLong(lastModifiedAt);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasNumNewProps) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropsCollectionMetadata", "numNewProps");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new PropsCollectionMetadata(numNewProps, lastModifiedAt, hasNumNewProps, hasLastModifiedAt);
    }
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
      paramObject = (PropsCollectionMetadata)paramObject;
      if (numNewProps != numNewProps) {
        return false;
      }
    } while (lastModifiedAt == lastModifiedAt);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumNewProps) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasLastModifiedAt) {
      i = j + 8;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = (numNewProps + 527) * 31 + (int)(lastModifiedAt ^ lastModifiedAt >>> 32);
    _cachedHashCode = i;
    return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PropsCollectionMetadata");
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
    label201:
    label209:
    label211:
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
        localByteBuffer.putInt(-204786235);
        if (hasNumNewProps)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numNewProps);
          if (!hasLastModifiedAt) {
            break label201;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(lastModifiedAt);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label209;
          }
          if (str != null) {
            break label211;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropsCollectionMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */