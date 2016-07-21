package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class LinearSmoothScroller
  extends RecyclerView.SmoothScroller
{
  private final float MILLISECONDS_PER_PX;
  public final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
  protected int mInterimTargetDx = 0;
  protected int mInterimTargetDy = 0;
  protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
  protected PointF mTargetVector;
  
  public LinearSmoothScroller(Context paramContext)
  {
    MILLISECONDS_PER_PX = (25.0F / getResourcesgetDisplayMetricsdensityDpi);
  }
  
  private int calculateTimeForScrolling(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * MILLISECONDS_PER_PX);
  }
  
  private static int clampApplyScroll(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt5)
    {
    default: 
      throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    case -1: 
      paramInt1 = paramInt3 - paramInt1;
    }
    do
    {
      return paramInt1;
      return paramInt4 - paramInt2;
      paramInt3 -= paramInt1;
      paramInt1 = paramInt3;
    } while (paramInt3 > 0);
    paramInt1 = paramInt4 - paramInt2;
    if (paramInt1 < 0) {
      return paramInt1;
    }
    return 0;
  }
  
  public final int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = mLayoutManager;
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollHorizontally())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(localLayoutManager.getDecoratedLeft(paramView) - leftMargin, localLayoutManager.getDecoratedRight(paramView) + rightMargin, localLayoutManager.getPaddingLeft(), mWidth - localLayoutManager.getPaddingRight(), paramInt);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = mLayoutManager;
    if ((localLayoutManager == null) || (!localLayoutManager.canScrollVertically())) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(localLayoutManager.getDecoratedTop(paramView) - topMargin, localLayoutManager.getDecoratedBottom(paramView) + bottomMargin, localLayoutManager.getPaddingTop(), mHeight - localLayoutManager.getPaddingBottom(), paramInt);
  }
  
  public final int calculateTimeForDeceleration(int paramInt)
  {
    return (int)Math.ceil(calculateTimeForScrolling(paramInt) / 0.3356D);
  }
  
  public abstract PointF computeScrollVectorForPosition(int paramInt);
  
  public int getHorizontalSnapPreference()
  {
    if ((mTargetVector == null) || (mTargetVector.x == 0.0F)) {
      return 0;
    }
    if (mTargetVector.x > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  public int getVerticalSnapPreference()
  {
    if ((mTargetVector == null) || (mTargetVector.y == 0.0F)) {
      return 0;
    }
    if (mTargetVector.y > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  protected final void onSeekTargetStep$64702b56(int paramInt1, int paramInt2, RecyclerView.SmoothScroller.Action paramAction)
  {
    if (getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      mInterimTargetDx = clampApplyScroll(mInterimTargetDx, paramInt1);
      mInterimTargetDy = clampApplyScroll(mInterimTargetDy, paramInt2);
    } while ((mInterimTargetDx != 0) || (mInterimTargetDy != 0));
    PointF localPointF = computeScrollVectorForPosition(mTargetPosition);
    if ((localPointF == null) || ((x == 0.0F) && (y == 0.0F)))
    {
      Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
      mJumpToPosition = mTargetPosition;
      stop();
      return;
    }
    double d = Math.sqrt(x * x + y * y);
    x = ((float)(x / d));
    y = ((float)(y / d));
    mTargetVector = localPointF;
    mInterimTargetDx = ((int)(x * 10000.0F));
    mInterimTargetDy = ((int)(y * 10000.0F));
    paramInt1 = calculateTimeForScrolling(10000);
    paramAction.update((int)(mInterimTargetDx * 1.2F), (int)(mInterimTargetDy * 1.2F), (int)(paramInt1 * 1.2F), mLinearInterpolator);
  }
  
  public void onStop()
  {
    mInterimTargetDy = 0;
    mInterimTargetDx = 0;
    mTargetVector = null;
  }
  
  public void onTargetFound$68abd3fe(View paramView, RecyclerView.SmoothScroller.Action paramAction)
  {
    int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
    int j = calculateDyToMakeVisible(paramView, getVerticalSnapPreference());
    int k = calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      paramAction.update(-i, -j, k, mDecelerateInterpolator);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearSmoothScroller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */