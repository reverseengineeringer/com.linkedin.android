package com.linkedin.android.axle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

final class ToastPromo$DismissAndThen$1
  extends AnimatorListenerAdapter
{
  ToastPromo$DismissAndThen$1(ToastPromo.DismissAndThen paramDismissAndThen, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this$1.next != null) {
      this$1.next.onClick(val$v);
    }
    this$1.container.setVisibility(8);
    this$1.container.removeAllViews();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromo.DismissAndThen.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */