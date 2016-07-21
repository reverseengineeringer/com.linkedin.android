package com.linkedin.android.growth.utils;

import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import javax.inject.Inject;

public final class ProgressBarUtil
{
  public static void setProgressDecelerate$c7af0ba(ProgressBar paramProgressBar)
  {
    paramProgressBar.setMax(10000);
    paramProgressBar.setVisibility(0);
    paramProgressBar = ObjectAnimator.ofInt(paramProgressBar, "progress", new int[] { 0, 10000 });
    paramProgressBar.setDuration(20000L);
    paramProgressBar.setInterpolator(new DecelerateInterpolator(1.5F));
    paramProgressBar.start();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.utils.ProgressBarUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */