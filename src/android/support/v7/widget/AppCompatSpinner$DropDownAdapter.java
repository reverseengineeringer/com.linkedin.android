package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

final class AppCompatSpinner$DropDownAdapter
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter mAdapter;
  private ListAdapter mListAdapter;
  
  public AppCompatSpinner$DropDownAdapter(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
  {
    mAdapter = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      mListAdapter = ((ListAdapter)paramSpinnerAdapter);
    }
    if ((paramTheme != null) && (AppCompatSpinner.access$100()) && ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter)))
    {
      paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
        paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
      }
    }
  }
  
  public final boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = mListAdapter;
    if (localListAdapter != null) {
      return localListAdapter.areAllItemsEnabled();
    }
    return true;
  }
  
  public final int getCount()
  {
    if (mAdapter == null) {
      return 0;
    }
    return mAdapter.getCount();
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (mAdapter == null) {
      return null;
    }
    return mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final Object getItem(int paramInt)
  {
    if (mAdapter == null) {
      return null;
    }
    return mAdapter.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    if (mAdapter == null) {
      return -1L;
    }
    return mAdapter.getItemId(paramInt);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final boolean hasStableIds()
  {
    return (mAdapter != null) && (mAdapter.hasStableIds());
  }
  
  public final boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = mListAdapter;
    if (localListAdapter != null) {
      return localListAdapter.isEnabled(paramInt);
    }
    return true;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (mAdapter != null) {
      mAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (mAdapter != null) {
      mAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatSpinner.DropDownAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */