package android.support.v7.view.menu;

import android.view.View;
import android.widget.FrameLayout;

final class MenuItemWrapperICS$CollapsibleActionViewWrapper
  extends FrameLayout
  implements android.support.v7.view.CollapsibleActionView
{
  final android.view.CollapsibleActionView mWrappedView;
  
  MenuItemWrapperICS$CollapsibleActionViewWrapper(View paramView)
  {
    super(paramView.getContext());
    mWrappedView = ((android.view.CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public final void onActionViewCollapsed()
  {
    mWrappedView.onActionViewCollapsed();
  }
  
  public final void onActionViewExpanded()
  {
    mWrappedView.onActionViewExpanded();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */