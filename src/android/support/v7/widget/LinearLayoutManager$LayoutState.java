package android.support.v7.widget;

import android.view.View;
import java.util.List;

final class LinearLayoutManager$LayoutState
{
  int mAvailable;
  int mCurrentPosition;
  int mExtra = 0;
  boolean mInfinite;
  boolean mIsPreLayout = false;
  int mItemDirection;
  int mLastScrollDelta;
  int mLayoutDirection;
  int mOffset;
  boolean mRecycle = true;
  List<RecyclerView.ViewHolder> mScrapList = null;
  int mScrollingOffset;
  
  public final void assignPositionFromScrapList(View paramView)
  {
    int m = mScrapList.size();
    Object localObject1 = null;
    int i = Integer.MAX_VALUE;
    int j = 0;
    Object localObject2;
    for (;;)
    {
      if (j >= m) {
        break label153;
      }
      localObject2 = mScrapList.get(j)).itemView;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject2).getLayoutParams();
      if ((localObject2 == paramView) || (mViewHolder.isRemoved())) {
        break label150;
      }
      int k = (mViewHolder.getLayoutPosition() - mCurrentPosition) * mItemDirection;
      if ((k < 0) || (k >= i)) {
        break label150;
      }
      if (k == 0) {
        break;
      }
      localObject1 = localObject2;
      i = k;
      j += 1;
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        mCurrentPosition = -1;
        return;
      }
      mCurrentPosition = getLayoutParamsmViewHolder.getLayoutPosition();
      return;
      label150:
      break;
      label153:
      localObject2 = localObject1;
    }
  }
  
  final boolean hasMore(RecyclerView.State paramState)
  {
    return (mCurrentPosition >= 0) && (mCurrentPosition < paramState.getItemCount());
  }
  
  final View next(RecyclerView.Recycler paramRecycler)
  {
    if (mScrapList != null)
    {
      int j = mScrapList.size();
      int i = 0;
      while (i < j)
      {
        paramRecycler = mScrapList.get(i)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramRecycler.getLayoutParams();
        if ((!mViewHolder.isRemoved()) && (mCurrentPosition == mViewHolder.getLayoutPosition()))
        {
          assignPositionFromScrapList(paramRecycler);
          return paramRecycler;
        }
        i += 1;
      }
      return null;
    }
    paramRecycler = paramRecycler.getViewForPosition(mCurrentPosition);
    mCurrentPosition += mItemDirection;
    return paramRecycler;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.LayoutState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */