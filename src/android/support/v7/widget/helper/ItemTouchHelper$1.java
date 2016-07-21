package android.support.v7.widget.helper;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

final class ItemTouchHelper$1
  implements Runnable
{
  ItemTouchHelper$1(ItemTouchHelper paramItemTouchHelper) {}
  
  public final void run()
  {
    int k = 0;
    ItemTouchHelper localItemTouchHelper;
    long l2;
    long l1;
    Object localObject;
    int j;
    int i;
    label149:
    int m;
    label206:
    RecyclerView localRecyclerView;
    if (this$0.mSelected != null)
    {
      localItemTouchHelper = this$0;
      if (mSelected == null) {
        break label550;
      }
      l2 = System.currentTimeMillis();
      if (mDragScrollStartTimeInMs != Long.MIN_VALUE) {
        break label409;
      }
      l1 = 0L;
      localObject = mRecyclerView.getLayoutManager();
      if (mTmpRect == null) {
        mTmpRect = new Rect();
      }
      ((RecyclerView.LayoutManager)localObject).calculateItemDecorationsForChild(mSelected.itemView, mTmpRect);
      if (!((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
        break label479;
      }
      j = (int)(mSelectedStartX + mDx);
      i = j - mTmpRect.left - mRecyclerView.getPaddingLeft();
      if ((mDx >= 0.0F) || (i >= 0)) {
        break label422;
      }
      if (!((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
        break label545;
      }
      m = (int)(mSelectedStartY + mDy);
      j = m - mTmpRect.top - mRecyclerView.getPaddingTop();
      if ((mDy >= 0.0F) || (j >= 0)) {
        break label484;
      }
      if (i == 0) {
        break label566;
      }
      localObject = mCallback;
      localRecyclerView = mRecyclerView;
      m = mSelected.itemView.getWidth();
      mRecyclerView.getWidth();
      i = ((ItemTouchHelper.Callback)localObject).interpolateOutOfBoundsScroll$519e9969(localRecyclerView, m, i, l1);
    }
    label409:
    label422:
    label479:
    label484:
    label545:
    label550:
    label566:
    for (;;)
    {
      if (j != 0)
      {
        localObject = mCallback;
        localRecyclerView = mRecyclerView;
        m = mSelected.itemView.getHeight();
        mRecyclerView.getHeight();
        j = ((ItemTouchHelper.Callback)localObject).interpolateOutOfBoundsScroll$519e9969(localRecyclerView, m, j, l1);
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            mDragScrollStartTimeInMs = l2;
          }
          mRecyclerView.scrollBy(i, j);
        }
        for (i = 1;; i = k)
        {
          if (i != 0)
          {
            if (this$0.mSelected != null) {
              ItemTouchHelper.access$100(this$0, this$0.mSelected);
            }
            this$0.mRecyclerView.removeCallbacks(this$0.mScrollRunnable);
            ViewCompat.postOnAnimation(this$0.mRecyclerView, this);
          }
          return;
          l1 = l2 - mDragScrollStartTimeInMs;
          break;
          if (mDx > 0.0F)
          {
            j = j + mSelected.itemView.getWidth() + mTmpRect.right - (mRecyclerView.getWidth() - mRecyclerView.getPaddingRight());
            i = j;
            if (j > 0) {
              break label149;
            }
          }
          i = 0;
          break label149;
          if (mDy > 0.0F)
          {
            m = m + mSelected.itemView.getHeight() + mTmpRect.bottom - (mRecyclerView.getHeight() - mRecyclerView.getPaddingBottom());
            j = m;
            if (m > 0) {
              break label206;
            }
          }
          j = 0;
          break label206;
          mDragScrollStartTimeInMs = Long.MIN_VALUE;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */