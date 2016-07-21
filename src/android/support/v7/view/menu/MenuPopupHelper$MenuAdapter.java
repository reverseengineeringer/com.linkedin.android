package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class MenuPopupHelper$MenuAdapter
  extends BaseAdapter
{
  private MenuBuilder mAdapterMenu;
  private int mExpandedIndex = -1;
  
  public MenuPopupHelper$MenuAdapter(MenuPopupHelper paramMenuPopupHelper, MenuBuilder paramMenuBuilder)
  {
    mAdapterMenu = paramMenuBuilder;
    findExpandedIndex();
  }
  
  private void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = access$300this$0).mExpandedItem;
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = MenuPopupHelper.access$300(this$0).getNonActionItems();
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
    if (MenuPopupHelper.access$100(this$0)) {}
    for (ArrayList localArrayList = mAdapterMenu.getNonActionItems(); mExpandedIndex < 0; localArrayList = mAdapterMenu.getVisibleItems()) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public final MenuItemImpl getItem(int paramInt)
  {
    if (MenuPopupHelper.access$100(this$0)) {}
    for (ArrayList localArrayList = mAdapterMenu.getNonActionItems();; localArrayList = mAdapterMenu.getVisibleItems())
    {
      int i = paramInt;
      if (mExpandedIndex >= 0)
      {
        i = paramInt;
        if (paramInt >= mExpandedIndex) {
          i = paramInt + 1;
        }
      }
      return (MenuItemImpl)localArrayList.get(i);
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = MenuPopupHelper.access$200(this$0).inflate(MenuPopupHelper.ITEM_LAYOUT, paramViewGroup, false);
    }
    paramView = (MenuView.ItemView)localView;
    if (this$0.mForceShowIcon) {
      ((ListMenuItemView)localView).setForceShowIcon(true);
    }
    paramView.initialize$667f453d(getItem(paramInt));
    return localView;
  }
  
  public final void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.MenuPopupHelper.MenuAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */