package com.linkedin.android.growth.abi;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class AbiPrepareBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public AbiPrepareBundle(boolean paramBoolean)
  {
    bundle.putBoolean("shouldShowSplashPage", paramBoolean);
  }
  
  public static boolean shouldShowSplashPage(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("shouldShowSplashPage"));
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiPrepareBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */