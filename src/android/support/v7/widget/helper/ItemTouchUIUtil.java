package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract interface ItemTouchUIUtil
{
  public abstract void clearView(View paramView);
  
  public abstract void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  public abstract void onDrawOver$3d9af585(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt);
  
  public abstract void onSelected(View paramView);
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchUIUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */