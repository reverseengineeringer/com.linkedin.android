package com.google.android.exoplayer.util;

import java.util.concurrent.ThreadFactory;

final class Util$1
  implements ThreadFactory
{
  Util$1(String paramString) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, val$threadName);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.Util.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */