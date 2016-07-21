package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.appcompat.R.layout;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public final class ListMenuPresenter
  implements MenuPresenter, AdapterView.OnItemClickListener
{
  MenuAdapter mAdapter;
  public MenuPresenter.Callback mCallback;
  Context mContext;
  private int mId;
  LayoutInflater mInflater;
  private int mItemIndexOffset;
  int mItemLayoutRes;
  MenuBuilder mMenu;
  ExpandedMenuView mMenuView;
  int mThemeRes;
  
  private ListMenuPresenter(int paramInt)
  {
    mItemLayoutRes = paramInt;
    mThemeRes = 0;
  }
  
  public ListMenuPresenter(Context paramContext, int paramInt)
  {
    this(paramInt);
    mContext = paramContext;
    mInflater = LayoutInflater.from(mContext);
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
  
  public final ListAdapter getAdapter()
  {
    if (mAdapter == null) {
      mAdapter = new MenuAdapter();
    }
    return mAdapter;
  }
  
  public final int getId()
  {
    return mId;
  }
  
  public final MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (mMenuView == null)
    {
      mMenuView = ((ExpandedMenuView)mInflater.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (mAdapter == null) {
        mAdapter = new MenuAdapter();
      }
      mMenuView.setAdapter(mAdapter);
      mMenuView.setOnItemClickListener(this);
    }
    return mMenuView;
  }
  
  public final void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    if (mThemeRes != 0)
    {
      mContext = new ContextThemeWrapper(paramContext, mThemeRes);
      mInflater = LayoutInflater.from(mContext);
    }
    for (;;)
    {
      mMenu = paramMenuBuilder;
      if (mAdapter != null) {
        mAdapter.notifyDataSetChanged();
      }
      return;
      if (mContext != null)
      {
        mContext = paramContext;
        if (mInflater == null) {
          mInflater = LayoutInflater.from(mContext);
        }
      }
    }
  }
  
  public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mCallback != null) {
      mCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    mMenu.performItemAction(mAdapter.getItem(paramInt), this, 0);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = ((Bundle)paramParcelable).getSparseParcelableArray("android:menu:list");
    if (paramParcelable != null) {
      mMenuView.restoreHierarchyState(paramParcelable);
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (mMenuView == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray = new SparseArray();
    if (mMenuView != null) {
      mMenuView.saveHierarchyState(localSparseArray);
    }
    localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    return localBundle;
  }
  
  public final boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (!paramSubMenuBuilder.hasVisibleItems()) {
      return false;
    }
    MenuDialogHelper localMenuDialogHelper = new MenuDialogHelper(paramSubMenuBuilder);
    Object localObject1 = mMenu;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(mContext);
    mPresenter = new ListMenuPresenter(P.mContext, R.layout.abc_list_menu_item_layout);
    mPresenter.mCallback = localMenuDialogHelper;
    mMenu.addMenuPresenter(mPresenter);
    localBuilder.setAdapter(mPresenter.getAdapter(), localMenuDialogHelper);
    Object localObject2 = mHeaderView;
    if (localObject2 != null) {
      P.mCustomTitleView = ((View)localObject2);
    }
    for (;;)
    {
      localBuilder.setOnKeyListener(localMenuDialogHelper);
      mDialog = localBuilder.create();
      mDialog.setOnDismissListener(localMenuDialogHelper);
      localObject1 = mDialog.getWindow().getAttributes();
      type = 1003;
      flags |= 0x20000;
      mDialog.show();
      if (mCallback != null) {
        mCallback.onOpenSubMenu(paramSubMenuBuilder);
      }
      return true;
      localObject2 = mHeaderIcon;
      P.mIcon = ((Drawable)localObject2);
      localBuilder.setTitle(mHeaderTitle);
    }
  }
  
  public final void updateMenuView(boolean paramBoolean)
  {
    if (mAdapter != null) {
      mAdapter.notifyDataSetChanged();
    }
  }
  
  private final class MenuAdapter
    extends BaseAdapter
  {
    private int mExpandedIndex = -1;
    
    public MenuAdapter()
    {
      findExpandedIndex();
    }
    
    private void findExpandedIndex()
    {
      MenuItemImpl localMenuItemImpl = mMenu.mExpandedItem;
      if (localMenuItemImpl != null)
      {
        ArrayList localArrayList = mMenu.getNonActionItems();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
          {
            mExpandedIndex = i;
            return;
          }
          i += 1;
        }
      }
      mExpandedIndex = -1;
    }
    
    public final int getCount()
    {
      int i = mMenu.getNonActionItems().size() - mItemIndexOffset;
      if (mExpandedIndex < 0) {
        return i;
      }
      return i - 1;
    }
    
    public final MenuItemImpl getItem(int paramInt)
    {
      ArrayList localArrayList = mMenu.getNonActionItems();
      int i = paramInt + mItemIndexOffset;
      paramInt = i;
      if (mExpandedIndex >= 0)
      {
        paramInt = i;
        if (i >= mExpandedIndex) {
          paramInt = i + 1;
        }
      }
      return (MenuItemImpl)localArrayList.get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = mInflater.inflate(mItemLayoutRes, paramViewGroup, false);
      }
      ((MenuView.ItemView)localView).initialize$667f453d(getItem(paramInt));
      return localView;
    }
    
    public final void notifyDataSetChanged()
    {
      findExpandedIndex();
      super.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ListMenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */