package com.linkedin.android.entities.group.controllers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.linkedin.android.entities.EntityUpdatesFragment;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.group.GroupUpdatesBundleBuilder;
import com.linkedin.android.entities.group.GroupsViewModelAdapter;
import com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer;
import com.linkedin.android.entities.group.transformers.GroupTransformer.1;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.entities.viewmodels.items.ButtonViewModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
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

public final class GroupUpdatesFragment
  extends EntityUpdatesFragment
{
  private GroupDataProvider dataProvider;
  private String groupUpdatesRoute;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  
  private void insertOrUpdateFeedUpdateViewModel(Update paramUpdate, final String paramString)
  {
    paramString = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (!isAdded()) {}
        GroupsViewModelAdapter localGroupsViewModelAdapter;
        do
        {
          do
          {
            return;
          } while (!(arrayAdapter instanceof GroupsViewModelAdapter));
          localGroupsViewModelAdapter = (GroupsViewModelAdapter)arrayAdapter;
          localGroupsViewModelAdapter.prependOrRelayoutDiscussionUpdateIfNecessary((FeedUpdateViewModel)viewModel, paramString);
        } while (recyclerView == null);
        recyclerView.scrollToPosition(discussionStartPosition);
      }
    };
    getFeedUpdateViewModel(fragmentComponent, paramUpdate, paramString);
  }
  
  public static GroupUpdatesFragment newInstance(GroupUpdatesBundleBuilder paramGroupUpdatesBundleBuilder)
  {
    GroupUpdatesFragment localGroupUpdatesFragment = new GroupUpdatesFragment();
    localGroupUpdatesFragment.setArguments(paramGroupUpdatesBundleBuilder.build());
    return localGroupUpdatesFragment;
  }
  
  public final int feedType()
  {
    return 6;
  }
  
  protected final EndlessViewModelAdapter getEndlessViewModelAdapter(List<ViewModel> paramList)
  {
    GroupsViewModelAdapter localGroupsViewModelAdapter = new GroupsViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), paramList);
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      discussionStartPosition = i;
      return localGroupsViewModelAdapter;
    }
  }
  
  protected final List<ViewModel> getHeaderViewModels()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = getArguments().getString("groupName");
    Object localObject2 = getArguments().getString("groupId");
    FragmentComponent localFragmentComponent = fragmentComponent;
    ButtonViewModel localButtonViewModel = new ButtonViewModel();
    text = localFragmentComponent.i18NManager().getString(2131230925);
    shouldCenterButton = true;
    clickListener = new GroupTransformer.1(localFragmentComponent.tracker(), "start_new_conversation", new TrackingEventBuilder[0], localFragmentComponent, (String)localObject1, (String)localObject2);
    CollectionUtils.addItemIfNonNull(localArrayList, localButtonViewModel);
    localObject1 = (GroupDataProvider.GroupState)dataProvider.state;
    localObject2 = ((GroupDataProvider.GroupState)localObject1).managersChoiceDiscussions();
    if (GroupHighlightsTransformer.canShowFeaturedDiscussionUpdate((CollectionTemplate)localObject2))
    {
      CollectionUtils.addItemIfNonNull(localArrayList, GroupHighlightsTransformer.toFeaturedDiscussionUpdate(fragmentComponent, viewPool, (CollectionTemplate)localObject2, groupTrackingObject));
      fragmentComponent.updateChangeCoordinator().listenForUpdates(elements, updateChangedListener);
    }
    return localArrayList;
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    new TrackingClosure(tracker, "try_again") {};
  }
  
  protected final List<ViewModel> getViewModels(List<Update> paramList)
  {
    paramList = super.getViewModels(paramList);
    List localList = fragmentComponent.groupsSharePublisher().pendingShares;
    if (localList.size() > 0) {
      paramList.addAll(super.getViewModels(localList));
    }
    return paramList;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    dataProvider = getActivityactivityComponent.groupDataProvider();
    super.onActivityCreated(paramBundle);
    arrayAdapter.showLoadingView(true);
    toolbar.setTitle(getLocalizedString(2131230911));
    groupUpdatesRoute = GroupDataProvider.getRecentUpdatesRoute(getArguments().getString("groupId"));
    dataProvider.fetchInitialGroupUpdates(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), groupUpdatesRoute);
    paramBundle = dataProvider.state).allUpdatesHelper;
    if (paramBundle != null) {
      setupLoadMoreScrollListener(paramBundle, groupUpdatesRoute);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final void onDestroy()
  {
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public final void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    paramUploadFailedEvent = fragmentComponent.groupsSharePublisher().onSlideShareUploadFailed(fragmentComponent, paramUploadFailedEvent, Tracker.createPageInstanceHeader(getPageInstance()));
    ((GroupsViewModelAdapter)arrayAdapter).removeDiscussionUpdateIfExist(paramUploadFailedEvent);
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
      ((GroupsViewModelAdapter)arrayAdapter).removeDiscussionUpdateIfExist(update.urn.toString());
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
        ((GroupsViewModelAdapter)arrayAdapter).removeDiscussionUpdateIfExist(str);
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
    return "group_recent_updates";
  }
  
  protected final List<ViewModel> setupInitialRows()
  {
    return getHeaderViewModels();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupUpdatesFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */