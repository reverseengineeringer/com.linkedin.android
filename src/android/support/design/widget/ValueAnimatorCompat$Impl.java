package android.support.design.widget;

import android.view.animation.Interpolator;

abstract class ValueAnimatorCompat$Impl
{
  abstract void cancel();
  
  abstract void end();
  
  abstract float getAnimatedFloatValue();
  
  abstract float getAnimatedFraction();
  
  abstract int getAnimatedIntValue();
  
  abstract long getDuration();
  
  abstract boolean isRunning();
  
  abstract void setDuration(int paramInt);
  
  abstract void setFloatValues(float paramFloat1, float paramFloat2);
  
  abstract void setIntValues(int paramInt1, int paramInt2);
  
  abstract void setInterpolator(Interpolator paramInterpolator);
  
  abstract void setListener(AnimatorListenerProxy paramAnimatorListenerProxy);
  
  abstract void setUpdateListener(AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy);
  
  abstract void start();
  
  static abstract interface AnimatorListenerProxy
  {
    public abstract void onAnimationCancel();
    
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
  
  static abstract interface AnimatorUpdateListenerProxy
  {
    public abstract void onAnimationUpdate();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.ValueAnimatorCompat.Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */