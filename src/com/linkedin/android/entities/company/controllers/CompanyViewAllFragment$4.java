package com.linkedin.android.entities.company.controllers;

import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.transformers.CompanyViewAllTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.List;

final class CompanyViewAllFragment$4
  extends EntityViewAllListBaseFragment.DataLoadListener<InCommonPerson>
{
  CompanyViewAllFragment$4(CompanyViewAllFragment paramCompanyViewAllFragment, CompanyDataProvider paramCompanyDataProvider, TrackingObject paramTrackingObject)
  {
    super(paramCompanyViewAllFragment);
  }
  
  protected final List<ViewModel> transformModels(CollectionTemplate<InCommonPerson, CollectionMetadata> paramCollectionTemplate)
  {
    Object localObject = ((CompanyDataProvider.CompanyState)val$dataProvider.state).company();
    if (localObject == null) {
      return null;
    }
    localObject = basicCompanyInfo.miniCompany.name;
    return CompanyViewAllTransformer.toViewAllIntroducersList(this$0.fragmentComponent, val$dataProvider, paramCollectionTemplate, (String)localObject, val$companyTrackingObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyViewAllFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */