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

public final class LegoWidgetImpressionEvent
  implements RecordTemplate<LegoWidgetImpressionEvent>
{
  public static final LegoWidgetImpressionEventBuilder BUILDER = LegoWidgetImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasIsSyncTrack;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasTrackingToken;
  public final boolean hasVisibility;
  public final boolean hasWidgetTrackingId;
  public final EventHeader header;
  public final boolean isSyncTrack;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String trackingToken;
  public final WidgetVisibility visibility;
  public final String widgetTrackingId;
  
  LegoWidgetImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, WidgetVisibility paramWidgetVisibility, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    trackingToken = paramString1;
    widgetTrackingId = paramString2;
    visibility = paramWidgetVisibility;
    isSyncTrack = paramBoolean1;
    hasHeader = paramBoolean2;
    hasRequestHeader = paramBoolean3;
    hasMobileHeader = paramBoolean4;
    hasTrackingToken = paramBoolean5;
    hasWidgetTrackingId = paramBoolean6;
    hasVisibility = paramBoolean7;
    hasIsSyncTrack = paramBoolean8;
    _cachedId = null;
  }
  
  private LegoWidgetImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label324;
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
          break label333;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label351;
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
          break label360;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label378;
        }
      }
    }
    label324:
    label333:
    label351:
    label360:
    label378:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (hasTrackingToken)
      {
        paramDataProcessor.startRecordField$505cff1c("trackingToken");
        paramDataProcessor.processString(trackingToken);
      }
      if (hasWidgetTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("widgetTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(widgetTrackingId));
      }
      if (hasVisibility)
      {
        paramDataProcessor.startRecordField$505cff1c("visibility");
        paramDataProcessor.processEnum(visibility);
      }
      if (hasIsSyncTrack)
      {
        paramDataProcessor.startRecordField$505cff1c("isSyncTrack");
        paramDataProcessor.processBoolean(isSyncTrack);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label472;
      }
      try
      {
        if (hasHeader) {
          break label384;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "header");
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
    label384:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "requestHeader");
    }
    if (!hasTrackingToken) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "trackingToken");
    }
    return new LegoWidgetImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, trackingToken, widgetTrackingId, visibility, isSyncTrack, bool1, bool2, bool3, hasTrackingToken, hasWidgetTrackingId, hasVisibility, hasIsSyncTrack);
    label472:
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
      paramObject = (LegoWidgetImpressionEvent)paramObject;
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
      if (widgetTrackingId != null)
      {
        if (widgetTrackingId.equals(widgetTrackingId)) {}
      }
      else {
        while (widgetTrackingId != null) {
          return false;
        }
      }
      if (visibility != null)
      {
        if (visibility.equals(visibility)) {}
      }
      else {
        while (visibility != null) {
          return false;
        }
      }
    } while (isSyncTrack == isSyncTrack);
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
        break label170;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label175;
      }
      k = mobileHeader.hashCode();
      if (trackingToken == null) {
        break label180;
      }
      m = trackingToken.hashCode();
      if (widgetTrackingId == null) {
        break label186;
      }
      n = widgetTrackingId.hashCode();
      label92:
      if (visibility == null) {
        break label192;
      }
    }
    label170:
    label175:
    label180:
    label186:
    label192:
    for (int i1 = visibility.hashCode();; i1 = 0)
    {
      if (isSyncTrack) {
        i2 = 1;
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
    implements TrackingEventBuilder, RecordTemplateBuilder<LegoWidgetImpressionEvent>
  {
    private boolean hasHeader = false;
    public boolean hasIsSyncTrack = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasTrackingToken = false;
    public boolean hasVisibility = false;
    private boolean hasWidgetTrackingId = false;
    private EventHeader header = null;
    public boolean isSyncTrack = false;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public String trackingToken = null;
    public WidgetVisibility visibility = null;
    private String widgetTrackingId = null;
    
    private LegoWidgetImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (LegoWidgetImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new LegoWidgetImpressionEvent(header, requestHeader, mobileHeader, trackingToken, widgetTrackingId, visibility, isSyncTrack, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingToken, hasWidgetTrackingId, hasVisibility, hasIsSyncTrack);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "requestHeader");
        }
      } while (hasTrackingToken);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent", "trackingToken");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */