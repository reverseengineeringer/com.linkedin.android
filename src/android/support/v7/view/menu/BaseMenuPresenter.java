package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter
  implements MenuPresenter
{
  public MenuPresenter.Callback mCallback;
  public Context mContext;
  public int mId;
  protected LayoutInflater mInflater;
  private int mItemLayoutRes;
  public MenuBuilder mMenu;
  private int mMenuLayoutRes;
  public MenuView mMenuView;
  public Context mSystemContext;
  protected LayoutInflater mSystemInflater;
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2)
  {
    mSystemContext = paramContext;
    mSystemInflater = LayoutInflater.from(paramContext);
    mMenuLayoutRes = paramInt1;
    mItemLayoutRes = paramInt2;
  }
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public final int getId()
  {
    return mId;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof MenuView.ItemView)) {}
    for (paramView = (MenuView.ItemView)paramView;; paramView = (MenuView.ItemView)mSystemInflater.inflate(mItemLayoutRes, paramViewGroup, false))
    {
      bindItemView(paramMenuItemImpl, paramView);
      return (View)paramView;
    }
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (mMenuView == null)
    {
      mMenuView = ((MenuView)mSystemInflater.inflate(mMenuLayoutRes, paramViewGroup, false));
      mMenuView.initialize(mMenu);
      updateMenuView(true);
    }
    return mMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    mContext = paramContext;
    mInflater = LayoutInflater.from(mContext);
    mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mCallback != null) {
      mCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (mCallback != null) {
      return mCallback.onOpenSubMenu(paramSubMenuBuilder);
    }
    return false;
  }
  
  public boolean shouldIncludeItem$6edfc5cf(MenuItemImpl paramMenuItemImpl)
  {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)mMenuView;
    if (localViewGroup == null) {}
    for (;;)
    {
      return;
      int j = 0;
      int i = 0;
      if (mMenu != null)
      {
        mMenu.flagActionItems();
        ArrayList localArrayList = mMenu.getVisibleItems();
        int m = localArrayList.size();
        int k = 0;
        j = i;
        if (k < m)
        {
          MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(k);
          j = i;
          View localView1;
          if (shouldIncludeItem$6edfc5cf(localMenuItemImpl))
          {
            localView1 = localViewGroup.getChildAt(i);
            if (!(localView1 instanceof MenuView.ItemView)) {
              break label199;
            }
          }
          label199:
          for (Object localObject = ((MenuView.ItemView)localView1).getItemData();; localObject = null)
          {
            View localView2 = getItemView(localMenuItemImpl, localView1, localViewGroup);
            if (localMenuItemImpl != localObject)
            {
              localView2.setPressed(false);
              ViewCompat.jumpDrawablesToCurrentState(localView2);
            }
            if (localView2 != localView1)
            {
              localObject = (ViewGroup)localView2.getParent();
              if (localObject != null) {
                ((ViewGroup)localObject).removeView(localView2);
              }
              ((ViewGroup)mMenuView).addView(localView2, i);
            }
            j = i + 1;
            k += 1;
            i = j;
            break;
          }
        }
      }
      while (j < localViewGroup.getChildCount()) {
        if (!filterLeftoverView(localViewGroup, j)) {
          j += 1;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.BaseMenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */