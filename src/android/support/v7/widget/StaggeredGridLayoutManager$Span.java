package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

public final class StaggeredGridLayoutManager$Span
{
  int mCachedEnd = Integer.MIN_VALUE;
  int mCachedStart = Integer.MIN_VALUE;
  int mDeletedSize = 0;
  final int mIndex;
  public ArrayList<View> mViews = new ArrayList();
  
  private StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt)
  {
    mIndex = paramInt;
  }
  
  private void calculateCachedEnd()
  {
    Object localObject = (View)mViews.get(mViews.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    mCachedEnd = this$0.mPrimaryOrientation.getDecoratedEnd((View)localObject);
    if (mFullSpan)
    {
      localObject = this$0.mLazySpanLookup.getFullSpanItem(mViewHolder.getLayoutPosition());
      if ((localObject != null) && (mGapDir == 1)) {
        mCachedEnd += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
      }
    }
  }
  
  private void calculateCachedStart()
  {
    Object localObject = (View)mViews.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
    mCachedStart = this$0.mPrimaryOrientation.getDecoratedStart((View)localObject);
    if (mFullSpan)
    {
      localObject = this$0.mLazySpanLookup.getFullSpanItem(mViewHolder.getLayoutPosition());
      if ((localObject != null) && (mGapDir == -1)) {
        mCachedStart -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
      }
    }
  }
  
  final void appendToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    mSpan = this;
    mViews.add(paramView);
    mCachedEnd = Integer.MIN_VALUE;
    if (mViews.size() == 1) {
      mCachedStart = Integer.MIN_VALUE;
    }
    if ((mViewHolder.isRemoved()) || (mViewHolder.isUpdated())) {
      mDeletedSize += this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  final void clear()
  {
    mViews.clear();
    mCachedStart = Integer.MIN_VALUE;
    mCachedEnd = Integer.MIN_VALUE;
    mDeletedSize = 0;
  }
  
  public final int findOneVisibleChild$486912d2(int paramInt1, int paramInt2)
  {
    int k = -1;
    int m = this$0.mPrimaryOrientation.getStartAfterPadding();
    int n = this$0.mPrimaryOrientation.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    for (;;)
    {
      int j = k;
      if (paramInt1 != paramInt2)
      {
        View localView = (View)mViews.get(paramInt1);
        j = this$0.mPrimaryOrientation.getDecoratedStart(localView);
        int i1 = this$0.mPrimaryOrientation.getDecoratedEnd(localView);
        if ((j < n) && (i1 > m)) {
          j = StaggeredGridLayoutManager.getPosition(localView);
        }
      }
      else
      {
        return j;
        i = -1;
        continue;
      }
      paramInt1 += i;
    }
  }
  
  final int getEndLine()
  {
    if (mCachedEnd != Integer.MIN_VALUE) {
      return mCachedEnd;
    }
    calculateCachedEnd();
    return mCachedEnd;
  }
  
  final int getEndLine(int paramInt)
  {
    if (mCachedEnd != Integer.MIN_VALUE) {
      paramInt = mCachedEnd;
    }
    while (mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedEnd();
    return mCachedEnd;
  }
  
  public final View getFocusableViewAfter(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    View localView;
    if (paramInt2 == -1)
    {
      i = mViews.size();
      paramInt2 = 0;
      localObject2 = localObject1;
      if (paramInt2 < i)
      {
        localView = (View)mViews.get(paramInt2);
        localObject2 = localObject1;
        if (localView.isFocusable())
        {
          if (StaggeredGridLayoutManager.getPosition(localView) > paramInt1) {}
          for (int k = 1;; k = 0)
          {
            localObject2 = localObject1;
            if (k != StaggeredGridLayoutManager.access$600(this$0)) {
              break label203;
            }
            localObject1 = localView;
            paramInt2 += 1;
            break;
          }
        }
      }
    }
    else
    {
      paramInt2 = mViews.size() - 1;
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (paramInt2 >= 0)
      {
        localView = (View)mViews.get(paramInt2);
        localObject2 = localObject1;
        if (localView.isFocusable())
        {
          if (StaggeredGridLayoutManager.getPosition(localView) > paramInt1)
          {
            i = 1;
            label158:
            if (StaggeredGridLayoutManager.access$600(this$0)) {
              break label197;
            }
          }
          label197:
          for (int j = 1;; j = 0)
          {
            localObject2 = localObject1;
            if (i != j) {
              break label203;
            }
            localObject1 = localView;
            paramInt2 -= 1;
            break;
            i = 0;
            break label158;
          }
        }
      }
    }
    label203:
    return (View)localObject2;
  }
  
  final int getStartLine()
  {
    if (mCachedStart != Integer.MIN_VALUE) {
      return mCachedStart;
    }
    calculateCachedStart();
    return mCachedStart;
  }
  
  final int getStartLine(int paramInt)
  {
    if (mCachedStart != Integer.MIN_VALUE) {
      paramInt = mCachedStart;
    }
    while (mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedStart();
    return mCachedStart;
  }
  
  final void onOffset(int paramInt)
  {
    if (mCachedStart != Integer.MIN_VALUE) {
      mCachedStart += paramInt;
    }
    if (mCachedEnd != Integer.MIN_VALUE) {
      mCachedEnd += paramInt;
    }
  }
  
  final void popEnd()
  {
    int i = mViews.size();
    View localView = (View)mViews.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    mSpan = null;
    if ((mViewHolder.isRemoved()) || (mViewHolder.isUpdated())) {
      mDeletedSize -= this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    if (i == 1) {
      mCachedStart = Integer.MIN_VALUE;
    }
    mCachedEnd = Integer.MIN_VALUE;
  }
  
  final void popStart()
  {
    View localView = (View)mViews.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
    mSpan = null;
    if (mViews.size() == 0) {
      mCachedEnd = Integer.MIN_VALUE;
    }
    if ((mViewHolder.isRemoved()) || (mViewHolder.isUpdated())) {
      mDeletedSize -= this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    mCachedStart = Integer.MIN_VALUE;
  }
  
  final void prependToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    mSpan = this;
    mViews.add(0, paramView);
    mCachedStart = Integer.MIN_VALUE;
    if (mViews.size() == 1) {
      mCachedEnd = Integer.MIN_VALUE;
    }
    if ((mViewHolder.isRemoved()) || (mViewHolder.isUpdated())) {
      mDeletedSize += this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  final void setLine(int paramInt)
  {
    mCachedStart = paramInt;
    mCachedEnd = paramInt;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.Span
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */