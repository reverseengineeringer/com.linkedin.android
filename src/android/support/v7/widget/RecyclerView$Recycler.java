package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$Recycler
{
  final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
  final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
  RecyclerView.RecycledViewPool mRecyclerPool;
  final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
  RecyclerView.ViewCacheExtension mViewCacheExtension;
  int mViewCacheMax = 2;
  
  public RecyclerView$Recycler(RecyclerView paramRecyclerView) {}
  
  private void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewCompat.setAccessibilityDelegate(itemView, null);
    if (RecyclerView.access$5300(this$0) != null) {
      RecyclerView.access$5300(this$0);
    }
    if (RecyclerView.access$3100(this$0) != null) {
      RecyclerView.access$3100(this$0).onViewRecycled(paramViewHolder);
    }
    if (this$0.mState != null) {
      this$0.mViewInfoStore.removeViewHolder(paramViewHolder);
    }
    mOwnerRecyclerView = null;
    getRecycledViewPool().putRecycledView(paramViewHolder);
  }
  
  private void attachAccessibilityDelegate(View paramView)
  {
    if (this$0.isAccessibilityEnabled())
    {
      if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
      if (!ViewCompat.hasAccessibilityDelegate(paramView)) {
        ViewCompat.setAccessibilityDelegate(paramView, access$4800this$0).mItemDelegate);
      }
    }
  }
  
  private RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
  {
    int j;
    if (mChangedScrap != null)
    {
      j = mChangedScrap.size();
      if (j != 0) {}
    }
    else
    {
      return null;
    }
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    while (i < j)
    {
      localViewHolder = (RecyclerView.ViewHolder)mChangedScrap.get(i);
      if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt))
      {
        localViewHolder.addFlags(32);
        return localViewHolder;
      }
      i += 1;
    }
    if (RecyclerView.access$3100(this$0).hasStableIds())
    {
      paramInt = this$0.mAdapterHelper.findPositionOffset(paramInt, 0);
      if ((paramInt > 0) && (paramInt < RecyclerView.access$3100(this$0).getItemCount()))
      {
        long l = RecyclerView.access$3100(this$0).getItemId(paramInt);
        paramInt = 0;
        while (paramInt < j)
        {
          localViewHolder = (RecyclerView.ViewHolder)mChangedScrap.get(paramInt);
          if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getItemId() == l))
          {
            localViewHolder.addFlags(32);
            return localViewHolder;
          }
          paramInt += 1;
        }
      }
    }
    return null;
  }
  
  private RecyclerView.ViewHolder getScrapViewForId$302a751d(long paramLong, int paramInt)
  {
    int i = mAttachedScrap.size() - 1;
    RecyclerView.ViewHolder localViewHolder;
    while (i >= 0)
    {
      localViewHolder = (RecyclerView.ViewHolder)mAttachedScrap.get(i);
      if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap()))
      {
        if (paramInt == localViewHolder.getItemViewType())
        {
          localViewHolder.addFlags(32);
          if ((localViewHolder.isRemoved()) && (!this$0.mState.mInPreLayout)) {
            localViewHolder.setFlags(2, 14);
          }
          return localViewHolder;
        }
        mAttachedScrap.remove(i);
        this$0.removeDetachedView(itemView, false);
        quickRecycleScrapView(itemView);
      }
      i -= 1;
    }
    i = mCachedViews.size() - 1;
    while (i >= 0)
    {
      localViewHolder = (RecyclerView.ViewHolder)mCachedViews.get(i);
      if (localViewHolder.getItemId() == paramLong)
      {
        if (paramInt == localViewHolder.getItemViewType())
        {
          mCachedViews.remove(i);
          return localViewHolder;
        }
        recycleCachedViewAt(i);
      }
      i -= 1;
    }
    return null;
  }
  
  private RecyclerView.ViewHolder getScrapViewForPosition$6d61fdc$7d85d05d(int paramInt)
  {
    int j = mAttachedScrap.size();
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = (RecyclerView.ViewHolder)mAttachedScrap.get(i);
      if ((!((RecyclerView.ViewHolder)localObject1).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject1).getLayoutPosition() == paramInt) && (!((RecyclerView.ViewHolder)localObject1).isInvalid()) && ((this$0.mState.mInPreLayout) || (!((RecyclerView.ViewHolder)localObject1).isRemoved())))
      {
        ((RecyclerView.ViewHolder)localObject1).addFlags(32);
        return (RecyclerView.ViewHolder)localObject1;
      }
      i += 1;
    }
    Object localObject2 = this$0.mChildHelper;
    j = mHiddenViews.size();
    i = 0;
    Object localObject3;
    if (i < j)
    {
      localObject1 = (View)mHiddenViews.get(i);
      localObject3 = mCallback.getChildViewHolder((View)localObject1);
      if ((((RecyclerView.ViewHolder)localObject3).getLayoutPosition() != paramInt) || (((RecyclerView.ViewHolder)localObject3).isInvalid()) || (((RecyclerView.ViewHolder)localObject3).isRemoved())) {}
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = RecyclerView.getChildViewHolderInt((View)localObject1);
        localObject3 = this$0.mChildHelper;
        paramInt = mCallback.indexOfChild((View)localObject1);
        if (paramInt < 0)
        {
          throw new IllegalArgumentException("view is not a child, cannot hide " + localObject1);
          i += 1;
          break;
          localObject1 = null;
          continue;
        }
        if (!mBucket.get(paramInt)) {
          throw new RuntimeException("trying to unhide a view that was not hidden" + localObject1);
        }
        mBucket.clear(paramInt);
        ((ChildHelper)localObject3).unhideViewInternal((View)localObject1);
        paramInt = this$0.mChildHelper.indexOfChild((View)localObject1);
        if (paramInt == -1) {
          throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2);
        }
        this$0.mChildHelper.detachViewFromParent(paramInt);
        scrapView((View)localObject1);
        ((RecyclerView.ViewHolder)localObject2).addFlags(8224);
        return (RecyclerView.ViewHolder)localObject2;
      }
    }
    j = mCachedViews.size();
    i = 0;
    while (i < j)
    {
      localObject1 = (RecyclerView.ViewHolder)mCachedViews.get(i);
      if ((!((RecyclerView.ViewHolder)localObject1).isInvalid()) && (((RecyclerView.ViewHolder)localObject1).getLayoutPosition() == paramInt))
      {
        mCachedViews.remove(i);
        return (RecyclerView.ViewHolder)localObject1;
      }
      i += 1;
    }
    return null;
  }
  
  private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        invalidateDisplayListInt((ViewGroup)localView, true);
      }
      i -= 1;
    }
    if (!paramBoolean) {
      return;
    }
    if (paramViewGroup.getVisibility() == 4)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setVisibility(4);
      return;
    }
    i = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(i);
  }
  
  public final void bindViewToPosition(View paramView, int paramInt)
  {
    boolean bool = true;
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder == null) {
      throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
    }
    int i = this$0.mAdapterHelper.findPositionOffset(paramInt);
    if ((i < 0) || (i >= RecyclerView.access$3100(this$0).getItemCount())) {
      throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + i + ").state:" + this$0.mState.getItemCount());
    }
    mOwnerRecyclerView = this$0;
    RecyclerView.access$3100(this$0).bindViewHolder(localViewHolder, i);
    attachAccessibilityDelegate(paramView);
    if (this$0.mState.mInPreLayout) {
      mPreLayoutPosition = paramInt;
    }
    paramView = itemView.getLayoutParams();
    if (paramView == null)
    {
      paramView = (RecyclerView.LayoutParams)this$0.generateDefaultLayoutParams();
      itemView.setLayoutParams(paramView);
      mInsetsDirty = true;
      mViewHolder = localViewHolder;
      if (itemView.getParent() != null) {
        break label260;
      }
    }
    for (;;)
    {
      mPendingInvalidate = bool;
      return;
      if (!this$0.checkLayoutParams(paramView))
      {
        paramView = (RecyclerView.LayoutParams)this$0.generateLayoutParams(paramView);
        itemView.setLayoutParams(paramView);
        break;
      }
      paramView = (RecyclerView.LayoutParams)paramView;
      break;
      label260:
      bool = false;
    }
  }
  
  public final void clear()
  {
    mAttachedScrap.clear();
    recycleAndClearCachedViews();
  }
  
  public final int convertPreLayoutPositionToPostLayout(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this$0.mState.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + this$0.mState.getItemCount());
    }
    if (!this$0.mState.mInPreLayout) {
      return paramInt;
    }
    return this$0.mAdapterHelper.findPositionOffset(paramInt);
  }
  
  final RecyclerView.RecycledViewPool getRecycledViewPool()
  {
    if (mRecyclerPool == null) {
      mRecyclerPool = new RecyclerView.RecycledViewPool();
    }
    return mRecyclerPool;
  }
  
  public final View getViewForPosition(int paramInt)
  {
    boolean bool2 = true;
    if ((paramInt < 0) || (paramInt >= this$0.mState.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this$0.mState.getItemCount());
    }
    Object localObject2;
    int i;
    if (this$0.mState.mInPreLayout)
    {
      localObject2 = getChangedScrapViewForPosition(paramInt);
      if (localObject2 != null) {
        i = 1;
      }
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      boolean bool1;
      if (localObject2 == null)
      {
        localObject2 = getScrapViewForPosition$6d61fdc$7d85d05d(paramInt);
        localObject1 = localObject2;
        if (localObject2 != null) {
          if (((RecyclerView.ViewHolder)localObject2).isRemoved())
          {
            bool1 = this$0.mState.mInPreLayout;
            label147:
            if (bool1) {
              break label457;
            }
            ((RecyclerView.ViewHolder)localObject2).addFlags(4);
            if (!((RecyclerView.ViewHolder)localObject2).isScrap()) {
              break label441;
            }
            this$0.removeDetachedView(itemView, false);
            ((RecyclerView.ViewHolder)localObject2).unScrap();
            label184:
            recycleViewHolderInternal((RecyclerView.ViewHolder)localObject2);
            localObject1 = null;
          }
        }
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        int k = i;
        label441:
        label457:
        int j;
        if (localObject1 == null)
        {
          k = this$0.mAdapterHelper.findPositionOffset(paramInt);
          if ((k < 0) || (k >= RecyclerView.access$3100(this$0).getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + this$0.mState.getItemCount());
            i = 0;
            break;
            if ((mPosition < 0) || (mPosition >= RecyclerView.access$3100(this$0).getItemCount())) {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2);
            }
            if ((!this$0.mState.mInPreLayout) && (RecyclerView.access$3100(this$0).getItemViewType(mPosition) != ((RecyclerView.ViewHolder)localObject2).getItemViewType()))
            {
              bool1 = false;
              break label147;
            }
            if ((RecyclerView.access$3100(this$0).hasStableIds()) && (((RecyclerView.ViewHolder)localObject2).getItemId() != RecyclerView.access$3100(this$0).getItemId(mPosition)))
            {
              bool1 = false;
              break label147;
            }
            bool1 = true;
            break label147;
            if (!((RecyclerView.ViewHolder)localObject2).wasReturnedFromScrap()) {
              break label184;
            }
            ((RecyclerView.ViewHolder)localObject2).clearReturnedFromScrapFlag();
            break label184;
            i = 1;
            localObject1 = localObject2;
            continue;
          }
          int m = RecyclerView.access$3100(this$0).getItemViewType(k);
          localObject2 = localObject1;
          j = i;
          if (RecyclerView.access$3100(this$0).hasStableIds())
          {
            localObject1 = getScrapViewForId$302a751d(RecyclerView.access$3100(this$0).getItemId(k), m);
            localObject2 = localObject1;
            j = i;
            if (localObject1 != null)
            {
              mPosition = k;
              j = 1;
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (mViewCacheExtension != null)
            {
              localObject3 = mViewCacheExtension.getViewForPositionAndType$430f8374();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject2 = this$0.getChildViewHolder((View)localObject3);
                if (localObject2 == null) {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                }
                localObject1 = localObject2;
                if (((RecyclerView.ViewHolder)localObject2).shouldIgnore()) {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = getRecycledViewPool().getRecycledView(m);
            if (localObject2 != null)
            {
              ((RecyclerView.ViewHolder)localObject2).resetInternal();
              if ((RecyclerView.access$4600()) && ((itemView instanceof ViewGroup))) {
                invalidateDisplayListInt((ViewGroup)itemView, false);
              }
            }
          }
          localObject3 = localObject2;
          k = j;
          if (localObject2 == null) {
            localObject2 = RecyclerView.access$3100(this$0).createViewHolder(this$0, m);
          }
        }
        for (i = j;; i = k)
        {
          if ((i != 0) && (!this$0.mState.mInPreLayout) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
          {
            ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
            if (this$0.mState.mRunSimpleAnimations)
            {
              RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
              localObject1 = this$0.mItemAnimator;
              localObject1 = this$0.mState;
              ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads();
              localObject1 = new RecyclerView.ItemAnimator.ItemHolderInfo().setFrom((RecyclerView.ViewHolder)localObject2);
              RecyclerView.access$4700(this$0, (RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
            }
          }
          if ((this$0.mState.mInPreLayout) && (((RecyclerView.ViewHolder)localObject2).isBound()))
          {
            mPreLayoutPosition = paramInt;
            paramInt = 0;
          }
          for (;;)
          {
            localObject1 = itemView.getLayoutParams();
            if (localObject1 == null)
            {
              localObject1 = (RecyclerView.LayoutParams)this$0.generateDefaultLayoutParams();
              itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              label894:
              mViewHolder = ((RecyclerView.ViewHolder)localObject2);
              if ((i == 0) || (paramInt == 0)) {
                break label1066;
              }
            }
            label1066:
            for (bool1 = bool2;; bool1 = false)
            {
              mPendingInvalidate = bool1;
              return itemView;
              if ((((RecyclerView.ViewHolder)localObject2).isBound()) && (!((RecyclerView.ViewHolder)localObject2).needsUpdate()) && (!((RecyclerView.ViewHolder)localObject2).isInvalid())) {
                break label1072;
              }
              j = this$0.mAdapterHelper.findPositionOffset(paramInt);
              mOwnerRecyclerView = this$0;
              RecyclerView.access$3100(this$0).bindViewHolder((RecyclerView.ViewHolder)localObject2, j);
              attachAccessibilityDelegate(itemView);
              if (this$0.mState.mInPreLayout) {
                mPreLayoutPosition = paramInt;
              }
              paramInt = 1;
              break;
              if (!this$0.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
              {
                localObject1 = (RecyclerView.LayoutParams)this$0.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                break label894;
              }
              localObject1 = (RecyclerView.LayoutParams)localObject1;
              break label894;
            }
            label1072:
            paramInt = 0;
          }
          localObject2 = localObject3;
        }
      }
      localObject2 = null;
      i = 0;
    }
  }
  
  final void quickRecycleScrapView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    RecyclerView.ViewHolder.access$5002(paramView, null);
    RecyclerView.ViewHolder.access$5102(paramView, false);
    paramView.clearReturnedFromScrapFlag();
    recycleViewHolderInternal(paramView);
  }
  
  final void recycleAndClearCachedViews()
  {
    int i = mCachedViews.size() - 1;
    while (i >= 0)
    {
      recycleCachedViewAt(i);
      i -= 1;
    }
    mCachedViews.clear();
  }
  
  final void recycleCachedViewAt(int paramInt)
  {
    addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)mCachedViews.get(paramInt));
    mCachedViews.remove(paramInt);
  }
  
  public final void recycleView(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.isTmpDetached()) {
      this$0.removeDetachedView(paramView, false);
    }
    if (localViewHolder.isScrap()) {
      localViewHolder.unScrap();
    }
    for (;;)
    {
      recycleViewHolderInternal(localViewHolder);
      return;
      if (localViewHolder.wasReturnedFromScrap()) {
        localViewHolder.clearReturnedFromScrapFlag();
      }
    }
  }
  
  final void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool = true;
    if ((paramViewHolder.isScrap()) || (itemView.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramViewHolder.isScrap()).append(" isAttached:");
      if (itemView.getParent() != null) {}
      for (;;)
      {
        throw new IllegalArgumentException(bool);
        bool = false;
      }
    }
    if (paramViewHolder.isTmpDetached()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramViewHolder);
    }
    if (paramViewHolder.shouldIgnore()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
    }
    bool = RecyclerView.ViewHolder.access$4900(paramViewHolder);
    if ((RecyclerView.access$3100(this$0) != null) && (bool) && (RecyclerView.access$3100(this$0).onFailedToRecycleView(paramViewHolder))) {}
    for (int i = 1;; i = 0)
    {
      int j = 0;
      int n = 0;
      int m = 0;
      int k;
      if (i == 0)
      {
        k = m;
        if (!paramViewHolder.isRecyclable()) {}
      }
      else
      {
        i = n;
        if (!paramViewHolder.hasAnyOfTheFlags(14))
        {
          j = mCachedViews.size();
          if ((j == mViewCacheMax) && (j > 0)) {
            recycleCachedViewAt(0);
          }
          i = n;
          if (j < mViewCacheMax)
          {
            mCachedViews.add(paramViewHolder);
            i = 1;
          }
        }
        j = i;
        k = m;
        if (i == 0)
        {
          addViewHolderToRecycledViewPool(paramViewHolder);
          k = 1;
          j = i;
        }
      }
      this$0.mViewInfoStore.removeViewHolder(paramViewHolder);
      if ((j == 0) && (k == 0) && (bool)) {
        mOwnerRecyclerView = null;
      }
      return;
    }
  }
  
  final void scrapView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if ((paramView.hasAnyOfTheFlags(12)) || (!paramView.isUpdated()) || (RecyclerView.access$5200(this$0, paramView)))
    {
      if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.access$3100(this$0).hasStableIds())) {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      }
      paramView.setScrapContainer(this, false);
      mAttachedScrap.add(paramView);
      return;
    }
    if (mChangedScrap == null) {
      mChangedScrap = new ArrayList();
    }
    paramView.setScrapContainer(this, true);
    mChangedScrap.add(paramView);
  }
  
  final void unscrapView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (RecyclerView.ViewHolder.access$5100(paramViewHolder)) {
      mChangedScrap.remove(paramViewHolder);
    }
    for (;;)
    {
      RecyclerView.ViewHolder.access$5002(paramViewHolder, null);
      RecyclerView.ViewHolder.access$5102(paramViewHolder, false);
      paramViewHolder.clearReturnedFromScrapFlag();
      return;
      mAttachedScrap.remove(paramViewHolder);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.Recycler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */