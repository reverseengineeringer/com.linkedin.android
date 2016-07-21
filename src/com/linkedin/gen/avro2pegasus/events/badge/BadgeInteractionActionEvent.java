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
import com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.ControlInteractionType;

public final class BadgeInteractionActionEvent
  implements RecordTemplate<BadgeInteractionActionEvent>
{
  public static final BadgeInteractionActionEventBuilder BUILDER = BadgeInteractionActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int appBadgeCount;
  public final AppTabType badgeTabCleared;
  public final String controlUrn;
  public final boolean hasAppBadgeCount;
  public final boolean hasBadgeTabCleared;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasInteractionType;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasTabBadgeDetails;
  public final EventHeader header;
  public final ControlInteractionType interactionType;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final TabBadgeDetails tabBadgeDetails;
  
  BadgeInteractionActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, AppTabType paramAppTabType, String paramString, ControlInteractionType paramControlInteractionType, TabBadgeDetails paramTabBadgeDetails, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    badgeTabCleared = paramAppTabType;
    controlUrn = paramString;
    interactionType = paramControlInteractionType;
    tabBadgeDetails = paramTabBadgeDetails;
    appBadgeCount = paramInt;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasBadgeTabCleared = paramBoolean4;
    hasControlUrn = paramBoolean5;
    hasInteractionType = paramBoolean6;
    hasTabBadgeDetails = paramBoolean7;
    hasAppBadgeCount = paramBoolean8;
    _cachedId = null;
  }
  
  private BadgeInteractionActionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label368;
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
          break label377;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label395;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label404;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label422;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      if (hasBadgeTabCleared)
      {
        paramDataProcessor.startRecordField$505cff1c("badgeTabCleared");
        paramDataProcessor.processEnum(badgeTabCleared);
      }
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      if (hasInteractionType)
      {
        paramDataProcessor.startRecordField$505cff1c("interactionType");
        paramDataProcessor.processEnum(interactionType);
      }
      localObject1 = null;
      bool4 = false;
      if (hasTabBadgeDetails)
      {
        paramDataProcessor.startRecordField$505cff1c("tabBadgeDetails");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label432;
        }
        localObject1 = tabBadgeDetails.accept(paramDataProcessor);
        label273:
        if (localObject1 == null) {
          break label450;
        }
      }
    }
    label368:
    label377:
    label395:
    label404:
    label422:
    label432:
    label450:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasAppBadgeCount)
      {
        paramDataProcessor.startRecordField$505cff1c("appBadgeCount");
        paramDataProcessor.processInt(appBadgeCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label548;
      }
      try
      {
        if (hasHeader) {
          break label456;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "header");
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
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (TabBadgeDetails)paramDataProcessor.processDataTemplate(tabBadgeDetails);
      break label273;
    }
    label456:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "requestHeader");
    }
    if (!hasTabBadgeDetails) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "tabBadgeDetails");
    }
    return new BadgeInteractionActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, badgeTabCleared, controlUrn, interactionType, (TabBadgeDetails)localObject1, appBadgeCount, bool1, bool2, bool3, hasBadgeTabCleared, hasControlUrn, hasInteractionType, bool4, hasAppBadgeCount);
    label548:
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
      paramObject = (BadgeInteractionActionEvent)paramObject;
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
      if (badgeTabCleared != null)
      {
        if (badgeTabCleared.equals(badgeTabCleared)) {}
      }
      else {
        while (badgeTabCleared != null) {
          return false;
        }
      }
      if (controlUrn != null)
      {
        if (controlUrn.equals(controlUrn)) {}
      }
      else {
        while (controlUrn != null) {
          return false;
        }
      }
      if (interactionType != null)
      {
        if (interactionType.equals(interactionType)) {}
      }
      else {
        while (interactionType != null) {
          return false;
        }
      }
      if (tabBadgeDetails != null)
      {
        if (tabBadgeDetails.equals(tabBadgeDetails)) {}
      }
      else {
        while (tabBadgeDetails != null) {
          return false;
        }
      }
    } while (appBadgeCount == appBadgeCount);
    return false;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label184;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label189;
      }
      k = mobileHeader.hashCode();
      if (badgeTabCleared == null) {
        break label194;
      }
      m = badgeTabCleared.hashCode();
      if (controlUrn == null) {
        break label200;
      }
      n = controlUrn.hashCode();
      label92:
      if (interactionType == null) {
        break label206;
      }
    }
    label184:
    label189:
    label194:
    label200:
    label206:
    for (int i1 = interactionType.hashCode();; i1 = 0)
    {
      if (tabBadgeDetails != null) {
        i2 = tabBadgeDetails.hashCode();
      }
      i = ((i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2) * 31 + appBadgeCount;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<BadgeInteractionActionEvent>
  {
    public int appBadgeCount = 0;
    public AppTabType badgeTabCleared = null;
    public String controlUrn = null;
    public boolean hasAppBadgeCount = false;
    public boolean hasBadgeTabCleared = false;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    public boolean hasInteractionType = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasTabBadgeDetails = false;
    private EventHeader header = null;
    public ControlInteractionType interactionType = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public TabBadgeDetails tabBadgeDetails = null;
    
    private BadgeInteractionActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (BadgeInteractionActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new BadgeInteractionActionEvent(header, requestHeader, mobileHeader, badgeTabCleared, controlUrn, interactionType, tabBadgeDetails, appBadgeCount, hasHeader, hasRequestHeader, hasMobileHeader, hasBadgeTabCleared, hasControlUrn, hasInteractionType, hasTabBadgeDetails, hasAppBadgeCount);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "requestHeader");
        }
      } while (hasTabBadgeDetails);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent", "tabBadgeDetails");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.BadgeInteractionActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */