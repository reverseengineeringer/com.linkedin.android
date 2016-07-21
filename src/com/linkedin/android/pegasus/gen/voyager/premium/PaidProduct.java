package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.data.lite.EnumBuilder;

public enum PaidProduct
{
  ADVERTISE,  CAC,  ELEVATE,  LEARNING,  LYNDA,  RECRUITER,  REFERRALS,  SALES_NAVIGATOR,  SUBS,  $UNKNOWN;
  
  private PaidProduct() {}
  
  public static PaidProduct of(int paramInt)
  {
    try
    {
      PaidProduct localPaidProduct = values()[paramInt];
      return localPaidProduct;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static PaidProduct of(String paramString)
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
    implements EnumBuilder<PaidProduct>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PaidProduct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */