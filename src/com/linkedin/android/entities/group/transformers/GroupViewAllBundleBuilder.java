package com.linkedin.android.entities.group.transformers;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class GroupViewAllBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  private GroupViewAllBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static GroupViewAllBundleBuilder create(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("pageType", paramInt);
    return new GroupViewAllBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupViewAllBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */