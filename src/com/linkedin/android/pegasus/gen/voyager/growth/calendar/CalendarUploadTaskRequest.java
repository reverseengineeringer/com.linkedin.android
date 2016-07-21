package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CalendarUploadTaskRequest
  implements FissileDataModel<CalendarUploadTaskRequest>, RecordTemplate<CalendarUploadTaskRequest>
{
  public static final CalendarUploadTaskRequestBuilder BUILDER = CalendarUploadTaskRequestBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final CalendarUploadTask calendarUploadTask;
  public final boolean hasCalendarUploadTask;
  
  CalendarUploadTaskRequest(CalendarUploadTask paramCalendarUploadTask, boolean paramBoolean)
  {
    calendarUploadTask = paramCalendarUploadTask;
    hasCalendarUploadTask = paramBoolean;
    _cachedId = null;
  }
  
  private CalendarUploadTaskRequest accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    CalendarUploadTask localCalendarUploadTask = null;
    boolean bool = false;
    if (hasCalendarUploadTask)
    {
      paramDataProcessor.startRecordField$505cff1c("calendarUploadTask");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localCalendarUploadTask = calendarUploadTask.accept(paramDataProcessor);
      if (localCalendarUploadTask == null) {
        break label110;
      }
    }
    label93:
    label110:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label125;
      }
      try
      {
        if (hasCalendarUploadTask) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest", "calendarUploadTask");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localCalendarUploadTask = (CalendarUploadTask)paramDataProcessor.processDataTemplate(calendarUploadTask);
      break;
    }
    label115:
    return new CalendarUploadTaskRequest(localCalendarUploadTask, bool);
    label125:
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
      paramObject = (CalendarUploadTaskRequest)paramObject;
      if (calendarUploadTask == null) {
        break;
      }
    } while (calendarUploadTask.equals(calendarUploadTask));
    for (;;)
    {
      return false;
      if (calendarUploadTask == null) {
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
    if (hasCalendarUploadTask) {
      if (calendarUploadTask._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(calendarUploadTask._cachedId) + 9;; i = calendarUploadTask.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (calendarUploadTask != null) {}
    for (int i = calendarUploadTask.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CalendarUploadTaskRequest");
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
    label238:
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
        localByteBuffer.putInt(-231213064);
        if (hasCalendarUploadTask)
        {
          localByteBuffer.put((byte)1);
          if (calendarUploadTask._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, calendarUploadTask._cachedId);
            calendarUploadTask.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          calendarUploadTask.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<CalendarUploadTaskRequest>
  {
    public CalendarUploadTask calendarUploadTask = null;
    public boolean hasCalendarUploadTask = false;
    
    public final CalendarUploadTaskRequest build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (CalendarUploadTaskRequest.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new CalendarUploadTaskRequest(calendarUploadTask, hasCalendarUploadTask);
      } while (hasCalendarUploadTask);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest", "calendarUploadTask");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTaskRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */