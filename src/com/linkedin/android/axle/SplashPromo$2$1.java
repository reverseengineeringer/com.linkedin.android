package com.linkedin.android.axle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoBase.OverlayPromo;

final class SplashPromo$2$1
  extends AnimatorListenerAdapter
{
  SplashPromo$2$1(SplashPromo.2 param2) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this$1.this$0.container.setVisibility(8);
    this$1.this$0.container.removeAllViews();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromo.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */