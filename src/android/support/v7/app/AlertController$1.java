package android.support.v7.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

final class AlertController$1
  implements View.OnClickListener
{
  AlertController$1(AlertController paramAlertController) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView == this$0.mButtonPositive) && (this$0.mButtonPositiveMessage != null)) {
      paramView = Message.obtain(this$0.mButtonPositiveMessage);
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.sendToTarget();
      }
      this$0.mHandler.obtainMessage(1, this$0.mDialog).sendToTarget();
      return;
      if ((paramView == this$0.mButtonNegative) && (this$0.mButtonNegativeMessage != null)) {
        paramView = Message.obtain(this$0.mButtonNegativeMessage);
      } else if ((paramView == this$0.mButtonNeutral) && (this$0.mButtonNeutralMessage != null)) {
        paramView = Message.obtain(this$0.mButtonNeutralMessage);
      } else {
        paramView = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */