package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum SearchFacetType
{
  CURRENT_COMPANY,  GEO_REGION,  INDUSTRY,  NETWORK,  NONPROFIT_INTEREST,  PROFILE_LANGUAGE,  SCHOOL,  $UNKNOWN;
  
  private SearchFacetType() {}
  
  public static SearchFacetType of(int paramInt)
  {
    try
    {
      SearchFacetType localSearchFacetType = values()[paramInt];
      return localSearchFacetType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SearchFacetType of(String paramString)
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
    implements EnumBuilder<SearchFacetType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacetType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */