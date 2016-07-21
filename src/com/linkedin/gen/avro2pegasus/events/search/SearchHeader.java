package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHeader
  implements RecordTemplate<SearchHeader>
{
  public static final SearchHeaderBuilder BUILDER = SearchHeaderBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasOrigin;
  public final boolean hasPlatform;
  public final boolean hasQuery;
  public final boolean hasRawSearchId;
  public final boolean hasVertical;
  public final SearchResultPageOrigin origin;
  public final SearchPlatformType platform;
  public final String query;
  public final String rawSearchId;
  public final SearchVertical vertical;
  
  SearchHeader(String paramString1, String paramString2, SearchResultPageOrigin paramSearchResultPageOrigin, SearchPlatformType paramSearchPlatformType, SearchVertical paramSearchVertical, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    rawSearchId = paramString1;
    query = paramString2;
    origin = paramSearchResultPageOrigin;
    platform = paramSearchPlatformType;
    vertical = paramSearchVertical;
    hasRawSearchId = paramBoolean1;
    hasQuery = paramBoolean2;
    hasOrigin = paramBoolean3;
    hasPlatform = paramBoolean4;
    hasVertical = paramBoolean5;
    _cachedId = null;
  }
  
  public final SearchHeader accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRawSearchId)
    {
      paramDataProcessor.startRecordField$505cff1c("rawSearchId");
      paramDataProcessor.processString(rawSearchId);
    }
    if (hasQuery)
    {
      paramDataProcessor.startRecordField$505cff1c("query");
      paramDataProcessor.processString(query);
    }
    if (hasOrigin)
    {
      paramDataProcessor.startRecordField$505cff1c("origin");
      paramDataProcessor.processEnum(origin);
    }
    if (hasPlatform)
    {
      paramDataProcessor.startRecordField$505cff1c("platform");
      paramDataProcessor.processEnum(platform);
    }
    if (hasVertical)
    {
      paramDataProcessor.startRecordField$505cff1c("vertical");
      paramDataProcessor.processEnum(vertical);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasRawSearchId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchHeader", "rawSearchId");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasPlatform) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchHeader", "platform");
      }
      return new SearchHeader(rawSearchId, query, origin, platform, vertical, hasRawSearchId, hasQuery, hasOrigin, hasPlatform, hasVertical);
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
      paramObject = (SearchHeader)paramObject;
      if (rawSearchId != null)
      {
        if (rawSearchId.equals(rawSearchId)) {}
      }
      else {
        while (rawSearchId != null) {
          return false;
        }
      }
      if (query != null)
      {
        if (query.equals(query)) {}
      }
      else {
        while (query != null) {
          return false;
        }
      }
      if (origin != null)
      {
        if (origin.equals(origin)) {}
      }
      else {
        while (origin != null) {
          return false;
        }
      }
      if (platform != null)
      {
        if (platform.equals(platform)) {}
      }
      else {
        while (platform != null) {
          return false;
        }
      }
      if (vertical == null) {
        break;
      }
    } while (vertical.equals(vertical));
    for (;;)
    {
      return false;
      if (vertical == null) {
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
    int k;
    if (rawSearchId != null)
    {
      i = rawSearchId.hashCode();
      if (query == null) {
        break label132;
      }
      j = query.hashCode();
      if (origin == null) {
        break label137;
      }
      k = origin.hashCode();
      label60:
      if (platform == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = platform.hashCode();; m = 0)
    {
      if (vertical != null) {
        n = vertical.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<SearchHeader>
  {
    public boolean hasOrigin = false;
    private boolean hasPlatform = false;
    private boolean hasQuery = false;
    private boolean hasRawSearchId = false;
    public boolean hasVertical = false;
    public SearchResultPageOrigin origin = null;
    private SearchPlatformType platform = null;
    private String query = null;
    private String rawSearchId = null;
    public SearchVertical vertical = null;
    
    public final SearchHeader build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (SearchHeader.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new SearchHeader(rawSearchId, query, origin, platform, vertical, hasRawSearchId, hasQuery, hasOrigin, hasPlatform, hasVertical);
        if (!hasRawSearchId) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchHeader", "rawSearchId");
        }
      } while (hasPlatform);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SearchHeader", "platform");
    }
    
    public final Builder setPlatform(SearchPlatformType paramSearchPlatformType)
    {
      if (paramSearchPlatformType == null)
      {
        hasPlatform = false;
        platform = null;
        return this;
      }
      hasPlatform = true;
      platform = paramSearchPlatformType;
      return this;
    }
    
    public final Builder setQuery(String paramString)
    {
      if (paramString == null)
      {
        hasQuery = false;
        query = null;
        return this;
      }
      hasQuery = true;
      query = paramString;
      return this;
    }
    
    public final Builder setRawSearchId(String paramString)
    {
      if (paramString == null)
      {
        hasRawSearchId = false;
        rawSearchId = null;
        return this;
      }
      hasRawSearchId = true;
      rawSearchId = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */