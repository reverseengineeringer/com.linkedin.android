package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchFilter
  implements RecordTemplate<SearchFilter>
{
  public static final SearchFilterBuilder BUILDER = SearchFilterBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String filterName;
  public final int filterPosition;
  public final SearchFilterType filterType;
  public final String filterValue;
  public final boolean hasFilterName;
  public final boolean hasFilterPosition;
  public final boolean hasFilterType;
  public final boolean hasFilterValue;
  public final boolean hasIsSelected;
  public final boolean isSelected;
  
  SearchFilter(SearchFilterType paramSearchFilterType, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    filterType = paramSearchFilterType;
    filterName = paramString1;
    filterValue = paramString2;
    filterPosition = paramInt;
    isSelected = paramBoolean1;
    hasFilterType = paramBoolean2;
    hasFilterName = paramBoolean3;
    hasFilterValue = paramBoolean4;
    hasFilterPosition = paramBoolean5;
    hasIsSelected = paramBoolean6;
    _cachedId = null;
  }
  
  public final SearchFilter accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFilterType)
    {
      paramDataProcessor.startRecordField$505cff1c("filterType");
      paramDataProcessor.processEnum(filterType);
    }
    if (hasFilterName)
    {
      paramDataProcessor.startRecordField$505cff1c("filterName");
      paramDataProcessor.processString(filterName);
    }
    if (hasFilterValue)
    {
      paramDataProcessor.startRecordField$505cff1c("filterValue");
      paramDataProcessor.processString(filterValue);
    }
    if (hasFilterPosition)
    {
      paramDataProcessor.startRecordField$505cff1c("filterPosition");
      paramDataProcessor.processInt(filterPosition);
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
        if (!hasFilterType) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterType");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasFilterName) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterName");
      }
      if (!hasFilterValue) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterValue");
      }
      if (!hasFilterPosition) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterPosition");
      }
      if (!hasIsSelected) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "isSelected");
      }
      return new SearchFilter(filterType, filterName, filterValue, filterPosition, isSelected, hasFilterType, hasFilterName, hasFilterValue, hasFilterPosition, hasIsSelected);
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
      paramObject = (SearchFilter)paramObject;
      if (filterType != null)
      {
        if (filterType.equals(filterType)) {}
      }
      else {
        while (filterType != null) {
          return false;
        }
      }
      if (filterName != null)
      {
        if (filterName.equals(filterName)) {}
      }
      else {
        while (filterName != null) {
          return false;
        }
      }
      if (filterValue != null)
      {
        if (filterValue.equals(filterValue)) {}
      }
      else {
        while (filterValue != null) {
          return false;
        }
      }
      if (filterPosition != filterPosition) {
        return false;
      }
    } while (isSelected == isSelected);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (filterType != null)
    {
      i = filterType.hashCode();
      if (filterName == null) {
        break label116;
      }
      j = filterName.hashCode();
      label45:
      if (filterValue == null) {
        break label121;
      }
    }
    label116:
    label121:
    for (int k = filterValue.hashCode();; k = 0)
    {
      int n = filterPosition;
      if (isSelected) {
        m = 1;
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + n) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<SearchFilter>
  {
    public String filterName = null;
    public int filterPosition = 0;
    public SearchFilterType filterType = null;
    public String filterValue = null;
    public boolean hasFilterName = false;
    public boolean hasFilterPosition = false;
    public boolean hasFilterType = false;
    public boolean hasFilterValue = false;
    public boolean hasIsSelected = false;
    public boolean isSelected = false;
    
    public final SearchFilter build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchFilter.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchFilter(filterType, filterName, filterValue, filterPosition, isSelected, hasFilterType, hasFilterName, hasFilterValue, hasFilterPosition, hasIsSelected);
        if (!hasFilterType) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterType");
        }
        if (!hasFilterName) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterName");
        }
        if (!hasFilterValue) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterValue");
        }
        if (!hasFilterPosition) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "filterPosition");
        }
      } while (hasIsSelected);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchFilter", "isSelected");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */