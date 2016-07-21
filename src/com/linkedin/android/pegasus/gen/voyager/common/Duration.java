package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Duration
  implements FissileDataModel<Duration>, RecordTemplate<Duration>
{
  public static final DurationBuilder BUILDER = DurationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasNumDays;
  public final boolean hasNumMonths;
  public final boolean hasNumYears;
  public final int numDays;
  public final int numMonths;
  public final int numYears;
  
  Duration(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    numDays = paramInt1;
    numMonths = paramInt2;
    numYears = paramInt3;
    hasNumDays = paramBoolean1;
    hasNumMonths = paramBoolean2;
    hasNumYears = paramBoolean3;
    _cachedId = null;
  }
  
  public final Duration accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasNumDays)
    {
      paramDataProcessor.startRecordField$505cff1c("numDays");
      paramDataProcessor.processInt(numDays);
    }
    if (hasNumMonths)
    {
      paramDataProcessor.startRecordField$505cff1c("numMonths");
      paramDataProcessor.processInt(numMonths);
    }
    if (hasNumYears)
    {
      paramDataProcessor.startRecordField$505cff1c("numYears");
      paramDataProcessor.processInt(numYears);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new Duration(numDays, numMonths, numYears, hasNumDays, hasNumMonths, hasNumYears);
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
      paramObject = (Duration)paramObject;
      if (numDays != numDays) {
        return false;
      }
      if (numMonths != numMonths) {
        return false;
      }
    } while (numYears == numYears);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasNumDays) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumMonths) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasNumYears) {
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
    int i = ((numDays + 527) * 31 + numMonths) * 31 + numYears;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Duration");
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
    label225:
    label235:
    label243:
    label245:
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
        localByteBuffer.putInt(-1847699885);
        if (hasNumDays)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numDays);
          if (!hasNumMonths) {
            break label225;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numMonths);
          if (!hasNumYears) {
            break label235;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(numYears);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label243;
          }
          if (str != null) {
            break label245;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Duration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */