package com.linkedin.android.cropphotoview;

import android.os.Build.VERSION;
import android.view.View;

public final class Compat
{
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.Compat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */