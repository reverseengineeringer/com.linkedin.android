package android.support.v7.widget;

import android.util.SparseArray;

public final class RecyclerView$State
{
  private SparseArray<Object> mData;
  int mDeletedInvisibleItemCountSincePreviousLayout = 0;
  boolean mInPreLayout = false;
  boolean mIsMeasuring = false;
  int mItemCount = 0;
  int mLayoutStep = 1;
  int mPreviousLayoutItemCount = 0;
  boolean mRunPredictiveAnimations = false;
  boolean mRunSimpleAnimations = false;
  boolean mStructureChanged = false;
  public int mTargetPosition = -1;
  boolean mTrackOldChangeHolders = false;
  
  final void assertLayoutStep(int paramInt)
  {
    if ((mLayoutStep & paramInt) == 0) {
      throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(mLayoutStep));
    }
  }
  
  public final int getItemCount()
  {
    if (mInPreLayout) {
      return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
    }
    return mItemCount;
  }
  
  public final String toString()
  {
    return "State{mTargetPosition=" + mTargetPosition + ", mData=" + mData + ", mItemCount=" + mItemCount + ", mPreviousLayoutItemCount=" + mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + mStructureChanged + ", mInPreLayout=" + mInPreLayout + ", mRunSimpleAnimations=" + mRunSimpleAnimations + ", mRunPredictiveAnimations=" + mRunPredictiveAnimations + '}';
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */