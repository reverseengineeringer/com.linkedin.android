package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.List;

final class AdapterHelper
  implements OpReorderer.Callback
{
  final Callback mCallback;
  final boolean mDisableRecycler;
  int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, (byte)0);
  }
  
  private AdapterHelper(Callback paramCallback, byte paramByte)
  {
    mCallback = paramCallback;
    mDisableRecycler = false;
    mOpReorderer = new OpReorderer(this);
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int k = mPostponedList.size();
    int i = 0;
    while (i < k)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPostponedList.get(i);
      if (cmd == 8)
      {
        if (findPositionOffset(itemCount, i + 1) == paramInt) {
          return true;
        }
      }
      else if (cmd == 1)
      {
        int m = positionStart;
        int n = itemCount;
        int j = positionStart;
        for (;;)
        {
          if (j >= m + n) {
            break label115;
          }
          if (findPositionOffset(j, i + 1) == paramInt) {
            break;
          }
          j += 1;
        }
      }
      label115:
      i += 1;
    }
    return false;
  }
  
  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    if ((cmd == 1) || (cmd == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = updatePositionWithPostponed(positionStart, cmd);
    int n = 1;
    int i = positionStart;
    int k;
    int m;
    label110:
    int i2;
    switch (cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 4: 
      k = 1;
      m = 1;
      if (m >= itemCount) {
        break label303;
      }
      i2 = updatePositionWithPostponed(positionStart + k * m, cmd);
      int i3 = 0;
      j = i3;
      switch (cmd)
      {
      default: 
        j = i3;
      case 3: 
        if (j == 0) {}
        break;
      }
      break;
    }
    for (int j = n + 1;; j = n)
    {
      m += 1;
      n = j;
      break label110;
      k = 0;
      break;
      if (i2 == i1 + 1) {}
      for (j = 1;; j = 0) {
        break;
      }
      if (i2 == i1) {}
      for (j = 1;; j = 0) {
        break;
      }
      localObject = obtainUpdateOp(cmd, i1, n, payload);
      dispatchFirstPassAndUpdateViewHolders((UpdateOp)localObject, i);
      recycleUpdateOp((UpdateOp)localObject);
      j = i;
      if (cmd == 4) {
        j = i + n;
      }
      i1 = i2;
      n = 1;
      i = j;
    }
    label303:
    Object localObject = payload;
    recycleUpdateOp(paramUpdateOp);
    if (n > 0)
    {
      paramUpdateOp = obtainUpdateOp(cmd, i1, n, localObject);
      dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
      recycleUpdateOp(paramUpdateOp);
    }
  }
  
  private void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
  {
    mCallback.onDispatchFirstPass(paramUpdateOp);
    switch (cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      mCallback.offsetPositionsForRemovingInvisible(paramInt, itemCount);
      return;
    }
    mCallback.markViewHoldersUpdated(paramInt, itemCount, payload);
  }
  
  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    mPostponedList.add(paramUpdateOp);
    switch (cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramUpdateOp);
    case 1: 
      mCallback.offsetPositionsForAdd(positionStart, itemCount);
      return;
    case 8: 
      mCallback.offsetPositionsForMove(positionStart, itemCount);
      return;
    case 2: 
      mCallback.offsetPositionsForRemovingLaidOutOrNewView(positionStart, itemCount);
      return;
    }
    mCallback.markViewHoldersUpdated(positionStart, itemCount, payload);
  }
  
  private void recycleUpdateOpsAndClearList(List<UpdateOp> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      recycleUpdateOp((UpdateOp)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = mPostponedList.size() - 1;
    int j = paramInt1;
    UpdateOp localUpdateOp;
    if (i >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(i);
      int k;
      if (cmd == 8) {
        if (positionStart < itemCount)
        {
          k = positionStart;
          paramInt1 = itemCount;
          label66:
          if ((j < k) || (j > paramInt1)) {
            break label202;
          }
          if (k != positionStart) {
            break label157;
          }
          if (paramInt2 != 1) {
            break label137;
          }
          itemCount += 1;
          label106:
          paramInt1 = j + 1;
        }
      }
      for (;;)
      {
        i -= 1;
        j = paramInt1;
        break;
        k = itemCount;
        paramInt1 = positionStart;
        break label66;
        label137:
        if (paramInt2 != 2) {
          break label106;
        }
        itemCount -= 1;
        break label106;
        label157:
        if (paramInt2 == 1) {
          positionStart += 1;
        }
        for (;;)
        {
          paramInt1 = j - 1;
          break;
          if (paramInt2 == 2) {
            positionStart -= 1;
          }
        }
        label202:
        paramInt1 = j;
        if (j < positionStart) {
          if (paramInt2 == 1)
          {
            positionStart += 1;
            itemCount += 1;
            paramInt1 = j;
          }
          else
          {
            paramInt1 = j;
            if (paramInt2 == 2)
            {
              positionStart -= 1;
              itemCount -= 1;
              paramInt1 = j;
              continue;
              if (positionStart <= j)
              {
                if (cmd == 1)
                {
                  paramInt1 = j - itemCount;
                }
                else
                {
                  paramInt1 = j;
                  if (cmd == 2) {
                    paramInt1 = j + itemCount;
                  }
                }
              }
              else if (paramInt2 == 1)
              {
                positionStart += 1;
                paramInt1 = j;
              }
              else
              {
                paramInt1 = j;
                if (paramInt2 == 2)
                {
                  positionStart -= 1;
                  paramInt1 = j;
                }
              }
            }
          }
        }
      }
    }
    paramInt1 = mPostponedList.size() - 1;
    if (paramInt1 >= 0)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(paramInt1);
      if (cmd == 8) {
        if ((itemCount == positionStart) || (itemCount < 0))
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
      for (;;)
      {
        paramInt1 -= 1;
        break;
        if (itemCount <= 0)
        {
          mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
    }
    return j;
  }
  
  final void consumePostponedUpdates()
  {
    int j = mPostponedList.size();
    int i = 0;
    while (i < j)
    {
      mCallback.onDispatchSecondPass((UpdateOp)mPostponedList.get(i));
      i += 1;
    }
    recycleUpdateOpsAndClearList(mPostponedList);
    mExistingUpdateTypes = 0;
  }
  
  final void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int j = mPendingUpdates.size();
    int i = 0;
    if (i < j)
    {
      UpdateOp localUpdateOp = (UpdateOp)mPendingUpdates.get(i);
      switch (cmd)
      {
      }
      for (;;)
      {
        if (mOnItemProcessedCallback != null) {
          mOnItemProcessedCallback.run();
        }
        i += 1;
        break;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForAdd(positionStart, itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForRemovingInvisible(positionStart, itemCount);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.markViewHoldersUpdated(positionStart, itemCount, payload);
        continue;
        mCallback.onDispatchSecondPass(localUpdateOp);
        mCallback.offsetPositionsForMove(positionStart, itemCount);
      }
    }
    recycleUpdateOpsAndClearList(mPendingUpdates);
    mExistingUpdateTypes = 0;
  }
  
  final int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  final int findPositionOffset(int paramInt1, int paramInt2)
  {
    int k = mPostponedList.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    UpdateOp localUpdateOp;
    if (j < k)
    {
      localUpdateOp = (UpdateOp)mPostponedList.get(j);
      if (cmd == 8) {
        if (positionStart == paramInt2) {
          paramInt1 = itemCount;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (positionStart < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (itemCount <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (positionStart <= paramInt2) {
          if (cmd == 2)
          {
            if (paramInt2 < positionStart + itemCount)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - itemCount;
          }
          else
          {
            paramInt1 = paramInt2;
            if (cmd == 1) {
              paramInt1 = paramInt2 + itemCount;
            }
          }
        }
      }
    }
  }
  
  final boolean hasAnyUpdateTypes(int paramInt)
  {
    return (mExistingUpdateTypes & paramInt) != 0;
  }
  
  final boolean hasPendingUpdates()
  {
    return mPendingUpdates.size() > 0;
  }
  
  public final UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    UpdateOp localUpdateOp = (UpdateOp)mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      return new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
    }
    cmd = paramInt1;
    positionStart = paramInt2;
    itemCount = paramInt3;
    payload = paramObject;
    return localUpdateOp;
  }
  
  final void preProcess()
  {
    OpReorderer localOpReorderer = mOpReorderer;
    ArrayList localArrayList = mPendingUpdates;
    int i;
    label24:
    label53:
    int i1;
    UpdateOp localUpdateOp2;
    UpdateOp localUpdateOp3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label268;
      }
      if (getcmd != 8) {
        break;
      }
      if (j == 0) {
        break label1835;
      }
      j = i;
      if (j == -1) {
        break label1251;
      }
      i1 = j + 1;
      localUpdateOp2 = (UpdateOp)localArrayList.get(j);
      localUpdateOp3 = (UpdateOp)localArrayList.get(i1);
      switch (cmd)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (itemCount < positionStart) {
          i = -1;
        }
        k = i;
        if (positionStart < positionStart) {
          k = i + 1;
        }
        if (positionStart <= positionStart) {
          positionStart += itemCount;
        }
        if (positionStart <= itemCount) {
          itemCount += itemCount;
        }
        positionStart = (k + positionStart);
        localArrayList.set(j, localUpdateOp3);
        localArrayList.set(i1, localUpdateOp2);
      }
    }
    int j = 1;
    label268:
    label344:
    label369:
    label491:
    label567:
    label655:
    label780:
    label958:
    label1002:
    label1027:
    label1149:
    label1227:
    label1251:
    label1458:
    label1526:
    label1835:
    for (;;)
    {
      i -= 1;
      break label24;
      j = -1;
      break label53;
      UpdateOp localUpdateOp1 = null;
      int m = 0;
      int n;
      if (positionStart < itemCount)
      {
        n = 0;
        k = n;
        i = m;
        if (positionStart == positionStart)
        {
          k = n;
          i = m;
          if (itemCount == itemCount - positionStart)
          {
            i = 1;
            k = n;
          }
        }
        if (itemCount >= positionStart) {
          break label491;
        }
        positionStart -= 1;
        if (positionStart > positionStart) {
          break label567;
        }
        positionStart += 1;
      }
      int i2;
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localUpdateOp3);
        localArrayList.remove(i1);
        mCallback.recycleUpdateOp(localUpdateOp2);
        break;
        n = 1;
        k = n;
        i = m;
        if (positionStart != itemCount + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (itemCount != positionStart - itemCount) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        if (itemCount >= positionStart + itemCount) {
          break label369;
        }
        itemCount -= 1;
        cmd = 2;
        itemCount = 1;
        if (itemCount != 0) {
          break;
        }
        localArrayList.remove(i1);
        mCallback.recycleUpdateOp(localUpdateOp3);
        break;
        if (positionStart < positionStart + itemCount)
        {
          m = positionStart;
          n = itemCount;
          i2 = positionStart;
          localUpdateOp1 = mCallback.obtainUpdateOp(2, positionStart + 1, m + n - i2, null);
          itemCount = (positionStart - positionStart);
        }
      }
      if (k != 0)
      {
        if (localUpdateOp1 != null)
        {
          if (positionStart > positionStart) {
            positionStart -= itemCount;
          }
          if (itemCount > positionStart) {
            itemCount -= itemCount;
          }
        }
        if (positionStart > positionStart) {
          positionStart -= itemCount;
        }
        if (itemCount > positionStart) {
          itemCount -= itemCount;
        }
        localArrayList.set(j, localUpdateOp3);
        if (positionStart == itemCount) {
          break label958;
        }
        localArrayList.set(i1, localUpdateOp2);
      }
      while (localUpdateOp1 != null)
      {
        localArrayList.add(j, localUpdateOp1);
        break;
        if (localUpdateOp1 != null)
        {
          if (positionStart >= positionStart) {
            positionStart -= itemCount;
          }
          if (itemCount >= positionStart) {
            itemCount -= itemCount;
          }
        }
        if (positionStart >= positionStart) {
          positionStart -= itemCount;
        }
        if (itemCount < positionStart) {
          break label780;
        }
        itemCount -= itemCount;
        break label780;
        localArrayList.remove(i1);
      }
      localUpdateOp1 = null;
      Object localObject = null;
      if (itemCount < positionStart)
      {
        positionStart -= 1;
        if (positionStart > positionStart) {
          break label1149;
        }
        positionStart += 1;
        localArrayList.set(i1, localUpdateOp2);
        if (itemCount <= 0) {
          break label1227;
        }
        localArrayList.set(j, localUpdateOp3);
      }
      for (;;)
      {
        if (localUpdateOp1 != null) {
          localArrayList.add(j, localUpdateOp1);
        }
        if (localObject == null) {
          break;
        }
        localArrayList.add(j, localObject);
        break;
        if (itemCount >= positionStart + itemCount) {
          break label1002;
        }
        itemCount -= 1;
        localUpdateOp1 = mCallback.obtainUpdateOp(4, positionStart, 1, payload);
        break label1002;
        if (positionStart >= positionStart + itemCount) {
          break label1027;
        }
        i = positionStart + itemCount - positionStart;
        localObject = mCallback.obtainUpdateOp(4, positionStart + 1, i, payload);
        itemCount -= i;
        break label1027;
        localArrayList.remove(j);
        mCallback.recycleUpdateOp(localUpdateOp3);
      }
      int i3 = mPendingUpdates.size();
      i1 = 0;
      if (i1 < i3)
      {
        localUpdateOp1 = (UpdateOp)mPendingUpdates.get(i1);
        switch (cmd)
        {
        }
        for (;;)
        {
          if (mOnItemProcessedCallback != null) {
            mOnItemProcessedCallback.run();
          }
          i1 += 1;
          break;
          postponeAndUpdateViewHolders(localUpdateOp1);
          continue;
          int i4 = positionStart;
          i = positionStart;
          k = itemCount + i;
          i2 = -1;
          i = positionStart;
          n = 0;
          if (i < k)
          {
            j = 0;
            m = 0;
            if ((mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
            {
              if (i2 == 0)
              {
                dispatchAndUpdateViewHolders(obtainUpdateOp(2, i4, n, null));
                m = 1;
              }
              j = 1;
              if (m == 0) {
                break label1526;
              }
              m = i - n;
              i = k - n;
            }
            for (k = 1;; k = n)
            {
              n = k;
              k = i;
              i = m + 1;
              i2 = j;
              break;
              if (i2 == 1)
              {
                postponeAndUpdateViewHolders(obtainUpdateOp(2, i4, n, null));
                j = 1;
              }
              i2 = 0;
              m = j;
              j = i2;
              break label1458;
              n += 1;
              m = i;
              i = k;
            }
          }
          localObject = localUpdateOp1;
          if (n != itemCount)
          {
            recycleUpdateOp(localUpdateOp1);
            localObject = obtainUpdateOp(2, i4, n, null);
          }
          if (i2 == 0)
          {
            dispatchAndUpdateViewHolders((UpdateOp)localObject);
          }
          else
          {
            postponeAndUpdateViewHolders((UpdateOp)localObject);
            continue;
            k = positionStart;
            i4 = positionStart;
            int i5 = itemCount;
            i = positionStart;
            j = 0;
            i2 = -1;
            if (i < i4 + i5)
            {
              if ((mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
              {
                m = j;
                n = k;
                if (i2 == 0)
                {
                  dispatchAndUpdateViewHolders(obtainUpdateOp(4, k, j, payload));
                  m = 0;
                  n = i;
                }
                k = n;
              }
              for (j = 1;; j = 0)
              {
                i += 1;
                m += 1;
                i2 = j;
                j = m;
                break;
                m = j;
                n = k;
                if (i2 == 1)
                {
                  postponeAndUpdateViewHolders(obtainUpdateOp(4, k, j, payload));
                  m = 0;
                  n = i;
                }
                k = n;
              }
            }
            localObject = localUpdateOp1;
            if (j != itemCount)
            {
              localObject = payload;
              recycleUpdateOp(localUpdateOp1);
              localObject = obtainUpdateOp(4, k, j, localObject);
            }
            if (i2 == 0)
            {
              dispatchAndUpdateViewHolders((UpdateOp)localObject);
            }
            else
            {
              postponeAndUpdateViewHolders((UpdateOp)localObject);
              continue;
              postponeAndUpdateViewHolders(localUpdateOp1);
            }
          }
        }
      }
      mPendingUpdates.clear();
      return;
    }
  }
  
  public final void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!mDisableRecycler)
    {
      payload = null;
      mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  final void reset()
  {
    recycleUpdateOpsAndClearList(mPendingUpdates);
    recycleUpdateOpsAndClearList(mPostponedList);
    mExistingUpdateTypes = 0;
  }
  
  static abstract interface Callback
  {
    public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);
    
    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);
    
    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);
    
    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }
  
  static final class UpdateOp
  {
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;
    
    UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      cmd = paramInt1;
      positionStart = paramInt2;
      itemCount = paramInt3;
      payload = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
              return false;
            }
            paramObject = (UpdateOp)paramObject;
            if (cmd != cmd) {
              return false;
            }
          } while ((cmd == 8) && (Math.abs(itemCount - positionStart) == 1) && (itemCount == positionStart) && (positionStart == itemCount));
          if (itemCount != itemCount) {
            return false;
          }
          if (positionStart != positionStart) {
            return false;
          }
          if (payload == null) {
            break;
          }
        } while (payload.equals(payload));
        return false;
      } while (payload == null);
      return false;
    }
    
    public final int hashCode()
    {
      return (cmd * 31 + positionStart) * 31 + itemCount;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (cmd)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        str = "??";
      }
      for (;;)
      {
        return str + ",s:" + positionStart + "c:" + itemCount + ",p:" + payload + "]";
        str = "add";
        continue;
        str = "rm";
        continue;
        str = "up";
        continue;
        str = "mv";
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AdapterHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */