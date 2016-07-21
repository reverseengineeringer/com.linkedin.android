package com.linkedin.android.entities.group.transformers;

import android.content.res.Resources;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.GroupDataProvider.GroupState;
import com.linkedin.android.entities.group.controllers.GroupViewAllFragment;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GroupDetailsTransformer
{
  public static boolean canShowAdminsCard(CollectionTemplate<MiniProfileWithDistance, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate)
  {
    return !CollectionUtils.isEmpty(paramCollectionTemplate);
  }
  
  private static boolean canShowMembersCard(CollectionTemplate<MiniProfileWithDistance, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate)
  {
    return (!CollectionUtils.isEmpty(paramCollectionTemplate)) && (paging != null);
  }
  
  public static EntityListCardViewModel toGroupAdminsCard(FragmentComponent paramFragmentComponent, ActivityComponent paramActivityComponent, CollectionTemplate<MiniProfileWithDistance, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (!canShowAdminsCard(paramCollectionTemplate)) {
      return null;
    }
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.i18NManager();
    Resources localResources = paramFragmentComponent.activity().getResources();
    header = ((I18NManager)localObject).getString(2131230910);
    entityListCardMaxRows = localResources.getInteger(2131558432);
    int j = elements.size();
    localObject = new ArrayList();
    int i = 0;
    while ((i < j) && (i < entityListCardMaxRows))
    {
      MiniProfileWithDistance localMiniProfileWithDistance = (MiniProfileWithDistance)elements.get(i);
      items.add(EntityTransformer.toConnectionItem(paramFragmentComponent, paramActivityComponent, miniProfile, distance));
      EntityUtils.addObjectUrnIfNonNull((List)localObject, miniProfile.objectUrn);
      i += 1;
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localResources.getString(2131231000);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, GroupViewAllFragment.newInstance(GroupViewAllBundleBuilder.create(0)), "see_all");
    }
    trackingEventBuilderClosure = GroupTransformer.newGroupImpressionTrackingClosure(paramTrackingObject, (List)localObject, "DETAILS_" + header, "mp5huJtERPOkM8wf56WQfQ==");
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toGroupMembers(FragmentComponent paramFragmentComponent, GroupDataProvider paramGroupDataProvider, CollectionTemplate<MiniProfileWithDistance, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (!canShowMembersCard(paramCollectionTemplate)) {
      return null;
    }
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    List localList = items;
    Object localObject = paramFragmentComponent.i18NManager();
    Resources localResources = paramFragmentComponent.activity().getResources();
    header = ((I18NManager)localObject).getString(2131230928, new Object[] { Integer.valueOf(paging.total) });
    entityListCardMaxRows = localResources.getInteger(2131558432);
    int j = elements.size();
    localObject = new ArrayList();
    int i = 0;
    while ((i < j) && (i < entityListCardMaxRows))
    {
      MiniProfileWithDistance localMiniProfileWithDistance = (MiniProfileWithDistance)elements.get(i);
      localList.add(EntityTransformer.toPersonItem(paramFragmentComponent, miniProfile, false, null));
      EntityUtils.addObjectUrnIfNonNull((List)localObject, miniProfile.objectUrn);
      i += 1;
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localResources.getString(2131231000);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, GroupViewAllFragment.newInstance(GroupViewAllBundleBuilder.create(1)), "see_all");
      if (state).membersHelper == null) {
        state).membersHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramCollectionTemplate, MiniProfileWithDistance.BUILDER, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata.BUILDER);
      }
    }
    trackingEventBuilderClosure = GroupTransformer.newGroupImpressionTrackingClosure(paramTrackingObject, (List)localObject, "DETAILS_" + header, "mp5huJtERPOkM8wf56WQfQ==");
    return localEntityListCardViewModel;
  }
  
  public static List<ViewModel> toViewAllMembersList(FragmentComponent paramFragmentComponent, CollectionTemplate<MiniProfileWithDistance, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (!canShowMembersCard(paramCollectionTemplate))
    {
      paramCollectionTemplate = null;
      return paramCollectionTemplate;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = elements.iterator();
    for (;;)
    {
      paramCollectionTemplate = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (MiniProfileWithDistance)localIterator.next();
      paramCollectionTemplate = null;
      localObject = miniProfile;
      if (paramTrackingObject != null) {
        paramCollectionTemplate = GroupTransformer.newGroupImpressionTrackingClosure(paramTrackingObject, Collections.singletonList(objectUrn.toString()), firstName, trackingId);
      }
      localArrayList.add(EntityTransformer.toPersonItem(paramFragmentComponent, (MiniProfile)localObject, false, paramCollectionTemplate));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupDetailsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */