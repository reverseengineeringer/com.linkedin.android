package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class DonutAnimatorCompatProvider
  implements AnimatorProvider
{
  public final void clearInterpolator(View paramView) {}
  
  public final ValueAnimatorCompat emptyValueAnimator()
  {
    return new DonutFloatValueAnimator();
  }
  
  private static final class DonutFloatValueAnimator
    implements ValueAnimatorCompat
  {
    long mDuration = 200L;
    private boolean mEnded = false;
    float mFraction = 0.0F;
    List<AnimatorListenerCompat> mListeners = new ArrayList();
    Runnable mLoopRunnable = new Runnable()
    {
      public final void run()
      {
        float f = (float)(mTarget.getDrawingTime() - mStartTime) * 1.0F / (float)mDuration;
        if ((f > 1.0F) || (mTarget.getParent() == null)) {
          f = 1.0F;
        }
        mFraction = f;
        DonutAnimatorCompatProvider.DonutFloatValueAnimator localDonutFloatValueAnimator = DonutAnimatorCompatProvider.DonutFloatValueAnimator.this;
        int i = mUpdateListeners.size() - 1;
        while (i >= 0)
        {
          ((AnimatorUpdateListenerCompat)mUpdateListeners.get(i)).onAnimationUpdate(localDonutFloatValueAnimator);
          i -= 1;
        }
        if (mFraction >= 1.0F)
        {
          dispatchEnd();
          return;
        }
        mTarget.postDelayed(mLoopRunnable, 16L);
      }
    };
    long mStartTime;
    private boolean mStarted = false;
    View mTarget;
    List<AnimatorUpdateListenerCompat> mUpdateListeners = new ArrayList();
    
    public final void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
    {
      mListeners.add(paramAnimatorListenerCompat);
    }
    
    public final void addUpdateListener(AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
    {
      mUpdateListeners.add(paramAnimatorUpdateListenerCompat);
    }
    
    public final void cancel()
    {
      if (mEnded) {
        return;
      }
      mEnded = true;
      if (mStarted)
      {
        int i = mListeners.size() - 1;
        while (i >= 0)
        {
          ((AnimatorListenerCompat)mListeners.get(i)).onAnimationCancel$2feb5e66();
          i -= 1;
        }
      }
      dispatchEnd();
    }
    
    final void dispatchEnd()
    {
      int i = mListeners.size() - 1;
      while (i >= 0)
      {
        ((AnimatorListenerCompat)mListeners.get(i)).onAnimationEnd(this);
        i -= 1;
      }
    }
    
    public final float getAnimatedFraction()
    {
      return mFraction;
    }
    
    public final void setDuration(long paramLong)
    {
      if (!mStarted) {
        mDuration = paramLong;
      }
    }
    
    public final void setTarget(View paramView)
    {
      mTarget = paramView;
    }
    
    public final void start()
    {
      if (mStarted) {
        return;
      }
      mStarted = true;
      int i = mListeners.size() - 1;
      while (i >= 0)
      {
        mListeners.get(i);
        i -= 1;
      }
      mFraction = 0.0F;
      mStartTime = mTarget.getDrawingTime();
      mTarget.postDelayed(mLoopRunnable, 16L);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.animation.DonutAnimatorCompatProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */