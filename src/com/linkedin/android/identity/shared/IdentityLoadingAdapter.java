package com.linkedin.android.identity.shared;

import com.linkedin.android.infra.LoadingViewHolder;
import com.linkedin.android.infra.app.BaseAdapter;
import javax.inject.Inject;

public final class IdentityLoadingAdapter
  extends BaseAdapter<LoadingViewHolder>
{
  private boolean isVisible;
  
  @Inject
  public IdentityLoadingAdapter()
  {
    setHasStableIds(true);
  }
  
  public final int getItemCount()
  {
    return 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return 2131755023L;
  }
  
  public final void setLoading(boolean paramBoolean)
  {
    if (isVisible != paramBoolean)
    {
      isVisible = paramBoolean;
      notifyItemChanged(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.shared.IdentityLoadingAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */