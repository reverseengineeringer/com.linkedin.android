package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

final class HoneycombMr1AnimatorCompatProvider
  implements AnimatorProvider
{
  private TimeInterpolator mDefaultInterpolator;
  
  public final void clearInterpolator(View paramView)
  {
    if (mDefaultInterpolator == null) {
      mDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(mDefaultInterpolator);
  }
  
  public final ValueAnimatorCompat emptyValueAnimator()
  {
    return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
  }
  
  static final class AnimatorListenerCompatWrapper
    implements Animator.AnimatorListener
  {
    final ValueAnimatorCompat mValueAnimatorCompat;
    final AnimatorListenerCompat mWrapped;
    
    public AnimatorListenerCompatWrapper(AnimatorListenerCompat paramAnimatorListenerCompat, ValueAnimatorCompat paramValueAnimatorCompat)
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
  
  static final class HoneycombValueAnimatorCompat
    implements ValueAnimatorCompat
  {
    final Animator mWrapped;
    
    public HoneycombValueAnimatorCompat(Animator paramAnimator)
    {
      mWrapped = paramAnimator;
    }
    
    public final void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
    {
      mWrapped.addListener(new HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper(paramAnimatorListenerCompat, this));
    }
    
    public final void addUpdateListener(final AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
    {
      if ((mWrapped instanceof ValueAnimator)) {
        ((ValueAnimator)mWrapped).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramAnimatorUpdateListenerCompat.onAnimationUpdate(HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.this);
          }
        });
      }
    }
    
    public final void cancel()
    {
      mWrapped.cancel();
    }
    
    public final float getAnimatedFraction()
    {
      return ((ValueAnimator)mWrapped).getAnimatedFraction();
    }
    
    public final void setDuration(long paramLong)
    {
      mWrapped.setDuration(paramLong);
    }
    
    public final void setTarget(View paramView)
    {
      mWrapped.setTarget(paramView);
    }
    
    public final void start()
    {
      mWrapped.start();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.animation.HoneycombMr1AnimatorCompatProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */