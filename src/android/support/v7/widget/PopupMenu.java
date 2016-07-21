package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public final class PopupMenu
  implements MenuBuilder.Callback, MenuPresenter.Callback
{
  private View mAnchor;
  private Context mContext;
  public OnDismissListener mDismissListener;
  public MenuBuilder mMenu;
  public OnMenuItemClickListener mMenuItemClickListener;
  public MenuPopupHelper mPopup;
  
  public PopupMenu(Context paramContext, View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public PopupMenu(Context paramContext, View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle);
  }
  
  private PopupMenu(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    mContext = paramContext;
    mMenu = new MenuBuilder(paramContext);
    mMenu.setCallback(this);
    mAnchor = paramView;
    mPopup = new MenuPopupHelper(paramContext, mMenu, paramView, false, paramInt2, (byte)0);
    mPopup.mDropDownGravity = paramInt1;
    mPopup.mPresenterCallback = this;
  }
  
  public final MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(mContext);
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mDismissListener != null) {
      mDismissListener.onDismiss$add183e();
    }
  }
  
  public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    if (mMenuItemClickListener != null) {
      return mMenuItemClickListener.onMenuItemClick(paramMenuItem);
    }
    return false;
  }
  
  public final void onMenuModeChange(MenuBuilder paramMenuBuilder) {}
  
  public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    boolean bool = true;
    if (paramMenuBuilder == null) {
      bool = false;
    }
    while (!paramMenuBuilder.hasVisibleItems()) {
      return bool;
    }
    new MenuPopupHelper(mContext, paramMenuBuilder, mAnchor).show();
    return true;
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss$add183e();
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.PopupMenu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */