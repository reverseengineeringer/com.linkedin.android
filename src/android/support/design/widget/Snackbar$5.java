package android.support.design.widget;

import android.os.Handler;
import android.view.View;

class Snackbar$5
  implements Snackbar.SnackbarLayout.OnAttachStateChangeListener
{
  Snackbar$5(Snackbar paramSnackbar) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (this$0.isShownOrQueued()) {
      Snackbar.access$100().post(new Runnable()
      {
        public void run()
        {
          Snackbar.access$300(this$0, 3);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */