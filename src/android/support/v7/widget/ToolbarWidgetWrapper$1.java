package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window.Callback;

final class ToolbarWidgetWrapper$1
  implements View.OnClickListener
{
  final ActionMenuItem mNavItem = new ActionMenuItem(this$0.mToolbar.getContext(), this$0.mTitle);
  
  ToolbarWidgetWrapper$1(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public final void onClick(View paramView)
  {
    if ((this$0.mWindowCallback != null) && (this$0.mMenuPrepared)) {
      this$0.mWindowCallback.onMenuItemSelected(0, mNavItem);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ToolbarWidgetWrapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */