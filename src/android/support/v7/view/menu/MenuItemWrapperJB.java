package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
final class MenuItemWrapperJB
  extends MenuItemWrapperICS
{
  MenuItemWrapperJB(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    super(paramContext, paramSupportMenuItem);
  }
  
  final MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider paramActionProvider)
  {
    return new ActionProviderWrapperJB(mContext, paramActionProvider);
  }
  
  final class ActionProviderWrapperJB
    extends MenuItemWrapperICS.ActionProviderWrapper
    implements android.view.ActionProvider.VisibilityListener
  {
    android.support.v4.view.ActionProvider.VisibilityListener mListener;
    
    public ActionProviderWrapperJB(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
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
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuItemWrapperJB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */