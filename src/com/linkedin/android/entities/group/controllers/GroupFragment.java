package com.linkedin.android.entities.group.controllers;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.EntityCoordinatorBaseFragment;
import com.linkedin.android.entities.events.GroupMemberStatusUpdateEvent;
import com.linkedin.android.entities.group.GroupBundleBuilder;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.group.GroupPagerAdapter;
import com.linkedin.android.entities.group.transformers.GroupTransformer;
import com.linkedin.android.entities.shared.AutofitTextButton;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipStatus;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipGroupViewEvent.Builder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public final class GroupFragment
  extends EntityCoordinatorBaseFragment
{
  private ActivityComponent activityComponent;
  @Inject
  ConsistencyManager consistencyManager;
  @Inject
  FlagshipDataManager dataManager;
  private GroupDataProvider groupDataProvider;
  private String groupId;
  private boolean shouldReturnToTop;
  private EntityDetailedTopCardViewHolder topCardViewHolder;
  EntityDetailedTopCardViewModel topCardViewModel;
  
  private void configureOptionsMenu()
  {
    MenuItem localMenuItem = toolbar.getMenu().findItem(2131758746);
    if (localMenuItem == null) {
      return;
    }
    Group localGroup = ((GroupDataProvider.GroupState)groupDataProvider.state).group();
    if ((localGroup != null) && (membershipInfo.status == GroupMembershipStatus.MEMBER))
    {
      localMenuItem.setVisible(true);
      return;
    }
    localMenuItem.setVisible(false);
  }
  
  public static GroupFragment newInstance(GroupBundleBuilder paramGroupBundleBuilder)
  {
    GroupFragment localGroupFragment = new GroupFragment();
    localGroupFragment.setArguments(paramGroupBundleBuilder.build());
    return localGroupFragment;
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    new TrackingClosure(tracker, "try_again") {};
  }
  
  protected final ViewHolderCreator<EntityDetailedTopCardViewHolder> getViewHolderCreator()
  {
    return EntityDetailedTopCardViewHolder.CREATOR;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    Object localObject1 = groupDataProvider.state).groupRoute;
    if ((paramSet != null) && (localObject1 != null) && (paramSet.contains(localObject1)))
    {
      localObject1 = ((GroupDataProvider.GroupState)groupDataProvider.state).group();
      if (localObject1 == null) {
        showErrorPage();
      }
    }
    else
    {
      return;
    }
    topCardViewModel = GroupTransformer.transformTopCardWithMembershipStatus(fragmentComponent, groupDataProvider, (Group)localObject1, membershipInfo.status);
    topCardViewModel.onBindViewHolder(activityComponent.activity().getLayoutInflater(), applicationComponent.mediaCenter(), topCardViewHolder);
    setTitle(basicGroupInfo.miniGroup.groupName);
    configureOptionsMenu();
    Object localObject2;
    FlagshipGroupViewEvent.Builder localBuilder;
    if (DataStore.Type.NETWORK.equals(paramType))
    {
      ((GroupDataProvider.GroupState)groupDataProvider.state).initGroupTrackingObjectFromNetwork();
      localObject1 = groupDataProvider.state).groupTrackingObject;
      if (localObject1 != null)
      {
        localObject2 = fragmentComponent.tracker();
        localBuilder = new FlagshipGroupViewEvent.Builder();
        if (localObject1 != null) {
          break label321;
        }
        hasGroup = false;
      }
    }
    for (group = null;; group = ((TrackingObject)localObject1))
    {
      ((Tracker)localObject2).send(localBuilder);
      localObject1 = new GroupPagerAdapter(fragmentComponent, getChildFragmentManager(), groupDataProvider);
      setupTabs((FragmentReferencingPagerAdapter)localObject1);
      if (!shouldReturnToTop) {
        break label342;
      }
      appBarLayout.setExpanded(true);
      collapsingToolbarLayout.setTitle(null);
      int i = 0;
      while (i < ((GroupPagerAdapter)localObject1).getCount())
      {
        localObject2 = ((GroupPagerAdapter)localObject1).getItemAtPosition(i);
        if ((localObject2 instanceof EntityBaseTabFragment)) {
          ((EntityBaseTabFragment)localObject2).scrollRecyclerToPosition$13462e();
        }
        i += 1;
      }
      label321:
      hasGroup = true;
    }
    shouldReturnToTop = false;
    label342:
    super.onDataReady(paramType, paramSet, paramMap);
  }
  
  @Subscribe
  public final void onEvent(GroupMemberStatusUpdateEvent paramGroupMemberStatusUpdateEvent)
  {
    if (isResponsePending)
    {
      topCardViewHolder.primaryButton.setEnabled(false);
      topCardViewHolder.secondaryButton.setEnabled(false);
    }
    Group localGroup;
    do
    {
      return;
      if (reloadPageOnResponse)
      {
        shouldReturnToTop = true;
        groupDataProvider.fetchData(busSubscriberId, getRumSessionId(), groupId, Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.NETWORK_ONLY);
        return;
      }
      localGroup = ((GroupDataProvider.GroupState)groupDataProvider.state).group();
    } while (localGroup == null);
    topCardViewModel = GroupTransformer.transformTopCardWithMembershipStatus(fragmentComponent, groupDataProvider, localGroup, memberStatus);
    topCardViewModel.onBindViewHolder(activityComponent.activity().getLayoutInflater(), applicationComponent.mediaCenter(), topCardViewHolder);
  }
  
  protected final boolean onMenuClick(MenuItem paramMenuItem)
  {
    Group localGroup = ((GroupDataProvider.GroupState)groupDataProvider.state).group();
    if ((paramMenuItem.getItemId() == 2131758746) && (localGroup != null))
    {
      paramMenuItem = fragmentComponent;
      GroupTransformer.fireGroupActionEvent(groupDataProvider, paramMenuItem, ActionCategory.LEAVE, "control_menu_group_leave");
      trackButtonShortPress("control_menu_group_leave");
      paramMenuItem = groupDataProvider;
      Map localMap = Tracker.createPageInstanceHeader(tracker.getCurrentPageInstance());
      paramMenuItem.sendRequestWithToastOnSuccess$676845c5(GroupDataProvider.buildActionRouteForGroup(basicGroupInfo.miniGroup.entityUrn.getId(), "leave"), localMap, localGroup, 2131230917, true);
      return true;
    }
    return super.onMenuClick(paramMenuItem);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    activityComponent = getActivityactivityComponent;
    groupDataProvider = activityComponent.groupDataProvider();
    groupId = getArguments().getString("getGroupId");
    topCardViewHolder = ((EntityDetailedTopCardViewHolder)EntityDetailedTopCardViewHolder.CREATOR.createViewHolder(topCard));
    if (((GroupDataProvider.GroupState)groupDataProvider.state).group() != null) {}
    for (int i = 1; i != 0; i = 0)
    {
      onDataReady(DataStore.Type.LOCAL, Collections.singleton(groupDataProvider.state).groupRoute), null);
      return;
    }
    loadingSpinner.setVisibility(0);
    groupDataProvider.fetchData(busSubscriberId, getRumSessionId(), groupId, Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.ALL);
  }
  
  public final String pageKey()
  {
    return "group";
  }
  
  protected final void setupToolbar()
  {
    super.setupToolbar();
    toolbar.inflateMenu(2131820545);
    configureOptionsMenu();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */