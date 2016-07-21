package com.linkedin.android.feed.page.feed.newupdatespill;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public abstract class NewUpdatesPillButton$RecyclerViewScrollDetector
  extends RecyclerView.OnScrollListener
{
  public int scrollThreshold;
  
  private NewUpdatesPillButton$RecyclerViewScrollDetector(NewUpdatesPillButton paramNewUpdatesPillButton) {}
  
  abstract void onScrollDown();
  
  abstract void onScrollUp();
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (Math.abs(paramInt2) > scrollThreshold) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        if (paramInt2 <= 0) {
          break;
        }
        onScrollDown();
      }
      return;
    }
    onScrollUp();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton.RecyclerViewScrollDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */