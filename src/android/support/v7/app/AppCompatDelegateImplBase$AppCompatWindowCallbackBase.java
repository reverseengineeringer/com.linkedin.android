package android.support.v7.app;

import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class AppCompatDelegateImplBase$AppCompatWindowCallbackBase
  extends WindowCallbackWrapper
{
  AppCompatDelegateImplBase$AppCompatWindowCallbackBase(AppCompatDelegateImplBase paramAppCompatDelegateImplBase, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this$0.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (this$0.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
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
    this$0.onMenuOpened$2fef5512(paramInt);
    return true;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    this$0.onPanelClosed$2fef5516(paramInt);
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

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplBase.AppCompatWindowCallbackBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */