package com.linkedin.android.growth.takeover;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;

public final class TakeoverIntentBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public TakeoverIntentBundleBuilder(String paramString, TakeoverType paramTakeoverType)
  {
    bundle.putString("legoTrackingToken", paramString);
    bundle.putSerializable("takeoverType", paramTakeoverType);
  }
  
  public static String getLegoTrackingToken(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("legoTrackingToken");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.TakeoverIntentBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */