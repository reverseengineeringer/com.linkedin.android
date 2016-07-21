package com.linkedin.crosspromo.common.android;

import com.linkedin.android.fission.interfaces.FissileModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.jackson.JacksonJsonGenerator;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AnyRecord
  implements FissileModel, RecordTemplate<AnyRecord>
{
  public static final AnyRecordBuilder BUILDER = AnyRecordBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _json;
  
  AnyRecord(String paramString)
  {
    _json = paramString;
  }
  
  public final AnyRecord accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    if ((paramDataProcessor instanceof JacksonJsonGenerator)) {
      ((JacksonJsonGenerator)paramDataProcessor).processJsonString(_json);
    }
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new AnyRecord(_json);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    return _json.equals(_json);
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    __sizeOfObject = 5;
    return 5;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    _cachedHashCode = 17;
    return 17;
  }
  
  public final String id()
  {
    return null;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    if ((paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AnyRecord");
    }
    if (paramBoolean) {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
    }
    ByteBuffer localByteBuffer;
    do
    {
      return;
      localByteBuffer = paramByteBuffer;
      if (paramByteBuffer == null) {
        localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
      }
      localByteBuffer.put((byte)1);
      localByteBuffer.putInt(2010813710);
      paramFissionAdapter.writeString(localByteBuffer, _json);
    } while (paramByteBuffer != null);
    paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
    paramFissionAdapter.recycle(localByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.common.android.AnyRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */