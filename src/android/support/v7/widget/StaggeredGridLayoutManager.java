package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
{
  private final AnchorInfo mAnchorInfo = new AnchorInfo((byte)0);
  private final Runnable mCheckForGapsRunnable = new Runnable()
  {
    public final void run()
    {
      StaggeredGridLayoutManager.this.checkForGaps();
    }
  };
  private int mFullSizeSpec;
  private int mGapStrategy = 2;
  private boolean mLaidOutInvalidFullSpan = false;
  private boolean mLastLayoutFromEnd;
  private boolean mLastLayoutRTL;
  private final LayoutState mLayoutState;
  LazySpanLookup mLazySpanLookup = new LazySpanLookup();
  private int mOrientation;
  private SavedState mPendingSavedState;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  OrientationHelper mPrimaryOrientation;
  private BitSet mRemainingSpans;
  private boolean mReverseLayout = false;
  OrientationHelper mSecondaryOrientation;
  boolean mShouldReverseLayout = false;
  private int mSizePerSpan;
  private boolean mSmoothScrollbarEnabled = true;
  public int mSpanCount = -1;
  public Span[] mSpans;
  private final Rect mTmpRect = new Rect();
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    mOrientation = paramInt2;
    setSpanCount(paramInt1);
    if (mGapStrategy != 0) {}
    for (;;)
    {
      mAutoMeasure = bool;
      mLayoutState = new LayoutState();
      createOrientationHelpers();
      return;
      bool = false;
    }
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt1 != mOrientation)
    {
      mOrientation = paramInt1;
      paramAttributeSet = mPrimaryOrientation;
      mPrimaryOrientation = mSecondaryOrientation;
      mSecondaryOrientation = paramAttributeSet;
      requestLayout();
    }
    setSpanCount(spanCount);
    setReverseLayout(reverseLayout);
    if (mGapStrategy != 0) {}
    for (;;)
    {
      mAutoMeasure = bool;
      mLayoutState = new LayoutState();
      createOrientationHelpers();
      return;
      bool = false;
    }
  }
  
  private int calculateScrollDirectionForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!mShouldReverseLayout) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < getFirstChildPosition()) {}
      for (int i = 1; i != mShouldReverseLayout; i = 0) {
        return -1;
      }
    }
  }
  
  private boolean checkForGaps()
  {
    if ((getChildCount() == 0) || (mGapStrategy == 0) || (!mIsAttachedToWindow)) {
      return false;
    }
    int j;
    if (mShouldReverseLayout) {
      j = getLastChildPosition();
    }
    for (int i = getFirstChildPosition(); (j == 0) && (hasGapsToFix() != null); i = getLastChildPosition())
    {
      mLazySpanLookup.clear();
      mRequestedSimpleAnimations = true;
      requestLayout();
      return true;
      j = getFirstChildPosition();
    }
    if (!mLaidOutInvalidFullSpan) {
      return false;
    }
    if (mShouldReverseLayout) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = mLazySpanLookup.getFirstFullSpanItemInRange$7b524a3(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      mLaidOutInvalidFullSpan = false;
      mLazySpanLookup.forceInvalidateAfter(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = mLazySpanLookup.getFirstFullSpanItemInRange$7b524a3(j, mPosition, k * -1);
    if (localFullSpanItem2 == null) {
      mLazySpanLookup.forceInvalidateAfter(mPosition);
    }
    for (;;)
    {
      mRequestedSimpleAnimations = true;
      requestLayout();
      return true;
      mLazySpanLookup.forceInvalidateAfter(mPosition + 1);
    }
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    OrientationHelper localOrientationHelper = mPrimaryOrientation;
    View localView;
    if (!mSmoothScrollbarEnabled)
    {
      bool1 = true;
      localView = findFirstVisibleItemClosestToStart$2930a1b7(bool1);
      if (mSmoothScrollbarEnabled) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ScrollbarHelper.computeScrollExtent(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd$2930a1b7(bool1), this, mSmoothScrollbarEnabled);
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
    OrientationHelper localOrientationHelper = mPrimaryOrientation;
    View localView;
    if (!mSmoothScrollbarEnabled)
    {
      bool1 = true;
      localView = findFirstVisibleItemClosestToStart$2930a1b7(bool1);
      if (mSmoothScrollbarEnabled) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ScrollbarHelper.computeScrollOffset(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd$2930a1b7(bool1), this, mSmoothScrollbarEnabled, mShouldReverseLayout);
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
    OrientationHelper localOrientationHelper = mPrimaryOrientation;
    View localView;
    if (!mSmoothScrollbarEnabled)
    {
      bool1 = true;
      localView = findFirstVisibleItemClosestToStart$2930a1b7(bool1);
      if (mSmoothScrollbarEnabled) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ScrollbarHelper.computeScrollRange(paramState, localOrientationHelper, localView, findFirstVisibleItemClosestToEnd$2930a1b7(bool1), this, mSmoothScrollbarEnabled);
      bool1 = false;
      break;
    }
  }
  
  private void createOrientationHelpers()
  {
    mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, mOrientation);
    mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - mOrientation);
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState)
  {
    mRemainingSpans.set(0, mSpanCount, true);
    int i;
    int k;
    label61:
    int j;
    int m;
    label85:
    View localView;
    LayoutParams localLayoutParams;
    int i4;
    Object localObject1;
    if (mLayoutState.mInfinite) {
      if (mLayoutDirection == 1)
      {
        i = Integer.MAX_VALUE;
        updateAllRemainingSpans(mLayoutDirection, i);
        if (!mShouldReverseLayout) {
          break label478;
        }
        k = mPrimaryOrientation.getEndAfterPadding();
        j = 0;
        if ((mCurrentPosition < 0) || (mCurrentPosition >= paramState.getItemCount())) {
          break label490;
        }
        m = 1;
        if ((m == 0) || ((!mLayoutState.mInfinite) && (mRemainingSpans.isEmpty()))) {
          break label1689;
        }
        localView = paramRecycler.getViewForPosition(mCurrentPosition);
        mCurrentPosition += mItemDirection;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i4 = mViewHolder.getLayoutPosition();
        localObject1 = mLazySpanLookup;
        if ((mData != null) && (i4 < mData.length)) {
          break label496;
        }
        j = -1;
        label181:
        if (j != -1) {
          break label509;
        }
        m = 1;
      }
    }
    label211:
    Object localObject2;
    label237:
    label260:
    label304:
    label328:
    int i2;
    int n;
    int i1;
    label478:
    label490:
    label496:
    label509:
    label540:
    int i3;
    int i5;
    for (;;)
    {
      if (m != 0)
      {
        if (mFullSpan)
        {
          localObject1 = mSpans[0];
          localObject2 = mLazySpanLookup;
          ((LazySpanLookup)localObject2).ensureSize(i4);
          mData[i4] = mIndex;
          mSpan = ((Span)localObject1);
          if (mLayoutDirection != 1) {
            break label729;
          }
          addViewInt(localView, -1, false);
          if (!mFullSpan) {
            break label771;
          }
          if (mOrientation != 1) {
            break label740;
          }
          measureChildWithDecorationsAndMargin$1bb98217(localView, mFullSizeSpec, getChildMeasureSpec(mHeight, mHeightMode, 0, height, true));
          if (mLayoutDirection != 1) {
            break label1075;
          }
          if (!mFullSpan) {
            break label869;
          }
          j = getMaxEnd(k);
          i2 = j + mPrimaryOrientation.getDecoratedMeasurement(localView);
          n = j;
          i1 = i2;
          if (m == 0) {
            break label911;
          }
          n = j;
          i1 = i2;
          if (!mFullSpan) {
            break label911;
          }
          localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
          mGapPerSpan = new int[mSpanCount];
          n = 0;
          while (n < mSpanCount)
          {
            mGapPerSpan[n] = (j - mSpans[n].getEndLine(j));
            n += 1;
          }
          i = Integer.MIN_VALUE;
          break;
          if (mLayoutDirection == 1)
          {
            i = mEndLine + mAvailable;
            break;
          }
          i = mStartLine - mAvailable;
          break;
          k = mPrimaryOrientation.getStartAfterPadding();
          break label61;
          m = 0;
          break label85;
          j = mData[i4];
          break label181;
          m = 0;
          continue;
        }
        if (preferLastSpan(mLayoutDirection))
        {
          j = mSpanCount - 1;
          i1 = -1;
          n = -1;
          if (mLayoutDirection != 1) {
            break label640;
          }
          localObject1 = null;
          i3 = Integer.MAX_VALUE;
          i5 = mPrimaryOrientation.getStartAfterPadding();
          i2 = j;
          j = i3;
          label572:
          if (i2 == i1) {
            break label637;
          }
          localObject2 = mSpans[i2];
          i3 = ((Span)localObject2).getEndLine(i5);
          if (i3 >= j) {
            break label1783;
          }
          localObject1 = localObject2;
          j = i3;
        }
      }
    }
    label637:
    label640:
    label664:
    label729:
    label740:
    label771:
    label869:
    label911:
    label956:
    label985:
    label1075:
    label1243:
    label1252:
    label1258:
    label1264:
    label1280:
    label1309:
    label1335:
    label1341:
    label1351:
    label1383:
    label1427:
    label1448:
    label1496:
    label1638:
    label1655:
    label1673:
    label1689:
    label1780:
    label1783:
    for (;;)
    {
      i2 += n;
      break label572;
      j = 0;
      i1 = mSpanCount;
      n = 1;
      break label540;
      break label211;
      localObject1 = null;
      i3 = Integer.MIN_VALUE;
      i5 = mPrimaryOrientation.getEndAfterPadding();
      i2 = j;
      j = i3;
      if (i2 != i1)
      {
        localObject2 = mSpans[i2];
        i3 = ((Span)localObject2).getStartLine(i5);
        if (i3 <= j) {
          break label1780;
        }
        localObject1 = localObject2;
        j = i3;
      }
      for (;;)
      {
        i2 += n;
        break label664;
        break label211;
        localObject1 = mSpans[j];
        break label237;
        super.addViewInt(localView, 0, false);
        break label260;
        measureChildWithDecorationsAndMargin$1bb98217(localView, getChildMeasureSpec(mWidth, mWidthMode, 0, width, true), mFullSizeSpec);
        break label304;
        if (mOrientation == 1)
        {
          measureChildWithDecorationsAndMargin$1bb98217(localView, getChildMeasureSpec(mSizePerSpan, mWidthMode, 0, width, false), getChildMeasureSpec(mHeight, mHeightMode, 0, height, true));
          break label304;
        }
        measureChildWithDecorationsAndMargin$1bb98217(localView, getChildMeasureSpec(mWidth, mWidthMode, 0, width, true), getChildMeasureSpec(mSizePerSpan, mHeightMode, 0, height, false));
        break label304;
        j = ((Span)localObject1).getEndLine(k);
        break label328;
        mGapDir = -1;
        mPosition = i4;
        mLazySpanLookup.addFullSpanItem((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
        i1 = i2;
        n = j;
        if ((mFullSpan) && (mItemDirection == -1)) {
          if (m == 0)
          {
            if (mLayoutDirection != 1) {
              break label1264;
            }
            m = mSpans[0].getEndLine(Integer.MIN_VALUE);
            j = 1;
            if (j >= mSpanCount) {
              break label1252;
            }
            if (mSpans[j].getEndLine(Integer.MIN_VALUE) == m) {
              break label1243;
            }
            j = 0;
            if (j != 0) {
              break label1258;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j != 0)
          {
            localObject2 = mLazySpanLookup.getFullSpanItem(i4);
            if (localObject2 != null) {
              mHasUnwantedGapAfter = true;
            }
            mLaidOutInvalidFullSpan = true;
          }
          if (mLayoutDirection != 1) {
            break label1496;
          }
          if (!mFullSpan) {
            break label1341;
          }
          j = mSpanCount - 1;
          while (j >= 0)
          {
            mSpans[j].appendToSpan(localView);
            j -= 1;
          }
          if (mFullSpan) {}
          for (j = getMinStart(k);; j = ((Span)localObject1).getStartLine(k))
          {
            i2 = j - mPrimaryOrientation.getDecoratedMeasurement(localView);
            n = i2;
            i1 = j;
            if (m == 0) {
              break;
            }
            n = i2;
            i1 = j;
            if (!mFullSpan) {
              break;
            }
            localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
            mGapPerSpan = new int[mSpanCount];
            n = 0;
            while (n < mSpanCount)
            {
              mGapPerSpan[n] = (mSpans[n].getStartLine(j) - j);
              n += 1;
            }
          }
          mGapDir = 1;
          mPosition = i4;
          mLazySpanLookup.addFullSpanItem((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
          n = i2;
          i1 = j;
          break;
          j += 1;
          break label956;
          j = 1;
          break label985;
        }
        m = mSpans[0].getStartLine(Integer.MIN_VALUE);
        j = 1;
        if (j < mSpanCount) {
          if (mSpans[j].getStartLine(Integer.MIN_VALUE) != m)
          {
            j = 0;
            if (j != 0) {
              break label1335;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          break;
          j += 1;
          break label1280;
          j = 1;
          break label1309;
        }
        mSpan.appendToSpan(localView);
        if ((isLayoutRTL()) && (mOrientation == 1)) {
          if (mFullSpan)
          {
            j = mSecondaryOrientation.getEndAfterPadding();
            i2 = j - mSecondaryOrientation.getDecoratedMeasurement(localView);
            m = j;
            j = i2;
            if (mOrientation != 1) {
              break label1638;
            }
            layoutDecoratedWithMargins(localView, j, n, m, i1);
            if (!mFullSpan) {
              break label1655;
            }
            updateAllRemainingSpans(mLayoutState.mLayoutDirection, i);
            recycle(paramRecycler, mLayoutState);
            if ((mLayoutState.mStopInFocusable) && (localView.isFocusable()))
            {
              if (!mFullSpan) {
                break label1673;
              }
              mRemainingSpans.clear();
            }
          }
        }
        for (;;)
        {
          j = 1;
          break;
          if (mFullSpan)
          {
            j = mSpanCount - 1;
            while (j >= 0)
            {
              mSpans[j].prependToSpan(localView);
              j -= 1;
            }
            break label1351;
          }
          mSpan.prependToSpan(localView);
          break label1351;
          j = mSecondaryOrientation.getEndAfterPadding() - (mSpanCount - 1 - mIndex) * mSizePerSpan;
          break label1383;
          if (mFullSpan) {}
          for (j = mSecondaryOrientation.getStartAfterPadding();; j = mIndex * mSizePerSpan + mSecondaryOrientation.getStartAfterPadding())
          {
            m = j + mSecondaryOrientation.getDecoratedMeasurement(localView);
            break;
          }
          layoutDecoratedWithMargins(localView, n, j, i1, m);
          break label1427;
          updateRemainingSpans((Span)localObject1, mLayoutState.mLayoutDirection, i);
          break label1448;
          mRemainingSpans.set(mIndex, false);
        }
        if (j == 0) {
          recycle(paramRecycler, mLayoutState);
        }
        if (mLayoutState.mLayoutDirection == -1) {
          i = getMinStart(mPrimaryOrientation.getStartAfterPadding());
        }
        for (i = mPrimaryOrientation.getStartAfterPadding() - i; i > 0; i = getMaxEnd(mPrimaryOrientation.getEndAfterPadding()) - mPrimaryOrientation.getEndAfterPadding()) {
          return Math.min(mAvailable, i);
        }
        return 0;
      }
    }
  }
  
  private View findFirstVisibleItemClosestToEnd$2930a1b7(boolean paramBoolean)
  {
    int j = mPrimaryOrientation.getStartAfterPadding();
    int k = mPrimaryOrientation.getEndAfterPadding();
    Object localObject1 = null;
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      int m = mPrimaryOrientation.getDecoratedStart(localView);
      int n = mPrimaryOrientation.getDecoratedEnd(localView);
      Object localObject2 = localObject1;
      if (n > j)
      {
        localObject2 = localObject1;
        if (m < k)
        {
          if ((n <= k) || (!paramBoolean)) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
      }
      i -= 1;
      localObject1 = localObject2;
    }
    return (View)localObject1;
  }
  
  private View findFirstVisibleItemClosestToStart$2930a1b7(boolean paramBoolean)
  {
    int j = mPrimaryOrientation.getStartAfterPadding();
    int k = mPrimaryOrientation.getEndAfterPadding();
    int m = getChildCount();
    Object localObject1 = null;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int n = mPrimaryOrientation.getDecoratedStart(localView);
      Object localObject2 = localObject1;
      if (mPrimaryOrientation.getDecoratedEnd(localView) > j)
      {
        localObject2 = localObject1;
        if (n < k)
        {
          if ((n >= j) || (!paramBoolean)) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (View)localObject1;
  }
  
  private void fixEndGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMaxEnd(Integer.MIN_VALUE);
    if (i == Integer.MIN_VALUE) {}
    do
    {
      do
      {
        return;
        i = mPrimaryOrientation.getEndAfterPadding() - i;
      } while (i <= 0);
      i -= -scrollBy(-i, paramRecycler, paramState);
    } while ((!paramBoolean) || (i <= 0));
    mPrimaryOrientation.offsetChildren(i);
  }
  
  private void fixStartGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMinStart(Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {}
    do
    {
      do
      {
        return;
        i -= mPrimaryOrientation.getStartAfterPadding();
      } while (i <= 0);
      i -= scrollBy(i, paramRecycler, paramState);
    } while ((!paramBoolean) || (i <= 0));
    mPrimaryOrientation.offsetChildren(-i);
  }
  
  private int getFirstChildPosition()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getPosition(getChildAt(0));
  }
  
  private int getLastChildPosition()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return getPosition(getChildAt(i - 1));
  }
  
  private int getMaxEnd(int paramInt)
  {
    int j = mSpans[0].getEndLine(paramInt);
    int i = 1;
    while (i < mSpanCount)
    {
      int m = mSpans[i].getEndLine(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinStart(int paramInt)
  {
    int j = mSpans[0].getStartLine(paramInt);
    int i = 1;
    while (i < mSpanCount)
    {
      int m = mSpans[i].getStartLine(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (mShouldReverseLayout)
    {
      k = getLastChildPosition();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      mLazySpanLookup.invalidateAfter(i);
      switch (paramInt3)
      {
      default: 
        label76:
        if (j > k) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      k = getFirstChildPosition();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      i = paramInt1;
      j = paramInt1 + paramInt2;
      break label32;
      mLazySpanLookup.offsetForAddition(paramInt1, paramInt2);
      break label76;
      mLazySpanLookup.offsetForRemoval(paramInt1, paramInt2);
      break label76;
      mLazySpanLookup.offsetForRemoval(paramInt1, 1);
      mLazySpanLookup.offsetForAddition(paramInt2, 1);
      break label76;
      if (mShouldReverseLayout) {}
      for (paramInt1 = getFirstChildPosition(); i <= paramInt1; paramInt1 = getLastChildPosition())
      {
        requestLayout();
        return;
      }
    }
  }
  
  private View hasGapsToFix()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(mSpanCount);
    localBitSet.set(0, mSpanCount, true);
    int j;
    int k;
    label57:
    int m;
    label65:
    int n;
    View localView;
    LayoutParams localLayoutParams;
    Object localObject;
    if ((mOrientation == 1) && (isLayoutRTL()))
    {
      j = 1;
      if (!mShouldReverseLayout) {
        break label184;
      }
      k = -1;
      if (i >= k) {
        break label197;
      }
      m = 1;
      n = i;
      if (n == k) {
        break label461;
      }
      localView = getChildAt(n);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(mSpan.mIndex)) {
        break label275;
      }
      localObject = mSpan;
      if (!mShouldReverseLayout) {
        break label208;
      }
      if (((Span)localObject).getEndLine() >= mPrimaryOrientation.getEndAfterPadding()) {
        break label257;
      }
      if (mViews.get(mViews.size() - 1)).getLayoutParams()).mFullSpan) {
        break label203;
      }
      i = 1;
      label172:
      if (i == 0) {
        break label262;
      }
    }
    label176:
    label184:
    label197:
    label203:
    label208:
    label257:
    label262:
    label275:
    label350:
    label386:
    label409:
    label450:
    label455:
    label459:
    for (;;)
    {
      return localView;
      j = -1;
      break;
      m = 0;
      k = i + 1;
      i = m;
      break label57;
      m = -1;
      break label65;
      i = 0;
      break label172;
      if (((Span)localObject).getStartLine() > mPrimaryOrientation.getStartAfterPadding())
      {
        if (!mViews.get(0)).getLayoutParams()).mFullSpan)
        {
          i = 1;
          break label172;
        }
        i = 0;
        break label172;
      }
      i = 0;
      break label172;
      localBitSet.clear(mSpan.mIndex);
      int i2;
      if ((!mFullSpan) && (n + m != k))
      {
        localObject = getChildAt(n + m);
        i = 0;
        if (!mShouldReverseLayout) {
          break label409;
        }
        i1 = mPrimaryOrientation.getDecoratedEnd(localView);
        i2 = mPrimaryOrientation.getDecoratedEnd((View)localObject);
        if (i1 < i2) {
          continue;
        }
        if (i1 == i2) {
          i = 1;
        }
        if (i != 0)
        {
          localObject = (LayoutParams)((View)localObject).getLayoutParams();
          if (mSpan.mIndex - mSpan.mIndex >= 0) {
            break label450;
          }
          i = 1;
          if (j >= 0) {
            break label455;
          }
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i != i1) {
          break label459;
        }
        n += m;
        break;
        i1 = mPrimaryOrientation.getDecoratedStart(localView);
        i2 = mPrimaryOrientation.getDecoratedStart((View)localObject);
        if (i1 > i2) {
          break label176;
        }
        if (i1 != i2) {
          break label350;
        }
        i = 1;
        break label350;
        i = 0;
        break label386;
      }
    }
    label461:
    return null;
  }
  
  private boolean isLayoutRTL()
  {
    return ViewCompat.getLayoutDirection(mRecyclerView) == 1;
  }
  
  private void layoutDecoratedWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    layoutDecorated(paramView, paramInt1 + leftMargin, paramInt2 + topMargin, paramInt3 - rightMargin, paramInt4 - bottomMargin);
  }
  
  private void measureChildWithDecorationsAndMargin$1bb98217(View paramView, int paramInt1, int paramInt2)
  {
    calculateItemDecorationsForChild(paramView, mTmpRect);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt1 = updateSpecWithExtra(paramInt1, leftMargin + mTmpRect.left, rightMargin + mTmpRect.right);
    paramInt2 = updateSpecWithExtra(paramInt2, topMargin + mTmpRect.top, bottomMargin + mTmpRect.bottom);
    if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private boolean preferLastSpan(int paramInt)
  {
    int i;
    if (mOrientation == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == mShouldReverseLayout) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i = 1;
        if (i != mShouldReverseLayout) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == isLayoutRTL()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private void recycle(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    int k = 1;
    int i = 1;
    if ((!mRecycle) || (mInfinite)) {
      return;
    }
    if (mAvailable == 0)
    {
      if (mLayoutDirection == -1)
      {
        recycleFromEnd(paramRecycler, mEndLine);
        return;
      }
      recycleFromStart(paramRecycler, mStartLine);
      return;
    }
    int m;
    if (mLayoutDirection == -1)
    {
      n = mStartLine;
      int i1 = mStartLine;
      for (j = mSpans[0].getStartLine(i1); i < mSpanCount; j = k)
      {
        m = mSpans[i].getStartLine(i1);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
      i = n - j;
      if (i < 0) {}
      for (i = mEndLine;; i = mEndLine - Math.min(i, mAvailable))
      {
        recycleFromEnd(paramRecycler, i);
        return;
      }
    }
    int n = mEndLine;
    int j = mSpans[0].getEndLine(n);
    i = k;
    while (i < mSpanCount)
    {
      m = mSpans[i].getEndLine(n);
      k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    i = j - mEndLine;
    if (i < 0) {}
    for (i = mStartLine;; i = mStartLine + Math.min(i, mAvailable))
    {
      recycleFromStart(paramRecycler, i);
      return;
    }
  }
  
  private void recycleFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if (mPrimaryOrientation.getDecoratedStart(localView) >= paramInt)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!mFullSpan) {
            break label119;
          }
          j = 0;
          if (j >= mSpanCount) {
            break label88;
          }
          if (mSpans[j].mViews.size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (mSpan.mViews.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < mSpanCount)
        {
          mSpans[j].popEnd();
          j += 1;
        }
      }
      mSpan.popEnd();
      removeAndRecycleView(localView, paramRecycler);
      i -= 1;
    }
  }
  
  private void recycleFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    for (;;)
    {
      View localView;
      LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if (mPrimaryOrientation.getDecoratedEnd(localView) <= paramInt)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!mFullSpan) {
            break label105;
          }
          i = 0;
          if (i >= mSpanCount) {
            break label79;
          }
          if (mSpans[i].mViews.size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label79:
      label105:
      while (mSpan.mViews.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < mSpanCount)
        {
          mSpans[i].popStart();
          i += 1;
        }
      }
      mSpan.popStart();
      removeAndRecycleView(localView, paramRecycler);
    }
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
    int i;
    int j;
    if (paramInt > 0)
    {
      i = 1;
      j = getLastChildPosition();
      mLayoutState.mRecycle = true;
      updateLayoutState(j, paramState);
      setLayoutStateDirection(i);
      mLayoutState.mCurrentPosition = (mLayoutState.mItemDirection + j);
      j = Math.abs(paramInt);
      mLayoutState.mAvailable = j;
      i = fill(paramRecycler, mLayoutState, paramState);
      if (j >= i) {
        break label116;
      }
    }
    for (;;)
    {
      mPrimaryOrientation.offsetChildren(-paramInt);
      mLastLayoutFromEnd = mShouldReverseLayout;
      return paramInt;
      i = -1;
      j = getFirstChildPosition();
      break;
      label116:
      if (paramInt < 0) {
        paramInt = -i;
      } else {
        paramInt = i;
      }
    }
  }
  
  private void setLayoutStateDirection(int paramInt)
  {
    int i = 1;
    mLayoutState.mLayoutDirection = paramInt;
    LayoutState localLayoutState = mLayoutState;
    boolean bool2 = mShouldReverseLayout;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label49;
      }
    }
    label49:
    for (paramInt = i;; paramInt = -1)
    {
      mItemDirection = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if ((mPendingSavedState != null) && (mPendingSavedState.mReverseLayout != paramBoolean)) {
      mPendingSavedState.mReverseLayout = paramBoolean;
    }
    mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  private void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != mSpanCount)
    {
      mLazySpanLookup.clear();
      requestLayout();
      mSpanCount = paramInt;
      mRemainingSpans = new BitSet(mSpanCount);
      mSpans = new Span[mSpanCount];
      paramInt = 0;
      while (paramInt < mSpanCount)
      {
        mSpans[paramInt] = new Span(paramInt, 0);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < mSpanCount)
    {
      if (!mSpans[i].mViews.isEmpty()) {
        updateRemainingSpans(mSpans[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private void updateLayoutState(int paramInt, RecyclerView.State paramState)
  {
    boolean bool2 = true;
    mLayoutState.mAvailable = 0;
    mLayoutState.mCurrentPosition = paramInt;
    int k = 0;
    int m = 0;
    int i = m;
    int j = k;
    if (isSmoothScrolling())
    {
      int n = mTargetPosition;
      i = m;
      j = k;
      if (n != -1)
      {
        boolean bool3 = mShouldReverseLayout;
        if (n >= paramInt) {
          break label184;
        }
        bool1 = true;
        if (bool3 != bool1) {
          break label190;
        }
        i = mPrimaryOrientation.getTotalSpace();
        j = k;
      }
    }
    label92:
    if (getClipToPadding())
    {
      mLayoutState.mStartLine = (mPrimaryOrientation.getStartAfterPadding() - j);
      mLayoutState.mEndLine = (mPrimaryOrientation.getEndAfterPadding() + i);
      label132:
      mLayoutState.mStopInFocusable = false;
      mLayoutState.mRecycle = true;
      paramState = mLayoutState;
      if ((mPrimaryOrientation.getMode() != 0) || (mPrimaryOrientation.getEnd() != 0)) {
        break label234;
      }
    }
    label184:
    label190:
    label234:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      mInfinite = bool1;
      return;
      bool1 = false;
      break;
      j = mPrimaryOrientation.getTotalSpace();
      i = m;
      break label92;
      mLayoutState.mEndLine = (mPrimaryOrientation.getEnd() + i);
      mLayoutState.mStartLine = (-j);
      break label132;
    }
  }
  
  private void updateMeasureSpecs(int paramInt)
  {
    mSizePerSpan = (paramInt / mSpanCount);
    mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(paramInt, mSecondaryOrientation.getMode());
  }
  
  private void updateRemainingSpans(Span paramSpan, int paramInt1, int paramInt2)
  {
    int i = mDeletedSize;
    if (paramInt1 == -1) {
      if (paramSpan.getStartLine() + i <= paramInt2) {
        mRemainingSpans.set(mIndex, false);
      }
    }
    while (paramSpan.getEndLine() - i < paramInt2) {
      return;
    }
    mRemainingSpans.set(mIndex, false);
  }
  
  private static int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != Integer.MIN_VALUE) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
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
  
  public final boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
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
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public final RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public final int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 1) {
      return mSpanCount;
    }
    return super.getColumnCountForAccessibility(paramRecycler, paramState);
  }
  
  public final int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 0) {
      return mSpanCount;
    }
    return super.getRowCountForAccessibility(paramRecycler, paramState);
  }
  
  public final void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].onOffset(paramInt);
      i += 1;
    }
  }
  
  public final void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].onOffset(paramInt);
      i += 1;
    }
  }
  
  public final void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    removeCallbacks(mCheckForGapsRunnable);
    int i = 0;
    while (i < mSpanCount)
    {
      mSpans[i].clear();
      i += 1;
    }
  }
  
  public final View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    View localView = findContainingItemView(paramView);
    if (localView == null) {
      return null;
    }
    resolveShouldLayoutReverse();
    switch (paramInt)
    {
    default: 
      paramInt = Integer.MIN_VALUE;
    }
    while (paramInt == Integer.MIN_VALUE)
    {
      return null;
      paramInt = -1;
      continue;
      paramInt = 1;
      continue;
      if (mOrientation == 1)
      {
        paramInt = -1;
      }
      else
      {
        paramInt = Integer.MIN_VALUE;
        continue;
        if (mOrientation == 1)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = Integer.MIN_VALUE;
          continue;
          if (mOrientation == 0)
          {
            paramInt = -1;
          }
          else
          {
            paramInt = Integer.MIN_VALUE;
            continue;
            if (mOrientation == 0) {
              paramInt = 1;
            } else {
              paramInt = Integer.MIN_VALUE;
            }
          }
        }
      }
    }
    paramView = (LayoutParams)localView.getLayoutParams();
    boolean bool = mFullSpan;
    paramView = mSpan;
    if (paramInt == 1) {}
    for (int i = getLastChildPosition();; i = getFirstChildPosition())
    {
      updateLayoutState(i, paramState);
      setLayoutStateDirection(paramInt);
      mLayoutState.mCurrentPosition = (mLayoutState.mItemDirection + i);
      mLayoutState.mAvailable = ((int)(0.33333334F * mPrimaryOrientation.getTotalSpace()));
      mLayoutState.mStopInFocusable = true;
      mLayoutState.mRecycle = false;
      fill(paramRecycler, mLayoutState, paramState);
      mLastLayoutFromEnd = mShouldReverseLayout;
      if (!bool)
      {
        paramRecycler = paramView.getFocusableViewAfter(i, paramInt);
        if (paramRecycler != null)
        {
          paramView = paramRecycler;
          if (paramRecycler != localView) {
            break;
          }
        }
      }
      if (!preferLastSpan(paramInt)) {
        break label390;
      }
      j = mSpanCount - 1;
      for (;;)
      {
        if (j < 0) {
          break label437;
        }
        paramRecycler = mSpans[j].getFocusableViewAfter(i, paramInt);
        if (paramRecycler != null)
        {
          paramView = paramRecycler;
          if (paramRecycler != localView) {
            break;
          }
        }
        j -= 1;
      }
    }
    label390:
    int j = 0;
    for (;;)
    {
      if (j >= mSpanCount) {
        break label437;
      }
      paramRecycler = mSpans[j].getFocusableViewAfter(i, paramInt);
      if (paramRecycler != null)
      {
        paramView = paramRecycler;
        if (paramRecycler != localView) {
          break;
        }
      }
      j += 1;
    }
    label437:
    return null;
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      localView1 = findFirstVisibleItemClosestToStart$2930a1b7(false);
      localView2 = findFirstVisibleItemClosestToEnd$2930a1b7(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = getPosition(localView1);
    int j = getPosition(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.setFromIndex(i);
      paramAccessibilityEvent.setToIndex(j);
      return;
    }
    paramAccessibilityEvent.setFromIndex(j);
    paramAccessibilityEvent.setToIndex(i);
  }
  
  public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    int k = 1;
    int i = 1;
    int j = -1;
    paramRecycler = paramView.getLayoutParams();
    if (!(paramRecycler instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramRecycler = (LayoutParams)paramRecycler;
    int m;
    int n;
    if (mOrientation == 0)
    {
      m = paramRecycler.getSpanIndex();
      if (mFullSpan) {
        i = mSpanCount;
      }
      n = -1;
      k = i;
      i = n;
    }
    for (;;)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain$430787b1(m, k, j, i, mFullSpan));
      return;
      i = paramRecycler.getSpanIndex();
      if (mFullSpan)
      {
        n = mSpanCount;
        m = -1;
        j = i;
        k = -1;
        i = n;
      }
      else
      {
        m = -1;
        j = i;
        n = -1;
        i = k;
        k = n;
      }
    }
  }
  
  public final void onItemsAdded$5927c743(int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public final void onItemsChanged$57043c5d()
  {
    mLazySpanLookup.clear();
    requestLayout();
  }
  
  public final void onItemsMoved$342e6be0(int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 8);
  }
  
  public final void onItemsRemoved$5927c743(int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public final void onItemsUpdated$783f8c5f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 4);
  }
  
  public final void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int j = 1;
    AnchorInfo localAnchorInfo = mAnchorInfo;
    mPosition = -1;
    mOffset = Integer.MIN_VALUE;
    mLayoutFromEnd = false;
    mInvalidateOffsets = false;
    if (((mPendingSavedState != null) || (mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      label61:
      return;
    }
    int m;
    int i;
    label181:
    Object localObject;
    if (mPendingSavedState != null)
    {
      if (mPendingSavedState.mSpanOffsetsSize > 0) {
        if (mPendingSavedState.mSpanOffsetsSize == mSpanCount)
        {
          k = 0;
          if (k < mSpanCount)
          {
            mSpans[k].clear();
            m = mPendingSavedState.mSpanOffsets[k];
            i = m;
            if (m != Integer.MIN_VALUE) {
              if (!mPendingSavedState.mAnchorLayoutFromEnd) {
                break label181;
              }
            }
            for (i = m + mPrimaryOrientation.getEndAfterPadding();; i = m + mPrimaryOrientation.getStartAfterPadding())
            {
              mSpans[k].setLine(i);
              k += 1;
              break;
            }
          }
        }
        else
        {
          localObject = mPendingSavedState;
          mSpanOffsets = null;
          mSpanOffsetsSize = 0;
          mSpanLookupSize = 0;
          mSpanLookup = null;
          mFullSpanItems = null;
          mPendingSavedState.mAnchorPosition = mPendingSavedState.mVisibleAnchorPosition;
        }
      }
      mLastLayoutRTL = mPendingSavedState.mLastLayoutRTL;
      setReverseLayout(mPendingSavedState.mReverseLayout);
      resolveShouldLayoutReverse();
      if (mPendingSavedState.mAnchorPosition != -1)
      {
        mPendingScrollPosition = mPendingSavedState.mAnchorPosition;
        mLayoutFromEnd = mPendingSavedState.mAnchorLayoutFromEnd;
        if (mPendingSavedState.mSpanLookupSize > 1)
        {
          mLazySpanLookup.mData = mPendingSavedState.mSpanLookup;
          mLazySpanLookup.mFullSpanItems = mPendingSavedState.mFullSpanItems;
        }
        label345:
        if ((!mInPreLayout) && (mPendingScrollPosition != -1)) {
          break label594;
        }
        i = 0;
        label363:
        if (i == 0)
        {
          if (!mLastLayoutFromEnd) {
            break label1113;
          }
          m = paramState.getItemCount();
          i = getChildCount() - 1;
          label389:
          if (i < 0) {
            break label1107;
          }
          k = getPosition(getChildAt(i));
          if ((k < 0) || (k >= m)) {
            break label1098;
          }
          i = k;
        }
      }
    }
    label594:
    label685:
    label751:
    label781:
    label817:
    boolean bool;
    label955:
    label983:
    label1005:
    label1098:
    label1107:
    label1113:
    int n;
    int i1;
    for (;;)
    {
      mPosition = i;
      mOffset = Integer.MIN_VALUE;
      if ((mPendingSavedState == null) && ((mLayoutFromEnd != mLastLayoutFromEnd) || (isLayoutRTL() != mLastLayoutRTL)))
      {
        mLazySpanLookup.clear();
        mInvalidateOffsets = true;
      }
      if ((getChildCount() <= 0) || ((mPendingSavedState != null) && (mPendingSavedState.mSpanOffsetsSize > 0))) {
        break label1335;
      }
      if (!mInvalidateOffsets) {
        break label1177;
      }
      i = 0;
      while (i < mSpanCount)
      {
        mSpans[i].clear();
        if (mOffset != Integer.MIN_VALUE) {
          mSpans[i].setLine(mOffset);
        }
        i += 1;
      }
      mLayoutFromEnd = mShouldReverseLayout;
      break;
      resolveShouldLayoutReverse();
      mLayoutFromEnd = mShouldReverseLayout;
      break label345;
      if ((mPendingScrollPosition < 0) || (mPendingScrollPosition >= paramState.getItemCount()))
      {
        mPendingScrollPosition = -1;
        mPendingScrollPositionOffset = Integer.MIN_VALUE;
        i = 0;
        break label363;
      }
      if ((mPendingSavedState == null) || (mPendingSavedState.mAnchorPosition == -1) || (mPendingSavedState.mSpanOffsetsSize <= 0))
      {
        localObject = findViewByPosition(mPendingScrollPosition);
        if (localObject != null)
        {
          if (mShouldReverseLayout)
          {
            i = getLastChildPosition();
            mPosition = i;
            if (mPendingScrollPositionOffset == Integer.MIN_VALUE) {
              break label781;
            }
            if (!mLayoutFromEnd) {
              break label751;
            }
          }
          for (mOffset = (mPrimaryOrientation.getEndAfterPadding() - mPendingScrollPositionOffset - mPrimaryOrientation.getDecoratedEnd((View)localObject));; mOffset = (mPrimaryOrientation.getStartAfterPadding() + mPendingScrollPositionOffset - mPrimaryOrientation.getDecoratedStart((View)localObject)))
          {
            i = 1;
            break;
            i = getFirstChildPosition();
            break label685;
          }
          if (mPrimaryOrientation.getDecoratedMeasurement((View)localObject) > mPrimaryOrientation.getTotalSpace()) {
            if (mLayoutFromEnd)
            {
              i = mPrimaryOrientation.getEndAfterPadding();
              mOffset = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = mPrimaryOrientation.getStartAfterPadding();
        break label817;
        i = mPrimaryOrientation.getDecoratedStart((View)localObject) - mPrimaryOrientation.getStartAfterPadding();
        if (i < 0)
        {
          mOffset = (-i);
        }
        else
        {
          i = mPrimaryOrientation.getEndAfterPadding() - mPrimaryOrientation.getDecoratedEnd((View)localObject);
          if (i < 0)
          {
            mOffset = i;
          }
          else
          {
            mOffset = Integer.MIN_VALUE;
            continue;
            mPosition = mPendingScrollPosition;
            if (mPendingScrollPositionOffset == Integer.MIN_VALUE) {
              if (calculateScrollDirectionForPosition(mPosition) == 1)
              {
                bool = true;
                mLayoutFromEnd = bool;
                if (!mLayoutFromEnd) {
                  break label1005;
                }
                i = this$0.mPrimaryOrientation.getEndAfterPadding();
                mOffset = i;
              }
            }
            for (;;)
            {
              mInvalidateOffsets = true;
              break;
              bool = false;
              break label955;
              i = this$0.mPrimaryOrientation.getStartAfterPadding();
              break label983;
              i = mPendingScrollPositionOffset;
              if (mLayoutFromEnd) {
                mOffset = (this$0.mPrimaryOrientation.getEndAfterPadding() - i);
              } else {
                mOffset = (i + this$0.mPrimaryOrientation.getStartAfterPadding());
              }
            }
            mOffset = Integer.MIN_VALUE;
            mPosition = mPendingScrollPosition;
          }
        }
      }
      i -= 1;
      break label389;
      i = 0;
      continue;
      n = paramState.getItemCount();
      i1 = getChildCount();
      k = 0;
      for (;;)
      {
        if (k >= i1) {
          break label1171;
        }
        m = getPosition(getChildAt(k));
        if (m >= 0)
        {
          i = m;
          if (m < n) {
            break;
          }
        }
        k += 1;
      }
      label1171:
      i = 0;
    }
    label1177:
    int k = 0;
    if (k < mSpanCount)
    {
      localObject = mSpans[k];
      bool = mShouldReverseLayout;
      n = mOffset;
      if (bool)
      {
        i = ((Span)localObject).getEndLine(Integer.MIN_VALUE);
        label1225:
        ((Span)localObject).clear();
        if ((i != Integer.MIN_VALUE) && ((!bool) || (i >= this$0.mPrimaryOrientation.getEndAfterPadding())) && ((bool) || (i <= this$0.mPrimaryOrientation.getStartAfterPadding()))) {
          break label1300;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        i = ((Span)localObject).getStartLine(Integer.MIN_VALUE);
        break label1225;
        label1300:
        m = i;
        if (n != Integer.MIN_VALUE) {
          m = i + n;
        }
        mCachedEnd = m;
        mCachedStart = m;
      }
    }
    label1335:
    detachAndScrapAttachedViews(paramRecycler);
    mLayoutState.mRecycle = false;
    mLaidOutInvalidFullSpan = false;
    updateMeasureSpecs(mSecondaryOrientation.getTotalSpace());
    updateLayoutState(mPosition, paramState);
    label1434:
    float f1;
    label1458:
    float f2;
    if (mLayoutFromEnd)
    {
      setLayoutStateDirection(-1);
      fill(paramRecycler, mLayoutState, paramState);
      setLayoutStateDirection(1);
      mLayoutState.mCurrentPosition = (mPosition + mLayoutState.mItemDirection);
      fill(paramRecycler, mLayoutState, paramState);
      if (mSecondaryOrientation.getMode() == 1073741824) {
        break label1820;
      }
      f1 = 0.0F;
      m = getChildCount();
      i = 0;
      if (i >= m) {
        break label1589;
      }
      localObject = getChildAt(i);
      f2 = mSecondaryOrientation.getDecoratedMeasurement((View)localObject);
      if (f2 < f1) {
        break label2004;
      }
      if (!getLayoutParamsmFullSpan) {
        break label2007;
      }
      f2 = 1.0F * f2 / mSpanCount;
    }
    label1589:
    label1758:
    label1820:
    label1848:
    label1998:
    label2004:
    label2007:
    for (;;)
    {
      f1 = Math.max(f1, f2);
      for (;;)
      {
        i += 1;
        break label1458;
        setLayoutStateDirection(1);
        fill(paramRecycler, mLayoutState, paramState);
        setLayoutStateDirection(-1);
        mLayoutState.mCurrentPosition = (mPosition + mLayoutState.mItemDirection);
        fill(paramRecycler, mLayoutState, paramState);
        break label1434;
        n = mSizePerSpan;
        k = Math.round(mSpanCount * f1);
        i = k;
        if (mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
          i = Math.min(k, mSecondaryOrientation.getTotalSpace());
        }
        updateMeasureSpecs(i);
        if (mSizePerSpan != n)
        {
          i = 0;
          if (i < m)
          {
            localObject = getChildAt(i);
            LayoutParams localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
            if (!mFullSpan)
            {
              if ((!isLayoutRTL()) || (mOrientation != 1)) {
                break label1758;
              }
              ((View)localObject).offsetLeftAndRight(-(mSpanCount - 1 - mSpan.mIndex) * mSizePerSpan - -(mSpanCount - 1 - mSpan.mIndex) * n);
            }
            for (;;)
            {
              i += 1;
              break;
              k = mSpan.mIndex * mSizePerSpan;
              i1 = mSpan.mIndex * n;
              if (mOrientation == 1) {
                ((View)localObject).offsetLeftAndRight(k - i1);
              } else {
                ((View)localObject).offsetTopAndBottom(k - i1);
              }
            }
          }
        }
        if (getChildCount() > 0)
        {
          if (mShouldReverseLayout)
          {
            fixEndGap(paramRecycler, paramState, true);
            fixStartGap(paramRecycler, paramState, false);
          }
        }
        else
        {
          m = 0;
          k = 0;
          i = m;
          if (j != 0)
          {
            i = m;
            if (!mInPreLayout) {
              if ((mGapStrategy == 0) || (getChildCount() <= 0) || ((!mLaidOutInvalidFullSpan) && (hasGapsToFix() == null))) {
                break label1998;
              }
            }
          }
        }
        for (j = 1;; j = 0)
        {
          i = k;
          if (j != 0)
          {
            removeCallbacks(mCheckForGapsRunnable);
            i = k;
            if (checkForGaps()) {
              i = 1;
            }
          }
          mPendingScrollPosition = -1;
          mPendingScrollPositionOffset = Integer.MIN_VALUE;
          mLastLayoutFromEnd = mLayoutFromEnd;
          mLastLayoutRTL = isLayoutRTL();
          mPendingSavedState = null;
          if (i == 0) {
            break label61;
          }
          j = 0;
          break;
          fixStartGap(paramRecycler, paramState, true);
          fixEndGap(paramRecycler, paramState, false);
          break label1848;
        }
      }
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
    Object localObject;
    if (mPendingSavedState != null) {
      localObject = new SavedState(mPendingSavedState);
    }
    SavedState localSavedState;
    int i;
    label130:
    label150:
    label157:
    int j;
    label185:
    do
    {
      return (Parcelable)localObject;
      localSavedState = new SavedState();
      mReverseLayout = mReverseLayout;
      mAnchorLayoutFromEnd = mLastLayoutFromEnd;
      mLastLayoutRTL = mLastLayoutRTL;
      if ((mLazySpanLookup == null) || (mLazySpanLookup.mData == null)) {
        break;
      }
      mSpanLookup = mLazySpanLookup.mData;
      mSpanLookupSize = mSpanLookup.length;
      mFullSpanItems = mLazySpanLookup.mFullSpanItems;
      if (getChildCount() <= 0) {
        break label318;
      }
      if (!mLastLayoutFromEnd) {
        break label258;
      }
      i = getLastChildPosition();
      mAnchorPosition = i;
      if (!mShouldReverseLayout) {
        break label266;
      }
      localObject = findFirstVisibleItemClosestToEnd$2930a1b7(true);
      if (localObject != null) {
        break label276;
      }
      i = -1;
      mVisibleAnchorPosition = i;
      mSpanOffsetsSize = mSpanCount;
      mSpanOffsets = new int[mSpanCount];
      j = 0;
      localObject = localSavedState;
    } while (j >= mSpanCount);
    int k;
    if (mLastLayoutFromEnd)
    {
      k = mSpans[j].getEndLine(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - mPrimaryOrientation.getEndAfterPadding();
      }
    }
    for (;;)
    {
      mSpanOffsets[j] = i;
      j += 1;
      break label185;
      mSpanLookupSize = 0;
      break;
      label258:
      i = getFirstChildPosition();
      break label130;
      label266:
      localObject = findFirstVisibleItemClosestToStart$2930a1b7(true);
      break label150;
      label276:
      i = getPosition((View)localObject);
      break label157;
      k = mSpans[j].getStartLine(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - mPrimaryOrientation.getStartAfterPadding();
      }
    }
    label318:
    mAnchorPosition = -1;
    mVisibleAnchorPosition = -1;
    mSpanOffsetsSize = 0;
    return localSavedState;
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      checkForGaps();
    }
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    if ((mPendingSavedState != null) && (mPendingSavedState.mAnchorPosition != paramInt))
    {
      SavedState localSavedState = mPendingSavedState;
      mSpanOffsets = null;
      mSpanOffsetsSize = 0;
      mAnchorPosition = -1;
      mVisibleAnchorPosition = -1;
    }
    mPendingScrollPosition = paramInt;
    mPendingScrollPositionOffset = Integer.MIN_VALUE;
    requestLayout();
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public final void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int i;
    if (mOrientation == 1)
    {
      i = chooseSize(paramInt2, paramRect.height() + k, ViewCompat.getMinimumHeight(mRecyclerView));
      paramInt2 = chooseSize(paramInt1, mSizePerSpan * mSpanCount + j, ViewCompat.getMinimumWidth(mRecyclerView));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, paramRect.width() + j, ViewCompat.getMinimumWidth(mRecyclerView));
      paramInt1 = chooseSize(paramInt2, mSizePerSpan * mSpanCount + k, ViewCompat.getMinimumHeight(mRecyclerView));
      paramInt2 = i;
    }
  }
  
  public final void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext())
    {
      public final PointF computeScrollVectorForPosition(int paramAnonymousInt)
      {
        paramAnonymousInt = StaggeredGridLayoutManager.this.calculateScrollDirectionForPosition(paramAnonymousInt);
        if (paramAnonymousInt == 0) {
          return null;
        }
        if (mOrientation == 0) {
          return new PointF(paramAnonymousInt, 0.0F);
        }
        return new PointF(0.0F, paramAnonymousInt);
      }
    };
    mTargetPosition = paramInt;
    startSmoothScroll(paramRecyclerView);
  }
  
  public final boolean supportsPredictiveItemAnimations()
  {
    return mPendingSavedState == null;
  }
  
  private final class AnchorInfo
  {
    boolean mInvalidateOffsets;
    boolean mLayoutFromEnd;
    int mOffset;
    int mPosition;
    
    private AnchorInfo() {}
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    boolean mFullSpan;
    StaggeredGridLayoutManager.Span mSpan;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public final int getSpanIndex()
    {
      if (mSpan == null) {
        return -1;
      }
      return mSpan.mIndex;
    }
  }
  
  static final class LazySpanLookup
  {
    int[] mData;
    List<FullSpanItem> mFullSpanItems;
    
    public final void addFullSpanItem(FullSpanItem paramFullSpanItem)
    {
      if (mFullSpanItems == null) {
        mFullSpanItems = new ArrayList();
      }
      int j = mFullSpanItems.size();
      int i = 0;
      while (i < j)
      {
        FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        if (mPosition == mPosition) {
          mFullSpanItems.remove(i);
        }
        if (mPosition >= mPosition)
        {
          mFullSpanItems.add(i, paramFullSpanItem);
          return;
        }
        i += 1;
      }
      mFullSpanItems.add(paramFullSpanItem);
    }
    
    final void clear()
    {
      if (mData != null) {
        Arrays.fill(mData, -1);
      }
      mFullSpanItems = null;
    }
    
    final void ensureSize(int paramInt)
    {
      if (mData == null)
      {
        mData = new int[Math.max(paramInt, 10) + 1];
        Arrays.fill(mData, -1);
      }
      while (paramInt < mData.length) {
        return;
      }
      int[] arrayOfInt = mData;
      int i = mData.length;
      while (i <= paramInt) {
        i *= 2;
      }
      mData = new int[i];
      System.arraycopy(arrayOfInt, 0, mData, 0, arrayOfInt.length);
      Arrays.fill(mData, arrayOfInt.length, mData.length, -1);
    }
    
    final int forceInvalidateAfter(int paramInt)
    {
      if (mFullSpanItems != null)
      {
        int i = mFullSpanItems.size() - 1;
        while (i >= 0)
        {
          if (mFullSpanItems.get(i)).mPosition >= paramInt) {
            mFullSpanItems.remove(i);
          }
          i -= 1;
        }
      }
      return invalidateAfter(paramInt);
    }
    
    public final FullSpanItem getFirstFullSpanItemInRange$7b524a3(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if (mFullSpanItems == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int j = mFullSpanItems.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label112;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        if (mPosition >= paramInt2) {
          return null;
        }
        if (mPosition >= paramInt1)
        {
          localObject = localFullSpanItem;
          if (paramInt3 == 0) {
            break;
          }
          localObject = localFullSpanItem;
          if (mGapDir == paramInt3) {
            break;
          }
          localObject = localFullSpanItem;
          if (mHasUnwantedGapAfter) {
            break;
          }
        }
        i += 1;
      }
      label112:
      return null;
    }
    
    public final FullSpanItem getFullSpanItem(int paramInt)
    {
      Object localObject;
      if (mFullSpanItems == null)
      {
        localObject = null;
        return (FullSpanItem)localObject;
      }
      int i = mFullSpanItems.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label61;
        }
        FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        localObject = localFullSpanItem;
        if (mPosition == paramInt) {
          break;
        }
        i -= 1;
      }
      label61:
      return null;
    }
    
    final int invalidateAfter(int paramInt)
    {
      if (mData == null) {
        return -1;
      }
      if (paramInt >= mData.length) {
        return -1;
      }
      FullSpanItem localFullSpanItem;
      int i;
      if (mFullSpanItems != null)
      {
        localFullSpanItem = getFullSpanItem(paramInt);
        if (localFullSpanItem != null) {
          mFullSpanItems.remove(localFullSpanItem);
        }
        int j = mFullSpanItems.size();
        i = 0;
        if (i >= j) {
          break label178;
        }
        if (mFullSpanItems.get(i)).mPosition < paramInt) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
          mFullSpanItems.remove(i);
        }
        for (i = mPosition;; i = -1)
        {
          if (i != -1) {
            break label162;
          }
          Arrays.fill(mData, paramInt, mData.length, -1);
          return mData.length;
          i += 1;
          break;
        }
        label162:
        Arrays.fill(mData, paramInt, i + 1, -1);
        return i + 1;
        label178:
        i = -1;
      }
    }
    
    final void offsetForAddition(int paramInt1, int paramInt2)
    {
      if ((mData == null) || (paramInt1 >= mData.length)) {}
      for (;;)
      {
        return;
        ensureSize(paramInt1 + paramInt2);
        System.arraycopy(mData, paramInt1, mData, paramInt1 + paramInt2, mData.length - paramInt1 - paramInt2);
        Arrays.fill(mData, paramInt1, paramInt1 + paramInt2, -1);
        if (mFullSpanItems != null)
        {
          int i = mFullSpanItems.size() - 1;
          while (i >= 0)
          {
            FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
            if (mPosition >= paramInt1) {
              mPosition += paramInt2;
            }
            i -= 1;
          }
        }
      }
    }
    
    final void offsetForRemoval(int paramInt1, int paramInt2)
    {
      if ((mData == null) || (paramInt1 >= mData.length)) {}
      do
      {
        return;
        ensureSize(paramInt1 + paramInt2);
        System.arraycopy(mData, paramInt1 + paramInt2, mData, paramInt1, mData.length - paramInt1 - paramInt2);
        Arrays.fill(mData, mData.length - paramInt2, mData.length, -1);
      } while (mFullSpanItems == null);
      int i = mFullSpanItems.size() - 1;
      label87:
      FullSpanItem localFullSpanItem;
      if (i >= 0)
      {
        localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        if (mPosition >= paramInt1)
        {
          if (mPosition >= paramInt1 + paramInt2) {
            break label144;
          }
          mFullSpanItems.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break label87;
        break;
        label144:
        mPosition -= paramInt2;
      }
    }
    
    static class FullSpanItem
      implements Parcelable
    {
      public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
      int mGapDir;
      int[] mGapPerSpan;
      boolean mHasUnwantedGapAfter;
      int mPosition;
      
      public FullSpanItem() {}
      
      public FullSpanItem(Parcel paramParcel)
      {
        mPosition = paramParcel.readInt();
        mGapDir = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          mHasUnwantedGapAfter = bool;
          int i = paramParcel.readInt();
          if (i > 0)
          {
            mGapPerSpan = new int[i];
            paramParcel.readIntArray(mGapPerSpan);
          }
          return;
          bool = false;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      final int getGapForSpan(int paramInt)
      {
        if (mGapPerSpan == null) {
          return 0;
        }
        return mGapPerSpan[paramInt];
      }
      
      public String toString()
      {
        return "FullSpanItem{mPosition=" + mPosition + ", mGapDir=" + mGapDir + ", mHasUnwantedGapAfter=" + mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(mGapPerSpan) + '}';
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(mPosition);
        paramParcel.writeInt(mGapDir);
        if (mHasUnwantedGapAfter) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if ((mGapPerSpan == null) || (mGapPerSpan.length <= 0)) {
            break;
          }
          paramParcel.writeInt(mGapPerSpan.length);
          paramParcel.writeIntArray(mGapPerSpan);
          return;
        }
        paramParcel.writeInt(0);
      }
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      mAnchorPosition = paramParcel.readInt();
      mVisibleAnchorPosition = paramParcel.readInt();
      mSpanOffsetsSize = paramParcel.readInt();
      if (mSpanOffsetsSize > 0)
      {
        mSpanOffsets = new int[mSpanOffsetsSize];
        paramParcel.readIntArray(mSpanOffsets);
      }
      mSpanLookupSize = paramParcel.readInt();
      if (mSpanLookupSize > 0)
      {
        mSpanLookup = new int[mSpanLookupSize];
        paramParcel.readIntArray(mSpanLookup);
      }
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        mReverseLayout = bool1;
        if (paramParcel.readInt() != 1) {
          break label152;
        }
        bool1 = true;
        label113:
        mAnchorLayoutFromEnd = bool1;
        if (paramParcel.readInt() != 1) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        mLastLayoutRTL = bool1;
        mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label113;
      }
    }
    
    public SavedState(SavedState paramSavedState)
    {
      mSpanOffsetsSize = mSpanOffsetsSize;
      mAnchorPosition = mAnchorPosition;
      mVisibleAnchorPosition = mVisibleAnchorPosition;
      mSpanOffsets = mSpanOffsets;
      mSpanLookupSize = mSpanLookupSize;
      mSpanLookup = mSpanLookup;
      mReverseLayout = mReverseLayout;
      mAnchorLayoutFromEnd = mAnchorLayoutFromEnd;
      mLastLayoutRTL = mLastLayoutRTL;
      mFullSpanItems = mFullSpanItems;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeInt(mAnchorPosition);
      paramParcel.writeInt(mVisibleAnchorPosition);
      paramParcel.writeInt(mSpanOffsetsSize);
      if (mSpanOffsetsSize > 0) {
        paramParcel.writeIntArray(mSpanOffsets);
      }
      paramParcel.writeInt(mSpanLookupSize);
      if (mSpanLookupSize > 0) {
        paramParcel.writeIntArray(mSpanLookup);
      }
      if (mReverseLayout)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!mAnchorLayoutFromEnd) {
          break label120;
        }
        paramInt = 1;
        label87:
        paramParcel.writeInt(paramInt);
        if (!mLastLayoutRTL) {
          break label125;
        }
      }
      label120:
      label125:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeList(mFullSpanItems);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label87;
      }
    }
  }
  
  public final class Span
  {
    int mCachedEnd = Integer.MIN_VALUE;
    int mCachedStart = Integer.MIN_VALUE;
    int mDeletedSize = 0;
    final int mIndex;
    public ArrayList<View> mViews = new ArrayList();
    
    private Span(int paramInt)
    {
      mIndex = paramInt;
    }
    
    private void calculateCachedEnd()
    {
      Object localObject = (View)mViews.get(mViews.size() - 1);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      mCachedEnd = mPrimaryOrientation.getDecoratedEnd((View)localObject);
      if (mFullSpan)
      {
        localObject = mLazySpanLookup.getFullSpanItem(mViewHolder.getLayoutPosition());
        if ((localObject != null) && (mGapDir == 1)) {
          mCachedEnd += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(mIndex);
        }
      }
    }
    
    private void calculateCachedStart()
    {
      Object localObject = (View)mViews.get(0);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
      mCachedStart = mPrimaryOrientation.getDecoratedStart((View)localObject);
      if (mFullSpan)
      {
        localObject = mLazySpanLookup.getFullSpanItem(mViewHolder.getLayoutPosition());
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
        mDeletedSize += mPrimaryOrientation.getDecoratedMeasurement(paramView);
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
      int m = mPrimaryOrientation.getStartAfterPadding();
      int n = mPrimaryOrientation.getEndAfterPadding();
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
          j = mPrimaryOrientation.getDecoratedStart(localView);
          int i1 = mPrimaryOrientation.getDecoratedEnd(localView);
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
              if (k != StaggeredGridLayoutManager.access$600(StaggeredGridLayoutManager.this)) {
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
              if (StaggeredGridLayoutManager.access$600(StaggeredGridLayoutManager.this)) {
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
        mDeletedSize -= mPrimaryOrientation.getDecoratedMeasurement(localView);
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
        mDeletedSize -= mPrimaryOrientation.getDecoratedMeasurement(localView);
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
        mDeletedSize += mPrimaryOrientation.getDecoratedMeasurement(paramView);
      }
    }
    
    final void setLine(int paramInt)
    {
      mCachedStart = paramInt;
      mCachedEnd = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */