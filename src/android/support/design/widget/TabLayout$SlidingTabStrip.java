package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class TabLayout$SlidingTabStrip
  extends LinearLayout
{
  private ValueAnimatorCompat mIndicatorAnimator;
  private int mIndicatorLeft = -1;
  private int mIndicatorRight = -1;
  private int mSelectedIndicatorHeight;
  private final Paint mSelectedIndicatorPaint;
  private int mSelectedPosition = -1;
  private float mSelectionOffset;
  
  TabLayout$SlidingTabStrip(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    mSelectedIndicatorPaint = new Paint();
  }
  
  private void setIndicatorPosition(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != mIndicatorLeft) || (paramInt2 != mIndicatorRight))
    {
      mIndicatorLeft = paramInt1;
      mIndicatorRight = paramInt2;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void updateIndicatorPosition()
  {
    View localView = getChildAt(mSelectedPosition);
    int i;
    int j;
    if ((localView != null) && (localView.getWidth() > 0))
    {
      int m = localView.getLeft();
      int k = localView.getRight();
      i = m;
      j = k;
      if (mSelectionOffset > 0.0F)
      {
        i = m;
        j = k;
        if (mSelectedPosition < getChildCount() - 1)
        {
          localView = getChildAt(mSelectedPosition + 1);
          i = (int)(mSelectionOffset * localView.getLeft() + (1.0F - mSelectionOffset) * m);
          j = (int)(mSelectionOffset * localView.getRight() + (1.0F - mSelectionOffset) * k);
        }
      }
    }
    for (;;)
    {
      setIndicatorPosition(i, j);
      return;
      j = -1;
      i = -1;
    }
  }
  
  void animateIndicatorToPosition(final int paramInt1, int paramInt2)
  {
    if ((mIndicatorAnimator != null) && (mIndicatorAnimator.isRunning())) {
      mIndicatorAnimator.cancel();
    }
    final int i;
    Object localObject;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      i = 1;
      localObject = getChildAt(paramInt1);
      if (localObject != null) {
        break label56;
      }
      updateIndicatorPosition();
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label56:
      final int k = ((View)localObject).getLeft();
      final int m = ((View)localObject).getRight();
      final int j;
      if (Math.abs(paramInt1 - mSelectedPosition) <= 1)
      {
        i = mIndicatorLeft;
        j = mIndicatorRight;
      }
      while ((i != k) || (j != m))
      {
        localObject = ViewUtils.createAnimator();
        mIndicatorAnimator = ((ValueAnimatorCompat)localObject);
        ((ValueAnimatorCompat)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ((ValueAnimatorCompat)localObject).setDuration(paramInt2);
        ((ValueAnimatorCompat)localObject).setFloatValues(0.0F, 1.0F);
        ((ValueAnimatorCompat)localObject).setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
          {
            float f = paramAnonymousValueAnimatorCompat.getAnimatedFraction();
            TabLayout.SlidingTabStrip.this.setIndicatorPosition(AnimationUtils.lerp(i, k, f), AnimationUtils.lerp(j, m, f));
          }
        });
        ((ValueAnimatorCompat)localObject).setListener(new ValueAnimatorCompat.AnimatorListenerAdapter()
        {
          public void onAnimationEnd(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
          {
            TabLayout.SlidingTabStrip.access$2502(TabLayout.SlidingTabStrip.this, paramInt1);
            TabLayout.SlidingTabStrip.access$2602(TabLayout.SlidingTabStrip.this, 0.0F);
          }
        });
        ((ValueAnimatorCompat)localObject).start();
        return;
        j = TabLayout.access$2100(this$0, 24);
        if (paramInt1 < mSelectedPosition)
        {
          if (i == 0)
          {
            j = m + j;
            i = j;
          }
        }
        else if (i != 0)
        {
          j = m + j;
          i = j;
          continue;
        }
        j = k - j;
        i = j;
      }
    }
  }
  
  boolean childrenNeedLayout()
  {
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      if (getChildAt(i).getWidth() <= 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((mIndicatorLeft >= 0) && (mIndicatorRight > mIndicatorLeft)) {
      paramCanvas.drawRect(mIndicatorLeft, getHeight() - mSelectedIndicatorHeight, mIndicatorRight, getHeight(), mSelectedIndicatorPaint);
    }
  }
  
  float getIndicatorPosition()
  {
    return mSelectedPosition + mSelectionOffset;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((mIndicatorAnimator != null) && (mIndicatorAnimator.isRunning()))
    {
      mIndicatorAnimator.cancel();
      long l = mIndicatorAnimator.getDuration();
      animateIndicatorToPosition(mSelectedPosition, Math.round((1.0F - mIndicatorAnimator.getAnimatedFraction()) * (float)l));
      return;
    }
    updateIndicatorPosition();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {}
    int m;
    do
    {
      int n;
      int j;
      Object localObject;
      do
      {
        do
        {
          return;
        } while ((TabLayout.access$1800(this$0) != 1) || (TabLayout.access$2200(this$0) != 1));
        n = getChildCount();
        j = 0;
        i = 0;
        while (i < n)
        {
          localObject = getChildAt(i);
          k = j;
          if (((View)localObject).getVisibility() == 0) {
            k = Math.max(j, ((View)localObject).getMeasuredWidth());
          }
          i += 1;
          j = k;
        }
      } while (j <= 0);
      int k = TabLayout.access$2100(this$0, 16);
      int i = 0;
      if (j * n <= getMeasuredWidth() - k * 2)
      {
        k = 0;
        for (;;)
        {
          m = i;
          if (k >= n) {
            break;
          }
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((width != j) || (weight != 0.0F))
          {
            width = j;
            weight = 0.0F;
            i = 1;
          }
          k += 1;
        }
      }
      TabLayout.access$2202(this$0, 0);
      TabLayout.access$2300(this$0, false);
      m = 1;
    } while (m == 0);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  void setIndicatorPositionFromTabPosition(int paramInt, float paramFloat)
  {
    if ((mIndicatorAnimator != null) && (mIndicatorAnimator.isRunning())) {
      mIndicatorAnimator.cancel();
    }
    mSelectedPosition = paramInt;
    mSelectionOffset = paramFloat;
    updateIndicatorPosition();
  }
  
  void setSelectedIndicatorColor(int paramInt)
  {
    if (mSelectedIndicatorPaint.getColor() != paramInt)
    {
      mSelectedIndicatorPaint.setColor(paramInt);
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void setSelectedIndicatorHeight(int paramInt)
  {
    if (mSelectedIndicatorHeight != paramInt)
    {
      mSelectedIndicatorHeight = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TabLayout.SlidingTabStrip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */