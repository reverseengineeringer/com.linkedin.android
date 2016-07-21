package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Window.Callback;

final class ToolbarActionBar$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private ToolbarActionBar$PanelMenuPresenterCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this$0.mWindowCallback != null) {
      this$0.mWindowCallback.onPanelClosed(0, paramMenuBuilder);
    }
  }
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (this$0.mWindowCallback != null)) {
      this$0.mWindowCallback.onMenuOpened(0, paramMenuBuilder);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.PanelMenuPresenterCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */