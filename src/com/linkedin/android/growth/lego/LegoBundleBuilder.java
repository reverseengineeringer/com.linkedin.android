package com.linkedin.android.growth.lego;

import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class LegoBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public LegoBundleBuilder(String paramString)
  {
    bundle.putString("tracking_token", paramString);
  }
  
  public static Bundle addHomeIntent(Bundle paramBundle, Intent paramIntent)
  {
    paramBundle.putParcelable("homeIntent", paramIntent);
    return paramBundle;
  }
  
  public static Intent getHomeIntent(Bundle paramBundle)
  {
    return (Intent)paramBundle.getParcelable("homeIntent");
  }
  
  public static Intent getRebuildMyFeedIntent(Bundle paramBundle)
  {
    return (Intent)paramBundle.getParcelable("rebuildMyFeedIntent");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */