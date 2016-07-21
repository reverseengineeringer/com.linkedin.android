package com.linkedin.android.entities.company.transformers;

import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.controllers.CompanyViewAllFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;

final class CompanyCardsTransformer$2
  extends TrackingClosure<Void, Void>
{
  CompanyCardsTransformer$2(Tracker paramTracker, String paramString, CompanyDataProvider paramCompanyDataProvider, InCommonPerson paramInCommonPerson, FragmentComponent paramFragmentComponent, CompanyViewAllFragment paramCompanyViewAllFragment)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyCardsTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */