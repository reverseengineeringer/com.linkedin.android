package com.linkedin.gen.avro2pegasus.events.entities;

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
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class FlagshipJobItemImpressionEvent
  implements RecordTemplate<FlagshipJobItemImpressionEvent>
{
  public static final FlagshipJobItemImpressionEventBuilder BUILDER = FlagshipJobItemImpressionEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasItems;
  public final boolean hasJob;
  public final boolean hasMobileHeader;
  public final boolean hasRequestHeader;
  public final EventHeader header;
  public final List<FlagshipJobImpressionItem> items;
  public final TrackingObject job;
  public final MobileHeader mobileHeader;
  public final UserRequestHeader requestHeader;
  
  FlagshipJobItemImpressionEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, TrackingObject paramTrackingObject, List<FlagshipJobImpressionItem> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    job = paramTrackingObject;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      items = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasJob = paramBoolean4;
      hasItems = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  private FlagshipJobItemImpressionEvent accept(DataProcessor paramDataProcessor)
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
    Object localObject5;
    boolean bool4;
    label200:
    label212:
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label378;
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
          break label387;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label405;
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
          break label415;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label433;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject5 = null;
      bool4 = false;
      if (hasJob)
      {
        paramDataProcessor.startRecordField$505cff1c("job");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label443;
        }
        localObject1 = job.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label461;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      localObject1 = null;
      localFlagshipJobImpressionItem = null;
      bool5 = false;
      if (!hasItems) {
        break label501;
      }
      paramDataProcessor.startRecordField$505cff1c("items");
      items.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localFlagshipJobImpressionItem;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = items.iterator();
      label287:
      if (!localIterator.hasNext()) {
        break label487;
      }
      localFlagshipJobImpressionItem = (FlagshipJobImpressionItem)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label471;
      }
    }
    label378:
    label387:
    label405:
    label415:
    label433:
    label443:
    label461:
    label471:
    for (FlagshipJobImpressionItem localFlagshipJobImpressionItem = localFlagshipJobImpressionItem.accept(paramDataProcessor);; localFlagshipJobImpressionItem = (FlagshipJobImpressionItem)paramDataProcessor.processDataTemplate(localFlagshipJobImpressionItem))
    {
      if ((localObject1 != null) && (localFlagshipJobImpressionItem != null)) {
        ((List)localObject1).add(localFlagshipJobImpressionItem);
      }
      i += 1;
      break label287;
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
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(job);
      break label200;
      bool4 = false;
      localObject5 = localObject1;
      break label212;
    }
    label487:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label501:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label685;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "requestHeader");
    }
    if (!hasJob) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "job");
    }
    if (!hasItems) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "items");
    }
    if (items != null)
    {
      paramDataProcessor = items.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((FlagshipJobImpressionItem)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "items");
        }
      }
    }
    return new FlagshipJobItemImpressionEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, (TrackingObject)localObject5, (List)localObject1, bool1, bool2, bool3, bool4, bool5);
    label685:
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
      paramObject = (FlagshipJobItemImpressionEvent)paramObject;
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
      if (job != null)
      {
        if (job.equals(job)) {}
      }
      else {
        while (job != null) {
          return false;
        }
      }
      if (items == null) {
        break;
      }
    } while (items.equals(items));
    for (;;)
    {
      return false;
      if (items == null) {
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
      if (job == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = job.hashCode();; m = 0)
    {
      if (items != null) {
        n = items.hashCode();
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
    implements TrackingEventBuilder, RecordTemplateBuilder<FlagshipJobItemImpressionEvent>
  {
    private boolean hasHeader = false;
    public boolean hasItems = false;
    public boolean hasJob = false;
    private boolean hasMobileHeader = false;
    private boolean hasRequestHeader = false;
    private EventHeader header = null;
    public List<FlagshipJobImpressionItem> items = null;
    public TrackingObject job = null;
    private MobileHeader mobileHeader = null;
    private UserRequestHeader requestHeader = null;
    
    private FlagshipJobItemImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FlagshipJobItemImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (items != null)
      {
        paramFlavor = items.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((FlagshipJobImpressionItem)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "items");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "requestHeader");
              }
              if (!hasJob) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "job");
              }
              if (hasItems) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent", "items");
            }
          }
        }
      }
      return new FlagshipJobItemImpressionEvent(header, requestHeader, mobileHeader, job, items, hasHeader, hasRequestHeader, hasMobileHeader, hasJob, hasItems);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */