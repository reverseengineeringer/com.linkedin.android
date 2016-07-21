package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.data.lite.EnumBuilder;

public enum PromoType
{
  ABI,  ABI_NUX,  ABI_WYLO,  $UNKNOWN;
  
  private PromoType() {}
  
  public static PromoType of(int paramInt)
  {
    try
    {
      PromoType localPromoType = values()[paramInt];
      return localPromoType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static PromoType of(String paramString)
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
    implements EnumBuilder<PromoType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PromoType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */