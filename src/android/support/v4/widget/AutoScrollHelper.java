package android.support.v4.widget;

import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper
  implements View.OnTouchListener
{
  private static final int DEFAULT_ACTIVATION_DELAY = ;
  private int mActivationDelay;
  private boolean mAlreadyDelayed;
  private boolean mAnimating;
  private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
  private int mEdgeType;
  private boolean mEnabled;
  private boolean mExclusive;
  private float[] mMaximumEdges = { Float.MAX_VALUE, Float.MAX_VALUE };
  private float[] mMaximumVelocity = { Float.MAX_VALUE, Float.MAX_VALUE };
  private float[] mMinimumVelocity = { 0.0F, 0.0F };
  private boolean mNeedsCancel;
  private boolean mNeedsReset;
  private float[] mRelativeEdges = { 0.0F, 0.0F };
  private float[] mRelativeVelocity = { 0.0F, 0.0F };
  private Runnable mRunnable;
  private final ClampedScroller mScroller = new ClampedScroller();
  private final View mTarget;
  
  public AutoScrollHelper(View paramView)
  {
    mTarget = paramView;
    paramView = Resources.getSystem().getDisplayMetrics();
    int i = (int)(1575.0F * density + 0.5F);
    int j = (int)(315.0F * density + 0.5F);
    float f = i;
    mMaximumVelocity[0] = (f / 1000.0F);
    mMaximumVelocity[1] = (f / 1000.0F);
    f = j;
    mMinimumVelocity[0] = (f / 1000.0F);
    mMinimumVelocity[1] = (f / 1000.0F);
    mEdgeType = 1;
    mMaximumEdges[0] = Float.MAX_VALUE;
    mMaximumEdges[1] = Float.MAX_VALUE;
    mRelativeEdges[0] = 0.2F;
    mRelativeEdges[1] = 0.2F;
    mRelativeVelocity[0] = 0.001F;
    mRelativeVelocity[1] = 0.001F;
    mActivationDelay = DEFAULT_ACTIVATION_DELAY;
    mScroller.mRampUpDuration = 500;
    mScroller.mRampDownDuration = 500;
  }
  
  private float computeTargetVelocity(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = constrain(mRelativeEdges[paramInt] * paramFloat2, 0.0F, mMaximumEdges[paramInt]);
    float f2 = constrainEdgeValue(paramFloat1, f1);
    paramFloat1 = constrainEdgeValue(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F) {
      paramFloat1 = -mEdgeInterpolator.getInterpolation(-paramFloat1);
    }
    for (paramFloat1 = constrain(paramFloat1, -1.0F, 1.0F);; paramFloat1 = 0.0F)
    {
      if (paramFloat1 != 0.0F) {
        break label102;
      }
      return 0.0F;
      if (paramFloat1 > 0.0F)
      {
        paramFloat1 = mEdgeInterpolator.getInterpolation(paramFloat1);
        break;
      }
    }
    label102:
    f2 = mRelativeVelocity[paramInt];
    paramFloat2 = mMinimumVelocity[paramInt];
    f1 = mMaximumVelocity[paramInt];
    paramFloat3 = f2 * paramFloat3;
    if (paramFloat1 > 0.0F) {
      return constrain(paramFloat1 * paramFloat3, paramFloat2, f1);
    }
    return -constrain(-paramFloat1 * paramFloat3, paramFloat2, f1);
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  private float constrainEdgeValue(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {}
    do
    {
      do
      {
        do
        {
          return 0.0F;
          switch (mEdgeType)
          {
          default: 
            return 0.0F;
          }
        } while (paramFloat1 >= paramFloat2);
        if (paramFloat1 >= 0.0F) {
          return 1.0F - paramFloat1 / paramFloat2;
        }
      } while ((!mAnimating) || (mEdgeType != 1));
      return 1.0F;
    } while (paramFloat1 >= 0.0F);
    return paramFloat1 / -paramFloat2;
  }
  
  private void requestStop()
  {
    if (mNeedsReset)
    {
      mAnimating = false;
      return;
    }
    ClampedScroller localClampedScroller = mScroller;
    long l = AnimationUtils.currentAnimationTimeMillis();
    int i = (int)(l - mStartTime);
    int j = mRampDownDuration;
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      mEffectiveRampDown = i;
      mStopValue = localClampedScroller.getValueAt(l);
      mStopTime = l;
      return;
      if (i < 0) {
        i = 0;
      }
    }
  }
  
  private boolean shouldAnimate()
  {
    ClampedScroller localClampedScroller = mScroller;
    int i = (int)(mTargetVelocityY / Math.abs(mTargetVelocityY));
    int j = (int)(mTargetVelocityX / Math.abs(mTargetVelocityX));
    if ((i == 0) || (!canTargetScrollVertically(i)))
    {
      if (j != 0) {}
      return false;
    }
    return true;
  }
  
  public abstract boolean canTargetScrollVertically(int paramInt);
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!mEnabled) {}
    for (;;)
    {
      return false;
      switch (MotionEventCompat.getActionMasked(paramMotionEvent))
      {
      }
      while ((mExclusive) && (mAnimating))
      {
        return true;
        mNeedsCancel = true;
        mAlreadyDelayed = false;
        float f1 = computeTargetVelocity(0, paramMotionEvent.getX(), paramView.getWidth(), mTarget.getWidth());
        float f2 = computeTargetVelocity(1, paramMotionEvent.getY(), paramView.getHeight(), mTarget.getHeight());
        paramView = mScroller;
        mTargetVelocityX = f1;
        mTargetVelocityY = f2;
        if ((!mAnimating) && (shouldAnimate()))
        {
          if (mRunnable == null) {
            mRunnable = new ScrollAnimationRunnable((byte)0);
          }
          mAnimating = true;
          mNeedsReset = true;
          if ((!mAlreadyDelayed) && (mActivationDelay > 0)) {
            ViewCompat.postOnAnimationDelayed(mTarget, mRunnable, mActivationDelay);
          }
          for (;;)
          {
            mAlreadyDelayed = true;
            break;
            mRunnable.run();
          }
          requestStop();
        }
      }
    }
  }
  
  public abstract void scrollTargetBy$255f295(int paramInt);
  
  public final AutoScrollHelper setEnabled(boolean paramBoolean)
  {
    if ((mEnabled) && (!paramBoolean)) {
      requestStop();
    }
    mEnabled = paramBoolean;
    return this;
  }
  
  private static final class ClampedScroller
  {
    long mDeltaTime = 0L;
    int mDeltaX = 0;
    int mDeltaY = 0;
    int mEffectiveRampDown;
    int mRampDownDuration;
    int mRampUpDuration;
    long mStartTime = Long.MIN_VALUE;
    long mStopTime = -1L;
    float mStopValue;
    float mTargetVelocityX;
    float mTargetVelocityY;
    
    final float getValueAt(long paramLong)
    {
      if (paramLong < mStartTime) {
        return 0.0F;
      }
      if ((mStopTime < 0L) || (paramLong < mStopTime)) {
        return 0.5F * AutoScrollHelper.access$900$483d241b((float)(paramLong - mStartTime) / mRampUpDuration);
      }
      long l = mStopTime;
      return 1.0F - mStopValue + mStopValue * AutoScrollHelper.access$900$483d241b((float)(paramLong - l) / mEffectiveRampDown);
    }
  }
  
  private final class ScrollAnimationRunnable
    implements Runnable
  {
    private ScrollAnimationRunnable() {}
    
    public final void run()
    {
      int j = 0;
      if (!mAnimating) {
        return;
      }
      if (mNeedsReset)
      {
        AutoScrollHelper.access$202$2149d4c8(AutoScrollHelper.this);
        localClampedScroller = mScroller;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStopTime = -1L;
        mDeltaTime = mStartTime;
        mStopValue = 0.5F;
        mDeltaX = 0;
        mDeltaY = 0;
      }
      AutoScrollHelper.ClampedScroller localClampedScroller = mScroller;
      int i = j;
      if (mStopTime > 0L)
      {
        i = j;
        if (AnimationUtils.currentAnimationTimeMillis() > mStopTime + mEffectiveRampDown) {
          i = 1;
        }
      }
      if ((i != 0) || (!AutoScrollHelper.this.shouldAnimate()))
      {
        AutoScrollHelper.access$102$2149d4c8(AutoScrollHelper.this);
        return;
      }
      if (mNeedsCancel)
      {
        AutoScrollHelper.access$502$2149d4c8(AutoScrollHelper.this);
        AutoScrollHelper.access$600(AutoScrollHelper.this);
      }
      if (mDeltaTime == 0L) {
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      float f = localClampedScroller.getValueAt(l1);
      f = f * 4.0F + -4.0F * f * f;
      long l2 = l1 - mDeltaTime;
      mDeltaTime = l1;
      mDeltaX = ((int)((float)l2 * f * mTargetVelocityX));
      mDeltaY = ((int)((float)l2 * f * mTargetVelocityY));
      i = mDeltaY;
      scrollTargetBy$255f295(i);
      ViewCompat.postOnAnimation(mTarget, this);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.AutoScrollHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */