package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class AppCompatDelegateImplBase
  extends AppCompatDelegate
{
  ActionBar mActionBar;
  final AppCompatCallback mAppCompatCallback;
  final Window.Callback mAppCompatWindowCallback;
  final Context mContext;
  boolean mHasActionBar;
  boolean mIsDestroyed;
  boolean mIsFloating;
  MenuInflater mMenuInflater;
  final Window.Callback mOriginalWindowCallback;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  CharSequence mTitle;
  final Window mWindow;
  boolean mWindowNoTitle;
  
  AppCompatDelegateImplBase(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    mContext = paramContext;
    mWindow = paramWindow;
    mAppCompatCallback = paramAppCompatCallback;
    mOriginalWindowCallback = mWindow.getCallback();
    if ((mOriginalWindowCallback instanceof AppCompatWindowCallbackBase)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    mAppCompatWindowCallback = wrapWindowCallback(mOriginalWindowCallback);
    mWindow.setCallback(mAppCompatWindowCallback);
  }
  
  public boolean applyDayNight()
  {
    return false;
  }
  
  abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  final Context getActionBarThemedContext()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = mContext;
    }
    return (Context)localObject;
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarDrawableToggleImpl((byte)0);
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (mMenuInflater == null)
    {
      initWindowDecorActionBar();
      if (mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = mActionBar.getThemedContext();; localContext = mContext)
    {
      mMenuInflater = new SupportMenuInflater(localContext);
      return mMenuInflater;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return mActionBar;
  }
  
  abstract void initWindowDecorActionBar();
  
  public void onDestroy()
  {
    mIsDestroyed = true;
  }
  
  abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean onMenuOpened$2fef5512(int paramInt);
  
  abstract void onPanelClosed$2fef5516(int paramInt);
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  abstract void onTitleChanged(CharSequence paramCharSequence);
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    onTitleChanged(paramCharSequence);
  }
  
  abstract ActionMode startSupportActionModeFromWindow(ActionMode.Callback paramCallback);
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackBase(paramCallback);
  }
  
  private final class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate
  {
    private ActionBarDrawableToggleImpl() {}
    
    public final void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  class AppCompatWindowCallbackBase
    extends WindowCallbackWrapper
  {
    AppCompatWindowCallbackBase(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplBase.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      onMenuOpened$2fef5512(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      onPanelClosed$2fef5516(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      MenuBuilder localMenuBuilder;
      boolean bool1;
      if ((paramMenu instanceof MenuBuilder))
      {
        localMenuBuilder = (MenuBuilder)paramMenu;
        if ((paramInt != 0) || (localMenuBuilder != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localMenuBuilder = null;
        break;
        if (localMenuBuilder != null) {
          mOverrideVisibleItems = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localMenuBuilder == null);
      mOverrideVisibleItems = false;
      return bool2;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */