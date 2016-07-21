package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;

final class ItemTouchHelper$5
  implements RecyclerView.ChildDrawingOrderCallback
{
  ItemTouchHelper$5(ItemTouchHelper paramItemTouchHelper) {}
  
  public final int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this$0.mOverdrawChild == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = this$0.mOverdrawChildPosition;
      i = j;
      if (j == -1)
      {
        i = this$0.mRecyclerView.indexOfChild(this$0.mOverdrawChild);
        this$0.mOverdrawChildPosition = i;
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */