package com.linkedin.android.entities;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

final class EntityBaseTabFragment$1
  extends RecyclerView.OnScrollListener
{
  EntityBaseTabFragment$1(EntityBaseTabFragment paramEntityBaseTabFragment) {}
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if ((paramInt2 > 0) && (!EntityBaseTabFragment.access$000(this$0)) && (!EntityBaseTabFragment.access$100(this$0))) {
      EntityBaseTabFragment.access$200(this$0);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityBaseTabFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */