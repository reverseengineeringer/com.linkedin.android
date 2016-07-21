package com.linkedin.android.entities.company.transformers;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.linkedin.android.entities.company.CompanyUpdatesBundleBuilder;
import com.linkedin.android.entities.company.controllers.CompanyUpdatesFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CompanyCardsTransformer$3
  extends TrackingOnClickListener
{
  CompanyCardsTransformer$3(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Company paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = val$fragmentComponent.activity().getPageFragmentTransaction();
    String str = val$company.basicCompanyInfo.miniCompany.entityUrn.getId();
    Bundle localBundle = new Bundle();
    localBundle.putString("companyId", str);
    paramView.replace(2131756509, CompanyUpdatesFragment.newInstance(new CompanyUpdatesBundleBuilder(localBundle))).addToBackStack(null).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyCardsTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */