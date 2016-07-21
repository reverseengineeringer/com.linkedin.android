package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import java.util.ArrayList;

final class RecyclerView$RecyclerViewDataObserver
  extends RecyclerView.AdapterDataObserver
{
  private RecyclerView$RecyclerViewDataObserver(RecyclerView paramRecyclerView) {}
  
  private void triggerUpdateProcessor()
  {
    if ((RecyclerView.access$4100(this$0)) && (RecyclerView.access$4200(this$0)) && (RecyclerView.access$4300(this$0)))
    {
      ViewCompat.postOnAnimation(this$0, RecyclerView.access$4400(this$0));
      return;
    }
    RecyclerView.access$4502$767d6395(this$0);
    this$0.requestLayout();
  }
  
  public final void onChanged()
  {
    this$0.assertNotInLayoutOrScroll(null);
    RecyclerView.access$3100(this$0).hasStableIds();
    this$0.mState.mStructureChanged = true;
    RecyclerView.access$4000(this$0);
    if (!this$0.mAdapterHelper.hasPendingUpdates()) {
      this$0.requestLayout();
    }
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 1;
    this$0.assertNotInLayoutOrScroll(null);
    AdapterHelper localAdapterHelper = this$0.mAdapterHelper;
    mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    mExistingUpdateTypes |= 0x4;
    if (mPendingUpdates.size() == 1) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        triggerUpdateProcessor();
      }
      return;
    }
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    int i = 1;
    this$0.assertNotInLayoutOrScroll(null);
    AdapterHelper localAdapterHelper = this$0.mAdapterHelper;
    mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(1, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x1;
    if (mPendingUpdates.size() == 1) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        triggerUpdateProcessor();
      }
      return;
    }
  }
  
  public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    this$0.assertNotInLayoutOrScroll(null);
    AdapterHelper localAdapterHelper = this$0.mAdapterHelper;
    if (paramInt1 != paramInt2)
    {
      if (paramInt3 != 1) {
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
      }
      mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(8, paramInt1, paramInt2, null));
      mExistingUpdateTypes |= 0x8;
      if (mPendingUpdates.size() != 1) {}
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        triggerUpdateProcessor();
      }
      return;
    }
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    int i = 1;
    this$0.assertNotInLayoutOrScroll(null);
    AdapterHelper localAdapterHelper = this$0.mAdapterHelper;
    mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(2, paramInt1, paramInt2, null));
    mExistingUpdateTypes |= 0x2;
    if (mPendingUpdates.size() == 1) {}
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        triggerUpdateProcessor();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.RecyclerViewDataObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */