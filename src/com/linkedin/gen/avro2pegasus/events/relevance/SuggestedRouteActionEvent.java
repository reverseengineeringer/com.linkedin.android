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

public final class SuggestedRouteActionEvent
  implements RecordTemplate<SuggestedRouteActionEvent>
{
  public static final SuggestedRouteActionEventBuilder BUILDER = SuggestedRouteActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ErrorType error;
  public final boolean hasError;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasRouteServed;
  public final boolean hasTrackingId;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final Route routeServed;
  public final String trackingId;
  
  SuggestedRouteActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, Route paramRoute, ErrorType paramErrorType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    trackingId = paramString;
    routeServed = paramRoute;
    error = paramErrorType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasTrackingId = paramBoolean4;
    hasRouteServed = paramBoolean5;
    hasError = paramBoolean6;
    _cachedId = null;
  }
  
  private SuggestedRouteActionEvent accept(DataProcessor paramDataProcessor)
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
      if (hasRouteServed)
      {
        paramDataProcessor.startRecordField$505cff1c("routeServed");
        paramDataProcessor.processEnum(routeServed);
      }
      if (hasError)
      {
        paramDataProcessor.startRecordField$505cff1c("error");
        paramDataProcessor.processEnum(error);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label458;
      }
      try
      {
        if (hasHeader) {
          break label359;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "header");
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
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "requestHeader");
    }
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "trackingId");
    }
    if (!hasRouteServed) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "routeServed");
    }
    return new SuggestedRouteActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, trackingId, routeServed, error, bool1, bool2, bool3, hasTrackingId, hasRouteServed, hasError);
    label458:
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
      paramObject = (SuggestedRouteActionEvent)paramObject;
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
      if (routeServed != null)
      {
        if (routeServed.equals(routeServed)) {}
      }
      else {
        while (routeServed != null) {
          return false;
        }
      }
      if (error == null) {
        break;
      }
    } while (error.equals(error));
    for (;;)
    {
      return false;
      if (error == null) {
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
      if (routeServed == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = routeServed.hashCode();; n = 0)
    {
      if (error != null) {
        i1 = error.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedRouteActionEvent>
  {
    public ErrorType error = null;
    public boolean hasError = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasRouteServed = false;
    public boolean hasTrackingId = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public Route routeServed = null;
    public String trackingId = null;
    
    private SuggestedRouteActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SuggestedRouteActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SuggestedRouteActionEvent(header, requestHeader, mobileHeader, trackingId, routeServed, error, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingId, hasRouteServed, hasError);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "requestHeader");
        }
        if (!hasTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "trackingId");
        }
      } while (hasRouteServed);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent", "routeServed");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */