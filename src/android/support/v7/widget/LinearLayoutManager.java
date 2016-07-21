package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements ItemTouchHelper.ViewDropHandler
{
  final AnchorInfo mAnchorInfo = new AnchorInfo();
  private boolean mLastStackFromEnd;
  private LayoutState mLayoutState;
  public int mOrientation;
  OrientationHelper mOrientationHelper;
  SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  public boolean mRecycleChildrenOnDetach;
  public boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
    mAutoMeasure = true;
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(orientation);
    setReverseLayout(reverseLayout);
    setStackFromEnd(stackFromEnd);
    mAutoMeasure = true;
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = mOrientationHelper;
    View localView;
    if (!mSmoothScrollbarEnabled)
    {
      bool1 = true;
      localView = findFirstVisibleChildClosestToStart$2930a1b7(bool1);
      if (mSmoothScrollbarEnabled) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ScrollbarHelper.computeScrollExtent(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd$2930a1b7(bool1), this, mSmoothScrollbarEnabled);
      bool1 = false;
      break;
    }
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = mOrientationHelper;
    View localView;
    if (!mSmoothScrollbarEnabled)
    {
      bool1 = true;
      localView = findFirstVisibleChildClosestToStart$2930a1b7(bool1);
      if (mSmoothScrollbarEnabled) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ScrollbarHelper.computeScrollOffset(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd$2930a1b7(bool1), this, mSmoothScrollbarEnabled, mShouldReverseLayout);
      bool1 = false;
      break;
    }
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = mOrientationHelper;
    View localView;
    if (!mSmoothScrollbarEnabled)
    {
      bool1 = true;
      localView = findFirstVisibleChildClosestToStart$2930a1b7(bool1);
      if (mSmoothScrollbarEnabled) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ScrollbarHelper.computeScrollRange(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd$2930a1b7(bool1), this, mSmoothScrollbarEnabled);
      bool1 = false;
      break;
    }
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean)
  {
    int k = mAvailable;
    if (mScrollingOffset != Integer.MIN_VALUE)
    {
      if (mAvailable < 0) {
        mScrollingOffset += mAvailable;
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int i = mAvailable + mExtra;
    LayoutChunkResult localLayoutChunkResult = new LayoutChunkResult();
    do
    {
      int j;
      do
      {
        if (((!mInfinite) && (i <= 0)) || (!paramLayoutState.hasMore(paramState))) {
          break;
        }
        mConsumed = 0;
        mFinished = false;
        mIgnoreConsumed = false;
        mFocusable = false;
        layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
        if (mFinished) {
          break;
        }
        mOffset += mConsumed * mLayoutDirection;
        if ((mIgnoreConsumed) && (mLayoutState.mScrapList == null))
        {
          j = i;
          if (mInPreLayout) {}
        }
        else
        {
          mAvailable -= mConsumed;
          j = i - mConsumed;
        }
        if (mScrollingOffset != Integer.MIN_VALUE)
        {
          mScrollingOffset += mConsumed;
          if (mAvailable < 0) {
            mScrollingOffset += mAvailable;
          }
          recycleByLayoutState(paramRecycler, paramLayoutState);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!mFocusable);
    return k - mAvailable;
  }
  
  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private View findFirstVisibleChildClosestToEnd$2930a1b7(boolean paramBoolean)
  {
    if (mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean, true);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private View findFirstVisibleChildClosestToStart$2930a1b7(boolean paramBoolean)
  {
    if (mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean, true);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean, true);
  }
  
  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private View findReferenceChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mShouldReverseLayout) {
      return findFirstReferenceChild(paramRecycler, paramState);
    }
    return findLastReferenceChild(paramRecycler, paramState);
  }
  
  private View findReferenceChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mShouldReverseLayout) {
      return findLastReferenceChild(paramRecycler, paramState);
    }
    return findFirstReferenceChild(paramRecycler, paramState);
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      int j = -scrollBy(-i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = mOrientationHelper.getEndAfterPadding() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          mOrientationHelper.offsetChildren(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      int j = -scrollBy(i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - mOrientationHelper.getStartAfterPadding();
        i = j;
        if (paramInt > 0)
        {
          mOrientationHelper.offsetChildren(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private View getChildClosestToEnd()
  {
    if (mShouldReverseLayout) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View getChildClosestToStart()
  {
    if (mShouldReverseLayout) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    int j = 0;
    if (mTargetPosition != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = mOrientationHelper.getTotalSpace();
      }
      return j;
    }
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if ((!mRecycle) || (mInfinite)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (mLayoutDirection == -1)
      {
        i = mScrollingOffset;
        j = getChildCount();
        if (i >= 0)
        {
          k = mOrientationHelper.getEnd() - i;
          if (mShouldReverseLayout)
          {
            i = 0;
            while (i < j)
            {
              paramLayoutState = getChildAt(i);
              if (mOrientationHelper.getDecoratedStart(paramLayoutState) < k)
              {
                recycleChildren(paramRecycler, 0, i);
                return;
              }
              i += 1;
            }
          }
          else
          {
            i = j - 1;
            while (i >= 0)
            {
              paramLayoutState = getChildAt(i);
              if (mOrientationHelper.getDecoratedStart(paramLayoutState) < k)
              {
                recycleChildren(paramRecycler, j - 1, i);
                return;
              }
              i -= 1;
            }
          }
        }
      }
      else
      {
        j = mScrollingOffset;
        if (j >= 0)
        {
          k = getChildCount();
          if (mShouldReverseLayout)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramLayoutState = getChildAt(i);
              if (mOrientationHelper.getDecoratedEnd(paramLayoutState) > j)
              {
                recycleChildren(paramRecycler, k - 1, i);
                return;
              }
              i -= 1;
            }
          }
          else
          {
            i = 0;
            while (i < k)
            {
              paramLayoutState = getChildAt(i);
              if (mOrientationHelper.getDecoratedEnd(paramLayoutState) > j)
              {
                recycleChildren(paramRecycler, 0, i);
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          removeAndRecycleViewAt(paramInt2, paramRecycler);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (paramInt1 > paramInt2)
        {
          removeAndRecycleViewAt(paramInt1, paramRecycler);
          paramInt1 -= 1;
        }
      }
    }
  }
  
  private boolean resolveIsInfinite()
  {
    return (mOrientationHelper.getMode() == 0) && (mOrientationHelper.getEnd() == 0);
  }
  
  private void resolveShouldLayoutReverse()
  {
    boolean bool = true;
    if ((mOrientation == 1) || (!isLayoutRTL())) {
      bool = mReverseLayout;
    }
    for (;;)
    {
      mShouldReverseLayout = bool;
      return;
      if (mReverseLayout) {
        bool = false;
      }
    }
  }
  
  private int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {}
    int i;
    int j;
    int k;
    do
    {
      return 0;
      mLayoutState.mRecycle = true;
      ensureLayoutState();
      if (paramInt <= 0) {
        break;
      }
      i = 1;
      j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      k = mLayoutState.mScrollingOffset + fill(paramRecycler, mLayoutState, paramState, false);
    } while (k < 0);
    if (j > k) {
      paramInt = i * k;
    }
    for (;;)
    {
      mOrientationHelper.offsetChildren(-paramInt);
      mLayoutState.mLastScrollDelta = paramInt;
      return paramInt;
      i = -1;
      break;
    }
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    int i = -1;
    int j = 1;
    mLayoutState.mInfinite = resolveIsInfinite();
    mLayoutState.mExtra = getExtraLayoutSpace(paramState);
    mLayoutState.mLayoutDirection = paramInt1;
    if (paramInt1 == 1)
    {
      paramState = mLayoutState;
      mExtra += mOrientationHelper.getEndPadding();
      paramState = getChildClosestToEnd();
      localLayoutState = mLayoutState;
      if (mShouldReverseLayout) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        mItemDirection = paramInt1;
        mLayoutState.mCurrentPosition = (getPosition(paramState) + mLayoutState.mItemDirection);
        mLayoutState.mOffset = mOrientationHelper.getDecoratedEnd(paramState);
        paramInt1 = mOrientationHelper.getDecoratedEnd(paramState) - mOrientationHelper.getEndAfterPadding();
        mLayoutState.mAvailable = paramInt2;
        if (paramBoolean)
        {
          paramState = mLayoutState;
          mAvailable -= paramInt1;
        }
        mLayoutState.mScrollingOffset = paramInt1;
        return;
      }
    }
    paramState = getChildClosestToStart();
    LayoutState localLayoutState = mLayoutState;
    mExtra += mOrientationHelper.getStartAfterPadding();
    localLayoutState = mLayoutState;
    if (mShouldReverseLayout) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      mItemDirection = paramInt1;
      mLayoutState.mCurrentPosition = (getPosition(paramState) + mLayoutState.mItemDirection);
      mLayoutState.mOffset = mOrientationHelper.getDecoratedStart(paramState);
      paramInt1 = -mOrientationHelper.getDecoratedStart(paramState) + mOrientationHelper.getStartAfterPadding();
      break;
    }
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    mLayoutState.mAvailable = (mOrientationHelper.getEndAfterPadding() - paramInt2);
    LayoutState localLayoutState = mLayoutState;
    if (mShouldReverseLayout) {}
    for (int i = -1;; i = 1)
    {
      mItemDirection = i;
      mLayoutState.mCurrentPosition = paramInt1;
      mLayoutState.mLayoutDirection = 1;
      mLayoutState.mOffset = paramInt2;
      mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
      return;
    }
  }
  
  private void updateLayoutStateToFillEnd(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(mPosition, mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    mLayoutState.mAvailable = (paramInt2 - mOrientationHelper.getStartAfterPadding());
    mLayoutState.mCurrentPosition = paramInt1;
    LayoutState localLayoutState = mLayoutState;
    if (mShouldReverseLayout) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      mItemDirection = paramInt1;
      mLayoutState.mLayoutDirection = -1;
      mLayoutState.mOffset = paramInt2;
      mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
      return;
    }
  }
  
  private void updateLayoutStateToFillStart(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillStart(mPosition, mCoordinate);
  }
  
  public final void assertNotInLayoutOrScroll(String paramString)
  {
    if (mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public final boolean canScrollHorizontally()
  {
    return mOrientation == 0;
  }
  
  public final boolean canScrollVertically()
  {
    return mOrientation == 1;
  }
  
  public final int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public final int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public final int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public final PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      i = 1;
    }
    if (i != mShouldReverseLayout) {}
    for (paramInt = -1; mOrientation == 0; paramInt = 1) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public final int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public final int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public final int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  final int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int j = -1;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = Integer.MIN_VALUE;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          return i;
          return 1;
          i = j;
        } while (mOrientation == 1);
        return Integer.MIN_VALUE;
        if (mOrientation == 1) {
          return 1;
        }
        return Integer.MIN_VALUE;
        i = j;
      } while (mOrientation == 0);
      return Integer.MIN_VALUE;
    }
    if (mOrientation == 0) {
      return 1;
    }
    return Integer.MIN_VALUE;
  }
  
  final void ensureLayoutState()
  {
    if (mLayoutState == null) {
      mLayoutState = new LayoutState();
    }
    if (mOrientationHelper == null) {
      mOrientationHelper = OrientationHelper.createOrientationHelper(this, mOrientation);
    }
  }
  
  public final int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public final int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public final View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int j = mOrientationHelper.getStartAfterPadding();
    int k = mOrientationHelper.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      if (paramInt1 == paramInt2) {
        break label150;
      }
      View localView = getChildAt(paramInt1);
      int m = mOrientationHelper.getDecoratedStart(localView);
      int n = mOrientationHelper.getDecoratedEnd(localView);
      localObject2 = localObject1;
      if (m < k)
      {
        localObject2 = localObject1;
        if (n > j)
        {
          if ((!paramBoolean1) || ((m >= j) && (n <= k)))
          {
            return localView;
            i = -1;
            break;
          }
          localObject2 = localObject1;
          if (paramBoolean2)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localView;
            }
          }
        }
      }
      paramInt1 += i;
    }
    label150:
    return (View)localObject1;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    ensureLayoutState();
    Object localObject1 = null;
    paramRecycler = null;
    int j = mOrientationHelper.getStartAfterPadding();
    int k = mOrientationHelper.getEndAfterPadding();
    int i;
    Object localObject2;
    Object localObject3;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (paramInt1 == paramInt2) {
        break label185;
      }
      paramState = getChildAt(paramInt1);
      int m = getPosition(paramState);
      localObject2 = localObject1;
      localObject3 = paramRecycler;
      if (m >= 0)
      {
        localObject2 = localObject1;
        localObject3 = paramRecycler;
        if (m < paramInt3)
        {
          if (!getLayoutParamsmViewHolder.isRemoved()) {
            break label135;
          }
          localObject2 = localObject1;
          localObject3 = paramRecycler;
          if (localObject1 == null)
          {
            localObject3 = paramRecycler;
            localObject2 = paramState;
          }
        }
      }
    }
    for (;;)
    {
      paramInt1 += i;
      localObject1 = localObject2;
      paramRecycler = (RecyclerView.Recycler)localObject3;
      break;
      i = -1;
      break;
      label135:
      if (mOrientationHelper.getDecoratedStart(paramState) < k)
      {
        localObject2 = paramState;
        if (mOrientationHelper.getDecoratedEnd(paramState) >= j) {
          break label192;
        }
      }
      localObject2 = localObject1;
      localObject3 = paramRecycler;
      if (paramRecycler == null)
      {
        localObject2 = localObject1;
        localObject3 = paramState;
      }
    }
    label185:
    if (paramRecycler != null)
    {
      localObject2 = paramRecycler;
      label192:
      return (View)localObject2;
    }
    return (View)localObject1;
  }
  
  public final View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return (View)localObject;
      int j = paramInt - getPosition(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (getPosition(localView) == paramInt);
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public final boolean isLayoutRTL()
  {
    return ViewCompat.getLayoutDirection(mRecyclerView) == 1;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState, LayoutChunkResult paramLayoutChunkResult)
  {
    paramRecycler = paramLayoutState.next(paramRecycler);
    if (paramRecycler == null)
    {
      mFinished = true;
      return;
    }
    paramState = (RecyclerView.LayoutParams)paramRecycler.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label63:
    int k;
    int j;
    label121:
    int i;
    int m;
    if (mScrapList == null)
    {
      bool2 = mShouldReverseLayout;
      if (mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label222;
        }
        super.addViewInt(paramRecycler, -1, false);
        measureChildWithMargins$17e143a3(paramRecycler, 0);
        mConsumed = mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        if (mOrientation != 1) {
          break label325;
        }
        if (!isLayoutRTL()) {
          break label282;
        }
        k = mWidth - getPaddingRight();
        j = k - mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
        if (mLayoutDirection != -1) {
          break label304;
        }
        i = mOffset;
        m = mOffset - mConsumed;
      }
    }
    for (;;)
    {
      layoutDecorated(paramRecycler, j + leftMargin, m + topMargin, k - rightMargin, i - bottomMargin);
      if ((mViewHolder.isRemoved()) || (mViewHolder.isUpdated())) {
        mIgnoreConsumed = true;
      }
      mFocusable = paramRecycler.isFocusable();
      return;
      bool1 = false;
      break;
      label222:
      super.addViewInt(paramRecycler, 0, false);
      break label63;
      bool2 = mShouldReverseLayout;
      if (mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label272;
        }
        super.addViewInt(paramRecycler, -1, true);
        break;
      }
      label272:
      super.addViewInt(paramRecycler, 0, true);
      break label63;
      label282:
      j = getPaddingLeft();
      k = j + mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      break label121;
      label304:
      m = mOffset;
      i = mOffset + mConsumed;
      continue;
      label325:
      m = getPaddingTop();
      i = m + mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      if (mLayoutDirection == -1)
      {
        k = mOffset;
        j = mOffset - mConsumed;
      }
      else
      {
        j = mOffset;
        k = mOffset + mConsumed;
      }
    }
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo, int paramInt) {}
  
  public final void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0)
    {
      paramRecycler = null;
      return paramRecycler;
    }
    paramInt = convertFocusDirectionToLayoutDirection(paramInt);
    if (paramInt == Integer.MIN_VALUE) {
      return null;
    }
    ensureLayoutState();
    if (paramInt == -1) {}
    for (View localView = findReferenceChildClosestToStart(paramRecycler, paramState); localView == null; localView = findReferenceChildClosestToEnd(paramRecycler, paramState)) {
      return null;
    }
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(0.33333334F * mOrientationHelper.getTotalSpace()), false, paramState);
    mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    mLayoutState.mRecycle = false;
    fill(paramRecycler, mLayoutState, paramState, true);
    if (paramInt == -1) {}
    for (paramView = getChildClosestToStart();; paramView = getChildClosestToEnd())
    {
      if (paramView != localView)
      {
        paramRecycler = paramView;
        if (paramView.isFocusable()) {
          break;
        }
      }
      return null;
    }
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (((mPendingSavedState != null) || (mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if ((mPendingSavedState != null) && (mPendingSavedState.hasValidAnchor())) {
      mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    Object localObject1 = mAnchorInfo;
    mPosition = -1;
    mCoordinate = Integer.MIN_VALUE;
    mLayoutFromEnd = false;
    mAnchorInfo.mLayoutFromEnd = (mShouldReverseLayout ^ mStackFromEnd);
    Object localObject2 = mAnchorInfo;
    label157:
    label211:
    label240:
    label242:
    label265:
    label290:
    int m;
    if ((mInPreLayout) || (mPendingScrollPosition == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1766;
        }
        if (mRecyclerView != null) {
          break label1268;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label1615;
        }
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
        if ((mViewHolder.isRemoved()) || (mViewHolder.getLayoutPosition() < 0) || (mViewHolder.getLayoutPosition() >= paramState.getItemCount())) {
          break label1303;
        }
        i = 1;
        if (i == 0) {
          break label1615;
        }
        j = this$0.mOrientationHelper.getTotalSpaceChange();
        if (j < 0) {
          break label1308;
        }
        ((AnchorInfo)localObject2).assignFromView((View)localObject1);
        i = 1;
        if (i == 0)
        {
          ((AnchorInfo)localObject2).assignCoordinateFromPadding();
          if (!mStackFromEnd) {
            break label1771;
          }
          i = paramState.getItemCount() - 1;
          mPosition = i;
        }
      }
      i = getExtraLayoutSpace(paramState);
      if (mLayoutState.mLastScrollDelta < 0) {
        break label1776;
      }
      j = 0;
      k = j + mOrientationHelper.getStartAfterPadding();
      m = i + mOrientationHelper.getEndPadding();
      i = m;
      j = k;
      if (mInPreLayout)
      {
        i = m;
        j = k;
        if (mPendingScrollPosition != -1)
        {
          i = m;
          j = k;
          if (mPendingScrollPositionOffset != Integer.MIN_VALUE)
          {
            localObject1 = findViewByPosition(mPendingScrollPosition);
            i = m;
            j = k;
            if (localObject1 != null)
            {
              if (!mShouldReverseLayout) {
                break label1784;
              }
              i = mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd((View)localObject1) - mPendingScrollPositionOffset;
              label410:
              if (i <= 0) {
                break label1816;
              }
              j = k + i;
              i = m;
            }
          }
        }
      }
      label423:
      if (!mAnchorInfo.mLayoutFromEnd) {
        break label1834;
      }
      if (!mShouldReverseLayout) {
        break label1828;
      }
      k = 1;
      label443:
      onAnchorReady(paramRecycler, paramState, mAnchorInfo, k);
      detachAndScrapAttachedViews(paramRecycler);
      mLayoutState.mInfinite = resolveIsInfinite();
      mLayoutState.mIsPreLayout = mInPreLayout;
      if (!mAnchorInfo.mLayoutFromEnd) {
        break label1853;
      }
      updateLayoutStateToFillStart(mAnchorInfo);
      mLayoutState.mExtra = j;
      fill(paramRecycler, mLayoutState, paramState, false);
      k = mLayoutState.mOffset;
      n = mLayoutState.mCurrentPosition;
      j = i;
      if (mLayoutState.mAvailable > 0) {
        j = i + mLayoutState.mAvailable;
      }
      updateLayoutStateToFillEnd(mAnchorInfo);
      mLayoutState.mExtra = j;
      localObject1 = mLayoutState;
      mCurrentPosition += mLayoutState.mItemDirection;
      fill(paramRecycler, mLayoutState, paramState, false);
      m = mLayoutState.mOffset;
      i = m;
      j = k;
      if (mLayoutState.mAvailable > 0)
      {
        i = mLayoutState.mAvailable;
        updateLayoutStateToFillStart(n, k);
        mLayoutState.mExtra = i;
        fill(paramRecycler, mLayoutState, paramState, false);
        j = mLayoutState.mOffset;
        i = m;
      }
      label690:
      k = i;
      m = j;
      if (getChildCount() > 0)
      {
        if (!(mShouldReverseLayout ^ mStackFromEnd)) {
          break label2052;
        }
        k = fixLayoutEndGap(i, paramRecycler, paramState, true);
        m = j + k;
        j = fixLayoutStartGap(m, paramRecycler, paramState, false);
        m += j;
      }
    }
    boolean bool;
    label1173:
    label1200:
    label1206:
    label1268:
    label1303:
    label1308:
    int i1;
    for (int k = i + k + j;; k = i + n)
    {
      if ((mRunPredictiveAnimations) && (getChildCount() != 0) && (!mInPreLayout) && (supportsPredictiveItemAnimations())) {
        break label2097;
      }
      if (!mInPreLayout)
      {
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        paramRecycler = mOrientationHelper;
        mLastTotalSpace = paramRecycler.getTotalSpace();
      }
      mLastStackFromEnd = mStackFromEnd;
      mPendingSavedState = null;
      return;
      if ((mPendingScrollPosition < 0) || (mPendingScrollPosition >= paramState.getItemCount()))
      {
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        i = 0;
        break;
      }
      mPosition = mPendingScrollPosition;
      if ((mPendingSavedState != null) && (mPendingSavedState.hasValidAnchor()))
      {
        mLayoutFromEnd = mPendingSavedState.mAnchorLayoutFromEnd;
        if (mLayoutFromEnd) {}
        for (mCoordinate = (mOrientationHelper.getEndAfterPadding() - mPendingSavedState.mAnchorOffset);; mCoordinate = (mOrientationHelper.getStartAfterPadding() + mPendingSavedState.mAnchorOffset))
        {
          i = 1;
          break;
        }
      }
      if (mPendingScrollPositionOffset == Integer.MIN_VALUE)
      {
        localObject1 = findViewByPosition(mPendingScrollPosition);
        if (localObject1 != null) {
          if (mOrientationHelper.getDecoratedMeasurement((View)localObject1) > mOrientationHelper.getTotalSpace()) {
            ((AnchorInfo)localObject2).assignCoordinateFromPadding();
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        if (mOrientationHelper.getDecoratedStart((View)localObject1) - mOrientationHelper.getStartAfterPadding() < 0)
        {
          mCoordinate = mOrientationHelper.getStartAfterPadding();
          mLayoutFromEnd = false;
        }
        else if (mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd((View)localObject1) < 0)
        {
          mCoordinate = mOrientationHelper.getEndAfterPadding();
          mLayoutFromEnd = true;
        }
        else
        {
          if (mLayoutFromEnd) {}
          for (i = mOrientationHelper.getDecoratedEnd((View)localObject1) + mOrientationHelper.getTotalSpaceChange();; i = mOrientationHelper.getDecoratedStart((View)localObject1))
          {
            mCoordinate = i;
            i = 1;
            break;
          }
          if (getChildCount() > 0)
          {
            i = getPosition(getChildAt(0));
            if (mPendingScrollPosition >= i) {
              break label1200;
            }
            bool = true;
            if (bool != mShouldReverseLayout) {
              break label1206;
            }
          }
          for (bool = true;; bool = false)
          {
            mLayoutFromEnd = bool;
            ((AnchorInfo)localObject2).assignCoordinateFromPadding();
            break;
            bool = false;
            break label1173;
          }
          mLayoutFromEnd = mShouldReverseLayout;
          if (mShouldReverseLayout) {
            mCoordinate = (mOrientationHelper.getEndAfterPadding() - mPendingScrollPositionOffset);
          } else {
            mCoordinate = (mOrientationHelper.getStartAfterPadding() + mPendingScrollPositionOffset);
          }
        }
      }
      localObject1 = mRecyclerView.getFocusedChild();
      if ((localObject1 == null) || (mChildHelper.isHidden((View)localObject1)))
      {
        localObject1 = null;
        break label157;
      }
      break label157;
      i = 0;
      break label211;
      mPosition = getPosition((View)localObject1);
      if (mLayoutFromEnd)
      {
        i = this$0.mOrientationHelper.getEndAfterPadding() - j - this$0.mOrientationHelper.getDecoratedEnd((View)localObject1);
        mCoordinate = (this$0.mOrientationHelper.getEndAfterPadding() - i);
        if (i <= 0) {
          break label240;
        }
        j = this$0.mOrientationHelper.getDecoratedMeasurement((View)localObject1);
        k = mCoordinate;
        m = this$0.mOrientationHelper.getStartAfterPadding();
        j = k - j - (Math.min(this$0.mOrientationHelper.getDecoratedStart((View)localObject1) - m, 0) + m);
        if (j >= 0) {
          break label240;
        }
        k = mCoordinate;
        mCoordinate = (Math.min(i, -j) + k);
        break label240;
      }
      k = this$0.mOrientationHelper.getDecoratedStart((View)localObject1);
      i = k - this$0.mOrientationHelper.getStartAfterPadding();
      mCoordinate = k;
      if (i <= 0) {
        break label240;
      }
      m = this$0.mOrientationHelper.getDecoratedMeasurement((View)localObject1);
      n = this$0.mOrientationHelper.getEndAfterPadding();
      i1 = this$0.mOrientationHelper.getDecoratedEnd((View)localObject1);
      j = this$0.mOrientationHelper.getEndAfterPadding() - Math.min(0, n - j - i1) - (k + m);
      if (j >= 0) {
        break label240;
      }
      mCoordinate -= Math.min(i, -j);
      break label240;
      label1615:
      if (mLastStackFromEnd == mStackFromEnd)
      {
        if (mLayoutFromEnd)
        {
          localObject1 = findReferenceChildClosestToEnd(paramRecycler, paramState);
          label1642:
          if (localObject1 == null) {
            break label1766;
          }
          ((AnchorInfo)localObject2).assignFromView((View)localObject1);
          if ((!mInPreLayout) && (supportsPredictiveItemAnimations()))
          {
            if ((mOrientationHelper.getDecoratedStart((View)localObject1) < mOrientationHelper.getEndAfterPadding()) && (mOrientationHelper.getDecoratedEnd((View)localObject1) >= mOrientationHelper.getStartAfterPadding())) {
              break label1750;
            }
            i = 1;
            label1708:
            if (i != 0) {
              if (!mLayoutFromEnd) {
                break label1755;
              }
            }
          }
        }
        label1750:
        label1755:
        for (i = mOrientationHelper.getEndAfterPadding();; i = mOrientationHelper.getStartAfterPadding())
        {
          mCoordinate = i;
          i = 1;
          break;
          localObject1 = findReferenceChildClosestToStart(paramRecycler, paramState);
          break label1642;
          i = 0;
          break label1708;
        }
      }
      label1766:
      i = 0;
      break label242;
      label1771:
      i = 0;
      break label265;
      label1776:
      j = i;
      i = 0;
      break label290;
      label1784:
      i = mOrientationHelper.getDecoratedStart((View)localObject1);
      j = mOrientationHelper.getStartAfterPadding();
      i = mPendingScrollPositionOffset - (i - j);
      break label410;
      label1816:
      i = m - i;
      j = k;
      break label423;
      label1828:
      k = -1;
      break label443;
      label1834:
      if (mShouldReverseLayout) {}
      for (k = -1;; k = 1) {
        break;
      }
      label1853:
      updateLayoutStateToFillEnd(mAnchorInfo);
      mLayoutState.mExtra = i;
      fill(paramRecycler, mLayoutState, paramState, false);
      k = mLayoutState.mOffset;
      n = mLayoutState.mCurrentPosition;
      i = j;
      if (mLayoutState.mAvailable > 0) {
        i = j + mLayoutState.mAvailable;
      }
      updateLayoutStateToFillStart(mAnchorInfo);
      mLayoutState.mExtra = i;
      localObject1 = mLayoutState;
      mCurrentPosition += mLayoutState.mItemDirection;
      fill(paramRecycler, mLayoutState, paramState, false);
      m = mLayoutState.mOffset;
      i = k;
      j = m;
      if (mLayoutState.mAvailable <= 0) {
        break label690;
      }
      i = mLayoutState.mAvailable;
      updateLayoutStateToFillEnd(n, k);
      mLayoutState.mExtra = i;
      fill(paramRecycler, mLayoutState, paramState, false);
      i = mLayoutState.mOffset;
      j = m;
      break label690;
      label2052:
      k = fixLayoutStartGap(j, paramRecycler, paramState, true);
      i += k;
      n = fixLayoutEndGap(i, paramRecycler, paramState, false);
      m = j + k + n;
    }
    label2097:
    int i = 0;
    int j = 0;
    localObject1 = mUnmodifiableAttachedScrap;
    int i2 = ((List)localObject1).size();
    int i3 = getPosition(getChildAt(0));
    int n = 0;
    label2130:
    if (n < i2)
    {
      localObject2 = (RecyclerView.ViewHolder)((List)localObject1).get(n);
      if (((RecyclerView.ViewHolder)localObject2).isRemoved()) {
        break label2402;
      }
      if (((RecyclerView.ViewHolder)localObject2).getLayoutPosition() < i3)
      {
        bool = true;
        label2172:
        if (bool == mShouldReverseLayout) {
          break label2242;
        }
        i1 = -1;
        label2184:
        if (i1 != -1) {
          break label2248;
        }
        i1 = mOrientationHelper.getDecoratedMeasurement(itemView) + i;
        i = j;
        j = i1;
      }
    }
    for (;;)
    {
      i1 = n + 1;
      n = j;
      j = i;
      i = n;
      n = i1;
      break label2130;
      bool = false;
      break label2172;
      label2242:
      i1 = 1;
      break label2184;
      label2248:
      i1 = mOrientationHelper.getDecoratedMeasurement(itemView) + j;
      j = i;
      i = i1;
      continue;
      mLayoutState.mScrapList = ((List)localObject1);
      if (i > 0)
      {
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), m);
        mLayoutState.mExtra = i;
        mLayoutState.mAvailable = 0;
        mLayoutState.assignPositionFromScrapList(null);
        fill(paramRecycler, mLayoutState, paramState, false);
      }
      if (j > 0)
      {
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), k);
        mLayoutState.mExtra = j;
        mLayoutState.mAvailable = 0;
        mLayoutState.assignPositionFromScrapList(null);
        fill(paramRecycler, mLayoutState, paramState, false);
      }
      mLayoutState.mScrapList = null;
      break;
      label2402:
      i1 = i;
      i = j;
      j = i1;
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      mPendingSavedState = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (mPendingSavedState != null) {
      return new SavedState(mPendingSavedState);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = mLastStackFromEnd ^ mShouldReverseLayout;
      mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localView = getChildClosestToEnd();
        mAnchorOffset = (mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(localView));
        mAnchorPosition = getPosition(localView);
        return localSavedState;
      }
      View localView = getChildClosestToStart();
      mAnchorPosition = getPosition(localView);
      mAnchorOffset = (mOrientationHelper.getDecoratedStart(localView) - mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    mAnchorPosition = -1;
    return localSavedState;
  }
  
  public final void prepareForDrop$6516cd95(View paramView1, View paramView2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    int i = getPosition(paramView1);
    int j = getPosition(paramView2);
    if (i < j) {
      i = 1;
    }
    while (mShouldReverseLayout) {
      if (i == 1)
      {
        scrollToPositionWithOffset(j, mOrientationHelper.getEndAfterPadding() - (mOrientationHelper.getDecoratedStart(paramView2) + mOrientationHelper.getDecoratedMeasurement(paramView1)));
        return;
        i = -1;
      }
      else
      {
        scrollToPositionWithOffset(j, mOrientationHelper.getEndAfterPadding() - mOrientationHelper.getDecoratedEnd(paramView2));
        return;
      }
    }
    if (i == -1)
    {
      scrollToPositionWithOffset(j, mOrientationHelper.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(j, mOrientationHelper.getDecoratedEnd(paramView2) - mOrientationHelper.getDecoratedMeasurement(paramView1));
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 1) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    mPendingScrollPosition = paramInt;
    mPendingScrollPositionOffset = Integer.MIN_VALUE;
    if (mPendingSavedState != null) {
      mPendingSavedState.mAnchorPosition = -1;
    }
    requestLayout();
  }
  
  public final void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    mPendingScrollPosition = paramInt1;
    mPendingScrollPositionOffset = paramInt2;
    if (mPendingSavedState != null) {
      mPendingSavedState.mAnchorPosition = -1;
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == mOrientation) {
      return;
    }
    mOrientation = paramInt;
    mOrientationHelper = null;
    requestLayout();
  }
  
  public final void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == mReverseLayout) {
      return;
    }
    mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (mStackFromEnd == paramBoolean) {
      return;
    }
    mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  final boolean shouldMeasureTwice()
  {
    if ((mHeightMode != 1073741824) && (mWidthMode != 1073741824))
    {
      int j = getChildCount();
      int i = 0;
      if (i < j)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
        if ((width >= 0) || (height >= 0)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label75;
        }
        return true;
        i += 1;
        break;
      }
    }
    label75:
    return false;
  }
  
  public void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext())
    {
      public final PointF computeScrollVectorForPosition(int paramAnonymousInt)
      {
        return LinearLayoutManager.this.computeScrollVectorForPosition(paramAnonymousInt);
      }
    };
    mTargetPosition = paramInt;
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (mPendingSavedState == null) && (mLastStackFromEnd == mStackFromEnd);
  }
  
  final class AnchorInfo
  {
    int mCoordinate;
    boolean mLayoutFromEnd;
    int mPosition;
    
    AnchorInfo() {}
    
    final void assignCoordinateFromPadding()
    {
      if (mLayoutFromEnd) {}
      for (int i = mOrientationHelper.getEndAfterPadding();; i = mOrientationHelper.getStartAfterPadding())
      {
        mCoordinate = i;
        return;
      }
    }
    
    public final void assignFromView(View paramView)
    {
      if (mLayoutFromEnd) {}
      for (mCoordinate = (mOrientationHelper.getDecoratedEnd(paramView) + mOrientationHelper.getTotalSpaceChange());; mCoordinate = mOrientationHelper.getDecoratedStart(paramView))
      {
        mPosition = LinearLayoutManager.getPosition(paramView);
        return;
      }
    }
    
    public final String toString()
    {
      return "AnchorInfo{mPosition=" + mPosition + ", mCoordinate=" + mCoordinate + ", mLayoutFromEnd=" + mLayoutFromEnd + '}';
    }
  }
  
  protected static final class LayoutChunkResult
  {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;
  }
  
  static final class LayoutState
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
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      mAnchorPosition = paramParcel.readInt();
      mAnchorOffset = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        mAnchorLayoutFromEnd = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      mAnchorPosition = mAnchorPosition;
      mAnchorOffset = mAnchorOffset;
      mAnchorLayoutFromEnd = mAnchorLayoutFromEnd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final boolean hasValidAnchor()
    {
      return mAnchorPosition >= 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(mAnchorPosition);
      paramParcel.writeInt(mAnchorOffset);
      if (mAnchorLayoutFromEnd) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */