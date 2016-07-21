package android.support.v7.widget.helper;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import java.util.List;

final class ItemTouchHelper$2
  implements RecyclerView.OnItemTouchListener
{
  ItemTouchHelper$2(ItemTouchHelper paramItemTouchHelper) {}
  
  public final boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    ItemTouchHelper localItemTouchHelper1 = null;
    this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0)
    {
      this$0.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this$0.mInitialTouchX = paramMotionEvent.getX();
      this$0.mInitialTouchY = paramMotionEvent.getY();
      this$0.obtainVelocityTracker();
      if (this$0.mSelected == null)
      {
        ItemTouchHelper localItemTouchHelper2 = this$0;
        paramRecyclerView = localItemTouchHelper1;
        if (!mRecoverAnimations.isEmpty())
        {
          View localView = localItemTouchHelper2.findChildView(paramMotionEvent);
          i = mRecoverAnimations.size() - 1;
          paramRecyclerView = localItemTouchHelper1;
          if (i >= 0)
          {
            paramRecyclerView = (ItemTouchHelper.RecoverAnimation)mRecoverAnimations.get(i);
            if (mViewHolder.itemView != localView) {
              break label304;
            }
          }
        }
        if (paramRecyclerView != null)
        {
          localItemTouchHelper1 = this$0;
          mInitialTouchX -= mX;
          localItemTouchHelper1 = this$0;
          mInitialTouchY -= mY;
          this$0.endRecoverAnimation(mViewHolder, true);
          if (this$0.mPendingCleanup.remove(mViewHolder.itemView)) {
            ItemTouchHelper.Callback.clearView$448413f6(mViewHolder);
          }
          this$0.select(mViewHolder, mActionState);
          ItemTouchHelper.access$900(this$0, paramMotionEvent, this$0.mSelectedFlags, 0);
        }
      }
    }
    for (;;)
    {
      if (this$0.mVelocityTracker != null) {
        this$0.mVelocityTracker.addMovement(paramMotionEvent);
      }
      if (this$0.mSelected == null) {
        break label385;
      }
      return true;
      label304:
      i -= 1;
      break;
      if ((i == 3) || (i == 1))
      {
        this$0.mActivePointerId = -1;
        this$0.select(null, 0);
      }
      else if (this$0.mActivePointerId != -1)
      {
        int j = MotionEventCompat.findPointerIndex(paramMotionEvent, this$0.mActivePointerId);
        if (j >= 0) {
          ItemTouchHelper.access$1000(this$0, i, paramMotionEvent, j);
        }
      }
    }
    label385:
    return false;
  }
  
  public final void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this$0.select(null, 0);
  }
  
  public final void onTouchEvent$606727f8(MotionEvent paramMotionEvent)
  {
    int i = 0;
    this$0.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (this$0.mVelocityTracker != null) {
      this$0.mVelocityTracker.addMovement(paramMotionEvent);
    }
    if (this$0.mActivePointerId == -1) {}
    int j;
    do
    {
      int k;
      RecyclerView.ViewHolder localViewHolder;
      do
      {
        return;
        j = MotionEventCompat.getActionMasked(paramMotionEvent);
        k = MotionEventCompat.findPointerIndex(paramMotionEvent, this$0.mActivePointerId);
        if (k >= 0) {
          ItemTouchHelper.access$1000(this$0, j, paramMotionEvent, k);
        }
        localViewHolder = this$0.mSelected;
      } while (localViewHolder == null);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this$0.select(null, 0);
          this$0.mActivePointerId = -1;
          return;
          if (k < 0) {
            break;
          }
          ItemTouchHelper.access$900(this$0, paramMotionEvent, this$0.mSelectedFlags, k);
          ItemTouchHelper.access$100(this$0, localViewHolder);
          this$0.mRecyclerView.removeCallbacks(this$0.mScrollRunnable);
          this$0.mScrollRunnable.run();
          this$0.mRecyclerView.invalidate();
          return;
          if (this$0.mVelocityTracker != null) {
            this$0.mVelocityTracker.clear();
          }
        }
      }
      j = MotionEventCompat.getActionIndex(paramMotionEvent);
    } while (MotionEventCompat.getPointerId(paramMotionEvent, j) != this$0.mActivePointerId);
    if (j == 0) {
      i = 1;
    }
    this$0.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
    ItemTouchHelper.access$900(this$0, paramMotionEvent, this$0.mSelectedFlags, j);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */