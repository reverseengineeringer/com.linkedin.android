package android.support.design.widget;

import android.os.Handler;

class Snackbar$3
  implements SnackbarManager.Callback
{
  Snackbar$3(Snackbar paramSnackbar) {}
  
  public void dismiss(int paramInt)
  {
    Snackbar.access$100().sendMessage(Snackbar.access$100().obtainMessage(1, paramInt, 0, this$0));
  }
  
  public void show()
  {
    Snackbar.access$100().sendMessage(Snackbar.access$100().obtainMessage(0, this$0));
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */