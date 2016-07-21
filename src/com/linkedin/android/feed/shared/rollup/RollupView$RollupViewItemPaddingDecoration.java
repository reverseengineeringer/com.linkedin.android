package com.linkedin.android.feed.shared.rollup;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;

final class RollupView$RollupViewItemPaddingDecoration
  extends RecyclerView.ItemDecoration
{
  private Context context;
  private int inset;
  
  private RollupView$RollupViewItemPaddingDecoration(Context paramContext, int paramInt)
  {
    context = paramContext;
    inset = paramInt;
  }
  
  public final void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    boolean bool = JellyBeanMr1Utils.isRTL(context);
    int i;
    if (bool)
    {
      i = 0;
      if (!bool) {
        break label53;
      }
    }
    label53:
    for (int j = inset;; j = 0)
    {
      if (RecyclerView.getChildAdapterPosition(paramView) != 0) {
        break label59;
      }
      paramRect.set(0, 0, 0, 0);
      return;
      i = inset;
      break;
    }
    label59:
    paramRect.set(i, 0, j, 0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.rollup.RollupView.RollupViewItemPaddingDecoration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */