package com.linkedin.gen.avro2pegasus.events.calendar;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class GlobalCalendarSyncActionEvent
  implements RecordTemplate<GlobalCalendarSyncActionEvent>
{
  public static final GlobalCalendarSyncActionEventBuilder BUILDER = GlobalCalendarSyncActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasIsSyncEnabled;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final boolean isSyncEnabled;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  GlobalCalendarSyncActionEvent(EventHeader paramEventHeader, MobileHeader paramMobileHeader, UserRequestHeader paramUserRequestHeader, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    mobileHeader = paramMobileHeader;
    requestHeader = paramUserRequestHeader;
    isSyncEnabled = paramBoolean1;
    hasHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasRequestHeader = paramBoolean4;
    hasIsSyncEnabled = paramBoolean5;
    _cachedId = null;
  }
  
  private GlobalCalendarSyncActionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label241;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label250;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label268;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label277;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label295;
        }
      }
    }
    label241:
    label250:
    label268:
    label277:
    label295:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasIsSyncEnabled)
      {
        paramDataProcessor.startRecordField$505cff1c("isSyncEnabled");
        paramDataProcessor.processBoolean(isSyncEnabled);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label365;
      }
      try
      {
        if (hasHeader) {
          break label301;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label146;
    }
    label301:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "requestHeader");
    }
    if (!hasIsSyncEnabled) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "isSyncEnabled");
    }
    return new GlobalCalendarSyncActionEvent((EventHeader)localObject2, (MobileHeader)localObject3, (UserRequestHeader)localObject1, isSyncEnabled, bool1, bool2, bool3, hasIsSyncEnabled);
    label365:
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
      paramObject = (GlobalCalendarSyncActionEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
    } while (isSyncEnabled == isSyncEnabled);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (header != null)
    {
      i = header.hashCode();
      if (mobileHeader == null) {
        break label104;
      }
      j = mobileHeader.hashCode();
      label45:
      if (requestHeader == null) {
        break label109;
      }
    }
    label104:
    label109:
    for (int k = requestHeader.hashCode();; k = 0)
    {
      if (isSyncEnabled) {
        m = 1;
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<GlobalCalendarSyncActionEvent>
  {
    private boolean hasHeader = false;
    public boolean hasIsSyncEnabled = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    public boolean isSyncEnabled = false;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private GlobalCalendarSyncActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (GlobalCalendarSyncActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new GlobalCalendarSyncActionEvent(header, mobileHeader, requestHeader, isSyncEnabled, hasHeader, hasMobileHeader, hasRequestHeader, hasIsSyncEnabled);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "requestHeader");
        }
      } while (hasIsSyncEnabled);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent", "isSyncEnabled");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.calendar.GlobalCalendarSyncActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */