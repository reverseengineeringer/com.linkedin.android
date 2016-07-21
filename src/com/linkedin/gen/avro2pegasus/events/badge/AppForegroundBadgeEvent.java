package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.badge.AppTabType;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class AppForegroundBadgeEvent
  implements RecordTemplate<AppForegroundBadgeEvent>
{
  public static final AppForegroundBadgeEventBuilder BUILDER = AppForegroundBadgeEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActionSource actionSource;
  public final int appBadgeCount;
  public final boolean hasActionSource;
  public final boolean hasAppBadgeCount;
  public final boolean hasHeader;
  public final boolean hasLandingTab;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final AppTabType landingTab;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  AppForegroundBadgeEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, int paramInt, ActionSource paramActionSource, AppTabType paramAppTabType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    appBadgeCount = paramInt;
    actionSource = paramActionSource;
    landingTab = paramAppTabType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasAppBadgeCount = paramBoolean4;
    hasActionSource = paramBoolean5;
    hasLandingTab = paramBoolean6;
    _cachedId = null;
  }
  
  private AppForegroundBadgeEvent accept(DataProcessor paramDataProcessor)
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
          break label291;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label300;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label318;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label106:
      localObject1 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label327;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label345;
        }
      }
    }
    label291:
    label300:
    label318:
    label327:
    label345:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasAppBadgeCount)
      {
        paramDataProcessor.startRecordField$505cff1c("appBadgeCount");
        paramDataProcessor.processInt(appBadgeCount);
      }
      if (hasActionSource)
      {
        paramDataProcessor.startRecordField$505cff1c("actionSource");
        paramDataProcessor.processEnum(actionSource);
      }
      if (hasLandingTab)
      {
        paramDataProcessor.startRecordField$505cff1c("landingTab");
        paramDataProcessor.processEnum(landingTab);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label431;
      }
      try
      {
        if (hasHeader) {
          break label351;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "header");
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
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label146;
    }
    label351:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "requestHeader");
    }
    if (!hasAppBadgeCount) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "appBadgeCount");
    }
    return new AppForegroundBadgeEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, appBadgeCount, actionSource, landingTab, bool1, bool2, bool3, hasAppBadgeCount, hasActionSource, hasLandingTab);
    label431:
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
      paramObject = (AppForegroundBadgeEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
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
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (appBadgeCount != appBadgeCount) {
        return false;
      }
      if (actionSource != null)
      {
        if (actionSource.equals(actionSource)) {}
      }
      else {
        while (actionSource != null) {
          return false;
        }
      }
      if (landingTab == null) {
        break;
      }
    } while (landingTab.equals(landingTab));
    for (;;)
    {
      return false;
      if (landingTab == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int i1;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label144;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label149;
      }
      k = mobileHeader.hashCode();
      i1 = appBadgeCount;
      if (actionSource == null) {
        break label154;
      }
    }
    label144:
    label149:
    label154:
    for (int m = actionSource.hashCode();; m = 0)
    {
      if (landingTab != null) {
        n = landingTab.hashCode();
      }
      i = (m + ((k + (j + (i + 527) * 31) * 31) * 31 + i1) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<AppForegroundBadgeEvent>
  {
    public ActionSource actionSource = null;
    public int appBadgeCount = 0;
    public boolean hasActionSource = false;
    public boolean hasAppBadgeCount = false;
    private boolean hasHeader = false;
    public boolean hasLandingTab = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    public AppTabType landingTab = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private AppForegroundBadgeEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AppForegroundBadgeEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new AppForegroundBadgeEvent(header, requestHeader, mobileHeader, appBadgeCount, actionSource, landingTab, hasHeader, hasRequestHeader, hasMobileHeader, hasAppBadgeCount, hasActionSource, hasLandingTab);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "requestHeader");
        }
      } while (hasAppBadgeCount);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent", "appBadgeCount");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.AppForegroundBadgeEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */