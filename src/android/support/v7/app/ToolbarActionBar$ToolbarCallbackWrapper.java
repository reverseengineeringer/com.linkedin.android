package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.DecorToolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import android.widget.ListAdapter;

final class ToolbarActionBar$ToolbarCallbackWrapper
  extends WindowCallbackWrapper
{
  public ToolbarActionBar$ToolbarCallbackWrapper(ToolbarActionBar paramToolbarActionBar, Window.Callback paramCallback)
  {
    super(paramCallback);
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
      localMenu = this$0.mDecorToolbar.getMenu();
    } while ((!onPreparePanel(paramInt, null, localMenu)) || (!onMenuOpened(paramInt, localMenu)));
    ToolbarActionBar localToolbarActionBar = this$0;
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
    if ((bool) && (!this$0.mToolbarMenuPrepared))
    {
      this$0.mDecorToolbar.setMenuPrepared();
      this$0.mToolbarMenuPrepared = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ToolbarActionBar.ToolbarCallbackWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */