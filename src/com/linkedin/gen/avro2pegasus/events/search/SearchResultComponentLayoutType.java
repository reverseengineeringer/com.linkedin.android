package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.EnumBuilder;

public enum SearchResultComponentLayoutType
{
  HORIZONTAL,  VERTICAL,  $UNKNOWN;
  
  private SearchResultComponentLayoutType() {}
  
  public static SearchResultComponentLayoutType of(String paramString)
  {
    try
    {
      paramString = valueOf(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return $UNKNOWN;
  }
  
  public static final class Builder
    implements EnumBuilder<SearchResultComponentLayoutType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SearchResultComponentLayoutType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */