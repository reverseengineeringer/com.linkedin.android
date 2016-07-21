package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;

public final class SearchFacetValue
  implements RecordTemplate<SearchFacetValue>
{
  public static final SearchFacetValueBuilder BUILDER = SearchFacetValueBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String facetValue;
  public final int facetValuePosition;
  public final boolean hasFacetValue;
  public final boolean hasFacetValuePosition;
  public final boolean hasIsSelected;
  public final boolean isSelected;
  
  SearchFacetValue(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    facetValue = paramString;
    facetValuePosition = paramInt;
    isSelected = paramBoolean1;
    hasFacetValue = paramBoolean2;
    hasFacetValuePosition = paramBoolean3;
    hasIsSelected = paramBoolean4;
    _cachedId = null;
  }
  
  public final SearchFacetValue accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFacetValue)
    {
      paramDataProcessor.startRecordField$505cff1c("facetValue");
      paramDataProcessor.processString(facetValue);
    }
    if (hasFacetValuePosition)
    {
      paramDataProcessor.startRecordField$505cff1c("facetValuePosition");
      paramDataProcessor.processInt(facetValuePosition);
    }
    if (hasIsSelected)
    {
      paramDataProcessor.startRecordField$505cff1c("isSelected");
      paramDataProcessor.processBoolean(isSelected);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasFacetValue) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue", "facetValue");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasFacetValuePosition) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue", "facetValuePosition");
      }
      if (!hasIsSelected) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue", "isSelected");
      }
      return new SearchFacetValue(facetValue, facetValuePosition, isSelected, hasFacetValue, hasFacetValuePosition, hasIsSelected);
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
      paramObject = (SearchFacetValue)paramObject;
      if (facetValue != null)
      {
        if (facetValue.equals(facetValue)) {}
      }
      else {
        while (facetValue != null) {
          return false;
        }
      }
      if (facetValuePosition != facetValuePosition) {
        return false;
      }
    } while (isSelected == isSelected);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (facetValue != null) {}
    for (int i = facetValue.hashCode();; i = 0)
    {
      int k = facetValuePosition;
      if (isSelected) {
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFacetValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */