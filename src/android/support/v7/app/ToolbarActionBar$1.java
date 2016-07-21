package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.Window.Callback;

final class ToolbarActionBar$1
  implements Runnable
{
  ToolbarActionBar$1(ToolbarActionBar paramToolbarActionBar) {}
  
  public final void run()
  {
    ToolbarActionBar localToolbarActionBar = this$0;
    Menu localMenu = localToolbarActionBar.getMenu();
    if ((localMenu instanceof MenuBuilder)) {}
    for (localMenuBuilder = (MenuBuilder)localMenu;; localMenuBuilder = null)
    {
      if (localMenuBuilder != null) {
        localMenuBuilder.stopDispatchingItemsChanged();
      }
      try
      {
        localMenu.clear();
        if ((!mWindowCallback.onCreatePanelMenu(0, localMenu)) || (!mWindowCallback.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localMenuBuilder == null) {
          break;
        }
        localMenuBuilder.startDispatchingItemsChanged();
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */