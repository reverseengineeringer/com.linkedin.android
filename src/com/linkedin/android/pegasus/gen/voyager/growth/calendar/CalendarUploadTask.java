package com.linkedin.android.pegasus.gen.voyager.growth.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CalendarUploadTask
  implements FissileDataModel<CalendarUploadTask>, RecordTemplate<CalendarUploadTask>
{
  public static final CalendarUploadTaskBuilder BUILDER = CalendarUploadTaskBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<CalendarUploadEvent> calenderUploadEvents;
  public final long endTime;
  public final boolean hasCalenderUploadEvents;
  public final boolean hasEndTime;
  public final boolean hasSource;
  public final boolean hasStartTime;
  public final CalendarSource source;
  public final long startTime;
  
  CalendarUploadTask(List<CalendarUploadEvent> paramList, CalendarSource paramCalendarSource, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      calenderUploadEvents = paramList;
      source = paramCalendarSource;
      startTime = paramLong1;
      endTime = paramLong2;
      hasCalenderUploadEvents = paramBoolean1;
      hasSource = paramBoolean2;
      hasStartTime = paramBoolean3;
      hasEndTime = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final CalendarUploadTask accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    CalendarUploadEvent localCalendarUploadEvent = null;
    boolean bool = false;
    if (hasCalenderUploadEvents)
    {
      paramDataProcessor.startRecordField$505cff1c("calenderUploadEvents");
      calenderUploadEvents.size();
      paramDataProcessor.startArray$13462e();
      localObject = localCalendarUploadEvent;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = calenderUploadEvents.iterator();
      if (localIterator.hasNext())
      {
        localCalendarUploadEvent = (CalendarUploadEvent)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localCalendarUploadEvent = localCalendarUploadEvent.accept(paramDataProcessor);; localCalendarUploadEvent = (CalendarUploadEvent)paramDataProcessor.processDataTemplate(localCalendarUploadEvent))
        {
          if ((localObject != null) && (localCalendarUploadEvent != null)) {
            ((List)localObject).add(localCalendarUploadEvent);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (bool = true;; bool = false)
    {
      if (hasSource)
      {
        paramDataProcessor.startRecordField$505cff1c("source");
        paramDataProcessor.processEnum(source);
      }
      if (hasStartTime)
      {
        paramDataProcessor.startRecordField$505cff1c("startTime");
        paramDataProcessor.processLong(startTime);
      }
      if (hasEndTime)
      {
        paramDataProcessor.startRecordField$505cff1c("endTime");
        paramDataProcessor.processLong(endTime);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label429;
      }
      try
      {
        if (hasCalenderUploadEvents) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "calenderUploadEvents");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasStartTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "startTime");
    }
    if (!hasEndTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "endTime");
    }
    if (calenderUploadEvents != null)
    {
      paramDataProcessor = calenderUploadEvents.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((CalendarUploadEvent)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "calenderUploadEvents");
        }
      }
    }
    return new CalendarUploadTask((List)localObject, source, startTime, endTime, bool, hasSource, hasStartTime, hasEndTime);
    label429:
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
      paramObject = (CalendarUploadTask)paramObject;
      if (calenderUploadEvents != null)
      {
        if (calenderUploadEvents.equals(calenderUploadEvents)) {}
      }
      else {
        while (calenderUploadEvents != null) {
          return false;
        }
      }
      if (source != null)
      {
        if (source.equals(source)) {}
      }
      else {
        while (source != null) {
          return false;
        }
      }
      if (startTime != startTime) {
        return false;
      }
    } while (endTime == endTime);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    int j = i;
    if (hasCalenderUploadEvents)
    {
      i += 2;
      Iterator localIterator = calenderUploadEvents.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        CalendarUploadEvent localCalendarUploadEvent = (CalendarUploadEvent)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localCalendarUploadEvent.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasSource) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasStartTime) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasEndTime) {
      i = j + 8;
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
    if (calenderUploadEvents != null) {}
    for (int i = calenderUploadEvents.hashCode();; i = 0)
    {
      if (source != null) {
        j = source.hashCode();
      }
      i = (((i + 527) * 31 + j) * 31 + (int)(startTime ^ startTime >>> 32)) * 31 + (int)(endTime ^ endTime >>> 32);
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CalendarUploadTask");
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
    label300:
    label367:
    label377:
    label385:
    label387:
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
        localByteBuffer.putInt(1812626023);
        if (hasCalenderUploadEvents)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, calenderUploadEvents.size());
          Iterator localIterator = calenderUploadEvents.iterator();
          while (localIterator.hasNext())
          {
            CalendarUploadEvent localCalendarUploadEvent = (CalendarUploadEvent)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localCalendarUploadEvent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localCalendarUploadEvent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasSource)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, source.ordinal());
          if (!hasStartTime) {
            break label367;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(startTime);
          if (!hasEndTime) {
            break label377;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(endTime);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label385;
          }
          if (str != null) {
            break label387;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label300;
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
    implements RecordTemplateBuilder<CalendarUploadTask>
  {
    public List<CalendarUploadEvent> calenderUploadEvents = null;
    public long endTime = 0L;
    public boolean hasCalenderUploadEvents = false;
    public boolean hasEndTime = false;
    public boolean hasSource = false;
    public boolean hasStartTime = false;
    public CalendarSource source = null;
    public long startTime = 0L;
    
    public final CalendarUploadTask build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (CalendarUploadTask.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (calenderUploadEvents != null)
      {
        paramFlavor = calenderUploadEvents.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((CalendarUploadEvent)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "calenderUploadEvents");
              if (!hasCalenderUploadEvents) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "calenderUploadEvents");
              }
              if (!hasStartTime) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "startTime");
              }
              if (hasEndTime) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask", "endTime");
            }
          }
        }
      }
      return new CalendarUploadTask(calenderUploadEvents, source, startTime, endTime, hasCalenderUploadEvents, hasSource, hasStartTime, hasEndTime);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */