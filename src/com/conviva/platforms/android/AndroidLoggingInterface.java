package com.conviva.platforms.android;

import android.util.Log;
import com.conviva.api.SystemSettings.LogLevel;
import com.conviva.api.system.ILoggingInterface;

public final class AndroidLoggingInterface
  implements ILoggingInterface
{
  protected final String _TAG = "CONVIVA";
  
  public final void consoleLog(String paramString, SystemSettings.LogLevel paramLogLevel)
  {
    if (paramLogLevel == SystemSettings.LogLevel.DEBUG) {
      Log.d("CONVIVA", paramString);
    }
    do
    {
      return;
      if (paramLogLevel == SystemSettings.LogLevel.ERROR)
      {
        Log.e("CONVIVA", paramString);
        return;
      }
      if (paramLogLevel == SystemSettings.LogLevel.INFO)
      {
        Log.i("CONVIVA", paramString);
        return;
      }
    } while (paramLogLevel != SystemSettings.LogLevel.WARNING);
    Log.w("CONVIVA", paramString);
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidLoggingInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */