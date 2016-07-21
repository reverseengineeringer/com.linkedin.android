package com.linkedin.android.identity.me.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.TabScrolledEvent;
import com.linkedin.android.home.TabSelectedEvent;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.identity.me.notifications.cards.MeBaseCardViewModel;
import com.linkedin.android.identity.me.notifications.cards.MeCardInfo;
import com.linkedin.android.identity.me.notifications.cards.MeCardTrackingViewModel;
import com.linkedin.android.identity.me.notifications.empty.MeEmptyStateAdapter;
import com.linkedin.android.identity.me.notifications.transformers.MeCardTransformer;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder.Action;
import com.linkedin.android.identity.me.shared.actions.MeActionEventManager;
import com.linkedin.android.identity.me.shared.actions.MeActionViewModelAdapterFragment;
import com.linkedin.android.identity.me.shared.actions.events.MePostExecuteActionEvent;
import com.linkedin.android.identity.me.shared.paging.CollectionDataErrorEvent;
import com.linkedin.android.identity.me.shared.paging.MeNotificationsPagingHelper;
import com.linkedin.android.identity.me.shared.util.MeTrackableViewModelArrayAdapter;
import com.linkedin.android.identity.me.shared.util.MeViewModelConsistencyFragment;
import com.linkedin.android.identity.shared.IdentityLoadingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.RecyclerViewUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarBuilder;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.FollowCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.JobUpdateActivityCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.JymbiiNotificationCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.NotificationsMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ProfinderServiceProposalNotificationCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.PropCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialActivityCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedEditCard.Builder;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropsCollectionMetadata;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.consistency.ModelListItemChangedListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.UnionMemberCountException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class NotificationsFragment
  extends ViewPagerFragment
  implements MeActionViewModelAdapterFragment<Card, ViewModel>, MeViewModelConsistencyFragment
{
  MeActionEventManager<Card, ViewModel> actionManager;
  private final Object badgeDataSubscriber = new Object()
  {
    @Subscribe
    public final void onEvent(TabSelectedEvent paramAnonymousTabSelectedEvent)
    {
      if ((tab == HomeTabInfo.NOTIFICATIONS) && (alreadySelected) && (tapSelected) && (!isDetached())) {
        RecyclerViewUtils.smoothScrollToTop(recyclerView, delayedExecution, 15);
      }
    }
    
    @Subscribe
    public final void onEvent(BadgeUpdateEvent paramAnonymousBadgeUpdateEvent)
    {
      if (("enabled".equals(applicationComponent.lixManager().getTreatment(Lix.ME_LIVE_UPDATE))) && (tabInfo == HomeTabInfo.NOTIFICATIONS))
      {
        if (prevBadgeValue != -1L) {
          break label75;
        }
        prevBadgeValue = count.longValue();
        shouldRefresh = false;
      }
      label75:
      while (prevBadgeValue == count.longValue()) {
        return;
      }
      prevBadgeValue = count.longValue();
      shouldRefresh = true;
    }
    
    @Subscribe
    public final void onEvent(CollectionDataErrorEvent paramAnonymousCollectionDataErrorEvent)
    {
      NotificationsFragment.this.onError(paramAnonymousCollectionDataErrorEvent);
    }
  };
  ModelListConsistencyCoordinator<Card> cardConsistencyCoordinator;
  ModelListItemChangedListener<Card> cardConsistencyListener = new NotificationsFragment.2(this);
  MeEmptyStateAdapter emptyStateAdapter;
  ErrorPageViewModel errorViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  InfiniteScrollListener infiniteScrollListener = new NotificationsFragment.3(this);
  boolean isVisible;
  IdentityLoadingAdapter loadingAdapter;
  MergeAdapter mergeAdapter;
  MeTrackableViewModelArrayAdapter<ViewModel> notificationsAdapter;
  RecyclerView.AdapterDataObserver notificationsObserver = new NotificationsFragment.4(this);
  long prevBadgeValue;
  @InjectView(2131756772)
  RecyclerView recyclerView;
  @InjectView(2131756771)
  SwipeRefreshLayout refreshLayout;
  protected SwipeRefreshLayout.OnRefreshListener refreshListener = new NotificationsFragment.1(this);
  boolean shouldRefresh;
  @Inject
  ViewPortManager viewPortManager;
  
  private void displayEmptyScreenIfNecessary()
  {
    recyclerView.removeOnScrollListener(infiniteScrollListener);
    if (notificationsAdapter.getItemCount() == 0)
    {
      if (!emptyStateAdapter.display) {
        emptyStateAdapter.setVisible(true);
      }
      return;
    }
    if (emptyStateAdapter.display) {
      emptyStateAdapter.setVisible(false);
    }
    recyclerView.addOnScrollListener(infiniteScrollListener);
  }
  
  protected static NotificationsDataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.notificationsDataProvider();
  }
  
  private void onError(DataStore.Type paramType, DataManagerException paramDataManagerException)
  {
    NotificationsDataProvider localNotificationsDataProvider = getActivityactivityComponent.notificationsDataProvider();
    if (paramType == DataStore.Type.NETWORK)
    {
      state).isRefreshing = false;
      com.linkedin.android.logger.Log.e(NotificationsDataProvider.TAG, "Error loading Me tab " + paramDataManagerException.toString());
    }
    if (paramType == DataStore.Type.NETWORK)
    {
      refreshLayout.setRefreshing(false);
      loadingAdapter.setLoading(false);
    }
  }
  
  private void reloadData(boolean paramBoolean)
  {
    if (((BaseActivity)getActivity() == null) || (!isResumed())) {}
    NotificationsDataProvider localNotificationsDataProvider;
    do
    {
      return;
      localNotificationsDataProvider = getActivityactivityComponent.notificationsDataProvider();
    } while (localNotificationsDataProvider == null);
    refreshLayout.setRefreshing(paramBoolean);
    Object localObject1 = loadingAdapter;
    String str;
    label87:
    Map localMap;
    int i;
    if (!paramBoolean)
    {
      bool = true;
      ((IdentityLoadingAdapter)localObject1).setLoading(bool);
      shouldRefresh = false;
      str = busSubscriberId;
      if (!paramBoolean) {
        break label264;
      }
      localObject1 = RUMHelper.pageInitRefresh(this);
      localMap = Tracker.createPageInstanceHeader(getPageInstance());
      state).isRefreshing = true;
      if (paramBoolean) {
        break label292;
      }
      if (System.currentTimeMillis() - state).lastReload <= 60000L) {
        break label273;
      }
      i = 1;
      label136:
      if (i != 0) {
        break label292;
      }
      if (!localNotificationsDataProvider.isNavV2PropsInNotifications()) {
        break label283;
      }
      if ((!localNotificationsDataProvider.isNotificationsDataAvailable()) || (!localNotificationsDataProvider.isPropsDataAvailable())) {
        break label278;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        break label292;
      }
      localObject2 = new HashSet(Arrays.asList(new String[] { state).notificationCardsRoute }));
      if (localNotificationsDataProvider.isNavV2PropsInNotifications()) {
        ((Set)localObject2).add(state).propsRoute);
      }
      activityComponent.eventBus();
      Bus.publish(new DataReceivedEvent(str, (String)localObject1, (Set)localObject2, DataStore.Type.MEMORY, null));
      return;
      bool = false;
      break;
      label264:
      localObject1 = getRumSessionId();
      break label87;
      label273:
      i = 0;
      break label136;
      label278:
      bool = false;
      continue;
      label283:
      bool = localNotificationsDataProvider.isNotificationsDataAvailable();
    }
    label292:
    if (localNotificationsDataProvider.isNavV2PropsInNotifications())
    {
      long l = activityComponent.flagshipSharedPreferences().getPreferences().getLong("propLastUpdateTimeStamp", 0L);
      state).propsRoute = RelationshipsRoutesHelper.makePropsRoute(l, "p-flagship3-notifications");
    }
    boolean bool = activityComponent.flagshipSharedPreferences().wasLastExitDueToCrash();
    if (bool)
    {
      android.util.Log.w(NotificationsDataProvider.TAG, "Previous exit was due to crash; bypassing cache and deleting cached data");
      localObject2 = activityComponent.dataManager();
      ((FlagshipDataManager)localObject2).submit(Request.delete().url(NotificationsDataProvider.NOTIFICATION_CARDS_ROUTE.toString()).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
      ((FlagshipDataManager)localObject2).submit(Request.delete().url(NotificationsDataProvider.NOTIFICATION_CARDS_ROUTE.toString()).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
    }
    if ((paramBoolean) || (bool)) {}
    for (Object localObject2 = DataManager.DataStoreFilter.NETWORK_ONLY;; localObject2 = DataManager.DataStoreFilter.ALL)
    {
      MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      localObject2 = localBuilder.filter((DataManager.DataStoreFilter)localObject2).required(Request.get().url(NotificationsDataProvider.NOTIFICATION_CARDS_ROUTE.toString()).builder(new CollectionTemplate.CollectionTemplateJsonParser(Card.BUILDER, NotificationsMetadata.BUILDER)));
      if (localNotificationsDataProvider.isNavV2PropsInNotifications()) {
        ((MultiplexRequest.Builder)localObject2).optional(Request.get().url(state).propsRoute).cacheKey("meNotificationsProps").builder(new CollectionTemplate.CollectionTemplateJsonParser(Prop.BUILDER, PropsCollectionMetadata.BUILDER)));
      }
      localNotificationsDataProvider.performMultiplexedFetch(str, (String)localObject1, localMap, (MultiplexRequest.Builder)localObject2);
      return;
    }
  }
  
  protected void clearAllBlueDots()
  {
    if (((BaseActivity)getActivity() == null) || (notificationsAdapter == null)) {
      return;
    }
    NotificationsDataProvider localNotificationsDataProvider = getActivityactivityComponent.notificationsDataProvider();
    Object localObject1 = getPageInstance();
    Object localObject3;
    label181:
    Card localCard;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    if ((localNotificationsDataProvider.isNotificationsDataAvailable()) && (state).notificationCards().hasMetadata))
    {
      localObject3 = new ArrayMap();
      ((Map)localObject3).put("onlyClearBadge", Boolean.valueOf(false));
      long l = state).notificationCards().metadata).latestPublishedAt;
      activityComponent.homeFragmentDataProvider().clearAllBadgeCountByLastUpdateTimestamp(HomeTabInfo.NOTIFICATIONS, l, Tracker.createPageInstanceHeader((PageInstance)localObject1), (Map)localObject3);
      if ((localNotificationsDataProvider.isNotificationsDataAvailable()) && (state).notificationCards().hasElements))
      {
        Iterator localIterator = state).notificationCards().elements.iterator();
        if (localIterator.hasNext())
        {
          localCard = (Card)localIterator.next();
          localObject3 = null;
          localObject4 = null;
          localObject5 = null;
          localObject6 = null;
          localObject7 = null;
          localObject8 = null;
          localObject9 = null;
          localObject10 = null;
          localObject11 = null;
          localObject12 = null;
          localObject1 = null;
        }
      }
    }
    label645:
    label664:
    label2330:
    label2336:
    label2339:
    label2342:
    label2345:
    label2348:
    label2351:
    label2354:
    label2357:
    label2360:
    label2363:
    label2366:
    for (;;)
    {
      try
      {
        if (value.profileViewCardValue == null) {
          break label664;
        }
        localObject3 = value.profileViewCardValue;
        if (read) {
          break label2336;
        }
        localObject3 = new ProfileViewCard.Builder((ProfileViewCard)localObject3);
        localObject1 = Boolean.valueOf(true);
        if (localObject1 != null) {
          break label645;
        }
        hasRead = false;
        read = false;
        localObject1 = new Card.Value.Builder();
        localObject3 = ((ProfileViewCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
        hasProfileViewCardValue = true;
        profileViewCardValue = ((ProfileViewCard)localObject3);
      }
      catch (BuilderException localBuilderException)
      {
        int j;
        activityComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(localBuilderException));
      }
      if (localObject1 == null) {
        break label181;
      }
      localObject3 = new Card.Builder(localCard);
      j = 0;
      if (hasProfileViewCardValue) {
        j = 1;
      }
      int i = j;
      if (hasAggregateProfileViewCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasEndorsementCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasFollowCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasAggregateFollowCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasSuggestedActionCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasSocialActivityCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasWvmpProfileViewCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasWvmpAnonymousProfileViewCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasWvmpPremiumUpsellCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasNewToVoyagerCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasJobUpdateActivityCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasSuggestedEditCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasJymbiiNotificationCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasProfinderServiceProposalNotificationCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasPropCardValue) {
        i = j + 1;
      }
      j = i;
      if (hasAggregatePropCardValue) {
        j = i + 1;
      }
      i = j;
      if (hasSocialUpdateAnalyticsCardValue) {
        i = j + 1;
      }
      if (i > 1)
      {
        throw new UnionMemberCountException("Value", i);
        break label181;
        hasRead = true;
        read = localBuilderException.booleanValue();
        continue;
        if (value.followCardValue != null)
        {
          localObject4 = value.followCardValue;
          localObject2 = localObject3;
          if (read) {
            break label2339;
          }
          localObject3 = new FollowCard.Builder((FollowCard)localObject4);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((FollowCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasFollowCardValue = true;
            followCardValue = ((FollowCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.endorsementCardValue != null)
        {
          localObject3 = value.endorsementCardValue;
          localObject2 = localObject4;
          if (read) {
            break label2342;
          }
          localObject3 = new EndorsementCard.Builder((EndorsementCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((EndorsementCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasEndorsementCardValue = true;
            endorsementCardValue = ((EndorsementCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.aggregateProfileViewCardValue != null)
        {
          localObject3 = value.aggregateProfileViewCardValue;
          localObject2 = localObject5;
          if (read) {
            break label2345;
          }
          localObject3 = new AggregateProfileViewCard.Builder((AggregateProfileViewCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((AggregateProfileViewCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasAggregateProfileViewCardValue = true;
            aggregateProfileViewCardValue = ((AggregateProfileViewCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.aggregateFollowCardValue != null)
        {
          localObject3 = value.aggregateFollowCardValue;
          localObject2 = localObject6;
          if (read) {
            break label2348;
          }
          localObject3 = new AggregateFollowCard.Builder((AggregateFollowCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((AggregateFollowCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasAggregateFollowCardValue = true;
            aggregateFollowCardValue = ((AggregateFollowCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.socialActivityCardValue != null)
        {
          localObject3 = value.socialActivityCardValue;
          localObject2 = localObject7;
          if (read) {
            break label2351;
          }
          localObject3 = new SocialActivityCard.Builder((SocialActivityCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((SocialActivityCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasSocialActivityCardValue = true;
            socialActivityCardValue = ((SocialActivityCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.jobUpdateActivityCardValue != null)
        {
          localObject3 = value.jobUpdateActivityCardValue;
          localObject2 = localObject8;
          if (read) {
            break label2354;
          }
          localObject3 = new JobUpdateActivityCard.Builder((JobUpdateActivityCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((JobUpdateActivityCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasJobUpdateActivityCardValue = true;
            jobUpdateActivityCardValue = ((JobUpdateActivityCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.suggestedEditCardValue != null)
        {
          localObject3 = value.suggestedEditCardValue;
          localObject2 = localObject9;
          if (read) {
            break label2357;
          }
          localObject3 = new SuggestedEditCard.Builder((SuggestedEditCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((SuggestedEditCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasSuggestedEditCardValue = true;
            suggestedEditCardValue = ((SuggestedEditCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.jymbiiNotificationCardValue != null)
        {
          localObject3 = value.jymbiiNotificationCardValue;
          localObject2 = localObject10;
          if (read) {
            break label2360;
          }
          localObject3 = new JymbiiNotificationCard.Builder((JymbiiNotificationCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((JymbiiNotificationCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasJymbiiNotificationCardValue = true;
            jymbiiNotificationCardValue = ((JymbiiNotificationCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.profinderServiceProposalNotificationCardValue != null)
        {
          localObject3 = value.profinderServiceProposalNotificationCardValue;
          localObject2 = localObject11;
          if (read) {
            break label2363;
          }
          localObject3 = new ProfinderServiceProposalNotificationCard.Builder((ProfinderServiceProposalNotificationCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((ProfinderServiceProposalNotificationCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasProfinderServiceProposalNotificationCardValue = true;
            profinderServiceProposalNotificationCardValue = ((ProfinderServiceProposalNotificationCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.propCardValue != null)
        {
          localObject3 = value.propCardValue;
          localObject2 = localObject12;
          if (read) {
            break label2366;
          }
          localObject3 = new PropCard.Builder((PropCard)localObject3);
          localObject2 = Boolean.valueOf(true);
          if (localObject2 == null) {
            hasRead = false;
          }
          for (read = false;; read = ((Boolean)localObject2).booleanValue())
          {
            localObject2 = new Card.Value.Builder();
            localObject3 = ((PropCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
            hasPropCardValue = true;
            propCardValue = ((PropCard)localObject3);
            break;
            hasRead = true;
          }
        }
        if (value.aggregatePropCardValue == null) {
          break label2330;
        }
        localObject2 = value.aggregatePropCardValue;
        if (read) {
          break label2330;
        }
        localObject3 = new AggregatePropCard.Builder((AggregatePropCard)localObject2);
        localObject2 = Boolean.valueOf(true);
        if (localObject2 == null) {
          hasRead = false;
        }
        for (read = false;; read = ((Boolean)localObject2).booleanValue())
        {
          localObject2 = new Card.Value.Builder();
          localObject3 = ((AggregatePropCard.Builder)localObject3).build(RecordTemplate.Flavor.RECORD);
          hasAggregatePropCardValue = true;
          aggregatePropCardValue = ((AggregatePropCard)localObject3);
          break;
          hasRead = true;
        }
      }
      Object localObject2 = new Card.Value(profileViewCardValue, aggregateProfileViewCardValue, endorsementCardValue, followCardValue, aggregateFollowCardValue, suggestedActionCardValue, socialActivityCardValue, wvmpProfileViewCardValue, wvmpAnonymousProfileViewCardValue, wvmpPremiumUpsellCardValue, newToVoyagerCardValue, jobUpdateActivityCardValue, suggestedEditCardValue, jymbiiNotificationCardValue, profinderServiceProposalNotificationCardValue, propCardValue, aggregatePropCardValue, socialUpdateAnalyticsCardValue, hasProfileViewCardValue, hasAggregateProfileViewCardValue, hasEndorsementCardValue, hasFollowCardValue, hasAggregateFollowCardValue, hasSuggestedActionCardValue, hasSocialActivityCardValue, hasWvmpProfileViewCardValue, hasWvmpAnonymousProfileViewCardValue, hasWvmpPremiumUpsellCardValue, hasNewToVoyagerCardValue, hasJobUpdateActivityCardValue, hasSuggestedEditCardValue, hasJymbiiNotificationCardValue, hasProfinderServiceProposalNotificationCardValue, hasPropCardValue, hasAggregatePropCardValue, hasSocialUpdateAnalyticsCardValue);
      hasValue = true;
      value = ((Card.Value)localObject2);
      activityComponent.dataManager().submit(Request.put().cacheKey(entityUrn.toString()).model(((Card.Builder)localObject3).build(RecordTemplate.Flavor.RECORD)).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
      break label181;
      localObject2 = notificationsAdapter.getValues().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ViewModel)((Iterator)localObject2).next();
        if ((localObject3 instanceof MeBaseCardViewModel))
        {
          localObject4 = (MeBaseCardViewModel)localObject3;
          if (unread)
          {
            unread = false;
            i = notificationsAdapter.getIndex(localObject3);
            if (i >= 0) {
              notificationsAdapter.notifyItemChanged(i);
            }
          }
        }
      }
      break;
      localObject2 = null;
      continue;
      continue;
      continue;
      continue;
      continue;
      continue;
      continue;
      continue;
      continue;
      continue;
    }
  }
  
  public void doEnter()
  {
    super.doEnter();
    isVisible = true;
    if ((BaseActivity)getActivity() != null)
    {
      if ((!fetchDataIfNeccessary()) && (shouldRefresh)) {
        reloadData(true);
      }
      cardConsistencyCoordinator.removeListener(cardConsistencyListener);
      actionManager.startActionHandling();
    }
    if ((viewPortManager != null) && (tracker != null)) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    actionManager.stopActionHandling();
    if ((getView() == null) || (!isAdded()) || (isDetached())) {
      return;
    }
    isVisible = false;
    clearAllBlueDots();
    viewPortManager.untrackAll();
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(badgeDataSubscriber);
    getActivityactivityComponent.notificationsDataProvider().state).isRefreshing = false;
    loadingAdapter.setLoading(false);
    refreshLayout.setRefreshing(false);
    try
    {
      notificationsAdapter.unregisterAdapterDataObserver(notificationsObserver);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(badgeDataSubscriber);
    notificationsAdapter.registerAdapterDataObserver(notificationsObserver);
    fetchDataIfNeccessary();
  }
  
  protected boolean fetchDataIfNeccessary()
  {
    if (((BaseActivity)getActivity() != null) && (isResumed()))
    {
      NotificationsDataProvider localNotificationsDataProvider = getActivityactivityComponent.notificationsDataProvider();
      if ((!notificationsAdapter.didSetValues) && (!localNotificationsDataProvider.isRefreshing())) {}
      for (int i = 1; i != 0; i = 0)
      {
        recyclerView.scrollToPosition(0);
        reloadData(false);
        return true;
      }
    }
    return false;
  }
  
  public final DataTemplateBuilder<Card> getDataModelParser()
  {
    return Card.BUILDER;
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(notificationsAdapter);
    return localArrayList;
  }
  
  public final ViewModel getViewModel(String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = notificationsAdapter.getValues().iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ViewModel)localIterator.next();
    } while ((!(localObject1 instanceof MeCardTrackingViewModel)) || (!paramString.equals(cardInfo.entityUrn.toString())));
    Object localObject1 = (MeCardTrackingViewModel)localObject1;
    return (ViewModel)localObject1;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public final void listenForCardUpdates(Card paramCard)
  {
    cardConsistencyCoordinator.listenForUpdates(paramCard, cardConsistencyListener);
  }
  
  public final String loadMorePageKey()
  {
    return "me_updates";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        paramInt2 = paramIntent.getIntExtra("targetResultCode", 0);
      } while ((paramInt1 != 31) || (paramInt2 != -1));
      localObject = paramIntent.getBundleExtra("returnBundle");
      paramInt1 = ((Bundle)localObject).getInt("ctaPreviousAction", 0);
      paramIntent = ((Bundle)localObject).getString("sharedPreferenceKey");
      localObject = ((Bundle)localObject).getString("cardEntityUrn");
      if (paramInt1 != 0) {
        fragmentComponent.flagshipSharedPreferences().saveNotificationAction(paramIntent, paramInt1);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    fragmentComponent.eventBus();
    Bus.publishStickyEvent(new MePostExecuteActionEvent((String)localObject, MeActionBundleBuilder.create(MeActionBundleBuilder.Action.UPDATE_CACHED_CARD)));
  }
  
  protected final void onCollectionDataEvent(int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2)
  {
    int i = 0;
    paramString1 = getActivityactivityComponent.notificationsDataProvider();
    boolean bool;
    if (((elements == null) || (elements.size() == 0) || ((elements.get(0) instanceof Card))) && ((metadata == null) || ((metadata instanceof NotificationsMetadata))))
    {
      if (paramString2 == null) {
        break label184;
      }
      paramInt = 1;
      if (paramType == DataStore.Type.NETWORK) {
        break label189;
      }
      bool = true;
      label89:
      if (paramInt != 0) {
        RUMTiming.renderStart(paramString2, bool, shouldAggregateMultipleRenders());
      }
      paramCollectionTemplate = elements;
      paramString1.updateNotificationCardsForUpsell(fragmentComponent, paramCollectionTemplate);
      loadingAdapter.setLoading(false);
      paramType = MeCardTransformer.toCardViewModels(state).numNotificationCardsLoaded, paramString1.getNotificationCardsWithUpsell(), fragmentComponent, paramCollectionTemplate);
      if (paramCollectionTemplate != null) {
        break label195;
      }
    }
    for (;;)
    {
      paramString1.appendNumNotificationsLoaded(i);
      notificationsAdapter.appendValues(paramType);
      if (paramInt != 0) {
        RUMHelper.callRenderEndOnNextLoop(paramString2, bool);
      }
      return;
      label184:
      paramInt = 0;
      break;
      label189:
      bool = false;
      break label89;
      label195:
      i = paramCollectionTemplate.size();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    actionManager = new MeActionEventManager(fragmentComponent, this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969120, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    onError(paramType, paramDataManagerException);
    if (paramType == DataStore.Type.NETWORK)
    {
      refreshLayout.setVisibility(8);
      paramType = (ErrorPageViewHolder)errorViewModel.getCreator().createViewHolder(getView());
      errorViewModel.errorImage = 2130838622;
      errorViewModel.errorDescriptionText = getContext().getString(2131232078);
      errorViewModel.errorButtonText = getContext().getString(2131232786);
      errorViewModel.onErrorButtonClick = new NotificationsFragment.6(this, fragmentComponent.tracker(), "error_page");
      paramSet = errorViewModel;
      paramDataManagerException = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      paramSet.onBindViewHolder$49e9e35b(paramDataManagerException, paramType);
    }
  }
  
  protected void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    refreshLayout.setVisibility(0);
    errorViewModel.remove();
    paramMap = getActivityactivityComponent.notificationsDataProvider();
    if ((paramSet != null) && (paramSet.contains(state).notificationCardsRoute)))
    {
      state).isRefreshing = false;
      if (paramType == DataStore.Type.NETWORK)
      {
        state).lastReload = System.currentTimeMillis();
        state).unseenNotificationsCleared = false;
        state).numNewPropsCleared = false;
      }
      if (((NotificationsDataProvider.NotificationsState)state).notificationCards() != null) {
        state).notificationsCardsHelper = new MeNotificationsPagingHelper(activityComponent, NotificationsDataProvider.NOTIFICATION_CARDS_ROUTE.toString(), ((NotificationsDataProvider.NotificationsState)state).notificationCards());
      }
    }
    else
    {
      if (paramSet != null) {
        break label207;
      }
    }
    label207:
    while ((!paramMap.isNotificationsDataAvailable()) || (!paramSet.contains(NotificationsDataProvider.NOTIFICATION_CARDS_ROUTE.toString())))
    {
      return;
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(NotificationsDataProvider.TAG + ": cards state is null!"));
      break;
    }
    refreshLayout.setRefreshing(false);
    loadingAdapter.setLoading(false);
    if (!paramMap.isNotificationsDataAvailable()) {
      Util.safeThrow(new RuntimeException("getNotificationCards should not be called when data is not available"));
    }
    paramSet = state).notificationCards().elements;
    if ((isVisible) && (paramType == DataStore.Type.NETWORK))
    {
      paramType = getPageInstance();
      if ((!state).unseenNotificationsCleared) && (paramMap.isNotificationsDataAvailable()) && (state).notificationCards().hasMetadata))
      {
        state).unseenNotificationsCleared = true;
        long l = state).notificationCards().metadata).latestPublishedAt;
        activityComponent.homeFragmentDataProvider().clearAllBadgeCountByLastUpdateTimestamp(HomeTabInfo.NOTIFICATIONS, l, Tracker.createPageInstanceHeader(paramType));
      }
      fragmentComponent.eventBus();
      Bus.getAndClearStickyEvent(MePostExecuteActionEvent.class);
    }
    state).numNotificationCardsLoaded = 0;
    paramMap.getNotificationCardsWithUpsell().clear();
    paramMap.updateNotificationCardsForUpsell(fragmentComponent, paramSet);
    paramType = MeCardTransformer.toCardViewModels(0L, paramMap.getNotificationCardsWithUpsell(), fragmentComponent, paramSet);
    if (paramSet == null) {}
    for (int i = 0;; i = paramSet.size())
    {
      paramMap.appendNumNotificationsLoaded(i);
      paramSet = notificationsAdapter;
      paramSet.setValues(paramType);
      didSetValues = true;
      displayEmptyScreenIfNecessary();
      return;
    }
  }
  
  public void onDestroy()
  {
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    viewPortManager.untrackAll();
    cardConsistencyCoordinator.removeListener(cardConsistencyListener);
    notificationsAdapter = null;
    loadingAdapter = null;
    mergeAdapter = null;
    recyclerView.setAdapter(null);
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(TabScrolledEvent paramTabScrolledEvent)
  {
    if ((viewPortManager != null) && (tab == HomeTabInfo.NOTIFICATIONS) && (source == 2) && (end)) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ButterKnife.inject(this, paramView);
    isVisible = false;
    shouldRefresh = false;
    prevBadgeValue = -1L;
    cardConsistencyCoordinator = new ModelListConsistencyCoordinator(fragmentComponent.consistencyManager());
    viewPortManager.container = recyclerView;
    notificationsAdapter = new MeTrackableViewModelArrayAdapter(fragmentComponent, "me_updates");
    loadingAdapter = new IdentityLoadingAdapter();
    emptyStateAdapter = new MeEmptyStateAdapter(fragmentComponent);
    mergeAdapter = new MergeAdapter();
    mergeAdapter.setViewPortManager(viewPortManager);
    mergeAdapter.addAdapter(emptyStateAdapter);
    mergeAdapter.addAdapter(notificationsAdapter);
    mergeAdapter.addAdapter(loadingAdapter);
    recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    recyclerView.setAdapter(mergeAdapter);
    paramView = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(paramView);
    refreshLayout.setOnRefreshListener(refreshListener);
    refreshLayout.setColorSchemeResources(ViewUtils.SWIPE_REFRESH_LAYOUT_COLOR_SCHEME);
    errorViewModel = new ErrorPageViewModel(errorViewStub);
    errorViewModel.remove();
  }
  
  public final String pageKey()
  {
    return "me";
  }
  
  public final void showSnackbar(String paramString, Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = getResources().getInteger(2131558478);
    if ((paramIntent != null) && (paramString != null)) {
      paramString = new NotificationsFragment.7(this, fragmentComponent.tracker(), paramString, new TrackingEventBuilder[0], paramIntent);
    }
    for (paramString = SnackbarBuilder.basic(fragmentComponent.app(), paramInt1, paramInt2, -1, paramString, i);; paramString = SnackbarBuilder.basic(fragmentComponent.app(), paramInt1, i))
    {
      fragmentComponent.snackbarUtil().showWhenAvailable(paramString);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.NotificationsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */