package android.support.v7.widget;

import android.view.View;

public abstract class SimpleItemAnimator
  extends RecyclerView.ItemAnimator
{
  boolean mSupportsChangeAnimations = true;
  
  public abstract boolean animateAdd(RecyclerView.ViewHolder paramViewHolder);
  
  public final boolean animateAppearance(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    if ((paramItemHolderInfo1 != null) && ((left != left) || (top != top))) {
      return animateMove(paramViewHolder, left, top, left, top);
    }
    return animateAdd(paramViewHolder);
  }
  
  public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    int k = left;
    int m = top;
    int i;
    if (paramViewHolder2.shouldIgnore()) {
      i = left;
    }
    for (int j = top;; j = top)
    {
      return animateChange(paramViewHolder1, paramViewHolder2, k, m, i, j);
      i = left;
    }
  }
  
  public final boolean animateDisappearance(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    int k = left;
    int m = top;
    paramItemHolderInfo1 = itemView;
    int i;
    if (paramItemHolderInfo2 == null)
    {
      i = paramItemHolderInfo1.getLeft();
      if (paramItemHolderInfo2 != null) {
        break label103;
      }
    }
    label103:
    for (int j = paramItemHolderInfo1.getTop();; j = top)
    {
      if ((paramViewHolder.isRemoved()) || ((k == i) && (m == j))) {
        break label112;
      }
      paramItemHolderInfo1.layout(i, j, paramItemHolderInfo1.getWidth() + i, paramItemHolderInfo1.getHeight() + j);
      return animateMove(paramViewHolder, k, m, i, j);
      i = left;
      break;
    }
    label112:
    return animateRemove(paramViewHolder);
  }
  
  public abstract boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final boolean animatePersistence(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    if ((left != left) || (top != top)) {
      return animateMove(paramViewHolder, left, top, left, top);
    }
    dispatchAnimationFinished(paramViewHolder);
    return false;
  }
  
  public abstract boolean animateRemove(RecyclerView.ViewHolder paramViewHolder);
  
  public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    return (!mSupportsChangeAnimations) || (paramViewHolder.isInvalid());
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SimpleItemAnimator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */