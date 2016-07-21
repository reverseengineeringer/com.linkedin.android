package android.support.design.widget;

import android.view.View;

class Snackbar$4
  implements SwipeDismissBehavior.OnDismissListener
{
  Snackbar$4(Snackbar paramSnackbar) {}
  
  public void onDismiss(View paramView)
  {
    paramView.setVisibility(8);
    Snackbar.access$000(this$0, 0);
  }
  
  public void onDragStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      SnackbarManager.getInstance().cancelTimeout(Snackbar.access$200(this$0));
      return;
    }
    SnackbarManager.getInstance().restoreTimeout(Snackbar.access$200(this$0));
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */