package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class MenuItemCompatIcs
{
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, SupportActionExpandProxy paramSupportActionExpandProxy)
  {
    return paramMenuItem.setOnActionExpandListener(new OnActionExpandListenerWrapper(paramSupportActionExpandProxy));
  }
  
  static final class OnActionExpandListenerWrapper
    implements MenuItem.OnActionExpandListener
  {
    private MenuItemCompatIcs.SupportActionExpandProxy mWrapped;
    
    public OnActionExpandListenerWrapper(MenuItemCompatIcs.SupportActionExpandProxy paramSupportActionExpandProxy)
    {
      mWrapped = paramSupportActionExpandProxy;
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return mWrapped.onMenuItemActionCollapse(paramMenuItem);
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return mWrapped.onMenuItemActionExpand(paramMenuItem);
    }
  }
  
  static abstract interface SupportActionExpandProxy
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.MenuItemCompatIcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */