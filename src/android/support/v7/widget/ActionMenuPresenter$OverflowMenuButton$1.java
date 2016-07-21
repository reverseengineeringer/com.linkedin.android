package android.support.v7.widget;

import android.support.v7.view.menu.MenuPopupHelper;
import android.view.View;

final class ActionMenuPresenter$OverflowMenuButton$1
  extends ListPopupWindow.ForwardingListener
{
  ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter.OverflowMenuButton paramOverflowMenuButton, View paramView, ActionMenuPresenter paramActionMenuPresenter)
  {
    super(paramView);
  }
  
  public final ListPopupWindow getPopup()
  {
    if (this$1.this$0.mOverflowPopup == null) {
      return null;
    }
    return this$1.this$0.mOverflowPopup.mPopup;
  }
  
  public final boolean onForwardingStarted()
  {
    this$1.this$0.showOverflowMenu();
    return true;
  }
  
  public final boolean onForwardingStopped()
  {
    if (this$1.this$0.mPostedOpenRunnable != null) {
      return false;
    }
    this$1.this$0.hideOverflowMenu();
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */