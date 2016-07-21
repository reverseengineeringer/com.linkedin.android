package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ValueAnimatorCompatImplHoneycombMr1$2
  extends AnimatorListenerAdapter
{
  ValueAnimatorCompatImplHoneycombMr1$2(ValueAnimatorCompatImplHoneycombMr1 paramValueAnimatorCompatImplHoneycombMr1, ValueAnimatorCompat.Impl.AnimatorListenerProxy paramAnimatorListenerProxy) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    val$listener.onAnimationCancel();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    val$listener.onAnimationEnd();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    val$listener.onAnimationStart();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */