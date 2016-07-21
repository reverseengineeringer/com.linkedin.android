package com.linkedin.gen.avro2pegasus.events.lego;

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

public final class LegoPageImpressionEvent
  implements RecordTemplate<LegoPageImpressionEvent>
{
  public static final LegoPageImpressionEventBuilder BUILDER = LegoPageImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasIsSyncTrack;
  public final boolean hasMobileHeader;
  public final boolean hasPageTrackingId;
  public final boolean hasRequestHeader;
  public final boolean hasTrackingToken;
  public final EventHeader header;
  public final boolean isSyncTrack;
  public final MobileHeader mobileHeader;
  public final String pageTrackingId;
  public final UserRequestHeader requestHeader;
  public final String trackingToken;
  
  LegoPageImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    trackingToken = paramString1;
    pageTrackingId = paramString2;
    isSyncTrack = paramBoolean1;
    hasHeader = paramBoolean2;
    hasRequestHeader = paramBoolean3;
    hasMobileHeader = paramBoolean4;
    hasTrackingToken = paramBoolean5;
    hasPageTrackingId = paramBoolean6;
    hasIsSyncTrack = paramBoolean7;
    _cachedId = null;
  }
  
  private LegoPageImpressionEvent accept(DataProcessor paramDataProcessor)
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
      if (hasTrackingToken)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingToken");
        paramDataProcessor.processString(trackingToken);
      }
      if (hasPageTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("pageTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(pageTrackingId));
      }
      if (hasIsSyncTrack)
      {
        paramDataProcessor.startRecordField$505cff1c("isSyncTrack");
        paramDataProcessor.processBoolean(isSyncTrack);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label439;
      }
      try
      {
        if (hasHeader) {
          break label359;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "header");
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
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "requestHeader");
    }
    if (!hasTrackingToken) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "trackingToken");
    }
    return new LegoPageImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, trackingToken, pageTrackingId, isSyncTrack, bool1, bool2, bool3, hasTrackingToken, hasPageTrackingId, hasIsSyncTrack);
    label439:
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
      paramObject = (LegoPageImpressionEvent)paramObject;
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
      if (trackingToken != null)
      {
        if (trackingToken.equals(trackingToken)) {}
      }
      else {
        while (trackingToken != null) {
          return false;
        }
      }
      if (pageTrackingId != null)
      {
        if (pageTrackingId.equals(pageTrackingId)) {}
      }
      else {
        while (pageTrackingId != null) {
          return false;
        }
      }
    } while (isSyncTrack == isSyncTrack);
    return false;
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
        break label148;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label153;
      }
      k = mobileHeader.hashCode();
      if (trackingToken == null) {
        break label158;
      }
      m = trackingToken.hashCode();
      label76:
      if (pageTrackingId == null) {
        break label164;
      }
    }
    label148:
    label153:
    label158:
    label164:
    for (int n = pageTrackingId.hashCode();; n = 0)
    {
      if (isSyncTrack) {
        i1 = 1;
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
    implements TrackingEventBuilder, RecordTemplateBuilder<LegoPageImpressionEvent>
  {
    private boolean hasHeader = false;
    public boolean hasIsSyncTrack = false;
    private boolean hasMobileHeader = false;
    private boolean hasPageTrackingId = false;
    private boolean hasRequestHeader = false;
    public boolean hasTrackingToken = false;
    private EventHeader header = null;
    public boolean isSyncTrack = false;
    private MobileHeader mobileHeader = null;
    private String pageTrackingId = null;
    private UserRequestHeader requestHeader = null;
    public String trackingToken = null;
    
    private LegoPageImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (LegoPageImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new LegoPageImpressionEvent(header, requestHeader, mobileHeader, trackingToken, pageTrackingId, isSyncTrack, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingToken, hasPageTrackingId, hasIsSyncTrack);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "requestHeader");
        }
      } while (hasTrackingToken);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent", "trackingToken");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoPageImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */