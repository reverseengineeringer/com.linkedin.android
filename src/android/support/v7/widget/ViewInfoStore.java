package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;

final class ViewInfoStore
{
  final ArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new ArrayMap();
  final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();
  
  final void addToDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    flags |= 0x1;
  }
  
  final void addToOldChangeHolders(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    mOldChangedHolders.put(paramLong, paramViewHolder);
  }
  
  final void addToPostLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    postInfo = paramItemHolderInfo;
    flags |= 0x8;
  }
  
  final void addToPreLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    preInfo = paramItemHolderInfo;
    flags |= 0x4;
  }
  
  final void clear()
  {
    mLayoutHolderMap.clear();
    LongSparseArray localLongSparseArray = mOldChangedHolders;
    int j = mSize;
    Object[] arrayOfObject = mValues;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    mSize = 0;
    mGarbage = false;
  }
  
  final boolean isDisappearing(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((flags & 0x1) != 0);
  }
  
  final RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    int i = mLayoutHolderMap.indexOfKey(paramViewHolder);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    InfoRecord localInfoRecord;
    do
    {
      do
      {
        return (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1;
        localInfoRecord = (InfoRecord)mLayoutHolderMap.valueAt(i);
        localObject1 = localObject2;
      } while (localInfoRecord == null);
      localObject1 = localObject2;
    } while ((flags & paramInt) == 0);
    flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramViewHolder = preInfo;; paramViewHolder = postInfo)
    {
      localObject1 = paramViewHolder;
      if ((flags & 0xC) != 0) {
        break;
      }
      mLayoutHolderMap.removeAt(i);
      InfoRecord.recycle(localInfoRecord);
      return paramViewHolder;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
  }
  
  final void process(ProcessCallback paramProcessCallback)
  {
    int i = mLayoutHolderMap.size() - 1;
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)mLayoutHolderMap.keyAt(i);
      InfoRecord localInfoRecord = (InfoRecord)mLayoutHolderMap.removeAt(i);
      if ((flags & 0x3) == 3) {
        paramProcessCallback.unused(localViewHolder);
      }
      for (;;)
      {
        InfoRecord.recycle(localInfoRecord);
        i -= 1;
        break;
        if ((flags & 0x1) != 0)
        {
          if (preInfo == null) {
            paramProcessCallback.unused(localViewHolder);
          } else {
            paramProcessCallback.processDisappeared(localViewHolder, preInfo, postInfo);
          }
        }
        else if ((flags & 0xE) == 14) {
          paramProcessCallback.processAppeared(localViewHolder, preInfo, postInfo);
        } else if ((flags & 0xC) == 12) {
          paramProcessCallback.processPersistent(localViewHolder, preInfo, postInfo);
        } else if ((flags & 0x4) != 0) {
          paramProcessCallback.processDisappeared(localViewHolder, preInfo, null);
        } else if ((flags & 0x8) != 0) {
          paramProcessCallback.processAppeared(localViewHolder, preInfo, postInfo);
        } else {
          int j = flags;
        }
      }
    }
  }
  
  final void removeFromDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)mLayoutHolderMap.get(paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    flags &= 0xFFFFFFFE;
  }
  
  final void removeViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = mOldChangedHolders.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramViewHolder != mOldChangedHolders.valueAt(i)) {
          break label78;
        }
        LongSparseArray localLongSparseArray = mOldChangedHolders;
        if (mValues[i] != LongSparseArray.DELETED)
        {
          mValues[i] = LongSparseArray.DELETED;
          mGarbage = true;
        }
      }
      paramViewHolder = (InfoRecord)mLayoutHolderMap.remove(paramViewHolder);
      if (paramViewHolder != null) {
        InfoRecord.recycle(paramViewHolder);
      }
      return;
      label78:
      i -= 1;
    }
  }
  
  static final class InfoRecord
  {
    static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool(20);
    int flags;
    RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
    RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
    
    static void drainCache()
    {
      while (sPool.acquire() != null) {}
    }
    
    static InfoRecord obtain()
    {
      InfoRecord localInfoRecord2 = (InfoRecord)sPool.acquire();
      InfoRecord localInfoRecord1 = localInfoRecord2;
      if (localInfoRecord2 == null) {
        localInfoRecord1 = new InfoRecord();
      }
      return localInfoRecord1;
    }
    
    static void recycle(InfoRecord paramInfoRecord)
    {
      flags = 0;
      preInfo = null;
      postInfo = null;
      sPool.release(paramInfoRecord);
    }
  }
  
  static abstract interface ProcessCallback
  {
    public abstract void processAppeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processDisappeared(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processPersistent(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void unused(RecyclerView.ViewHolder paramViewHolder);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ViewInfoStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */