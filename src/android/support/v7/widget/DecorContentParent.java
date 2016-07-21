package android.support.v7.widget;

import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.Window.Callback;

public abstract interface DecorContentParent
{
  public abstract boolean canShowOverflowMenu();
  
  public abstract void dismissPopups();
  
  public abstract boolean hideOverflowMenu();
  
  public abstract void initFeature(int paramInt);
  
  public abstract boolean isOverflowMenuShowPending();
  
  public abstract boolean isOverflowMenuShowing();
  
  public abstract void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback);
  
  public abstract void setMenuPrepared();
  
  public abstract void setWindowCallback(Window.Callback paramCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
  
  public abstract boolean showOverflowMenu();
}

/* Location:
 * Qualified Name:     android.support.v7.widget.DecorContentParent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */