package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum PeopleSearchFacetType
{
  CURRENT_COMPANY,  GEO_REGION,  INDUSTRY,  NETWORK,  NONPROFIT_INTEREST,  PROFILE_LANGUAGE,  SCHOOL,  $UNKNOWN;
  
  private PeopleSearchFacetType() {}
  
  public static PeopleSearchFacetType of(int paramInt)
  {
    try
    {
      PeopleSearchFacetType localPeopleSearchFacetType = values()[paramInt];
      return localPeopleSearchFacetType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static PeopleSearchFacetType of(String paramString)
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
    implements EnumBuilder<PeopleSearchFacetType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.PeopleSearchFacetType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */