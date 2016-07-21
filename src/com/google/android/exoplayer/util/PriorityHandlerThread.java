package com.google.android.exoplayer.util;

import android.os.HandlerThread;
import android.os.Process;

public final class PriorityHandlerThread
  extends HandlerThread
{
  private final int priority = -16;
  
  public PriorityHandlerThread(String paramString)
  {
    super(paramString);
  }
  
  public final void run()
  {
    Process.setThreadPriority(priority);
    super.run();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.PriorityHandlerThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */