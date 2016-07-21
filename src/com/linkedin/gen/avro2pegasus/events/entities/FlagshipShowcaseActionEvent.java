package com.linkedin.gen.avro2pegasus.events.entities;

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

public final class FlagshipShowcaseActionEvent
  implements RecordTemplate<FlagshipShowcaseActionEvent>
{
  public static final FlagshipShowcaseActionEventBuilder BUILDER = FlagshipShowcaseActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActionCategory actionCategory;
  public final String controlUrn;
  public final boolean hasActionCategory;
  public final boolean hasControlUrn;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasShowcase;
  public final boolean hasSubItemUrn;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final TrackingObject showcase;
  public final String subItemUrn;
  
  FlagshipShowcaseActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, ActionCategory paramActionCategory, String paramString2, TrackingObject paramTrackingObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    controlUrn = paramString1;
    actionCategory = paramActionCategory;
    subItemUrn = paramString2;
    showcase = paramTrackingObject;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasControlUrn = paramBoolean4;
    hasActionCategory = paramBoolean5;
    hasSubItemUrn = paramBoolean6;
    hasShowcase = paramBoolean7;
    _cachedId = null;
  }
  
  private FlagshipShowcaseActionEvent accept(DataProcessor paramDataProcessor)
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
          break label343;
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
          break label352;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label370;
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
          break label379;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label397;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
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
      if (hasSubItemUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("subItemUrn");
        paramDataProcessor.processString(subItemUrn);
      }
      localObject1 = null;
      bool4 = false;
      if (hasShowcase)
      {
        paramDataProcessor.startRecordField$505cff1c("showcase");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label407;
        }
        localObject1 = showcase.accept(paramDataProcessor);
        label273:
        if (localObject1 == null) {
          break label425;
        }
      }
    }
    label343:
    label352:
    label370:
    label379:
    label397:
    label407:
    label425:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label553;
      }
      try
      {
        if (hasHeader) {
          break label431;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "header");
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
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(showcase);
      break label273;
    }
    label431:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "requestHeader");
    }
    if (!hasControlUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "controlUrn");
    }
    if (!hasActionCategory) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "actionCategory");
    }
    if (!hasShowcase) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "showcase");
    }
    return new FlagshipShowcaseActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, controlUrn, actionCategory, subItemUrn, (TrackingObject)localObject1, bool1, bool2, bool3, hasControlUrn, hasActionCategory, hasSubItemUrn, bool4);
    label553:
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
      paramObject = (FlagshipShowcaseActionEvent)paramObject;
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
      if (controlUrn != null)
      {
        if (controlUrn.equals(controlUrn)) {}
      }
      else {
        while (controlUrn != null) {
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
      if (subItemUrn != null)
      {
        if (subItemUrn.equals(subItemUrn)) {}
      }
      else {
        while (subItemUrn != null) {
          return false;
        }
      }
      if (showcase == null) {
        break;
      }
    } while (showcase.equals(showcase));
    for (;;)
    {
      return false;
      if (showcase == null) {
        break;
      }
    }
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
        break label176;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label181;
      }
      k = mobileHeader.hashCode();
      if (controlUrn == null) {
        break label186;
      }
      m = controlUrn.hashCode();
      if (actionCategory == null) {
        break label192;
      }
      n = actionCategory.hashCode();
      label92:
      if (subItemUrn == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = subItemUrn.hashCode();; i1 = 0)
    {
      if (showcase != null) {
        i2 = showcase.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipShowcaseActionEvent>
  {
    public ActionCategory actionCategory = null;
    public String controlUrn = null;
    public boolean hasActionCategory = false;
    public boolean hasControlUrn = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasShowcase = false;
    public boolean hasSubItemUrn = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public TrackingObject showcase = null;
    public String subItemUrn = null;
    
    private FlagshipShowcaseActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FlagshipShowcaseActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new FlagshipShowcaseActionEvent(header, requestHeader, mobileHeader, controlUrn, actionCategory, subItemUrn, showcase, hasHeader, hasRequestHeader, hasMobileHeader, hasControlUrn, hasActionCategory, hasSubItemUrn, hasShowcase);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "requestHeader");
        }
        if (!hasControlUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "controlUrn");
        }
        if (!hasActionCategory) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "actionCategory");
        }
      } while (hasShowcase);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent", "showcase");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */