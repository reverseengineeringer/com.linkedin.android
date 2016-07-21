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

public final class LegoWidgetActionEvent
  implements RecordTemplate<LegoWidgetActionEvent>
{
  public static final LegoWidgetActionEventBuilder BUILDER = LegoWidgetActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final WidgetActionCategory actionCategory;
  public final int actionCount;
  public final String actionName;
  public final boolean hasActionCategory;
  public final boolean hasActionCount;
  public final boolean hasActionName;
  public final boolean hasHeader;
  public final boolean hasIsSyncTrack;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasTrackingToken;
  public final boolean hasWidgetTrackingId;
  public final EventHeader header;
  public final boolean isSyncTrack;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final String trackingToken;
  public final String widgetTrackingId;
  
  LegoWidgetActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, WidgetActionCategory paramWidgetActionCategory, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    trackingToken = paramString1;
    widgetTrackingId = paramString2;
    actionCategory = paramWidgetActionCategory;
    actionName = paramString3;
    actionCount = paramInt;
    isSyncTrack = paramBoolean1;
    hasHeader = paramBoolean2;
    hasRequestHeader = paramBoolean3;
    hasMobileHeader = paramBoolean4;
    hasTrackingToken = paramBoolean5;
    hasWidgetTrackingId = paramBoolean6;
    hasActionCategory = paramBoolean7;
    hasActionName = paramBoolean8;
    hasActionCount = paramBoolean9;
    hasIsSyncTrack = paramBoolean10;
    _cachedId = null;
  }
  
  private LegoWidgetActionEvent accept(DataProcessor paramDataProcessor)
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
          break label374;
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
          break label383;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label401;
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
          break label410;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label428;
        }
      }
    }
    label374:
    label383:
    label401:
    label410:
    label428:
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
      if (hasActionCategory)
      {
        paramDataProcessor.startRecordField$505cff1c("actionCategory");
        paramDataProcessor.processEnum(actionCategory);
      }
      if (hasActionName)
      {
        paramDataProcessor.startRecordField$505cff1c("actionName");
        paramDataProcessor.processString(actionName);
      }
      if (hasActionCount)
      {
        paramDataProcessor.startRecordField$505cff1c("actionCount");
        paramDataProcessor.processInt(actionCount);
      }
      if (hasIsSyncTrack)
      {
        paramDataProcessor.startRecordField$505cff1c("isSyncTrack");
        paramDataProcessor.processBoolean(isSyncTrack);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label557;
      }
      try
      {
        if (hasHeader) {
          break label434;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "header");
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
    label434:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "requestHeader");
    }
    if (!hasTrackingToken) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "trackingToken");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "actionCategory");
    }
    return new LegoWidgetActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, trackingToken, widgetTrackingId, actionCategory, actionName, actionCount, isSyncTrack, bool1, bool2, bool3, hasTrackingToken, hasWidgetTrackingId, hasActionCategory, hasActionName, hasActionCount, hasIsSyncTrack);
    label557:
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
      paramObject = (LegoWidgetActionEvent)paramObject;
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
      if (actionCategory != null)
      {
        if (actionCategory.equals(actionCategory)) {}
      }
      else {
        while (actionCategory != null) {
          return false;
        }
      }
      if (actionName != null)
      {
        if (actionName.equals(actionName)) {}
      }
      else {
        while (actionName != null) {
          return false;
        }
      }
      if (actionCount != actionCount) {
        return false;
      }
    } while (isSyncTrack == isSyncTrack);
    return false;
  }
  
  public final int hashCode()
  {
    int i3 = 0;
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
    label92:
    int i1;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label204;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label209;
      }
      k = mobileHeader.hashCode();
      if (trackingToken == null) {
        break label214;
      }
      m = trackingToken.hashCode();
      if (widgetTrackingId == null) {
        break label220;
      }
      n = widgetTrackingId.hashCode();
      if (actionCategory == null) {
        break label226;
      }
      i1 = actionCategory.hashCode();
      label108:
      if (actionName == null) {
        break label232;
      }
    }
    label204:
    label209:
    label214:
    label220:
    label226:
    label232:
    for (int i2 = actionName.hashCode();; i2 = 0)
    {
      int i4 = actionCount;
      if (isSyncTrack) {
        i3 = 1;
      }
      i = ((i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + i3;
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
      i1 = 0;
      break label108;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<LegoWidgetActionEvent>
  {
    public WidgetActionCategory actionCategory = null;
    public int actionCount = 0;
    public String actionName = null;
    public boolean hasActionCategory = false;
    public boolean hasActionCount = false;
    public boolean hasActionName = false;
    private boolean hasHeader = false;
    public boolean hasIsSyncTrack = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasTrackingToken = false;
    private boolean hasWidgetTrackingId = false;
    private EventHeader header = null;
    public boolean isSyncTrack = false;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public String trackingToken = null;
    private String widgetTrackingId = null;
    
    private LegoWidgetActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (LegoWidgetActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new LegoWidgetActionEvent(header, requestHeader, mobileHeader, trackingToken, widgetTrackingId, actionCategory, actionName, actionCount, isSyncTrack, hasHeader, hasRequestHeader, hasMobileHeader, hasTrackingToken, hasWidgetTrackingId, hasActionCategory, hasActionName, hasActionCount, hasIsSyncTrack);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "requestHeader");
        }
        if (!hasTrackingToken) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "trackingToken");
        }
      } while (hasActionCategory);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent", "actionCategory");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.lego.LegoWidgetActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */