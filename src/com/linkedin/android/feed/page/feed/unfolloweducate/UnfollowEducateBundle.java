package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class UnfollowEducateBundle
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public UnfollowEducateBundle(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */