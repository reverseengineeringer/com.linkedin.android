package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

class ValueAnimatorCompatImplEclairMr1
  extends ValueAnimatorCompat.Impl
{
  private static final int DEFAULT_DURATION = 200;
  private static final int HANDLER_DELAY = 10;
  private static final Handler sHandler = new Handler(Looper.getMainLooper());
  private float mAnimatedFraction;
  private int mDuration = 200;
  private final float[] mFloatValues = new float[2];
  private final int[] mIntValues = new int[2];
  private Interpolator mInterpolator;
  private boolean mIsRunning;
  private ValueAnimatorCompat.Impl.AnimatorListenerProxy mListener;
  private final Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      ValueAnimatorCompatImplEclairMr1.this.update();
    }
  };
  private long mStartTime;
  private ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy mUpdateListener;
  
  private void update()
  {
    if (mIsRunning)
    {
      float f2 = (float)(SystemClock.uptimeMillis() - mStartTime) / mDuration;
      float f1 = f2;
      if (mInterpolator != null) {
        f1 = mInterpolator.getInterpolation(f2);
      }
      mAnimatedFraction = f1;
      if (mUpdateListener != null) {
        mUpdateListener.onAnimationUpdate();
      }
      if (SystemClock.uptimeMillis() >= mStartTime + mDuration)
      {
        mIsRunning = false;
        if (mListener != null) {
          mListener.onAnimationEnd();
        }
      }
    }
    if (mIsRunning) {
      sHandler.postDelayed(mRunnable, 10L);
    }
  }
  
  public void cancel()
  {
    mIsRunning = false;
    sHandler.removeCallbacks(mRunnable);
    if (mListener != null) {
      mListener.onAnimationCancel();
    }
  }
  
  public void end()
  {
    if (mIsRunning)
    {
      mIsRunning = false;
      sHandler.removeCallbacks(mRunnable);
      mAnimatedFraction = 1.0F;
      if (mUpdateListener != null) {
        mUpdateListener.onAnimationUpdate();
      }
      if (mListener != null) {
        mListener.onAnimationEnd();
      }
    }
  }
  
  public float getAnimatedFloatValue()
  {
    return AnimationUtils.lerp(mFloatValues[0], mFloatValues[1], getAnimatedFraction());
  }
  
  public float getAnimatedFraction()
  {
    return mAnimatedFraction;
  }
  
  public int getAnimatedIntValue()
  {
    return AnimationUtils.lerp(mIntValues[0], mIntValues[1], getAnimatedFraction());
  }
  
  public long getDuration()
  {
    return mDuration;
  }
  
  public boolean isRunning()
  {
    return mIsRunning;
  }
  
  public void setDuration(int paramInt)
  {
    mDuration = paramInt;
  }
  
  public void setFloatValues(float paramFloat1, float paramFloat2)
  {
    mFloatValues[0] = paramFloat1;
    mFloatValues[1] = paramFloat2;
  }
  
  public void setIntValues(int paramInt1, int paramInt2)
  {
    mIntValues[0] = paramInt1;
    mIntValues[1] = paramInt2;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    mInterpolator = paramInterpolator;
  }
  
  public void setListener(ValueAnimatorCompat.Impl.AnimatorListenerProxy paramAnimatorListenerProxy)
  {
    mListener = paramAnimatorListenerProxy;
  }
  
  public void setUpdateListener(ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy paramAnimatorUpdateListenerProxy)
  {
    mUpdateListener = paramAnimatorUpdateListenerProxy;
  }
  
  public void start()
  {
    if (mIsRunning) {
      return;
    }
    if (mInterpolator == null) {
      mInterpolator = new AccelerateDecelerateInterpolator();
    }
    mStartTime = SystemClock.uptimeMillis();
    mIsRunning = true;
    if (mListener != null) {
      mListener.onAnimationStart();
    }
    sHandler.postDelayed(mRunnable, 10L);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.ValueAnimatorCompatImplEclairMr1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */