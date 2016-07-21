package com.linkedin.android.premium.checkout;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.ExceptionUtils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.paymentslibrary.api.Callbacks;
import com.linkedin.android.paymentslibrary.api.CartHandle;
import com.linkedin.android.paymentslibrary.api.CartOffer;
import com.linkedin.android.paymentslibrary.api.PaymentService;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.android.pegasus.gen.voyager.premium.SubscriptionCart;
import com.linkedin.android.premium.PremiumActivity;
import com.linkedin.android.premium.PremiumChooserPageInstance;
import com.linkedin.android.premium.PremiumDataProvider;
import com.linkedin.android.premium.PremiumDataProvider.State;
import com.linkedin.android.premium.PremiumDataProvider.SubscriptionCartInputModel;
import com.linkedin.android.premium.PremiumErrorHandler;
import com.linkedin.android.premium.PremiumTracking;
import com.linkedin.android.premium.onboarding.PremiumOnboardingBundleBuilder;
import com.linkedin.android.premium.onboarding.PremiumOnboardingFragment;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class CheckoutFragment
  extends BaseCheckoutFragment
  implements OnBackPressedListener, PurchaseCompleteListener
{
  private static final String PREMIUM_ONBOARDING_TAG = PremiumOnboardingFragment.class.getName();
  private static final String TAG = CheckoutFragment.class.getSimpleName();
  private Handler handler;
  private final AtomicBoolean inTaxReview = new AtomicBoolean(false);
  private boolean isViewStateRestored;
  @Inject
  KeyboardUtil keyboardUtil;
  @Inject
  PaymentService paymentService;
  private CheckoutViewHolder viewHolder;
  private CheckoutViewModel viewModel;
  
  private void bindUI(CartOffer paramCartOffer, LayoutInflater paramLayoutInflater)
  {
    if (viewHolder == null) {
      return;
    }
    viewHolder.mainView.setVisibility(0);
    viewHolder.splash.setVisibility(8);
    Object localObject1 = tracker;
    Object localObject2 = paymentService;
    Handler localHandler = handler;
    Context localContext = getContext();
    CheckoutViewModel localCheckoutViewModel = new CheckoutViewModel((PaymentService)localObject2, paramCartOffer, getProductName());
    actionListener = new CheckoutTransformer.1(localCheckoutViewModel, (Tracker)localObject1, (PaymentService)localObject2, paramCartOffer, localHandler, localContext, this);
    viewModel = localCheckoutViewModel;
    viewModel.inTaxReview = inTaxReview;
    localObject1 = viewModel;
    boolean bool;
    if ((!paramCartOffer.isFreeTrial()) && ("control".equals(fragmentComponent.lixManager().getTreatment(Lix.PREMIUM_VAT_PRICE))))
    {
      bool = true;
      postalCodeAndVatNumberAffectTax = bool;
      viewModel.viewModelListener = new CheckoutFragment.2(this);
      localObject1 = viewModel;
      applicationComponent.mediaCenter();
      ((CheckoutViewModel)localObject1).onBindViewHolder$4d6d7010(paramLayoutInflater, viewHolder);
      if (isViewStateRestored) {
        viewModel.onViewStateRestored(fragmentComponent, viewHolder);
      }
      viewHolder.subscriptionDetails.setOnClickListener(new CheckoutFragment.3(this, tracker, "details", new TrackingEventBuilder[0]));
      viewHolder.closeButton.setOnClickListener(new CheckoutFragment.4(this, tracker, "back", new TrackingEventBuilder[0]));
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null) {
        break label346;
      }
      paramLayoutInflater = null;
      label290:
      localObject1 = getArguments();
      if (localObject1 != null) {
        break label356;
      }
    }
    label346:
    label356:
    for (localObject1 = null;; localObject1 = ((Bundle)localObject1).getString("priceId"))
    {
      localObject2 = CheckoutBundleBuilder.getChooserPageInstance(getArguments());
      long l = paramCartOffer.getCartHandle().getCartId();
      PremiumTracking.fireCheckoutImpressionEvent(tracker, paramLayoutInflater, (String)localObject1, (PremiumChooserPageInstance)localObject2, l);
      return;
      bool = false;
      break;
      paramLayoutInflater = paramLayoutInflater.getString("productId");
      break label290;
    }
  }
  
  private void navigateBack()
  {
    if (isAdded()) {
      getActivity().onBackPressed();
    }
  }
  
  static CheckoutFragment newInstance(CheckoutBundleBuilder paramCheckoutBundleBuilder)
  {
    CheckoutFragment localCheckoutFragment = new CheckoutFragment();
    localCheckoutFragment.setArguments(paramCheckoutBundleBuilder.build());
    return localCheckoutFragment;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean onBackPressed()
  {
    if (viewHolder != null) {
      KeyboardUtil.hideKeyboard(viewHolder.layout);
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    handler = new Handler();
    if (paramBundle != null) {
      inTaxReview.set(paramBundle.getBoolean("inTaxReview", false));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(CheckoutViewHolder.CREATOR.getLayoutId(), paramViewGroup, false);
    viewHolder = ((CheckoutViewHolder)CheckoutViewHolder.CREATOR.createViewHolder(paramViewGroup));
    paramViewGroup = getCartOffer();
    if (paramViewGroup != null)
    {
      bindUI(paramViewGroup, paramLayoutInflater);
      return viewHolder.layout;
    }
    viewHolder.splash.setVisibility(0);
    viewHolder.mainView.setVisibility(8);
    paramViewGroup = getDataProvider();
    Object localObject = busSubscriberId;
    paramBundle = getRumSessionId();
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = paramLayoutInflater.getString("quote"))
    {
      PremiumProductFamily localPremiumProductFamily = CheckoutBundleBuilder.getProductFamily(getArguments());
      Map localMap = Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance());
      String str = Routes.SUBSCRIPTION_CART.buildUponRoot().buildUpon().appendQueryParameter("action", "submitQuote").build().toString();
      state).cartRoute = str;
      localObject = paramViewGroup.newModelListener((String)localObject, paramBundle);
      paramLayoutInflater = Request.post().url(str).customHeaders(localMap).model(new PremiumDataProvider.SubscriptionCartInputModel(paramLayoutInflater, localPremiumProductFamily)).builder(new ActionResponseBuilder(SubscriptionCart.BUILDER)).listener((RecordTemplateListener)localObject).trackingSessionId(paramBundle).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      activityComponent.dataManager().submit(paramLayoutInflater);
      break;
    }
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    Log.e(TAG, paramDataManagerException);
    FragmentActivity localFragmentActivity = getActivity();
    Object localObject = null;
    paramType = (DataStore.Type)localObject;
    if (paramSet != null)
    {
      paramType = (DataStore.Type)localObject;
      if (paramSet.size() == 1) {
        paramType = (String)paramSet.iterator().next();
      }
    }
    if (paramType == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Unknown routes : " + paramSet.toArray()));
      return;
    }
    if ((paramType != null) && (paramType.equals(getDataProviderstate).onboardingRoute)))
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramDataManagerException));
      ((PremiumActivity)localFragmentActivity).finishOnboarding();
      return;
    }
    paramType = ExceptionUtils.getUserVisibleException(paramDataManagerException);
    if ((paramType != null) && (paramType.getLocalizedMessage() != null)) {
      PremiumErrorHandler.showError(localFragmentActivity, paramType.getLocalizedMessage());
    }
    for (;;)
    {
      navigateBack();
      return;
      PremiumErrorHandler.showError(localFragmentActivity, 2131230817);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    FragmentActivity localFragmentActivity = getActivity();
    paramMap = null;
    paramType = paramMap;
    if (paramSet != null)
    {
      paramType = paramMap;
      if (paramSet.size() == 1) {
        paramType = (String)paramSet.iterator().next();
      }
    }
    if (paramType == null) {
      Util.safeThrow$7a8b4789(new RuntimeException("Unknown routes : " + paramSet.toArray()));
    }
    do
    {
      return;
      if (!isAdded())
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Fragment is not attached to an activity"));
        return;
      }
    } while (!paramType.equals(getDataProviderstate).cartRoute));
    paramType = (PremiumDataProvider.State)getDataProviderstate;
    paramType = (ActionResponse)paramType.getModel(cartRoute);
    if (paramType != null) {}
    for (paramType = (SubscriptionCart)value; paramType == null; paramType = null)
    {
      PremiumErrorHandler.showError(localFragmentActivity, 2131230817);
      navigateBack();
      return;
    }
    paymentService.fetchCart(cartId, Callbacks.viaHandler(handler, new CheckoutFragment.1(this)));
  }
  
  public void onDestroyView()
  {
    isViewStateRestored = false;
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("inTaxReview", inTaxReview.get());
  }
  
  public final void onSuccessfulPurchase()
  {
    Object localObject1 = fragmentComponent.memberUtil();
    overrideIsPremium = true;
    ((MemberUtil)localObject1).loadMe();
    if (viewHolder != null)
    {
      KeyboardUtil.hideKeyboard(viewHolder.layout);
      viewHolder.splash.setVisibility(8);
    }
    if (!isAdded()) {
      Toast.makeText(fragmentComponent.app().getBaseContext(), 2131233044, 1).show();
    }
    do
    {
      return;
      if ("control".equals(fragmentComponent.lixManager().getTreatment(Lix.PREMIUM_SHOW_ONBOARDING)))
      {
        ((PremiumActivity)getActivity()).finishOnboarding();
        return;
      }
      localObject1 = (BaseActivity)getActivity();
    } while ((!isAdded()) || (localObject1 == null) || (!((BaseActivity)localObject1).isSafeToExecuteTransaction()));
    localObject1 = new PremiumOnboardingBundleBuilder();
    Object localObject2 = getCartOffer();
    if (localObject2 != null)
    {
      long l = ((CartOffer)localObject2).getCartHandle().getCartId();
      bundle.putLong("orderId", l);
    }
    localObject2 = ((PremiumOnboardingBundleBuilder)localObject1).setProductFamily(CheckoutBundleBuilder.getProductFamily(getArguments()));
    PremiumChooserPageInstance localPremiumChooserPageInstance = CheckoutBundleBuilder.getChooserPageInstance(getArguments());
    bundle.putParcelable("chooserPageInstance", localPremiumChooserPageInstance);
    localObject1 = PremiumOnboardingFragment.newInstance((PremiumOnboardingBundleBuilder)localObject1);
    getFragmentManager().beginTransaction().replace(2131756509, (Fragment)localObject1, PREMIUM_ONBOARDING_TAG).commit();
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    isViewStateRestored = true;
    if (viewModel != null) {
      viewModel.onViewStateRestored(fragmentComponent, viewHolder);
    }
  }
  
  public final String pageKey()
  {
    return "premium_checkout";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.checkout.CheckoutFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */