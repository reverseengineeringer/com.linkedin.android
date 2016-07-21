package com.linkedin.android.entities.group.controllers;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.group.GroupTabBundleBuilder;
import com.linkedin.android.entities.group.transformers.GroupDetailsTransformer;
import com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer;
import com.linkedin.android.entities.group.transformers.GroupTransformer;
import com.linkedin.android.entities.viewmodels.cards.EntitySingleCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.List;

public final class GroupTabFragment
  extends EntityBaseTabFragment
{
  public static GroupTabFragment newInstance(GroupTabBundleBuilder paramGroupTabBundleBuilder)
  {
    GroupTabFragment localGroupTabFragment = new GroupTabFragment();
    localGroupTabFragment.setArguments(paramGroupTabBundleBuilder.build());
    return localGroupTabFragment;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.groupDataProvider();
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((BaseActivity)getActivity() == null) {
      label15:
      return;
    }
    GroupDataProvider localGroupDataProvider = getActivityactivityComponent.groupDataProvider();
    if (state).groupTrackingObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      isLoadedFromNetwork = bool;
      localObject1 = GroupTabBundleBuilder.getTabType(getArguments());
      paramBundle = null;
      switch (localObject1)
      {
      default: 
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("GroupTabFragment does not support this tab type: " + localObject1));
        paramBundle = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), paramBundle);
        recyclerView.setAdapter(paramBundle);
        if (!isLoadedFromNetwork) {
          break label15;
        }
        initImpressionTracking(paramBundle);
        return;
      }
    }
    FragmentComponent localFragmentComponent = fragmentComponent;
    ActivityComponent localActivityComponent = getActivityactivityComponent;
    TrackingObject localTrackingObject = state).groupTrackingObject;
    Object localObject1 = new ArrayList();
    Object localObject2 = ((GroupDataProvider.GroupState)state).group();
    label240:
    label256:
    int i;
    if (localObject2 != null)
    {
      if (hasDescription) {
        break label379;
      }
      paramBundle = null;
      CollectionUtils.addItemIfNonNull((List)localObject1, paramBundle);
      if (hasRules) {
        break label483;
      }
      paramBundle = null;
      CollectionUtils.addItemIfNonNull((List)localObject1, paramBundle);
      if ((!hasOwner) || (owner == null)) {
        break label588;
      }
      i = 1;
      label280:
      if (i != 0) {
        break label593;
      }
      paramBundle = null;
    }
    for (;;)
    {
      CollectionUtils.addItemIfNonNull((List)localObject1, paramBundle);
      CollectionUtils.addItemIfNonNull((List)localObject1, GroupDetailsTransformer.toGroupAdminsCard(localFragmentComponent, localActivityComponent, ((GroupDataProvider.GroupState)state).admins(), localTrackingObject));
      CollectionUtils.addItemIfNonNull((List)localObject1, GroupDetailsTransformer.toGroupMembers(localFragmentComponent, localGroupDataProvider, ((GroupDataProvider.GroupState)state).members(), localTrackingObject));
      if (!GroupTransformer.canShowConversationsTab(localGroupDataProvider)) {
        CollectionUtils.addItemIfNonNull((List)localObject1, GroupHighlightsTransformer.toSimilarGroupsBrowseMapListCard(localFragmentComponent, ((GroupDataProvider.GroupState)state).similarGroups(), localTrackingObject));
      }
      paramBundle = (Bundle)localObject1;
      break;
      label379:
      paramBundle = new ParagraphCardViewModel();
      header = localFragmentComponent.i18NManager().getString(2131230907);
      body = description;
      maxLinesCollapsed = localFragmentComponent.activity().getResources().getInteger(2131558439);
      onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(localFragmentComponent.tracker(), "see_more");
      trackingEventBuilderClosure = GroupTransformer.newGroupImpressionTrackingClosure(localTrackingObject, null, "DETAILS_" + header, "mp5huJtERPOkM8wf56WQfQ==");
      break label240;
      label483:
      paramBundle = new ParagraphCardViewModel();
      header = localFragmentComponent.i18NManager().getString(2131230923);
      body = rules;
      maxLinesCollapsed = localFragmentComponent.activity().getResources().getInteger(2131558439);
      onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(localFragmentComponent.tracker(), "see_more");
      trackingEventBuilderClosure = GroupTransformer.newGroupImpressionTrackingClosure(localTrackingObject, null, "DETAILS_" + header, "mp5huJtERPOkM8wf56WQfQ==");
      break label256;
      label588:
      i = 0;
      break label280;
      label593:
      localObject2 = owner;
      I18NManager localI18NManager = localFragmentComponent.i18NManager();
      paramBundle = new EntitySingleCardViewModel();
      header = localI18NManager.getString(2131230919);
      itemViewModel = EntityTransformer.toConnectionItem(localFragmentComponent, localActivityComponent, miniProfile, distance);
      trackingEventBuilderClosure = GroupTransformer.newGroupImpressionTrackingClosure(localTrackingObject, null, "DETAILS_" + header, "mp5huJtERPOkM8wf56WQfQ==");
    }
  }
  
  public final String pageKey()
  {
    EntityPagerAdapter.TabType localTabType = GroupTabBundleBuilder.getTabType(getArguments());
    switch (localTabType)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to determine page key for tab type " + localTabType));
      return "";
    }
    return "group_details";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupTabFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */