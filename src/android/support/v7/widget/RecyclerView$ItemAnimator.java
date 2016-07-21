package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$ItemAnimator
{
  public long mAddDuration = 120L;
  public long mChangeDuration = 250L;
  private ArrayList<Object> mFinishedListeners = new ArrayList();
  ItemAnimatorListener mListener = null;
  public long mMoveDuration = 250L;
  public long mRemoveDuration = 120L;
  
  static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = RecyclerView.ViewHolder.access$6500(paramViewHolder) & 0xE;
    if (paramViewHolder.isInvalid()) {
      return 4;
    }
    int i = j;
    if ((j & 0x4) == 0)
    {
      int k = paramViewHolder.getOldPosition();
      int m = paramViewHolder.getAdapterPosition();
      i = j;
      if (k != -1)
      {
        i = j;
        if (m != -1)
        {
          i = j;
          if (k != m) {
            i = j | 0x800;
          }
        }
      }
    }
    return i;
  }
  
  public abstract boolean animateAppearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animateDisappearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animatePersistence(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder, List<Object> paramList)
  {
    return canReuseUpdatedViewHolder(paramViewHolder);
  }
  
  public final void dispatchAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    if (mListener != null) {
      mListener.onAnimationFinished(paramViewHolder);
    }
  }
  
  public final void dispatchAnimationsFinished()
  {
    int j = mFinishedListeners.size();
    int i = 0;
    while (i < j)
    {
      mFinishedListeners.get(i);
      i += 1;
    }
    mFinishedListeners.clear();
  }
  
  public abstract void endAnimation(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void endAnimations();
  
  public abstract boolean isRunning();
  
  public abstract void runPendingAnimations();
  
  static abstract interface ItemAnimatorListener
  {
    public abstract void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder);
  }
  
  public static final class ItemHolderInfo
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
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemAnimator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */