package com.linkedin.android.premium;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.paymentslibrary.api.CartOffer;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts;
import com.linkedin.android.pegasus.gen.voyager.premium.onboarding.PremiumOnboardingCard;
import com.linkedin.data.lite.RecordTemplate;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public final class PremiumDataProvider
  extends DataProvider<State, DataProvider.DataProviderListener>
{
  @Inject
  public PremiumDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void fetchProductData(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    paramString3 = Routes.PREMIUM_PRODUCTS.buildUponRoot().buildUpon().appendQueryParameter("channel", paramString3);
    if (paramString4 != null) {
      paramString3.appendQueryParameter("productFamily", paramString4);
    }
    paramString3 = paramString3.build().toString();
    state).productsRoute = paramString3;
    paramString1 = newModelListener(paramString1, paramString2);
    paramString1 = Request.get().url(paramString3).customHeaders(paramMap).builder(PremiumProducts.BUILDER).listener(paramString1).trackingSessionId(paramString2).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    activityComponent.dataManager().submit(paramString1);
  }
  
  public final boolean isDataAvailable()
  {
    return ((State)state).getPremiumProducts() != null;
  }
  
  public static final class State
    extends DataProvider.State
  {
    public CartOffer cartOffer;
    public String cartRoute;
    public String onboardingRoute;
    public PremiumProducts premiumProducts;
    public String productsRoute;
    
    State(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
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
  
  private static final class SubscriptionCartInputModel
    implements RecordTemplate<SubscriptionCartInputModel>
  {
    private PremiumProductFamily productFamily;
    private final String quote;
    
    public SubscriptionCartInputModel(String paramString, PremiumProductFamily paramPremiumProductFamily)
    {
      quote = paramString;
      productFamily = paramPremiumProductFamily;
    }
    
    public final String id()
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */