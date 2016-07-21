package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;

class BottomSheetBehavior$SettleRunnable
  implements Runnable
{
  private final int mTargetState;
  private final View mView;
  
  BottomSheetBehavior$SettleRunnable(BottomSheetBehavior paramBottomSheetBehavior, View paramView, int paramInt)
  {
    mView = paramView;
    mTargetState = paramInt;
  }
  
  public void run()
  {
    if ((BottomSheetBehavior.access$1200(this$0) != null) && (BottomSheetBehavior.access$1200(this$0).continueSettling$138603()))
    {
      ViewCompat.postOnAnimation(mView, this);
      return;
    }
    BottomSheetBehavior.access$600(this$0, mTargetState);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.SettleRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */