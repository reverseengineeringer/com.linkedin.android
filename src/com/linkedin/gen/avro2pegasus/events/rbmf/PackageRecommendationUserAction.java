package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.EnumBuilder;

public enum PackageRecommendationUserAction
{
  FOLLOW,  UNFOLLOW,  $UNKNOWN;
  
  private PackageRecommendationUserAction() {}
  
  public static PackageRecommendationUserAction of(String paramString)
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
    implements EnumBuilder<PackageRecommendationUserAction>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationUserAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */