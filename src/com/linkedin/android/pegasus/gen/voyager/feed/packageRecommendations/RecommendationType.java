package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.data.lite.EnumBuilder;

public enum RecommendationType
{
  FOLLOW,  UNFOLLOW,  $UNKNOWN;
  
  private RecommendationType() {}
  
  public static RecommendationType of(int paramInt)
  {
    try
    {
      RecommendationType localRecommendationType = values()[paramInt];
      return localRecommendationType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static RecommendationType of(String paramString)
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
    implements EnumBuilder<RecommendationType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */