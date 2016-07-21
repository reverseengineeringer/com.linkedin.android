package com.linkedin.gen.avro2pegasus.events.pymk;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
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

public final class PymkClientImpressionEvent
  implements RecordTemplate<PymkClientImpressionEvent>
{
  public static final PymkClientImpressionEventBuilder BUILDER = PymkClientImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRecommendations;
  public final boolean hasRequestHeader;
  public final boolean hasUsageContext;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final List<PymkRecommendation> recommendations;
  public final UserRequestHeader requestHeader;
  public final String usageContext;
  
  PymkClientImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, List<PymkRecommendation> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    usageContext = paramString;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      recommendations = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasUsageContext = paramBoolean4;
      hasRecommendations = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  private PymkClientImpressionEvent accept(DataProcessor paramDataProcessor)
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
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label351;
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
          break label360;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label378;
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
          break label388;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label406;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasUsageContext)
      {
        paramDataProcessor.startRecordField$505cff1c("usageContext");
        paramDataProcessor.processString(usageContext);
      }
      localObject1 = null;
      localPymkRecommendation = null;
      bool4 = false;
      if (!hasRecommendations) {
        break label446;
      }
      paramDataProcessor.startRecordField$505cff1c("recommendations");
      recommendations.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localPymkRecommendation;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = recommendations.iterator();
      label260:
      if (!localIterator.hasNext()) {
        break label432;
      }
      localPymkRecommendation = (PymkRecommendation)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label416;
      }
    }
    label351:
    label360:
    label378:
    label388:
    label406:
    label416:
    for (PymkRecommendation localPymkRecommendation = localPymkRecommendation.accept(paramDataProcessor);; localPymkRecommendation = (PymkRecommendation)paramDataProcessor.processDataTemplate(localPymkRecommendation))
    {
      if ((localObject1 != null) && (localPymkRecommendation != null)) {
        ((List)localObject1).add(localPymkRecommendation);
      }
      i += 1;
      break label260;
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      bool3 = false;
      localObject4 = localObject1;
      break label160;
    }
    label432:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label446:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label634;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "requestHeader");
    }
    if (!hasUsageContext) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "usageContext");
    }
    if (!hasRecommendations) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "recommendations");
    }
    if (recommendations != null)
    {
      paramDataProcessor = recommendations.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PymkRecommendation)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "recommendations");
        }
      }
    }
    return new PymkClientImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, usageContext, (List)localObject1, bool1, bool2, bool3, hasUsageContext, bool4);
    label634:
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
      paramObject = (PymkClientImpressionEvent)paramObject;
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
      if (usageContext != null)
      {
        if (usageContext.equals(usageContext)) {}
      }
      else {
        while (usageContext != null) {
          return false;
        }
      }
      if (recommendations == null) {
        break;
      }
    } while (recommendations.equals(recommendations));
    for (;;)
    {
      return false;
      if (recommendations == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label134;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label139;
      }
      k = mobileHeader.hashCode();
      label60:
      if (usageContext == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = usageContext.hashCode();; m = 0)
    {
      if (recommendations != null) {
        n = recommendations.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<PymkClientImpressionEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRecommendations = false;
    private boolean hasRequestHeader = false;
    private boolean hasUsageContext = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private List<PymkRecommendation> recommendations = null;
    private UserRequestHeader requestHeader = null;
    private String usageContext = null;
    
    private PymkClientImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PymkClientImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (recommendations != null)
      {
        paramFlavor = recommendations.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((PymkRecommendation)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "recommendations");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "requestHeader");
              }
              if (!hasUsageContext) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "usageContext");
              }
              if (hasRecommendations) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent", "recommendations");
            }
          }
        }
      }
      return new PymkClientImpressionEvent(header, requestHeader, mobileHeader, usageContext, recommendations, hasHeader, hasRequestHeader, hasMobileHeader, hasUsageContext, hasRecommendations);
    }
    
    public final Builder setRecommendations(List<PymkRecommendation> paramList)
    {
      if (paramList == null)
      {
        hasRecommendations = false;
        recommendations = null;
        return this;
      }
      hasRecommendations = true;
      recommendations = paramList;
      return this;
    }
    
    public final Builder setUsageContext(String paramString)
    {
      if (paramString == null)
      {
        hasUsageContext = false;
        usageContext = null;
        return this;
      }
      hasUsageContext = true;
      usageContext = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.pymk.PymkClientImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */