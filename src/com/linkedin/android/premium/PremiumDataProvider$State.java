package com.linkedin.android.premium;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.paymentslibrary.api.CartOffer;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.PremiumOnboardingCard;
import java.util.List;

public final class PremiumDataProvider$State
  extends DataProvider.State
{
  public CartOffer cartOffer;
  public String cartRoute;
  public String onboardingRoute;
  public PremiumProducts premiumProducts;
  public String productsRoute;
  
  PremiumDataProvider$State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  public final List<PremiumOnboardingCard> getOnboardingCards()
  {
    CollectionTemplate localCollectionTemplate = (CollectionTemplate)getModel(onboardingRoute);
    if (localCollectionTemplate != null) {
      return elements;
    }
    return null;
  }
  
  public final Throwable getPremiumProblem()
  {
    return getError(productsRoute);
  }
  
  public final PremiumProducts getPremiumProducts()
  {
    if (premiumProducts == null) {
      premiumProducts = ((PremiumProducts)getModel(productsRoute));
    }
    return premiumProducts;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumDataProvider.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */