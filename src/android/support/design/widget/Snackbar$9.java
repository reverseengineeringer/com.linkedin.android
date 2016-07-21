package android.support.design.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class Snackbar$9
  extends ViewPropertyAnimatorListenerAdapter
{
  Snackbar$9(Snackbar paramSnackbar, int paramInt) {}
  
  public void onAnimationEnd(View paramView)
  {
    Snackbar.access$300(this$0, val$event);
  }
  
  public void onAnimationStart(View paramView)
  {
    Snackbar.access$400(this$0).animateChildrenOut(0, 180);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */