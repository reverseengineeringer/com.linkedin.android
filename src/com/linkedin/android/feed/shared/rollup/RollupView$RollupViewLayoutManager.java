package com.linkedin.android.feed.shared.rollup;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;

final class RollupView$RollupViewLayoutManager
  extends RecyclerView.LayoutManager
{
  private final int itemPadding;
  private final int itemSize;
  
  private RollupView$RollupViewLayoutManager(RollupView paramRollupView, int paramInt1, int paramInt2)
  {
    itemSize = paramInt1;
    itemPadding = paramInt2;
  }
  
  public final boolean canScrollHorizontally()
  {
    return false;
  }
  
  public final boolean canScrollVertically()
  {
    return false;
  }
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int m = Math.min(getItemCount(), RollupView.access$200(this$0));
    int k;
    if (ViewCompat.getLayoutDirection(mRecyclerView) == 1)
    {
      i = mWidth - getPaddingRight();
      j = 0;
      while (j < m)
      {
        paramState = paramRecycler.getViewForPosition(j);
        addViewInt(paramState, -1, false);
        measureChild$17e143a3(paramState);
        k = i - getDecoratedMeasuredWidth(paramState);
        layoutDecorated(paramState, k, 0, i, paramState.getMeasuredHeight());
        j += 1;
        i = k;
      }
    }
    int i = getPaddingLeft();
    int j = 0;
    while (j < m)
    {
      paramState = paramRecycler.getViewForPosition(j);
      addViewInt(paramState, -1, false);
      measureChild$17e143a3(paramState);
      k = i + getDecoratedMeasuredWidth(paramState);
      layoutDecorated(paramState, i, 0, k, paramState.getMeasuredHeight());
      j += 1;
      i = k;
    }
  }
  
  public final void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    super.onMeasure(paramRecycler, paramState, paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = itemSize;
    int k = itemPadding;
    RollupView.access$202(this$0, (paramInt1 - (paramInt2 + i) - itemSize) / (j + k) + 1);
  }
  
  public final void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.rollup.RollupView.RollupViewLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */