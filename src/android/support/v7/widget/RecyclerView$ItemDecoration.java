package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public abstract class RecyclerView$ItemDecoration
{
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    getLayoutParamsmViewHolder.getLayoutPosition();
    paramRect.set(0, 0, 0, 0);
  }
  
  public void onDraw$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
  
  public void onDrawOver$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView.ItemDecoration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */