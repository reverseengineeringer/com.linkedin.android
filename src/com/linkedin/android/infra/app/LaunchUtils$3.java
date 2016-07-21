package com.linkedin.android.infra.app;

import com.linkedin.android.infra.lix.LixManager.TreatmentListener;

final class LaunchUtils$3
  implements LixManager.TreatmentListener
{
  LaunchUtils$3(LaunchUtils paramLaunchUtils) {}
  
  public final void onChange(String paramString)
  {
    com.linkedin.android.networking.LinkedInNetwork.ENABLE_BROTLI = "enabled".equals(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */