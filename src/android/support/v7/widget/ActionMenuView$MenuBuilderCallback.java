package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.view.MenuItem;

final class ActionMenuView$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  private ActionMenuView$MenuBuilderCallback(ActionMenuView paramActionMenuView) {}
  
  public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (ActionMenuView.access$200(this$0) != null) && (ActionMenuView.access$200(this$0).onMenuItemClick(paramMenuItem));
  }
  
  public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (ActionMenuView.access$300(this$0) != null) {
      ActionMenuView.access$300(this$0).onMenuModeChange(paramMenuBuilder);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuView.MenuBuilderCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */