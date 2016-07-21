package com.linkedin.android.infra.app;

import com.linkedin.android.infra.lix.LixManager.TreatmentListener;

final class LaunchUtils$2
  implements LixManager.TreatmentListener
{
  LaunchUtils$2(LaunchUtils paramLaunchUtils) {}
  
  public final void onChange(String paramString)
  {
    com.linkedin.android.datamanager.DataManagerParserFactory.USE_FAST_JSON_PARSER = "enabled".equals(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */