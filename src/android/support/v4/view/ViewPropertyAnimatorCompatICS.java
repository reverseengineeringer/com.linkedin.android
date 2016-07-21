package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

final class ViewPropertyAnimatorCompatICS
{
  public static void setListener(final View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    paramView.animate().setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        val$listener.onAnimationCancel(paramView);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        val$listener.onAnimationEnd(paramView);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        val$listener.onAnimationStart(paramView);
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatICS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */