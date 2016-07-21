package com.linkedin.android.feed.updates.common.likes.detail;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import java.net.URISyntaxException;

public final class LikesDetailBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle;
  
  public LikesDetailBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static Urn getUpdateUrn(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      paramBundle = Urn.createFromString(paramBundle.getString("updateUrn"));
      return paramBundle;
    }
    catch (URISyntaxException paramBundle)
    {
      Util.safeThrow(new RuntimeException(paramBundle));
    }
    return null;
  }
  
  public static String getUpdateUrnString(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("updateUrn");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */