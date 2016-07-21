package com.linkedin.android.infra;

import com.linkedin.android.infra.app.BaseAdapter;
import javax.inject.Inject;

public final class LoadingAdapter
  extends BaseAdapter<LoadingViewHolder>
{
  private boolean isVisible = true;
  
  @Inject
  public LoadingAdapter()
  {
    setHasStableIds(true);
  }
  
  public final int getItemCount()
  {
    if (isVisible) {
      return 1;
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return 2131755023L;
  }
  
  public final void setLoading(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = isVisible;
    isVisible = paramBoolean1;
    if ((bool) && (!isVisible)) {
      if (paramBoolean2) {
        notifyDataSetChanged();
      }
    }
    while ((bool) || (!isVisible))
    {
      return;
      notifyItemRemoved(0);
      return;
    }
    if (paramBoolean2)
    {
      notifyDataSetChanged();
      return;
    }
    notifyItemInserted(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.LoadingAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */