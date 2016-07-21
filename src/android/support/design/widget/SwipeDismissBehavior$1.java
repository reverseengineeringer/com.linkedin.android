package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.View;
import android.view.ViewParent;

class SwipeDismissBehavior$1
  extends ViewDragHelper.Callback
{
  private static final int INVALID_POINTER_ID = -1;
  private int mActivePointerId = -1;
  private int mOriginalCapturedViewLeft;
  
  SwipeDismissBehavior$1(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  private boolean shouldDismiss(View paramView, float paramFloat)
  {
    int i;
    if (paramFloat != 0.0F) {
      if (ViewCompat.getLayoutDirection(paramView) == 1)
      {
        i = 1;
        if (SwipeDismissBehavior.access$200(this$0) != 2) {
          break label34;
        }
      }
    }
    label34:
    label56:
    label64:
    label87:
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              i = 0;
              break;
              if (SwipeDismissBehavior.access$200(this$0) != 0) {
                break label64;
              }
              if (i == 0) {
                break label56;
              }
            } while (paramFloat < 0.0F);
            return false;
          } while (paramFloat > 0.0F);
          return false;
          if (SwipeDismissBehavior.access$200(this$0) != 1) {
            break label138;
          }
          if (i == 0) {
            break label87;
          }
        } while (paramFloat > 0.0F);
        return false;
      } while (paramFloat < 0.0F);
      return false;
      i = paramView.getLeft();
      j = mOriginalCapturedViewLeft;
      k = Math.round(paramView.getWidth() * SwipeDismissBehavior.access$300(this$0));
    } while (Math.abs(i - j) >= k);
    return false;
    label138:
    return false;
  }
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    int i;
    if (ViewCompat.getLayoutDirection(paramView) == 1)
    {
      paramInt2 = 1;
      if (SwipeDismissBehavior.access$200(this$0) != 0) {
        break label72;
      }
      if (paramInt2 == 0) {
        break label53;
      }
      i = mOriginalCapturedViewLeft - paramView.getWidth();
      paramInt2 = mOriginalCapturedViewLeft;
    }
    for (;;)
    {
      return SwipeDismissBehavior.access$400(i, paramInt1, paramInt2);
      paramInt2 = 0;
      break;
      label53:
      i = mOriginalCapturedViewLeft;
      paramInt2 = mOriginalCapturedViewLeft + paramView.getWidth();
      continue;
      label72:
      if (SwipeDismissBehavior.access$200(this$0) == 1)
      {
        if (paramInt2 != 0)
        {
          i = mOriginalCapturedViewLeft;
          paramInt2 = mOriginalCapturedViewLeft + paramView.getWidth();
        }
        else
        {
          i = mOriginalCapturedViewLeft - paramView.getWidth();
          paramInt2 = mOriginalCapturedViewLeft;
        }
      }
      else
      {
        i = mOriginalCapturedViewLeft - paramView.getWidth();
        paramInt2 = mOriginalCapturedViewLeft + paramView.getWidth();
      }
    }
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return paramView.getWidth();
  }
  
  public void onViewCaptured(View paramView, int paramInt)
  {
    mActivePointerId = paramInt;
    mOriginalCapturedViewLeft = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if (SwipeDismissBehavior.access$000(this$0) != null) {
      SwipeDismissBehavior.access$000(this$0).onDragStateChanged(paramInt);
    }
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = mOriginalCapturedViewLeft + paramView.getWidth() * SwipeDismissBehavior.access$500(this$0);
    float f2 = mOriginalCapturedViewLeft + paramView.getWidth() * SwipeDismissBehavior.access$600(this$0);
    if (paramInt1 <= f1)
    {
      ViewCompat.setAlpha(paramView, 1.0F);
      return;
    }
    if (paramInt1 >= f2)
    {
      ViewCompat.setAlpha(paramView, 0.0F);
      return;
    }
    ViewCompat.setAlpha(paramView, SwipeDismissBehavior.access$700(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, paramInt1), 1.0F));
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    mActivePointerId = -1;
    int i = paramView.getWidth();
    boolean bool = false;
    if (shouldDismiss(paramView, paramFloat1)) {
      if (paramView.getLeft() < mOriginalCapturedViewLeft)
      {
        i = mOriginalCapturedViewLeft - i;
        bool = true;
        label46:
        if (!SwipeDismissBehavior.access$100(this$0).settleCapturedViewAt(i, paramView.getTop())) {
          break label105;
        }
        ViewCompat.postOnAnimation(paramView, new SwipeDismissBehavior.SettleRunnable(this$0, paramView, bool));
      }
    }
    label105:
    while ((!bool) || (SwipeDismissBehavior.access$000(this$0) == null))
    {
      return;
      i = mOriginalCapturedViewLeft + i;
      break;
      i = mOriginalCapturedViewLeft;
      break label46;
    }
    SwipeDismissBehavior.access$000(this$0).onDismiss(paramView);
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    return (mActivePointerId == -1) && (this$0.canSwipeDismissView(paramView));
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */