package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.recyclerview.R.styleable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager
{
  public boolean mAutoMeasure = false;
  public ChildHelper mChildHelper;
  public int mHeight;
  int mHeightMode;
  boolean mIsAttachedToWindow = false;
  boolean mMeasurementCacheEnabled = true;
  public RecyclerView mRecyclerView;
  public boolean mRequestedSimpleAnimations = false;
  RecyclerView.SmoothScroller mSmoothScroller;
  public int mWidth;
  int mWidthMode;
  
  public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i;
    switch (j)
    {
    default: 
      paramInt1 = Math.max(paramInt2, paramInt3);
    case 1073741824: 
      return paramInt1;
    }
    return Math.min(i, Math.max(paramInt2, paramInt3));
  }
  
  private void detachViewAt(int paramInt)
  {
    getChildAt(paramInt);
    detachViewInternal$4d81c81c(paramInt);
  }
  
  public static int getBottomDecorationHeight(View paramView)
  {
    return getLayoutParamsmDecorInsets.bottom;
  }
  
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = Math.max(0, paramInt1 - paramInt3);
    paramInt3 = 0;
    paramInt1 = 0;
    if (paramBoolean) {
      if (paramInt4 >= 0)
      {
        paramInt3 = paramInt4;
        paramInt1 = 1073741824;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
      if (paramInt4 == -1)
      {
        switch (paramInt2)
        {
        default: 
          break;
        case 1073741824: 
        case -2147483648: 
          paramInt3 = i;
          paramInt1 = paramInt2;
          break;
        case 0: 
          paramInt3 = 0;
          paramInt1 = 0;
          break;
        }
      }
      else if (paramInt4 == -2)
      {
        paramInt3 = 0;
        do
        {
          paramInt1 = 0;
          break;
          if (paramInt4 >= 0)
          {
            paramInt3 = paramInt4;
            paramInt1 = 1073741824;
            break;
          }
          if (paramInt4 == -1)
          {
            paramInt3 = i;
            paramInt1 = paramInt2;
            break;
          }
          if (paramInt4 != -2) {
            break;
          }
          if (paramInt2 == Integer.MIN_VALUE) {
            break label149;
          }
          paramInt3 = i;
        } while (paramInt2 != 1073741824);
        label149:
        paramInt1 = Integer.MIN_VALUE;
        paramInt3 = i;
      }
    }
  }
  
  @Deprecated
  public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = Math.max(0, paramInt1 - paramInt2);
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramBoolean) {
      if (paramInt3 >= 0)
      {
        paramInt2 = paramInt3;
        paramInt1 = 1073741824;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1);
      paramInt2 = 0;
      paramInt1 = 0;
      continue;
      if (paramInt3 >= 0)
      {
        paramInt2 = paramInt3;
        paramInt1 = 1073741824;
      }
      else if (paramInt3 == -1)
      {
        paramInt2 = i;
        paramInt1 = 1073741824;
      }
      else if (paramInt3 == -2)
      {
        paramInt2 = i;
        paramInt1 = Integer.MIN_VALUE;
      }
    }
  }
  
  public static int getLeftDecorationWidth(View paramView)
  {
    return getLayoutParamsmDecorInsets.left;
  }
  
  public static int getPosition(View paramView)
  {
    return getLayoutParamsmViewHolder.getLayoutPosition();
  }
  
  public static Properties getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Properties localProperties = new Properties();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
    orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
    spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
    reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
    stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
    paramContext.recycle();
    return localProperties;
  }
  
  public static int getRightDecorationWidth(View paramView)
  {
    return getLayoutParamsmDecorInsets.right;
  }
  
  public static int getTopDecorationHeight(View paramView)
  {
    return getLayoutParamsmDecorInsets.top;
  }
  
  static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {}
    do
    {
      do
      {
        return false;
        switch (i)
        {
        default: 
          return false;
        }
      } while (paramInt2 < paramInt1);
      return true;
      return true;
    } while (paramInt2 != paramInt1);
    return true;
  }
  
  private void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null) {
      mChildHelper.removeViewAt(paramInt);
    }
  }
  
  private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.shouldIgnore()) {
      return;
    }
    if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!RecyclerView.access$3100(mRecyclerView).hasStableIds()))
    {
      removeViewAt(paramInt);
      paramRecycler.recycleViewHolderInternal(localViewHolder);
      return;
    }
    detachViewAt(paramInt);
    paramRecycler.scrapView(paramView);
    mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
  }
  
  public final void addViewInt(View paramView, int paramInt, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramBoolean) || (localViewHolder.isRemoved()))
    {
      mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localViewHolder.wasReturnedFromScrap()) && (!localViewHolder.isScrap())) {
        break label128;
      }
      if (!localViewHolder.isScrap()) {
        break label120;
      }
      localViewHolder.unScrap();
      label68:
      mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (mPendingInvalidate)
      {
        itemView.invalidate();
        mPendingInvalidate = false;
      }
      return;
      mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      break;
      label120:
      localViewHolder.clearReturnedFromScrapFlag();
      break label68;
      label128:
      if (paramView.getParent() == mRecyclerView)
      {
        int j = mChildHelper.indexOfChild(paramView);
        int i = paramInt;
        if (paramInt == -1) {
          i = mChildHelper.getChildCount();
        }
        if (j == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + mRecyclerView.indexOfChild(paramView));
        }
        if (j != i)
        {
          paramView = mRecyclerView.mLayout;
          View localView = paramView.getChildAt(j);
          if (localView == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j);
          }
          paramView.detachViewAt(j);
          paramView.attachView(localView, i);
        }
      }
      else
      {
        mChildHelper.addView(paramView, paramInt, false);
        mInsetsDirty = true;
        if ((mSmoothScroller != null) && (mSmoothScroller.mRunning)) {
          mSmoothScroller.onChildAttachedToWindow(paramView);
        }
      }
    }
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (mRecyclerView != null) {
      mRecyclerView.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public final void attachView(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.isRemoved()) {
      mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
    }
    for (;;)
    {
      mChildHelper.attachViewToParent(paramView, paramInt, localLayoutParams, localViewHolder.isRemoved());
      return;
      mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
    }
  }
  
  public final void calculateItemDecorationsForChild(View paramView, Rect paramRect)
  {
    if (mRecyclerView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(mRecyclerView.getItemDecorInsetsForChild(paramView));
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return 0;
  }
  
  public final void detachAndScrapAttachedViews(RecyclerView.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      scrapOrRecycleView(paramRecycler, i, getChildAt(i));
      i -= 1;
    }
  }
  
  public final void detachAndScrapViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
  }
  
  public final void detachViewInternal$4d81c81c(int paramInt)
  {
    mChildHelper.detachViewFromParent(paramInt);
  }
  
  final void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    mIsAttachedToWindow = false;
    onDetachedFromWindow(paramRecyclerView, paramRecycler);
  }
  
  public final View findContainingItemView(View paramView)
  {
    Object localObject;
    if (mRecyclerView == null) {
      localObject = null;
    }
    do
    {
      return (View)localObject;
      RecyclerView localRecyclerView = mRecyclerView;
      for (localObject = paramView.getParent(); (localObject != null) && (localObject != localRecyclerView) && ((localObject instanceof View)); localObject = paramView.getParent()) {
        paramView = (View)localObject;
      }
      if (localObject == localRecyclerView) {}
      while (paramView == null)
      {
        return null;
        paramView = null;
      }
      localObject = paramView;
    } while (!mChildHelper.isHidden(paramView));
    return null;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if ((localViewHolder != null) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.shouldIgnore()) && ((mRecyclerView.mState.mInPreLayout) || (!localViewHolder.isRemoved()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
      return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new RecyclerView.LayoutParams(paramLayoutParams);
  }
  
  public final View getChildAt(int paramInt)
  {
    if (mChildHelper != null) {
      return mChildHelper.getChildAt(paramInt);
    }
    return null;
  }
  
  public final int getChildCount()
  {
    if (mChildHelper != null) {
      return mChildHelper.getChildCount();
    }
    return 0;
  }
  
  public final boolean getClipToPadding()
  {
    return (mRecyclerView != null) && (RecyclerView.access$5500(mRecyclerView));
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((mRecyclerView == null) || (RecyclerView.access$3100(mRecyclerView) == null)) {}
    while (!canScrollHorizontally()) {
      return 1;
    }
    return RecyclerView.access$3100(mRecyclerView).getItemCount();
  }
  
  public int getDecoratedBottom(View paramView)
  {
    return paramView.getBottom() + getBottomDecorationHeight(paramView);
  }
  
  public int getDecoratedLeft(View paramView)
  {
    return paramView.getLeft() - getLeftDecorationWidth(paramView);
  }
  
  public int getDecoratedMeasuredHeight(View paramView)
  {
    Rect localRect = getLayoutParamsmDecorInsets;
    return paramView.getMeasuredHeight() + top + bottom;
  }
  
  public int getDecoratedMeasuredWidth(View paramView)
  {
    Rect localRect = getLayoutParamsmDecorInsets;
    return paramView.getMeasuredWidth() + left + right;
  }
  
  public int getDecoratedRight(View paramView)
  {
    return paramView.getRight() + getRightDecorationWidth(paramView);
  }
  
  public int getDecoratedTop(View paramView)
  {
    return paramView.getTop() - getTopDecorationHeight(paramView);
  }
  
  public final int getItemCount()
  {
    if (mRecyclerView != null) {}
    for (RecyclerView.Adapter localAdapter = mRecyclerView.getAdapter(); localAdapter != null; localAdapter = null) {
      return localAdapter.getItemCount();
    }
    return 0;
  }
  
  public final int getPaddingBottom()
  {
    if (mRecyclerView != null) {
      return mRecyclerView.getPaddingBottom();
    }
    return 0;
  }
  
  public final int getPaddingEnd()
  {
    if (mRecyclerView != null) {
      return ViewCompat.getPaddingEnd(mRecyclerView);
    }
    return 0;
  }
  
  public final int getPaddingLeft()
  {
    if (mRecyclerView != null) {
      return mRecyclerView.getPaddingLeft();
    }
    return 0;
  }
  
  public final int getPaddingRight()
  {
    if (mRecyclerView != null) {
      return mRecyclerView.getPaddingRight();
    }
    return 0;
  }
  
  public final int getPaddingStart()
  {
    if (mRecyclerView != null) {
      return ViewCompat.getPaddingStart(mRecyclerView);
    }
    return 0;
  }
  
  public final int getPaddingTop()
  {
    if (mRecyclerView != null) {
      return mRecyclerView.getPaddingTop();
    }
    return 0;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((mRecyclerView == null) || (RecyclerView.access$3100(mRecyclerView) == null)) {}
    while (!canScrollVertically()) {
      return 1;
    }
    return RecyclerView.access$3100(mRecyclerView).getItemCount();
  }
  
  public final boolean isSmoothScrolling()
  {
    return (mSmoothScroller != null) && (mSmoothScroller.mRunning);
  }
  
  public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = getLayoutParamsmDecorInsets;
    paramView.layout(left + paramInt1, top + paramInt2, paramInt3 - right, paramInt4 - bottom);
  }
  
  public final void measureChild$17e143a3(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = mRecyclerView.getItemDecorInsetsForChild(paramView);
    int k = left;
    int m = right;
    int i = top;
    int j = bottom;
    k = getChildMeasureSpec(mWidth, mWidthMode, getPaddingLeft() + getPaddingRight() + (k + m + 0), width, canScrollHorizontally());
    i = getChildMeasureSpec(mHeight, mHeightMode, getPaddingTop() + getPaddingBottom() + (i + j + 0), height, canScrollVertically());
    if (shouldMeasureChild(paramView, k, i, localLayoutParams)) {
      paramView.measure(k, i);
    }
  }
  
  public final void measureChildWithMargins$17e143a3(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    Rect localRect = mRecyclerView.getItemDecorInsetsForChild(paramView);
    int k = left;
    int m = right;
    int i = top;
    int j = bottom;
    paramInt = getChildMeasureSpec(mWidth, mWidthMode, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + (paramInt + (k + m)), width, canScrollHorizontally());
    i = getChildMeasureSpec(mHeight, mHeightMode, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + (i + j + 0), height, canScrollVertically());
    if (shouldMeasureChild(paramView, paramInt, i, localLayoutParams)) {
      paramView.measure(paramInt, i);
    }
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    if (mRecyclerView != null)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      int j = mChildHelper.getChildCount();
      int i = 0;
      while (i < j)
      {
        mChildHelper.getChildAt(i).offsetLeftAndRight(paramInt);
        i += 1;
      }
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    if (mRecyclerView != null)
    {
      RecyclerView localRecyclerView = mRecyclerView;
      int j = mChildHelper.getChildCount();
      int i = 0;
      while (i < j)
      {
        mChildHelper.getChildAt(i).offsetTopAndBottom(paramInt);
        i += 1;
      }
    }
  }
  
  public void onAdapterChanged$69e7eefb() {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler) {}
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    Object localObject = mRecyclerView.mRecycler;
    localObject = mRecyclerView.mState;
    paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
    if (mRecyclerView == null) {
      return;
    }
    boolean bool1 = bool2;
    if (!ViewCompat.canScrollVertically(mRecyclerView, 1))
    {
      bool1 = bool2;
      if (!ViewCompat.canScrollVertically(mRecyclerView, -1))
      {
        bool1 = bool2;
        if (!ViewCompat.canScrollHorizontally(mRecyclerView, -1)) {
          if (!ViewCompat.canScrollHorizontally(mRecyclerView, 1)) {
            break label115;
          }
        }
      }
    }
    label115:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.setScrollable(bool1);
      if (RecyclerView.access$3100(mRecyclerView) == null) {
        break;
      }
      paramAccessibilityEvent.setItemCount(RecyclerView.access$3100(mRecyclerView).getItemCount());
      return;
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    int i;
    if (canScrollVertically())
    {
      i = getPosition(paramView);
      if (!canScrollHorizontally()) {
        break label48;
      }
    }
    label48:
    for (int j = getPosition(paramView);; j = 0)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain$430787b1(i, 1, j, 1, false));
      return;
      i = 0;
      break;
    }
  }
  
  final void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (!mChildHelper.isHidden(itemView))) {
      onInitializeAccessibilityNodeInfoForItem(mRecyclerView.mRecycler, mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public void onItemsAdded$5927c743(int paramInt1, int paramInt2) {}
  
  public void onItemsChanged$57043c5d() {}
  
  public void onItemsMoved$342e6be0(int paramInt1, int paramInt2) {}
  
  public void onItemsRemoved$5927c743(int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void onItemsUpdated$783f8c5f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public final void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
        removeAndRecycleViewAt(i, paramRecycler);
      }
      i -= 1;
    }
  }
  
  final void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
  {
    int j = mAttachedScrap.size();
    int i = j - 1;
    while (i >= 0)
    {
      View localView = mAttachedScrap.get(i)).itemView;
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if (!localViewHolder.shouldIgnore())
      {
        localViewHolder.setIsRecyclable(false);
        if (localViewHolder.isTmpDetached()) {
          mRecyclerView.removeDetachedView(localView, false);
        }
        if (mRecyclerView.mItemAnimator != null) {
          mRecyclerView.mItemAnimator.endAnimation(localViewHolder);
        }
        localViewHolder.setIsRecyclable(true);
        paramRecycler.quickRecycleScrapView(localView);
      }
      i -= 1;
    }
    mAttachedScrap.clear();
    if (mChangedScrap != null) {
      mChangedScrap.clear();
    }
    if (j > 0) {
      mRecyclerView.invalidate();
    }
  }
  
  public final void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
  {
    ChildHelper localChildHelper = mChildHelper;
    int i = mCallback.indexOfChild(paramView);
    if (i >= 0)
    {
      if (mBucket.remove(i)) {
        localChildHelper.unhideViewInternal(paramView);
      }
      mCallback.removeViewAt(i);
    }
    paramRecycler.recycleView(paramView);
  }
  
  public final void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
  {
    View localView = getChildAt(paramInt);
    removeViewAt(paramInt);
    paramRecycler.recycleView(localView);
  }
  
  public final boolean removeCallbacks(Runnable paramRunnable)
  {
    if (mRecyclerView != null) {
      return mRecyclerView.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public final void requestLayout()
  {
    if (mRecyclerView != null) {
      mRecyclerView.requestLayout();
    }
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  public void scrollToPosition(int paramInt) {}
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return 0;
  }
  
  final void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
  {
    setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  final void setMeasureSpecs(int paramInt1, int paramInt2)
  {
    mWidth = View.MeasureSpec.getSize(paramInt1);
    mWidthMode = View.MeasureSpec.getMode(paramInt1);
    if ((mWidthMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
      mWidth = 0;
    }
    mHeight = View.MeasureSpec.getSize(paramInt2);
    mHeightMode = View.MeasureSpec.getMode(paramInt2);
    if ((mHeightMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
      mHeight = 0;
    }
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2)
  {
    RecyclerView.access$5600(mRecyclerView, paramInt1, paramInt2);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = paramRect.width();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = paramRect.height();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    setMeasuredDimension(chooseSize(paramInt1, i + j + k, ViewCompat.getMinimumWidth(mRecyclerView)), chooseSize(paramInt2, m + n + i1, ViewCompat.getMinimumHeight(mRecyclerView)));
  }
  
  final void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
  {
    int i6 = getChildCount();
    if (i6 == 0)
    {
      mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    int i1 = Integer.MAX_VALUE;
    int j = Integer.MAX_VALUE;
    int n = Integer.MIN_VALUE;
    int i = Integer.MIN_VALUE;
    int k = 0;
    while (k < i6)
    {
      View localView = getChildAt(k);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int i5 = getDecoratedLeft(localView) - leftMargin;
      int i2 = getDecoratedRight(localView) + rightMargin;
      int i4 = getDecoratedTop(localView) - topMargin;
      int i3 = getDecoratedBottom(localView) + bottomMargin;
      int m = i1;
      if (i5 < i1) {
        m = i5;
      }
      i1 = n;
      if (i2 > n) {
        i1 = i2;
      }
      i2 = j;
      if (i4 < j) {
        i2 = i4;
      }
      j = i;
      if (i3 > i) {
        j = i3;
      }
      k += 1;
      n = i1;
      i = j;
      i1 = m;
      j = i2;
    }
    RecyclerView.access$5400(mRecyclerView).set(i1, j, n, i);
    setMeasuredDimension(RecyclerView.access$5400(mRecyclerView), paramInt1, paramInt2);
  }
  
  final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      mRecyclerView = null;
      mChildHelper = null;
      mWidth = 0;
    }
    for (mHeight = 0;; mHeight = paramRecyclerView.getHeight())
    {
      mWidthMode = 1073741824;
      mHeightMode = 1073741824;
      return;
      mRecyclerView = paramRecyclerView;
      mChildHelper = mChildHelper;
      mWidth = paramRecyclerView.getWidth();
    }
  }
  
  final boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
  {
    return (paramView.isLayoutRequested()) || (!mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, height));
  }
  
  boolean shouldMeasureTwice()
  {
    return false;
  }
  
  public void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt)
  {
    Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
  }
  
  public final void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
  {
    if ((mSmoothScroller != null) && (paramSmoothScroller != mSmoothScroller) && (mSmoothScroller.mRunning)) {
      mSmoothScroller.stop();
    }
    mSmoothScroller = paramSmoothScroller;
    paramSmoothScroller = mSmoothScroller;
    mRecyclerView = mRecyclerView;
    mLayoutManager = this;
    if (mTargetPosition == -1) {
      throw new IllegalArgumentException("Invalid target position");
    }
    mRecyclerView.mState.mTargetPosition = mTargetPosition;
    mRunning = true;
    mPendingInitialRun = true;
    int i = mTargetPosition;
    mTargetView = mRecyclerView.mLayout.findViewByPosition(i);
    RecyclerView.access$5900(mRecyclerView).postOnAnimation();
  }
  
  final void stopSmoothScroller()
  {
    if (mSmoothScroller != null) {
      mSmoothScroller.stop();
    }
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
  
  public static final class Properties
  {
    public int orientation;
    public boolean reverseLayout;
    public int spanCount;
    public boolean stackFromEnd;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.LayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */