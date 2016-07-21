package com.linkedin.android.shaky;

import android.app.Application;

public class Shaky
{
  public static void with(Application paramApplication, ShakeDelegate paramShakeDelegate)
  {
    paramApplication.registerActivityLifecycleCallbacks(new LifecycleCallbacks(paramApplication, paramShakeDelegate));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.Shaky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */