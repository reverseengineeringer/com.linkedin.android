package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

final class RecyclerView$AdapterDataObservable
  extends Observable<RecyclerView.AdapterDataObserver>
{
  public final boolean hasObservers()
  {
    return !mObservers.isEmpty();
  }
  
  public final void notifyChanged()
  {
    int i = mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onChanged();
      i -= 1;
    }
  }
  
  public final void notifyItemMoved(int paramInt1, int paramInt2)
  {
    int i = mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
      i -= 1;
    }
  }
  
  public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    notifyItemRangeChanged(paramInt1, paramInt2, null);
  }
  
  public final void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
      i -= 1;
    }
  }
  
  public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    int i = mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    int i = mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
      i -= 1;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.AdapterDataObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */