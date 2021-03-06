package android.support.v7.widget;

import android.view.View;

final class ScrollbarHelper
{
  static int computeScrollExtent(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    if ((paramLayoutManager.getChildCount() == 0) || (paramState.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return Math.abs(RecyclerView.LayoutManager.getPosition(paramView1) - RecyclerView.LayoutManager.getPosition(paramView2)) + 1;
    }
    int i = paramOrientationHelper.getDecoratedEnd(paramView2);
    int j = paramOrientationHelper.getDecoratedStart(paramView1);
    return Math.min(paramOrientationHelper.getTotalSpace(), i - j);
  }
  
  static int computeScrollOffset(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int j = i;
    if (paramLayoutManager.getChildCount() != 0)
    {
      j = i;
      if (paramState.getItemCount() != 0)
      {
        j = i;
        if (paramView1 != null)
        {
          if (paramView2 != null) {
            break label45;
          }
          j = i;
        }
      }
    }
    return j;
    label45:
    i = Math.min(RecyclerView.LayoutManager.getPosition(paramView1), RecyclerView.LayoutManager.getPosition(paramView2));
    j = Math.max(RecyclerView.LayoutManager.getPosition(paramView1), RecyclerView.LayoutManager.getPosition(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, paramState.getItemCount() - j - 1);; i = Math.max(0, i))
    {
      j = i;
      if (!paramBoolean1) {
        break;
      }
      j = Math.abs(paramOrientationHelper.getDecoratedEnd(paramView2) - paramOrientationHelper.getDecoratedStart(paramView1));
      int k = Math.abs(RecyclerView.LayoutManager.getPosition(paramView1) - RecyclerView.LayoutManager.getPosition(paramView2));
      float f = j / (k + 1);
      return Math.round(i * f + (paramOrientationHelper.getStartAfterPadding() - paramOrientationHelper.getDecoratedStart(paramView1)));
    }
  }
  
  static int computeScrollRange(RecyclerView.State paramState, OrientationHelper paramOrientationHelper, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    if ((paramLayoutManager.getChildCount() == 0) || (paramState.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null)) {
      return 0;
    }
    if (!paramBoolean) {
      return paramState.getItemCount();
    }
    int i = paramOrientationHelper.getDecoratedEnd(paramView2);
    int j = paramOrientationHelper.getDecoratedStart(paramView1);
    int k = Math.abs(RecyclerView.LayoutManager.getPosition(paramView1) - RecyclerView.LayoutManager.getPosition(paramView2));
    return (int)((i - j) / (k + 1) * paramState.getItemCount());
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ScrollbarHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */