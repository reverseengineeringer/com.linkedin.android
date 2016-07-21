package com.linkedin.android.feed.page.feed.newupdatespill;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;

public final class NewUpdatesDividerDecoration
  extends RecyclerView.ItemDecoration
{
  private View divider;
  public String lastRecentUpdateUrn;
  public boolean measured;
  
  public NewUpdatesDividerDecoration(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private NewUpdatesDividerDecoration(Context paramContext, byte paramByte)
  {
    divider = LayoutInflater.from(paramContext).inflate(2130968762, null);
  }
  
  private void measureDivider(View paramView)
  {
    int i = paramView.getWidth();
    int j = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    divider.measure(j, k);
    j = divider.getMeasuredHeight();
    divider.layout(0, 0, i, j);
    measured = true;
  }
  
  private boolean shouldShowDividerAfterView(View paramView, RecyclerView paramRecyclerView)
  {
    if (lastRecentUpdateUrn == null) {}
    for (;;)
    {
      return false;
      int i = RecyclerView.getChildAdapterPosition(paramView);
      if (i != -1)
      {
        paramView = paramRecyclerView.getAdapter();
        if ((paramView instanceof FeedAdapter))
        {
          paramRecyclerView = (FeedAdapter)paramView;
          if (paramRecyclerView.getItemCount() > i + 1)
          {
            paramView = (FeedItemViewModel)paramRecyclerView.getItemAtPosition(i);
            if ((paramView instanceof FeedUpdateViewModel)) {}
            for (paramView = updateUrn; (paramView != null) && (paramView.equals(lastRecentUpdateUrn)); paramView = null) {
              return paramRecyclerView.getItemAtPosition(i + 1) instanceof FeedUpdateViewModel;
            }
          }
        }
      }
    }
  }
  
  public final void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (!shouldShowDividerAfterView(paramView, paramRecyclerView))
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (!measured) {
      measureDivider(paramRecyclerView);
    }
    paramRect.set(0, 0, 0, divider.getHeight());
  }
  
  public final void onDraw$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if (lastRecentUpdateUrn == null) {}
    for (;;)
    {
      return;
      if (!measured) {
        measureDivider(paramRecyclerView);
      }
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        if (shouldShowDividerAfterView(localView, paramRecyclerView))
        {
          RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
          int k = localView.getBottom();
          int m = bottomMargin;
          paramCanvas.save();
          paramCanvas.translate(0.0F, k + m);
          divider.draw(paramCanvas);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesDividerDecoration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */