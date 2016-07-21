package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class MenuItemCompat$HoneycombMenuVersionImpl
  implements MenuItemCompat.MenuVersionImpl
{
  public boolean collapseActionView(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean expandActionView(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final View getActionView(MenuItem paramMenuItem)
  {
    return paramMenuItem.getActionView();
  }
  
  public boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    return paramMenuItem.setActionView(paramInt);
  }
  
  public final MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    return paramMenuItem.setActionView(paramView);
  }
  
  public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    return paramMenuItem;
  }
  
  public final void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem.setShowAsAction(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.MenuItemCompat.HoneycombMenuVersionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */