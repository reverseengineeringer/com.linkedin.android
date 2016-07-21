package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

final class RecyclerView$6
  implements AdapterHelper.Callback
{
  RecyclerView$6(RecyclerView paramRecyclerView) {}
  
  private void dispatchUpdate(AdapterHelper.UpdateOp paramUpdateOp)
  {
    switch (cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      this$0.mLayout.onItemsAdded$5927c743(positionStart, itemCount);
      return;
    case 2: 
      this$0.mLayout.onItemsRemoved$5927c743(positionStart, itemCount);
      return;
    case 4: 
      this$0.mLayout.onItemsUpdated$783f8c5f(this$0, positionStart, itemCount);
      return;
    }
    this$0.mLayout.onItemsMoved$342e6be0(positionStart, itemCount);
  }
  
  public final RecyclerView.ViewHolder findViewHolder(int paramInt)
  {
    Object localObject = this$0;
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    if (i < j)
    {
      localViewHolder = RecyclerView.getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (mPosition == paramInt))
      {
        label58:
        if (localViewHolder != null) {
          break label82;
        }
        localObject = null;
      }
    }
    label82:
    do
    {
      return (RecyclerView.ViewHolder)localObject;
      i += 1;
      break;
      localViewHolder = null;
      break label58;
      localObject = localViewHolder;
    } while (!this$0.mChildHelper.isHidden(itemView));
    return null;
  }
  
  public final void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject = this$0;
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = mChildHelper.getUnfilteredChildAt(i);
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (mPosition >= paramInt1) && (mPosition < paramInt1 + paramInt2))
      {
        localViewHolder.addFlags(2);
        localViewHolder.addChangePayload(paramObject);
        getLayoutParamsmInsetsDirty = true;
      }
      i += 1;
    }
    paramObject = mRecycler;
    i = mCachedViews.size() - 1;
    while (i >= 0)
    {
      localObject = (RecyclerView.ViewHolder)mCachedViews.get(i);
      if (localObject != null)
      {
        j = ((RecyclerView.ViewHolder)localObject).getLayoutPosition();
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          ((RecyclerView.ViewHolder)localObject).addFlags(2);
          ((RecyclerView.Recycler)paramObject).recycleCachedViewAt(i);
        }
      }
      i -= 1;
    }
    this$0.mItemsChanged = true;
  }
  
  public final void offsetPositionsForAdd(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this$0;
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = RecyclerView.getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if ((localObject != null) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()) && (mPosition >= paramInt1))
      {
        ((RecyclerView.ViewHolder)localObject).offsetPosition(paramInt2, false);
        mState.mStructureChanged = true;
      }
      i += 1;
    }
    Object localObject = mRecycler;
    j = mCachedViews.size();
    i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)mCachedViews.get(i);
      if ((localViewHolder != null) && (mPosition >= paramInt1)) {
        localViewHolder.offsetPosition(paramInt2, true);
      }
      i += 1;
    }
    localRecyclerView.requestLayout();
    this$0.mItemsAddedOrRemoved = true;
  }
  
  public final void offsetPositionsForMove(int paramInt1, int paramInt2)
  {
    int n = -1;
    RecyclerView localRecyclerView = this$0;
    int i1 = mChildHelper.getUnfilteredChildCount();
    int i;
    int j;
    int k;
    int m;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
      k = paramInt1;
      m = 0;
      label35:
      if (m >= i1) {
        break label139;
      }
      localObject = RecyclerView.getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(m));
      if ((localObject != null) && (mPosition >= k) && (mPosition <= j))
      {
        if (mPosition != paramInt1) {
          break label129;
        }
        ((RecyclerView.ViewHolder)localObject).offsetPosition(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      mState.mStructureChanged = true;
      m += 1;
      break label35;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label129:
      ((RecyclerView.ViewHolder)localObject).offsetPosition(i, false);
    }
    label139:
    Object localObject = mRecycler;
    label173:
    RecyclerView.ViewHolder localViewHolder;
    if (paramInt1 < paramInt2)
    {
      j = paramInt2;
      k = paramInt1;
      i = n;
      n = mCachedViews.size();
      m = 0;
      if (m >= n) {
        break label268;
      }
      localViewHolder = (RecyclerView.ViewHolder)mCachedViews.get(m);
      if ((localViewHolder != null) && (mPosition >= k) && (mPosition <= j))
      {
        if (mPosition != paramInt1) {
          break label258;
        }
        localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
      }
    }
    for (;;)
    {
      m += 1;
      break label173;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label258:
      localViewHolder.offsetPosition(i, false);
    }
    label268:
    localRecyclerView.requestLayout();
    this$0.mItemsAddedOrRemoved = true;
  }
  
  public final void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2)
  {
    this$0.offsetPositionRecordsForRemove(paramInt1, paramInt2, true);
    this$0.mItemsAddedOrRemoved = true;
    RecyclerView.State localState = this$0.mState;
    mDeletedInvisibleItemCountSincePreviousLayout += paramInt2;
  }
  
  public final void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2)
  {
    this$0.offsetPositionRecordsForRemove(paramInt1, paramInt2, false);
    this$0.mItemsAddedOrRemoved = true;
  }
  
  public final void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp)
  {
    dispatchUpdate(paramUpdateOp);
  }
  
  public final void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp)
  {
    dispatchUpdate(paramUpdateOp);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */