package com.linkedin.android.premium;

import java.util.HashMap;
import java.util.Map;

public enum PremiumServiceExceptionServiceCodes
{
  private static final Map<Integer, PremiumServiceExceptionServiceCodes> LOOKUP;
  private final int code;
  
  static
  {
    int i = 0;
    EMBARGO_COUNTRY = new PremiumServiceExceptionServiceCodes("EMBARGO_COUNTRY", 0, 0);
    NO_PRODUCTS = new PremiumServiceExceptionServiceCodes("NO_PRODUCTS", 1, 1);
    ALREADY_A_SUBSCRIBER = new PremiumServiceExceptionServiceCodes("ALREADY_A_SUBSCRIBER", 2, 2);
    MEMBER_WITHOUT_CONFIRMED_EMAIL = new PremiumServiceExceptionServiceCodes("MEMBER_WITHOUT_CONFIRMED_EMAIL", 3, 3);
    $VALUES = new PremiumServiceExceptionServiceCodes[] { EMBARGO_COUNTRY, NO_PRODUCTS, ALREADY_A_SUBSCRIBER, MEMBER_WITHOUT_CONFIRMED_EMAIL };
    LOOKUP = new HashMap();
    PremiumServiceExceptionServiceCodes[] arrayOfPremiumServiceExceptionServiceCodes = values();
    int j = arrayOfPremiumServiceExceptionServiceCodes.length;
    while (i < j)
    {
      PremiumServiceExceptionServiceCodes localPremiumServiceExceptionServiceCodes = arrayOfPremiumServiceExceptionServiceCodes[i];
      LOOKUP.put(Integer.valueOf(code), localPremiumServiceExceptionServiceCodes);
      i += 1;
    }
  }
  
  private PremiumServiceExceptionServiceCodes(int paramInt)
  {
    code = paramInt;
  }
  
  public static PremiumServiceExceptionServiceCodes fromCode(int paramInt)
  {
    return (PremiumServiceExceptionServiceCodes)LOOKUP.get(Integer.valueOf(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumServiceExceptionServiceCodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */