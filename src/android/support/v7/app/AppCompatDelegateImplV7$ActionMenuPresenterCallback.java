package android.support.v7.app;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Window;
import android.view.Window.Callback;

final class AppCompatDelegateImplV7$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  private AppCompatDelegateImplV7$ActionMenuPresenterCallback(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    AppCompatDelegateImplV7.access$1100(this$0, paramMenuBuilder);
  }
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    Window.Callback localCallback = this$0.mWindow.getCallback();
    if (localCallback != null) {
      localCallback.onMenuOpened(108, paramMenuBuilder);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.ActionMenuPresenterCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */