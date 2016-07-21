package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum SearchType
{
  ALL,  ARTICLE,  COMPANIES,  CONTENT,  FEED_UPDATES,  GROUPS,  JOBS,  PEOPLE,  SCHOOLS,  TOP,  $UNKNOWN;
  
  private SearchType() {}
  
  public static SearchType of(int paramInt)
  {
    try
    {
      SearchType localSearchType = values()[paramInt];
      return localSearchType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SearchType of(String paramString)
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
    implements EnumBuilder<SearchType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */