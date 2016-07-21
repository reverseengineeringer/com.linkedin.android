package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class MenuItemWrapperICS$OnMenuItemClickListenerWrapper
  extends BaseWrapper<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)mWrappedObject).onMenuItemClick(this$0.getMenuItemWrapper(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS.OnMenuItemClickListenerWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */