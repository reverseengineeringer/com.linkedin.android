package com.linkedin.CrossPromoLib.utils;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

final class Utils$1
  implements View.OnClickListener
{
  Utils$1(View paramView, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    val$view.setVisibility(8);
    if (val$afterDismiss != null) {}
    try
    {
      val$afterDismiss.run();
      return;
    }
    catch (Exception paramView)
    {
      Log.w("Utils", val$afterDismiss.toString(), paramView);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Utils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */