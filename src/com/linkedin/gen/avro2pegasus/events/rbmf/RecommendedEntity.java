package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class RecommendedEntity
  implements RecordTemplate<RecommendedEntity>
{
  public static final RecommendedEntityBuilder BUILDER = RecommendedEntityBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final TrackingObject entity;
  public final int entityPosition;
  public final boolean hasEntity;
  public final boolean hasEntityPosition;
  public final boolean hasIsFollowing;
  public final boolean isFollowing;
  
  RecommendedEntity(TrackingObject paramTrackingObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entity = paramTrackingObject;
    entityPosition = paramInt;
    isFollowing = paramBoolean1;
    hasEntity = paramBoolean2;
    hasEntityPosition = paramBoolean3;
    hasIsFollowing = paramBoolean4;
    _cachedId = null;
  }
  
  public final RecommendedEntity accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    TrackingObject localTrackingObject = null;
    boolean bool = false;
    if (hasEntity)
    {
      paramDataProcessor.startRecordField$505cff1c("entity");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localTrackingObject = entity.accept(paramDataProcessor);
      if (localTrackingObject == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      if (hasEntityPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("entityPosition");
        paramDataProcessor.processInt(entityPosition);
      }
      if (hasIsFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("isFollowing");
        paramDataProcessor.processBoolean(isFollowing);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasEntity) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity", "entity");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localTrackingObject = (TrackingObject)paramDataProcessor.processDataTemplate(entity);
      break;
    }
    label165:
    if (!hasEntityPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity", "entityPosition");
    }
    return new RecommendedEntity(localTrackingObject, entityPosition, isFollowing, bool, hasEntityPosition, hasIsFollowing);
    label210:
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
      paramObject = (RecommendedEntity)paramObject;
      if (entity != null)
      {
        if (entity.equals(entity)) {}
      }
      else {
        while (entity != null) {
          return false;
        }
      }
      if (entityPosition != entityPosition) {
        return false;
      }
    } while (isFollowing == isFollowing);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (entity != null) {}
    for (int i = entity.hashCode();; i = 0)
    {
      int k = entityPosition;
      if (isFollowing) {
        j = 1;
      }
      i = ((i + 527) * 31 + k) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<RecommendedEntity>
  {
    public TrackingObject entity = null;
    public int entityPosition = 0;
    public boolean hasEntity = false;
    public boolean hasEntityPosition = false;
    private boolean hasIsFollowing = false;
    private boolean isFollowing = false;
    
    public final RecommendedEntity build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (RecommendedEntity.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new RecommendedEntity(entity, entityPosition, isFollowing, hasEntity, hasEntityPosition, hasIsFollowing);
        if (!hasEntity) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity", "entity");
        }
      } while (hasEntityPosition);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity", "entityPosition");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.RecommendedEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */