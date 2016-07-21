package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SearchFacet
  implements RecordTemplate<SearchFacet>
{
  public static final SearchFacetBuilder BUILDER = SearchFacetBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int facetPosition;
  public final SearchFacetType facetType;
  public final List<SearchFacetValue> facetValues;
  public final SearchVertical facetVertical;
  public final boolean hasFacetPosition;
  public final boolean hasFacetType;
  public final boolean hasFacetValues;
  public final boolean hasFacetVertical;
  
  SearchFacet(SearchFacetType paramSearchFacetType, SearchVertical paramSearchVertical, List<SearchFacetValue> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    facetType = paramSearchFacetType;
    facetVertical = paramSearchVertical;
    if (paramList == null) {}
    for (paramSearchFacetType = null;; paramSearchFacetType = Collections.unmodifiableList(paramList))
    {
      facetValues = paramSearchFacetType;
      facetPosition = paramInt;
      hasFacetType = paramBoolean1;
      hasFacetVertical = paramBoolean2;
      hasFacetValues = paramBoolean3;
      hasFacetPosition = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final SearchFacet accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFacetType)
    {
      paramDataProcessor.startRecordField$505cff1c("facetType");
      paramDataProcessor.processEnum(facetType);
    }
    if (hasFacetVertical)
    {
      paramDataProcessor.startRecordField$505cff1c("facetVertical");
      paramDataProcessor.processEnum(facetVertical);
    }
    Object localObject = null;
    SearchFacetValue localSearchFacetValue = null;
    boolean bool = false;
    if (hasFacetValues)
    {
      paramDataProcessor.startRecordField$505cff1c("facetValues");
      facetValues.size();
      paramDataProcessor.startArray$13462e();
      localObject = localSearchFacetValue;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = facetValues.iterator();
      if (localIterator.hasNext())
      {
        localSearchFacetValue = (SearchFacetValue)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localSearchFacetValue = localSearchFacetValue.accept(paramDataProcessor);; localSearchFacetValue = (SearchFacetValue)paramDataProcessor.processDataTemplate(localSearchFacetValue))
        {
          if ((localObject != null) && (localSearchFacetValue != null)) {
            ((List)localObject).add(localSearchFacetValue);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label301;
      }
    }
    label301:
    for (bool = true;; bool = false)
    {
      if (hasFacetPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("facetPosition");
        paramDataProcessor.processInt(facetPosition);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label448;
      }
      try
      {
        if (hasFacetType) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacet", "facetType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasFacetVertical) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacet", "facetVertical");
    }
    if (!hasFacetValues) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacet", "facetValues");
    }
    if (!hasFacetPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacet", "facetPosition");
    }
    if (facetValues != null)
    {
      paramDataProcessor = facetValues.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((SearchFacetValue)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.SearchFacet", "facetValues");
        }
      }
    }
    return new SearchFacet(facetType, facetVertical, (List)localObject, facetPosition, hasFacetType, hasFacetVertical, bool, hasFacetPosition);
    label448:
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
      paramObject = (SearchFacet)paramObject;
      if (facetType != null)
      {
        if (facetType.equals(facetType)) {}
      }
      else {
        while (facetType != null) {
          return false;
        }
      }
      if (facetVertical != null)
      {
        if (facetVertical.equals(facetVertical)) {}
      }
      else {
        while (facetVertical != null) {
          return false;
        }
      }
      if (facetValues != null)
      {
        if (facetValues.equals(facetValues)) {}
      }
      else {
        while (facetValues != null) {
          return false;
        }
      }
    } while (facetPosition == facetPosition);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (facetType != null)
    {
      i = facetType.hashCode();
      if (facetVertical == null) {
        break label97;
      }
    }
    label97:
    for (int j = facetVertical.hashCode();; j = 0)
    {
      if (facetValues != null) {
        k = facetValues.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + k) * 31 + facetPosition;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFacet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */