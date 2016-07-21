package com.linkedin.android.entities.group.controllers;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.EntityViewAllListBaseFragment;
import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.group.transformers.GroupDetailsTransformer;
import com.linkedin.android.entities.group.transformers.GroupTransformer;
import com.linkedin.android.entities.group.transformers.GroupViewAllBundleBuilder;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GroupViewAllFragment
  extends EntityViewAllListBaseFragment
  implements FeedPageType
{
  private ActivityComponent activityComponent;
  private FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  
  public static GroupViewAllFragment newInstance(GroupViewAllBundleBuilder paramGroupViewAllBundleBuilder)
  {
    GroupViewAllFragment localGroupViewAllFragment = new GroupViewAllFragment();
    localGroupViewAllFragment.setArguments(paramGroupViewAllBundleBuilder.build());
    return localGroupViewAllFragment;
  }
  
  public final int feedType()
  {
    return 6;
  }
  
  protected final EntityViewAllListBaseFragment.DataLoadListener getDataLoadListener()
  {
    final Object localObject = activityComponent.groupDataProvider();
    int i = getArguments().getInt("pageType");
    localObject = state).groupTrackingObject;
    switch (i)
    {
    default: 
      return null;
    }
    new EntityViewAllListBaseFragment.DataLoadListener((TrackingObject)localObject)
    {
      protected final List<? extends ViewModel> transformModels(CollectionTemplate<MiniProfileWithDistance, CollectionMetadata> paramAnonymousCollectionTemplate)
      {
        return GroupDetailsTransformer.toViewAllMembersList(fragmentComponent, paramAnonymousCollectionTemplate, localObject);
      }
    };
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    return null;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    activityComponent = getActivityactivityComponent;
    shouldTrackImpressions = EntityUtils.isLixEnabled(fragmentComponent.lixManager(), Lix.ENTITIES_SEE_ALL_ITEM_IMPRESSION_TRACKING);
    super.onActivityCreated(paramBundle);
  }
  
  public final String pageKey()
  {
    int i = getArguments().getInt("pageType");
    switch (i)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to determine page key for view all page type " + i));
      return "";
    case 0: 
      return "group_admins";
    }
    return "group_members";
  }
  
  protected final List<ViewModel> setupInitialRows()
  {
    Object localObject2 = activityComponent.groupDataProvider();
    int i = getArguments().getInt("pageType");
    TrackingObject localTrackingObject = state).groupTrackingObject;
    CollectionTemplateHelper localCollectionTemplateHelper = null;
    String str = null;
    Object localObject1 = null;
    switch (i)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("GroupViewAllFragment does not support this page type: " + i));
      if (CollectionUtils.isEmpty((Collection)localObject1)) {
        showErrorPage();
      }
      break;
    }
    while ((localCollectionTemplateHelper == null) || (str == null))
    {
      return (List<ViewModel>)localObject1;
      toolbar.setTitle(getLocalizedString(2131230910));
      localObject1 = ((GroupDataProvider.GroupState)state).admins();
      FragmentComponent localFragmentComponent = fragmentComponent;
      ActivityComponent localActivityComponent = activityComponent;
      if (!GroupDetailsTransformer.canShowAdminsCard((CollectionTemplate)localObject1))
      {
        localObject1 = null;
        break;
      }
      localObject2 = new ArrayList();
      Iterator localIterator = elements.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        MiniProfileWithDistance localMiniProfileWithDistance = (MiniProfileWithDistance)localIterator.next();
        localObject1 = null;
        MiniProfile localMiniProfile = miniProfile;
        if (localTrackingObject != null) {
          localObject1 = GroupTransformer.newGroupImpressionTrackingClosure(localTrackingObject, Collections.singletonList(objectUrn.toString()), firstName, trackingId);
        }
        ((List)localObject2).add(EntityTransformer.toConnectionItem(localFragmentComponent, localActivityComponent, localMiniProfile, distance, (Closure)localObject1));
      }
      localObject1 = ((GroupDataProvider.GroupState)state).members();
      localObject1 = GroupDetailsTransformer.toViewAllMembersList(fragmentComponent, (CollectionTemplate)localObject1, localTrackingObject);
      if (localObject1 != null) {
        toolbar.setTitle(getLocalizedString(2131230918));
      }
      localCollectionTemplateHelper = state).membersHelper;
      str = state).membersRoute;
      break;
    }
    setupLoadMoreScrollListener(localCollectionTemplateHelper, str);
    return (List<ViewModel>)localObject1;
  }
  
  protected final void setupItemDividers()
  {
    switch (getArguments().getInt("pageType"))
    {
    default: 
      return;
    }
    super.setupItemDividers();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupViewAllFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */