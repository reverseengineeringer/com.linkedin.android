package android.support.design.widget;

import android.view.View;

class Snackbar$6
  implements Snackbar.SnackbarLayout.OnLayoutChangeListener
{
  Snackbar$6(Snackbar paramSnackbar) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Snackbar.access$400(this$0).setOnLayoutChangeListener(null);
    if (Snackbar.access$500(this$0))
    {
      Snackbar.access$600(this$0);
      return;
    }
    Snackbar.access$700(this$0);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */