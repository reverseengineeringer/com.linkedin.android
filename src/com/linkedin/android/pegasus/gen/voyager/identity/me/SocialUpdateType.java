package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.data.lite.EnumBuilder;

public enum SocialUpdateType
{
  POST,  SHARE,  $UNKNOWN;
  
  private SocialUpdateType() {}
  
  public static SocialUpdateType of(int paramInt)
  {
    try
    {
      SocialUpdateType localSocialUpdateType = values()[paramInt];
      return localSocialUpdateType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static SocialUpdateType of(String paramString)
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
    implements EnumBuilder<SocialUpdateType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */