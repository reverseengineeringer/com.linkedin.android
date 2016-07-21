package android.support.v7.view.menu;

import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class MenuItemWrapperICS$OnActionExpandListenerWrapper
  extends BaseWrapper<MenuItem.OnActionExpandListener>
  implements MenuItemCompat.OnActionExpandListener
{
  MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)mWrappedObject).onMenuItemActionCollapse(this$0.getMenuItemWrapper(paramMenuItem));
  }
  
  public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)mWrappedObject).onMenuItemActionExpand(this$0.getMenuItemWrapper(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */