package com.linkedin.android.entities.group.controllers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.group.GroupTabBundleBuilder;
import com.linkedin.android.entities.group.GroupsViewModelAdapter;
import com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer;
import com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer.1;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.entities.viewmodels.items.ButtonViewModel;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.publishing.sharing.compose.GroupSharePublisher;
import com.linkedin.android.publishing.sharing.events.GroupUpdateCreatedEvent;
import com.linkedin.android.publishing.sharing.events.GroupUpdateCreatedFailedEvent;
import com.linkedin.android.publishing.sharing.events.GroupUpdateCreatedSuccessEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class GroupDiscussionsTabFragment
  extends EntityBaseTabFragment
  implements FeedPageType
{
  GroupsViewModelAdapter discussionsAdapter;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  FeedComponentsViewPool viewPool;
  
  private void insertOrUpdateFeedUpdateViewModel(Update paramUpdate, final String paramString)
  {
    paramString = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {}
        do
        {
          return;
          if (discussionsAdapter != null) {
            discussionsAdapter.prependOrRelayoutDiscussionUpdateIfNecessary((FeedUpdateViewModel)viewModel, paramString);
          }
        } while (recyclerView == null);
        recyclerView.scrollToPosition(discussionsAdapter.discussionStartPosition);
      }
    };
    getFeedUpdateViewModel(fragmentComponent, viewPool, paramUpdate, paramString);
  }
  
  public static GroupDiscussionsTabFragment newInstance(GroupTabBundleBuilder paramGroupTabBundleBuilder)
  {
    GroupDiscussionsTabFragment localGroupDiscussionsTabFragment = new GroupDiscussionsTabFragment();
    localGroupDiscussionsTabFragment.setArguments(paramGroupTabBundleBuilder.build());
    return localGroupDiscussionsTabFragment;
  }
  
  public final int feedType()
  {
    return 6;
  }
  
  final void getFeedUpdateViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, ModelTransformedCallback paramModelTransformedCallback)
  {
    fragmentComponent.updateChangeCoordinator().listenForUpdates(paramUpdate, updateChangedListener);
    FeedViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, paramUpdate, FeedDataModelMetadata.DEFAULT, paramModelTransformedCallback);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    discussionsAdapter.showLoadingView(false);
    recyclerView.setAdapter(discussionsAdapter);
    if (isLoadedFromNetwork) {
      initImpressionTracking(discussionsAdapter);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    Object localObject1 = getActivityactivityComponent.groupDataProvider();
    boolean bool;
    Object localObject2;
    ArrayList localArrayList;
    GroupDataProvider.GroupState localGroupState;
    Group localGroup;
    if (state).groupTrackingObject != null)
    {
      bool = true;
      isLoadedFromNetwork = bool;
      viewPool = new FeedComponentsViewPool();
      localObject2 = fragmentComponent;
      paramBundle = viewPool;
      localArrayList = new ArrayList();
      localGroupState = (GroupDataProvider.GroupState)state;
      localGroup = ((GroupDataProvider.GroupState)state).group();
      if (localGroup != null) {
        break label271;
      }
      discussionsAdapter = new GroupsViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), localArrayList);
      bool = GroupHighlightsTransformer.canShowFeaturedDiscussionUpdate(((GroupDataProvider.GroupState)state).managersChoiceDiscussions());
      paramBundle = ((GroupDataProvider.GroupState)state).recentDiscussions();
      localObject1 = ((GroupDataProvider.GroupState)state).managersChoiceDiscussions();
      localObject2 = new ArrayList();
      if (CollectionUtils.isNonEmpty(paramBundle)) {
        ((List)localObject2).addAll(elements);
      }
      if (CollectionUtils.isNonEmpty((CollectionTemplate)localObject1)) {
        ((List)localObject2).addAll(elements);
      }
      fragmentComponent.updateChangeCoordinator().listenForUpdates((List)localObject2, updateChangedListener);
      paramBundle = discussionsAdapter;
      if (!bool) {
        break label487;
      }
    }
    label271:
    label487:
    for (int i = 1;; i = 0)
    {
      discussionStartPosition = i;
      return;
      bool = false;
      break;
      CollectionUtils.addItemIfNonNull(localArrayList, GroupHighlightsTransformer.toFeaturedDiscussionUpdate((FragmentComponent)localObject2, paramBundle, localGroupState.managersChoiceDiscussions(), groupTrackingObject));
      localArrayList.addAll(GroupHighlightsTransformer.toRecentDiscussionUpdates((FragmentComponent)localObject2, paramBundle, localGroupState.recentDiscussions(), groupTrackingObject));
      paramBundle = localGroupState.recentDiscussions();
      if ((CollectionUtils.isNonEmpty(paramBundle)) && (hasElements) && (elements.size() > 4))
      {
        if (state).allUpdatesHelper == null) {
          state).allUpdatesHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramBundle, Update.BUILDER, CollectionMetadata.BUILDER);
        }
        paramBundle = new ButtonViewModel();
        text = ((FragmentComponent)localObject2).i18NManager().getString(2131230924);
        clickListener = new GroupHighlightsTransformer.1(((FragmentComponent)localObject2).tracker(), "see_all", new TrackingEventBuilder[0], (FragmentComponent)localObject2, localGroup);
      }
      for (;;)
      {
        CollectionUtils.addItemIfNonNull(localArrayList, paramBundle);
        CollectionUtils.addItemIfNonNull(localArrayList, GroupHighlightsTransformer.toSimilarGroupsBrowseMapListCard((FragmentComponent)localObject2, localGroupState.similarGroups(), groupTrackingObject));
        break;
        paramBundle = null;
      }
    }
  }
  
  public final void onDestroy()
  {
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    fragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    super.onDestroy();
  }
  
  @Subscribe
  public final void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    paramUploadFailedEvent = fragmentComponent.groupsSharePublisher().onSlideShareUploadFailed(fragmentComponent, paramUploadFailedEvent, Tracker.createPageInstanceHeader(getPageInstance()));
    discussionsAdapter.removeDiscussionUpdateIfExist(paramUploadFailedEvent);
  }
  
  @Subscribe
  public final void onEvent(GroupUpdateCreatedEvent paramGroupUpdateCreatedEvent)
  {
    if (update.urn != null) {
      insertOrUpdateFeedUpdateViewModel(update, update.urn.toString());
    }
  }
  
  @Subscribe
  public final void onEvent(GroupUpdateCreatedFailedEvent paramGroupUpdateCreatedFailedEvent)
  {
    if (update.urn != null) {
      discussionsAdapter.removeDiscussionUpdateIfExist(update.urn.toString());
    }
  }
  
  @Subscribe
  public final void onEvent(GroupUpdateCreatedSuccessEvent paramGroupUpdateCreatedSuccessEvent)
  {
    applicationComponent.groupsSharePublisher().onPostGroupUpdateCreateSuccess(paramGroupUpdateCreatedSuccessEvent, fragmentComponent);
    String str;
    if (pendingUpdate.urn != null)
    {
      str = pendingUpdate.urn.toString();
      if (newUpdate == null) {
        discussionsAdapter.removeDiscussionUpdateIfExist(str);
      }
    }
    else
    {
      return;
    }
    insertOrUpdateFeedUpdateViewModel(newUpdate, str);
  }
  
  public final String pageKey()
  {
    return "group_highlights";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupDiscussionsTabFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */