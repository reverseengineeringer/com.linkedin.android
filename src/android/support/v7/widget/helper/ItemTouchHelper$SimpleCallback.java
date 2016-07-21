package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract class ItemTouchHelper$SimpleCallback
  extends ItemTouchHelper.Callback
{
  private int mDefaultDragDirs;
  private int mDefaultSwipeDirs = 12;
  
  public ItemTouchHelper$SimpleCallback(int paramInt)
  {
    mDefaultDragDirs = paramInt;
  }
  
  public final int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    int i = mDefaultDragDirs;
    int j = getSwipeDirs(paramRecyclerView, paramViewHolder);
    return i << 16 | j << 8 | (j | i) << 0;
  }
  
  public int getSwipeDirs(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return mDefaultSwipeDirs;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */