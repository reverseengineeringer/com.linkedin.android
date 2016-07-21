package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import java.util.ArrayList;

final class Toolbar$ExpandedActionViewMenuPresenter
  implements MenuPresenter
{
  MenuItemImpl mCurrentExpandedItem;
  MenuBuilder mMenu;
  
  private Toolbar$ExpandedActionViewMenuPresenter(Toolbar paramToolbar) {}
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    if ((this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this$0.mExpandedActionView).onActionViewCollapsed();
    }
    this$0.removeView(this$0.mExpandedActionView);
    this$0.removeView(Toolbar.access$300(this$0));
    this$0.mExpandedActionView = null;
    Toolbar localToolbar = this$0;
    int i = mHiddenViews.size() - 1;
    while (i >= 0)
    {
      localToolbar.addView((View)mHiddenViews.get(i));
      i -= 1;
    }
    mHiddenViews.clear();
    mCurrentExpandedItem = null;
    this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(false);
    return true;
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    Toolbar.access$200(this$0);
    if (Toolbar.access$300(this$0).getParent() != this$0) {
      this$0.addView(Toolbar.access$300(this$0));
    }
    this$0.mExpandedActionView = paramMenuItemImpl.getActionView();
    mCurrentExpandedItem = paramMenuItemImpl;
    if (this$0.mExpandedActionView.getParent() != this$0)
    {
      localObject = Toolbar.generateDefaultLayoutParams();
      gravity = (0x800003 | Toolbar.access$400(this$0) & 0x70);
      mViewType = 2;
      this$0.mExpandedActionView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this$0.addView(this$0.mExpandedActionView);
    }
    Object localObject = this$0;
    int i = ((Toolbar)localObject).getChildCount() - 1;
    while (i >= 0)
    {
      View localView = ((Toolbar)localObject).getChildAt(i);
      if ((getLayoutParamsmViewType != 2) && (localView != mMenuView))
      {
        ((Toolbar)localObject).removeViewAt(i);
        mHiddenViews.add(localView);
      }
      i -= 1;
    }
    this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(true);
    if ((this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this$0.mExpandedActionView).onActionViewExpanded();
    }
    return true;
  }
  
  public final boolean flagActionItems()
  {
    return false;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    if ((mMenu != null) && (mCurrentExpandedItem != null)) {
      mMenu.collapseItemActionView(mCurrentExpandedItem);
    }
    mMenu = paramMenuBuilder;
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public final void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public final Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public final void updateMenuView(boolean paramBoolean)
  {
    int k;
    int j;
    int m;
    int i;
    if (mCurrentExpandedItem != null)
    {
      k = 0;
      j = k;
      if (mMenu != null)
      {
        m = mMenu.size();
        i = 0;
      }
    }
    for (;;)
    {
      j = k;
      if (i < m)
      {
        if (mMenu.getItem(i) == mCurrentExpandedItem) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          collapseItemActionView$5c2da31d(mCurrentExpandedItem);
        }
        return;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.Toolbar.ExpandedActionViewMenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */