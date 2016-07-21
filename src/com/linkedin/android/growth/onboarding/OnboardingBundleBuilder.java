package com.linkedin.android.growth.onboarding;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class OnboardingBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle;
  
  public OnboardingBundleBuilder()
  {
    bundle = new Bundle();
  }
  
  public OnboardingBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static OnboardingBundleBuilder create$5df52dcd(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("emailConfirmation", true);
    localBundle.putString("originalUrl", paramString);
    return new OnboardingBundleBuilder(localBundle);
  }
  
  public static String getLapseUserTrackingToken(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("lapseOnboardingLegoToken");
  }
  
  public static boolean isOnboardingResume(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("isOnboardingResume", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */