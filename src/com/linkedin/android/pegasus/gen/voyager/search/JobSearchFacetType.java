package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum JobSearchFacetType
{
  COMPANY,  EXPERIENCE,  FUNCTION,  GEO_CITY,  INDUSTRY,  JOB_TYPE,  LOCATION,  SALARY_BUCKET,  TIME_POSTED,  TITLE,  $UNKNOWN;
  
  private JobSearchFacetType() {}
  
  public static JobSearchFacetType of(int paramInt)
  {
    try
    {
      JobSearchFacetType localJobSearchFacetType = values()[paramInt];
      return localJobSearchFacetType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static JobSearchFacetType of(String paramString)
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
    implements EnumBuilder<JobSearchFacetType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.JobSearchFacetType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */