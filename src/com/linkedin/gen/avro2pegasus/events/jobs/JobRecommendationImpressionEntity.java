package com.linkedin.gen.avro2pegasus.events.jobs;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class JobRecommendationImpressionEntity
  implements RecordTemplate<JobRecommendationImpressionEntity>
{
  public static final JobRecommendationImpressionEntityBuilder BUILDER = JobRecommendationImpressionEntityBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long duration;
  public final GridPosition gridPosition;
  public final boolean hasDuration;
  public final boolean hasGridPosition;
  public final boolean hasIsSponsored;
  public final boolean hasListPosition;
  public final boolean hasRecommendation;
  public final boolean hasSize;
  public final boolean hasVisibleTime;
  public final boolean isSponsored;
  public final ListPosition listPosition;
  public final TrackingObject recommendation;
  public final EntityDimension size;
  public final long visibleTime;
  
  JobRecommendationImpressionEntity(TrackingObject paramTrackingObject, boolean paramBoolean1, long paramLong1, long paramLong2, GridPosition paramGridPosition, ListPosition paramListPosition, EntityDimension paramEntityDimension, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    recommendation = paramTrackingObject;
    isSponsored = paramBoolean1;
    visibleTime = paramLong1;
    duration = paramLong2;
    gridPosition = paramGridPosition;
    listPosition = paramListPosition;
    size = paramEntityDimension;
    hasRecommendation = paramBoolean2;
    hasIsSponsored = paramBoolean3;
    hasVisibleTime = paramBoolean4;
    hasDuration = paramBoolean5;
    hasGridPosition = paramBoolean6;
    hasListPosition = paramBoolean7;
    hasSize = paramBoolean8;
    _cachedId = null;
  }
  
  public final JobRecommendationImpressionEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label170:
    label181:
    Object localObject4;
    boolean bool3;
    if (hasRecommendation)
    {
      paramDataProcessor.startRecordField$505cff1c("recommendation");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = recommendation.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label343;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasIsSponsored)
      {
        paramDataProcessor.startRecordField$505cff1c("isSponsored");
        paramDataProcessor.processBoolean(isSponsored);
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
      localObject3 = null;
      bool2 = false;
      if (hasGridPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("gridPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label352;
        }
        localObject1 = gridPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label370;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasListPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("listPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label379;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        label221:
        if (localObject1 == null) {
          break label397;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label233:
      localObject1 = null;
      bool4 = false;
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label407;
        }
        localObject1 = size.accept(paramDataProcessor);
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
        break label515;
      }
      try
      {
        if (hasRecommendation) {
          break label431;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "recommendation");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(recommendation);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (GridPosition)paramDataProcessor.processDataTemplate(gridPosition);
      break label170;
      bool2 = false;
      localObject3 = localObject1;
      break label181;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label221;
      bool3 = false;
      localObject4 = localObject1;
      break label233;
      localObject1 = (EntityDimension)paramDataProcessor.processDataTemplate(size);
      break label273;
    }
    label431:
    if (!hasIsSponsored) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "isSponsored");
    }
    if (!hasVisibleTime) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "visibleTime");
    }
    return new JobRecommendationImpressionEntity((TrackingObject)localObject2, isSponsored, visibleTime, duration, (GridPosition)localObject3, (ListPosition)localObject4, (EntityDimension)localObject1, bool1, hasIsSponsored, hasVisibleTime, hasDuration, bool2, bool3, bool4);
    label515:
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
      paramObject = (JobRecommendationImpressionEntity)paramObject;
      if (recommendation != null)
      {
        if (recommendation.equals(recommendation)) {}
      }
      else {
        while (recommendation != null) {
          return false;
        }
      }
      if (isSponsored != isSponsored) {
        return false;
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
    label39:
    int i1;
    int i2;
    int k;
    if (recommendation != null)
    {
      i = recommendation.hashCode();
      if (!isSponsored) {
        break label168;
      }
      j = 1;
      i1 = (int)(visibleTime ^ visibleTime >>> 32);
      i2 = (int)(duration ^ duration >>> 32);
      if (gridPosition == null) {
        break label173;
      }
      k = gridPosition.hashCode();
      label84:
      if (listPosition == null) {
        break label178;
      }
    }
    label168:
    label173:
    label178:
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
      break label39;
      k = 0;
      break label84;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<JobRecommendationImpressionEntity>
  {
    public long duration = 0L;
    private GridPosition gridPosition = null;
    public boolean hasDuration = false;
    private boolean hasGridPosition = false;
    public boolean hasIsSponsored = false;
    public boolean hasListPosition = false;
    public boolean hasRecommendation = false;
    public boolean hasSize = false;
    public boolean hasVisibleTime = false;
    public boolean isSponsored = false;
    public ListPosition listPosition = null;
    public TrackingObject recommendation = null;
    public EntityDimension size = null;
    public long visibleTime = 0L;
    
    public final JobRecommendationImpressionEntity build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (JobRecommendationImpressionEntity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new JobRecommendationImpressionEntity(recommendation, isSponsored, visibleTime, duration, gridPosition, listPosition, size, hasRecommendation, hasIsSponsored, hasVisibleTime, hasDuration, hasGridPosition, hasListPosition, hasSize);
        if (!hasRecommendation) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "recommendation");
        }
        if (!hasIsSponsored) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "isSponsored");
        }
      } while (hasVisibleTime);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity", "visibleTime");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */