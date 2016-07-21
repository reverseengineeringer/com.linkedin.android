package com.linkedin.gen.avro2pegasus.events.guidededit;

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
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.common.guidededit.IsbFieldName;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GuidedEditFlowImpressionEvent
  implements RecordTemplate<GuidedEditFlowImpressionEvent>
{
  public static final GuidedEditFlowImpressionEventBuilder BUILDER = GuidedEditFlowImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final GuidedEditContextType contextType;
  public final List<IsbFieldName> fieldNames;
  public final String flowTrackingId;
  public final boolean hasContextType;
  public final boolean hasFieldNames;
  public final boolean hasFlowTrackingId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  GuidedEditFlowImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, GuidedEditContextType paramGuidedEditContextType, List<IsbFieldName> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    contextType = paramGuidedEditContextType;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      fieldNames = paramEventHeader;
      flowTrackingId = paramString;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasContextType = paramBoolean4;
      hasFieldNames = paramBoolean5;
      hasFlowTrackingId = paramBoolean6;
      _cachedId = null;
      return;
    }
  }
  
  private GuidedEditFlowImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label337;
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
          break label346;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label364;
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
          break label374;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        label148:
        if (localObject1 == null) {
          break label392;
        }
        bool3 = true;
      }
    }
    Object localObject5;
    for (Object localObject4 = localObject1;; localObject4 = localObject1)
    {
      if (hasContextType)
      {
        paramDataProcessor.startRecordField$505cff1c("contextType");
        paramDataProcessor.processEnum(contextType);
      }
      localObject1 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasFieldNames) {
        break label416;
      }
      paramDataProcessor.startRecordField$505cff1c("fieldNames");
      fieldNames.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localObject5 = fieldNames.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        IsbFieldName localIsbFieldName = (IsbFieldName)((Iterator)localObject5).next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum(localIsbFieldName);
        if (localObject1 != null) {
          ((List)localObject1).add(localIsbFieldName);
        }
        i += 1;
      }
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      label337:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label346:
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      label364:
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      label374:
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      label392:
      bool3 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label416:
      if (hasFlowTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("flowTrackingId");
        localObject5 = BytesCoercer.INSTANCE;
        paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(flowTrackingId));
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
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "requestHeader");
    }
    if (!hasContextType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "contextType");
    }
    if (!hasFlowTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "flowTrackingId");
    }
    if (fieldNames != null)
    {
      paramDataProcessor = fieldNames.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((IsbFieldName)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "fieldNames");
        }
      }
    }
    return new GuidedEditFlowImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, contextType, (List)localObject1, flowTrackingId, bool1, bool2, bool3, hasContextType, bool4, hasFlowTrackingId);
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
      paramObject = (GuidedEditFlowImpressionEvent)paramObject;
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
      if (contextType != null)
      {
        if (contextType.equals(contextType)) {}
      }
      else {
        while (contextType != null) {
          return false;
        }
      }
      if (fieldNames != null)
      {
        if (fieldNames.equals(fieldNames)) {}
      }
      else {
        while (fieldNames != null) {
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
        break label156;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label161;
      }
      k = mobileHeader.hashCode();
      if (contextType == null) {
        break label166;
      }
      m = contextType.hashCode();
      label76:
      if (fieldNames == null) {
        break label172;
      }
    }
    label156:
    label161:
    label166:
    label172:
    for (int n = fieldNames.hashCode();; n = 0)
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
    implements TrackingEventBuilder, RecordTemplateBuilder<GuidedEditFlowImpressionEvent>
  {
    public GuidedEditContextType contextType = null;
    public List<IsbFieldName> fieldNames = null;
    public String flowTrackingId = null;
    public boolean hasContextType = false;
    public boolean hasFieldNames = false;
    public boolean hasFlowTrackingId = false;
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private GuidedEditFlowImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (GuidedEditFlowImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (fieldNames != null)
      {
        paramFlavor = fieldNames.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((IsbFieldName)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "fieldNames");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "requestHeader");
              }
              if (!hasContextType) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "contextType");
              }
              if (hasFlowTrackingId) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent", "flowTrackingId");
            }
          }
        }
      }
      return new GuidedEditFlowImpressionEvent(header, requestHeader, mobileHeader, contextType, fieldNames, flowTrackingId, hasHeader, hasRequestHeader, hasMobileHeader, hasContextType, hasFieldNames, hasFlowTrackingId);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */