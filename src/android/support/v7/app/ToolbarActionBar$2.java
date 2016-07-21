package android.support.v7.app;

import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.Window.Callback;

final class ToolbarActionBar$2
  implements Toolbar.OnMenuItemClickListener
{
  ToolbarActionBar$2(ToolbarActionBar paramToolbarActionBar) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return this$0.mWindowCallback.onMenuItemSelected(0, paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */