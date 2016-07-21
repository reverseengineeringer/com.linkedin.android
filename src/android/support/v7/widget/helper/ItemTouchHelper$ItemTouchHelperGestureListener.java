package android.support.v7.widget.helper;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public final class ItemTouchHelper$ItemTouchHelperGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private ItemTouchHelper$ItemTouchHelperGestureListener(ItemTouchHelper paramItemTouchHelper) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    Object localObject = this$0.findChildView(paramMotionEvent);
    if (localObject != null)
    {
      localObject = this$0.mRecyclerView.getChildViewHolder((View)localObject);
      if ((localObject != null) && (ItemTouchHelper.Callback.access$2100(this$0.mCallback, this$0.mRecyclerView, (RecyclerView.ViewHolder)localObject))) {
        break label57;
      }
    }
    label57:
    while (MotionEventCompat.getPointerId(paramMotionEvent, 0) != this$0.mActivePointerId) {
      return;
    }
    int i = MotionEventCompat.findPointerIndex(paramMotionEvent, this$0.mActivePointerId);
    float f1 = MotionEventCompat.getX(paramMotionEvent, i);
    float f2 = MotionEventCompat.getY(paramMotionEvent, i);
    this$0.mInitialTouchX = f1;
    this$0.mInitialTouchY = f2;
    paramMotionEvent = this$0;
    this$0.mDy = 0.0F;
    mDx = 0.0F;
    ItemTouchHelper.Callback.isLongPressDragEnabled();
    this$0.select((RecyclerView.ViewHolder)localObject, 2);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.ItemTouchHelperGestureListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */