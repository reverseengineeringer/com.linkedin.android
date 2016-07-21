package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

final class RecyclerView$5
  implements ChildHelper.Callback
{
  RecyclerView$5(RecyclerView paramRecyclerView) {}
  
  public final void addView(View paramView, int paramInt)
  {
    this$0.addView(paramView, paramInt);
    RecyclerView.access$1100(this$0, paramView);
  }
  
  public final void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore())) {
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + localViewHolder);
      }
      localViewHolder.clearTmpDetachFlag();
    }
    RecyclerView.access$1300(this$0, paramView, paramInt, paramLayoutParams);
  }
  
  public final void detachViewFromParent(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.getChildViewHolderInt((View)localObject);
      if (localObject != null)
      {
        if ((((RecyclerView.ViewHolder)localObject).isTmpDetached()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore())) {
          throw new IllegalArgumentException("called detach on an already detached child " + localObject);
        }
        ((RecyclerView.ViewHolder)localObject).addFlags(256);
      }
    }
    RecyclerView.access$1400(this$0, paramInt);
  }
  
  public final View getChildAt(int paramInt)
  {
    return this$0.getChildAt(paramInt);
  }
  
  public final int getChildCount()
  {
    return this$0.getChildCount();
  }
  
  public final RecyclerView.ViewHolder getChildViewHolder(View paramView)
  {
    return RecyclerView.getChildViewHolderInt(paramView);
  }
  
  public final int indexOfChild(View paramView)
  {
    return this$0.indexOfChild(paramView);
  }
  
  public final void onEnteredHiddenState(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      RecyclerView.ViewHolder.access$1500(paramView);
    }
  }
  
  public final void onLeftHiddenState(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      RecyclerView.ViewHolder.access$1600(paramView);
    }
  }
  
  public final void removeAllViews()
  {
    int j = this$0.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.access$1200(this$0, getChildAt(i));
      i += 1;
    }
    this$0.removeAllViews();
  }
  
  public final void removeViewAt(int paramInt)
  {
    View localView = this$0.getChildAt(paramInt);
    if (localView != null) {
      RecyclerView.access$1200(this$0, localView);
    }
    this$0.removeViewAt(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */