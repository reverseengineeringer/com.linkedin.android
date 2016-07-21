package com.linkedin.android.entities.job.controllers;

import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.job.transformers.JobViewAllTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.List;

final class JobViewAllFragment$1
  extends EntityViewAllListBaseFragment.DataLoadListener<EntitiesMiniProfile>
{
  JobViewAllFragment$1(JobViewAllFragment paramJobViewAllFragment, TrackingObject paramTrackingObject)
  {
    super(paramJobViewAllFragment);
  }
  
  protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate)
  {
    return JobViewAllTransformer.toViewAllEmployeesAtCompany(this$0.fragmentComponent, paramCollectionTemplate, val$jobTrackingObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobViewAllFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */