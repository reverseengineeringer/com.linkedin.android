package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class EntityAwareSuggestionInfo
  implements RecordTemplate<EntityAwareSuggestionInfo>
{
  public static final EntityAwareSuggestionInfoBuilder BUILDER = EntityAwareSuggestionInfoBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasSuggestedEntities;
  public final List<SuggestedEntityType> suggestedEntities;
  
  EntityAwareSuggestionInfo(List<SuggestedEntityType> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      suggestedEntities = paramList;
      hasSuggestedEntities = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final EntityAwareSuggestionInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasSuggestedEntities)
    {
      paramDataProcessor.startRecordField$505cff1c("suggestedEntities");
      suggestedEntities.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = suggestedEntities.iterator();
      while (localIterator.hasNext())
      {
        SuggestedEntityType localSuggestedEntityType = (SuggestedEntityType)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processEnum(localSuggestedEntityType);
        if (localObject != null) {
          ((List)localObject).add(localSuggestedEntityType);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label196;
      }
    }
    label196:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label262;
      }
      try
      {
        if (hasSuggestedEntities) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo", "suggestedEntities");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (suggestedEntities != null)
    {
      paramDataProcessor = suggestedEntities.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SuggestedEntityType)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo", "suggestedEntities");
        }
      }
    }
    return new EntityAwareSuggestionInfo((List)localObject, bool);
    label262:
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
      paramObject = (EntityAwareSuggestionInfo)paramObject;
      if (suggestedEntities == null) {
        break;
      }
    } while (suggestedEntities.equals(suggestedEntities));
    for (;;)
    {
      return false;
      if (suggestedEntities == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (suggestedEntities != null) {}
    for (int i = suggestedEntities.hashCode();; i = 0)
    {
      i += 527;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<EntityAwareSuggestionInfo>
  {
    public boolean hasSuggestedEntities = false;
    public List<SuggestedEntityType> suggestedEntities = null;
    
    public final EntityAwareSuggestionInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (EntityAwareSuggestionInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (suggestedEntities != null)
      {
        paramFlavor = suggestedEntities.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((SuggestedEntityType)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo", "suggestedEntities");
              if (hasSuggestedEntities) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo", "suggestedEntities");
            }
          }
        }
      }
      return new EntityAwareSuggestionInfo(suggestedEntities, hasSuggestedEntities);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */