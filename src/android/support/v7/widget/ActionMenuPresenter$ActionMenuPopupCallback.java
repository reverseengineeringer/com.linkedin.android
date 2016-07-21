package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItemView.PopupCallback;
import android.support.v7.view.menu.MenuPopupHelper;

final class ActionMenuPresenter$ActionMenuPopupCallback
  extends ActionMenuItemView.PopupCallback
{
  private ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public final ListPopupWindow getPopup()
  {
    if (this$0.mActionButtonPopup != null) {
      return this$0.mActionButtonPopup.mPopup;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionMenuPopupCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */