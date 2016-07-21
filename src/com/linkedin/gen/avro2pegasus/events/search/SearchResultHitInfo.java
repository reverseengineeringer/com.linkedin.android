package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchResultHitInfo
  implements RecordTemplate<SearchResultHitInfo>
{
  public static final SearchResultHitInfoBuilder BUILDER = SearchResultHitInfoBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final EntityAwareSuggestionInfo entityAwareSuggestionInfo;
  public final boolean hasEntityAwareSuggestionInfo;
  public final boolean hasSecondarySearchResultInfo;
  public final SecondarySearchResultInfo secondarySearchResultInfo;
  
  SearchResultHitInfo(SecondarySearchResultInfo paramSecondarySearchResultInfo, EntityAwareSuggestionInfo paramEntityAwareSuggestionInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    secondarySearchResultInfo = paramSecondarySearchResultInfo;
    entityAwareSuggestionInfo = paramEntityAwareSuggestionInfo;
    hasSecondarySearchResultInfo = paramBoolean1;
    hasEntityAwareSuggestionInfo = paramBoolean2;
    _cachedId = null;
  }
  
  public final SearchResultHitInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasSecondarySearchResultInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("secondarySearchResultInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = secondarySearchResultInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label149;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasEntityAwareSuggestionInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("entityAwareSuggestionInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = entityAwareSuggestionInfo.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new SearchResultHitInfo((SecondarySearchResultInfo)localObject2, (EntityAwareSuggestionInfo)localObject1, bool1, bool2);
      localObject1 = (SecondarySearchResultInfo)paramDataProcessor.processDataTemplate(secondarySearchResultInfo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (EntityAwareSuggestionInfo)paramDataProcessor.processDataTemplate(entityAwareSuggestionInfo);
      break label95;
    }
    label181:
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
      paramObject = (SearchResultHitInfo)paramObject;
      if (secondarySearchResultInfo != null)
      {
        if (secondarySearchResultInfo.equals(secondarySearchResultInfo)) {}
      }
      else {
        while (secondarySearchResultInfo != null) {
          return false;
        }
      }
      if (entityAwareSuggestionInfo == null) {
        break;
      }
    } while (entityAwareSuggestionInfo.equals(entityAwareSuggestionInfo));
    for (;;)
    {
      return false;
      if (entityAwareSuggestionInfo == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (secondarySearchResultInfo != null) {}
    for (int i = secondarySearchResultInfo.hashCode();; i = 0)
    {
      if (entityAwareSuggestionInfo != null) {
        j = entityAwareSuggestionInfo.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<SearchResultHitInfo>
  {
    public EntityAwareSuggestionInfo entityAwareSuggestionInfo = null;
    public boolean hasEntityAwareSuggestionInfo = false;
    public boolean hasSecondarySearchResultInfo = false;
    public SecondarySearchResultInfo secondarySearchResultInfo = null;
    
    public final SearchResultHitInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      int[] arrayOfInt = SearchResultHitInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
      paramFlavor.ordinal();
      return new SearchResultHitInfo(secondarySearchResultInfo, entityAwareSuggestionInfo, hasSecondarySearchResultInfo, hasEntityAwareSuggestionInfo);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultHitInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */