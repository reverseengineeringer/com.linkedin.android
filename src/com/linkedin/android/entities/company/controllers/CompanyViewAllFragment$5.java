package com.linkedin.android.entities.company.controllers;

import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.company.transformers.CompanyViewAllTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.List;

final class CompanyViewAllFragment$5
  extends EntityViewAllListBaseFragment.DataLoadListener<InCommonCompany>
{
  CompanyViewAllFragment$5(CompanyViewAllFragment paramCompanyViewAllFragment, TrackingObject paramTrackingObject)
  {
    super(paramCompanyViewAllFragment);
  }
  
  protected final List<ViewModel> transformModels(CollectionTemplate<InCommonCompany, CollectionMetadata> paramCollectionTemplate)
  {
    return CompanyViewAllTransformer.toViewAllCommonCompaniesAlumniList(this$0.fragmentComponent, paramCollectionTemplate, val$companyTrackingObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyViewAllFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */