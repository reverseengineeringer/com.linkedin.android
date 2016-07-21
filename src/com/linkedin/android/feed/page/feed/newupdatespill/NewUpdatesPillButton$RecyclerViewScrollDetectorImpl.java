package com.linkedin.android.feed.page.feed.newupdatespill;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public final class NewUpdatesPillButton$RecyclerViewScrollDetectorImpl
  extends NewUpdatesPillButton.RecyclerViewScrollDetector
{
  private RecyclerView.OnScrollListener onScrollListener;
  
  private NewUpdatesPillButton$RecyclerViewScrollDetectorImpl(NewUpdatesPillButton paramNewUpdatesPillButton)
  {
    super(paramNewUpdatesPillButton, (byte)0);
  }
  
  public final void onScrollDown()
  {
    NewUpdatesPillButton.access$200$13e22efd(this$0);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (onScrollListener != null) {
      onScrollListener.onScrollStateChanged(paramRecyclerView, paramInt);
    }
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public final void onScrollUp()
  {
    if (NewUpdatesPillButton.access$300(this$0)) {
      NewUpdatesPillButton.access$400$13e22efd(this$0);
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (onScrollListener != null) {
      onScrollListener.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    }
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton.RecyclerViewScrollDetectorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */