package com.squareup.leakcanary;

import android.app.Application;

public final class LeakCanary
{
  private LeakCanary()
  {
    throw new AssertionError();
  }
  
  public static RefWatcher install(Application paramApplication)
  {
    return RefWatcher.DISABLED;
  }
}

/* Location:
 * Qualified Name:     com.squareup.leakcanary.LeakCanary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */