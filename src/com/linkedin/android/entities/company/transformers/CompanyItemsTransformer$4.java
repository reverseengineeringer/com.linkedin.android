package com.linkedin.android.entities.company.transformers;

import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import java.util.Map;

final class CompanyItemsTransformer$4
  extends TrackingClosure<Boolean, Void>
{
  CompanyItemsTransformer$4(Tracker paramTracker, String paramString, CompanyDataProvider paramCompanyDataProvider, BasicCompanyInfo paramBasicCompanyInfo, Map paramMap)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyItemsTransformer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */