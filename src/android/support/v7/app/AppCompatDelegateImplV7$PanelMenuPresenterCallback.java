package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Window;
import android.view.Window.Callback;

final class AppCompatDelegateImplV7$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private AppCompatDelegateImplV7$PanelMenuPresenterCallback(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
    if (localMenuBuilder != paramMenuBuilder) {}
    for (int i = 1;; i = 0)
    {
      AppCompatDelegateImplV7 localAppCompatDelegateImplV7 = this$0;
      if (i != 0) {
        paramMenuBuilder = localMenuBuilder;
      }
      paramMenuBuilder = AppCompatDelegateImplV7.access$800(localAppCompatDelegateImplV7, paramMenuBuilder);
      if (paramMenuBuilder != null)
      {
        if (i == 0) {
          break;
        }
        AppCompatDelegateImplV7.access$900(this$0, featureId, paramMenuBuilder, localMenuBuilder);
        AppCompatDelegateImplV7.access$1000(this$0, paramMenuBuilder, true);
      }
      return;
    }
    AppCompatDelegateImplV7.access$1000(this$0, paramMenuBuilder, paramBoolean);
  }
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (this$0.mHasActionBar))
    {
      Window.Callback localCallback = this$0.mWindow.getCallback();
      if ((localCallback != null) && (!this$0.mIsDestroyed)) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.PanelMenuPresenterCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */