package com.linkedin.android.entities.company.controllers;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.transformers.CompanyTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;

final class CompanyFragment$1
  implements RecordTemplateListener<MiniCompany>
{
  CompanyFragment$1(CompanyFragment paramCompanyFragment) {}
  
  public final void onResponse(DataStoreResponse<MiniCompany> paramDataStoreResponse)
  {
    if ((error != null) || (model == null) || (CompanyFragment.access$000(this$0).isDataAvailable())) {
      return;
    }
    CompanyTransformer.preFillTopCard(this$0.fragmentComponent, CompanyFragment.access$100(this$0), (MiniCompany)model);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */