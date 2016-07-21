package com.linkedin.android.feed.channel;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.events.UpdateExpandEvent;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ChannelFragment
  extends FeedTrackableFragment
  implements FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider
{
  public static final String TAG = ChannelFragment.class.getSimpleName();
  private ActivityComponent activityComponent;
  Channel channel;
  @InjectView(2131755587)
  ImageView channelBackgroundView;
  private ConsistencyManagerListener channelChangeListener;
  @InjectView(2131755592)
  Button channelFollowButton;
  @InjectView(2131755593)
  ImageView channelLogoView;
  @InjectView(2131755590)
  TextView channelNameView;
  @InjectView(2131755583)
  RecyclerView channelRecyclerView;
  @InjectView(2131755586)
  Toolbar channelToolbar;
  private FeedAdapter channelUpdatesAdapter;
  ChannelUpdatesDataProvider channelUpdatesDataProvider;
  @InjectView(2131755585)
  CollapsingToolbarLayout collapsingToolbarLayout;
  @Inject
  ConsistencyManager consistencyManager;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  Bus eventBus;
  @Inject
  FollowPublisher followPublisher;
  @InjectView(2131755591)
  TextView followerCountView;
  @Inject
  I18NManager i18NManager;
  LinearLayoutManager layoutManager;
  private boolean startedWithZeroFollowers;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  private FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  @Inject
  ViewPortManager viewportManager;
  
  private void collapseUpdate(UpdateActionEvent paramUpdateActionEvent)
  {
    Update localUpdate = update;
    paramUpdateActionEvent = updateAction;
    ModelTransformedCallback local9 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {
          return;
        }
        channelUpdatesAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
      }
    };
    FragmentComponent localFragmentComponent = fragmentComponent;
    localFragmentComponent.updateChangeCoordinator().setCollapsed(urn, paramUpdateActionEvent);
    FeedViewTransformer.toCollapsedViewModel(localFragmentComponent, viewPool, localUpdate, paramUpdateActionEvent, local9);
  }
  
  private void getFeedUpdateViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, ModelTransformedCallback paramModelTransformedCallback)
  {
    fragmentComponent.updateChangeCoordinator().listenForUpdates(paramUpdate, updateChangedListener);
    FeedViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, paramUpdate, FeedDataModelMetadata.DEFAULT, paramModelTransformedCallback);
  }
  
  private void updateFollowButtonState()
  {
    if (channel == null) {
      return;
    }
    String str;
    Drawable localDrawable;
    if (channel.followingInfo.following)
    {
      str = getResources().getString(2131231129);
      localDrawable = ContextCompat.getDrawable(getContext(), 2130837817);
    }
    for (int i = ContextCompat.getColor(getContext(), 2131623940);; i = ContextCompat.getColor(getContext(), 2131624322))
    {
      channelFollowButton.setText(str);
      JellyBeanUtils.setBackground(channelFollowButton, localDrawable);
      channelFollowButton.setTextColor(i);
      return;
      str = getResources().getString(2131231127);
      localDrawable = ContextCompat.getDrawable(getContext(), 2130837816);
    }
  }
  
  private void updateFollowCountText()
  {
    if (channel == null) {
      return;
    }
    if ((channel.followingInfo.followerCount <= 0) || (startedWithZeroFollowers)) {}
    for (Object localObject = null;; localObject = i18NManager.getString(2131231128, new Object[] { Integer.valueOf(channel.followingInfo.followerCount) }))
    {
      ViewUtils.setTextAndUpdateVisibility(followerCountView, (CharSequence)localObject);
      return;
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (channelUpdatesAdapter != null) {
      channelUpdatesAdapter.onScreen = true;
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (channelUpdatesAdapter != null) {
      channelUpdatesAdapter.onLeave();
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    viewportManager.untrackAll();
  }
  
  public final void doResume()
  {
    super.doResume();
    updateFollowButtonState();
  }
  
  public final String enterPageKey()
  {
    return "feed_channel_updates";
  }
  
  public final int feedType()
  {
    return 3;
  }
  
  @OnClick({2131755592})
  public void handleFollowChannelClick()
  {
    trackButtonShortPress("channel_follow_toggle");
    if (channel != null) {
      followPublisher.toggleFollow(channel.entityUrn.getId(), Routes.CHANNELS, channel.followingInfo, Tracker.createPageInstanceHeader(getPageInstance()));
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return "feed_channel_updates";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    if ((BaseActivity)getActivity() != null)
    {
      activityComponent = getActivityactivityComponent;
      channelUpdatesDataProvider = activityComponent.channelUpdatesDataProvider();
      channelUpdatesDataProvider.addListener(new CollectionDataProvider.CollectionDataProviderListener()
      {
        public final void onDataFinishedLoading(DataStore.Type paramAnonymousType, DataManagerException paramAnonymousDataManagerException) {}
        
        public final void onFetching()
        {
          channelUpdatesAdapter.showLoadingView(true);
        }
        
        public final void onFinishedFetching()
        {
          channelUpdatesAdapter.showLoadingView(false);
        }
      });
    }
    paramBundle = getArguments();
    if (paramBundle != null) {
      channel = ((Channel)RecordParceler.quietUnparcel(Channel.BUILDER, "channel", paramBundle));
    }
    if (channel != null) {
      if (channel.followingInfo.followerCount != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      startedWithZeroFollowers = bool;
      channelChangeListener = new DefaultConsistencyListener(channel) {};
      consistencyManager.listenForUpdates(channelChangeListener);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968707, paramViewGroup, false);
    ButterKnife.inject(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    consistencyManager.removeListener(channelChangeListener);
    fragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(UpdateActionEvent paramUpdateActionEvent)
  {
    if (!isActive) {
      return;
    }
    final Update localUpdate = update;
    final UpdateActionModel localUpdateActionModel = updateAction;
    final FragmentComponent localFragmentComponent = fragmentComponent;
    switch (type)
    {
    }
    for (;;)
    {
      UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, urn.toString(), localUpdateActionModel, localUpdate);
      return;
      UpdateActionPublisher.showDeleteConfirmationDialog$79962340(localFragmentComponent, new UpdateActionPublisher.DeleteUpdateActionListener()
      {
        public final void onDeleteUpdateAction()
        {
          ChannelFragment.access$600(ChannelFragment.this, localUpdateurn.toString());
          UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(getPageInstance()), localFragmentComponent, localUpdateurn.toString(), localUpdateActionModel, localUpdate);
        }
      });
      return;
      viewportManager.untrackAll();
      channelUpdatesAdapter.clear();
      paramUpdateActionEvent = RUMHelper.pageInitRefresh(this);
      channelUpdatesDataProvider.refreshFeed(Tracker.createPageInstanceHeader(getPageInstance()), FeedRouteUtils.getChannelMiniFeedRoute(fragmentComponent, channel.entityUrn.getId()), paramUpdateActionEvent);
      return;
      collapseUpdate(paramUpdateActionEvent);
      return;
      collapseUpdate(paramUpdateActionEvent);
    }
  }
  
  @Subscribe
  public void onEvent(UpdateExpandEvent paramUpdateExpandEvent)
  {
    ModelTransformedCallback local8 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {
          return;
        }
        channelUpdatesAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel);
      }
    };
    if (update.urn != null)
    {
      fragmentComponent.updateChangeCoordinator().setExpanded(update.urn);
      getFeedUpdateViewModel(fragmentComponent, viewPool, update, local8);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = (BaseActivity)getActivity();
    if ((channel == null) || (paramView == null))
    {
      getActivity().onBackPressed();
      return;
    }
    if (channel != null)
    {
      channelNameView.setText(channel.name);
      updateFollowButtonState();
      updateFollowCountText();
      paramView = GhostImageUtils.getUnstructuredCompany(2131492963);
      new ImageModel(channel.logo, paramView, Util.retrieveRumSessionId(fragmentComponent)).setImageView(applicationComponent.mediaCenter(), channelLogoView);
      if (channel.backgroundImage != null) {
        applicationComponent.mediaCenter().load(channel.backgroundImage).into(channelBackgroundView);
      }
    }
    viewportManager.container = channelRecyclerView;
    if (channelUpdatesAdapter == null)
    {
      channelUpdatesAdapter = new FeedAdapter(activityComponent.context(), applicationComponent, this);
      channelUpdatesAdapter.setViewPortManager(viewportManager);
    }
    if (layoutManager == null) {
      layoutManager = new LinearLayoutManager(getActivity());
    }
    channelRecyclerView.setAdapter(channelUpdatesAdapter);
    channelRecyclerView.setLayoutManager(layoutManager);
    channelRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
    {
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        paramAnonymousRecyclerView = ChannelFragment.this;
        if (layoutManager.findLastVisibleItemPosition() == layoutManager.getItemCount() - 1)
        {
          String str = RUMHelper.pageInitLoadMore(paramAnonymousRecyclerView);
          channelUpdatesDataProvider.loadMoreData$727f7092(Tracker.createPageInstanceHeader(paramAnonymousRecyclerView.getPageInstance()), str, FeedRouteUtils.getBaseChannelMiniFeedRoute(fragmentComponent, channel.entityUrn.getId()));
        }
      }
    });
    paramView = new RecyclerViewPortListener(viewportManager);
    channelRecyclerView.addOnScrollListener(paramView);
    channelToolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        NavigationUtils.onUpPressed(getActivity(), false);
      }
    });
    if (channel != null) {
      collapsingToolbarLayout.setTitle(channel.name);
    }
    channelUpdatesDataProvider.channelId = channel.entityUrn.getId();
    channelUpdatesDataProvider.performInitialFetch(Tracker.createPageInstanceHeader(getPageInstance()), 2, getRumSessionId(), FeedRouteUtils.getChannelMiniFeedRoute(fragmentComponent, channel.entityUrn.getId()));
  }
  
  public final String pageKey()
  {
    return "feed_channel";
  }
  
  public final String provideDebugData()
  {
    if (channel != null) {
      return "Channel Id: " + channel.entityUrn.getId();
    }
    return null;
  }
  
  public final String refreshPageKey()
  {
    return "feed_channel_updates";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.channel.ChannelFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */