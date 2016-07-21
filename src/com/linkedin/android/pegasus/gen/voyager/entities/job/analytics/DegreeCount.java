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

public final class DegreeCount
  implements FissileDataModel<DegreeCount>, RecordTemplate<DegreeCount>
{
  public static final DegreeCountBuilder BUILDER = DegreeCountBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long count;
  public final String degree;
  public final boolean hasCount;
  public final boolean hasDegree;
  public final boolean hasPercent;
  public final boolean hasSharedDegree;
  public final int percent;
  public final boolean sharedDegree;
  
  DegreeCount(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    degree = paramString;
    count = paramLong;
    percent = paramInt;
    sharedDegree = paramBoolean1;
    hasDegree = paramBoolean2;
    hasCount = paramBoolean3;
    hasPercent = paramBoolean4;
    hasSharedDegree = paramBoolean5;
    _cachedId = null;
  }
  
  public final DegreeCount accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasDegree)
    {
      paramDataProcessor.startRecordField$505cff1c("degree");
      paramDataProcessor.processString(degree);
    }
    if (hasCount)
    {
      paramDataProcessor.startRecordField$505cff1c("count");
      paramDataProcessor.processLong(count);
    }
    if (hasPercent)
    {
      paramDataProcessor.startRecordField$505cff1c("percent");
      paramDataProcessor.processInt(percent);
    }
    if (hasSharedDegree)
    {
      paramDataProcessor.startRecordField$505cff1c("sharedDegree");
      paramDataProcessor.processBoolean(sharedDegree);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasDegree) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount", "degree");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCount) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount", "count");
      }
      if (!hasPercent) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount", "percent");
      }
      return new DegreeCount(degree, count, percent, sharedDegree, hasDegree, hasCount, hasPercent, hasSharedDegree);
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
      paramObject = (DegreeCount)paramObject;
      if (degree != null)
      {
        if (degree.equals(degree)) {}
      }
      else {
        while (degree != null) {
          return false;
        }
      }
      if (count != count) {
        return false;
      }
      if (percent != percent) {
        return false;
      }
    } while (sharedDegree == sharedDegree);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasDegree) {
      i = PegasusBinaryUtils.getEncodedLength(degree) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCount) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasPercent) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasSharedDegree) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (degree != null) {}
    for (int i = degree.hashCode();; i = 0)
    {
      int k = (int)(count ^ count >>> 32);
      int m = percent;
      if (sharedDegree) {
        j = 1;
      }
      i = (((i + 527) * 31 + k) * 31 + m) * 31 + j;
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
    int i = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DegreeCount");
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
    label163:
    label187:
    label208:
    label260:
    label270:
    label280:
    label286:
    label294:
    label296:
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
        localByteBuffer.putInt(-829717739);
        if (hasDegree)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, degree);
          if (!hasCount) {
            break label260;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(count);
          if (!hasPercent) {
            break label270;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(percent);
          if (!hasSharedDegree) {
            break label286;
          }
          localByteBuffer.put((byte)1);
          if (!sharedDegree) {
            break label280;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label294;
          }
          if (str != null) {
            break label296;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label163;
          localByteBuffer.put((byte)0);
          break label187;
          i = 0;
          break label208;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */