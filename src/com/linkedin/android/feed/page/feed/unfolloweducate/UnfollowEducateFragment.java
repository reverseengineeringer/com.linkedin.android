package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.PulsatingView;
import com.linkedin.android.growth.onboarding.rbmf.PackageRecommendationTrackingHelper;
import com.linkedin.android.infra.RepeatingRunnable;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedPackage;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.rbmf.PackageRecommendationImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnfollowEducateFragment
  extends PageFragment
{
  private AnimatorSet actionListAnimations;
  @InjectView(2131755842)
  View controlPanelOverlay;
  private TrackingOnClickListener dismissListener;
  @InjectView(2131755864)
  Button doneButton;
  private boolean isDataReady;
  private int lastImpressionEventBatch;
  @InjectView(2131755873)
  PulsatingView pulsingButton;
  private RecommendedPackage recommendedPackage;
  private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener()
  {
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      UnfollowEducateFragment.this.fireImpressionEventIfNecessary();
    }
  };
  @InjectView(2131755850)
  Button skipButton;
  private PackageRecommendationTrackingHelper trackingHelper;
  @InjectView(2131755846)
  LinearLayout unfollowButton;
  @InjectView(2131755844)
  View unfollowButtonBottomBar;
  @InjectView(2131755843)
  View unfollowButtonTopBar;
  private UnfollowEducateAdapter unfollowEducateAdapter;
  private UnfollowEducateDataProvider unfollowEducateDataProvider;
  @InjectView(2131755848)
  View unfollowFragmentContainer;
  @InjectView(2131755863)
  RecyclerView unfollowList;
  @InjectView(2131755862)
  TextView unfollowText;
  @InjectView(2131755861)
  TextView unfollowTitle;
  @InjectView(2131755849)
  ViewFlipper viewFlipper;
  
  static
  {
    if (!UnfollowEducateFragment.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private void fireImpressionEventIfNecessary()
  {
    if (!isDataReady) {}
    int j;
    do
    {
      return;
      j = ((LinearLayoutManager)unfollowList.getLayoutManager()).findFirstVisibleItemPosition() / 5;
    } while (lastImpressionEventBatch == j);
    localPackageRecommendationTrackingHelper = trackingHelper;
    RecommendedPackage localRecommendedPackage = recommendedPackage;
    try
    {
      PackageRecommendationImpressionEvent.Builder localBuilder = new PackageRecommendationImpressionEvent.Builder();
      ViewedPackage.Builder localBuilder1 = new ViewedPackage.Builder();
      localBuilder1.setPackageFlowPosition(Integer.valueOf(1));
      localBuilder1.setPackageScreenPosition(Integer.valueOf(j + 1));
      ArrayList localArrayList = new ArrayList(5);
      int i = j;
      while (i < j + 5)
      {
        localArrayList.add(PackageRecommendationTrackingHelper.getRecommendedEntity((RecommendedEntity)recommendedEntities.get(i), i));
        i += 1;
      }
      localBuilder1.setEntities(localArrayList);
      localBuilder.setPackages(Collections.singletonList(localBuilder1.build()));
      tracker.send(localBuilder);
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        fragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(localBuilderException));
      }
    }
    lastImpressionEventBatch = j;
  }
  
  public static UnfollowEducateFragment newInstance(UnfollowEducateBundle paramUnfollowEducateBundle)
  {
    UnfollowEducateFragment localUnfollowEducateFragment = new UnfollowEducateFragment();
    localUnfollowEducateFragment.setArguments(paramUnfollowEducateBundle.build());
    return localUnfollowEducateFragment;
  }
  
  public final void doPause()
  {
    if (unfollowEducateDataProvider != null) {
      unfollowEducateDataProvider.unregister(this);
    }
    super.doPause();
  }
  
  public final void doResume()
  {
    super.doResume();
    if (unfollowEducateDataProvider != null) {
      unfollowEducateDataProvider.register(this);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968765, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    Log.d("Feed Logging", "Error: " + paramDataManagerException.getMessage());
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet != null) && (paramSet.contains(unfollowEducateDataProvider.state).unfollowEducateRecommendationsRoute)))
    {
      paramType = (UnfollowEducateDataProvider.State)unfollowEducateDataProvider.state;
      paramType = (CollectionTemplate)paramType.getModel(unfollowEducateRecommendationsRoute);
      if (!CollectionUtils.isEmpty(paramType))
      {
        assert (elements != null);
        recommendedPackage = ((RecommendedPackage)elements.get(0));
        if (CollectionUtils.isEmpty(recommendedPackage.recommendedEntities)) {
          break label203;
        }
      }
    }
    label203:
    for (boolean bool = true;; bool = false)
    {
      isDataReady = bool;
      unfollowEducateAdapter = new UnfollowEducateAdapter(fragmentComponent, trackingHelper, recommendedPackage.recommendedEntities);
      paramType = new DividerItemDecoration();
      paramType.setDivider(getResources(), 2130837654);
      paramType.setStartMargin(getResources(), 2131493152);
      unfollowList.addItemDecoration(paramType);
      unfollowList.setAdapter(unfollowEducateAdapter);
      unfollowList.addOnScrollListener(scrollListener);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    lastImpressionEventBatch = -1;
    isDataReady = false;
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    unfollowEducateDataProvider = fragmentComponent.activity().activityComponent.unfollowEducateDataProvider();
    paramBundle = unfollowEducateDataProvider;
    Object localObject = busSubscriberId;
    String str = getRumSessionId();
    state).unfollowEducateRecommendationsRoute = Routes.UNFOLLOW_EDUCATE.buildPagedRouteUponRoot(0, 50).buildUpon().appendQueryParameter("q", "unfollowRecommendations").build().toString();
    localObject = paramBundle.newModelListener((String)localObject, str);
    activityComponent.dataManager().submit(Request.get().url(state).unfollowEducateRecommendationsRoute).customHeaders(null).builder(CollectionTemplate.of(RecommendedPackage.BUILDER)).shouldUpdateCache(false).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    viewFlipper.setDisplayedChild(0);
    paramBundle = AnimationUtils.loadAnimation(getContext(), 2131034129);
    paramBundle.setDuration(1000L);
    paramView.startAnimation(paramBundle);
    paramView = AnimationUtils.loadAnimation(getContext(), 2131034129);
    paramView.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        UnfollowEducateFragment.access$100(UnfollowEducateFragment.this);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        viewFlipper.setVisibility(0);
      }
    });
    paramView.setStartOffset(700L);
    paramView.setDuration(1000L);
    viewFlipper.startAnimation(paramView);
    trackingHelper = new PackageRecommendationTrackingHelper(fragmentComponent, delayedExecution);
  }
  
  public final String pageKey()
  {
    return "feed_unfollow_educate";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */