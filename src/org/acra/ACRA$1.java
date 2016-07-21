package org.acra;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import org.acra.log.ACRALog;

final class ACRA$1
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public final void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    boolean bool;
    ACRALog localACRALog;
    String str;
    StringBuilder localStringBuilder;
    if (("acra.disable".equals(paramString)) || ("acra.enable".equals(paramString)))
    {
      if (ACRA.access$000(paramSharedPreferences)) {
        break label99;
      }
      bool = true;
      paramString = ACRA.getErrorReporter();
      localACRALog = ACRA.log;
      str = ACRA.LOG_TAG;
      localStringBuilder = new StringBuilder("ACRA is ");
      if (!bool) {
        break label104;
      }
    }
    label99:
    label104:
    for (paramSharedPreferences = "enabled";; paramSharedPreferences = "disabled")
    {
      localACRALog.i(str, paramSharedPreferences + " for " + mContext.getPackageName());
      enabled = bool;
      return;
      bool = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     org.acra.ACRA.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */