package com.linkedin.android.pegasus.gen.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Date
  implements FissileDataModel<Date>, RecordTemplate<Date>
{
  public static final DateBuilder BUILDER = DateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final int day;
  public final boolean hasDay;
  public final boolean hasMonth;
  public final boolean hasYear;
  public final int month;
  public final int year;
  
  Date(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    day = paramInt1;
    month = paramInt2;
    year = paramInt3;
    hasDay = paramBoolean1;
    hasMonth = paramBoolean2;
    hasYear = paramBoolean3;
    _cachedId = null;
  }
  
  public final Date accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasDay)
    {
      paramDataProcessor.startRecordField$505cff1c("day");
      paramDataProcessor.processInt(day);
    }
    if (hasMonth)
    {
      paramDataProcessor.startRecordField$505cff1c("month");
      paramDataProcessor.processInt(month);
    }
    if (hasYear)
    {
      paramDataProcessor.startRecordField$505cff1c("year");
      paramDataProcessor.processInt(year);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new Date(day, month, year, hasDay, hasMonth, hasYear);
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
      paramObject = (Date)paramObject;
      if (day != day) {
        return false;
      }
      if (month != month) {
        return false;
      }
    } while (year == year);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasDay) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasMonth) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasYear) {
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
    int i = ((day + 527) * 31 + month) * 31 + year;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Date");
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
        localByteBuffer.putInt(3177425);
        if (hasDay)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(day);
          if (!hasMonth) {
            break label225;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(month);
          if (!hasYear) {
            break label235;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(year);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Date>
  {
    private int day = 0;
    private boolean hasDay = false;
    private boolean hasMonth = false;
    private boolean hasYear = false;
    private int month = 0;
    private int year = 0;
    
    public final Date build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = Date.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new Date(day, month, year, hasDay, hasMonth, hasYear);
    }
    
    public final Builder setDay(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasDay = false;
        day = 0;
        return this;
      }
      hasDay = true;
      day = paramInteger.intValue();
      return this;
    }
    
    public final Builder setMonth(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasMonth = false;
        month = 0;
        return this;
      }
      hasMonth = true;
      month = paramInteger.intValue();
      return this;
    }
    
    public final Builder setYear(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasYear = false;
        year = 0;
        return this;
      }
      hasYear = true;
      year = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.Date
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */