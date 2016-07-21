package com.linkedin.android.entities.job;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.entities.EntityPagerAdapter;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.job.controllers.JobTabFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobSections;
import java.util.ArrayList;
import java.util.List;

public final class JobPagerAdapter
  extends EntityPagerAdapter
{
  private final JobDataProvider jobDataProvider;
  
  public JobPagerAdapter(FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager, JobDataProvider paramJobDataProvider)
  {
    super(paramFragmentComponent, paramFragmentManager);
    jobDataProvider = paramJobDataProvider;
    paramFragmentManager = ((JobDataProvider.JobState)state).job();
    if (paramFragmentManager == null)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Job from Data Provider state null - NOOP!!"));
      return;
    }
    paramFragmentComponent = new ArrayList();
    if (sections == null)
    {
      fragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Job sections is null!!"));
      return;
    }
    if (sections.hasHighlights) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.HIGHLIGHTS);
    }
    if (sections.hasDetails) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.DETAILS);
    }
    if (sections.hasInsights) {
      paramFragmentComponent.add(EntityPagerAdapter.TabType.PREMIUM);
    }
    setTabs(paramFragmentComponent);
  }
  
  public final Fragment getItem(int paramInt)
  {
    return JobTabFragment.newInstance(JobTabBundleBuilder.create(getTabType(paramInt)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */