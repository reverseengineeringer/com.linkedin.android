package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHeader$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchHeader.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */