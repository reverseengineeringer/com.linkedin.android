package com.linkedin.android.axle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.linkedin.CrossPromoLib.api.PromoBase.OverlayPromo;

final class SplashPromo$2
  implements Runnable
{
  SplashPromo$2(SplashPromo paramSplashPromo, Runnable paramRunnable, int paramInt) {}
  
  public final void run()
  {
    try
    {
      if (val$onTapRunnable != null) {
        val$onTapRunnable.run();
      }
      return;
    }
    finally
    {
      this$0.container.animate().alpha(0.0F).setDuration(val$fadeOutDuration).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          this$0.container.setVisibility(8);
          this$0.container.removeAllViews();
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromo.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */