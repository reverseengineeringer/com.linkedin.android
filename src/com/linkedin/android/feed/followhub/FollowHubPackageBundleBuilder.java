package com.linkedin.android.feed.followhub;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class FollowHubPackageBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  FollowHubPackageBundleBuilder(int paramInt)
  {
    bundle.putInt("package_ID", paramInt);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */