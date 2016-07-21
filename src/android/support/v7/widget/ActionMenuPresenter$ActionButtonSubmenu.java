package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.MenuItem;
import android.view.View;

final class ActionMenuPresenter$ActionButtonSubmenu
  extends MenuPopupHelper
{
  private SubMenuBuilder mSubMenu;
  
  public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, SubMenuBuilder paramSubMenuBuilder)
  {
    super(paramContext, paramSubMenuBuilder, null, false, R.attr.actionOverflowMenuStyle);
    mSubMenu = paramSubMenuBuilder;
    boolean bool2;
    int j;
    int i;
    if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
    {
      if (mOverflowButton == null)
      {
        paramContext = (View)mMenuView;
        mAnchorView = paramContext;
      }
    }
    else
    {
      mPresenterCallback = mPopupPresenterCallback;
      bool2 = false;
      j = paramSubMenuBuilder.size();
      i = 0;
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        paramActionMenuPresenter = paramSubMenuBuilder.getItem(i);
        if ((paramActionMenuPresenter.isVisible()) && (paramActionMenuPresenter.getIcon() != null)) {
          bool1 = true;
        }
      }
      else
      {
        mForceShowIcon = bool1;
        return;
        paramContext = mOverflowButton;
        break;
      }
      i += 1;
    }
  }
  
  public final void onDismiss()
  {
    super.onDismiss();
    this$0.mActionButtonPopup = null;
    this$0.mOpenSubMenuId = 0;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.ActionButtonSubmenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */