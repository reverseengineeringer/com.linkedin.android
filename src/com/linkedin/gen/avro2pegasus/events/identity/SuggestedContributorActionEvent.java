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

public final class SuggestedContributorActionEvent
  implements RecordTemplate<SuggestedContributorActionEvent>
{
  public static final SuggestedContributorActionEventBuilder BUILDER = SuggestedContributorActionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final SuggestedEditActionType actionType;
  public final Contributor contributor;
  public final String flowTrackingId;
  public final boolean hasActionType;
  public final boolean hasContributor;
  public final boolean hasFlowTrackingId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  SuggestedContributorActionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, Contributor paramContributor, SuggestedEditActionType paramSuggestedEditActionType, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    contributor = paramContributor;
    actionType = paramSuggestedEditActionType;
    flowTrackingId = paramString;
    hasHeader = paramBoolean1;
    hasRequestHeader = paramBoolean2;
    hasMobileHeader = paramBoolean3;
    hasContributor = paramBoolean4;
    hasActionType = paramBoolean5;
    hasFlowTrackingId = paramBoolean6;
    _cachedId = null;
  }
  
  private SuggestedContributorActionEvent accept(DataProcessor paramDataProcessor)
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
          break label326;
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
          break label335;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label353;
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
          break label362;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label380;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasContributor)
      {
        paramDataProcessor.startRecordField$505cff1c("contributor");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label390;
        }
        localObject1 = contributor.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label408;
        }
      }
    }
    label326:
    label335:
    label353:
    label362:
    label380:
    label390:
    label408:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (hasActionType)
      {
        paramDataProcessor.startRecordField$505cff1c("actionType");
        paramDataProcessor.processEnum(actionType);
      }
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(flowTrackingId));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label528;
      }
      try
      {
        if (hasHeader) {
          break label414;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "header");
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
      localObject1 = (Contributor)paramDataProcessor.processDataTemplate(contributor);
      break label198;
    }
    label414:
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "requestHeader");
    }
    if (!hasContributor) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "contributor");
    }
    if (!hasActionType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "actionType");
    }
    if (!hasFlowTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "flowTrackingId");
    }
    return new SuggestedContributorActionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (Contributor)localObject1, actionType, flowTrackingId, bool1, bool2, bool3, bool4, hasActionType, hasFlowTrackingId);
    label528:
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
      paramObject = (SuggestedContributorActionEvent)paramObject;
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
      if (contributor != null)
      {
        if (contributor.equals(contributor)) {}
      }
      else {
        while (contributor != null) {
          return false;
        }
      }
      if (actionType != null)
      {
        if (actionType.equals(actionType)) {}
      }
      else {
        while (actionType != null) {
          return false;
        }
      }
      if (flowTrackingId == null) {
        break;
      }
    } while (flowTrackingId.equals(flowTrackingId));
    for (;;)
    {
      return false;
      if (flowTrackingId == null) {
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
      if (contributor == null) {
        break label164;
      }
      m = contributor.hashCode();
      label76:
      if (actionType == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = actionType.hashCode();; n = 0)
    {
      if (flowTrackingId != null) {
        i1 = flowTrackingId.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedContributorActionEvent>
  {
    public SuggestedEditActionType actionType = null;
    public Contributor contributor = null;
    public String flowTrackingId = null;
    public boolean hasActionType = false;
    public boolean hasContributor = false;
    public boolean hasFlowTrackingId = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private SuggestedContributorActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SuggestedContributorActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SuggestedContributorActionEvent(header, requestHeader, mobileHeader, contributor, actionType, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContributor, hasActionType, hasFlowTrackingId);
        if (!hasHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "header");
        }
        if (!hasRequestHeader) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "requestHeader");
        }
        if (!hasContributor) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "contributor");
        }
        if (!hasActionType) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "actionType");
        }
      } while (hasFlowTrackingId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent", "flowTrackingId");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */