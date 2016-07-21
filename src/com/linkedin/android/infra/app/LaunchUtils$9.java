package com.linkedin.android.infra.app;

import android.content.Context;
import com.linkedin.android.infra.lix.LixManager.TreatmentListener;
import com.linkedin.android.logger.FileLog;
import com.linkedin.android.logger.Log;

final class LaunchUtils$9
  implements LixManager.TreatmentListener
{
  LaunchUtils$9(Context paramContext) {}
  
  public final void onChange(String paramString)
  {
    boolean bool = "show".equals(paramString);
    Log.enableLogging(bool);
    FileLog.enableFileLogging(val$context, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */