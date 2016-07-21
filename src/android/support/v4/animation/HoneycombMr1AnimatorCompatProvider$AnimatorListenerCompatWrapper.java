package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper
  implements Animator.AnimatorListener
{
  final ValueAnimatorCompat mValueAnimatorCompat;
  final AnimatorListenerCompat mWrapped;
  
  public HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper(AnimatorListenerCompat paramAnimatorListenerCompat, ValueAnimatorCompat paramValueAnimatorCompat)
  {
    mWrapped = paramAnimatorListenerCompat;
    mValueAnimatorCompat = paramValueAnimatorCompat;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    mWrapped.onAnimationCancel$2feb5e66();
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    mWrapped.onAnimationEnd(mValueAnimatorCompat);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}

/* Location:
 * Qualified Name:     android.support.v4.animation.HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */