package com.linkedin.gen.avro2pegasus.events.badge;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class BadgeUpdateReceivedEvent
  implements RecordTemplate<BadgeUpdateReceivedEvent>
{
  public static final BadgeUpdateReceivedEventBuilder BUILDER = BadgeUpdateReceivedEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int existingAppBadgeCount;
  public final TabBadgeDetails existingTabBadgeDetails;
  public final boolean hasExistingAppBadgeCount;
  public final boolean hasExistingTabBadgeDetails;
  public final boolean hasHeader;
  public final boolean hasIsFirstUpdate;
  public final boolean hasMobileHeader;
  public final boolean hasNewAppBadgeCount;
  public final boolean hasNewTabBadgeDetails;
  public final boolean hasRequestHeader;
  public final boolean hasUpdateType;
  public final EventHeader header;
  public final boolean isFirstUpdate;
  public final MobileHeader mobileHeader;
  public final int newAppBadgeCount;
  public final TabBadgeDetails newTabBadgeDetails;
  public final UserRequestHeader requestHeader;
  public final UpdateType updateType;
  
  BadgeUpdateReceivedEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, boolean paramBoolean1, UpdateType paramUpdateType, TabBadgeDetails paramTabBadgeDetails1, int paramInt1, TabBadgeDetails paramTabBadgeDetails2, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    isFirstUpdate = paramBoolean1;
    updateType = paramUpdateType;
    existingTabBadgeDetails = paramTabBadgeDetails1;
    existingAppBadgeCount = paramInt1;
    newTabBadgeDetails = paramTabBadgeDetails2;
    newAppBadgeCount = paramInt2;
    hasHeader = paramBoolean2;
    hasRequestHeader = paramBoolean3;
    hasMobileHeader = paramBoolean4;
    hasIsFirstUpdate = paramBoolean5;
    hasUpdateType = paramBoolean6;
    hasExistingTabBadgeDetails = paramBoolean7;
    hasExistingAppBadgeCount = paramBoolean8;
    hasNewTabBadgeDetails = paramBoolean9;
    hasNewAppBadgeCount = paramBoolean10;
    _cachedId = null;
  }
  
  private BadgeUpdateReceivedEvent accept(DataProcessor paramDataProcessor)
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
    label146:
    label158:
    Object localObject5;
    boolean bool4;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label420;
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
          break label429;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label447;
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
          break label456;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label474;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasIsFirstUpdate)
      {
        paramDataProcessor.startRecordField$505cff1c("isFirstUpdate");
        paramDataProcessor.processBoolean(isFirstUpdate);
      }
      if (hasUpdateType)
      {
        paramDataProcessor.startRecordField$505cff1c("updateType");
        paramDataProcessor.processEnum(updateType);
      }
      localObject5 = null;
      bool4 = false;
      if (hasExistingTabBadgeDetails)
      {
        paramDataProcessor.startRecordField$505cff1c("existingTabBadgeDetails");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label484;
        }
        localObject1 = existingTabBadgeDetails.accept(paramDataProcessor);
        label248:
        if (localObject1 == null) {
          break label502;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      label260:
      if (hasExistingAppBadgeCount)
      {
        paramDataProcessor.startRecordField$505cff1c("existingAppBadgeCount");
        paramDataProcessor.processInt(existingAppBadgeCount);
      }
      localObject1 = null;
      bool5 = false;
      if (hasNewTabBadgeDetails)
      {
        paramDataProcessor.startRecordField$505cff1c("newTabBadgeDetails");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label512;
        }
        localObject1 = newTabBadgeDetails.accept(paramDataProcessor);
        label325:
        if (localObject1 == null) {
          break label530;
        }
      }
    }
    label420:
    label429:
    label447:
    label456:
    label474:
    label484:
    label502:
    label512:
    label530:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (hasNewAppBadgeCount)
      {
        paramDataProcessor.startRecordField$505cff1c("newAppBadgeCount");
        paramDataProcessor.processInt(newAppBadgeCount);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label651;
      }
      try
      {
        if (hasHeader) {
          break label536;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "header");
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
      localObject1 = (TabBadgeDetails)paramDataProcessor.processDataTemplate(existingTabBadgeDetails);
      break label248;
      bool4 = false;
      localObject5 = localObject1;
      break label260;
      localObject1 = (TabBadgeDetails)paramDataProcessor.processDataTemplate(newTabBadgeDetails);
      break label325;
    }
    label536:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "requestHeader");
    }
    if (!hasIsFirstUpdate) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "isFirstUpdate");
    }
    if (!hasNewTabBadgeDetails) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "newTabBadgeDetails");
    }
    return new BadgeUpdateReceivedEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, isFirstUpdate, updateType, (TabBadgeDetails)localObject5, existingAppBadgeCount, (TabBadgeDetails)localObject1, newAppBadgeCount, bool1, bool2, bool3, hasIsFirstUpdate, hasUpdateType, bool4, hasExistingAppBadgeCount, bool5, hasNewAppBadgeCount);
    label651:
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
      paramObject = (BadgeUpdateReceivedEvent)paramObject;
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
      if (isFirstUpdate != isFirstUpdate) {
        return false;
      }
      if (updateType != null)
      {
        if (updateType.equals(updateType)) {}
      }
      else {
        while (updateType != null) {
          return false;
        }
      }
      if (existingTabBadgeDetails != null)
      {
        if (existingTabBadgeDetails.equals(existingTabBadgeDetails)) {}
      }
      else {
        while (existingTabBadgeDetails != null) {
          return false;
        }
      }
      if (existingAppBadgeCount != existingAppBadgeCount) {
        return false;
      }
      if (newTabBadgeDetails != null)
      {
        if (newTabBadgeDetails.equals(newTabBadgeDetails)) {}
      }
      else {
        while (newTabBadgeDetails != null) {
          return false;
        }
      }
    } while (newAppBadgeCount == newAppBadgeCount);
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
    label70:
    int n;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label190;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label195;
      }
      k = mobileHeader.hashCode();
      if (!isFirstUpdate) {
        break label200;
      }
      m = 1;
      if (updateType == null) {
        break label206;
      }
      n = updateType.hashCode();
      label86:
      if (existingTabBadgeDetails == null) {
        break label212;
      }
    }
    label190:
    label195:
    label200:
    label206:
    label212:
    for (int i1 = existingTabBadgeDetails.hashCode();; i1 = 0)
    {
      int i3 = existingAppBadgeCount;
      if (newTabBadgeDetails != null) {
        i2 = newTabBadgeDetails.hashCode();
      }
      i = (((i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i3) * 31 + i2) * 31 + newAppBadgeCount;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label70;
      n = 0;
      break label86;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<BadgeUpdateReceivedEvent>
  {
    public int existingAppBadgeCount = 0;
    public TabBadgeDetails existingTabBadgeDetails = null;
    public boolean hasExistingAppBadgeCount = false;
    public boolean hasExistingTabBadgeDetails = false;
    private boolean hasHeader = false;
    public boolean hasIsFirstUpdate = false;
    private boolean hasMobileHeader = false;
    public boolean hasNewAppBadgeCount = false;
    public boolean hasNewTabBadgeDetails = false;
    private boolean hasRequestHeader = false;
    public boolean hasUpdateType = false;
    private EventHeader header = null;
    public boolean isFirstUpdate = false;
    private MobileHeader mobileHeader = null;
    public int newAppBadgeCount = 0;
    public TabBadgeDetails newTabBadgeDetails = null;
    private UserRequestHeader requestHeader = null;
    public UpdateType updateType = null;
    
    private BadgeUpdateReceivedEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (BadgeUpdateReceivedEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new BadgeUpdateReceivedEvent(header, requestHeader, mobileHeader, isFirstUpdate, updateType, existingTabBadgeDetails, existingAppBadgeCount, newTabBadgeDetails, newAppBadgeCount, hasHeader, hasRequestHeader, hasMobileHeader, hasIsFirstUpdate, hasUpdateType, hasExistingTabBadgeDetails, hasExistingAppBadgeCount, hasNewTabBadgeDetails, hasNewAppBadgeCount);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "requestHeader");
        }
        if (!hasIsFirstUpdate) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "isFirstUpdate");
        }
      } while (hasNewTabBadgeDetails);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent", "newTabBadgeDetails");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.badge.BadgeUpdateReceivedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */