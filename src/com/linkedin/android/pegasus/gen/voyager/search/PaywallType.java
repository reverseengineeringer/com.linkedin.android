package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum PaywallType
{
  UPSELL_LIMIT,  UPSELL_WARNING,  $UNKNOWN;
  
  private PaywallType() {}
  
  public static PaywallType of(int paramInt)
  {
    try
    {
      PaywallType localPaywallType = values()[paramInt];
      return localPaywallType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static PaywallType of(String paramString)
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
    implements EnumBuilder<PaywallType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.PaywallType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */