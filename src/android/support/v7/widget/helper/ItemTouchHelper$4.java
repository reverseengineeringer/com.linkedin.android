package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

final class ItemTouchHelper$4
  implements Runnable
{
  ItemTouchHelper$4(ItemTouchHelper paramItemTouchHelper, ItemTouchHelper.RecoverAnimation paramRecoverAnimation, int paramInt) {}
  
  public final void run()
  {
    if ((this$0.mRecyclerView != null) && (this$0.mRecyclerView.isAttachedToWindow()) && (!val$anim.mOverridden) && (val$anim.mViewHolder.getAdapterPosition() != -1))
    {
      Object localObject = this$0.mRecyclerView.getItemAnimator();
      if ((localObject != null) && (((RecyclerView.ItemAnimator)localObject).isRunning())) {
        break label150;
      }
      localObject = this$0;
      int j = mRecoverAnimations.size();
      i = 0;
      if (i >= j) {
        break label145;
      }
      if (mRecoverAnimations.get(i)).mEnded) {
        break label138;
      }
    }
    label138:
    label145:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label150;
      }
      this$0.mCallback.onSwiped(val$anim.mViewHolder, val$swipeDir);
      return;
      i += 1;
      break;
    }
    label150:
    this$0.mRecyclerView.post(this);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */