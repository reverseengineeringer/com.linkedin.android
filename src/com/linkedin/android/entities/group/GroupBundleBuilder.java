package com.linkedin.android.entities.group;

import android.os.Bundle;
import android.widget.ImageView;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.shared.Util;

public final class GroupBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle;
  public ImageView logoView;
  
  public GroupBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
    if (!paramBundle.containsKey("getGroupId")) {
      Util.safeThrow(new IllegalArgumentException("Invalid group bundle"));
    }
  }
  
  public static GroupBundleBuilder create(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("getGroupId", paramString);
    return new GroupBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */