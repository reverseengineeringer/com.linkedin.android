package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder
  extends MenuBuilder
  implements SubMenu
{
  private MenuItemImpl mItem;
  public MenuBuilder mParentMenu;
  
  public SubMenuBuilder(Context paramContext, MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    super(paramContext);
    mParentMenu = paramMenuBuilder;
    mItem = paramMenuItemImpl;
  }
  
  public final boolean collapseItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    return mParentMenu.collapseItemActionView(paramMenuItemImpl);
  }
  
  final boolean dispatchMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (super.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem)) || (mParentMenu.dispatchMenuItemSelected(paramMenuBuilder, paramMenuItem));
  }
  
  public final boolean expandItemActionView(MenuItemImpl paramMenuItemImpl)
  {
    return mParentMenu.expandItemActionView(paramMenuItemImpl);
  }
  
  public final String getActionViewStatesKey()
  {
    if (mItem != null) {}
    for (int i = mItem.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.getActionViewStatesKey() + ":" + i;
  }
  
  public MenuItem getItem()
  {
    return mItem;
  }
  
  public final MenuBuilder getRootMenu()
  {
    return mParentMenu;
  }
  
  public final boolean isQwertyMode()
  {
    return mParentMenu.isQwertyMode();
  }
  
  public final boolean isShortcutsVisible()
  {
    return mParentMenu.isShortcutsVisible();
  }
  
  public final void setCallback(MenuBuilder.Callback paramCallback)
  {
    mParentMenu.setCallback(paramCallback);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.setHeaderIconInt(ContextCompat.getDrawable(mContext, paramInt));
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.setHeaderIconInt(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.setHeaderTitleInt(mContext.getResources().getString(paramInt));
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.setHeaderTitleInt(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.setHeaderInternal$6c64639d(null, null, paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    mItem.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    mItem.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    mParentMenu.setQwertyMode(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.SubMenuBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */