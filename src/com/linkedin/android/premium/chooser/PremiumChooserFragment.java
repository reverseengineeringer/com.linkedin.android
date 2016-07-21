package com.linkedin.android.premium.chooser;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.linkedin.android.premium.PremiumActivityBundleBuilder;
import com.linkedin.android.premium.PremiumChooserPageInstance;
import com.linkedin.android.premium.PremiumDataProvider;
import com.linkedin.android.premium.PremiumDataProvider.State;
import com.linkedin.android.premium.PremiumErrorHandler;
import com.linkedin.android.premium.PremiumModel.ColoredText;
import com.linkedin.android.premium.PremiumModel.Gradient;
import com.linkedin.android.premium.PremiumServiceExceptionServiceCodes;
import com.linkedin.android.premium.PremiumUtils;
import com.linkedin.android.premium.StripedFrameLayout;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class PremiumChooserFragment
  extends PageFragment
{
  private static final String TAG = PremiumChooserFragment.class.getSimpleName();
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131757215)
  ViewStub errorViewStub;
  private Bundle extras;
  View.OnClickListener finish;
  private boolean firedPageImpression;
  private boolean isDataDisplayed;
  private boolean large;
  private PremiumChooserLargePagerAdapter largePagerAdapter;
  View.OnClickListener largeToSmallClickListener;
  private int lastLargeDismissPage = -1;
  private ViewPager.OnPageChangeListener pageChangeListener;
  private PremiumChooserPagerAdapter pagerAdapter;
  @Inject
  PhoneOnlyUserDialogManager phoneOnlyUserDialogManager;
  private int restoredPage = -1;
  private int selectedPage = -1;
  View.OnClickListener smallToLargeClickListener;
  private PremiumChooserViewHolder ui;
  private PremiumChooserViewModel viewModel;
  
  private void bindDataToUi(PremiumProducts paramPremiumProducts)
  {
    int[] arrayOfInt = null;
    boolean bool = false;
    Object localObject1 = pagerAdapter;
    int i = products.size();
    if (count != i)
    {
      count = i;
      hidSomeData = false;
      ((PremiumChooserPagerAdapter)localObject1).notifyDataSetChanged();
    }
    localObject1 = largePagerAdapter;
    i = products.size();
    if (count != i)
    {
      count = i;
      ((PremiumChooserLargePagerAdapter)localObject1).notifyDataSetChanged();
    }
    PremiumChooserPalette localPremiumChooserPalette = PremiumChooserPalette.getPalette(fragmentComponent.lixManager(), getContext());
    PremiumChooserViewModel localPremiumChooserViewModel = new PremiumChooserViewModel();
    if (paramPremiumProducts != null)
    {
      displayedProductIndex = recommendedProductIndex;
      if (header == null) {
        break label352;
      }
      localObject1 = new PremiumModel.ColoredText(header, Integer.valueOf(headerTextColor));
      header = ((PremiumModel.ColoredText)localObject1);
      localObject1 = arrayOfInt;
      if (footer != null) {
        localObject1 = new PremiumModel.ColoredText(footer, Integer.valueOf(footerTextColor));
      }
      footer = ((PremiumModel.ColoredText)localObject1);
      headerIsDark = headerIsDark;
      invertPageIndicatorColor = invertPageIndicatorColor;
      if (products != null) {
        break label358;
      }
      productColors = new int[0];
    }
    for (;;)
    {
      viewModel = localPremiumChooserViewModel;
      if ((restoredPage >= 0) && (restoredPage < products.size()))
      {
        viewModel.displayedProductIndex = restoredPage;
        restoredPage = -1;
      }
      viewModel.onBindViewHolder$28e92a97(getActivity().getLayoutInflater(), ui);
      selectedPage = ui.pager.getCurrentItem();
      pageChangeListener.onPageSelected(selectedPage);
      if (getResourcesgetConfigurationorientation == 2) {
        bool = true;
      }
      large = bool;
      setLargeDismissBackground(selectedPage);
      return;
      label352:
      localObject1 = null;
      break;
      label358:
      productColors = new int[products.size()];
      localObject1 = products.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = localPremiumChooserPalette.getProductTheme(nextproductFamily);
        arrayOfInt = productColors;
        localObject2 = headerBackground.colors;
        arrayOfInt[i] = localObject2[(localObject2.length - 1)];
        i += 1;
      }
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
  
  private PremiumDataProvider getDataProvider()
  {
    return fragmentComponent.premiumDataProvider();
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
          phoneOnlyUserDialogManager.showDialog(new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              PremiumChooserFragment.this.finishActivity();
            }
          });
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
    Object localObject2 = new TrackingClosure(fragmentComponent.tracker(), "try_again") {};
    paramThrowable = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.setupDefaultErrorConfiguration((Context)localObject1, (TrackingClosure)localObject2);
    localObject2 = errorPageViewModel;
    Object localObject1 = ((Activity)localObject1).getLayoutInflater();
    applicationComponent.mediaCenter();
    ((ErrorPageViewModel)localObject2).onBindViewHolderWithErrorTracking$18b8048((LayoutInflater)localObject1, paramThrowable, tracker, getPageInstance());
  }
  
  public static PremiumChooserFragment newInstance()
  {
    return new PremiumChooserFragment();
  }
  
  private void setLargeDismissBackground(int paramInt)
  {
    int i;
    if ((viewModel != null) && (ui != null) && (paramInt != lastLargeDismissPage) && (paramInt < viewModel.productColors.length))
    {
      i = viewModel.productColors[paramInt];
      if (ViewCompat.getLayoutDirection(ui.large) != 1) {
        break label111;
      }
    }
    label111:
    for (GradientDrawable.Orientation localOrientation = GradientDrawable.Orientation.RIGHT_LEFT;; localOrientation = GradientDrawable.Orientation.LEFT_RIGHT)
    {
      PremiumUtils.setBackground(new PremiumModel.Gradient(localOrientation, new int[] { PremiumChooserViewModel.toTransparent(i), i, i }), new View[] { ui.largeDismissBackground });
      lastLargeDismissPage = paramInt;
      return;
    }
  }
  
  public final void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    if (!firedPageImpression)
    {
      if (large) {
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
    Object localObject = getPremium();
    if (localObject != null)
    {
      bindDataToUi((PremiumProducts)localObject);
      return;
    }
    localObject = fragmentComponent.premiumDataProvider();
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
      fragmentComponent.premiumDataProvider().fetchProductData(busSubscriberId, getRumSessionId(), str, (String)localObject, Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance()));
      return;
    }
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
      fragmentComponent.premiumDataProvider().state).premiumProducts = paramBundle;
    }
    fragmentComponent.inject(this);
    smallToLargeClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PremiumChooserFragment.access$000(PremiumChooserFragment.this, true);
        PremiumChooserFragment.this.fireFullPage("tell_me_more_link", ControlType.BUTTON, InteractionType.SHORT_PRESS);
      }
    };
    largeToSmallClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PremiumChooserFragment.access$000(PremiumChooserFragment.this, false);
        PremiumChooserFragment.this.fireMiniPage("close", ControlType.BUTTON, InteractionType.SHORT_PRESS);
      }
    };
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ui = PremiumChooserViewHolder.createView$15152deb(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = getPalettefragmentComponent.lixManager(), getContext()).headerBackground;
    if (PremiumUtils.setBackgroundImage(this, ui.backgroundImage, ui.background, paramLayoutInflater))
    {
      PremiumUtils.arrangeVertically(new View[] { ui.toolbar, ui.pageIndicator, ui.headerText });
      ui.headerText.setPadding(ui.headerText.getPaddingLeft(), ui.headerText.getPaddingBottom(), ui.headerText.getPaddingRight(), ui.headerText.getPaddingBottom());
    }
    ui.layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        int k = 0;
        if (ui != null)
        {
          Object localObject1 = ui.large;
          float f;
          Object localObject2;
          if (large)
          {
            f = 0.0F;
            ((View)localObject1).setTranslationY(f);
            localObject1 = ui.largeDismissBackground;
            localObject2 = largePagerAdapter.getItemAtPosition(ui.largePager.getCurrentItem());
            if (!(localObject2 instanceof PremiumChooserLargePageFragment)) {
              break label348;
            }
            localObject2 = (PremiumChooserLargePageFragment)localObject2;
            if ((ui == null) || (ui.header == null)) {
              break label348;
            }
          }
          int j;
          label348:
          for (int i = ui.header.getHeight();; i = 0)
          {
            PremiumChooserLargePageViewHolder.setHeight((View)localObject1, i);
            localObject1 = pagerAdapter;
            j = Math.max(ui.headerText.getBottom(), ui.pageIndicator.getBottom()) + ui.headerText.getPaddingBottom() - ui.multiViewPager.getTop();
            int m = ui.footer.getHeight();
            i = 0;
            while (i < ((PremiumChooserPagerAdapter)localObject1).getCount())
            {
              localObject2 = ((PremiumChooserPagerAdapter)localObject1).getItemAtPosition(i);
              if ((localObject2 instanceof PremiumChooserPageFragment))
              {
                localObject2 = (PremiumChooserPageFragment)localObject2;
                if ((ui != null) && ((ui.layout.getPaddingTop() != j) || (ui.layout.getPaddingBottom() != m))) {
                  ui.layout.setPadding(ui.layout.getPaddingLeft(), j, ui.layout.getPaddingRight(), m);
                }
              }
              i += 1;
            }
            f = ui.layout.getHeight();
            break;
          }
          if (!hidSomeData)
          {
            i = 0;
            if (i >= ((PremiumChooserPagerAdapter)localObject1).getCount()) {
              break label523;
            }
            localObject2 = ((PremiumChooserPagerAdapter)localObject1).getItemAtPosition(i);
            if (!(localObject2 instanceof PremiumChooserPageFragment)) {
              break label516;
            }
            localObject2 = (PremiumChooserPageFragment)localObject2;
            if ((productBoundToUi == null) || (ui == null) || (ui.features.getChildCount() <= 0) || (ui.features.getBottom() <= ui.smallToLarge.getTop())) {
              break label511;
            }
            j = 1;
            label452:
            if (j == 0) {
              break label516;
            }
          }
          label511:
          label516:
          label523:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              return;
            }
            hidSomeData = true;
            i = k;
            while (i < ((PremiumChooserPagerAdapter)localObject1).getCount())
            {
              localObject2 = ((PremiumChooserPagerAdapter)localObject1).getItemAtPosition(i);
              if ((localObject2 instanceof PremiumChooserPageFragment)) {
                ((PremiumChooserPageFragment)localObject2).hideSomeData();
              }
              i += 1;
            }
            j = 0;
            break label452;
            i += 1;
            break;
          }
        }
      }
    });
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
    paramBundle.putInt("selectedPage", selectedPage);
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
    int i;
    if (paramBundle == null)
    {
      i = -1;
      restoredPage = i;
      selectedPage = -1;
      pageChangeListener = new PageChangeListener((byte)0);
      pagerAdapter = new PremiumChooserPagerAdapter(getChildFragmentManager(), new PremiumChooserPageInstance(getPageInstance()));
      ui.pager.setAdapter(pagerAdapter);
      ui.pager.setOffscreenPageLimit(2);
      ui.pager.addOnPageChangeListener(pageChangeListener);
      ui.pageIndicator.setViewPager(ui.pager);
      largePagerAdapter = new PremiumChooserLargePagerAdapter(getChildFragmentManager(), new PremiumChooserPageInstance(getPageInstance()));
      ui.largePager.setAdapter(largePagerAdapter);
      ui.largePager.addOnPageChangeListener(new LargePageChangeListener((byte)0));
      finish = new TrackingOnClickListener(tracker, "close", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          PremiumChooserFragment.this.finishActivity();
        }
      };
      ui.toolbar.setNavigationOnClickListener(finish);
      ui.lightToolbar.setNavigationOnClickListener(finish);
      if (getResourcesgetConfigurationorientation != 2) {
        break label290;
      }
      ui.largeDismiss.setOnClickListener(finish);
    }
    for (;;)
    {
      errorPageViewModel = new ErrorPageViewModel(errorViewStub);
      errorPageViewModel.remove();
      return;
      i = paramBundle.getInt("selectedPage", -1);
      break;
      label290:
      ui.largeDismiss.setOnClickListener(largeToSmallClickListener);
    }
  }
  
  public final String pageKey()
  {
    return "premium_chooser";
  }
  
  private final class LargePageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int lastPosition = -1;
    
    private LargePageChangeListener() {}
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      if ((paramInt == 0) && (ui != null)) {
        onPageSelected(ui.largePager.getCurrentItem());
      }
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (paramFloat == 0.0F) {
        onPageSelected(paramInt1);
      }
      while (ui == null) {
        return;
      }
      if (paramInt2 > ui.largeDismiss.getWidth())
      {
        PremiumChooserFragment.this.setLargeDismissBackground(paramInt1 + 1);
        return;
      }
      PremiumChooserFragment.this.setLargeDismissBackground(paramInt1);
    }
    
    public final void onPageSelected(int paramInt)
    {
      if ((paramInt != lastPosition) && (ui != null))
      {
        Log.v(PremiumChooserFragment.TAG, "selected large page " + paramInt);
        ui.pager.post(new PremiumChooserFragment.LargePageChangeListener.1(this));
        lastPosition = paramInt;
      }
      PremiumChooserFragment.this.setLargeDismissBackground(paramInt);
    }
  }
  
  private final class PageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int lastPosition = -1;
    
    private PageChangeListener() {}
    
    public final void onPageScrollStateChanged(int paramInt)
    {
      if ((paramInt == 0) && (ui != null)) {
        onPageSelected(ui.pager.getCurrentItem());
      }
    }
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      if (paramFloat == 0.0F) {
        onPageSelected(paramInt1);
      }
    }
    
    public final void onPageSelected(int paramInt)
    {
      if ((paramInt == lastPosition) || (selectedPage < 0)) {}
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt < 0)
            {
              lastPosition = -1;
              return;
            }
            Log.v(PremiumChooserFragment.TAG, "selected small page " + paramInt);
            localObject = getPremium();
          } while ((localObject == null) || (products == null) || (products.size() <= paramInt));
          PremiumChooserFragment.access$1502(PremiumChooserFragment.this, paramInt);
          if (lastPosition >= 0)
          {
            while (paramInt < lastPosition)
            {
              PremiumChooserFragment.access$1600(PremiumChooserFragment.this);
              lastPosition -= 1;
            }
            while (paramInt > lastPosition)
            {
              PremiumChooserFragment.access$1700(PremiumChooserFragment.this);
              lastPosition += 1;
            }
          }
          lastPosition = paramInt;
        } while (ui == null);
        ui.largePager.post(new PremiumChooserFragment.PageChangeListener.1(this));
        localObject = (PremiumProduct)products.get(paramInt);
      } while (localObject == null);
      PremiumChooserFragment.access$1800(PremiumChooserFragment.this, (PremiumProduct)localObject, paramInt, pagerAdapter.getCount());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.chooser.PremiumChooserFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */