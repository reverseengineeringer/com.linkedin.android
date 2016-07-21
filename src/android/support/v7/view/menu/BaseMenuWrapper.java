package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class BaseMenuWrapper<T>
  extends BaseWrapper<T>
{
  final Context mContext;
  Map<SupportMenuItem, MenuItem> mMenuItems;
  Map<SupportSubMenu, SubMenu> mSubMenus;
  
  BaseMenuWrapper(Context paramContext, T paramT)
  {
    super(paramT);
    mContext = paramContext;
  }
  
  final MenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)paramMenuItem;
      if (mMenuItems == null) {
        mMenuItems = new ArrayMap();
      }
      MenuItem localMenuItem = (MenuItem)mMenuItems.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = MenuWrapperFactory.wrapSupportMenuItem(mContext, localSupportMenuItem);
        mMenuItems.put(localSupportMenuItem, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (mSubMenus == null) {
        mSubMenus = new ArrayMap();
      }
      SubMenu localSubMenu = (SubMenu)mSubMenus.get(localSupportSubMenu);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = mContext;
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramSubMenu = new SubMenuWrapperICS(paramSubMenu, localSupportSubMenu);
          mSubMenus.put(localSupportSubMenu, paramSubMenu);
        }
      }
      else
      {
        return paramSubMenu;
      }
      throw new UnsupportedOperationException();
    }
    return paramSubMenu;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.BaseMenuWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */