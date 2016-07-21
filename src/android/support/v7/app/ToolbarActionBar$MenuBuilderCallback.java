package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.DecorToolbar;
import android.view.MenuItem;
import android.view.Window.Callback;

final class ToolbarActionBar$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  private ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (this$0.mWindowCallback != null)
    {
      if (!this$0.mDecorToolbar.isOverflowMenuShowing()) {
        break label41;
      }
      this$0.mWindowCallback.onPanelClosed(108, paramMenuBuilder);
    }
    label41:
    while (!this$0.mWindowCallback.onPreparePanel(0, null, paramMenuBuilder)) {
      return;
    }
    this$0.mWindowCallback.onMenuOpened(108, paramMenuBuilder);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.MenuBuilderCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */