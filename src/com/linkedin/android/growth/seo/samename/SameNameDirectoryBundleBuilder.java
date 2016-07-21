package com.linkedin.android.growth.seo.samename;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class SameNameDirectoryBundleBuilder
  implements BundleBuilder
{
  Bundle bundle;
  
  public SameNameDirectoryBundleBuilder()
  {
    bundle = new Bundle();
  }
  
  public SameNameDirectoryBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static String getFirstName(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("firstName");
  }
  
  public static String getLastName(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("lastName");
  }
  
  public static String getRegion(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("region");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final SameNameDirectoryBundleBuilder setFirstName(String paramString)
  {
    bundle.putString("firstName", paramString);
    return this;
  }
  
  public final SameNameDirectoryBundleBuilder setLastName(String paramString)
  {
    bundle.putString("lastName", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.seo.samename.SameNameDirectoryBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */