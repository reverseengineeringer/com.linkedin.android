package com.linkedin.android.entities.school;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.shared.Util;

public final class SchoolBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public SchoolBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
    if (!paramBundle.containsKey("schoolId")) {
      Util.safeThrow(new IllegalArgumentException("Invalid school bundle"));
    }
  }
  
  public static SchoolBundleBuilder create(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schoolId", paramString);
    return new SchoolBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */