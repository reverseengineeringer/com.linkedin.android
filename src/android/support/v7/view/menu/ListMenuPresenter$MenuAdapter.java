package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

final class ListMenuPresenter$MenuAdapter
  extends BaseAdapter
{
  private int mExpandedIndex = -1;
  
  public ListMenuPresenter$MenuAdapter(ListMenuPresenter paramListMenuPresenter)
  {
    findExpandedIndex();
  }
  
  private void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = this$0.mMenu.mExpandedItem;
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this$0.mMenu.getNonActionItems();
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
    int i = this$0.mMenu.getNonActionItems().size() - ListMenuPresenter.access$000(this$0);
    if (mExpandedIndex < 0) {
      return i;
    }
    return i - 1;
  }
  
  public final MenuItemImpl getItem(int paramInt)
  {
    ArrayList localArrayList = this$0.mMenu.getNonActionItems();
    int i = paramInt + ListMenuPresenter.access$000(this$0);
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
      localView = this$0.mInflater.inflate(this$0.mItemLayoutRes, paramViewGroup, false);
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

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ListMenuPresenter.MenuAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */