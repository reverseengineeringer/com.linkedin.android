package com.linkedin.android.feed.followhub;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class FollowHubBundleBuilder
  implements BundleBuilder
{
  private Bundle bundle;
  
  private FollowHubBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static FollowHubBundleBuilder createBundle()
  {
    return new FollowHubBundleBuilder(new Bundle());
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */