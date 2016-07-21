package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.View;

class SwipeDismissBehavior$SettleRunnable
  implements Runnable
{
  private final boolean mDismiss;
  private final View mView;
  
  SwipeDismissBehavior$SettleRunnable(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    mView = paramView;
    mDismiss = paramBoolean;
  }
  
  public void run()
  {
    if ((SwipeDismissBehavior.access$100(this$0) != null) && (SwipeDismissBehavior.access$100(this$0).continueSettling$138603())) {
      ViewCompat.postOnAnimation(mView, this);
    }
    while ((!mDismiss) || (SwipeDismissBehavior.access$000(this$0) == null)) {
      return;
    }
    SwipeDismissBehavior.access$000(this$0).onDismiss(mView);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior.SettleRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */