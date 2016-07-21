package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;

public final class NavigationSubMenu
  extends SubMenuBuilder
{
  public NavigationSubMenu(Context paramContext, NavigationMenu paramNavigationMenu, MenuItemImpl paramMenuItemImpl)
  {
    super(paramContext, paramNavigationMenu, paramMenuItemImpl);
  }
  
  public final void onItemsChanged(boolean paramBoolean)
  {
    super.onItemsChanged(paramBoolean);
    ((MenuBuilder)mParentMenu).onItemsChanged(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationSubMenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */