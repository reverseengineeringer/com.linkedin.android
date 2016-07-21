package com.linkedin.gen.avro2pegasus.events;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class EntityView
  implements RecordTemplate<EntityView>
{
  public static final EntityViewBuilder BUILDER = EntityViewBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasTargetId;
  public final boolean hasViewType;
  public final boolean hasViewerId;
  public final int targetId;
  public final String viewType;
  public final int viewerId;
  
  EntityView(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    viewType = paramString;
    viewerId = paramInt1;
    targetId = paramInt2;
    hasViewType = paramBoolean1;
    hasViewerId = paramBoolean2;
    hasTargetId = paramBoolean3;
    _cachedId = null;
  }
  
  public final EntityView accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasViewType)
    {
      paramDataProcessor.startRecordField$505cff1c("viewType");
      paramDataProcessor.processString(viewType);
    }
    if (hasViewerId)
    {
      paramDataProcessor.startRecordField$505cff1c("viewerId");
      paramDataProcessor.processInt(viewerId);
    }
    if (hasTargetId)
    {
      paramDataProcessor.startRecordField$505cff1c("targetId");
      paramDataProcessor.processInt(targetId);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasViewType) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EntityView", "viewType");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasTargetId) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EntityView", "targetId");
      }
      return new EntityView(viewType, viewerId, targetId, hasViewType, hasViewerId, hasTargetId);
    }
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
      paramObject = (EntityView)paramObject;
      if (viewType != null)
      {
        if (viewType.equals(viewType)) {}
      }
      else {
        while (viewType != null) {
          return false;
        }
      }
      if (viewerId != viewerId) {
        return false;
      }
    } while (targetId == targetId);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (viewType != null) {}
    for (int i = viewType.hashCode();; i = 0)
    {
      i = ((i + 527) * 31 + viewerId) * 31 + targetId;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<EntityView>
  {
    public boolean hasTargetId = false;
    public boolean hasViewType = false;
    public boolean hasViewerId = false;
    public int targetId = 0;
    public String viewType = null;
    public int viewerId = 0;
    
    public final EntityView build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EntityView.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new EntityView(viewType, viewerId, targetId, hasViewType, hasViewerId, hasTargetId);
        if (!hasViewType) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EntityView", "viewType");
        }
      } while (hasTargetId);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.EntityView", "targetId");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.EntityView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */