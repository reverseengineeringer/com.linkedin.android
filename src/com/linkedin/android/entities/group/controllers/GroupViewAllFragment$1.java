package com.linkedin.android.entities.group.controllers;

import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.group.transformers.GroupDetailsTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.List;

final class GroupViewAllFragment$1
  extends EntityViewAllListBaseFragment.DataLoadListener<MiniProfileWithDistance>
{
  GroupViewAllFragment$1(GroupViewAllFragment paramGroupViewAllFragment, TrackingObject paramTrackingObject)
  {
    super(paramGroupViewAllFragment);
  }
  
  protected final List<? extends ViewModel> transformModels(CollectionTemplate<MiniProfileWithDistance, CollectionMetadata> paramCollectionTemplate)
  {
    return GroupDetailsTransformer.toViewAllMembersList(this$0.fragmentComponent, paramCollectionTemplate, val$groupTrackingObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupViewAllFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */