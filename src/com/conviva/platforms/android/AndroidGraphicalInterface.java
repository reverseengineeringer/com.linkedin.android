package com.conviva.platforms.android;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import com.conviva.api.system.IGraphicalInterface;
import java.util.List;

public final class AndroidGraphicalInterface
  implements IGraphicalInterface
{
  private Context _context = null;
  
  public AndroidGraphicalInterface(Context paramContext)
  {
    _context = paramContext;
  }
  
  public final boolean inSleepingMode()
  {
    return !((PowerManager)_context.getSystemService("power")).isScreenOn();
  }
  
  public final boolean isVisible()
  {
    int j = Process.myPid();
    List localList = ((ActivityManager)_context.getSystemService("activity")).getRunningAppProcesses();
    if (localList == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= localList.size()) {
        break label83;
      }
      if (getpid == j)
      {
        if (getimportance > 200) {
          break;
        }
        return true;
      }
      i += 1;
    }
    label83:
    return true;
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidGraphicalInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */