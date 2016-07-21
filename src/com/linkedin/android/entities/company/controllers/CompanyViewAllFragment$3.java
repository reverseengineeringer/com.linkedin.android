package com.linkedin.android.entities.company.controllers;

import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.company.transformers.CompanyViewAllTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.List;

final class CompanyViewAllFragment$3
  extends EntityViewAllListBaseFragment.DataLoadListener<EntitiesMiniProfile>
{
  CompanyViewAllFragment$3(CompanyViewAllFragment paramCompanyViewAllFragment, TrackingObject paramTrackingObject)
  {
    super(paramCompanyViewAllFragment);
  }
  
  protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate)
  {
    return CompanyViewAllTransformer.toViewAllImmediateConnectionsList(this$0.fragmentComponent, paramCollectionTemplate, val$companyTrackingObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyViewAllFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */