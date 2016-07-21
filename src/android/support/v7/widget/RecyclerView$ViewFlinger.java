package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.animation.Interpolator;
import java.util.ArrayList;

final class RecyclerView$ViewFlinger
  implements Runnable
{
  private boolean mEatRunOnAnimationRequest = false;
  private Interpolator mInterpolator = RecyclerView.access$3000();
  int mLastFlingX;
  int mLastFlingY;
  private boolean mReSchedulePostAnimationCallback = false;
  ScrollerCompat mScroller;
  
  public RecyclerView$ViewFlinger(RecyclerView paramRecyclerView)
  {
    mScroller = ScrollerCompat.create(paramRecyclerView.getContext(), RecyclerView.access$3000());
  }
  
  final void postOnAnimation()
  {
    if (mEatRunOnAnimationRequest)
    {
      mReSchedulePostAnimationCallback = true;
      return;
    }
    this$0.removeCallbacks(this);
    ViewCompat.postOnAnimation(this$0, this);
  }
  
  public final void run()
  {
    if (this$0.mLayout == null)
    {
      stop();
      return;
    }
    mReSchedulePostAnimationCallback = false;
    mEatRunOnAnimationRequest = true;
    RecyclerView.access$400(this$0);
    ScrollerCompat localScrollerCompat = mScroller;
    RecyclerView.SmoothScroller localSmoothScroller = this$0.mLayout.mSmoothScroller;
    int i4;
    int i5;
    int n;
    int i;
    int i3;
    int m;
    int i1;
    int j;
    int i2;
    int k;
    label348:
    label424:
    label441:
    RecyclerView localRecyclerView;
    if (localScrollerCompat.computeScrollOffset())
    {
      int i6 = localScrollerCompat.getCurrX();
      int i7 = localScrollerCompat.getCurrY();
      i4 = i6 - mLastFlingX;
      i5 = i7 - mLastFlingY;
      n = 0;
      i = 0;
      i3 = 0;
      m = 0;
      mLastFlingX = i6;
      mLastFlingY = i7;
      i1 = 0;
      j = 0;
      i2 = 0;
      k = 0;
      if (RecyclerView.access$3100(this$0) != null)
      {
        this$0.eatRequestLayout();
        RecyclerView.access$3200(this$0);
        TraceCompat.beginSection("RV Scroll");
        if (i4 != 0)
        {
          i = this$0.mLayout.scrollHorizontallyBy(i4, this$0.mRecycler, this$0.mState);
          j = i4 - i;
        }
        if (i5 != 0)
        {
          m = this$0.mLayout.scrollVerticallyBy(i5, this$0.mRecycler, this$0.mState);
          k = i5 - m;
        }
        TraceCompat.endSection();
        RecyclerView.access$3300(this$0);
        RecyclerView.access$3400(this$0);
        this$0.resumeRequestLayout(false);
        n = i;
        i1 = j;
        i2 = k;
        i3 = m;
        if (localSmoothScroller != null)
        {
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          if (!mPendingInitialRun)
          {
            n = i;
            i1 = j;
            i2 = k;
            i3 = m;
            if (mRunning)
            {
              n = this$0.mState.getItemCount();
              if (n != 0) {
                break label735;
              }
              localSmoothScroller.stop();
              i3 = m;
              i2 = k;
              i1 = j;
              n = i;
            }
          }
        }
      }
      if (!RecyclerView.access$3600(this$0).isEmpty()) {
        this$0.invalidate();
      }
      if (ViewCompat.getOverScrollMode(this$0) != 2) {
        RecyclerView.access$3700(this$0, i4, i5);
      }
      if ((i1 != 0) || (i2 != 0))
      {
        k = (int)localScrollerCompat.getCurrVelocity();
        i = 0;
        if (i1 != i6)
        {
          if (i1 >= 0) {
            break label783;
          }
          i = -k;
        }
        j = 0;
        if (i2 != i7)
        {
          if (i2 >= 0) {
            break label798;
          }
          j = -k;
        }
        if (ViewCompat.getOverScrollMode(this$0) != 2)
        {
          localRecyclerView = this$0;
          if (i >= 0) {
            break label813;
          }
          localRecyclerView.ensureLeftGlow();
          mLeftGlow.onAbsorb(-i);
          label478:
          if (j >= 0) {
            break label835;
          }
          localRecyclerView.ensureTopGlow();
          mTopGlow.onAbsorb(-j);
          label498:
          if ((i != 0) || (j != 0)) {
            ViewCompat.postInvalidateOnAnimation(localRecyclerView);
          }
        }
        if (((i != 0) || (i1 == i6) || (localScrollerCompat.getFinalX() == 0)) && ((j != 0) || (i2 == i7) || (localScrollerCompat.getFinalY() == 0))) {
          localScrollerCompat.abortAnimation();
        }
      }
      if ((n != 0) || (i3 != 0)) {
        this$0.dispatchOnScrolled(n, i3);
      }
      if (!RecyclerView.access$3800(this$0)) {
        this$0.invalidate();
      }
      if ((i5 == 0) || (!this$0.mLayout.canScrollVertically()) || (i3 != i5)) {
        break label857;
      }
      i = 1;
      label619:
      if ((i4 == 0) || (!this$0.mLayout.canScrollHorizontally()) || (n != i4)) {
        break label862;
      }
      j = 1;
      label646:
      if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
        break label867;
      }
      i = 1;
      label666:
      if ((!localScrollerCompat.isFinished()) && (i != 0)) {
        break label872;
      }
      RecyclerView.access$3900(this$0, 0);
    }
    for (;;)
    {
      if (localSmoothScroller != null)
      {
        if (mPendingInitialRun) {
          RecyclerView.SmoothScroller.access$3500(localSmoothScroller, 0, 0);
        }
        if (!mReSchedulePostAnimationCallback) {
          localSmoothScroller.stop();
        }
      }
      mEatRunOnAnimationRequest = false;
      if (!mReSchedulePostAnimationCallback) {
        break;
      }
      postOnAnimation();
      return;
      label735:
      if (mTargetPosition >= n) {
        mTargetPosition = (n - 1);
      }
      RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - j, i5 - k);
      n = i;
      i1 = j;
      i2 = k;
      i3 = m;
      break label348;
      label783:
      if (i1 > 0)
      {
        i = k;
        break label424;
      }
      i = 0;
      break label424;
      label798:
      if (i2 > 0)
      {
        j = k;
        break label441;
      }
      j = 0;
      break label441;
      label813:
      if (i <= 0) {
        break label478;
      }
      localRecyclerView.ensureRightGlow();
      mRightGlow.onAbsorb(i);
      break label478;
      label835:
      if (j <= 0) {
        break label498;
      }
      localRecyclerView.ensureBottomGlow();
      mBottomGlow.onAbsorb(j);
      break label498;
      label857:
      i = 0;
      break label619;
      label862:
      j = 0;
      break label646;
      label867:
      i = 0;
      break label666;
      label872:
      postOnAnimation();
    }
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n;
    int i1;
    if (k > m)
    {
      j = 1;
      n = (int)Math.sqrt(0.0D);
      i1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (j == 0) {
        break label157;
      }
    }
    label157:
    for (int i = this$0.getWidth();; i = this$0.getHeight())
    {
      int i2 = i / 2;
      float f3 = Math.min(1.0F, i1 * 1.0F / i);
      float f1 = i2;
      float f2 = i2;
      f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
      if (n <= 0) {
        break label169;
      }
      i = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / n)) * 4;
      smoothScrollBy(paramInt1, paramInt2, Math.min(i, 2000));
      return;
      j = 0;
      break;
    }
    label169:
    if (j != 0) {}
    for (int j = k;; j = m)
    {
      i = (int)((j / i + 1.0F) * 300.0F);
      break;
    }
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.access$3000());
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (mInterpolator != paramInterpolator)
    {
      mInterpolator = paramInterpolator;
      mScroller = ScrollerCompat.create(this$0.getContext(), paramInterpolator);
    }
    RecyclerView.access$3900(this$0, 2);
    mLastFlingY = 0;
    mLastFlingX = 0;
    mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    postOnAnimation();
  }
  
  public final void stop()
  {
    this$0.removeCallbacks(this);
    mScroller.abortAnimation();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.ViewFlinger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */