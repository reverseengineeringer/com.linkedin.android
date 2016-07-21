package android.support.v7.widget;

import android.view.View;

public final class RecyclerView$ItemAnimator$ItemHolderInfo
{
  public int bottom;
  public int left;
  public int right;
  public int top;
  
  public final ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = itemView;
    left = paramViewHolder.getLeft();
    top = paramViewHolder.getTop();
    right = paramViewHolder.getRight();
    bottom = paramViewHolder.getBottom();
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimator.ItemHolderInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */