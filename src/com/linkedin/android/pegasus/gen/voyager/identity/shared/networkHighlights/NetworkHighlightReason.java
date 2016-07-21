package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

import com.linkedin.data.lite.EnumBuilder;

public enum NetworkHighlightReason
{
  VIEWEE_ASSOCIATED_PRIMARY_ENTITY,  VIEWER_ASSOCIATED_PRIMARY_ENTITY,  VIEWER_FOLLOWING_PRIMARY_ENTITY,  $UNKNOWN;
  
  private NetworkHighlightReason() {}
  
  public static NetworkHighlightReason of(int paramInt)
  {
    try
    {
      NetworkHighlightReason localNetworkHighlightReason = values()[paramInt];
      return localNetworkHighlightReason;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static NetworkHighlightReason of(String paramString)
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
    implements EnumBuilder<NetworkHighlightReason>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlightReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */