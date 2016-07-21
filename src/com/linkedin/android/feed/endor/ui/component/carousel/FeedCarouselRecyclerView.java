package com.linkedin.android.feed.endor.ui.component.carousel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.Util;

public class FeedCarouselRecyclerView
  extends RecyclerView
{
  FeedCarouselAdapter adapter;
  private CarouselLayoutManager carouselLayoutManager;
  private View currentTargetView;
  private float downX;
  private float dx;
  private boolean hasCalledOnPageChanged;
  private boolean needAdjust;
  private OnPageChangedListener onPageChangedListener;
  private int positionBeforeScroll;
  private int smoothScrollTargetPosition;
  
  public FeedCarouselRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FeedCarouselRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FeedCarouselRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutManager(new CarouselLayoutManager(paramContext, paramAttributeSet, paramInt, (byte)0));
    setNestedScrollingEnabled(false);
  }
  
  private int clampPosition(int paramInt)
  {
    return Math.max(0, Math.min(paramInt, adapter.getItemCount() - 1));
  }
  
  private void dispatchOnPageChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    do
    {
      return;
      if (paramInt2 > paramInt1)
      {
        adapter.registerSwipe(2);
        return;
      }
    } while (paramInt2 >= paramInt1);
    adapter.registerSwipe(1);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      downX = paramMotionEvent.getX();
      dx = 0.0F;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling((int)(paramInt1 * 0.15F), (int)(paramInt2 * 0.15F));
    if ((bool) && (getChildCount() > 0)) {
      smoothScrollToPosition(clampPosition(clampPosition(getTargetViewPosition())));
    }
    return bool;
  }
  
  public int getTargetViewPosition()
  {
    int j = -1;
    int i = adapter.getItemCount();
    if (i == 0)
    {
      i = 0;
      return i;
    }
    int k = i - 1;
    Object localObject = carouselLayoutManager;
    localObject = ((LinearLayoutManager)localObject).findOneVisibleChild(((LinearLayoutManager)localObject).getChildCount() - 1, -1, true, false);
    if (localObject == null) {}
    for (;;)
    {
      i = k;
      if (j == k) {
        break;
      }
      i = carouselLayoutManager.findFirstVisibleItemPosition();
      if (dx < 0.0F) {
        break label85;
      }
      return i;
      j = LinearLayoutManager.getPosition((View)localObject);
    }
    label85:
    return i + 1;
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    super.onScrollStateChanged(paramInt);
    currentTargetView = carouselLayoutManager.findViewByPosition(getTargetViewPosition());
    if (paramInt == 1)
    {
      needAdjust = true;
      if (currentTargetView != null) {
        if (hasCalledOnPageChanged)
        {
          positionBeforeScroll = getChildLayoutPosition(currentTargetView);
          hasCalledOnPageChanged = false;
        }
      }
    }
    do
    {
      do
      {
        return;
        positionBeforeScroll = -1;
        return;
        if (paramInt == 2)
        {
          needAdjust = false;
          currentTargetView = null;
          return;
        }
      } while (paramInt != 0);
      if ((needAdjust) && (currentTargetView != null))
      {
        smoothScrollToPosition(clampPosition(getChildAdapterPosition(currentTargetView)));
        return;
      }
    } while (smoothScrollTargetPosition == positionBeforeScroll);
    dispatchOnPageChanged(positionBeforeScroll, smoothScrollTargetPosition);
    hasCalledOnPageChanged = true;
    positionBeforeScroll = smoothScrollTargetPosition;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    float f2;
    if (paramMotionEvent.getAction() == 2)
    {
      f1 = paramMotionEvent.getX();
      f2 = downX;
      if (!carouselLayoutManager.isLayoutRTL()) {
        break label48;
      }
    }
    label48:
    for (int i = -1;; i = 1)
    {
      dx = (i * (f1 - f2));
      return super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public final void scrollToPosition(int paramInt)
  {
    positionBeforeScroll = getTargetViewPosition();
    smoothScrollTargetPosition = paramInt;
    super.scrollToPosition(paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        JellyBeanUtils.removeOnGlobalLayoutListener(getViewTreeObserver(), this);
        if ((smoothScrollTargetPosition >= 0) && (smoothScrollTargetPosition < adapter.getItemCount())) {
          FeedCarouselRecyclerView.this.dispatchOnPageChanged(positionBeforeScroll, smoothScrollTargetPosition);
        }
      }
    });
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if ((paramAdapter instanceof FeedCarouselAdapter))
    {
      super.setAdapter(paramAdapter);
      adapter = ((FeedCarouselAdapter)paramAdapter);
    }
    while (paramAdapter == null) {
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Adapter must be a FeedCarouselAdapter"));
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof CarouselLayoutManager))
    {
      super.setLayoutManager(paramLayoutManager);
      carouselLayoutManager = ((CarouselLayoutManager)paramLayoutManager);
    }
    while (paramLayoutManager == null) {
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Layout manager must be a CarouselLayoutManager"));
  }
  
  public void setOnPageChangedListener(OnPageChangedListener paramOnPageChangedListener)
  {
    onPageChangedListener = paramOnPageChangedListener;
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    smoothScrollTargetPosition = paramInt;
    FeedCarouselScroller localFeedCarouselScroller = new FeedCarouselScroller(getContext(), carouselLayoutManager.isLayoutRTL());
    mTargetPosition = paramInt;
    carouselLayoutManager.startSmoothScroll(localFeedCarouselScroller);
  }
  
  private static final class CarouselLayoutManager
    extends LinearLayoutManager
  {
    private CarouselLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt, 0);
      setOrientation(0);
    }
  }
  
  public static abstract interface OnPageChangedListener {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselRecyclerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */