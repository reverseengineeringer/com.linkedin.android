package android.support.v7.widget;

final class RecyclerView$4
  implements ViewInfoStore.ProcessCallback
{
  RecyclerView$4(RecyclerView paramRecyclerView) {}
  
  public final void processAppeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    RecyclerView.access$800(this$0, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public final void processDisappeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    this$0.mRecycler.unscrapView(paramViewHolder);
    RecyclerView.access$700(this$0, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public final void processPersistent(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (RecyclerView.access$900(this$0)) {
      if (this$0.mItemAnimator.animateChange(paramViewHolder, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
        RecyclerView.access$1000(this$0);
      }
    }
    while (!this$0.mItemAnimator.animatePersistence(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      return;
    }
    RecyclerView.access$1000(this$0);
  }
  
  public final void unused(RecyclerView.ViewHolder paramViewHolder)
  {
    this$0.mLayout.removeAndRecycleView(itemView, this$0.mRecycler);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */