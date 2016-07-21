package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.View;

final class ActionMenuPresenter$OverflowPopup
  extends MenuPopupHelper
{
  public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    super(paramContext, paramMenuBuilder, paramView, true, R.attr.actionOverflowMenuStyle);
    mDropDownGravity = 8388613;
    mPresenterCallback = mPopupPresenterCallback;
  }
  
  public final void onDismiss()
  {
    super.onDismiss();
    if (this$0.mMenu != null) {
      this$0.mMenu.close();
    }
    this$0.mOverflowPopup = null;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowPopup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */