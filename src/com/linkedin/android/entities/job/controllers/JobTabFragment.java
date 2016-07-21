package com.linkedin.android.entities.job.controllers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.JobTabBundleBuilder;
import com.linkedin.android.entities.job.transformers.JobTransformer;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobSections;
import java.util.Collection;
import java.util.List;

@Deprecated
public final class JobTabFragment
  extends EntityBaseTabFragment
{
  public static JobTabFragment newInstance(JobTabBundleBuilder paramJobTabBundleBuilder)
  {
    JobTabFragment localJobTabFragment = new JobTabFragment();
    localJobTabFragment.setArguments(paramJobTabBundleBuilder.build());
    return localJobTabFragment;
  }
  
  protected final String crossPromoPageKey()
  {
    return "job";
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    FragmentComponent localFragmentComponent = null;
    Object localObject1 = null;
    super.onActivityCreated(paramBundle);
    if ((BaseActivity)getActivity() == null) {
      label20:
      return;
    }
    JobDataProvider localJobDataProvider = getActivityactivityComponent.jobDataProvider();
    if (state).jobTrackingObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      isLoadedFromNetwork = bool;
      localObject2 = JobTabBundleBuilder.getTabType(getArguments());
      paramBundle = null;
      switch (localObject2)
      {
      default: 
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("JobTabFragment does not support this tab type: " + localObject2));
        paramBundle = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), paramBundle);
        recyclerView.setAdapter(paramBundle);
        if (!isLoadedFromNetwork) {
          break label20;
        }
        initImpressionTracking(paramBundle);
        return;
      }
    }
    localObject1 = fragmentComponent;
    paramBundle = ((JobDataProvider.JobState)state).job();
    if ((paramBundle == null) || (sections == null) || (sections.highlights == null)) {}
    for (paramBundle = null;; paramBundle = sections.highlights.items)
    {
      paramBundle = JobTransformer.toCardViewModels((FragmentComponent)localObject1, localJobDataProvider, paramBundle);
      break;
    }
    localFragmentComponent = fragmentComponent;
    Object localObject2 = ((JobDataProvider.JobState)state).job();
    paramBundle = (Bundle)localObject1;
    if (localObject2 != null)
    {
      paramBundle = (Bundle)localObject1;
      if (sections != null) {
        if (sections.details != null) {
          break label310;
        }
      }
    }
    label310:
    for (paramBundle = (Bundle)localObject1;; paramBundle = sections.details.items)
    {
      paramBundle = JobTransformer.toCardViewModels(localFragmentComponent, localJobDataProvider, paramBundle);
      break;
    }
    localObject1 = fragmentComponent;
    localObject2 = ((JobDataProvider.JobState)state).job();
    paramBundle = localFragmentComponent;
    if (localObject2 != null)
    {
      paramBundle = localFragmentComponent;
      if (sections != null) {
        if (sections.insights != null) {
          break label430;
        }
      }
    }
    label430:
    for (paramBundle = localFragmentComponent;; paramBundle = sections.insights.items)
    {
      localObject1 = JobTransformer.toCardViewModels((FragmentComponent)localObject1, localJobDataProvider, paramBundle);
      paramBundle = (Bundle)localObject1;
      if (!CollectionUtils.isEmpty((Collection)localObject1)) {
        break;
      }
      paramBundle = fragmentComponent.i18NManager().getString(2131230962);
      ((List)localObject1).add(EntityTransformer.noCardsEmptyState(fragmentComponent, paramBundle, 2130838512));
      paramBundle = (Bundle)localObject1;
      break;
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
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobTabFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */