package com.linkedin.android.pegasus.gen.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TimeRange
  implements FissileDataModel<TimeRange>, RecordTemplate<TimeRange>
{
  public static final TimeRangeBuilder BUILDER = TimeRangeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final long end;
  public final boolean hasEnd;
  public final boolean hasStart;
  public final long start;
  
  TimeRange(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    start = paramLong1;
    end = paramLong2;
    hasStart = paramBoolean1;
    hasEnd = paramBoolean2;
    _cachedId = null;
  }
  
  public final TimeRange accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStart)
    {
      paramDataProcessor.startRecordField$505cff1c("start");
      paramDataProcessor.processLong(start);
    }
    if (hasEnd)
    {
      paramDataProcessor.startRecordField$505cff1c("end");
      paramDataProcessor.processLong(end);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new TimeRange(start, end, hasStart, hasEnd);
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
      paramObject = (TimeRange)paramObject;
      if (start != start) {
        return false;
      }
    } while (end == end);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasStart) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasEnd) {
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
    int i = ((int)(start ^ start >>> 32) + 527) * 31 + (int)(end ^ end >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TimeRange");
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
        localByteBuffer.putInt(1516381760);
        if (hasStart)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(start);
          if (!hasEnd) {
            break label201;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(end);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.TimeRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */