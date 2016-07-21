package com.linkedin.android.growth.onboarding.rbmf;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class RebuildMyFeedBundleBuilder
  implements BundleBuilder
{
  Bundle bundle;
  
  private RebuildMyFeedBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static RebuildMyFeedBundleBuilder createBundle(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("skipRbmfIntro", paramBoolean);
    return new RebuildMyFeedBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final RebuildMyFeedBundleBuilder setRbmfOrigin(int paramInt)
  {
    bundle.putInt("origin", paramInt);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */