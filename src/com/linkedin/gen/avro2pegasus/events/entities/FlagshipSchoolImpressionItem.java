package com.linkedin.gen.avro2pegasus.events.entities;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class FlagshipSchoolImpressionItem
  implements RecordTemplate<FlagshipSchoolImpressionItem>
{
  public static final FlagshipSchoolImpressionItemBuilder BUILDER = FlagshipSchoolImpressionItemBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long duration;
  public final GridPosition gridPosition;
  public final boolean hasDuration;
  public final boolean hasGridPosition;
  public final boolean hasItemTrackingId;
  public final boolean hasListPosition;
  public final boolean hasSize;
  public final boolean hasUrns;
  public final boolean hasVisibleTime;
  public final String itemTrackingId;
  public final ListPosition listPosition;
  public final EntityDimension size;
  public final List<String> urns;
  public final long visibleTime;
  
  FlagshipSchoolImpressionItem(String paramString, long paramLong1, long paramLong2, GridPosition paramGridPosition, ListPosition paramListPosition, EntityDimension paramEntityDimension, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    itemTrackingId = paramString;
    visibleTime = paramLong1;
    duration = paramLong2;
    gridPosition = paramGridPosition;
    listPosition = paramListPosition;
    size = paramEntityDimension;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      urns = paramString;
      hasItemTrackingId = paramBoolean1;
      hasVisibleTime = paramBoolean2;
      hasDuration = paramBoolean3;
      hasGridPosition = paramBoolean4;
      hasListPosition = paramBoolean5;
      hasSize = paramBoolean6;
      hasUrns = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  public final FlagshipSchoolImpressionItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasItemTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("itemTrackingId");
      localObject1 = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(itemTrackingId));
    }
    if (hasVisibleTime)
    {
      paramDataProcessor.startRecordField$505cff1c("visibleTime");
      paramDataProcessor.processLong(visibleTime);
    }
    if (hasDuration)
    {
      paramDataProcessor.startRecordField$505cff1c("duration");
      paramDataProcessor.processLong(duration);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    label139:
    Object localObject3;
    boolean bool2;
    label179:
    label191:
    boolean bool3;
    if (hasGridPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("gridPosition");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = gridPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label395;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasListPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("listPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label404;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label422;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label432;
        }
        localObject1 = size.accept(paramDataProcessor);
        label231:
        if (localObject1 == null) {
          break label450;
        }
        bool3 = true;
      }
    }
    for (Object localObject4 = localObject1;; localObject4 = localObject1)
    {
      localObject1 = null;
      Iterator localIterator = null;
      bool4 = false;
      if (!hasUrns) {
        break label474;
      }
      paramDataProcessor.startRecordField$505cff1c("urns");
      urns.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = urns.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(gridPosition);
      break;
      label395:
      bool1 = false;
      localObject2 = localObject1;
      break label139;
      label404:
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label179;
      label422:
      bool2 = false;
      localObject3 = localObject1;
      break label191;
      label432:
      localObject1 = (EntityDimension)paramDataProcessor.processDataTemplate(size);
      break label231;
      label450:
      bool3 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label474:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label659;
      }
      try
      {
        if (hasItemTrackingId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "itemTrackingId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasVisibleTime) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "visibleTime");
    }
    if (!hasUrns) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "urns");
    }
    if (urns != null)
    {
      paramDataProcessor = urns.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "urns");
        }
      }
    }
    return new FlagshipSchoolImpressionItem(itemTrackingId, visibleTime, duration, (GridPosition)localObject2, (ListPosition)localObject3, (EntityDimension)localObject4, (List)localObject1, hasItemTrackingId, hasVisibleTime, hasDuration, bool1, bool2, bool3, bool4);
    label659:
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
      paramObject = (FlagshipSchoolImpressionItem)paramObject;
      if (itemTrackingId != null)
      {
        if (itemTrackingId.equals(itemTrackingId)) {}
      }
      else {
        while (itemTrackingId != null) {
          return false;
        }
      }
      if (visibleTime != visibleTime) {
        return false;
      }
      if (duration != duration) {
        return false;
      }
      if (gridPosition != null)
      {
        if (gridPosition.equals(gridPosition)) {}
      }
      else {
        while (gridPosition != null) {
          return false;
        }
      }
      if (listPosition != null)
      {
        if (listPosition.equals(listPosition)) {}
      }
      else {
        while (listPosition != null) {
          return false;
        }
      }
      if (size != null)
      {
        if (size.equals(size)) {}
      }
      else {
        while (size != null) {
          return false;
        }
      }
      if (urns == null) {
        break;
      }
    } while (urns.equals(urns));
    for (;;)
    {
      return false;
      if (urns == null) {
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
    int i1;
    int i2;
    int j;
    label75:
    int k;
    if (itemTrackingId != null)
    {
      i = itemTrackingId.hashCode();
      i1 = (int)(visibleTime ^ visibleTime >>> 32);
      i2 = (int)(duration ^ duration >>> 32);
      if (gridPosition == null) {
        break label176;
      }
      j = gridPosition.hashCode();
      if (listPosition == null) {
        break label181;
      }
      k = listPosition.hashCode();
      label90:
      if (size == null) {
        break label186;
      }
    }
    label176:
    label181:
    label186:
    for (int m = size.hashCode();; m = 0)
    {
      if (urns != null) {
        n = urns.hashCode();
      }
      i = (m + (k + (j + (((i + 527) * 31 + i1) * 31 + i2) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label75;
      k = 0;
      break label90;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<FlagshipSchoolImpressionItem>
  {
    private long duration = 0L;
    private GridPosition gridPosition = null;
    private boolean hasDuration = false;
    private boolean hasGridPosition = false;
    public boolean hasItemTrackingId = false;
    public boolean hasListPosition = false;
    public boolean hasSize = false;
    public boolean hasUrns = false;
    public boolean hasVisibleTime = false;
    public String itemTrackingId = null;
    public ListPosition listPosition = null;
    public EntityDimension size = null;
    public List<String> urns = null;
    public long visibleTime = 0L;
    
    public final FlagshipSchoolImpressionItem build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FlagshipSchoolImpressionItem.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (urns != null)
      {
        paramFlavor = urns.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "urns");
              if (!hasItemTrackingId) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "itemTrackingId");
              }
              if (!hasVisibleTime) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "visibleTime");
              }
              if (hasUrns) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem", "urns");
            }
          }
        }
      }
      return new FlagshipSchoolImpressionItem(itemTrackingId, visibleTime, duration, gridPosition, listPosition, size, urns, hasItemTrackingId, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize, hasUrns);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */