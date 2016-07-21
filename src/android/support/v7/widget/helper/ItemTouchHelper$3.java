package android.support.v7.widget.helper;

import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

final class ItemTouchHelper$3
  extends ItemTouchHelper.RecoverAnimation
{
  ItemTouchHelper$3(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(paramItemTouchHelper, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public final void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    super.onAnimationEnd(paramValueAnimatorCompat);
    if (mOverridden) {}
    for (;;)
    {
      return;
      if (val$swipeDir <= 0) {
        ItemTouchHelper.Callback.clearView$448413f6(val$prevSelected);
      }
      while (this$0.mOverdrawChild == val$prevSelected.itemView)
      {
        this$0.removeChildDrawingOrderCallbackIfNecessary(val$prevSelected.itemView);
        return;
        this$0.mPendingCleanup.add(val$prevSelected.itemView);
        mIsPendingCleanup = true;
        if (val$swipeDir > 0)
        {
          paramValueAnimatorCompat = this$0;
          int i = val$swipeDir;
          mRecyclerView.post(new ItemTouchHelper.4(paramValueAnimatorCompat, this, i));
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */