package android.support.design.internal;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public final class NavigationMenuPresenter$NavigationMenuAdapter
  extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
{
  private MenuItemImpl mCheckedItem;
  final ArrayList<NavigationMenuPresenter.NavigationMenuItem> mItems = new ArrayList();
  private ColorDrawable mTransparentIcon;
  boolean mUpdateSuspended;
  
  public NavigationMenuPresenter$NavigationMenuAdapter(NavigationMenuPresenter paramNavigationMenuPresenter)
  {
    prepareMenuItems();
  }
  
  private void appendTransparentIconIfMissing(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      MenuItemImpl localMenuItemImpl = mItems.get(paramInt1)).mMenuItem;
      if (localMenuItemImpl.getIcon() == null)
      {
        if (mTransparentIcon == null) {
          mTransparentIcon = new ColorDrawable(0);
        }
        localMenuItemImpl.setIcon(mTransparentIcon);
      }
      paramInt1 += 1;
    }
  }
  
  public final Bundle createInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (mCheckedItem != null) {
      localBundle.putInt("android:menu:checked", mCheckedItem.getItemId());
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = mItems.iterator();
    label129:
    while (localIterator.hasNext())
    {
      Object localObject = (NavigationMenuPresenter.NavigationMenuItem)localIterator.next();
      if ((localObject instanceof NavigationMenuPresenter.NavigationMenuTextItem))
      {
        MenuItemImpl localMenuItemImpl = mMenuItem;
        if (localMenuItemImpl != null) {}
        for (localObject = localMenuItemImpl.getActionView();; localObject = null)
        {
          if (localObject == null) {
            break label129;
          }
          ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
          ((View)localObject).saveHierarchyState(localParcelableSparseArray);
          localSparseArray.put(localMenuItemImpl.getItemId(), localParcelableSparseArray);
          break;
        }
      }
    }
    localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
    return localBundle;
  }
  
  public final int getItemCount()
  {
    return mItems.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    NavigationMenuPresenter.NavigationMenuItem localNavigationMenuItem = (NavigationMenuPresenter.NavigationMenuItem)mItems.get(paramInt);
    if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)) {
      return 2;
    }
    if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)) {
      return 3;
    }
    if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem))
    {
      if (mMenuItem.hasSubMenu()) {
        return 1;
      }
      return 0;
    }
    throw new RuntimeException("Unknown item type.");
  }
  
  final void prepareMenuItems()
  {
    if (mUpdateSuspended) {
      return;
    }
    mUpdateSuspended = true;
    mItems.clear();
    mItems.add(new NavigationMenuPresenter.NavigationMenuHeaderItem((byte)0));
    int i1 = -1;
    int k = 0;
    int m = 0;
    int n = 0;
    int i4 = this$0.mMenu.getVisibleItems().size();
    while (n < i4)
    {
      MenuItemImpl localMenuItemImpl1 = (MenuItemImpl)this$0.mMenu.getVisibleItems().get(n);
      if (localMenuItemImpl1.isChecked()) {
        setCheckedItem(localMenuItemImpl1);
      }
      if (localMenuItemImpl1.isCheckable()) {
        localMenuItemImpl1.setExclusiveCheckable(false);
      }
      int j;
      int i2;
      int i3;
      int i;
      if (localMenuItemImpl1.hasSubMenu())
      {
        SubMenu localSubMenu = localMenuItemImpl1.getSubMenu();
        j = m;
        i2 = i1;
        i3 = k;
        if (localSubMenu.hasVisibleItems())
        {
          if (n != 0) {
            mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this$0.mPaddingSeparator, 0));
          }
          mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl1, (byte)0));
          i = 0;
          int i5 = mItems.size();
          i2 = 0;
          i3 = localSubMenu.size();
          while (i2 < i3)
          {
            MenuItemImpl localMenuItemImpl2 = (MenuItemImpl)localSubMenu.getItem(i2);
            j = i;
            if (localMenuItemImpl2.isVisible())
            {
              j = i;
              if (i == 0)
              {
                j = i;
                if (localMenuItemImpl2.getIcon() != null) {
                  j = 1;
                }
              }
              if (localMenuItemImpl2.isCheckable()) {
                localMenuItemImpl2.setExclusiveCheckable(false);
              }
              if (localMenuItemImpl1.isChecked()) {
                setCheckedItem(localMenuItemImpl1);
              }
              mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl2, (byte)0));
            }
            i2 += 1;
            i = j;
          }
          j = m;
          i2 = i1;
          i3 = k;
          if (i != 0)
          {
            appendTransparentIconIfMissing(i5, mItems.size());
            i3 = k;
            i2 = i1;
            j = m;
          }
        }
        n += 1;
        m = j;
        i1 = i2;
        k = i3;
      }
      else
      {
        i2 = localMenuItemImpl1.getGroupId();
        if (i2 != i1)
        {
          m = mItems.size();
          if (localMenuItemImpl1.getIcon() != null)
          {
            k = 1;
            label416:
            j = k;
            i = m;
            if (n != 0)
            {
              i = m + 1;
              mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this$0.mPaddingSeparator, this$0.mPaddingSeparator));
              j = k;
            }
          }
        }
        for (;;)
        {
          if ((j != 0) && (localMenuItemImpl1.getIcon() == null)) {
            localMenuItemImpl1.setIcon(17170445);
          }
          mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl1, (byte)0));
          i3 = i;
          break;
          k = 0;
          break label416;
          j = m;
          i = k;
          if (m == 0)
          {
            j = m;
            i = k;
            if (localMenuItemImpl1.getIcon() != null)
            {
              j = 1;
              appendTransparentIconIfMissing(k, mItems.size());
              i = k;
            }
          }
        }
      }
    }
    mUpdateSuspended = false;
  }
  
  public final void setCheckedItem(MenuItemImpl paramMenuItemImpl)
  {
    if ((mCheckedItem == paramMenuItemImpl) || (!paramMenuItemImpl.isCheckable())) {
      return;
    }
    if (mCheckedItem != null) {
      mCheckedItem.setChecked(false);
    }
    mCheckedItem = paramMenuItemImpl;
    paramMenuItemImpl.setChecked(true);
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationMenuPresenter.NavigationMenuAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */