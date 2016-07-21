package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class RecyclerViewAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  final AccessibilityDelegateCompat mItemDelegate = new AccessibilityDelegateCompat()
  {
    public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      if ((!shouldIgnore()) && (mRecyclerView.getLayoutManager() != null)) {
        mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      }
    }
    
    public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      boolean bool2 = false;
      boolean bool1;
      if (super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle)) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (shouldIgnore());
        bool1 = bool2;
      } while (mRecyclerView.getLayoutManager() == null);
      paramAnonymousView = mRecyclerView.getLayoutManager();
      paramAnonymousBundle = mRecyclerView.mRecycler;
      paramAnonymousView = mRecyclerView.mState;
      return false;
    }
  };
  final RecyclerView mRecyclerView;
  
  public RecyclerViewAccessibilityDelegate(RecyclerView paramRecyclerView)
  {
    mRecyclerView = paramRecyclerView;
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!shouldIgnore()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
    if ((!shouldIgnore()) && (mRecyclerView.getLayoutManager() != null))
    {
      paramView = mRecyclerView.getLayoutManager();
      RecyclerView.Recycler localRecycler = mRecyclerView.mRecycler;
      RecyclerView.State localState = mRecyclerView.mState;
      if ((ViewCompat.canScrollVertically(mRecyclerView, -1)) || (ViewCompat.canScrollHorizontally(mRecyclerView, -1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(8192);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      if ((ViewCompat.canScrollVertically(mRecyclerView, 1)) || (ViewCompat.canScrollHorizontally(mRecyclerView, 1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(4096);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      int i = paramView.getRowCountForAccessibility(localRecycler, localState);
      int j = paramView.getColumnCountForAccessibility(localRecycler, localState);
      paramView = new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionInfo$50cb9c52(i, j));
      AccessibilityNodeInfoCompat.IMPL.setCollectionInfo(mInfo, mInfo);
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (shouldIgnore());
          bool1 = bool2;
        } while (mRecyclerView.getLayoutManager() == null);
        paramView = mRecyclerView.getLayoutManager();
        paramBundle = mRecyclerView.mRecycler;
        paramBundle = mRecyclerView.mState;
        bool1 = bool2;
      } while (mRecyclerView == null);
      switch (paramInt)
      {
      default: 
        paramInt = 0;
        i = 0;
        if (i != 0) {
          break label126;
        }
        bool1 = bool2;
      }
    } while (paramInt == 0);
    label126:
    mRecyclerView.scrollBy(paramInt, i);
    return true;
    if (ViewCompat.canScrollVertically(mRecyclerView, -1)) {}
    for (paramInt = -(mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom());; paramInt = 0)
    {
      i = paramInt;
      int j;
      if (ViewCompat.canScrollHorizontally(mRecyclerView, -1))
      {
        j = -(mWidth - paramView.getPaddingLeft() - paramView.getPaddingRight());
        i = paramInt;
        paramInt = j;
        break;
        if (!ViewCompat.canScrollVertically(mRecyclerView, 1)) {
          break label283;
        }
      }
      label283:
      for (paramInt = mHeight - paramView.getPaddingTop() - paramView.getPaddingBottom();; paramInt = 0)
      {
        i = paramInt;
        if (ViewCompat.canScrollHorizontally(mRecyclerView, 1))
        {
          j = mWidth;
          int k = paramView.getPaddingLeft();
          int m = paramView.getPaddingRight();
          i = paramInt;
          paramInt = j - k - m;
          break;
        }
        paramInt = 0;
        break;
      }
    }
  }
  
  final boolean shouldIgnore()
  {
    RecyclerView localRecyclerView = mRecyclerView;
    return (!mFirstLayoutComplete) || (mDataSetHasChangedAfterLayout) || (mAdapterHelper.hasPendingUpdates());
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerViewAccessibilityDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */