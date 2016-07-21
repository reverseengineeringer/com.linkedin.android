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

public final class SearchResultComponent
  implements RecordTemplate<SearchResultComponent>
{
  public static final SearchResultComponentBuilder BUILDER = SearchResultComponentBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasLayoutType;
  public final boolean hasPosition;
  public final boolean hasResultComponentType;
  public final boolean hasResultVerticalType;
  public final boolean hasResults;
  public final SearchResultComponentLayoutType layoutType;
  public final int position;
  public final SearchResultComponentType resultComponentType;
  public final SearchVertical resultVerticalType;
  public final List<SearchResultHit> results;
  
  SearchResultComponent(SearchResultComponentType paramSearchResultComponentType, int paramInt, SearchResultComponentLayoutType paramSearchResultComponentLayoutType, SearchVertical paramSearchVertical, List<SearchResultHit> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    resultComponentType = paramSearchResultComponentType;
    position = paramInt;
    layoutType = paramSearchResultComponentLayoutType;
    resultVerticalType = paramSearchVertical;
    if (paramList == null) {}
    for (paramSearchResultComponentType = null;; paramSearchResultComponentType = Collections.unmodifiableList(paramList))
    {
      results = paramSearchResultComponentType;
      hasResultComponentType = paramBoolean1;
      hasPosition = paramBoolean2;
      hasLayoutType = paramBoolean3;
      hasResultVerticalType = paramBoolean4;
      hasResults = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final SearchResultComponent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasResultComponentType)
    {
      paramDataProcessor.startRecordField$505cff1c("resultComponentType");
      paramDataProcessor.processEnum(resultComponentType);
    }
    if (hasPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("position");
      paramDataProcessor.processInt(position);
    }
    if (hasLayoutType)
    {
      paramDataProcessor.startRecordField$505cff1c("layoutType");
      paramDataProcessor.processEnum(layoutType);
    }
    if (hasResultVerticalType)
    {
      paramDataProcessor.startRecordField$505cff1c("resultVerticalType");
      paramDataProcessor.processEnum(resultVerticalType);
    }
    Object localObject = null;
    SearchResultHit localSearchResultHit = null;
    boolean bool = false;
    if (hasResults)
    {
      paramDataProcessor.startRecordField$505cff1c("results");
      results.size();
      paramDataProcessor.startArray$13462e();
      localObject = localSearchResultHit;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = results.iterator();
      if (localIterator.hasNext())
      {
        localSearchResultHit = (SearchResultHit)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSearchResultHit = localSearchResultHit.accept(paramDataProcessor);; localSearchResultHit = (SearchResultHit)paramDataProcessor.processDataTemplate(localSearchResultHit))
        {
          if ((localObject != null) && (localSearchResultHit != null)) {
            ((List)localObject).add(localSearchResultHit);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label326;
      }
    }
    label326:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label500;
      }
      try
      {
        if (hasResultComponentType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "resultComponentType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "position");
    }
    if (!hasLayoutType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "layoutType");
    }
    if (!hasResultVerticalType) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "resultVerticalType");
    }
    if (!hasResults) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "results");
    }
    if (results != null)
    {
      paramDataProcessor = results.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchResultHit)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "results");
        }
      }
    }
    return new SearchResultComponent(resultComponentType, position, layoutType, resultVerticalType, (List)localObject, hasResultComponentType, hasPosition, hasLayoutType, hasResultVerticalType, bool);
    label500:
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
      paramObject = (SearchResultComponent)paramObject;
      if (resultComponentType != null)
      {
        if (resultComponentType.equals(resultComponentType)) {}
      }
      else {
        while (resultComponentType != null) {
          return false;
        }
      }
      if (position != position) {
        return false;
      }
      if (layoutType != null)
      {
        if (layoutType.equals(layoutType)) {}
      }
      else {
        while (layoutType != null) {
          return false;
        }
      }
      if (resultVerticalType != null)
      {
        if (resultVerticalType.equals(resultVerticalType)) {}
      }
      else {
        while (resultVerticalType != null) {
          return false;
        }
      }
      if (results == null) {
        break;
      }
    } while (results.equals(results));
    for (;;)
    {
      return false;
      if (results == null) {
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
    int n;
    int j;
    if (resultComponentType != null)
    {
      i = resultComponentType.hashCode();
      n = position;
      if (layoutType == null) {
        break label124;
      }
      j = layoutType.hashCode();
      label51:
      if (resultVerticalType == null) {
        break label129;
      }
    }
    label124:
    label129:
    for (int k = resultVerticalType.hashCode();; k = 0)
    {
      if (results != null) {
        m = results.hashCode();
      }
      i = (k + (j + ((i + 527) * 31 + n) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label51;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<SearchResultComponent>
  {
    public boolean hasLayoutType = false;
    private boolean hasPosition = false;
    public boolean hasResultComponentType = false;
    public boolean hasResultVerticalType = false;
    public boolean hasResults = false;
    public SearchResultComponentLayoutType layoutType = null;
    private int position = 0;
    public SearchResultComponentType resultComponentType = null;
    public SearchVertical resultVerticalType = null;
    public List<SearchResultHit> results = null;
    
    public final SearchResultComponent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchResultComponent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (results != null)
      {
        paramFlavor = results.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((SearchResultHit)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "results");
              if (!hasResultComponentType) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "resultComponentType");
              }
              if (!hasPosition) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "position");
              }
              if (!hasLayoutType) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "layoutType");
              }
              if (!hasResultVerticalType) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "resultVerticalType");
              }
              if (hasResults) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent", "results");
            }
          }
        }
      }
      return new SearchResultComponent(resultComponentType, position, layoutType, resultVerticalType, results, hasResultComponentType, hasPosition, hasLayoutType, hasResultVerticalType, hasResults);
    }
    
    public final Builder setPosition(Integer paramInteger)
    {
      if (paramInteger == null)
      {
        hasPosition = false;
        position = 0;
        return this;
      }
      hasPosition = true;
      position = paramInteger.intValue();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */