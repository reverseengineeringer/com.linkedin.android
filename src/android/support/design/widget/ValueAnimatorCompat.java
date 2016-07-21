package android.support.design.widget;

import android.view.animation.Interpolator;

class ValueAnimatorCompat
{
  private final Impl mImpl;
  
  ValueAnimatorCompat(Impl paramImpl)
  {
    mImpl = paramImpl;
  }
  
  public void cancel()
  {
    mImpl.cancel();
  }
  
  public void end()
  {
    mImpl.end();
  }
  
  public float getAnimatedFloatValue()
  {
    return mImpl.getAnimatedFloatValue();
  }
  
  public float getAnimatedFraction()
  {
    return mImpl.getAnimatedFraction();
  }
  
  public int getAnimatedIntValue()
  {
    return mImpl.getAnimatedIntValue();
  }
  
  public long getDuration()
  {
    return mImpl.getDuration();
  }
  
  public boolean isRunning()
  {
    return mImpl.isRunning();
  }
  
  public void setDuration(int paramInt)
  {
    mImpl.setDuration(paramInt);
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    mImpl.setFloatValues(paramFloat1, paramFloat2);
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    mImpl.setIntValues(paramInt1, paramInt2);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    mImpl.setInterpolator(paramInterpolator);
  }
  
  public void setListener(final AnimatorListener paramAnimatorListener)
  {
    if (paramAnimatorListener != null)
    {
      mImpl.setListener(new ValueAnimatorCompat.Impl.AnimatorListenerProxy()
      {
        public void onAnimationCancel()
        {
          paramAnimatorListener.onAnimationCancel(ValueAnimatorCompat.this);
        }
        
        public void onAnimationEnd()
        {
          paramAnimatorListener.onAnimationEnd(ValueAnimatorCompat.this);
        }
        
        public void onAnimationStart()
        {
          paramAnimatorListener.onAnimationStart(ValueAnimatorCompat.this);
        }
      });
      return;
    }
    mImpl.setListener(null);
  }
  
  public void setUpdateListener(final AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    if (paramAnimatorUpdateListener != null)
    {
      mImpl.setUpdateListener(new ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy()
      {
        public void onAnimationUpdate()
        {
          paramAnimatorUpdateListener.onAnimationUpdate(ValueAnimatorCompat.this);
        }
      });
      return;
    }
    mImpl.setUpdateListener(null);
  }
  
  public void start()
  {
    mImpl.start();
  }
  
  static abstract interface AnimatorListener
  {
    public abstract void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat);
    
    public abstract void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat);
    
    public abstract void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat);
  }
  
  static class AnimatorListenerAdapter
    implements ValueAnimatorCompat.AnimatorListener
  {
    public void onAnimationCancel(ValueAnimatorCompat paramValueAnimatorCompat) {}
    
    public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat) {}
    
    public void onAnimationStart(ValueAnimatorCompat paramValueAnimatorCompat) {}
  }
  
  static abstract interface AnimatorUpdateListener
  {
    public abstract void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat);
  }
  
  static abstract interface Creator
  {
    public abstract ValueAnimatorCompat createAnimator();
  }
  
  static abstract class Impl
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
}

/* Location:
 * Qualified Name:     android.support.design.widget.ValueAnimatorCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */