package com.linkedin.android.entities.school.controllers;

import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.school.transformers.SchoolViewAllTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.List;

final class SchoolViewAllFragment$1
  extends EntityViewAllListBaseFragment.DataLoadListener<EntitiesMiniProfile>
{
  SchoolViewAllFragment$1(SchoolViewAllFragment paramSchoolViewAllFragment, TrackingObject paramTrackingObject)
  {
    super(paramSchoolViewAllFragment);
  }
  
  protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate)
  {
    return SchoolViewAllTransformer.toFirstDegreeStudentsAndAlumniViewAllList(this$0.fragmentComponent, SchoolViewAllFragment.access$000(this$0), paramCollectionTemplate, val$schoolTrackingObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.controllers.SchoolViewAllFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */