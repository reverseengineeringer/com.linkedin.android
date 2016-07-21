package com.linkedin.android.feed.utils;

import android.support.v7.widget.RecyclerView;
import com.linkedin.android.infra.ArrayAdapter;

public final class FeedRecyclerViewUtils$1
  implements Runnable
{
  public FeedRecyclerViewUtils$1(RecyclerView paramRecyclerView, ArrayAdapter paramArrayAdapter) {}
  
  public final void run()
  {
    if ((val$recyclerView != null) && (val$adapter != null) && (val$adapter.getItemCount() > val$position)) {
      val$recyclerView.scrollToPosition(val$position);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedRecyclerViewUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */