package com.linkedin.android.feed.endor.ui.component.carousel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.view.View;

final class FeedCarouselScroller
  extends LinearSmoothScroller
{
  private boolean isRtl;
  
  FeedCarouselScroller(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    isRtl = paramBoolean;
  }
  
  public final PointF computeScrollVectorForPosition(int paramInt)
  {
    if (mLayoutManager == null) {
      return null;
    }
    return ((LinearLayoutManager)mLayoutManager).computeScrollVectorForPosition(paramInt);
  }
  
  protected final int getHorizontalSnapPreference()
  {
    if (isRtl) {
      return 1;
    }
    return -1;
  }
  
  protected final void onTargetFound$68abd3fe(View paramView, RecyclerView.SmoothScroller.Action paramAction)
  {
    if (mLayoutManager == null) {
      return;
    }
    int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
    if (i > 0) {
      i -= RecyclerView.LayoutManager.getLeftDecorationWidth(paramView);
    }
    for (;;)
    {
      int j = calculateTimeForDeceleration(i);
      if (j <= 0) {
        break;
      }
      paramAction.update(-i, 0, j, mDecelerateInterpolator);
      return;
      i += RecyclerView.LayoutManager.getRightDecorationWidth(paramView);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselScroller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */