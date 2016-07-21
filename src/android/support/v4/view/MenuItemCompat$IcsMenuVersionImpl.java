package android.support.v4.view;

import android.view.MenuItem;

final class MenuItemCompat$IcsMenuVersionImpl
  extends MenuItemCompat.HoneycombMenuVersionImpl
{
  public final boolean collapseActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.collapseActionView();
  }
  
  public final boolean expandActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.expandActionView();
  }
  
  public final boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return paramMenuItem.isActionViewExpanded();
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem paramMenuItem, final MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    if (paramOnActionExpandListener == null) {
      return MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, null);
    }
    MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, new MenuItemCompatIcs.SupportActionExpandProxy()
    {
      public final boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
      {
        return paramOnActionExpandListener.onMenuItemActionCollapse(paramAnonymousMenuItem);
      }
      
      public final boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
      {
        return paramOnActionExpandListener.onMenuItemActionExpand(paramAnonymousMenuItem);
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.MenuItemCompat.IcsMenuVersionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */