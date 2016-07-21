package com.linkedin.gen.avro2pegasus.events.me.wvmp;

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

public final class WvmpOverviewInsightImpressionEvent
  implements RecordTemplate<WvmpOverviewInsightImpressionEvent>
{
  public static final WvmpOverviewInsightImpressionEventBuilder BUILDER = WvmpOverviewInsightImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final boolean hasWvmpOverviewInsights;
  public final EventHeader header;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  public final List<WvmpOverviewInsightImpression> wvmpOverviewInsights;
  
  WvmpOverviewInsightImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, List<WvmpOverviewInsightImpression> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      wvmpOverviewInsights = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasWvmpOverviewInsights = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  private WvmpOverviewInsightImpressionEvent accept(DataProcessor paramDataProcessor)
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
          break label363;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label381;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject1 = null;
      localWvmpOverviewInsightImpression = null;
      bool4 = false;
      if (!hasWvmpOverviewInsights) {
        break label421;
      }
      paramDataProcessor.startRecordField$505cff1c("wvmpOverviewInsights");
      wvmpOverviewInsights.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localWvmpOverviewInsightImpression;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = wvmpOverviewInsights.iterator();
      label235:
      if (!localIterator.hasNext()) {
        break label407;
      }
      localWvmpOverviewInsightImpression = (WvmpOverviewInsightImpression)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label391;
      }
    }
    label326:
    label335:
    label353:
    label363:
    label381:
    label391:
    for (WvmpOverviewInsightImpression localWvmpOverviewInsightImpression = localWvmpOverviewInsightImpression.accept(paramDataProcessor);; localWvmpOverviewInsightImpression = (WvmpOverviewInsightImpression)paramDataProcessor.processDataTemplate(localWvmpOverviewInsightImpression))
    {
      if ((localObject1 != null) && (localWvmpOverviewInsightImpression != null)) {
        ((List)localObject1).add(localWvmpOverviewInsightImpression);
      }
      i += 1;
      break label235;
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
    label407:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label421:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label582;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "requestHeader");
    }
    if (!hasWvmpOverviewInsights) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "wvmpOverviewInsights");
    }
    if (wvmpOverviewInsights != null)
    {
      paramDataProcessor = wvmpOverviewInsights.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((WvmpOverviewInsightImpression)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "wvmpOverviewInsights");
        }
      }
    }
    return new WvmpOverviewInsightImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (List)localObject1, bool1, bool2, bool3, bool4);
    label582:
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
      paramObject = (WvmpOverviewInsightImpressionEvent)paramObject;
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
      if (wvmpOverviewInsights == null) {
        break;
      }
    } while (wvmpOverviewInsights.equals(wvmpOverviewInsights));
    for (;;)
    {
      return false;
      if (wvmpOverviewInsights == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label112;
      }
      j = requestHeader.hashCode();
      label45:
      if (mobileHeader == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = mobileHeader.hashCode();; k = 0)
    {
      if (wvmpOverviewInsights != null) {
        m = wvmpOverviewInsights.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<WvmpOverviewInsightImpressionEvent>
  {
    private boolean hasHeader = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    public boolean hasWvmpOverviewInsights = false;
    private EventHeader header = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    public List<WvmpOverviewInsightImpression> wvmpOverviewInsights = null;
    
    private WvmpOverviewInsightImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (WvmpOverviewInsightImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (wvmpOverviewInsights != null)
      {
        paramFlavor = wvmpOverviewInsights.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((WvmpOverviewInsightImpression)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "wvmpOverviewInsights");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "requestHeader");
              }
              if (hasWvmpOverviewInsights) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent", "wvmpOverviewInsights");
            }
          }
        }
      }
      return new WvmpOverviewInsightImpressionEvent(header, requestHeader, mobileHeader, wvmpOverviewInsights, hasHeader, hasRequestHeader, hasMobileHeader, hasWvmpOverviewInsights);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.wvmp.WvmpOverviewInsightImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */