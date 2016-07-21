package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

public abstract interface MenuPresenter
{
  public abstract boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl);
  
  public abstract boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl);
  
  public abstract boolean flagActionItems();
  
  public abstract int getId();
  
  public abstract void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder);
  
  public abstract void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean);
  
  public abstract void onRestoreInstanceState(Parcelable paramParcelable);
  
  public abstract Parcelable onSaveInstanceState();
  
  public abstract boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder);
  
  public abstract void updateMenuView(boolean paramBoolean);
  
  public static abstract interface Callback
  {
    public abstract void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean);
    
    public abstract boolean onOpenSubMenu(MenuBuilder paramMenuBuilder);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */