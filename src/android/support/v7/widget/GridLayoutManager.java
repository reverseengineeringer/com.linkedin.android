package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  int[] mCachedBorders;
  final Rect mDecorInsets = new Rect();
  boolean mPendingSpanCountChange = false;
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSpanCount = -1;
  SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getPropertiesspanCount);
  }
  
  private void assignSpans$1d107c69(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, boolean paramBoolean)
  {
    int i;
    int k;
    int j;
    int m;
    label43:
    LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 0;
      k = paramInt;
      j = 1;
      paramInt = i;
      if ((mOrientation != 1) || (!isLayoutRTL())) {
        break label149;
      }
      i = mSpanCount - 1;
      m = -1;
      if (paramInt == k) {
        return;
      }
      View localView = mSet[paramInt];
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      LayoutParams.access$102(localLayoutParams, getSpanSize(paramRecycler, paramState, getPosition(localView)));
      if ((m != -1) || (mSpanSize <= 1)) {
        break label158;
      }
      LayoutParams.access$002(localLayoutParams, i - (mSpanSize - 1));
    }
    for (;;)
    {
      i += mSpanSize * m;
      paramInt += j;
      break label43;
      paramInt -= 1;
      k = -1;
      j = -1;
      break;
      label149:
      i = 0;
      m = 1;
      break label43;
      label158:
      LayoutParams.access$002(localLayoutParams, i);
    }
  }
  
  private void calculateItemBorders(int paramInt)
  {
    int k = 0;
    int[] arrayOfInt2 = mCachedBorders;
    int n = mSpanCount;
    int[] arrayOfInt1;
    if ((arrayOfInt2 != null) && (arrayOfInt2.length == n + 1))
    {
      arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2[(arrayOfInt2.length - 1)] == paramInt) {}
    }
    else
    {
      arrayOfInt1 = new int[n + 1];
    }
    arrayOfInt1[0] = 0;
    int m = paramInt / n;
    int i1 = paramInt % n;
    int i = 1;
    int j = 0;
    paramInt = k;
    if (i <= n)
    {
      paramInt += i1;
      if ((paramInt <= 0) || (n - paramInt >= i1)) {
        break label137;
      }
      k = m + 1;
      paramInt -= n;
    }
    for (;;)
    {
      j += k;
      arrayOfInt1[i] = j;
      i += 1;
      break;
      mCachedBorders = arrayOfInt1;
      return;
      label137:
      k = m;
    }
  }
  
  private void ensureViewSet()
  {
    if ((mSet == null) || (mSet.length != mSpanCount)) {
      mSet = new View[mSpanCount];
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!mInPreLayout) {
      return SpanSizeLookup.getSpanGroupIndex(paramInt, mSpanCount);
    }
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + paramInt);
      return 0;
    }
    return SpanSizeLookup.getSpanGroupIndex(i, mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!mInPreLayout) {
      i = mSpanSizeLookup.getCachedSpanIndex(paramInt, mSpanCount);
    }
    int j;
    do
    {
      return i;
      j = mPreLayoutSpanIndexCache.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 0;
    }
    return mSpanSizeLookup.getCachedSpanIndex(i, mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    int i;
    if (!mInPreLayout) {
      i = 1;
    }
    int j;
    do
    {
      return i;
      j = mPreLayoutSpanSizeCache.get(paramInt, -1);
      i = j;
    } while (j != -1);
    if (paramRecycler.convertPreLayoutPositionToPostLayout(paramInt) == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 1;
    }
    return 1;
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    calculateItemDecorationsForChild(paramView, mDecorInsets);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i;
    if (!paramBoolean1)
    {
      i = paramInt1;
      if (mOrientation != 1) {}
    }
    else
    {
      i = updateSpecWithExtra(paramInt1, leftMargin + mDecorInsets.left, rightMargin + mDecorInsets.right);
    }
    if (!paramBoolean1)
    {
      paramInt1 = paramInt2;
      if (mOrientation != 0) {}
    }
    else
    {
      paramInt1 = updateSpecWithExtra(paramInt2, topMargin + mDecorInsets.top, bottomMargin + mDecorInsets.bottom);
    }
    if (paramBoolean2)
    {
      paramBoolean1 = bool;
      if (mMeasurementCacheEnabled)
      {
        paramBoolean1 = bool;
        if (RecyclerView.LayoutManager.isMeasurementUpToDate(paramView.getMeasuredWidth(), i, width))
        {
          if (RecyclerView.LayoutManager.isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt1, height)) {
            break label184;
          }
          paramBoolean1 = bool;
        }
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        paramView.measure(i, paramInt1);
      }
      return;
      label184:
      paramBoolean1 = false;
      continue;
      paramBoolean1 = shouldMeasureChild(paramView, i, paramInt1, localLayoutParams);
    }
  }
  
  private void setSpanCount(int paramInt)
  {
    if (paramInt == mSpanCount) {
      return;
    }
    mPendingSpanCountChange = true;
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    }
    mSpanCount = paramInt;
    mSpanSizeLookup.mSpanIndexCache.clear();
  }
  
  private void updateMeasurements()
  {
    if (mOrientation == 1) {}
    for (int i = mWidth - getPaddingRight() - getPaddingLeft();; i = mHeight - getPaddingBottom() - getPaddingTop())
    {
      calculateItemBorders(i);
      return;
    }
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
  
  public final boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  final View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    ensureLayoutState();
    Object localObject2 = null;
    Object localObject1 = null;
    int j = mOrientationHelper.getStartAfterPadding();
    int k = mOrientationHelper.getEndAfterPadding();
    int i;
    View localView;
    Object localObject3;
    Object localObject4;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (paramInt1 == paramInt2) {
        break label220;
      }
      localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (m < paramInt3)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (getSpanIndex(paramRecycler, paramState, m) == 0)
          {
            if (!getLayoutParamsmViewHolder.isRemoved()) {
              break label164;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject4 = localObject1;
              localObject3 = localView;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramInt1 += i;
      localObject2 = localObject3;
      localObject1 = localObject4;
      break;
      i = -1;
      break;
      label164:
      if (mOrientationHelper.getDecoratedStart(localView) < k)
      {
        localObject3 = localView;
        if (mOrientationHelper.getDecoratedEnd(localView) >= j) {
          break label229;
        }
      }
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject2;
        localObject4 = localView;
      }
    }
    label220:
    if (localObject1 != null)
    {
      localObject3 = localObject1;
      label229:
      return (View)localObject3;
    }
    return (View)localObject2;
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
    if (paramState.getItemCount() <= 0) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  public final int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mOrientation == 0) {
      return mSpanCount;
    }
    if (paramState.getItemCount() <= 0) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  final void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i3 = mOrientationHelper.getModeInOther();
    label38:
    boolean bool1;
    label58:
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label212;
      }
      k = mCachedBorders[mSpanCount];
      if (j != 0) {
        updateMeasurements();
      }
      if (mItemDirection != 1) {
        break label218;
      }
      bool1 = true;
      m = 0;
      i = mSpanCount;
      n = m;
      if (!bool1)
      {
        i = getSpanIndex(paramRecycler, paramState, mCurrentPosition) + getSpanSize(paramRecycler, paramState, mCurrentPosition);
        n = m;
      }
    }
    for (;;)
    {
      if ((n >= mSpanCount) || (!paramLayoutState.hasMore(paramState)) || (i <= 0)) {
        break label266;
      }
      m = mCurrentPosition;
      i1 = getSpanSize(paramRecycler, paramState, m);
      if (i1 > mSpanCount)
      {
        throw new IllegalArgumentException("Item at position " + m + " requires " + i1 + " spans but GridLayoutManager has only " + mSpanCount + " spans.");
        j = 0;
        break;
        label212:
        k = 0;
        break label38;
        label218:
        bool1 = false;
        break label58;
      }
      i -= i1;
      if (i < 0) {
        break label266;
      }
      View localView = paramLayoutState.next(paramRecycler);
      if (localView == null) {
        break label266;
      }
      mSet[n] = localView;
      n += 1;
    }
    label266:
    if (n == 0)
    {
      mFinished = true;
      return;
    }
    int i = 0;
    float f1 = 0.0F;
    assignSpans$1d107c69(paramRecycler, paramState, n, bool1);
    int m = 0;
    label331:
    int i2;
    if (m < n)
    {
      paramRecycler = mSet[m];
      if (mScrapList == null) {
        if (bool1)
        {
          super.addViewInt(paramRecycler, -1, false);
          paramState = (LayoutParams)paramRecycler.getLayoutParams();
          i2 = mCachedBorders[(mSpanIndex + mSpanSize)];
          int i4 = mCachedBorders[mSpanIndex];
          if (mOrientation != 0) {
            break label583;
          }
          i1 = height;
          label379:
          i2 = getChildMeasureSpec(i2 - i4, i3, 0, i1, false);
          i4 = mOrientationHelper.getTotalSpace();
          int i5 = mOrientationHelper.getMode();
          if (mOrientation != 1) {
            break label592;
          }
          i1 = height;
          label427:
          i1 = getChildMeasureSpec(i4, i5, 0, i1, true);
          if (mOrientation != 1) {
            break label607;
          }
          if (height != -1) {
            break label601;
          }
        }
      }
      label583:
      label592:
      label601:
      for (boolean bool2 = true;; bool2 = false)
      {
        measureChildWithDecorationsAndMargin(paramRecycler, i2, i1, bool2, false);
        i2 = mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        i1 = i;
        if (i2 > i) {
          i1 = i2;
        }
        float f3 = 1.0F * mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) / mSpanSize;
        float f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
        m += 1;
        i = i1;
        f1 = f2;
        break;
        super.addViewInt(paramRecycler, 0, false);
        break label331;
        if (bool1)
        {
          super.addViewInt(paramRecycler, -1, true);
          break label331;
        }
        super.addViewInt(paramRecycler, 0, true);
        break label331;
        i1 = width;
        break label379;
        i1 = width;
        break label427;
      }
      label607:
      if (width == -1) {}
      for (bool2 = true;; bool2 = false)
      {
        measureChildWithDecorationsAndMargin(paramRecycler, i1, i2, bool2, false);
        break;
      }
    }
    m = i;
    if (j != 0)
    {
      calculateItemBorders(Math.max(Math.round(mSpanCount * f1), k));
      i = 0;
      j = 0;
      m = i;
      if (j < n)
      {
        paramRecycler = mSet[j];
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        m = mCachedBorders[(mSpanIndex + mSpanSize)];
        i1 = mCachedBorders[mSpanIndex];
        if (mOrientation == 0)
        {
          k = height;
          label741:
          m = getChildMeasureSpec(m - i1, 1073741824, 0, k, false);
          i1 = mOrientationHelper.getTotalSpace();
          i2 = mOrientationHelper.getMode();
          if (mOrientation != 1) {
            break label869;
          }
          k = height;
          label790:
          k = getChildMeasureSpec(i1, i2, 0, k, true);
          if (mOrientation != 1) {
            break label878;
          }
          measureChildWithDecorationsAndMargin(paramRecycler, m, k, false, true);
        }
        for (;;)
        {
          m = mOrientationHelper.getDecoratedMeasurement(paramRecycler);
          k = i;
          if (m > i) {
            k = m;
          }
          j += 1;
          i = k;
          break;
          k = width;
          break label741;
          label869:
          k = width;
          break label790;
          label878:
          measureChildWithDecorationsAndMargin(paramRecycler, k, m, false, true);
        }
      }
    }
    int k = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    i = 0;
    if (i < n)
    {
      paramRecycler = mSet[i];
      if (mOrientationHelper.getDecoratedMeasurement(paramRecycler) != m)
      {
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        i1 = mCachedBorders[(mSpanIndex + mSpanSize)];
        i2 = mCachedBorders[mSpanIndex];
        if (mOrientation != 0) {
          break label1026;
        }
        j = height;
        label981:
        j = getChildMeasureSpec(i1 - i2, 1073741824, 0, j, false);
        if (mOrientation != 1) {
          break label1035;
        }
        measureChildWithDecorationsAndMargin(paramRecycler, j, k, true, true);
      }
      for (;;)
      {
        i += 1;
        break;
        label1026:
        j = width;
        break label981;
        label1035:
        measureChildWithDecorationsAndMargin(paramRecycler, k, j, true, true);
      }
    }
    mConsumed = m;
    int j = 0;
    k = 0;
    int i1 = 0;
    i = 0;
    if (mOrientation == 1) {
      if (mLayoutDirection == -1)
      {
        i = mOffset;
        m = i - m;
        i1 = 0;
        i2 = k;
        i3 = j;
        k = i1;
        i1 = i;
        label1116:
        if (k >= n) {
          break label1419;
        }
        paramRecycler = mSet[k];
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        if (mOrientation != 1) {
          break label1379;
        }
        if (!isLayoutRTL()) {
          break label1347;
        }
        j = getPaddingLeft() + mCachedBorders[(mSpanIndex + mSpanSize)];
        i = j - mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      }
    }
    for (;;)
    {
      layoutDecorated(paramRecycler, i + leftMargin, m + topMargin, j - rightMargin, i1 - bottomMargin);
      if ((mViewHolder.isRemoved()) || (mViewHolder.isUpdated())) {
        mIgnoreConsumed = true;
      }
      mFocusable |= paramRecycler.isFocusable();
      k += 1;
      i3 = i;
      i2 = j;
      break label1116;
      i1 = mOffset;
      i = i1 + m;
      m = i1;
      break;
      if (mLayoutDirection == -1)
      {
        k = mOffset;
        j = k - m;
        m = i1;
        break;
      }
      j = mOffset;
      k = j + m;
      m = i1;
      break;
      label1347:
      i = getPaddingLeft() + mCachedBorders[mSpanIndex];
      j = i + mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      continue;
      label1379:
      m = getPaddingTop() + mCachedBorders[mSpanIndex];
      i1 = m + mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      i = i3;
      j = i2;
    }
    label1419:
    Arrays.fill(mSet, null);
  }
  
  final void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    int i = 1;
    super.onAnchorReady(paramRecycler, paramState, paramAnchorInfo, paramInt);
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!mInPreLayout))
    {
      if (paramInt == 1) {}
      for (;;)
      {
        paramInt = getSpanIndex(paramRecycler, paramState, mPosition);
        if (i == 0) {
          break;
        }
        while ((paramInt > 0) && (mPosition > 0))
        {
          mPosition -= 1;
          paramInt = getSpanIndex(paramRecycler, paramState, mPosition);
        }
        i = 0;
      }
      int k = paramState.getItemCount();
      i = mPosition;
      while (i < k - 1)
      {
        int j = getSpanIndex(paramRecycler, paramState, i + 1);
        if (j <= paramInt) {
          break;
        }
        i += 1;
        paramInt = j;
      }
      mPosition = i;
    }
    ensureViewSet();
  }
  
  public final View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    View localView = findContainingItemView(paramView);
    if (localView == null) {
      paramState = null;
    }
    LayoutParams localLayoutParams;
    int i4;
    int i5;
    int i8;
    label85:
    int i;
    int j;
    label102:
    int k;
    label120:
    int n;
    int i1;
    int m;
    label131:
    int i6;
    int i7;
    do
    {
      return paramState;
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i4 = mSpanIndex;
      i5 = mSpanIndex + mSpanSize;
      if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
        return null;
      }
      if (convertFocusDirectionToLayoutDirection(paramInt) != 1) {
        break label287;
      }
      i8 = 1;
      if (i8 == mShouldReverseLayout) {
        break label293;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label298;
      }
      paramInt = getChildCount() - 1;
      i = -1;
      j = -1;
      if ((mOrientation != 1) || (!isLayoutRTL())) {
        break label312;
      }
      k = 1;
      paramView = null;
      n = -1;
      i1 = 0;
      m = paramInt;
      if (m == j) {
        return paramView;
      }
      paramRecycler = getChildAt(m);
      if (paramRecycler == localView) {
        return paramView;
      }
      paramState = paramView;
      i3 = i1;
      i2 = n;
      if (!paramRecycler.isFocusable()) {
        break label266;
      }
      localLayoutParams = (LayoutParams)paramRecycler.getLayoutParams();
      i6 = mSpanIndex;
      i7 = mSpanIndex + mSpanSize;
      if (i6 != i4) {
        break;
      }
      paramState = paramRecycler;
    } while (i7 == i5);
    int i3 = 0;
    if (paramView == null) {
      paramInt = 1;
    }
    label266:
    label287:
    label293:
    label298:
    label312:
    label349:
    do
    {
      for (;;)
      {
        paramState = paramView;
        i3 = i1;
        i2 = n;
        if (paramInt != 0)
        {
          i2 = mSpanIndex;
          i3 = Math.min(i7, i5) - Math.max(i6, i4);
          paramState = paramRecycler;
        }
        m += i;
        paramView = paramState;
        i1 = i3;
        n = i2;
        break label131;
        i8 = 0;
        break;
        paramInt = 0;
        break label85;
        paramInt = 0;
        i = 1;
        j = getChildCount();
        break label102;
        k = 0;
        break label120;
        paramInt = Math.max(i6, i4);
        i2 = Math.min(i7, i5) - paramInt;
        if (i2 <= i1) {
          break label349;
        }
        paramInt = 1;
      }
      paramInt = i3;
    } while (i2 != i1);
    if (i6 > n) {}
    for (int i2 = 1;; i2 = 0)
    {
      paramInt = i3;
      if (k != i2) {
        break;
      }
      paramInt = 1;
      break;
    }
    return paramView;
  }
  
  public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, mViewHolder.getLayoutPosition());
    if (mOrientation == 0)
    {
      j = mSpanIndex;
      k = mSpanSize;
      bool1 = bool2;
      if (mSpanCount > 1)
      {
        bool1 = bool2;
        if (mSpanSize == mSpanCount) {
          bool1 = true;
        }
      }
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain$430787b1(j, k, i, 1, bool1));
      return;
    }
    int j = mSpanIndex;
    int k = mSpanSize;
    boolean bool1 = bool3;
    if (mSpanCount > 1)
    {
      bool1 = bool3;
      if (mSpanSize == mSpanCount) {
        bool1 = true;
      }
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain$430787b1(i, 1, j, k, bool1));
  }
  
  public final void onItemsAdded$5927c743(int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.mSpanIndexCache.clear();
  }
  
  public final void onItemsChanged$57043c5d()
  {
    mSpanSizeLookup.mSpanIndexCache.clear();
  }
  
  public final void onItemsMoved$342e6be0(int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.mSpanIndexCache.clear();
  }
  
  public final void onItemsRemoved$5927c743(int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.mSpanIndexCache.clear();
  }
  
  public final void onItemsUpdated$783f8c5f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    mSpanSizeLookup.mSpanIndexCache.clear();
  }
  
  public final void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (mInPreLayout)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        int k = mViewHolder.getLayoutPosition();
        mPreLayoutSpanSizeCache.put(k, mSpanSize);
        mPreLayoutSpanIndexCache.put(k, mSpanIndex);
        i += 1;
      }
    }
    super.onLayoutChildren(paramRecycler, paramState);
    mPreLayoutSpanSizeCache.clear();
    mPreLayoutSpanIndexCache.clear();
    if (!mInPreLayout) {
      mPendingSpanCountChange = false;
    }
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }
  
  public final void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (mCachedBorders == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int j = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int i;
    if (mOrientation == 1)
    {
      i = chooseSize(paramInt2, paramRect.height() + k, ViewCompat.getMinimumHeight(mRecyclerView));
      paramInt2 = chooseSize(paramInt1, mCachedBorders[(mCachedBorders.length - 1)] + j, ViewCompat.getMinimumWidth(mRecyclerView));
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, paramRect.width() + j, ViewCompat.getMinimumWidth(mRecyclerView));
      paramInt1 = chooseSize(paramInt2, mCachedBorders[(mCachedBorders.length - 1)] + k, ViewCompat.getMinimumHeight(mRecyclerView));
      paramInt2 = i;
    }
  }
  
  public final void setStackFromEnd(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.setStackFromEnd(false);
  }
  
  public final boolean supportsPredictiveItemAnimations()
  {
    return (mPendingSavedState == null) && (!mPendingSpanCountChange);
  }
  
  public static final class DefaultSpanSizeLookup
    extends GridLayoutManager.SpanSizeLookup
  {
    public final int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    int mSpanIndex = -1;
    int mSpanSize = 0;
    
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
  }
  
  public static abstract class SpanSizeLookup
  {
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    
    public static int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int i = 0;
      int j = 0;
      int m = 0;
      if (m < paramInt1)
      {
        int n = i + 1;
        int k;
        if (n == paramInt2)
        {
          i = 0;
          k = j + 1;
        }
        for (;;)
        {
          m += 1;
          j = k;
          break;
          k = j;
          i = n;
          if (n > paramInt2)
          {
            i = 1;
            k = j + 1;
          }
        }
      }
      paramInt1 = j;
      if (i + 1 > paramInt2) {
        paramInt1 = j + 1;
      }
      return paramInt1;
    }
    
    final int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      int i;
      if (!mCacheSpanIndices) {
        i = getSpanIndex(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = mSpanIndexCache.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      mSpanIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      if (1 == paramInt2) {
        paramInt1 = 0;
      }
      int i;
      label162:
      label190:
      do
      {
        return paramInt1;
        int m = 0;
        int n = 0;
        i = m;
        int j = n;
        int k;
        if (mCacheSpanIndices)
        {
          i = m;
          j = n;
          if (mSpanIndexCache.size() > 0)
          {
            j = mSpanIndexCache.size() - 1;
            i = 0;
            while (i <= j)
            {
              k = i + j >>> 1;
              if (mSpanIndexCache.keyAt(k) < paramInt1) {
                i = k + 1;
              } else {
                j = k - 1;
              }
            }
            i -= 1;
            if ((i < 0) || (i >= mSpanIndexCache.size())) {
              break label190;
            }
            k = mSpanIndexCache.keyAt(i);
            i = m;
            j = n;
            if (k >= 0)
            {
              i = mSpanIndexCache.get(k) + 1;
              j = k + 1;
            }
          }
        }
        if (j < paramInt1)
        {
          k = i + 1;
          if (k == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break label162;
            k = -1;
            break;
            i = k;
            if (k > paramInt2) {
              i = 1;
            }
          }
        }
        paramInt1 = i;
      } while (i + 1 <= paramInt2);
      return 0;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */