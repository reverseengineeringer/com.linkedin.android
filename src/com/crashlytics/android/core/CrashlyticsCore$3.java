package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.File;
import java.util.concurrent.Callable;

final class CrashlyticsCore$3
  implements Callable<Boolean>
{
  CrashlyticsCore$3(CrashlyticsCore paramCrashlyticsCore) {}
  
  private Boolean call()
    throws Exception
  {
    try
    {
      boolean bool = CrashlyticsCore.access$100(this$0).getMarkerFile().delete();
      Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file removed: " + bool);
      return Boolean.valueOf(bool);
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", localException);
    }
    return Boolean.valueOf(false);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */