package com.linkedin.android.entities.job;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class JobViewAllBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  private JobViewAllBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static JobViewAllBundleBuilder create(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("pageType", paramInt);
    return new JobViewAllBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobViewAllBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */