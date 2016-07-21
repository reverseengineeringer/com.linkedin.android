package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

final class MenuDialogHelper
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback
{
  AlertDialog mDialog;
  MenuBuilder mMenu;
  ListMenuPresenter mPresenter;
  private MenuPresenter.Callback mPresenterCallback;
  
  public MenuDialogHelper(MenuBuilder paramMenuBuilder)
  {
    mMenu = paramMenuBuilder;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mMenu.performItemAction((MenuItemImpl)mPresenter.getAdapter().getItem(paramInt), null, 0);
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (((paramBoolean) || (paramMenuBuilder == mMenu)) && (mDialog != null)) {
      mDialog.dismiss();
    }
    if (mPresenterCallback != null) {
      mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    mPresenter.onCloseMenu(mMenu, true);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = mDialog.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = mDialog.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              mMenu.close(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return mMenu.performShortcut(paramInt, paramKeyEvent, 0);
  }
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if (mPresenterCallback != null) {
      return mPresenterCallback.onOpenSubMenu(paramMenuBuilder);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuDialogHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */