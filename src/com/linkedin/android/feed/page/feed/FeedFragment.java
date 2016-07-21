package com.linkedin.android.feed.page.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.EfficientCoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.Callback;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.FeedLoadingViewHolder;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.FeedUpdatesDataProvider.2;
import com.linkedin.android.feed.FeedUpdatesDataProvider.State;
import com.linkedin.android.feed.actions.ControlMenuBundleBuilder;
import com.linkedin.android.feed.actions.ControlMenuOnClickListener;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformerConstants;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.endoffeed.FeedEndOfFeedLayout;
import com.linkedin.android.feed.endor.ui.component.endoffeed.FeedEndOfFeedViewModel;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.aggregated.connection.FeedAggregatedConnectionUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.aggregated.pymk.FeedAggregatedPymkUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.events.FeedLikeUpdateSucceededEvent;
import com.linkedin.android.feed.events.UpdateExpandEvent;
import com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggDismissedEvent;
import com.linkedin.android.feed.page.feed.hero.FeedHeroManager;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdateHelper;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdateInfo;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider.1;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider.State;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesListener;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.page.feed.newupdatespill.FeedNewUpdatesPillEvent;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesDividerDecoration;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesManager;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton.RecyclerViewScrollDetector;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton.RecyclerViewScrollDetectorImpl;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillTrackingEvent;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDismissedEvent;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateViewModel;
import com.linkedin.android.feed.shared.PullToRefreshListener;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.transformer.UpdateActionTransformerHelpers;
import com.linkedin.android.feed.utils.FeedCollectionHelper;
import com.linkedin.android.feed.utils.FeedErrorViewModels;
import com.linkedin.android.feed.utils.FeedErrorViewModels.2;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedRecyclerViewUtils.1;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.FeedShareHeaderManager;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.utils.animations.FeedAnimationHelper;
import com.linkedin.android.feed.utils.animations.FeedAnimationHelper.4;
import com.linkedin.android.feed.utils.animations.FeedAnimationHelper.5;
import com.linkedin.android.feed.utils.animations.FeedAnimationHelper.FeedAnimationListener;
import com.linkedin.android.feed.utils.animations.RBMFCustomizingYourFeedAnimationHelper;
import com.linkedin.android.feed.utils.animations.UnfollowEducateAnimationHelper;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.growth.onboarding.rbmf.PackageRecommendationTrackingHelper;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabScrolledEvent;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider.GuidedEditState;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.identity.profile.view.topcard.events.SendInvitationEvent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.events.MeUpdatedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.mediaupload.UploadProgressEvent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.DisplayedViewDetector;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Me;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher.PendingShare;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher.PendingSlideShareUpload;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreatedEvent;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreatingEvent;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreationFailedEvent;
import com.linkedin.android.publishing.sharing.events.FeedUpdateCreationSuccessEvent;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerBundle;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.feed.highlightedUpdateSource;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedFragment
  extends BaseFeedFragment
{
  public static final String TAG = FeedFragment.class.getSimpleName();
  @InjectView(2131755786)
  RoundedImageView actorImage;
  private FeedAnimationHelper animationHelper;
  @InjectView(2131755784)
  AppBarLayout appBarLayout;
  @InjectView(2131755731)
  LinearLayout buttonLayout;
  @InjectView(2131755791)
  LinearLayout cameraButton;
  @InjectView(2131755792)
  TextView cameraButtonText;
  private Uri cameraPhotoUri;
  @Inject
  ConsistencyManager consistencyManager;
  @InjectView(2131755782)
  EfficientCoordinatorLayout coordinatorLayout;
  private Snackbar currentSnackbar;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  DelayedExecution delayedExecution;
  private Set<String> displayedSnackbars = new HashSet();
  private final Runnable easterEggRunnable = new Runnable()
  {
    public final void run()
    {
      if (((isHoldingShareButton) && (isHoldingCameraButton)) || (isHoldingFab)) {
        FeedFragment.access$300(FeedFragment.this);
      }
    }
  };
  private ErrorPageViewModel errorViewModel;
  @InjectView(2131755783)
  ViewStub errorViewStub;
  @Inject
  Bus eventBus;
  @InjectView(2131755800)
  FloatingActionButton fab;
  private FeedHeroManager feedHeroManager;
  private View feedLoadingView;
  private final RecyclerView.OnScrollListener feedScrollListener = new RecyclerView.OnScrollListener()
  {
    public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      int i = 0;
      if (paramAnonymousInt == 1) {
        FeatureLog.d(FeedFragment.TAG, "user interaction detected on feed", "Realtime Feed Updates");
      }
      do
      {
        FeedFragment.access$602$571b359f(FeedFragment.this);
        do
        {
          return;
        } while ((paramAnonymousInt != 0) || (isAnimatingLoadingView) || (!isScrollingUp));
        paramAnonymousInt = i;
        if (com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[0] == 0)
        {
          paramAnonymousInt = i;
          if (paramAnonymousRecyclerView.getChildAt(0).getTop() >= 0) {
            paramAnonymousInt = 1;
          }
        }
      } while (paramAnonymousInt == 0);
      shareHeaderManager.setShareActionsVisibility(true, true);
      feedHeroManager.expandFeedHeroIfAvailable();
    }
    
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((preventEndOfFeedPill) && (paramAnonymousInt2 > 0)) {
        FeedFragment.access$402$571b359f(FeedFragment.this);
      }
      paramAnonymousRecyclerView = FeedFragment.this;
      if (paramAnonymousInt2 < 0) {}
      for (boolean bool = true;; bool = false)
      {
        FeedFragment.access$502(paramAnonymousRecyclerView, bool);
        return;
      }
    }
  };
  @Inject
  FollowPublisher followPublisher;
  private boolean hasPendingPillPVE;
  private boolean hasResumedOnce;
  @InjectView(2131755799)
  View headerDropShadow;
  @InjectView(2131755794)
  AppBarLayout heroAppBarLayout;
  @InjectView(2131755795)
  CollapsingToolbarLayout heroContainer;
  public HighlightedUpdateHelper highlightedUpdateHelper;
  private HighlightedUpdatesDataProvider highlightedUpdatesDataProvider;
  private boolean highlightedUpdatesRead;
  private boolean isAnimatingLoadingView;
  public boolean isAnimatingScrolling;
  private boolean isHoldingCameraButton;
  private boolean isHoldingFab;
  private boolean isHoldingShareButton;
  private boolean isScrollingUp;
  private boolean isShowingEasterEgg;
  private LayoutInflater layoutInflater;
  @Inject
  CheckForNewUpdatesRunnable newUpdatesChecker;
  private NewUpdatesDividerDecoration newUpdatesDivider;
  @InjectView(2131755798)
  NewUpdatesPillButton newUpdatesPill;
  private PackageRecommendationTrackingHelper packageRecommendationTrackingHelper;
  private Map<String, FeedSharePublisher.PendingShare> pendingSharesUploadMap = new ArrayMap();
  private Map<String, Snackbar> pendingSnackbars = new ArrayMap();
  private NewUpdatesManager pillManager;
  private boolean preventEndOfFeedPill;
  @Inject
  RateTheApp rateTheApp;
  private int screenHeight;
  @InjectView(2131755789)
  LinearLayout shareButton;
  @InjectView(2131755790)
  TextView shareButtonText;
  @InjectView(2131755787)
  TextView shareHeaderHintText;
  private FeedShareHeaderManager shareHeaderManager;
  @Inject
  FeedSharePublisher sharePublisher;
  private UnfollowEducateAnimationHelper unfollowEducateAnimationHelper;
  @InjectView(2131755793)
  EfficientCoordinatorLayout updatesContainer;
  @InjectView(2131755785)
  LinearLayout upperLayout;
  private boolean userInteractionDetected;
  
  private void appendHardRefreshFromNewUpdatesManager(List<FeedItemViewModel> paramList)
  {
    moveNewUpdatesDivider(paramList);
    int i = feedAdapter.getItemCount();
    feedAdapter.prependValues(paramList);
    feedAdapter.removeValues(paramList.size(), i);
    scrollToTop();
    preventEndOfFeedPill = true;
  }
  
  private void enqueueShareCreatingSnackbar(String paramString)
  {
    if ((displayedSnackbars.contains(paramString)) || (pendingSnackbars.containsKey(paramString))) {
      return;
    }
    enqueueSnackbar(paramString, 2131231290, 2131231289, 4000, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        scrollToTop();
      }
    });
  }
  
  private void enqueueSnackbar(String paramString, int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    if (!isAdded()) {
      return;
    }
    paramOnClickListener = Snackbar.make(getActivity().findViewById(16908290), getLocalizedString(paramInt1), paramInt3).setAction(paramInt2, paramOnClickListener);
    paramOnClickListener.setCallback(new Snackbar.Callback()
    {
      public final void onDismissed(Snackbar paramAnonymousSnackbar, int paramAnonymousInt)
      {
        FeedFragment.access$1702$1bf405df(FeedFragment.this);
        if ((pendingSnackbars.isEmpty()) && (rateTheApp.rtaToDisplay))
        {
          rateTheApp.rtaToDisplay = false;
          rateTheApp.showRTA(fragmentComponent);
        }
        FeedFragment.this.showNextPendingSnackbar();
      }
      
      public final void onShown(Snackbar paramAnonymousSnackbar)
      {
        if (rateTheApp.rtaDisplayed)
        {
          paramAnonymousSnackbar = rateTheApp;
          FragmentComponent localFragmentComponent = fragmentComponent;
          if (container != null) {
            container.removeView(rtaFrameView);
          }
        }
      }
    });
    pendingSnackbars.put(paramString, paramOnClickListener);
  }
  
  private void firePendingPillPVEIfNecessary()
  {
    if ((isActive) && (hasPendingPillPVE))
    {
      PageInstance localPageInstance = applicationComponent.newUpdatesChecker().getCurrentPageInstance();
      new PageViewEvent(tracker, "feed_pill", false, localPageInstance).send();
      hasPendingPillPVE = false;
    }
  }
  
  private Update getViralUpdate(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = feedAdapter.getUpdateViewModel(paramString);
      if ((paramString != null) && (controlMenuClickListener != null))
      {
        paramString = (ControlMenuOnClickListener)controlMenuClickListener;
        Iterator localIterator = actionList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (nexttype != 3);
        for (int i = 1; i != 0; i = 0) {
          return update;
        }
      }
    }
    return null;
  }
  
  private void hideNewUpdatesPill()
  {
    if (newUpdatesPill == null) {
      return;
    }
    newUpdatesPill.toggleDisplayed(false, 4);
    hasPendingPillPVE = false;
  }
  
  private void intendToShowRTA()
  {
    if (currentSnackbar != null)
    {
      rateTheApp.rtaToDisplay = true;
      return;
    }
    rateTheApp.showRTA(fragmentComponent);
  }
  
  private void launchShareCreatorWithImage(Uri paramUri)
  {
    FragmentActivity localFragmentActivity = getActivity();
    paramUri = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShareWithImage(paramUri));
    localFragmentActivity.startActivity(fragmentComponent.intentRegistry().share.newIntent(localFragmentActivity, paramUri));
  }
  
  private void loadNewPendingShares()
  {
    List localList = sharePublisher.pendingShares;
    if (localList.size() == 0) {
      return;
    }
    getFeedUpdateViewModels(localList, new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelsData)
      {
        if (!isAdded()) {}
        ArrayList localArrayList;
        do
        {
          return;
          localArrayList = new ArrayList();
          paramAnonymousModelsData = viewModels;
          int i = 0;
          int j = paramAnonymousModelsData.size();
          while (i < j)
          {
            FeedUpdateViewModel localFeedUpdateViewModel = (FeedUpdateViewModel)paramAnonymousModelsData.get(i);
            if (!feedAdapter.containsUpdate(localFeedUpdateViewModel))
            {
              localArrayList.add(localFeedUpdateViewModel);
              FeedFragment.this.enqueueShareCreatingSnackbar(updateUrn);
            }
            i += 1;
          }
        } while (localArrayList.size() <= 0);
        feedAdapter.prependValues(localArrayList);
      }
    });
  }
  
  private void moveNewUpdatesDivider(List<FeedItemViewModel> paramList)
  {
    String str = null;
    if (paramList.size() > 0)
    {
      paramList = (FeedItemViewModel)paramList.get(paramList.size() - 1);
      if (!(paramList instanceof FeedUpdateViewModel)) {
        break label53;
      }
    }
    label53:
    for (str = updateUrn;; str = null)
    {
      newUpdatesDivider.lastRecentUpdateUrn = str;
      return;
    }
  }
  
  private void openShareCreation()
  {
    FragmentActivity localFragmentActivity = getActivity();
    ShareBundle localShareBundle = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShare());
    localFragmentActivity.startActivity(fragmentComponent.intentRegistry().share.newIntent(localFragmentActivity, localShareBundle));
  }
  
  private void performNewUpdatesClick(NewUpdatesPillTrackingEvent paramNewUpdatesPillTrackingEvent)
  {
    Object localObject = null;
    int j = pillManager.getAndResetPillBehavior();
    int i;
    CollectionTemplate localCollectionTemplate;
    if ((j == 1) || (j == 0) || (j == 3))
    {
      i = 1;
      if ((paramNewUpdatesPillTrackingEvent != null) && (i != 0)) {
        paramNewUpdatesPillTrackingEvent.send();
      }
      feedAdapter.lastPageTracked = -1;
      paramNewUpdatesPillTrackingEvent = pillManager.getAndClearNewUpdates();
      NewUpdatesManager localNewUpdatesManager = pillManager;
      localNewUpdatesManager.updateMostRecentFeedTime();
      localCollectionTemplate = newUpdatesCollection;
      newUpdatesCollection = null;
      switch (j)
      {
      case 2: 
      default: 
        if (feedUpdatesDataProvider != null)
        {
          swipeRefreshLayout.setRefreshing(true);
          paramNewUpdatesPillTrackingEvent = RUMHelper.pageInitRefresh(this);
          feedUpdatesDataProvider.refreshFeed(Tracker.createPageInstanceHeader(getPageInstance()), FeedRouteUtils.getFeedUpdatesRoute(fragmentComponent, getFeedWidth()), paramNewUpdatesPillTrackingEvent);
          newUpdatesChecker.restart(false);
        }
        break;
      }
    }
    for (;;)
    {
      paramNewUpdatesPillTrackingEvent = (NewUpdatesPillTrackingEvent)localObject;
      if (localCollectionTemplate != null) {
        paramNewUpdatesPillTrackingEvent = elements;
      }
      if (paramNewUpdatesPillTrackingEvent != null) {
        fragmentComponent.updateChangeCoordinator().listenForUpdates(paramNewUpdatesPillTrackingEvent, updateChangedListener);
      }
      hideNewUpdatesPill();
      return;
      i = 0;
      break;
      appendHardRefreshFromNewUpdatesManager(paramNewUpdatesPillTrackingEvent);
      newUpdatesChecker.restart(false);
      continue;
      moveNewUpdatesDivider(paramNewUpdatesPillTrackingEvent);
      feedAdapter.prependValues(paramNewUpdatesPillTrackingEvent);
      scrollToTop();
      newUpdatesChecker.restart(false);
      continue;
      if ((localCollectionTemplate != null) && (feedUpdatesDataProvider != null)) {
        feedUpdatesDataProvider.state).collectionHelper.setCollectionTemplate(localCollectionTemplate);
      }
      appendHardRefreshFromNewUpdatesManager(paramNewUpdatesPillTrackingEvent);
      newUpdatesChecker.restart(false);
    }
  }
  
  private void removePendingShare(String paramString)
  {
    paramString = (FeedSharePublisher.PendingShare)pendingSharesUploadMap.remove(paramString);
    if ((paramString != null) && (progressBar != null)) {
      progressBar.setVisibility(8);
    }
  }
  
  private void resetAnimatingViews()
  {
    isAnimatingScrolling = false;
    Object localObject;
    if (animationHelper != null)
    {
      localObject = animationHelper;
      animationLatch = new CountDownLatch(2);
      animationHandler.removeCallbacks(waitForFeedAnimationRunnable);
      if (loadingViewHolder != null)
      {
        ViewParent localViewParent = loadingViewHolder.itemView.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(loadingViewHolder.itemView);
        }
      }
      if (recyclerView != null)
      {
        recyclerView.setVisibility(0);
        recyclerView.setAlpha(1.0F);
        recyclerView.setTranslationY(0.0F);
      }
      animationHelper = null;
      applicationComponent.flagshipSharedPreferences().setShowCustomizingYourFeedView(false);
    }
    if (unfollowEducateAnimationHelper != null)
    {
      localObject = unfollowEducateAnimationHelper;
      fragmentComponent.delayedExecution().stopDelayedExecution(showUnfollowRunnable);
    }
  }
  
  private void setupFeedErrorViewModel()
  {
    Closure local16 = new Closure() {};
    Tracker localTracker = fragmentComponent.tracker();
    if (errorViewModel == null)
    {
      ViewStub localViewStub = errorViewStub;
      ErrorPageViewModel localErrorPageViewModel = new ErrorPageViewModel(localViewStub);
      FeedErrorViewModels.setupFeedRetryErrorViewModel(localViewStub.getContext(), localErrorPageViewModel, localTracker, local16);
      errorViewModel = localErrorPageViewModel;
      return;
    }
    FeedErrorViewModels.setupFeedRetryErrorViewModel(errorViewStub.getContext(), errorViewModel, localTracker, local16);
  }
  
  private boolean shouldInsertUnfollowEducateViewModel(List<FeedUpdateViewModel> paramList)
  {
    return (fragmentComponent.flagshipSharedPreferences().getInsertUnfollowEducateCard()) && (paramList.size() > 4) && (!(paramList.get(4) instanceof UnfollowEducateViewModel));
  }
  
  private void showFeedLoadingView$13462e()
  {
    if (feedLoadingView != null) {
      return;
    }
    isAnimatingLoadingView = true;
    hideErrorView();
    shareHeaderManager.setShareActionsVisibility(false, false);
    hideNewUpdatesPill();
    feedAdapter.showLoadingView(false);
    feedLoadingView = layoutInflater.inflate(2130968761, updatesContainer, false);
    updatesContainer.addView(feedLoadingView);
    Object localObject2 = new FeedLoadingViewHolder(feedLoadingView);
    packageRecommendationTrackingHelper.firePageEvent("onboarding_feed_building");
    text.setAlpha(0.0F);
    progressBar.setAlpha(0.0F);
    Object localObject3 = text;
    Object localObject1 = getArguments();
    int i;
    if (localObject1 != null)
    {
      i = ((Bundle)localObject1).getInt("origin", 0);
      switch (i)
      {
      }
    }
    for (localObject1 = i18NManager.getString(2131231275);; localObject1 = i18NManager.getString(2131231169))
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = new FeedLoadingAnimationListener((byte)0);
      animationHelper = new RBMFCustomizingYourFeedAnimationHelper(recyclerView, (FeedLoadingViewHolder)localObject2, (FeedAnimationHelper.FeedAnimationListener)localObject1, screenHeight);
      recyclerView.setVisibility(8);
      localObject2 = animationHelper;
      localObject3 = ObjectAnimator.ofFloat(loadingViewHolder.progressBar, View.ALPHA, new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject3).setDuration(500L);
      ((ObjectAnimator)localObject3).addListener(new FeedAnimationHelper.4((FeedAnimationHelper)localObject2));
      float f = screenHeight;
      localObject1 = ObjectAnimator.ofFloat(loadingViewHolder.text, View.TRANSLATION_Y, new float[] { f * 0.25F, 0.0F });
      ((ObjectAnimator)localObject1).setDuration(500L);
      ((ObjectAnimator)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      ((ObjectAnimator)localObject1).addListener(new FeedAnimationHelper.5((FeedAnimationHelper)localObject2, (ObjectAnimator)localObject3));
      localObject2 = ObjectAnimator.ofFloat(loadingViewHolder.text, View.ALPHA, new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).setDuration(500L);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).playTogether(new Animator[] { localObject1, localObject2 });
      ((AnimatorSet)localObject3).setStartDelay(700L);
      ((AnimatorSet)localObject3).start();
      return;
      i = 0;
      break;
    }
  }
  
  private void showNewUpdatesPill(int paramInt)
  {
    if (newUpdatesPill == null) {
      return;
    }
    hasPendingPillPVE = newUpdatesPill.toggleDisplayed(true, paramInt);
    firePendingPillPVEIfNecessary();
  }
  
  private void showNextPendingSnackbar()
  {
    if (currentSnackbar != null) {}
    while (pendingSnackbars.size() <= 0) {
      return;
    }
    Iterator localIterator = pendingSnackbars.entrySet().iterator();
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    currentSnackbar = ((Snackbar)localEntry.getValue());
    currentSnackbar.show();
    displayedSnackbars.add(localEntry.getKey());
    localIterator.remove();
  }
  
  protected final void deleteUpdate(String paramString)
  {
    int i = feedAdapter.removeUpdateIfFound(paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString.equals(newUpdatesDivider.lastRecentUpdateUrn))
    {
      localObject1 = localObject2;
      if (i != 0)
      {
        paramString = (FeedItemViewModel)feedAdapter.getItemAtPosition(i - 1);
        localObject1 = localObject2;
        if ((paramString instanceof FeedUpdateViewModel)) {
          localObject1 = updateUrn;
        }
      }
    }
    newUpdatesDivider.lastRecentUpdateUrn = ((String)localObject1);
  }
  
  public final void displayInitialUpdates(CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<FeedUpdateViewModel> paramList, DataStore.Type paramType)
  {
    if (shouldInsertUnfollowEducateViewModel(paramList)) {
      paramList.add(4, new UnfollowEducateViewModel(viewPool, fragmentComponent));
    }
    if (paramType == DataStore.Type.LOCAL)
    {
      resetFeedAdapter(paramList);
      if (pillManager.getInitialFetchFilter() == 4) {
        newUpdatesChecker.restart(false);
      }
      if (feedAdapter.containsHighlightedUpdates())
      {
        paramList = feedAdapter;
        paramCollectionTemplate = feedAdapter;
        if (!paramCollectionTemplate.containsHighlightedUpdates()) {
          break label204;
        }
      }
    }
    label204:
    for (paramCollectionTemplate = highlightedItemViewModels;; paramCollectionTemplate = null)
    {
      paramList.prependValues(paramCollectionTemplate);
      hideErrorView();
      if (animationHelper != null) {
        animationHelper.hideLoadingViewIfPossible();
      }
      if (feedAdapter.hasUpdates()) {
        loadNewPendingShares();
      }
      return;
      if ((paramType == DataStore.Type.NETWORK) && (pillManager.getInitialFetchFilter() == 2) && (feedAdapter.hasUpdates()) && (!feedAdapter.containsHighlightedUpdates()))
      {
        pillManager.setNewUpdatesCollection$12f66db9(paramCollectionTemplate, paramList);
        showNewUpdatesPill(3);
        break;
      }
      super.displayInitialUpdates(paramCollectionTemplate, paramList, paramType);
      newUpdatesChecker.restart(false);
      break;
    }
  }
  
  protected final void displayRefreshUpdates(CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<FeedUpdateViewModel> paramList, DataStore.Type paramType)
  {
    if (shouldInsertUnfollowEducateViewModel(paramList)) {
      paramList.add(4, new UnfollowEducateViewModel(viewPool, fragmentComponent));
    }
    if ((feedAdapter.containsHighlightedUpdates()) && (highlightedUpdateHelper != null))
    {
      feedAdapter.removeHighlightedItemViewModels();
      highlightedUpdateHelper = null;
      highlightedUpdatesRead = true;
    }
    super.displayRefreshUpdates(paramCollectionTemplate, paramList, paramType);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    currentSnackbar = null;
    if ((feedAdapter != null) && (feedAdapter.hasUpdates()))
    {
      loadNewPendingShares();
      showNextPendingSnackbar();
    }
    NewUpdatesManager localNewUpdatesManager = pillManager;
    FragmentComponent localFragmentComponent = fragmentComponent;
    FeatureLog.i("NewUpdatesManager", "entering", "Realtime Feed Updates");
    localFragmentComponent.eventBus();
    if (!Bus.isSubscribed(localNewUpdatesManager))
    {
      FeatureLog.i("NewUpdatesManager", "subscribing on the event bus", "Realtime Feed Updates");
      Bus.subscribe(localNewUpdatesManager);
    }
    Bus.publish(BadgeUpdateEvent.createWithShouldUpdateOuterBadge(HomeTabInfo.FEED, Long.valueOf(0L)));
    if (pillManager.shouldShowNewUpdatesPill()) {
      showNewUpdatesPill(3);
    }
    firePendingPillPVEIfNecessary();
  }
  
  public final void doLeave()
  {
    int j = 1;
    super.doLeave();
    if (packageRecommendationTrackingHelper != null) {
      packageRecommendationTrackingHelper.cancelPageEvent();
    }
    resetAnimatingViews();
    NewUpdatesManager localNewUpdatesManager;
    FragmentComponent localFragmentComponent;
    if (pillManager != null)
    {
      localNewUpdatesManager = pillManager;
      localFragmentComponent = fragmentComponent;
      if ((feedAdapter == null) || (!feedAdapter.hasUpdates()) || (userInteractionDetected)) {
        break label189;
      }
      i = 1;
      FeatureLog.i("NewUpdatesManager", "leaving", "Realtime Feed Updates");
      localFragmentComponent.eventBus();
      Bus.unsubscribe(localNewUpdatesManager);
      FeatureLog.i("NewUpdatesManager", "unsubscribing from the event bus", "Realtime Feed Updates");
      if ((!newFeedSession) || (i == 0) || (!localFragmentComponent.lixManager().getTreatment(Lix.FEED_AGGRESSIVE_BADGE).equals("enabled"))) {
        break label194;
      }
    }
    label189:
    label194:
    for (int i = j;; i = 0)
    {
      if ((localNewUpdatesManager.shouldShowNewUpdatesPill()) || (i != 0))
      {
        localFragmentComponent.eventBus();
        Bus.publish(BadgeUpdateEvent.createWithShouldUpdateOuterBadge(HomeTabInfo.FEED, Long.valueOf(1L)));
        FeatureLog.i("NewUpdatesManager", "showing new updates badge", "Realtime Feed Updates");
      }
      return;
      i = 0;
      break;
    }
  }
  
  public final void doResume()
  {
    resetAnimatingViews();
    Object localObject5 = fragmentComponent;
    Object localObject4;
    Object localObject3;
    int i;
    if ((FeedLixHelper.isEnabled(((FragmentComponent)localObject5).lixManager(), Lix.FEED_CHERRY)) && (!highlightedUpdatesRead) && (!feedAdapter.containsHighlightedUpdates()))
    {
      localObject2 = getArguments();
      localObject4 = null;
      localObject3 = null;
      String[] arrayOfString1 = FeedBundleBuilder.getHighlightedUrns((Bundle)localObject2);
      String[] arrayOfString2 = FeedBundleBuilder.getHighlightedTypes((Bundle)localObject2);
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label188;
        }
      }
      label188:
      for (localObject2 = null;; localObject2 = (MessageId)RecordParceler.quietUnparcel(MessageId.BUILDER, "sourceTrackingId", (Bundle)localObject2))
      {
        if (localObject1 != null) {
          localObject3 = highlightedUpdateSource.of((String)localObject1);
        }
        localObject1 = localObject4;
        if (arrayOfString1 == null) {
          break label207;
        }
        localObject1 = localObject4;
        if (arrayOfString2 == null) {
          break label207;
        }
        localObject1 = localObject4;
        if (arrayOfString1.length != arrayOfString2.length) {
          break label207;
        }
        localObject4 = new HighlightedUpdateInfo[arrayOfString1.length];
        i = 0;
        for (;;)
        {
          localObject1 = localObject4;
          if (i >= localObject4.length) {
            break;
          }
          localObject4[i] = new HighlightedUpdateInfo(arrayOfString2[i], arrayOfString1[i]);
          i += 1;
        }
        localObject1 = ((Bundle)localObject2).getString("highlightedUpdateSource");
        break;
      }
      label207:
      if (localObject1 == null) {
        break label458;
      }
    }
    label458:
    for (Object localObject1 = new HighlightedUpdateHelper((HighlightedUpdateInfo[])localObject1, (highlightedUpdateSource)localObject3, (MessageId)localObject2);; localObject1 = null)
    {
      highlightedUpdateHelper = ((HighlightedUpdateHelper)localObject1);
      if (highlightedUpdateHelper != null)
      {
        localObject1 = highlightedUpdateHelper.highlightedUpdateInfos;
        feedAdapter.insertHighlightedPlaceholderViews((FragmentComponent)localObject5, (HighlightedUpdateInfo[])localObject1);
        localObject2 = highlightedUpdatesDataProvider;
        localObject3 = Tracker.createPageInstanceHeader(getPageInstance());
        localObject4 = getRumSessionId();
        localObject5 = FeedRouteUtils.getBaseHighlightedUpdatesRoute((HighlightedUpdateInfo[])localObject1).buildUpon();
        ((Uri.Builder)localObject5).appendQueryParameter("start", "0").appendQueryParameter("count", String.valueOf(localObject1.length));
        localObject1 = ((Uri.Builder)localObject5).build().toString();
        state).collectionHelper.fetchInitialData((Map)localObject3, 3, (String)localObject1, new HighlightedUpdatesDataProvider.1((HighlightedUpdatesDataProvider)localObject2, (String)localObject4), (String)localObject4);
        preventEndOfFeedPill = true;
      }
      super.doResume();
      if (!hasResumedOnce) {
        break;
      }
      int j = com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[0];
      int k = com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(layoutManager)[1];
      i = j;
      while ((i <= k) && (j != -1) && (k != -1))
      {
        localObject1 = (FeedItemViewModel)feedAdapter.getItemAtPosition(i);
        if ((localObject1 instanceof FeedUpdateViewModel))
        {
          localObject2 = Tracker.createPageInstanceHeader(getPageInstance());
          ((FeedUpdateViewModel)localObject1).trackImpressionIfSponsored((Map)localObject2, i);
        }
        i += 1;
      }
    }
    hasResumedOnce = true;
    feedHeroManager.showFeedHeroIfRequired();
    localObject1 = pillManager;
    Object localObject2 = (FragmentComponent)fragmentComponentReference.get();
    if ((fastNetwork) && (localObject2 != null))
    {
      ((FragmentComponent)localObject2).timeWrapper();
      long l1 = System.currentTimeMillis();
      long l2 = ((FragmentComponent)localObject2).flagshipSharedPreferences().getAppLastBackgroundTimeStamp();
      if ((feedStartTimestamp < l2) && (l1 - l2 >= newSessionThreshold))
      {
        i = 2;
        switch (i)
        {
        default: 
          label584:
          if (feedUpdatesDataProvider != null)
          {
            localObject1 = ((FeedUpdatesDataProvider.State)feedUpdatesDataProvider.state).getCrossPromo("p_flagship3_rate");
            if (localObject1 == null) {
              break label727;
            }
            rateTheApp.onResume((Promo)localObject1);
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (fragmentComponent.flagshipSharedPreferences().isReadTheArticle())
      {
        fragmentComponent.flagshipSharedPreferences().setReadTheArticle(false);
        if (pendingSnackbars.isEmpty()) {
          intendToShowRTA();
        }
      }
      return;
      if (((NewUpdatesManager)localObject1).shouldShowNewUpdatesPill())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      FeatureLog.d(TAG, "resuming, showing pill", "Realtime Feed Updates");
      showNewUpdatesPill(3);
      break label584;
      FeatureLog.d(TAG, "resuming, hard refreshing", "Realtime Feed Updates");
      nukeFeed();
      break label584;
      label727:
      if (((FeedUpdatesDataProvider.State)feedUpdatesDataProvider.state).getCrossPromoError("p_flagship3_rate") == null) {
        feedUpdatesDataProvider.fetchCrossPromo("p_flagship3_rate", busSubscriberId, getRumSessionId());
      }
    }
  }
  
  public final String enterPageKey()
  {
    return "feed_updates";
  }
  
  public final int feedType()
  {
    return 0;
  }
  
  protected final int filterForInitialFetch()
  {
    return pillManager.getInitialFetchFilter();
  }
  
  public final void getFeedUpdateViewModels(List<Update> paramList, ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsTransformedCallback)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramModelsTransformedCallback.onModelsTransformed(ModelTransformerConstants.emptyListData());
      return;
    }
    fragmentComponent.updateChangeCoordinator().listenForUpdates(paramList, updateChangedListener);
    FeedViewTransformer.toViewModels(fragmentComponent, viewPool, paramList, FeedDataModelMetadata.DEFAULT, paramModelsTransformedCallback);
  }
  
  protected final String getInitialFetchRoute()
  {
    if ((FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_CHERRY)) && (feedAdapter.containsHighlightedUpdates()) && (highlightedUpdateHelper != null))
    {
      FragmentComponent localFragmentComponent = fragmentComponent;
      HighlightedUpdateInfo[] arrayOfHighlightedUpdateInfo = highlightedUpdateHelper.highlightedUpdateInfos;
      int i = getFeedWidth();
      Uri.Builder localBuilder = FeedRouteUtils.getBaseHighlightedUpdatesRoute(arrayOfHighlightedUpdateInfo).buildUpon();
      localBuilder.appendQueryParameter("start", String.valueOf(arrayOfHighlightedUpdateInfo.length)).appendQueryParameter("count", FeedRouteUtils.getFeedPageSize(localFragmentComponent.lixManager()));
      if (i > 0)
      {
        int j = FeedRouteUtils.getImageHeight(localFragmentComponent.context().getResources(), i);
        localBuilder.appendQueryParameter("w", String.valueOf(i)).appendQueryParameter("h", String.valueOf(j));
      }
      return localBuilder.build().toString();
    }
    return FeedRouteUtils.getFeedUpdatesRoute(fragmentComponent, getFeedWidth());
  }
  
  protected final Uri getLoadMoreRoute()
  {
    return FeedRouteUtils.getBaseFeedUpdatesRoute(fragmentComponent, getFeedWidth());
  }
  
  public final String getLogTag()
  {
    return TAG;
  }
  
  public final int getTrackingMode()
  {
    return 1;
  }
  
  public final void hardRefreshFeed()
  {
    if (feedUpdatesDataProvider != null)
    {
      String str = RUMHelper.pageInitRefresh(this);
      feedUpdatesDataProvider.refreshFeed(Tracker.createPageInstanceHeader(getPageInstance()), FeedRouteUtils.getFeedUpdatesRoute(fragmentComponent, getFeedWidth()), str);
      newUpdatesChecker.restart(false);
    }
  }
  
  public final void hideErrorView()
  {
    super.hideErrorView();
    if (errorViewModel != null) {
      errorViewModel.remove();
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return "feed_updates";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (paramInt1 != 11) {
                break;
              }
              if (paramIntent == null) {}
              for (paramIntent = null; paramIntent != null; paramIntent = paramIntent.getData())
              {
                launchShareCreatorWithImage(paramIntent);
                return;
              }
            }
            if (paramInt1 != 12) {
              break;
            }
          } while (cameraPhotoUri == null);
          launchShareCreatorWithImage(cameraPhotoUri);
          cameraPhotoUri = null;
          return;
          if ((paramInt1 != 13) || (paramIntent == null)) {
            break;
          }
          localObject1 = LinkPickerBundle.getUrlPreviewData(paramIntent.getBundleExtra("BUNDLE_URL_PREVIEW_DATA"));
        } while (localObject1 == null);
        paramIntent = getActivity();
        Object localObject1 = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShareWithLink((UrlPreviewData)localObject1));
        paramIntent.startActivity(fragmentComponent.intentRegistry().share.newIntent(paramIntent, (BundleBuilder)localObject1));
        return;
        if ((paramInt1 != 14) || (paramIntent == null)) {
          break;
        }
        localObject2 = paramIntent.getExtras();
        paramIntent = ((Bundle)localObject2).getString("UPDATE_URN");
        paramInt1 = ((Bundle)localObject2).getInt("UPDATE_ACTION_TYPE", -1);
        if (1 == paramInt1)
        {
          localObject1 = FeedUpdateDetailBundleBuilder.getViralUpdateUrn((Bundle)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramIntent = (Intent)localObject1;
          }
          for (;;)
          {
            deleteUpdate(paramIntent);
            return;
          }
        }
        if (3 == paramInt1)
        {
          localObject1 = ControlMenuBundleBuilder.getUpdate((Bundle)localObject2);
          localObject2 = FeedUpdateDetailBundleBuilder.getViralUpdateUrn((Bundle)localObject2);
          paramIntent = (Intent)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramIntent = (Intent)localObject1;
            if (getViralUpdate((String)localObject2) != null) {
              paramIntent = getViralUpdate((String)localObject2);
            }
          }
          collapseUpdate(paramIntent, UpdateActionTransformerHelpers.toUpdateActionModel(paramInt1, null, null, -1, null, null, null, null, null, false, null, null, null));
          return;
        }
      } while ((!UpdateActionModel.isUnfollowAction(paramInt1)) && (22 != paramInt1) && (21 != paramInt1) && (23 != paramInt1));
      collapseUpdate(ControlMenuBundleBuilder.getUpdate((Bundle)localObject2), UpdateActionTransformerHelpers.toUpdateActionModel(paramInt1, ((Bundle)localObject2).getString("UPDATE_ACTOR_ID"), ((Bundle)localObject2).getString("UPDATE_ACTOR_NAME"), -1, null, null, null, null, ((Bundle)localObject2).getString("MENTIONED_ENTITY"), ((Bundle)localObject2).getBoolean("REPORTED_BY_ME"), null, ((Bundle)localObject2).getString("GROUP_NAME"), ((Bundle)localObject2).getString("PERMALINK")));
      return;
    } while (paramInt1 != 42);
    feedHeroManager.dismissUEditHero(true);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_CHERRY))
    {
      highlightedUpdatesDataProvider = fragmentComponent.highlightedUpdatesDataProvider();
      highlightedUpdatesDataProvider.addListener(new HighlightedUpdatesListener(this));
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    newUpdatesDivider.measured = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    if (FeedLixHelper.isEnabled(applicationComponent.lixManager(), Lix.FEED_REDUCE_THRESHOLD_FOR_FIE))
    {
      viewPortManager = new ViewPortManager(tracker, new DisplayedViewDetector());
      viewPortManager.configure(0.0F, 0.0F, 0L);
    }
    paramBundle = getContext();
    pillManager = new NewUpdatesManager(paramBundle, fragmentComponent, viewPool);
    CollectionTemplate localCollectionTemplate = newUpdatesChecker.getAndClearLastFeed();
    if (localCollectionTemplate != null) {
      pillManager.transformAndStoreFeed(localCollectionTemplate);
    }
    newUpdatesDivider = new NewUpdatesDividerDecoration(paramBundle);
    if (feedUpdatesDataProvider != null) {
      feedUpdatesDataProvider.fetchCrossPromo("p_flagship3_rate", busSubscriberId, getRumSessionId());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968751, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    FeedHeroManager localFeedHeroManager = feedHeroManager;
    if (paramMap != null)
    {
      paramType = paramMap.values().iterator();
      do
      {
        if (!paramType.hasNext()) {
          break;
        }
      } while (!(nextmodel instanceof Promo));
    }
    for (int i = 1;; i = 0)
    {
      if ((paramSet != null) && (paramSet.contains(guidedEditDataProvider.state).guidedEditCategoriesFeedRoute)))
      {
        paramType = (GuidedEditDataProvider.GuidedEditState)guidedEditDataProvider.state;
        paramType = (CollectionTemplate)paramType.getModel(guidedEditCategoriesFeedRoute);
        if (paramType != null)
        {
          paramType = elements;
          if (!CollectionUtils.isNonEmpty(paramType)) {
            break label153;
          }
          guidedEditCategoryForFeed = ((GuidedEditCategory)paramType.get(0));
          i = 1;
        }
      }
      label153:
      for (;;)
      {
        if (i != 0) {
          localFeedHeroManager.showFeedHeroIfRequired();
        }
        return;
        paramType = null;
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    Bus.unsubscribe(feedHeroManager);
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(FeedCommentUpdateEvent paramFeedCommentUpdateEvent)
  {
    if ((updateEventType == 6) && (pendingSnackbars.isEmpty())) {
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          FeedFragment.this.intendToShowRTA();
        }
      }, 4000L);
    }
  }
  
  @Subscribe
  public void onEvent(FeedLikeUpdateSucceededEvent paramFeedLikeUpdateSucceededEvent)
  {
    if (feedUpdatesDataProvider == null) {}
    for (paramFeedLikeUpdateSucceededEvent = null;; paramFeedLikeUpdateSucceededEvent = ((FeedUpdatesDataProvider.State)feedUpdatesDataProvider.state).getCrossPromo("p_flagship3_rate"))
    {
      if (paramFeedLikeUpdateSucceededEvent != null) {
        rateTheApp.onResume(paramFeedLikeUpdateSucceededEvent);
      }
      if (pendingSnackbars.isEmpty()) {
        intendToShowRTA();
      }
      return;
    }
  }
  
  @Subscribe
  public void onEvent(UpdateExpandEvent paramUpdateExpandEvent)
  {
    ModelTransformedCallback local9 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {
          return;
        }
        feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
      }
    };
    if (update.urn != null)
    {
      fragmentComponent.updateChangeCoordinator().setExpanded(update.urn);
      getFeedUpdateViewModel(fragmentComponent, viewPool, update, local9);
    }
  }
  
  @Subscribe
  public void onEvent(FeedEasterEggDismissedEvent paramFeedEasterEggDismissedEvent)
  {
    isShowingEasterEgg = false;
  }
  
  @Subscribe
  public void onEvent(FeedNewUpdatesPillEvent paramFeedNewUpdatesPillEvent)
  {
    FeatureLog.d(TAG, "pill event: " + action, "Realtime Feed Updates");
    switch (action)
    {
    default: 
      return;
    case 1: 
      hideNewUpdatesPill();
      return;
    case 2: 
      showNewUpdatesPill(3);
      return;
    case 3: 
      hideNewUpdatesPill();
      performNewUpdatesClick(FeedTracking.getNUPTrackingEventForTappedEndOfFeedButton(applicationComponent));
      return;
    }
    hideNewUpdatesPill();
    nukeFeed();
  }
  
  @Subscribe
  public void onEvent(UnfollowEducateDismissedEvent paramUnfollowEducateDismissedEvent)
  {
    boolean bool = didUnfollow;
    paramUnfollowEducateDismissedEvent = feedAdapter;
    int i = 0;
    for (;;)
    {
      if (i < values.size())
      {
        if (((FeedItemViewModel)values.get(i) instanceof UnfollowEducateViewModel))
        {
          values.remove(i);
          paramUnfollowEducateDismissedEvent.notifyItemRemoved(i);
        }
      }
      else
      {
        if (bool) {
          showFeedLoadingView$13462e();
        }
        return;
      }
      i += 1;
    }
  }
  
  @Subscribe
  public void onEvent(TabScrolledEvent paramTabScrolledEvent)
  {
    if ((layoutManager != null) && (viewPortManager != null) && (tab == HomeTabInfo.FEED) && (source == 2) && (end)) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  @Subscribe
  public void onEvent(TabSelectedEvent paramTabSelectedEvent)
  {
    if ((tab == HomeTabInfo.FEED) && (alreadySelected) && (tapSelected) && (!isDetached()))
    {
      if (pillManager.shouldShowNewUpdatesPill()) {
        performNewUpdatesClick(FeedTracking.getNUPTrackingEventForTappedTab(applicationComponent));
      }
    }
    else {
      return;
    }
    scrollToTop();
  }
  
  @Subscribe
  public void onEvent(SendInvitationEvent paramSendInvitationEvent)
  {
    FeedUpdatesDataProvider localFeedUpdatesDataProvider;
    String str1;
    Object localObject1;
    String str2;
    FragmentComponent localFragmentComponent;
    if ((invitationSource == 2) && (feedUpdatesDataProvider != null))
    {
      localFeedUpdatesDataProvider = feedUpdatesDataProvider;
      str1 = profileId;
      localObject1 = trackingId;
      str2 = message;
      localFragmentComponent = fragmentComponent;
      paramSendInvitationEvent = new FeedUpdatesDataProvider.2(localFeedUpdatesDataProvider, str1, localFragmentComponent);
    }
    try
    {
      Object localObject2 = new InviteeProfile.Builder().setProfileId(str1).build(RecordTemplate.Flavor.RECORD);
      localObject2 = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject2).build();
      localObject1 = new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject2).setTrackingId((String)localObject1);
      if (str2 != null) {
        ((NormInvitation.Builder)localObject1).setMessage(str2);
      }
      localObject1 = PegasusPatchGenerator.modelToJSON(((NormInvitation.Builder)localObject1).build(RecordTemplate.Flavor.RECORD));
      str2 = Routes.NORM_INVITATIONS.buildUponRoot().buildUpon().build().toString();
      paramSendInvitationEvent = Request.post().url(str2).model(new JsonModel((JSONObject)localObject1)).listener(paramSendInvitationEvent).filter(DataManager.DataStoreFilter.NETWORK_ONLY).customHeaders(Tracker.createPageInstanceHeader(localFragmentComponent.tracker().getCurrentPageInstance()));
      activityComponent.dataManager().submit(paramSendInvitationEvent);
      profilePendingConnectionRequestManager.setPendingState(str1, ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT);
      localFragmentComponent.eventBus();
      Bus.publish(new InvitationUpdatedEvent(str1, InvitationUpdatedEvent.Type.SENT));
      return;
    }
    catch (BuilderException paramSendInvitationEvent)
    {
      localFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Failed to create normInvitation", paramSendInvitationEvent));
      return;
    }
    catch (JSONException paramSendInvitationEvent)
    {
      for (;;) {}
    }
  }
  
  @Subscribe
  public void onEvent(MeUpdatedEvent paramMeUpdatedEvent)
  {
    if (shareHeaderManager != null) {
      shareHeaderManager.setupProfileImage(me.miniProfile);
    }
  }
  
  @Subscribe
  public void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    removePendingShare(optimisticUpdateId);
    final Object localObject = fragmentComponent.sharePublisher();
    final FeedSharePublisher.PendingSlideShareUpload localPendingSlideShareUpload = ((FeedSharePublisher)localObject).removeFromPendingSlideShareUploads(uploadId);
    if (localPendingSlideShareUpload != null)
    {
      Bus.publish(new FeedUpdateCreationFailedEvent(newShare, error));
      ((FeedSharePublisher)localObject).removeFromPendingShares(newShare);
    }
    if (localPendingSlideShareUpload != null)
    {
      localObject = Tracker.createPageInstanceHeader(getPageInstance());
      enqueueSnackbar(optimisticUpdateId, 2131233663, 2131233680, 8000, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          fragmentComponent.sharePublisher().publishSlideShare(localPendingSlideShareUpload, localObject);
          FeedFragment.this.loadNewPendingShares();
          FeedFragment.this.showNextPendingSnackbar();
        }
      });
      showNextPendingSnackbar();
    }
  }
  
  @Subscribe
  public void onEvent(UploadProgressEvent paramUploadProgressEvent)
  {
    if (pendingSharesUploadMap.containsKey(optimisticUpdateId))
    {
      FeedSharePublisher.PendingShare localPendingShare = (FeedSharePublisher.PendingShare)pendingSharesUploadMap.get(optimisticUpdateId);
      progress = ((int)(progressPercent * 0.8F * 100.0F));
      if (progressBar != null) {
        progressBar.setProgress(progress);
      }
    }
  }
  
  @Subscribe
  public void onEvent(FeedUpdateCreatedEvent paramFeedUpdateCreatedEvent)
  {
    ModelTransformedCallback local6 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {}
        while (feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel)) {
          return;
        }
        feedAdapter.prependValues(Collections.singletonList(viewModel));
      }
    };
    getFeedUpdateViewModel(fragmentComponent, viewPool, optimisticUpdate, local6);
    if (!pendingSharesUploadMap.containsKey(optimisticUpdate.urn.toString())) {
      pendingSharesUploadMap.put(optimisticUpdate.urn.toString(), new FeedSharePublisher.PendingShare());
    }
  }
  
  @Subscribe
  public void onEvent(FeedUpdateCreatingEvent paramFeedUpdateCreatingEvent)
  {
    pendingSharesUploadMap.put(optimisticUpdateId, new FeedSharePublisher.PendingShare());
    enqueueShareCreatingSnackbar(optimisticUpdateId);
  }
  
  @Subscribe
  public void onEvent(FeedUpdateCreationFailedEvent paramFeedUpdateCreationFailedEvent)
  {
    removePendingShare(postedUpdate.urn.toString());
    feedAdapter.removeUpdateIfFound(postedUpdate.urn.toString());
    pendingSnackbars.remove(postedUpdate.urn.toString());
  }
  
  @Subscribe
  public void onEvent(FeedUpdateCreationSuccessEvent paramFeedUpdateCreationSuccessEvent)
  {
    final Object localObject = postedUpdate.urn.toString();
    removePendingShare((String)localObject);
    localObject = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {}
        boolean bool1;
        do
        {
          return;
          boolean bool2 = feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel, localObject);
          bool1 = bool2;
          if (!bool2) {
            bool1 = feedAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
          }
        } while (bool1);
        feedAdapter.prependValues(Collections.singletonList(viewModel));
      }
    };
    getFeedUpdateViewModel(fragmentComponent, viewPool, updateFromServer, (ModelTransformedCallback)localObject);
    rateTheApp.rtaToDisplay = true;
  }
  
  @Subscribe
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    Object localObject1 = feedAdapter;
    String str = profileId;
    paramInvitationUpdatedEvent = new ArrayList();
    int i = 0;
    while (i < values.size())
    {
      Object localObject2 = (FeedItemViewModel)values.get(i);
      if ((localObject2 instanceof FeedUpdateViewModel))
      {
        localObject2 = (FeedUpdateViewModel)localObject2;
        Object localObject3;
        int j;
        if ((localObject2 instanceof FeedAggregatedConnectionUpdateViewModel))
        {
          localObject3 = actorIds;
          j = 0;
          while (j < ((List)localObject3).size())
          {
            if (TextUtils.equals((CharSequence)((List)localObject3).get(j), str)) {
              paramInvitationUpdatedEvent.add(update);
            }
            j += 1;
          }
        }
        if ((localObject2 instanceof FeedAggregatedPymkUpdateViewModel))
        {
          localObject3 = actorIds;
          j = 0;
          while (j < ((List)localObject3).size())
          {
            if (TextUtils.equals((CharSequence)((List)localObject3).get(j), str)) {
              paramInvitationUpdatedEvent.add(update);
            }
            j += 1;
          }
        }
        if ((localObject2 instanceof FeedSingleUpdateViewModel))
        {
          localObject3 = components.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)((Iterator)localObject3).next();
            if (((localFeedComponentViewModel instanceof FeedPrimaryActorViewModel)) && (TextUtils.equals(str, actorId))) {
              paramInvitationUpdatedEvent.add(update);
            }
          }
        }
      }
      i += 1;
    }
    if (!paramInvitationUpdatedEvent.isEmpty())
    {
      localObject1 = new ModelsTransformedCallback()
      {
        public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelsData)
        {
          if (!isAdded()) {}
          for (;;)
          {
            return;
            paramAnonymousModelsData = viewModels.iterator();
            while (paramAnonymousModelsData.hasNext())
            {
              FeedUpdateViewModel localFeedUpdateViewModel1 = (FeedUpdateViewModel)paramAnonymousModelsData.next();
              FeedUpdateViewModel localFeedUpdateViewModel2 = feedAdapter.getUpdateViewModel(updateUrn);
              if (localFeedUpdateViewModel2 != null) {
                feedAdapter.changeViewModel(localFeedUpdateViewModel2, localFeedUpdateViewModel1);
              }
            }
          }
        }
      };
      FeedViewTransformer.toViewModels(fragmentComponent, viewPool, paramInvitationUpdatedEvent, FeedDataModelMetadata.DEFAULT, (ModelsTransformedCallback)localObject1);
    }
  }
  
  protected final void onInitialFetchRequested(int paramInt)
  {
    super.onInitialFetchRequested(paramInt);
    if (applicationComponent.flagshipSharedPreferences().getShowCustomizingYourFeedView()) {
      showFeedLoadingView$13462e();
    }
    while ((paramInt != 3) || (!fragmentComponent.lixManager().getTreatment(Lix.FEED_NEW_SESSION_LOAD_ANIMATION).equals("mountains"))) {
      return;
    }
    feedAdapter.insertLoadingViews();
  }
  
  @OnClick({2131755798})
  public void onNewUpdatesClicked()
  {
    trackButtonShortPress("new_updates");
    performNewUpdatesClick(FeedTracking.getNUPTrackingEventForTappedPill(applicationComponent));
  }
  
  protected final void onNoMoreData()
  {
    FeedAdapter localFeedAdapter;
    FragmentComponent localFragmentComponent;
    I18NManager localI18NManager;
    String str;
    FeedEndOfFeedViewModel localFeedEndOfFeedViewModel;
    int i;
    if ((feedAdapter != null) && (!preventEndOfFeedPill) && (feedAdapter.hasUpdates()))
    {
      showNewUpdatesPill(2);
      localFeedAdapter = feedAdapter;
      localFragmentComponent = fragmentComponent;
      if ((localFragmentComponent != null) && (!localFeedAdapter.isShowingNoMoresUpdatesView()) && (localFeedAdapter.hasUpdates()))
      {
        localI18NManager = localFragmentComponent.i18NManager();
        str = localFragmentComponent.lixManager().getTreatment(Lix.FEED_END_OF_FEED);
        localFeedEndOfFeedViewModel = new FeedEndOfFeedViewModel(new FeedEndOfFeedLayout());
        i = -1;
        switch (str.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            text = localI18NManager.getString(2131231233);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localFeedAdapter.appendValue(localFeedEndOfFeedViewModel);
      new PageViewEvent(appComponent.tracker(), "feed_end", false).send();
      return;
      if (!str.equals("refresh-link-blue")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("refresh-button-gray")) {
        break;
      }
      i = 1;
      break;
      linkText = localI18NManager.getString(2131231232);
      clickListener = FeedTracking.newEndOfFeedClickListener(localFragmentComponent.tracker(), localFragmentComponent.eventBus());
      continue;
      buttonText = localI18NManager.getString(2131231232);
      clickListener = FeedTracking.newEndOfFeedClickListener(localFragmentComponent.tracker(), localFragmentComponent.eventBus());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("CameraPhotoUri", cameraPhotoUri);
    paramBundle.putBoolean("ReadHighlightedUpdates", highlightedUpdatesRead);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramBundle != null)
    {
      cameraPhotoUri = ((Uri)paramBundle.getParcelable("CameraPhotoUri"));
      highlightedUpdatesRead = paramBundle.getBoolean("ReadHighlightedUpdates");
    }
    shareHeaderManager = new FeedShareHeaderManager(fragmentComponent, appBarLayout, headerDropShadow, upperLayout, actorImage, shareHeaderHintText, fab, applicationComponent.lixManager().getTreatment(Lix.FEED_SHARE_ENTRY_POINT));
    layoutInflater = getActivity().getLayoutInflater();
    screenHeight = ViewUtils.getScreenHeight(getActivity());
    if (applicationComponent.flagshipSharedPreferences().getShowCustomizingYourFeedView()) {
      packageRecommendationTrackingHelper = new PackageRecommendationTrackingHelper(fragmentComponent, delayedExecution);
    }
    newUpdatesPill.getBackground().setAlpha(getResources().getInteger(2131558453));
    if (pillManager.shouldShowNewUpdatesPill()) {
      showNewUpdatesPill(3);
    }
    swipeRefreshLayout.setColorSchemeResources(ViewUtils.SWIPE_REFRESH_LAYOUT_COLOR_SCHEME);
    if (FeedLixHelper.isEnabled(applicationComponent.lixManager(), Lix.FEED_EASTER_EGG))
    {
      isHoldingShareButton = false;
      isHoldingCameraButton = false;
      isShowingEasterEgg = false;
      shareButton.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          default: 
            paramAnonymousView.setPressed(false);
            paramAnonymousView.removeCallbacks(easterEggRunnable);
            FeedFragment.access$002(FeedFragment.this, false);
          }
          do
          {
            do
            {
              return true;
              paramAnonymousView.setPressed(true);
              FeedFragment.access$002(FeedFragment.this, true);
            } while (!isHoldingCameraButton);
            paramAnonymousView.postDelayed(easterEggRunnable, 5000L);
            return true;
            paramAnonymousView.setPressed(false);
            paramAnonymousView.removeCallbacks(easterEggRunnable);
            FeedFragment.access$002(FeedFragment.this, false);
          } while (isShowingEasterEgg);
          paramAnonymousView.performClick();
          return true;
        }
      });
      cameraButton.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          default: 
            paramAnonymousView.setPressed(false);
            paramAnonymousView.removeCallbacks(easterEggRunnable);
            FeedFragment.access$102(FeedFragment.this, false);
          }
          do
          {
            do
            {
              return true;
              paramAnonymousView.setPressed(true);
              FeedFragment.access$102(FeedFragment.this, true);
            } while (!isHoldingShareButton);
            paramAnonymousView.postDelayed(easterEggRunnable, 5000L);
            return true;
            paramAnonymousView.setPressed(false);
            paramAnonymousView.removeCallbacks(easterEggRunnable);
            FeedFragment.access$102(FeedFragment.this, false);
          } while (isShowingEasterEgg);
          paramAnonymousView.performClick();
          return true;
        }
      });
      fab.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getActionMasked())
          {
          default: 
            paramAnonymousView.setPressed(false);
            paramAnonymousView.removeCallbacks(easterEggRunnable);
            FeedFragment.access$202(FeedFragment.this, false);
          }
          do
          {
            return true;
            paramAnonymousView.setPressed(true);
            FeedFragment.access$202(FeedFragment.this, true);
            paramAnonymousView.postDelayed(easterEggRunnable, 8000L);
            return true;
            paramAnonymousView.setPressed(false);
            paramAnonymousView.removeCallbacks(easterEggRunnable);
            FeedFragment.access$202(FeedFragment.this, false);
          } while (isShowingEasterEgg);
          paramAnonymousView.performClick();
          return true;
        }
      });
    }
    coordinatorLayout.setShouldConsumeAndForwardScrollEvents(true);
    updatesContainer.setShouldConsumeAndForwardScrollEvents(true);
    feedHeroManager = new FeedHeroManager(eventBus, this, feedUpdatesDataProvider, layoutManager, heroContainer, heroAppBarLayout);
  }
  
  public final String pageKey()
  {
    return "feed";
  }
  
  public final String refreshPageKey()
  {
    return "feed_updates";
  }
  
  protected final void resetFeedAdapter(List<? extends FeedItemViewModel> paramList)
  {
    super.resetFeedAdapter(paramList);
    if (!isAnimatingLoadingView) {
      shareHeaderManager.setShareActionsVisibility(true, true);
    }
    if (updatesContainer != null) {
      updatesContainer.setVisibility(0);
    }
    newUpdatesDivider.lastRecentUpdateUrn = null;
  }
  
  public final void scrollToTop()
  {
    RecyclerView localRecyclerView;
    FeedAdapter localFeedAdapter;
    DelayedExecution localDelayedExecution;
    if ((recyclerView != null) && (layoutManager != null) && (feedAdapter != null) && (delayedExecution != null))
    {
      RecyclerView.LayoutManager localLayoutManager = layoutManager;
      localRecyclerView = recyclerView;
      localFeedAdapter = feedAdapter;
      localDelayedExecution = delayedExecution;
      if (Math.abs(0 - com.linkedin.android.litrackinglib.utils.LayoutManagerUtils.findFirstAndLastVisiblePosition$22f1d434(localLayoutManager)[0]) > 10) {
        break label87;
      }
      localRecyclerView.smoothScrollToPosition(0);
    }
    for (;;)
    {
      shareHeaderManager.setShareActionsVisibility(true, true);
      feedHeroManager.expandFeedHeroIfAvailable();
      return;
      label87:
      localRecyclerView.smoothScrollToPosition(0);
      localDelayedExecution.postDelayedExecution(new FeedRecyclerViewUtils.1(localRecyclerView, localFeedAdapter), 500L);
    }
  }
  
  protected final void setupRecyclerView()
  {
    super.setupRecyclerView();
    recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener()
    {
      public final void onChildViewAttachedToWindow(View paramAnonymousView)
      {
        if ((paramAnonymousView.getId() == 2131755870) && (!isScrollingUp))
        {
          recyclerView.stopScroll();
          FeedFragment.access$1100(FeedFragment.this, paramAnonymousView);
        }
      }
      
      public final void onChildViewDetachedFromWindow(View paramAnonymousView) {}
    });
    recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener()
    {
      public final boolean onInterceptTouchEvent(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        if (isAnimatingScrolling)
        {
          paramAnonymousRecyclerView.requestDisallowInterceptTouchEvent(true);
          return true;
        }
        paramAnonymousRecyclerView.requestDisallowInterceptTouchEvent(false);
        return false;
      }
      
      public final void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean) {}
      
      public final void onTouchEvent$606727f8(MotionEvent paramAnonymousMotionEvent) {}
    });
    recyclerView.addItemDecoration(newUpdatesDivider);
  }
  
  protected final void setupRefreshListener()
  {
    swipeRefreshLayout.setOnRefreshListener(new PullToRefreshListener(fragmentComponent.tracker(), "feed_container")
    {
      public final void onRefresh()
      {
        super.onRefresh();
        if (pillManager.shouldShowNewUpdatesPill())
        {
          FeedFragment.this.performNewUpdatesClick(FeedTracking.getNUPTrackingEventForSwipeToRefresh(applicationComponent));
          swipeRefreshLayout.setRefreshing(false);
        }
        for (;;)
        {
          FeedFragment.this.hideNewUpdatesPill();
          return;
          swipeRefreshLayout.setRefreshing(true);
          hardRefreshFeed();
        }
      }
    });
  }
  
  protected final void setupScrollListeners()
  {
    super.setupScrollListeners();
    Object localObject = newUpdatesPill;
    RecyclerView localRecyclerView = recyclerView;
    localObject = new NewUpdatesPillButton.RecyclerViewScrollDetectorImpl((NewUpdatesPillButton)localObject, (byte)0);
    scrollThreshold = 10;
    localRecyclerView.addOnScrollListener((RecyclerView.OnScrollListener)localObject);
    recyclerView.addOnScrollListener(feedScrollListener);
  }
  
  @OnClick({2131755789, 2131755800})
  public void shareButtonClick()
  {
    trackButtonShortPress("share_update");
    openShareCreation();
  }
  
  @OnClick({2131755791})
  public void shareCameraClick()
  {
    trackButtonShortPress("share_photo");
    fragmentComponent.photoUtils().startImageChooserOrCameraForResult(this, new PhotoUtils.UriListener()
    {
      public final void onCameraDestinationUri(Uri paramAnonymousUri)
      {
        FeedFragment.access$1602(FeedFragment.this, paramAnonymousUri);
      }
    }, tracker, "take_photo", "select_photo");
  }
  
  @OnClick({2131755785})
  public void shareHeaderClick()
  {
    trackButtonShortPress("share");
    openShareCreation();
  }
  
  protected final void showEmptyMessage()
  {
    Object localObject1 = getView();
    if ((localObject1 == null) || ((feedAdapter != null) && (feedAdapter.hasUpdates()))) {
      return;
    }
    updatesContainer.setVisibility(8);
    shareHeaderManager.setShareActionsVisibility(false, false);
    if (applicationComponent.flagshipSharedPreferences().getPreferences().getBoolean("userHasBeenThroughRBMF", false)) {
      setupFeedErrorViewModel();
    }
    for (;;)
    {
      localObject1 = (ErrorPageViewHolder)errorViewModel.getCreator().createViewHolder((View)localObject1);
      Object localObject2 = errorViewModel;
      Object localObject3 = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      Object localObject4 = tracker;
      ((ErrorPageViewModel)localObject2).onBindViewHolder$49e9e35b((LayoutInflater)localObject3, (ErrorPageViewHolder)localObject1);
      new PageViewEvent((Tracker)localObject4, "feed_updates_empty", false).send();
      return;
      localObject2 = new Closure() {};
      Object localObject5 = errorViewStub;
      localObject3 = tracker;
      localObject4 = Util.getAppComponent(((ViewStub)localObject5).getContext()).i18NManager();
      localObject5 = new ErrorPageViewModel((ViewStub)localObject5);
      errorHeaderText = ((I18NManager)localObject4).getString(2131231231);
      errorDescriptionText = ((I18NManager)localObject4).getString(2131231230);
      errorButtonText = ((I18NManager)localObject4).getString(2131231229);
      errorImage = 2130838631;
      onErrorButtonClick = new FeedErrorViewModels.2((Tracker)localObject3, "rebuild", (Closure)localObject2);
      errorViewModel = ((ErrorPageViewModel)localObject5);
    }
  }
  
  public final void showErrorView(Throwable paramThrowable)
  {
    super.showErrorView(paramThrowable);
    paramThrowable = getView();
    if ((paramThrowable == null) || ((feedAdapter != null) && (feedAdapter.hasUpdates()))) {
      return;
    }
    new PageViewEvent(tracker, "feed_updates_error", false).send();
    updatesContainer.setVisibility(8);
    shareHeaderManager.setShareActionsVisibility(false, false);
    setupFeedErrorViewModel();
    paramThrowable = (ErrorPageViewHolder)errorViewModel.getCreator().createViewHolder(paramThrowable);
    ErrorPageViewModel localErrorPageViewModel = errorViewModel;
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    localErrorPageViewModel.onBindViewHolderWithErrorTracking$18b8048(localLayoutInflater, paramThrowable, tracker, getPageInstance());
  }
  
  private final class FeedLoadingAnimationListener
    implements FeedAnimationHelper.FeedAnimationListener
  {
    private FeedLoadingAnimationListener() {}
    
    public final void onAnimateRecyclerViewUpDone()
    {
      applicationComponent.flagshipSharedPreferences().setShowCustomizingYourFeedView(false);
      FeedFragment.access$702$571b359f(FeedFragment.this);
    }
    
    public final void onDismissLoadingViewDone()
    {
      if ((updatesContainer != null) && (feedLoadingView != null))
      {
        updatesContainer.removeView(feedLoadingView);
        FeedFragment.access$2502$5587b863(FeedFragment.this);
        shareHeaderManager.setShareActionsVisibility(true, true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */