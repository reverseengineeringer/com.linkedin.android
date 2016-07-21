package com.linkedin.android.infra;

import android.view.View;
import com.linkedin.android.infra.app.BaseViewHolder;

public abstract interface ViewHolderCreator<V extends BaseViewHolder>
{
  public abstract V createViewHolder(View paramView);
  
  public abstract int getLayoutId();
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.ViewHolderCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */