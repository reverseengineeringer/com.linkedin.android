package android.support.design.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class Snackbar$7
  extends ViewPropertyAnimatorListenerAdapter
{
  Snackbar$7(Snackbar paramSnackbar) {}
  
  public void onAnimationEnd(View paramView)
  {
    Snackbar.access$700(this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    Snackbar.access$400(this$0).animateChildrenIn(70, 180);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */