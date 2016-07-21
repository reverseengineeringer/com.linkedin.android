package com.linkedin.android.entities.company.transformers;

import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import java.util.Map;

final class CompanyTransformer$1
  extends TrackingClosure<Boolean, Void>
{
  CompanyTransformer$1(Tracker paramTracker, String paramString, Company paramCompany, CompanyDataProvider paramCompanyDataProvider, FragmentComponent paramFragmentComponent, MiniCompany paramMiniCompany, Map paramMap)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */