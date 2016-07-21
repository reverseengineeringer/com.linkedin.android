package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum GuideType
{
  FACET,  VERTICAL,  $UNKNOWN;
  
  private GuideType() {}
  
  public static GuideType of(int paramInt)
  {
    try
    {
      GuideType localGuideType = values()[paramInt];
      return localGuideType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static GuideType of(String paramString)
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
    implements EnumBuilder<GuideType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.GuideType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */