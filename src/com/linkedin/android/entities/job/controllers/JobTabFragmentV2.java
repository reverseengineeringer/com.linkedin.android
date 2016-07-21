package com.linkedin.android.entities.job.controllers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.JobTabBundleBuilder;
import com.linkedin.android.entities.job.transformers.JobTransformerV2;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;

public final class JobTabFragmentV2
  extends EntityBaseTabFragment
{
  public static JobTabFragmentV2 newInstance(JobTabBundleBuilder paramJobTabBundleBuilder)
  {
    JobTabFragmentV2 localJobTabFragmentV2 = new JobTabFragmentV2();
    localJobTabFragmentV2.setArguments(paramJobTabBundleBuilder.build());
    return localJobTabFragmentV2;
  }
  
  protected final String crossPromoPageKey()
  {
    return "job";
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((BaseActivity)getActivity() == null) {
      return;
    }
    JobDataProvider localJobDataProvider = getActivityactivityComponent.jobDataProvider();
    boolean bool;
    label49:
    Object localObject;
    if (state).jobTrackingObject != null)
    {
      bool = true;
      isLoadedFromNetwork = bool;
      EntityPagerAdapter.TabType localTabType = JobTabBundleBuilder.getTabType(getArguments());
      localObject = null;
      paramBundle = (Bundle)localObject;
      switch (localTabType)
      {
      default: 
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("JobTabFragment does not support this tab type: " + localTabType));
      }
    }
    for (paramBundle = (Bundle)localObject;; paramBundle = JobTransformerV2.toCardViewModels(fragmentComponent, localJobDataProvider))
    {
      paramBundle = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), paramBundle);
      recyclerView.setAdapter(paramBundle);
      if (!isLoadedFromNetwork) {
        break;
      }
      initImpressionTracking(paramBundle);
      return;
      bool = false;
      break label49;
    }
  }
  
  public final String pageKey()
  {
    EntityPagerAdapter.TabType localTabType = JobTabBundleBuilder.getTabType(getArguments());
    switch (localTabType)
    {
    default: 
      Util.safeThrow(new RuntimeException("Unable to determine page key for tab type " + localTabType));
      return "";
    case ???: 
      return "job_highlights";
    case ???: 
      return "job_details";
    }
    return "job_premium";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobTabFragmentV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */