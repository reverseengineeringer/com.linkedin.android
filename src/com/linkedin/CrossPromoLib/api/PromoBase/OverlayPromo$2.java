package com.linkedin.CrossPromoLib.api.PromoBase;

import android.view.ViewGroup;

final class OverlayPromo$2
  implements Runnable
{
  OverlayPromo$2(OverlayPromo paramOverlayPromo, Runnable paramRunnable) {}
  
  public final void run()
  {
    try
    {
      if (val$first != null) {
        val$first.run();
      }
      return;
    }
    finally
    {
      this$0.container.setVisibility(8);
      this$0.container.removeAllViews();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.OverlayPromo.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */