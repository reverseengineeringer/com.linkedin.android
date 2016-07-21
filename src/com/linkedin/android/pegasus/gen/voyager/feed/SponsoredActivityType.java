package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.EnumBuilder;

public enum SponsoredActivityType
{
  SPONSORED,  VIRAL,  $UNKNOWN;
  
  private SponsoredActivityType() {}
  
  public static SponsoredActivityType of(int paramInt)
  {
    try
    {
      SponsoredActivityType localSponsoredActivityType = values()[paramInt];
      return localSponsoredActivityType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SponsoredActivityType of(String paramString)
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
    implements EnumBuilder<SponsoredActivityType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.SponsoredActivityType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */