package android.support.v7.widget;

import android.view.View;

final class ListPopupWindow$2
  implements Runnable
{
  ListPopupWindow$2(ListPopupWindow paramListPopupWindow) {}
  
  public final void run()
  {
    View localView = this$0.mDropDownAnchorView;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this$0.show();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */