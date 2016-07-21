package com.linkedin.android.entities.group;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class GroupUpdatesBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public GroupUpdatesBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupUpdatesBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */