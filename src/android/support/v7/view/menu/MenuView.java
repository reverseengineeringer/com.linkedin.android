package android.support.v7.view.menu;

public abstract interface MenuView
{
  public abstract void initialize(MenuBuilder paramMenuBuilder);
  
  public static abstract interface ItemView
  {
    public abstract MenuItemImpl getItemData();
    
    public abstract void initialize$667f453d(MenuItemImpl paramMenuItemImpl);
    
    public abstract boolean prefersCondensedTitle();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */