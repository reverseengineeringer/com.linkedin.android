package com.linkedin.gen.avro2pegasus.events.identity;

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

public final class SuggestedEditActionEvent
  implements RecordTemplate<SuggestedEditActionEvent>
{
  public static final SuggestedEditActionEventBuilder BUILDER = SuggestedEditActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final SuggestedEditActionType actionType;
  public final String flowTrackingId;
  public final boolean hasActionType;
  public final boolean hasFlowTrackingId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRawProfileElementUrn;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final String rawProfileElementUrn;
  public final UserRequestHeader requestHeader;
  
  SuggestedEditActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString1, String paramString2, SuggestedEditActionType paramSuggestedEditActionType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    rawProfileElementUrn = paramString1;
    flowTrackingId = paramString2;
    actionType = paramSuggestedEditActionType;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasRawProfileElementUrn = paramBoolean4;
    hasFlowTrackingId = paramBoolean5;
    hasActionType = paramBoolean6;
    _cachedId = null;
  }
  
  private SuggestedEditActionEvent accept(DataProcessor paramDataProcessor)
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
      if (hasRawProfileElementUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("rawProfileElementUrn");
        paramDataProcessor.processString(rawProfileElementUrn);
      }
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(flowTrackingId));
      }
      if (hasActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("actionType");
        paramDataProcessor.processEnum(actionType);
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
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "header");
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
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "requestHeader");
    }
    if (!hasRawProfileElementUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "rawProfileElementUrn");
    }
    if (!hasFlowTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "flowTrackingId");
    }
    if (!hasActionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "actionType");
    }
    return new SuggestedEditActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject1, rawProfileElementUrn, flowTrackingId, actionType, bool1, bool2, bool3, hasRawProfileElementUrn, hasFlowTrackingId, hasActionType);
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
      paramObject = (SuggestedEditActionEvent)paramObject;
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
      if (rawProfileElementUrn != null)
      {
        if (rawProfileElementUrn.equals(rawProfileElementUrn)) {}
      }
      else {
        while (rawProfileElementUrn != null) {
          return false;
        }
      }
      if (flowTrackingId != null)
      {
        if (flowTrackingId.equals(flowTrackingId)) {}
      }
      else {
        while (flowTrackingId != null) {
          return false;
        }
      }
      if (actionType == null) {
        break;
      }
    } while (actionType.equals(actionType));
    for (;;)
    {
      return false;
      if (actionType == null) {
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
      if (rawProfileElementUrn == null) {
        break label164;
      }
      m = rawProfileElementUrn.hashCode();
      label76:
      if (flowTrackingId == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = flowTrackingId.hashCode();; n = 0)
    {
      if (actionType != null) {
        i1 = actionType.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedEditActionEvent>
  {
    public SuggestedEditActionType actionType = null;
    public String flowTrackingId = null;
    public boolean hasActionType = false;
    public boolean hasFlowTrackingId = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasRawProfileElementUrn = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public String rawProfileElementUrn = null;
    private UserRequestHeader requestHeader = null;
    
    private SuggestedEditActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SuggestedEditActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SuggestedEditActionEvent(header, requestHeader, mobileHeader, rawProfileElementUrn, flowTrackingId, actionType, hasHeader, hasRequestHeader, hasMobileHeader, hasRawProfileElementUrn, hasFlowTrackingId, hasActionType);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "requestHeader");
        }
        if (!hasRawProfileElementUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "rawProfileElementUrn");
        }
        if (!hasFlowTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "flowTrackingId");
        }
      } while (hasActionType);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent", "actionType");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */