package com.linkedin.android.feed.page.feed.easteregg;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class FeedEasterEggBundle
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public FeedEasterEggBundle(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */