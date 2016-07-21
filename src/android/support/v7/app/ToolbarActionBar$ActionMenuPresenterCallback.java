package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.DecorToolbar;
import android.view.Window.Callback;

final class ToolbarActionBar$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private boolean mClosingActionMenu;
  
  private ToolbarActionBar$ActionMenuPresenterCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mClosingActionMenu) {
      return;
    }
    mClosingActionMenu = true;
    this$0.mDecorToolbar.dismissPopupMenus();
    if (this$0.mWindowCallback != null) {
      this$0.mWindowCallback.onPanelClosed(108, paramMenuBuilder);
    }
    mClosingActionMenu = false;
  }
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (this$0.mWindowCallback != null)
    {
      this$0.mWindowCallback.onMenuOpened(108, paramMenuBuilder);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.ActionMenuPresenterCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */