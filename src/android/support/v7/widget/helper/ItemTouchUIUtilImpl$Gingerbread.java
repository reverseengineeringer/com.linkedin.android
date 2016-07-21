package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class ItemTouchUIUtilImpl$Gingerbread
  implements ItemTouchUIUtil
{
  private static void draw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramRecyclerView.drawChild(paramCanvas, paramView, 0L);
    paramCanvas.restore();
  }
  
  public final void clearView(View paramView)
  {
    paramView.setVisibility(0);
  }
  
  public final void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2) {
      draw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2);
    }
  }
  
  public final void onDrawOver$3d9af585(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt == 2) {
      draw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2);
    }
  }
  
  public final void onSelected(View paramView)
  {
    paramView.setVisibility(4);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchUIUtilImpl.Gingerbread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */