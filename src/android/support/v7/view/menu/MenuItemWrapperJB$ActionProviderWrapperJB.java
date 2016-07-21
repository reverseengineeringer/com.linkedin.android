package android.support.v7.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

final class MenuItemWrapperJB$ActionProviderWrapperJB
  extends MenuItemWrapperICS.ActionProviderWrapper
  implements android.view.ActionProvider.VisibilityListener
{
  android.support.v4.view.ActionProvider.VisibilityListener mListener;
  
  public MenuItemWrapperJB$ActionProviderWrapperJB(MenuItemWrapperJB paramMenuItemWrapperJB, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramMenuItemWrapperJB, paramContext, paramActionProvider);
  }
  
  public final boolean isVisible()
  {
    return mInner.isVisible();
  }
  
  public final void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    if (mListener != null) {
      mListener.onActionProviderVisibilityChanged$1385ff();
    }
  }
  
  public final View onCreateActionView(MenuItem paramMenuItem)
  {
    return mInner.onCreateActionView(paramMenuItem);
  }
  
  public final boolean overridesItemVisibility()
  {
    return mInner.overridesItemVisibility();
  }
  
  public final void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener paramVisibilityListener)
  {
    mListener = paramVisibilityListener;
    mInner.setVisibilityListener(this);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperJB.ActionProviderWrapperJB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */