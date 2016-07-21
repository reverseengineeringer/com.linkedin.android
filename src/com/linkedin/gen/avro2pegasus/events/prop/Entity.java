package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;

public final class Entity
  implements RecordTemplate<Entity>
{
  public static final EntityBuilder BUILDER = EntityBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long duration;
  public final GridPosition gridPosition;
  public final boolean hasDuration;
  public final boolean hasGridPosition;
  public final boolean hasListPosition;
  public final boolean hasSize;
  public final boolean hasTrackingId;
  public final boolean hasUrn;
  public final boolean hasVisibleTime;
  public final ListPosition listPosition;
  public final EntityDimension size;
  public final String trackingId;
  public final String urn;
  public final long visibleTime;
  
  Entity(String paramString1, String paramString2, long paramLong1, long paramLong2, GridPosition paramGridPosition, ListPosition paramListPosition, EntityDimension paramEntityDimension, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    urn = paramString1;
    trackingId = paramString2;
    visibleTime = paramLong1;
    duration = paramLong2;
    gridPosition = paramGridPosition;
    listPosition = paramListPosition;
    size = paramEntityDimension;
    hasUrn = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasVisibleTime = paramBoolean3;
    hasDuration = paramBoolean4;
    hasGridPosition = paramBoolean5;
    hasListPosition = paramBoolean6;
    hasSize = paramBoolean7;
    _cachedId = null;
  }
  
  public final Entity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("urn");
      paramDataProcessor.processString(urn);
    }
    Object localObject1;
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      localObject1 = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
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
    label164:
    Object localObject3;
    boolean bool2;
    if (hasGridPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("gridPosition");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = gridPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label324;
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
          break label333;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        label203:
        if (localObject1 == null) {
          break label351;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label214:
      localObject1 = null;
      bool3 = false;
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label360;
        }
        localObject1 = size.accept(paramDataProcessor);
        label254:
        if (localObject1 == null) {
          break label378;
        }
      }
    }
    label324:
    label333:
    label351:
    label360:
    label378:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label472;
      }
      try
      {
        if (hasUrn) {
          break label384;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "urn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(gridPosition);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label164;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label203;
      bool2 = false;
      localObject3 = localObject1;
      break label214;
      localObject1 = (EntityDimension)paramDataProcessor.processDataTemplate(size);
      break label254;
    }
    label384:
    if (!hasTrackingId) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "trackingId");
    }
    if (!hasVisibleTime) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "visibleTime");
    }
    return new Entity(urn, trackingId, visibleTime, duration, (GridPosition)localObject2, (ListPosition)localObject3, (EntityDimension)localObject1, hasUrn, hasTrackingId, hasVisibleTime, hasDuration, bool1, bool2, bool3);
    label472:
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
      paramObject = (Entity)paramObject;
      if (urn != null)
      {
        if (urn.equals(urn)) {}
      }
      else {
        while (urn != null) {
          return false;
        }
      }
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
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
      if (size == null) {
        break;
      }
    } while (size.equals(size));
    for (;;)
    {
      return false;
      if (size == null) {
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
    int i1;
    int i2;
    int k;
    if (urn != null)
    {
      i = urn.hashCode();
      if (trackingId == null) {
        break label174;
      }
      j = trackingId.hashCode();
      i1 = (int)(visibleTime ^ visibleTime >>> 32);
      i2 = (int)(duration ^ duration >>> 32);
      if (gridPosition == null) {
        break label179;
      }
      k = gridPosition.hashCode();
      label90:
      if (listPosition == null) {
        break label184;
      }
    }
    label174:
    label179:
    label184:
    for (int m = listPosition.hashCode();; m = 0)
    {
      if (size != null) {
        n = size.hashCode();
      }
      i = (m + (k + (((j + (i + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label90;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<Entity>
  {
    private long duration = 0L;
    private GridPosition gridPosition = null;
    private boolean hasDuration = false;
    private boolean hasGridPosition = false;
    private boolean hasListPosition = false;
    private boolean hasSize = false;
    private boolean hasTrackingId = false;
    private boolean hasUrn = false;
    private boolean hasVisibleTime = false;
    private ListPosition listPosition = null;
    private EntityDimension size = null;
    private String trackingId = null;
    private String urn = null;
    private long visibleTime = 0L;
    
    public final Entity build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Entity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Entity(urn, trackingId, visibleTime, duration, gridPosition, listPosition, size, hasUrn, hasTrackingId, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize);
        if (!hasUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "urn");
        }
        if (!hasTrackingId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "trackingId");
        }
      } while (hasVisibleTime);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.Entity", "visibleTime");
    }
    
    public final Builder setDuration(Long paramLong)
    {
      if (paramLong == null)
      {
        hasDuration = false;
        duration = 0L;
        return this;
      }
      hasDuration = true;
      duration = paramLong.longValue();
      return this;
    }
    
    public final Builder setListPosition(ListPosition paramListPosition)
    {
      if (paramListPosition == null)
      {
        hasListPosition = false;
        listPosition = null;
        return this;
      }
      hasListPosition = true;
      listPosition = paramListPosition;
      return this;
    }
    
    public final Builder setSize(EntityDimension paramEntityDimension)
    {
      if (paramEntityDimension == null)
      {
        hasSize = false;
        size = null;
        return this;
      }
      hasSize = true;
      size = paramEntityDimension;
      return this;
    }
    
    public final Builder setTrackingId(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingId = false;
        trackingId = null;
        return this;
      }
      hasTrackingId = true;
      trackingId = paramString;
      return this;
    }
    
    public final Builder setUrn(String paramString)
    {
      if (paramString == null)
      {
        hasUrn = false;
        urn = null;
        return this;
      }
      hasUrn = true;
      urn = paramString;
      return this;
    }
    
    public final Builder setVisibleTime(Long paramLong)
    {
      if (paramLong == null)
      {
        hasVisibleTime = false;
        visibleTime = 0L;
        return this;
      }
      hasVisibleTime = true;
      visibleTime = paramLong.longValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.Entity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */