package com.google.android.gms.internal;

import android.os.Process;

final class zznl
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzx;
  
  public zznl(Runnable paramRunnable, int paramInt)
  {
    zzx = paramRunnable;
    mPriority = paramInt;
  }
  
  public final void run()
  {
    Process.setThreadPriority(mPriority);
    zzx.run();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zznl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */