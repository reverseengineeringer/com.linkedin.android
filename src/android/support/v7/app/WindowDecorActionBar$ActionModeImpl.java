package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.DecorToolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public final class WindowDecorActionBar$ActionModeImpl
  extends ActionMode
  implements MenuBuilder.Callback
{
  private final Context mActionModeContext;
  private ActionMode.Callback mCallback;
  private WeakReference<View> mCustomView;
  private final MenuBuilder mMenu;
  
  public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar paramWindowDecorActionBar, Context paramContext, ActionMode.Callback paramCallback)
  {
    mActionModeContext = paramContext;
    mCallback = paramCallback;
    paramWindowDecorActionBar = new MenuBuilder(paramContext);
    mDefaultShowAsAction = 1;
    mMenu = paramWindowDecorActionBar;
    mMenu.setCallback(this);
  }
  
  public final boolean dispatchOnCreate()
  {
    mMenu.stopDispatchingItemsChanged();
    try
    {
      boolean bool = mCallback.onCreateActionMode(this, mMenu);
      return bool;
    }
    finally
    {
      mMenu.startDispatchingItemsChanged();
    }
  }
  
  public final void finish()
  {
    if (this$0.mActionMode != this) {
      return;
    }
    if (!WindowDecorActionBar.access$700$49605cc3(WindowDecorActionBar.access$500(this$0), WindowDecorActionBar.access$600(this$0)))
    {
      this$0.mDeferredDestroyActionMode = this;
      this$0.mDeferredModeDestroyCallback = mCallback;
    }
    for (;;)
    {
      mCallback = null;
      this$0.animateToMode(false);
      ActionBarContextView localActionBarContextView = WindowDecorActionBar.access$800(this$0);
      if (mClose == null) {
        localActionBarContextView.killMode();
      }
      WindowDecorActionBar.access$900(this$0).getViewGroup().sendAccessibilityEvent(32);
      WindowDecorActionBar.access$400(this$0).setHideOnContentScrollEnabled(this$0.mHideOnContentScroll);
      this$0.mActionMode = null;
      return;
      mCallback.onDestroyActionMode(this);
    }
  }
  
  public final View getCustomView()
  {
    if (mCustomView != null) {
      return (View)mCustomView.get();
    }
    return null;
  }
  
  public final Menu getMenu()
  {
    return mMenu;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(mActionModeContext);
  }
  
  public final CharSequence getSubtitle()
  {
    return WindowDecorActionBar.access$800(this$0).getSubtitle();
  }
  
  public final CharSequence getTitle()
  {
    return WindowDecorActionBar.access$800(this$0).getTitle();
  }
  
  public final void invalidate()
  {
    if (this$0.mActionMode != this) {
      return;
    }
    mMenu.stopDispatchingItemsChanged();
    try
    {
      mCallback.onPrepareActionMode(this, mMenu);
      return;
    }
    finally
    {
      mMenu.startDispatchingItemsChanged();
    }
  }
  
  public final boolean isTitleOptional()
  {
    return access$800this$0).mTitleOptional;
  }
  
  public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (mCallback != null) {
      return mCallback.onActionItemClicked(this, paramMenuItem);
    }
    return false;
  }
  
  public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    if (mCallback == null) {
      return;
    }
    invalidate();
    WindowDecorActionBar.access$800(this$0).showOverflowMenu();
  }
  
  public final void setCustomView(View paramView)
  {
    WindowDecorActionBar.access$800(this$0).setCustomView(paramView);
    mCustomView = new WeakReference(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    setSubtitle(WindowDecorActionBar.access$1000(this$0).getResources().getString(paramInt));
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    WindowDecorActionBar.access$800(this$0).setSubtitle(paramCharSequence);
  }
  
  public final void setTitle(int paramInt)
  {
    setTitle(WindowDecorActionBar.access$1000(this$0).getResources().getString(paramInt));
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    WindowDecorActionBar.access$800(this$0).setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    WindowDecorActionBar.access$800(this$0).setTitleOptional(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.ActionModeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */