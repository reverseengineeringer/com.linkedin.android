package com.linkedin.android.premium;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment.EnterTooEarlyException;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.settings.ui.PhoneOnlyUserDialogManager;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.ExceptionUtils;
import com.linkedin.android.infra.shared.KitKatUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.VoyagerUserVisibleException;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProduct;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProductFamily;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumProducts;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class SubscriptionChooserFragment
  extends PageFragment
{
  private static final String TAG = SubscriptionChooserFragment.class.getSimpleName();
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131755319)
  ViewStub errorViewStub;
  private Bundle extras;
  View.OnClickListener finish;
  private boolean firedPageImpression;
  private boolean isDataDisplayed;
  private boolean isLarge;
  float large;
  private final ValueAnimator largeAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  View.OnClickListener largeToSmallClickListener;
  private SubscriptionChooserPagerAdapter pagerAdapter;
  @Inject
  PhoneOnlyUserDialogManager phoneOnlyUserDialogManager;
  View.OnClickListener smallToLargeClickListener;
  SubscriptionChooserViewHolder ui;
  private SubscriptionChooserViewModel viewModel;
  
  private void bindDataToUi(PremiumProducts paramPremiumProducts)
  {
    Object localObject2 = null;
    Object localObject1 = pagerAdapter;
    int i = products.size();
    if (count != i)
    {
      count = i;
      hidSomeData = false;
      ((SubscriptionChooserPagerAdapter)localObject1).notifyDataSetChanged();
    }
    SubscriptionChooserPalette localSubscriptionChooserPalette = SubscriptionChooserPalette.getPalette(fragmentComponent.lixManager(), getResources());
    boolean bool;
    SubscriptionChooserViewModel localSubscriptionChooserViewModel;
    if (large == 1.0F)
    {
      bool = true;
      localSubscriptionChooserViewModel = new SubscriptionChooserViewModel();
      if (paramPremiumProducts != null)
      {
        displayedProductIndex = recommendedProductIndex;
        if (header == null) {
          break label293;
        }
      }
    }
    label293:
    for (localObject1 = new PremiumModel.ColoredText(header, Integer.valueOf(headerTextColor));; localObject1 = null)
    {
      header = ((PremiumModel.ColoredText)localObject1);
      localObject1 = localObject2;
      if (footer != null) {
        localObject1 = new PremiumModel.ColoredText(footer, Integer.valueOf(footerTextColor));
      }
      footer = ((PremiumModel.ColoredText)localObject1);
      headerIsDark = headerIsDark;
      invertPageIndicatorColor = invertPageIndicatorColor;
      isLarge = Boolean.valueOf(bool).booleanValue();
      viewModel = localSubscriptionChooserViewModel;
      viewModel.onBindViewHolder$4879abf(getActivity().getLayoutInflater(), ui);
      paramPremiumProducts = new SubscriptionChooserFragment.PageChangeListener(this, (byte)0);
      ui.pager.addOnPageChangeListener(paramPremiumProducts);
      paramPremiumProducts.onPageSelected(ui.pager.getCurrentItem());
      if (getResourcesgetConfigurationorientation == 2)
      {
        setLarge(1.0F);
        isLarge = true;
      }
      return;
      bool = false;
      break;
    }
  }
  
  private void finishActivity()
  {
    PremiumUtils.navigateUp((BaseActivity)getActivity());
  }
  
  private void fireEvents(String paramString1, ControlType paramControlType, InteractionType paramInteractionType, String paramString2)
  {
    if (paramString1 != null) {
      new ControlInteractionEvent(tracker, paramString1, paramControlType, paramInteractionType).send();
    }
    new PageViewEvent(tracker, paramString2, false).send();
  }
  
  private void fireFullPage(String paramString, ControlType paramControlType, InteractionType paramInteractionType)
  {
    fireEvents(paramString, paramControlType, paramInteractionType, "premium_chooser_full");
    firedPageImpression = true;
  }
  
  private void fireMiniPage(String paramString, ControlType paramControlType, InteractionType paramInteractionType)
  {
    fireEvents(paramString, paramControlType, paramInteractionType, "premium_chooser_mini");
    firedPageImpression = true;
  }
  
  private int getDividerColor(int paramInt)
  {
    SubscriptionChooserPalette localSubscriptionChooserPalette = SubscriptionChooserPalette.getPalette(fragmentComponent.lixManager(), getResources());
    SubscriptionChooserPalette.ProductTheme localProductTheme = localSubscriptionChooserPalette.getProductTheme(getPremiumproducts.get(paramInt)).productFamily);
    if (productHeaderIsDark) {
      return headerBackground.colors[0];
    }
    return headerDivider.colors[0];
  }
  
  private void handleError(Throwable paramThrowable)
  {
    Log.e(TAG, paramThrowable);
    if ((paramThrowable instanceof DataManagerException))
    {
      localObject1 = ExceptionUtils.getUserVisibleException((DataManagerException)paramThrowable);
      if (localObject1 != null)
      {
        paramThrowable = PremiumServiceExceptionServiceCodes.fromCode(serviceErrorCode);
        if (paramThrowable == PremiumServiceExceptionServiceCodes.MEMBER_WITHOUT_CONFIRMED_EMAIL)
        {
          KitKatUtils.pauseOrCancel(ui.splashLogo.stripeAnimator);
          phoneOnlyUserDialogManager.showDialog(new SubscriptionChooserFragment.6(this));
        }
      }
    }
    do
    {
      return;
      localObject1 = ((VoyagerUserVisibleException)localObject1).getLocalizedMessage();
      PremiumErrorHandler.showError(getContext(), (String)localObject1);
      if (paramThrowable == PremiumServiceExceptionServiceCodes.EMBARGO_COUNTRY) {
        new ControlInteractionEvent(tracker, "embargo", ControlType.LINK, InteractionType.SHORT_PRESS).send();
      }
      finishActivity();
      return;
      ui.hideSplashPage();
      localObject1 = getActivity();
    } while (localObject1 == null);
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    Object localObject2 = new SubscriptionChooserFragment.7(this, fragmentComponent.tracker(), "try_again");
    paramThrowable = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.setupDefaultErrorConfiguration((Context)localObject1, (TrackingClosure)localObject2);
    localObject2 = errorPageViewModel;
    Object localObject1 = ((Activity)localObject1).getLayoutInflater();
    applicationComponent.mediaCenter();
    ((ErrorPageViewModel)localObject2).onBindViewHolderWithErrorTracking$18b8048((LayoutInflater)localObject1, paramThrowable, tracker, getPageInstance());
  }
  
  static SubscriptionChooserFragment newInstance()
  {
    return new SubscriptionChooserFragment();
  }
  
  private void setLarge(float paramFloat)
  {
    large = paramFloat;
    if (ui == null) {}
    Object localObject1;
    label353:
    label426:
    do
    {
      return;
      localObject1 = pagerAdapter;
      int i = 0;
      Object localObject2;
      while (i < ((SubscriptionChooserPagerAdapter)localObject1).getCount())
      {
        localObject2 = (SubscriptionChooserPageFragment)((SubscriptionChooserPagerAdapter)localObject1).getItemAtPosition(i);
        if (localObject2 != null) {
          ((SubscriptionChooserPageFragment)localObject2).setLarge(paramFloat);
        }
        i += 1;
      }
      localObject1 = ui.headerText;
      i = ui.headerText.getCurrentTextColor();
      ((TextView)localObject1).setTextColor(Color.argb(Math.round((1.0F - paramFloat) * 255.0F), Color.red(i), Color.green(i), Color.blue(i)));
      ui.divider.setAlpha(paramFloat);
      ui.largeGuideline.setAlpha(0.8F * paramFloat);
      ui.footer.setAlpha(1.0F - paramFloat);
      ui.pageIndicator.setAlpha(1.0F - paramFloat);
      if (paramFloat < 1.0F) {
        if (viewModel != null)
        {
          if (!viewModel.headerIsDark) {
            break label353;
          }
          ui.toolbar.setVisibility(0);
          ui.lightToolbar.setVisibility(8);
        }
      }
      for (;;)
      {
        localObject1 = pagerAdapter.primaryPage;
        if ((localObject1 == null) || (ui == null)) {
          break;
        }
        localObject2 = PremiumUtils.getBoundsInView(ui.largeButtonBackground, getView());
        ui.divider.setY(top);
        localObject2 = new RelativeLayout.LayoutParams(-1, (int)(bottom - top));
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ui.largeGuideline.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (ui.touchInterceptor.getWidth() <= 0) {
          break;
        }
        if (paramFloat >= 1.0F) {
          break label426;
        }
        if (ui.smallBorder.getWidth() <= 0) {
          break;
        }
        ui.touchInterceptor.setInterceptedArea(PremiumUtils.getBoundsInView(ui.smallBorder, ui.touchInterceptor));
        return;
        ui.lightToolbar.setVisibility(0);
        ui.toolbar.setVisibility(8);
        continue;
        ui.lightToolbar.setVisibility(8);
        ui.toolbar.setVisibility(8);
        ui.divider.bringToFront();
        ui.divider.invalidate();
      }
    } while (ui.largeHeader.getWidth() <= 0);
    ui.touchInterceptor.setInterceptedArea(PremiumUtils.getBoundsInView(ui.largeHeader, ui.touchInterceptor));
  }
  
  public final void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    if (!firedPageImpression)
    {
      if (isLarge) {
        fireFullPage(null, null, null);
      }
    }
    else {
      return;
    }
    fireMiniPage(null, null, null);
  }
  
  public final void doResume()
  {
    super.doResume();
    if (large <= 0.0F) {
      ui.divider.setY(ui.layout.getBottom());
    }
    Object localObject = getPremium();
    if (localObject != null)
    {
      bindDataToUi((PremiumProducts)localObject);
      return;
    }
    localObject = getDataProvider();
    if ((localObject != null) && (((PremiumDataProvider.State)state).getPremiumProblem() != null))
    {
      handleError(((PremiumDataProvider.State)state).getPremiumProblem());
      return;
    }
    ui.showSplashPage();
    String str = String.valueOf(PremiumActivityBundleBuilder.getFromChannel(extras));
    localObject = PremiumActivityBundleBuilder.getSuggestedFamily(extras);
    if (localObject == PremiumProductFamily.$UNKNOWN) {}
    for (localObject = null;; localObject = String.valueOf(localObject))
    {
      getDataProvider().fetchProductData(busSubscriberId, getRumSessionId(), str, (String)localObject, Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance()));
      return;
    }
  }
  
  protected final PremiumDataProvider getDataProvider()
  {
    return getActivityactivityComponent.premiumDataProvider();
  }
  
  final PremiumProducts getPremium()
  {
    PremiumDataProvider localPremiumDataProvider = getDataProvider();
    if (localPremiumDataProvider == null) {
      return null;
    }
    return ((PremiumDataProvider.State)state).getPremiumProducts();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    extras = paramActivity.getIntent().getExtras();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("premiumProducts")))
    {
      paramBundle = (PremiumProducts)RecordParceler.quietUnparcel(PremiumProducts.BUILDER, "premiumProducts", paramBundle);
      getDataProviderstate).premiumProducts = paramBundle;
    }
    fragmentComponent.inject(this);
    largeAnimator.setDuration(100L).setInterpolator(new DecelerateInterpolator());
    largeAnimator.addUpdateListener(new SubscriptionChooserFragment.1(this));
    smallToLargeClickListener = new SubscriptionChooserFragment.2(this);
    largeToSmallClickListener = new SubscriptionChooserFragment.3(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ui = SubscriptionChooserViewHolder.createView$74dff977(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = getPalettefragmentComponent.lixManager(), getResources()).headerBackground;
    if (PremiumUtils.setBackgroundImage(this, ui.backgroundImage, ui.layout, paramLayoutInflater))
    {
      PremiumUtils.arrangeVertically(new View[] { ui.toolbar, ui.pageIndicator, ui.headerText });
      ui.headerText.setPadding(ui.headerText.getPaddingLeft(), ui.headerText.getPaddingBottom(), ui.headerText.getPaddingRight(), ui.headerText.getPaddingBottom());
    }
    ui.layout.getViewTreeObserver().addOnGlobalLayoutListener(new SubscriptionChooserFragment.4(this));
    return ui.layout;
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (((PremiumDataProvider.State)getDataProviderstate).getError(getDataProviderstate).productsRoute) != null) {
      handleError(paramDataManagerException);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    int i;
    if ((paramSet != null) && (paramSet.size() == 1) && (((String)paramSet.iterator().next()).equals(getDataProviderstate).productsRoute)))
    {
      i = 1;
      if (i != 0) {
        break label62;
      }
    }
    label62:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        paramType = getPremium();
        if (paramType == null)
        {
          finishActivity();
          PremiumErrorHandler.showError(getContext(), 2131230820);
          return;
        }
      } while (ui == null);
      if (!isDataDisplayed)
      {
        errorPageViewModel.remove();
        isDataDisplayed = true;
      }
      bindDataToUi(paramType);
    } while (!hasWarningText);
    PremiumErrorHandler.showWarning(getContext(), warningText);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ui = null;
    pagerAdapter = null;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    PremiumProducts localPremiumProducts = getPremium();
    if (localPremiumProducts == null) {
      return;
    }
    RecordParceler.quietParcel(localPremiumProducts, "premiumProducts", paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    firedPageImpression = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    pagerAdapter = new SubscriptionChooserPagerAdapter(getChildFragmentManager(), new PremiumChooserPageInstance(getPageInstance()));
    ui.pager.setAdapter(pagerAdapter);
    ui.pager.setOffscreenPageLimit(2);
    finish = new SubscriptionChooserFragment.5(this, tracker, "close", new TrackingEventBuilder[0]);
    ui.pageIndicator.setViewPager(ui.pager);
    ui.toolbar.setNavigationOnClickListener(finish);
    ui.lightToolbar.setNavigationOnClickListener(finish);
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    errorPageViewModel.remove();
  }
  
  public final String pageKey()
  {
    return "premium_chooser";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.SubscriptionChooserFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */