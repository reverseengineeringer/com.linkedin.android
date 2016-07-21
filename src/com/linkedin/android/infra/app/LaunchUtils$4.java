package com.linkedin.android.infra.app;

import com.linkedin.android.infra.lix.LixManager.TreatmentListener;

final class LaunchUtils$4
  implements LixManager.TreatmentListener
{
  LaunchUtils$4(LaunchUtils paramLaunchUtils) {}
  
  public final void onChange(String paramString)
  {
    com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack.SHOULD_GZIP_REQUEST_BODY = "enabled".equals(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */