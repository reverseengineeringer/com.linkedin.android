package com.linkedin.android.growth.onboarding.greeting;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class GreetingBundle
  implements BundleBuilder
{
  public final Bundle bundle = new Bundle();
  
  public GreetingBundle(boolean paramBoolean)
  {
    bundle.putBoolean("isLapse", paramBoolean);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.greeting.GreetingBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */