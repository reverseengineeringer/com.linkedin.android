package com.linkedin.android.pegasus.gen.voyager.entities.job.analytics;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EmployeeCount
  implements FissileDataModel<EmployeeCount>, RecordTemplate<EmployeeCount>
{
  public static final EmployeeCountBuilder BUILDER = EmployeeCountBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final long count;
  public final Date date;
  public final boolean hasCount;
  public final boolean hasDate;
  public final boolean hasRecordedOn;
  public final Date recordedOn;
  
  EmployeeCount(Date paramDate1, Date paramDate2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    date = paramDate1;
    recordedOn = paramDate2;
    count = paramLong;
    hasDate = paramBoolean1;
    hasRecordedOn = paramBoolean2;
    hasCount = paramBoolean3;
    _cachedId = null;
  }
  
  public final EmployeeCount accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    Date localDate;
    if (hasDate)
    {
      paramDataProcessor.startRecordField$505cff1c("date");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localDate = date.accept(paramDataProcessor);
        if (localDate == null) {
          break label189;
        }
        bool1 = true;
        localObject = localDate;
      }
    }
    else
    {
      label56:
      localDate = null;
      bool2 = false;
      if (hasRecordedOn)
      {
        paramDataProcessor.startRecordField$505cff1c("recordedOn");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localDate = recordedOn.accept(paramDataProcessor);
        label95:
        if (localDate == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasCount)
      {
        paramDataProcessor.startRecordField$505cff1c("count");
        paramDataProcessor.processLong(count);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasCount) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EmployeeCount", "count");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localDate = (Date)paramDataProcessor.processDataTemplate(date);
      break;
      bool1 = false;
      localObject = localDate;
      break label56;
      localDate = (Date)paramDataProcessor.processDataTemplate(recordedOn);
      break label95;
    }
    label221:
    return new EmployeeCount((Date)localObject, localDate, count, bool1, bool2, hasCount);
    label243:
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
      paramObject = (EmployeeCount)paramObject;
      if (date != null)
      {
        if (date.equals(date)) {}
      }
      else {
        while (date != null) {
          return false;
        }
      }
      if (recordedOn != null)
      {
        if (recordedOn.equals(recordedOn)) {}
      }
      else {
        while (recordedOn != null) {
          return false;
        }
      }
    } while (count == count);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j;
    if (hasDate)
    {
      if (date._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(date._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasRecordedOn)
      {
        i = j + 1;
        if (recordedOn._cachedId == null) {
          break label132;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(recordedOn._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasCount) {
        i = j + 8;
      }
      __sizeOfObject = i;
      return i;
      i = date.getSerializedSize() + 7;
      break;
      label132:
      i += recordedOn.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (date != null) {}
    for (int i = date.hashCode();; i = 0)
    {
      if (recordedOn != null) {
        j = recordedOn.hashCode();
      }
      i = ((i + 527) * 31 + j) * 31 + (int)(count ^ count >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building EmployeeCount");
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
    label230:
    label322:
    label347:
    label357:
    label365:
    label367:
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
        localByteBuffer.putInt(304478099);
        if (hasDate)
        {
          localByteBuffer.put((byte)1);
          if (date._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, date._cachedId);
            date.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasRecordedOn) {
              break label347;
            }
            localByteBuffer.put((byte)1);
            if (recordedOn._cachedId == null) {
              break label322;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, recordedOn._cachedId);
            recordedOn.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCount) {
              break label357;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putLong(count);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label365;
          }
          if (str != null) {
            break label367;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          date.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          recordedOn.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EmployeeCount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */