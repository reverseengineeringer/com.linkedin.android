package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.widget.PopupWindow;

final class ListPopupWindow$ResizePopupRunnable
  implements Runnable
{
  private ListPopupWindow$ResizePopupRunnable(ListPopupWindow paramListPopupWindow) {}
  
  public final void run()
  {
    if ((ListPopupWindow.access$600(this$0) != null) && (ViewCompat.isAttachedToWindow(ListPopupWindow.access$600(this$0))) && (ListPopupWindow.access$600(this$0).getCount() > ListPopupWindow.access$600(this$0).getChildCount()) && (ListPopupWindow.access$600(this$0).getChildCount() <= this$0.mListItemExpandMaximum))
    {
      ListPopupWindow.access$1100(this$0).setInputMethodMode(2);
      this$0.show();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ResizePopupRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */