package com.linkedin.android.entities.job;

import android.os.Bundle;
import android.widget.ImageView;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;

public final class JobBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle;
  public ImageView logoView;
  
  private JobBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
    if (!paramBundle.containsKey("getJobId")) {
      Util.safeThrow(new IllegalArgumentException("Invalid job bundle"));
    }
  }
  
  public static JobBundleBuilder create(Bundle paramBundle)
  {
    return new JobBundleBuilder(paramBundle);
  }
  
  public static JobBundleBuilder create(MiniJob paramMiniJob)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("jobUrn", entityUrn.toString());
    localBundle.putString("getJobId", entityUrn.getId());
    return new JobBundleBuilder(localBundle);
  }
  
  public static JobBundleBuilder create(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("getJobId", paramString);
    return new JobBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */