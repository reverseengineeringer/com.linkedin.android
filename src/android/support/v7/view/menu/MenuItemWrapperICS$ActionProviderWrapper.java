package android.support.v7.view.menu;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;

class MenuItemWrapperICS$ActionProviderWrapper
  extends android.support.v4.view.ActionProvider
{
  final android.view.ActionProvider mInner;
  
  public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, Context paramContext, android.view.ActionProvider paramActionProvider)
  {
    super(paramContext);
    mInner = paramActionProvider;
  }
  
  public final boolean hasSubMenu()
  {
    return mInner.hasSubMenu();
  }
  
  public final View onCreateActionView()
  {
    return mInner.onCreateActionView();
  }
  
  public final boolean onPerformDefaultAction()
  {
    return mInner.onPerformDefaultAction();
  }
  
  public final void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    mInner.onPrepareSubMenu(this$0.getSubMenuWrapper(paramSubMenu));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS.ActionProviderWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */