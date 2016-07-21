package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SuggestedEditImpressionEvent
  implements RecordTemplate<SuggestedEditImpressionEvent>
{
  public static final SuggestedEditImpressionEventBuilder BUILDER = SuggestedEditImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String flowTrackingId;
  public final boolean hasFlowTrackingId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRawProfileElementUrns;
  public final boolean hasRequestHeader;
  public final boolean hasSuggestionSource;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final List<String> rawProfileElementUrns;
  public final UserRequestHeader requestHeader;
  public final SuggestionSource suggestionSource;
  
  SuggestedEditImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, List<String> paramList, String paramString, SuggestionSource paramSuggestionSource, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      rawProfileElementUrns = paramEventHeader;
      flowTrackingId = paramString;
      suggestionSource = paramSuggestionSource;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasRawProfileElementUrns = paramBoolean4;
      hasFlowTrackingId = paramBoolean5;
      hasSuggestionSource = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  private SuggestedEditImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    boolean bool3;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label312;
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
          break label321;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label339;
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
          break label349;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label148:
        if (localObject1 == null) {
          break label367;
        }
        bool3 = true;
      }
    }
    Object localObject5;
    for (Object localObject4 = localObject1;; localObject4 = localObject1)
    {
      localObject1 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasRawProfileElementUrns) {
        break label391;
      }
      paramDataProcessor.startRecordField$505cff1c("rawProfileElementUrns");
      rawProfileElementUrns.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject5 = rawProfileElementUrns.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label312:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label321:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label339:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label349:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label367:
      bool3 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label391:
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        localObject5 = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(flowTrackingId));
      }
      if (hasSuggestionSource)
      {
        paramDataProcessor.startRecordField$505cff1c("suggestionSource");
        paramDataProcessor.processEnum(suggestionSource);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label645;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "requestHeader");
    }
    if (!hasRawProfileElementUrns) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "rawProfileElementUrns");
    }
    if (!hasFlowTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "flowTrackingId");
    }
    if (rawProfileElementUrns != null)
    {
      paramDataProcessor = rawProfileElementUrns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "rawProfileElementUrns");
        }
      }
    }
    return new SuggestedEditImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (List)localObject1, flowTrackingId, suggestionSource, bool1, bool2, bool3, bool4, hasFlowTrackingId, hasSuggestionSource);
    label645:
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
      paramObject = (SuggestedEditImpressionEvent)paramObject;
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
      if (rawProfileElementUrns != null)
      {
        if (rawProfileElementUrns.equals(rawProfileElementUrns)) {}
      }
      else {
        while (rawProfileElementUrns != null) {
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
      if (suggestionSource == null) {
        break;
      }
    } while (suggestionSource.equals(suggestionSource));
    for (;;)
    {
      return false;
      if (suggestionSource == null) {
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
        break label156;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label161;
      }
      k = mobileHeader.hashCode();
      if (rawProfileElementUrns == null) {
        break label166;
      }
      m = rawProfileElementUrns.hashCode();
      label78:
      if (flowTrackingId == null) {
        break label172;
      }
    }
    label156:
    label161:
    label166:
    label172:
    for (int n = flowTrackingId.hashCode();; n = 0)
    {
      if (suggestionSource != null) {
        i1 = suggestionSource.hashCode();
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
      break label78;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<SuggestedEditImpressionEvent>
  {
    public String flowTrackingId = null;
    public boolean hasFlowTrackingId = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    public boolean hasRawProfileElementUrns = false;
    private boolean hasRequestHeader = false;
    public boolean hasSuggestionSource = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    public List<String> rawProfileElementUrns = null;
    private UserRequestHeader requestHeader = null;
    public SuggestionSource suggestionSource = null;
    
    private SuggestedEditImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SuggestedEditImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (rawProfileElementUrns != null)
      {
        paramFlavor = rawProfileElementUrns.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "rawProfileElementUrns");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "requestHeader");
              }
              if (!hasRawProfileElementUrns) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "rawProfileElementUrns");
              }
              if (hasFlowTrackingId) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent", "flowTrackingId");
            }
          }
        }
      }
      return new SuggestedEditImpressionEvent(header, requestHeader, mobileHeader, rawProfileElementUrns, flowTrackingId, suggestionSource, hasHeader, hasRequestHeader, hasMobileHeader, hasRawProfileElementUrns, hasFlowTrackingId, hasSuggestionSource);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */