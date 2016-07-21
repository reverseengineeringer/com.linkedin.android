package android.support.v4.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;

final class DrawerLayout$ViewDragCallback
  extends ViewDragHelper.Callback
{
  final int mAbsGravity;
  ViewDragHelper mDragger;
  private final Runnable mPeekRunnable = new Runnable()
  {
    public final void run()
    {
      int k = 0;
      Object localObject2 = DrawerLayout.ViewDragCallback.this;
      int m = mDragger.mEdgeSize;
      int i;
      Object localObject1;
      int j;
      if (mAbsGravity == 3)
      {
        i = 1;
        if (i == 0) {
          break label227;
        }
        localObject1 = this$0.findDrawerWithGravity(3);
        if (localObject1 == null) {
          break label222;
        }
        j = -((View)localObject1).getWidth();
        label56:
        j += m;
      }
      for (;;)
      {
        label61:
        if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (this$0.getDrawerLockMode((View)localObject1) == 0))))
        {
          DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
          mDragger.smoothSlideViewTo((View)localObject1, j, ((View)localObject1).getTop());
          DrawerLayout.LayoutParams.access$202(localLayoutParams, true);
          this$0.invalidate();
          ((DrawerLayout.ViewDragCallback)localObject2).closeOtherDrawer();
          localObject1 = this$0;
          if (!mChildrenCanceledTouch)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            j = ((DrawerLayout)localObject1).getChildCount();
            i = k;
            for (;;)
            {
              if (i < j)
              {
                ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
                i += 1;
                continue;
                i = 0;
                break;
                label222:
                j = 0;
                break label56;
                label227:
                localObject1 = this$0.findDrawerWithGravity(5);
                j = this$0.getWidth();
                j -= m;
                break label61;
              }
            }
            ((MotionEvent)localObject2).recycle();
            mChildrenCanceledTouch = true;
          }
        }
      }
    }
  };
  
  public DrawerLayout$ViewDragCallback(DrawerLayout paramDrawerLayout, int paramInt)
  {
    mAbsGravity = paramInt;
  }
  
  public final int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (this$0.checkDrawerViewAbsoluteGravity(paramView, 3)) {
      return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
    }
    paramInt2 = this$0.getWidth();
    return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
  }
  
  public final int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  final void closeOtherDrawer()
  {
    int i = 3;
    if (mAbsGravity == 3) {
      i = 5;
    }
    View localView = this$0.findDrawerWithGravity(i);
    if (localView != null) {
      this$0.closeDrawer(localView);
    }
  }
  
  public final int getViewHorizontalDragRange(View paramView)
  {
    if (DrawerLayout.isDrawerView(paramView)) {
      return paramView.getWidth();
    }
    return 0;
  }
  
  public final void onEdgeDragStarted(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1) {}
    for (View localView = this$0.findDrawerWithGravity(3);; localView = this$0.findDrawerWithGravity(5))
    {
      if ((localView != null) && (this$0.getDrawerLockMode(localView) == 0)) {
        mDragger.captureChildView(localView, paramInt2);
      }
      return;
    }
  }
  
  public final boolean onEdgeLock(int paramInt)
  {
    return false;
  }
  
  public final void onEdgeTouched(int paramInt1, int paramInt2)
  {
    this$0.postDelayed(mPeekRunnable, 160L);
  }
  
  public final void onViewCaptured(View paramView, int paramInt)
  {
    DrawerLayout.LayoutParams.access$202((DrawerLayout.LayoutParams)paramView.getLayoutParams(), false);
    closeOtherDrawer();
  }
  
  public final void onViewDragStateChanged(int paramInt)
  {
    DrawerLayout localDrawerLayout = this$0;
    View localView = mDragger.mCapturedView;
    int i = mLeftDragger.mDragState;
    int j = mRightDragger.mDragState;
    if ((i == 1) || (j == 1)) {
      i = 1;
    }
    DrawerLayout.LayoutParams localLayoutParams;
    while ((localView != null) && (paramInt == 0))
    {
      localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      if (DrawerLayout.LayoutParams.access$000(localLayoutParams) != 0.0F) {
        break label267;
      }
      localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      if ((DrawerLayout.LayoutParams.access$100(localLayoutParams) & 0x1) == 1)
      {
        DrawerLayout.LayoutParams.access$102(localLayoutParams, 0);
        if (mListeners != null)
        {
          paramInt = mListeners.size() - 1;
          for (;;)
          {
            if (paramInt >= 0)
            {
              ((DrawerLayout.DrawerListener)mListeners.get(paramInt)).onDrawerClosed$3c7ec8c3();
              paramInt -= 1;
              continue;
              if ((i == 2) || (j == 2))
              {
                i = 2;
                break;
              }
              i = 0;
              break;
            }
          }
        }
        localDrawerLayout.updateChildrenImportantForAccessibility(localView, false);
        if (localDrawerLayout.hasWindowFocus())
        {
          localView = localDrawerLayout.getRootView();
          if (localView != null) {
            localView.sendAccessibilityEvent(32);
          }
        }
      }
    }
    while (i != mDrawerState)
    {
      mDrawerState = i;
      if (mListeners == null) {
        break;
      }
      paramInt = mListeners.size() - 1;
      while (paramInt >= 0)
      {
        mListeners.get(paramInt);
        paramInt -= 1;
      }
      label267:
      if (DrawerLayout.LayoutParams.access$000(localLayoutParams) == 1.0F)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if ((DrawerLayout.LayoutParams.access$100(localLayoutParams) & 0x1) == 0)
        {
          DrawerLayout.LayoutParams.access$102(localLayoutParams, 1);
          if (mListeners != null)
          {
            paramInt = mListeners.size() - 1;
            while (paramInt >= 0)
            {
              ((DrawerLayout.DrawerListener)mListeners.get(paramInt)).onDrawerOpened$3c7ec8c3();
              paramInt -= 1;
            }
          }
          localDrawerLayout.updateChildrenImportantForAccessibility(localView, true);
          if (localDrawerLayout.hasWindowFocus()) {
            localDrawerLayout.sendAccessibilityEvent(32);
          }
          localView.requestFocus();
        }
      }
    }
  }
  
  public final void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramView.getWidth();
    float f;
    if (this$0.checkDrawerViewAbsoluteGravity(paramView, 3))
    {
      f = (paramInt2 + paramInt1) / paramInt2;
      this$0.setDrawerViewOffset(paramView, f);
      if (f != 0.0F) {
        break label76;
      }
    }
    label76:
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      paramView.setVisibility(paramInt1);
      this$0.invalidate();
      return;
      f = (this$0.getWidth() - paramInt1) / paramInt2;
      break;
    }
  }
  
  public final void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat2 = DrawerLayout.getDrawerViewOffset(paramView);
    int j = paramView.getWidth();
    if (this$0.checkDrawerViewAbsoluteGravity(paramView, 3))
    {
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {}
      for (i = 0;; i = -j)
      {
        mDragger.settleCapturedViewAt(i, paramView.getTop());
        this$0.invalidate();
        return;
      }
    }
    int i = this$0.getWidth();
    if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
      i -= j;
    }
    for (;;)
    {
      break;
    }
  }
  
  public final void removeCallbacks()
  {
    this$0.removeCallbacks(mPeekRunnable);
  }
  
  public final boolean tryCaptureView(View paramView, int paramInt)
  {
    return (DrawerLayout.isDrawerView(paramView)) && (this$0.checkDrawerViewAbsoluteGravity(paramView, mAbsGravity)) && (this$0.getDrawerLockMode(paramView) == 0);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.DrawerLayout.ViewDragCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */