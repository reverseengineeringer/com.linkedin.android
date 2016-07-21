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

public final class DateRange
  implements FissileDataModel<DateRange>, RecordTemplate<DateRange>
{
  public static final DateRangeBuilder BUILDER = DateRangeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Date end;
  public final boolean hasEnd;
  public final boolean hasStart;
  public final Date start;
  
  DateRange(Date paramDate1, Date paramDate2, boolean paramBoolean1, boolean paramBoolean2)
  {
    start = paramDate1;
    end = paramDate2;
    hasStart = paramBoolean1;
    hasEnd = paramBoolean2;
    _cachedId = null;
  }
  
  public final DateRange accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    Date localDate;
    if (hasStart)
    {
      paramDataProcessor.startRecordField$505cff1c("start");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localDate = start.accept(paramDataProcessor);
        if (localDate == null) {
          break label149;
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
      if (hasEnd)
      {
        paramDataProcessor.startRecordField$505cff1c("end");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localDate = end.accept(paramDataProcessor);
        label95:
        if (localDate == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new DateRange((Date)localObject, localDate, bool1, bool2);
      localDate = (Date)paramDataProcessor.processDataTemplate(start);
      break;
      bool1 = false;
      localObject = localDate;
      break label56;
      localDate = (Date)paramDataProcessor.processDataTemplate(end);
      break label95;
    }
    label181:
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
      paramObject = (DateRange)paramObject;
      if (start != null)
      {
        if (start.equals(start)) {}
      }
      else {
        while (start != null) {
          return false;
        }
      }
      if (end == null) {
        break;
      }
    } while (end.equals(end));
    for (;;)
    {
      return false;
      if (end == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasStart)
    {
      if (start._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(start._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasEnd)
      {
        i = j + 1;
        if (end._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(end._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = start.getSerializedSize() + 7;
      break;
      label114:
      i += end.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (start != null) {}
    for (int i = start.hashCode();; i = 0)
    {
      if (end != null) {
        j = end.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building DateRange");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(1954515866);
        if (hasStart)
        {
          localByteBuffer.put((byte)1);
          if (start._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, start._cachedId);
            start.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEnd) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (end._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, end._cachedId);
            end.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          start.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          end.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.DateRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */