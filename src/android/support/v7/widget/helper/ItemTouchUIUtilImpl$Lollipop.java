package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.id;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class ItemTouchUIUtilImpl$Lollipop
  extends ItemTouchUIUtilImpl.Honeycomb
{
  public final void clearView(View paramView)
  {
    Object localObject = paramView.getTag(R.id.item_touch_helper_previous_elevation);
    if ((localObject != null) && ((localObject instanceof Float))) {
      ViewCompat.setElevation(paramView, ((Float)localObject).floatValue());
    }
    paramView.setTag(R.id.item_touch_helper_previous_elevation, null);
    super.clearView(paramView);
  }
  
  public final void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    float f3;
    float f1;
    int i;
    if ((paramBoolean) && (paramView.getTag(R.id.item_touch_helper_previous_elevation) == null))
    {
      f3 = ViewCompat.getElevation(paramView);
      int j = paramRecyclerView.getChildCount();
      f1 = 0.0F;
      i = 0;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        if (localView == paramView) {
          break label118;
        }
        float f2 = ViewCompat.getElevation(localView);
        if (f2 <= f1) {
          break label118;
        }
        f1 = f2;
      }
    }
    label118:
    for (;;)
    {
      i += 1;
      break;
      ViewCompat.setElevation(paramView, 1.0F + f1);
      paramView.setTag(R.id.item_touch_helper_previous_elevation, Float.valueOf(f3));
      super.onDraw(paramCanvas, paramRecyclerView, paramView, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchUIUtilImpl.Lollipop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */