package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class DateRange
  implements FissileDataModel<DateRange>, RecordTemplate<DateRange>
{
  public static final DateRangeBuilder BUILDER = DateRangeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Date endDate;
  public final boolean hasEndDate;
  public final boolean hasStartDate;
  public final Date startDate;
  
  DateRange(Date paramDate1, Date paramDate2, boolean paramBoolean1, boolean paramBoolean2)
  {
    startDate = paramDate1;
    endDate = paramDate2;
    hasStartDate = paramBoolean1;
    hasEndDate = paramBoolean2;
    _cachedId = null;
  }
  
  public final DateRange accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    Date localDate;
    if (hasStartDate)
    {
      paramDataProcessor.startRecordField$505cff1c("startDate");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localDate = startDate.accept(paramDataProcessor);
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
      if (hasEndDate)
      {
        paramDataProcessor.startRecordField$505cff1c("endDate");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localDate = endDate.accept(paramDataProcessor);
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
      localDate = (Date)paramDataProcessor.processDataTemplate(startDate);
      break;
      bool1 = false;
      localObject = localDate;
      break label56;
      localDate = (Date)paramDataProcessor.processDataTemplate(endDate);
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
      if (startDate != null)
      {
        if (startDate.equals(startDate)) {}
      }
      else {
        while (startDate != null) {
          return false;
        }
      }
      if (endDate == null) {
        break;
      }
    } while (endDate.equals(endDate));
    for (;;)
    {
      return false;
      if (endDate == null) {
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
    if (hasStartDate)
    {
      if (startDate._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(startDate._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasEndDate)
      {
        i = j + 1;
        if (endDate._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(endDate._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = startDate.getSerializedSize() + 7;
      break;
      label114:
      i += endDate.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (startDate != null) {}
    for (int i = startDate.hashCode();; i = 0)
    {
      if (endDate != null) {
        j = endDate.hashCode();
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
        localByteBuffer.putInt(1385617250);
        if (hasStartDate)
        {
          localByteBuffer.put((byte)1);
          if (startDate._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, startDate._cachedId);
            startDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEndDate) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (endDate._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, endDate._cachedId);
            endDate.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          startDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          endDate.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<DateRange>
  {
    private Date endDate = null;
    private boolean hasEndDate = false;
    private boolean hasStartDate = false;
    private Date startDate = null;
    
    public final DateRange build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = DateRange.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new DateRange(startDate, endDate, hasStartDate, hasEndDate);
    }
    
    public final Builder setEndDate(Date paramDate)
    {
      if (paramDate == null)
      {
        hasEndDate = false;
        endDate = null;
        return this;
      }
      hasEndDate = true;
      endDate = paramDate;
      return this;
    }
    
    public final Builder setStartDate(Date paramDate)
    {
      if (paramDate == null)
      {
        hasStartDate = false;
        startDate = null;
        return this;
      }
      hasStartDate = true;
      startDate = paramDate;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.DateRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */