package com.linkedin.android.growth.onboarding.rbmf;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.InjectView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerBannerViewTransformer;
import com.linkedin.android.growth.onboarding.OnboardingRoutes;
import com.linkedin.android.growth.onboarding.rbmf.carousel.CarouselContentPageDataModel;
import com.linkedin.android.growth.onboarding.rbmf.carousel.ConsistencyManagerListenerHelper;
import com.linkedin.android.growth.onboarding.rbmf.carousel.RebuildMyFeedCarouselAdapter;
import com.linkedin.android.growth.onboarding.rbmf.carousel.RebuildMyFeedCarouselTransformer;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingDialogInterfaceOnClickListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;

public class RebuildMyFeedFragment
  extends PageFragment
{
  private AlertDialog alertDialog;
  @InjectView(2131756235)
  ViewPager carousel;
  private RebuildMyFeedCarouselAdapter carouselAdapter;
  @InjectView(2131756234)
  View carouselContainer;
  private RebuildMyFeedFragment.CarouselPageChangeListener carouselPageChangeListener;
  private TrackingOnClickListener carouselPageContinueListener;
  private TrackingOnClickListener carouselPageDoneListener;
  @Inject
  ConsistencyManager consistencyManager;
  private TrackingDialogInterfaceOnClickListener dialogNegativeClickListener;
  private TrackingDialogInterfaceOnClickListener dialogPositiveClickListener;
  @InjectView(2131756238)
  Button exitButton;
  @InjectView(2131756244)
  View extraUpdateImage1;
  @InjectView(2131756246)
  View extraUpdateImage2;
  @InjectView(2131756247)
  View extraUpdateImage3;
  private boolean firstBatchReady;
  @InjectView(2131756239)
  ViewFlipper flipper;
  private Handler handler = new Handler();
  private boolean hasMoreData;
  private AnimatorSet introAnimatorSet;
  @InjectView(2131756240)
  View introContainer;
  private float introDummyPhoneScreenHeight;
  private float introExtraUpdatesSlideDistance;
  @InjectView(2131756242)
  TextView introText;
  private float introTextSlideDistance;
  @InjectView(2131756249)
  ProgressBar loadingIcon;
  private int origin = 0;
  @InjectView(2131756236)
  HorizontalViewPagerCarousel pageIndicator;
  ViewGroup parent;
  @InjectView(2131756243)
  ImageView phoneImage;
  private RebuildMyFeedDataProvider rebuildMyFeedDataProvider;
  private PackageRecommendationTrackingHelper rebuildMyFeedTrackingHelper;
  private boolean skipIntro;
  @InjectView(2131756248)
  Button skipIntroButton;
  private int startOfNextPage;
  @InjectView(2131756237)
  TextView swipeMoreText;
  @InjectView(2131756245)
  View updateImage;
  private Runnable waitForFirstBatchReadyRunnable = new RebuildMyFeedFragment.1(this);
  
  private void clearAnimations()
  {
    if (introText != null) {
      introText.clearAnimation();
    }
    if (phoneImage != null) {
      phoneImage.clearAnimation();
    }
    if (updateImage != null) {
      updateImage.clearAnimation();
    }
    if (introAnimatorSet != null)
    {
      introAnimatorSet.removeAllListeners();
      introAnimatorSet.cancel();
    }
  }
  
  private void firePackageImpressionEvent(int paramInt)
  {
    if ((carouselAdapter == null) || (!"onboarding_feed_follow_package".equals(RebuildMyFeedCarouselAdapter.getPageKey(paramInt)))) {
      return;
    }
    PackageRecommendationTrackingHelper localPackageRecommendationTrackingHelper = rebuildMyFeedTrackingHelper;
    int i;
    if (paramInt < 5) {
      i = paramInt;
    }
    label57:
    PackageRecommendationImpressionEvent.Builder localBuilder;
    ViewedPackage.Builder localBuilder1;
    for (;;)
    {
      Object localObject1 = carouselAdapter.pageModels.get(paramInt);
      if (!(localObject1 instanceof CarouselContentPageDataModel)) {
        localObject1 = null;
      }
      try
      {
        localBuilder = new PackageRecommendationImpressionEvent.Builder();
        localBuilder1 = new ViewedPackage.Builder().setPackageFlowPosition(Integer.valueOf(i));
        localBuilder1.setPackageFlowPosition(Integer.valueOf(i + 1));
        localBuilder1.setPackageScreenPosition(Integer.valueOf(1));
        Object localObject2 = Integer.valueOf(packageId);
        if (localObject2 == null) {
          hasPackageId = false;
        }
        for (packageId = 0;; packageId = ((Integer)localObject2).intValue())
        {
          i = recommendedEntities.size();
          localObject2 = new ArrayList(i);
          paramInt = 0;
          while (paramInt < i)
          {
            ((List)localObject2).add(PackageRecommendationTrackingHelper.getRecommendedEntity((RecommendedEntity)recommendedEntities.get(paramInt), paramInt));
            paramInt += 1;
          }
          i = paramInt - 1;
          break;
          localObject1 = recommendedPackage;
          break label57;
          hasPackageId = true;
        }
        localBuilder1.setEntities((List)localObject2);
      }
      catch (BuilderException localBuilderException)
      {
        fragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(localBuilderException));
        return;
      }
    }
    localBuilder.setPackages(Collections.singletonList(localBuilder1.build()));
    tracker.send(localBuilder);
  }
  
  private void firePageEvent(int paramInt)
  {
    if (carouselAdapter == null) {
      return;
    }
    rebuildMyFeedTrackingHelper.firePageEvent(RebuildMyFeedCarouselAdapter.getPageKey(paramInt));
  }
  
  private ObjectAnimator getFadeObjectAnimator(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator.addListener(new RebuildMyFeedFragment.10(this, paramView));
      return localObjectAnimator;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setInterpolator(new AccelerateInterpolator());
    localObjectAnimator.addListener(new RebuildMyFeedFragment.11(this, paramView));
    return localObjectAnimator;
  }
  
  private ObjectAnimator getTranslateYObjectAnimator(View paramView, boolean paramBoolean, float paramFloat, long paramLong)
  {
    if (paramBoolean) {}
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.TRANSLATION_Y, new float[] { paramFloat, 0.0F });; localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.TRANSLATION_Y, new float[] { 0.0F, paramFloat }))
    {
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator.setStartDelay(paramLong);
      localObjectAnimator.addListener(new RebuildMyFeedFragment.12(this, paramView));
      return localObjectAnimator;
    }
  }
  
  private void showCarousel()
  {
    if ((!isAdded()) || (flipper == null)) {
      return;
    }
    clearAnimations();
    startOfNextPage += 6;
    hasMoreData = false;
    Object localObject = (RebuildMyFeedDataProvider.State)rebuildMyFeedDataProvider.state;
    localObject = (CollectionTemplate)((RebuildMyFeedDataProvider.State)localObject).getModel(rbmfFirstPageRoute);
    if ((localObject == null) || (CollectionUtils.isEmpty(elements)))
    {
      showFeed(true);
      return;
    }
    if (elements.size() >= 6) {}
    for (boolean bool = true;; bool = false)
    {
      hasMoreData = bool;
      carouselAdapter = new RebuildMyFeedCarouselAdapter((CollectionTemplate)localObject, fragmentComponent, rebuildMyFeedTrackingHelper);
      carousel.setAdapter(carouselAdapter);
      carousel.setPageMargin(getResources().getDimensionPixelOffset(2131492991));
      carousel.setClipChildren(false);
      carousel.setOffscreenPageLimit(3);
      carousel.setPageTransformer(false, new RebuildMyFeedCarouselTransformer());
      firePageEvent(0);
      firePackageImpressionEvent(0);
      updateCarouselFooter(0);
      pageIndicator.setViewPager(carousel, 5);
      carouselPageChangeListener = new RebuildMyFeedFragment.CarouselPageChangeListener(this, (byte)0);
      carousel.addOnPageChangeListener(carouselPageChangeListener);
      exitButton.setOnClickListener(carouselPageDoneListener);
      localObject = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      ((TranslateAnimation)localObject).setDuration(900L);
      ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      flipper.setInAnimation((Animation)localObject);
      localObject = new TranslateAnimation(2, 0.0F, 2, -1.0F, 2, 0.0F, 2, 0.0F);
      ((TranslateAnimation)localObject).setDuration(900L);
      ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      flipper.setOutAnimation((Animation)localObject);
      flipper.setDisplayedChild(2);
      return;
    }
  }
  
  private void showFeed(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject1 = applicationComponent.flagshipSharedPreferences();
      if (!skipIntro) {
        ((FlagshipSharedPreferences)localObject1).setInsertUnfollowEducateCard(true);
      }
      ((FlagshipSharedPreferences)localObject1).setShowCustomizingYourFeedView(true);
      if ((carouselAdapter != null) && (carouselAdapter.followedCount.get() > 0)) {
        ((FlagshipSharedPreferences)localObject1).getPreferences().edit().putBoolean("userHasBeenThroughRBMF", true).apply();
      }
      localObject1 = fragmentComponent;
      localObject2 = ((FragmentComponent)localObject1).flagshipSharedPreferences().getNewToVoyagerLegoTrackingToken();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        LegoTrackingDataProvider localLegoTrackingDataProvider = NewToVoyagerBannerViewTransformer.getLegoTrackingDataProvider((FragmentComponent)localObject1);
        if (localLegoTrackingDataProvider != null) {
          localLegoTrackingDataProvider.sendActionEvent$67c7f505((String)localObject2, ActionCategory.SKIP);
        }
        ((FragmentComponent)localObject1).flagshipSharedPreferences().setNewToVoyagerLegoTrackingToken("");
      }
    }
    Object localObject1 = new HomeBundle();
    activeTab = HomeTabInfo.FEED;
    Object localObject2 = new FeedBundleBuilder();
    int i = origin;
    bundle.putInt("origin", i);
    activeTabBundleBuilder = ((BundleBuilder)localObject2);
    startActivity(applicationComponent.intentRegistry().home.newIntent(getActivity(), (BundleBuilder)localObject1).setFlags(268468224));
    fragmentComponent.activity().finish();
  }
  
  private void updateCarouselFooter(int paramInt)
  {
    int j = 8;
    Object localObject = pageIndicator;
    int i;
    label43:
    Button localButton;
    if (paramInt >= 5)
    {
      i = 4;
      ((HorizontalViewPagerCarousel)localObject).setVisibility(i);
      localObject = swipeMoreText;
      if ((paramInt <= 0) && (origin != 1)) {
        break label107;
      }
      i = 8;
      ((TextView)localObject).setVisibility(i);
      localObject = exitButton;
      if (paramInt <= 0)
      {
        i = j;
        if (origin != 1) {}
      }
      else
      {
        i = 0;
      }
      ((Button)localObject).setVisibility(i);
      localButton = exitButton;
      if (paramInt != 5) {
        break label112;
      }
    }
    label107:
    label112:
    for (localObject = carouselPageContinueListener;; localObject = carouselPageDoneListener)
    {
      localButton.setOnClickListener((View.OnClickListener)localObject);
      return;
      i = 0;
      break;
      i = 0;
      break label43;
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    rebuildMyFeedTrackingHelper.delayedExecution.stopAllDelayedExecution();
  }
  
  public final void doPause()
  {
    rebuildMyFeedDataProvider.unregister(this);
    super.doPause();
  }
  
  public final void doResume()
  {
    super.doResume();
    rebuildMyFeedDataProvider.register(this);
  }
  
  final void handleExitFlowButton()
  {
    if (carouselAdapter == null)
    {
      showCarousel();
      return;
    }
    if (carouselAdapter.followedCount.get() < 5)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
      localBuilder.setTitle(2131231693);
      localBuilder.setMessage(fragmentComponent.i18NManager().getString(2131231692, new Object[] { Integer.valueOf(5) }));
      localBuilder.setPositiveButton(17039379, dialogPositiveClickListener);
      localBuilder.setNegativeButton(17039360, dialogNegativeClickListener);
      rebuildMyFeedTrackingHelper.firePageEvent("onboarding_feed_confirm_done");
      alertDialog = localBuilder.show();
      return;
    }
    showFeed(false);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((orientation != 2) && (orientation != 1)) {}
    while (carousel == null) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)carousel.getLayoutParams();
    Resources localResources = getResources();
    if (orientation == 2) {}
    for (int i = 2131492987;; i = 2131493003)
    {
      topMargin = ((int)localResources.getDimension(i));
      carousel.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    boolean bool;
    if (paramBundle != null)
    {
      if ((paramBundle == null) || (!paramBundle.getBoolean("skipRbmfIntro", false))) {
        break label182;
      }
      bool = true;
      skipIntro = bool;
      if (paramBundle == null) {
        break label187;
      }
    }
    label182:
    label187:
    for (int i = paramBundle.getInt("origin", 0);; i = 0)
    {
      origin = i;
      rebuildMyFeedDataProvider = fragmentComponent.activity().activityComponent.rebuildMyFeedDataProvider();
      paramBundle = rebuildMyFeedDataProvider;
      Object localObject = busSubscriberId;
      String str = getRumSessionId();
      Uri localUri = OnboardingRoutes.buildRebuildMyFeedRout(0, 6);
      state).rbmfFirstPageRoute = localUri.toString();
      localObject = paramBundle.newModelListener((String)localObject, str);
      activityComponent.dataManager().submit(Request.get().url(state).rbmfFirstPageRoute).customHeaders(null).builder(CollectionTemplate.of(RecommendedPackage.BUILDER)).shouldUpdateCache(false).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
      bool = false;
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968867, paramViewGroup, false);
    parent = ((ViewGroup)paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    showFeed(true);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    boolean bool = true;
    if (paramSet == null) {
      showFeed(true);
    }
    do
    {
      do
      {
        return;
        if (!paramSet.contains(rebuildMyFeedDataProvider.state).rbmfFirstPageRoute)) {
          break;
        }
        firstBatchReady = true;
      } while (!skipIntro);
      showCarousel();
      return;
      if (!paramSet.contains(rebuildMyFeedDataProvider.state).rbmfNextPageRoute)) {
        break;
      }
      paramType = (RebuildMyFeedDataProvider.State)rebuildMyFeedDataProvider.state;
      paramSet = (CollectionTemplate)paramType.getModel(rbmfNextPageRoute);
      hasMoreData = false;
    } while ((paramSet == null) || (CollectionUtils.isEmpty(elements)));
    if (elements.size() >= 6) {}
    for (;;)
    {
      hasMoreData = bool;
      startOfNextPage += 6;
      paramType = carouselAdapter;
      paramSet = elements;
      if (CollectionUtils.isEmpty(paramSet)) {
        break;
      }
      int i = paramSet.size();
      packages.addAll(paramSet);
      int j = packages.size();
      while (i < j)
      {
        paramType.createContentPageModel(i);
        i += 1;
      }
      bool = false;
    }
    carouselAdapter.notifyDataSetChanged();
    return;
    showFeed(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (alertDialog != null) {
      alertDialog.dismiss();
    }
    if (carouselAdapter != null)
    {
      ConsistencyManagerListenerHelper localConsistencyManagerListenerHelper = carouselAdapter.consistencyManagerHelper;
      if (!listeners.isEmpty())
      {
        Iterator localIterator = listeners.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          consistencyManager.removeListener((ConsistencyManagerListener)localEntry.getValue());
        }
        listeners.clear();
      }
    }
    handler.removeCallbacks(waitForFirstBatchReadyRunnable);
    clearAnimations();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    rebuildMyFeedTrackingHelper = new PackageRecommendationTrackingHelper(fragmentComponent, fragmentComponent.delayedExecution());
    carouselPageDoneListener = new RebuildMyFeedFragment.2(this, tracker, "done", new TrackingEventBuilder[0]);
    dialogPositiveClickListener = new RebuildMyFeedFragment.3(this, tracker, "confirm", new TrackingEventBuilder[0]);
    dialogNegativeClickListener = new RebuildMyFeedFragment.4(this, tracker, "cancel", new TrackingEventBuilder[0]);
    carouselPageContinueListener = new RebuildMyFeedFragment.5(this, tracker, "continue", new TrackingEventBuilder[0]);
    if (skipIntro)
    {
      flipper.setDisplayedChild(1);
      return;
    }
    introDummyPhoneScreenHeight = getResources().getDimensionPixelSize(2131493176);
    introTextSlideDistance = getResources().getDimensionPixelSize(2131493181);
    introExtraUpdatesSlideDistance = getResources().getDimensionPixelSize(2131493180);
    flipper.setDisplayedChild(0);
    rebuildMyFeedTrackingHelper.firePageEvent("onboarding_feed_intro");
    introAnimatorSet = new AnimatorSet();
    paramView = introAnimatorSet;
    paramBundle = getFadeObjectAnimator(introText, true);
    paramBundle.addListener(new RebuildMyFeedFragment.7(this));
    Object localObject1 = getTranslateYObjectAnimator(introText, true, introTextSlideDistance, 0L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramBundle, localObject1 });
    paramBundle = getTranslateYObjectAnimator(phoneImage, true, introDummyPhoneScreenHeight, 0L);
    Object localObject2 = getTranslateYObjectAnimator(extraUpdateImage1, true, introDummyPhoneScreenHeight, 160L);
    Object localObject3 = getTranslateYObjectAnimator(updateImage, true, introDummyPhoneScreenHeight, 193L);
    ObjectAnimator localObjectAnimator1 = getTranslateYObjectAnimator(extraUpdateImage2, true, introDummyPhoneScreenHeight, 226L);
    ObjectAnimator localObjectAnimator2 = getTranslateYObjectAnimator(extraUpdateImage3, true, introDummyPhoneScreenHeight, 226L);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { paramBundle, localObject2, localObject3, localObjectAnimator1, localObjectAnimator2 });
    localObject2 = getFadeObjectAnimator(introText, false);
    ((ObjectAnimator)localObject2).setStartDelay(2000L);
    paramBundle = new AnimatorSet();
    paramBundle.playSequentially(new Animator[] { localAnimatorSet, localObject1, localObject2 });
    paramBundle.setStartDelay(1000L);
    localObject1 = getFadeObjectAnimator(introText, true);
    ((ObjectAnimator)localObject1).addListener(new RebuildMyFeedFragment.8(this));
    localObject2 = getTranslateYObjectAnimator(introText, true, introTextSlideDistance, 0L);
    localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
    localObject2 = ObjectAnimator.ofFloat(updateImage, View.SCALE_X, new float[] { 0.0F });
    localObject3 = ObjectAnimator.ofFloat(updateImage, View.SCALE_Y, new float[] { 0.0F });
    ((ObjectAnimator)localObject2).setDuration(500L);
    ((ObjectAnimator)localObject3).setDuration(500L);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
    ((AnimatorSet)localObject1).addListener(new RebuildMyFeedFragment.9(this));
    localObject3 = getTranslateYObjectAnimator(extraUpdateImage2, false, -introExtraUpdatesSlideDistance, 0L);
    localObjectAnimator1 = getTranslateYObjectAnimator(extraUpdateImage3, false, -introExtraUpdatesSlideDistance, 0L);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).setStartDelay(320L);
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localObject3, localObjectAnimator1 });
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).playSequentially(new Animator[] { localAnimatorSet, localObject1, localObject2 });
    ((AnimatorSet)localObject3).setStartDelay(320L);
    paramView.playSequentially(new Animator[] { paramBundle, localObject3 });
    introAnimatorSet.addListener(new RebuildMyFeedFragment.6(this));
    introAnimatorSet.start();
  }
  
  public final String pageKey()
  {
    return "onboarding_feed_follow";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */