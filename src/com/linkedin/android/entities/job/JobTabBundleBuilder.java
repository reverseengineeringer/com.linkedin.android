package com.linkedin.android.entities.job;

import android.os.Bundle;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.infra.BundleBuilder;

public final class JobTabBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  private JobTabBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static JobTabBundleBuilder create(EntityPagerAdapter.TabType paramTabType)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("tabType", paramTabType);
    return new JobTabBundleBuilder(localBundle);
  }
  
  public static EntityPagerAdapter.TabType getTabType(Bundle paramBundle)
  {
    return (EntityPagerAdapter.TabType)paramBundle.getSerializable("tabType");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobTabBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */