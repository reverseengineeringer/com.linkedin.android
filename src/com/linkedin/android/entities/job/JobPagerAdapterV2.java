package com.linkedin.android.entities.job;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.entities.EntityPagerAdapter;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.job.controllers.JobTabFragmentV2;
import com.linkedin.android.infra.components.FragmentComponent;
import java.util.ArrayList;
import java.util.List;

public final class JobPagerAdapterV2
  extends EntityPagerAdapter
{
  private final JobDataProvider jobDataProvider;
  
  public JobPagerAdapterV2(FragmentComponent paramFragmentComponent, FragmentManager paramFragmentManager, JobDataProvider paramJobDataProvider)
  {
    super(paramFragmentComponent, paramFragmentManager);
    jobDataProvider = paramJobDataProvider;
    paramFragmentComponent = new ArrayList();
    paramFragmentComponent.add(EntityPagerAdapter.TabType.HIGHLIGHTS);
    setTabs(paramFragmentComponent);
  }
  
  public final Fragment getItem(int paramInt)
  {
    return JobTabFragmentV2.newInstance(JobTabBundleBuilder.create(getTabType(paramInt)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobPagerAdapterV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */