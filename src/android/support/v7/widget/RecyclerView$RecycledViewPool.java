package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool
{
  int mAttachCount = 0;
  private SparseIntArray mMaxScrap = new SparseIntArray();
  SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();
  
  final void attach$b0de1c8()
  {
    mAttachCount += 1;
  }
  
  final void detach()
  {
    mAttachCount -= 1;
  }
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)mScrap.get(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramInt = localArrayList.size() - 1;
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localArrayList.get(paramInt);
      localArrayList.remove(paramInt);
      return localViewHolder;
    }
    return null;
  }
  
  public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getItemViewType();
    Object localObject = (ArrayList)mScrap.get(i);
    if (localObject == null)
    {
      ArrayList localArrayList = new ArrayList();
      mScrap.put(i, localArrayList);
      localObject = localArrayList;
      if (mMaxScrap.indexOfKey(i) < 0)
      {
        mMaxScrap.put(i, 5);
        localObject = localArrayList;
      }
    }
    for (;;)
    {
      if (mMaxScrap.get(i) <= ((ArrayList)localObject).size()) {
        return;
      }
      paramViewHolder.resetInternal();
      ((ArrayList)localObject).add(paramViewHolder);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.RecycledViewPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */