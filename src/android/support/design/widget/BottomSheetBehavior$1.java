package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.View;
import java.lang.ref.WeakReference;

class BottomSheetBehavior$1
  extends ViewDragHelper.Callback
{
  BottomSheetBehavior$1(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getLeft();
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    int i = BottomSheetBehavior.access$700(this$0);
    if (BottomSheetBehavior.access$800(this$0)) {}
    for (paramInt2 = BottomSheetBehavior.access$1000(this$0);; paramInt2 = BottomSheetBehavior.access$1100(this$0)) {
      return MathUtils.constrain(paramInt1, i, paramInt2);
    }
  }
  
  public int getViewVerticalDragRange(View paramView)
  {
    if (BottomSheetBehavior.access$800(this$0)) {
      return BottomSheetBehavior.access$1000(this$0) - BottomSheetBehavior.access$700(this$0);
    }
    return BottomSheetBehavior.access$1100(this$0) - BottomSheetBehavior.access$700(this$0);
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      BottomSheetBehavior.access$600(this$0, 1);
    }
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BottomSheetBehavior.access$500(this$0, paramInt2);
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    int j;
    int i;
    if (paramFloat2 < 0.0F)
    {
      j = BottomSheetBehavior.access$700(this$0);
      i = 3;
    }
    while (BottomSheetBehavior.access$1200(this$0).settleCapturedViewAt(paramView.getLeft(), j))
    {
      BottomSheetBehavior.access$600(this$0, 2);
      ViewCompat.postOnAnimation(paramView, new BottomSheetBehavior.SettleRunnable(this$0, paramView, i));
      return;
      if ((BottomSheetBehavior.access$800(this$0)) && (BottomSheetBehavior.access$900(this$0, paramView, paramFloat2)))
      {
        j = BottomSheetBehavior.access$1000(this$0);
        i = 5;
      }
      else if (paramFloat2 == 0.0F)
      {
        i = paramView.getTop();
        if (Math.abs(i - BottomSheetBehavior.access$700(this$0)) < Math.abs(i - BottomSheetBehavior.access$1100(this$0)))
        {
          j = BottomSheetBehavior.access$700(this$0);
          i = 3;
        }
        else
        {
          j = BottomSheetBehavior.access$1100(this$0);
          i = 4;
        }
      }
      else
      {
        j = BottomSheetBehavior.access$1100(this$0);
        i = 4;
      }
    }
    BottomSheetBehavior.access$600(this$0, i);
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    if (BottomSheetBehavior.access$000(this$0) == 1) {}
    do
    {
      View localView;
      do
      {
        do
        {
          return false;
        } while (BottomSheetBehavior.access$100(this$0));
        if ((BottomSheetBehavior.access$000(this$0) != 3) || (BottomSheetBehavior.access$200(this$0) != paramInt)) {
          break;
        }
        localView = (View)BottomSheetBehavior.access$300(this$0).get();
      } while ((localView != null) && (ViewCompat.canScrollVertically(localView, -1)));
    } while ((BottomSheetBehavior.access$400(this$0) == null) || (BottomSheetBehavior.access$400(this$0).get() != paramView));
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */