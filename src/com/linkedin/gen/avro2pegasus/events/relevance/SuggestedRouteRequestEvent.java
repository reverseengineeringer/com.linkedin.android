package com.linkedin.gen.avro2pegasus.events.relevance;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;

public final class SuggestedRouteRequestEvent
  implements RecordTemplate<SuggestedRouteRequestEvent>
{
  public static final SuggestedRouteRequestEventBuilder BUILDER = SuggestedRouteRequestEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasOrigin;
  public final boolean hasRequestHeader;
  public final boolean hasTrackingId;
  public final boolean hasUserActionType;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final Origin origin;
  public final UserRequestHeader requestHeader;
  public final String trackingId;
  public final UserActionType userActionType;
  
  SuggestedRouteRequestEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, Origin paramOrigin, UserActionType paramUserActionType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    trackingId = paramString;
    origin = paramOrigin;
    userActionType = paramUserActionType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasTrackingId = paramBoolean4;
    hasOrigin = paramBoolean5;
    hasUserActionType = paramBoolean6;
    _cachedId = null;
  }
  
  private SuggestedRouteRequestEvent accept(DataProcessor paramDataProcessor)
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
          break label299;
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
          break label308;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label326;
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
          break label335;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label353;
        }
      }
    }
    label299:
    label308:
    label326:
    label335:
    label353:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
      }
      if (hasOrigin)
      {
        paramDataProcessor.startRecordField$505cff1c("origin");
        paramDataProcessor.processEnum(origin);
      }
      if (hasUserActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("userActionType");
        paramDataProcessor.processEnum(userActionType);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label477;
      }
      try
      {
        if (hasHeader) {
          break label359;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "header");
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
    label359:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "requestHeader");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "trackingId");
    }
    if (!hasOrigin) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "origin");
    }
    if (!hasUserActionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "userActionType");
    }
    return new SuggestedRouteRequestEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, trackingId, origin, userActionType, bool1, bool2, bool3, hasTrackingId, hasOrigin, hasUserActionType);
    label477:
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
      paramObject = (SuggestedRouteRequestEvent)paramObject;
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
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (origin != null)
      {
        if (origin.equals(origin)) {}
      }
      else {
        while (origin != null) {
          return false;
        }
      }
      if (userActionType == null) {
        break;
      }
    } while (userActionType.equals(userActionType));
    for (;;)
    {
      return false;
      if (userActionType == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label154;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label159;
      }
      k = mobileHeader.hashCode();
      if (trackingId == null) {
        break label164;
      }
      m = trackingId.hashCode();
      label76:
      if (origin == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = origin.hashCode();; n = 0)
    {
      if (userActionType != null) {
        i1 = userActionType.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedRouteRequestEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasOrigin = false;
    private boolean hasRequestHeader = false;
    public boolean hasTrackingId = false;
    public boolean hasUserActionType = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public Origin origin = null;
    private UserRequestHeader requestHeader = null;
    public String trackingId = null;
    public UserActionType userActionType = null;
    
    private SuggestedRouteRequestEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SuggestedRouteRequestEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SuggestedRouteRequestEvent(header, requestHeader, mobileHeader, trackingId, origin, userActionType, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingId, hasOrigin, hasUserActionType);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "requestHeader");
        }
        if (!hasTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "trackingId");
        }
        if (!hasOrigin) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "origin");
        }
      } while (hasUserActionType);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent", "userActionType");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteRequestEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */