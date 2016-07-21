package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

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

public final class SeniorityCount
  implements FissileDataModel<SeniorityCount>, RecordTemplate<SeniorityCount>
{
  public static final SeniorityCountBuilder BUILDER = SeniorityCountBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long count;
  public final boolean hasCount;
  public final boolean hasLevel;
  public final boolean hasSeniority;
  public final int level;
  public final String seniority;
  
  SeniorityCount(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    seniority = paramString;
    count = paramLong;
    level = paramInt;
    hasSeniority = paramBoolean1;
    hasCount = paramBoolean2;
    hasLevel = paramBoolean3;
    _cachedId = null;
  }
  
  public final SeniorityCount accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSeniority)
    {
      paramDataProcessor.startRecordField$505cff1c("seniority");
      paramDataProcessor.processString(seniority);
    }
    if (hasCount)
    {
      paramDataProcessor.startRecordField$505cff1c("count");
      paramDataProcessor.processLong(count);
    }
    if (hasLevel)
    {
      paramDataProcessor.startRecordField$505cff1c("level");
      paramDataProcessor.processInt(level);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasSeniority) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount", "seniority");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCount) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount", "count");
      }
      if (!hasLevel) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount", "level");
      }
      return new SeniorityCount(seniority, count, level, hasSeniority, hasCount, hasLevel);
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
      paramObject = (SeniorityCount)paramObject;
      if (seniority != null)
      {
        if (seniority.equals(seniority)) {}
      }
      else {
        while (seniority != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
    } while (level == level);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasSeniority) {
      i = PegasusBinaryUtils.getEncodedLength(seniority) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCount) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasLevel) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (seniority != null) {}
    for (int i = seniority.hashCode();; i = 0)
    {
      i = ((i + 527) * 31 + (int)(count ^ count >>> 32)) * 31 + level;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SeniorityCount");
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
    label160:
    label227:
    label237:
    label245:
    label247:
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
        localByteBuffer.putInt(2013023136);
        if (hasSeniority)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, seniority);
          if (!hasCount) {
            break label227;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(count);
          if (!hasLevel) {
            break label237;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(level);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label245;
          }
          if (str != null) {
            break label247;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label160;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */