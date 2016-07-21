package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.ListAdapter;
import java.util.ArrayList;

final class ToolbarActionBar
  extends ActionBar
{
  DecorToolbar mDecorToolbar;
  private boolean mLastMenuVisibility;
  ListMenuPresenter mListMenuPresenter;
  private boolean mMenuCallbackSet;
  private final Toolbar.OnMenuItemClickListener mMenuClicker = new Toolbar.OnMenuItemClickListener()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return mWindowCallback.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  private final Runnable mMenuInvalidator = new Runnable()
  {
    public final void run()
    {
      ToolbarActionBar localToolbarActionBar = ToolbarActionBar.this;
      Menu localMenu = localToolbarActionBar.getMenu();
      if ((localMenu instanceof MenuBuilder)) {}
      for (localMenuBuilder = (MenuBuilder)localMenu;; localMenuBuilder = null)
      {
        if (localMenuBuilder != null) {
          localMenuBuilder.stopDispatchingItemsChanged();
        }
        try
        {
          localMenu.clear();
          if ((!mWindowCallback.onCreatePanelMenu(0, localMenu)) || (!mWindowCallback.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localMenuBuilder == null) {
            break;
          }
          localMenuBuilder.startDispatchingItemsChanged();
        }
      }
    }
  };
  private ArrayList<Object> mMenuVisibilityListeners = new ArrayList();
  boolean mToolbarMenuPrepared;
  Window.Callback mWindowCallback;
  
  public ToolbarActionBar(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    mDecorToolbar = new ToolbarWidgetWrapper(paramToolbar, false);
    mWindowCallback = new ToolbarCallbackWrapper(paramCallback);
    mDecorToolbar.setWindowCallback(mWindowCallback);
    paramToolbar.setOnMenuItemClickListener(mMenuClicker);
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = mDecorToolbar.getDisplayOptions();
    mDecorToolbar.setDisplayOptions(paramInt1 & paramInt2 | (paramInt2 ^ 0xFFFFFFFF) & i);
  }
  
  public final boolean collapseActionView()
  {
    if (mDecorToolbar.hasExpandedActionView())
    {
      mDecorToolbar.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean == mLastMenuVisibility) {}
    for (;;)
    {
      return;
      mLastMenuVisibility = paramBoolean;
      int j = mMenuVisibilityListeners.size();
      int i = 0;
      while (i < j)
      {
        mMenuVisibilityListeners.get(i);
        i += 1;
      }
    }
  }
  
  public final int getDisplayOptions()
  {
    return mDecorToolbar.getDisplayOptions();
  }
  
  public final float getElevation()
  {
    return ViewCompat.getElevation(mDecorToolbar.getViewGroup());
  }
  
  final Menu getMenu()
  {
    if (!mMenuCallbackSet)
    {
      mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback((byte)0), new MenuBuilderCallback((byte)0));
      mMenuCallbackSet = true;
    }
    return mDecorToolbar.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return mDecorToolbar.getContext();
  }
  
  public final void hide()
  {
    mDecorToolbar.setVisibility(8);
  }
  
  public final boolean invalidateOptionsMenu()
  {
    mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
    ViewCompat.postOnAnimation(mDecorToolbar.getViewGroup(), mMenuInvalidator);
    return true;
  }
  
  public final boolean isShowing()
  {
    return mDecorToolbar.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    mDecorToolbar.getViewGroup().removeCallbacks(mMenuInvalidator);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = getMenu();
    int i;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label56;
      }
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label61;
      }
    }
    label56:
    label61:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return true;
      i = -1;
      break;
    }
  }
  
  public final boolean requestFocus()
  {
    ViewGroup localViewGroup = mDecorToolbar.getViewGroup();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public final void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {}
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public final void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      setDisplayOptions(i, 8);
      return;
    }
  }
  
  public final void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(mDecorToolbar.getViewGroup(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    mDecorToolbar.setNavigationContentDescription(paramInt);
  }
  
  public final void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    mDecorToolbar.setNavigationIcon(paramDrawable);
  }
  
  public final void setNavigationMode$13462e()
  {
    mDecorToolbar.setNavigationMode$13462e();
  }
  
  public final void setShowHideAnimationEnabled(boolean paramBoolean) {}
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setTitle(paramCharSequence);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    mDecorToolbar.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    mDecorToolbar.setVisibility(0);
  }
  
  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private boolean mClosingActionMenu;
    
    private ActionMenuPresenterCallback() {}
    
    public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if (mClosingActionMenu) {
        return;
      }
      mClosingActionMenu = true;
      mDecorToolbar.dismissPopupMenus();
      if (mWindowCallback != null) {
        mWindowCallback.onPanelClosed(108, paramMenuBuilder);
      }
      mClosingActionMenu = false;
    }
    
    public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (mWindowCallback != null)
      {
        mWindowCallback.onMenuOpened(108, paramMenuBuilder);
        return true;
      }
      return false;
    }
  }
  
  private final class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    private MenuBuilderCallback() {}
    
    public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (mWindowCallback != null)
      {
        if (!mDecorToolbar.isOverflowMenuShowing()) {
          break label41;
        }
        mWindowCallback.onPanelClosed(108, paramMenuBuilder);
      }
      label41:
      while (!mWindowCallback.onPreparePanel(0, null, paramMenuBuilder)) {
        return;
      }
      mWindowCallback.onMenuOpened(108, paramMenuBuilder);
    }
  }
  
  private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private PanelMenuPresenterCallback() {}
    
    public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if (mWindowCallback != null) {
        mWindowCallback.onPanelClosed(0, paramMenuBuilder);
      }
    }
    
    public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if ((paramMenuBuilder == null) && (mWindowCallback != null)) {
        mWindowCallback.onMenuOpened(0, paramMenuBuilder);
      }
      return true;
    }
  }
  
  private final class ToolbarCallbackWrapper
    extends WindowCallbackWrapper
  {
    public ToolbarCallbackWrapper(Window.Callback paramCallback)
    {
      super();
    }
    
    public final View onCreatePanelView(int paramInt)
    {
      switch (paramInt)
      {
      }
      Menu localMenu;
      do
      {
        return super.onCreatePanelView(paramInt);
        localMenu = mDecorToolbar.getMenu();
      } while ((!onPreparePanel(paramInt, null, localMenu)) || (!onMenuOpened(paramInt, localMenu)));
      ToolbarActionBar localToolbarActionBar = ToolbarActionBar.this;
      MenuBuilder localMenuBuilder;
      Object localObject;
      Resources.Theme localTheme;
      if ((mListMenuPresenter == null) && ((localMenu instanceof MenuBuilder)))
      {
        localMenuBuilder = (MenuBuilder)localMenu;
        localObject = mDecorToolbar.getContext();
        TypedValue localTypedValue = new TypedValue();
        localTheme = ((Context)localObject).getResources().newTheme();
        localTheme.setTo(((Context)localObject).getTheme());
        localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
        if (resourceId != 0) {
          localTheme.applyStyle(resourceId, true);
        }
        localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
        if (resourceId == 0) {
          break label261;
        }
        localTheme.applyStyle(resourceId, true);
      }
      for (;;)
      {
        localObject = new ContextThemeWrapper((Context)localObject, 0);
        ((Context)localObject).getTheme().setTo(localTheme);
        mListMenuPresenter = new ListMenuPresenter((Context)localObject, R.layout.abc_list_menu_item_layout);
        mListMenuPresenter.mCallback = new ToolbarActionBar.PanelMenuPresenterCallback(localToolbarActionBar, (byte)0);
        localMenuBuilder.addMenuPresenter(mListMenuPresenter);
        if ((localMenu != null) && (mListMenuPresenter != null)) {
          break;
        }
        return null;
        label261:
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
      if (mListMenuPresenter.getAdapter().getCount() > 0) {
        return (View)mListMenuPresenter.getMenuView(mDecorToolbar.getViewGroup());
      }
      return null;
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!mToolbarMenuPrepared))
      {
        mDecorToolbar.setMenuPrepared();
        mToolbarMenuPrepared = true;
      }
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */