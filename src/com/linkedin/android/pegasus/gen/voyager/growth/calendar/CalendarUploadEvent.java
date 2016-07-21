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

public final class CalendarUploadEvent
  implements FissileDataModel<CalendarUploadEvent>, RecordTemplate<CalendarUploadEvent>
{
  public static final CalendarUploadEventBuilder BUILDER = CalendarUploadEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final List<CalendarEventAttendee> attendees;
  public final long endTime;
  public final String externalId;
  public final boolean fullDayEvent;
  public final boolean hasAttendees;
  public final boolean hasEndTime;
  public final boolean hasExternalId;
  public final boolean hasFullDayEvent;
  public final boolean hasLocation;
  public final boolean hasRecurring;
  public final boolean hasSource;
  public final boolean hasStartTime;
  public final boolean hasStatus;
  public final boolean hasTitle;
  public final String location;
  public final boolean recurring;
  public final CalendarSource source;
  public final long startTime;
  public final CalendarEventAvailability status;
  public final String title;
  
  CalendarUploadEvent(String paramString1, CalendarSource paramCalendarSource, long paramLong1, long paramLong2, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, List<CalendarEventAttendee> paramList, CalendarEventAvailability paramCalendarEventAvailability, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12)
  {
    externalId = paramString1;
    source = paramCalendarSource;
    startTime = paramLong1;
    endTime = paramLong2;
    title = paramString2;
    location = paramString3;
    fullDayEvent = paramBoolean1;
    recurring = paramBoolean2;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      attendees = paramString1;
      status = paramCalendarEventAvailability;
      hasExternalId = paramBoolean3;
      hasSource = paramBoolean4;
      hasStartTime = paramBoolean5;
      hasEndTime = paramBoolean6;
      hasTitle = paramBoolean7;
      hasLocation = paramBoolean8;
      hasFullDayEvent = paramBoolean9;
      hasRecurring = paramBoolean10;
      hasAttendees = paramBoolean11;
      hasStatus = paramBoolean12;
      _cachedId = null;
      return;
    }
  }
  
  public final CalendarUploadEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasExternalId)
    {
      paramDataProcessor.startRecordField$505cff1c("externalId");
      paramDataProcessor.processString(externalId);
    }
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
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      paramDataProcessor.processString(title);
    }
    if (hasLocation)
    {
      paramDataProcessor.startRecordField$505cff1c("location");
      paramDataProcessor.processString(location);
    }
    if (hasFullDayEvent)
    {
      paramDataProcessor.startRecordField$505cff1c("fullDayEvent");
      paramDataProcessor.processBoolean(fullDayEvent);
    }
    if (hasRecurring)
    {
      paramDataProcessor.startRecordField$505cff1c("recurring");
      paramDataProcessor.processBoolean(recurring);
    }
    Object localObject = null;
    CalendarEventAttendee localCalendarEventAttendee = null;
    boolean bool = false;
    if (hasAttendees)
    {
      paramDataProcessor.startRecordField$505cff1c("attendees");
      attendees.size();
      paramDataProcessor.startArray$13462e();
      localObject = localCalendarEventAttendee;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = attendees.iterator();
      if (localIterator.hasNext())
      {
        localCalendarEventAttendee = (CalendarEventAttendee)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localCalendarEventAttendee = localCalendarEventAttendee.accept(paramDataProcessor);; localCalendarEventAttendee = (CalendarEventAttendee)paramDataProcessor.processDataTemplate(localCalendarEventAttendee))
        {
          if ((localObject != null) && (localCalendarEventAttendee != null)) {
            ((List)localObject).add(localCalendarEventAttendee);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label463;
      }
    }
    label463:
    for (bool = true;; bool = false)
    {
      if (hasStatus)
      {
        paramDataProcessor.startRecordField$505cff1c("status");
        paramDataProcessor.processEnum(status);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label658;
      }
      if (!hasAttendees) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasExternalId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "externalId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasSource) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "source");
    }
    if (!hasStartTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "startTime");
    }
    if (!hasEndTime) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "endTime");
    }
    if (attendees != null)
    {
      paramDataProcessor = attendees.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((CalendarEventAttendee)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "attendees");
        }
      }
    }
    return new CalendarUploadEvent(externalId, source, startTime, endTime, title, location, fullDayEvent, recurring, (List)localObject, status, hasExternalId, hasSource, hasStartTime, hasEndTime, hasTitle, hasLocation, hasFullDayEvent, hasRecurring, bool, hasStatus);
    label658:
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
      paramObject = (CalendarUploadEvent)paramObject;
      if (externalId != null)
      {
        if (externalId.equals(externalId)) {}
      }
      else {
        while (externalId != null) {
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
      if (endTime != endTime) {
        return false;
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (fullDayEvent != fullDayEvent) {
        return false;
      }
      if (recurring != recurring) {
        return false;
      }
      if (attendees != null)
      {
        if (attendees.equals(attendees)) {}
      }
      else {
        while (attendees != null) {
          return false;
        }
      }
      if (status == null) {
        break;
      }
    } while (status.equals(status));
    for (;;)
    {
      return false;
      if (status == null) {
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
    if (hasExternalId) {
      i = PegasusBinaryUtils.getEncodedLength(externalId) + 8;
    }
    int j = i + 1;
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
    j = i + 1;
    i = j;
    if (hasTitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(title);
    }
    j = i + 1;
    i = j;
    if (hasLocation) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
    }
    j = i + 1;
    i = j;
    if (hasFullDayEvent) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasRecurring) {
      i = j + 1;
    }
    i += 1;
    j = i;
    if (hasAttendees)
    {
      i += 2;
      Iterator localIterator = attendees.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        CalendarEventAttendee localCalendarEventAttendee = (CalendarEventAttendee)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localCalendarEventAttendee.getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasStatus) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int i1 = 1;
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label48:
    int i4;
    int i5;
    int k;
    label93:
    int m;
    label109:
    int n;
    if (externalId != null)
    {
      i = externalId.hashCode();
      if (source == null) {
        break label230;
      }
      j = source.hashCode();
      i4 = (int)(startTime ^ startTime >>> 32);
      i5 = (int)(endTime ^ endTime >>> 32);
      if (title == null) {
        break label235;
      }
      k = title.hashCode();
      if (location == null) {
        break label240;
      }
      m = location.hashCode();
      if (!fullDayEvent) {
        break label246;
      }
      n = 1;
      label119:
      if (!recurring) {
        break label252;
      }
      label126:
      if (attendees == null) {
        break label258;
      }
    }
    label230:
    label235:
    label240:
    label246:
    label252:
    label258:
    for (int i2 = attendees.hashCode();; i2 = 0)
    {
      if (status != null) {
        i3 = status.hashCode();
      }
      i = (i2 + ((n + (m + (k + (((j + (i + 527) * 31) * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31 + i1) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label48;
      k = 0;
      break label93;
      m = 0;
      break label109;
      n = 0;
      break label119;
      i1 = 0;
      break label126;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CalendarUploadEvent");
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
    label167:
    label191:
    label215:
    label241:
    label267:
    label291:
    label300:
    label324:
    label333:
    label450:
    label460:
    label470:
    label480:
    label490:
    label500:
    label506:
    label516:
    label522:
    label555:
    label562:
    label634:
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
        localByteBuffer.putInt(1166889098);
        Iterator localIterator;
        if (hasExternalId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, externalId);
          if (!hasSource) {
            break label450;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, source.ordinal());
          if (!hasStartTime) {
            break label460;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(startTime);
          if (!hasEndTime) {
            break label470;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(endTime);
          if (!hasTitle) {
            break label480;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, title);
          if (!hasLocation) {
            break label490;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasFullDayEvent) {
            break label506;
          }
          localByteBuffer.put((byte)1);
          if (!fullDayEvent) {
            break label500;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasRecurring) {
            break label522;
          }
          localByteBuffer.put((byte)1);
          if (!recurring) {
            break label516;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasAttendees) {
            break label555;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, attendees.size());
          localIterator = attendees.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label562;
          }
          CalendarEventAttendee localCalendarEventAttendee = (CalendarEventAttendee)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localCalendarEventAttendee.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label167;
            localByteBuffer.put((byte)0);
            break label191;
            localByteBuffer.put((byte)0);
            break label215;
            localByteBuffer.put((byte)0);
            break label241;
            localByteBuffer.put((byte)0);
            break label267;
            i = 0;
            break label291;
            localByteBuffer.put((byte)0);
            break label300;
            i = 0;
            break label324;
            localByteBuffer.put((byte)0);
            break label333;
          }
          localByteBuffer.put((byte)1);
          localCalendarEventAttendee.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasStatus)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label634;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
    implements RecordTemplateBuilder<CalendarUploadEvent>
  {
    public List<CalendarEventAttendee> attendees = null;
    public long endTime = 0L;
    public String externalId = null;
    public boolean fullDayEvent = false;
    public boolean hasAttendees = false;
    public boolean hasEndTime = false;
    public boolean hasExternalId = false;
    public boolean hasFullDayEvent = false;
    public boolean hasLocation = false;
    public boolean hasRecurring = false;
    public boolean hasSource = false;
    public boolean hasStartTime = false;
    public boolean hasStatus = false;
    public boolean hasTitle = false;
    public String location = null;
    public boolean recurring = false;
    public CalendarSource source = null;
    public long startTime = 0L;
    public CalendarEventAvailability status = null;
    public String title = null;
    
    public final CalendarUploadEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (CalendarUploadEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (attendees != null)
      {
        paramFlavor = attendees.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((CalendarEventAttendee)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "attendees");
              if (!hasFullDayEvent) {
                fullDayEvent = false;
              }
              if (!hasRecurring) {
                recurring = false;
              }
              if (!hasAttendees) {
                attendees = Collections.emptyList();
              }
              if (!hasStatus) {
                status = CalendarEventAvailability.NOT_SUPPORTED;
              }
              if (!hasExternalId) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "externalId");
              }
              if (!hasSource) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "source");
              }
              if (!hasStartTime) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "startTime");
              }
              if (hasEndTime) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent", "endTime");
            }
          }
        }
      }
      return new CalendarUploadEvent(externalId, source, startTime, endTime, title, location, fullDayEvent, recurring, attendees, status, hasExternalId, hasSource, hasStartTime, hasEndTime, hasTitle, hasLocation, hasFullDayEvent, hasRecurring, hasAttendees, hasStatus);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.calendar.CalendarUploadEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */