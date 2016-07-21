package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public final class NavigationMenuPresenter
  implements MenuPresenter
{
  public NavigationMenuAdapter mAdapter;
  private MenuPresenter.Callback mCallback;
  public LinearLayout mHeaderLayout;
  public ColorStateList mIconTintList;
  public int mId;
  public Drawable mItemBackground;
  public LayoutInflater mLayoutInflater;
  MenuBuilder mMenu;
  public NavigationMenuView mMenuView;
  final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      setUpdateSuspended(true);
      paramAnonymousView = paramAnonymousView.getItemData();
      boolean bool = mMenu.performItemAction(paramAnonymousView, NavigationMenuPresenter.this, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        mAdapter.setCheckedItem(paramAnonymousView);
      }
      setUpdateSuspended(false);
      updateMenuView(false);
    }
  };
  int mPaddingSeparator;
  public int mPaddingTopDefault;
  int mTextAppearance;
  boolean mTextAppearanceSet;
  public ColorStateList mTextColor;
  
  public final void addHeaderView(View paramView)
  {
    mHeaderLayout.addView(paramView);
    mMenuView.setPadding(0, 0, 0, mMenuView.getPaddingBottom());
  }
  
  public final boolean collapseItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public final boolean expandItemActionView$5c2da31d(MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public final boolean flagActionItems()
  {
    return false;
  }
  
  public final int getId()
  {
    return mId;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    mLayoutInflater = LayoutInflater.from(paramContext);
    mMenu = paramMenuBuilder;
    mPaddingSeparator = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mCallback != null) {
      mCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    Object localObject1 = paramParcelable.getSparseParcelableArray("android:menu:list");
    if (localObject1 != null) {
      mMenuView.restoreHierarchyState((SparseArray)localObject1);
    }
    localObject1 = paramParcelable.getBundle("android:menu:adapter");
    if (localObject1 != null)
    {
      paramParcelable = mAdapter;
      int i = ((Bundle)localObject1).getInt("android:menu:checked", 0);
      Object localObject2;
      if (i != 0)
      {
        mUpdateSuspended = true;
        localIterator = mItems.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (NavigationMenuItem)localIterator.next();
          if ((localObject2 instanceof NavigationMenuTextItem))
          {
            localObject2 = mMenuItem;
            if ((localObject2 != null) && (((MenuItemImpl)localObject2).getItemId() == i)) {
              paramParcelable.setCheckedItem((MenuItemImpl)localObject2);
            }
          }
        }
        mUpdateSuspended = false;
        paramParcelable.prepareMenuItems();
      }
      localObject1 = ((Bundle)localObject1).getSparseParcelableArray("android:menu:action_views");
      Iterator localIterator = mItems.iterator();
      label225:
      while (localIterator.hasNext())
      {
        paramParcelable = (NavigationMenuItem)localIterator.next();
        if ((paramParcelable instanceof NavigationMenuTextItem))
        {
          localObject2 = mMenuItem;
          if (localObject2 != null) {}
          for (paramParcelable = ((MenuItemImpl)localObject2).getActionView();; paramParcelable = null)
          {
            if (paramParcelable == null) {
              break label225;
            }
            paramParcelable.restoreHierarchyState((SparseArray)((SparseArray)localObject1).get(((MenuItemImpl)localObject2).getItemId()));
            break;
          }
        }
      }
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (mMenuView != null)
    {
      SparseArray localSparseArray = new SparseArray();
      mMenuView.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    }
    if (mAdapter != null) {
      localBundle.putBundle("android:menu:adapter", mAdapter.createInstanceState());
    }
    return localBundle;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public final void setItemBackground(Drawable paramDrawable)
  {
    mItemBackground = paramDrawable;
    updateMenuView(false);
  }
  
  public final void setItemIconTintList(ColorStateList paramColorStateList)
  {
    mIconTintList = paramColorStateList;
    updateMenuView(false);
  }
  
  public final void setItemTextAppearance(int paramInt)
  {
    mTextAppearance = paramInt;
    mTextAppearanceSet = true;
    updateMenuView(false);
  }
  
  public final void setItemTextColor(ColorStateList paramColorStateList)
  {
    mTextColor = paramColorStateList;
    updateMenuView(false);
  }
  
  public final void setUpdateSuspended(boolean paramBoolean)
  {
    if (mAdapter != null) {
      mAdapter.mUpdateSuspended = paramBoolean;
    }
  }
  
  public final void updateMenuView(boolean paramBoolean)
  {
    if (mAdapter != null)
    {
      NavigationMenuAdapter localNavigationMenuAdapter = mAdapter;
      localNavigationMenuAdapter.prepareMenuItems();
      localNavigationMenuAdapter.notifyDataSetChanged();
    }
  }
  
  private static final class HeaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public HeaderViewHolder(View paramView)
    {
      super();
    }
  }
  
  private final class NavigationMenuAdapter
    extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
  {
    private MenuItemImpl mCheckedItem;
    final ArrayList<NavigationMenuPresenter.NavigationMenuItem> mItems = new ArrayList();
    private ColorDrawable mTransparentIcon;
    boolean mUpdateSuspended;
    
    public NavigationMenuAdapter()
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
      int i4 = mMenu.getVisibleItems().size();
      while (n < i4)
      {
        MenuItemImpl localMenuItemImpl1 = (MenuItemImpl)mMenu.getVisibleItems().get(n);
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
              mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(mPaddingSeparator, 0));
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
                mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(mPaddingSeparator, mPaddingSeparator));
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
  
  private static final class NavigationMenuHeaderItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {}
  
  private static abstract interface NavigationMenuItem {}
  
  private static final class NavigationMenuSeparatorItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    final int mPaddingBottom;
    final int mPaddingTop;
    
    public NavigationMenuSeparatorItem(int paramInt1, int paramInt2)
    {
      mPaddingTop = paramInt1;
      mPaddingBottom = paramInt2;
    }
  }
  
  private static final class NavigationMenuTextItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    final MenuItemImpl mMenuItem;
    
    private NavigationMenuTextItem(MenuItemImpl paramMenuItemImpl)
    {
      mMenuItem = paramMenuItemImpl;
    }
  }
  
  private static final class NormalViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public NormalViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      itemView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static final class SeparatorViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SeparatorViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static final class SubheaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SubheaderViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public ViewHolder(View paramView)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationMenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */