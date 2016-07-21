package com.linkedin.android.axle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;

final class ToastPromo$DismissAndThen
  implements View.OnClickListener
{
  final ViewGroup container;
  final View.OnClickListener next;
  
  public ToastPromo$DismissAndThen(ToastPromo paramToastPromo, View.OnClickListener paramOnClickListener, ViewGroup paramViewGroup)
  {
    next = paramOnClickListener;
    container = paramViewGroup;
  }
  
  public final void onClick(final View paramView)
  {
    container.animate().setInterpolator(new AccelerateInterpolator()).setDuration(ToastPromo.access$100(this$0)).translationY(ToastPromo.access$000(this$0)).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        if (next != null) {
          next.onClick(paramView);
        }
        container.setVisibility(8);
        container.removeAllViews();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromo.DismissAndThen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */