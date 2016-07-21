package com.linkedin.android.premium;

import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.data.lite.RecordTemplate;

public final class PremiumDataProvider$SubscriptionCartInputModel
  implements RecordTemplate<SubscriptionCartInputModel>
{
  private PremiumProductFamily productFamily;
  private final String quote;
  
  public PremiumDataProvider$SubscriptionCartInputModel(String paramString, PremiumProductFamily paramPremiumProductFamily)
  {
    quote = paramString;
    productFamily = paramPremiumProductFamily;
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumDataProvider.SubscriptionCartInputModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */