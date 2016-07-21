package com.linkedin.gen.avro2pegasus.events.me.wvmpOverview;

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
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class WvmpInsightActionEvent
  implements RecordTemplate<WvmpInsightActionEvent>
{
  public static final WvmpInsightActionEventBuilder BUILDER = WvmpInsightActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActionCategory actionCategory;
  public final String controlUrn;
  public final boolean hasActionCategory;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasInsight;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final TrackingObject insight;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  WvmpInsightActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, String paramString, ActionCategory paramActionCategory, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    insight = paramTrackingObject;
    controlUrn = paramString;
    actionCategory = paramActionCategory;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasInsight = paramBoolean4;
    hasControlUrn = paramBoolean5;
    hasActionCategory = paramBoolean6;
    _cachedId = null;
  }
  
  private WvmpInsightActionEvent accept(DataProcessor paramDataProcessor)
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
          break label318;
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
          break label327;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label345;
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
          break label354;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label372;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label382;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label400;
        }
      }
    }
    label318:
    label327:
    label345:
    label354:
    label372:
    label382:
    label400:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("controlUrn");
        paramDataProcessor.processString(controlUrn);
      }
      if (hasActionCategory)
      {
        paramDataProcessor.startRecordField$505cff1c("actionCategory");
        paramDataProcessor.processEnum(actionCategory);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label520;
      }
      try
      {
        if (hasHeader) {
          break label406;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "header");
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
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(insight);
      break label198;
    }
    label406:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "requestHeader");
    }
    if (!hasInsight) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "insight");
    }
    if (!hasControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "controlUrn");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "actionCategory");
    }
    return new WvmpInsightActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject1, controlUrn, actionCategory, bool1, bool2, bool3, bool4, hasControlUrn, hasActionCategory);
    label520:
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
      paramObject = (WvmpInsightActionEvent)paramObject;
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
      if (insight != null)
      {
        if (insight.equals(insight)) {}
      }
      else {
        while (insight != null) {
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
      if (actionCategory == null) {
        break;
      }
    } while (actionCategory.equals(actionCategory));
    for (;;)
    {
      return false;
      if (actionCategory == null) {
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
      if (insight == null) {
        break label164;
      }
      m = insight.hashCode();
      label76:
      if (controlUrn == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = controlUrn.hashCode();; n = 0)
    {
      if (actionCategory != null) {
        i1 = actionCategory.hashCode();
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
  
  public static class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<WvmpInsightActionEvent>
  {
    public ActionCategory actionCategory = null;
    public String controlUrn = null;
    public boolean hasActionCategory = false;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    public boolean hasInsight = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    public TrackingObject insight = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private WvmpInsightActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (WvmpInsightActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new WvmpInsightActionEvent(header, requestHeader, mobileHeader, insight, controlUrn, actionCategory, hasHeader, hasRequestHeader, hasMobileHeader, hasInsight, hasControlUrn, hasActionCategory);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "requestHeader");
        }
        if (!hasInsight) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "insight");
        }
        if (!hasControlUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "controlUrn");
        }
      } while (hasActionCategory);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent", "actionCategory");
    }
    
    public WvmpInsightActionEvent build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmpOverview.WvmpInsightActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */