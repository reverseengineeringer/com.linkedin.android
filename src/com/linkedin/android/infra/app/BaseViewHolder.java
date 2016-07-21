package com.linkedin.android.infra.app;

import android.support.v7.widget.CustomTypeViewHolder;
import android.view.View;
import butterknife.ButterKnife;

public abstract class BaseViewHolder
  extends CustomTypeViewHolder
{
  public BaseViewHolder(View paramView)
  {
    this(paramView, true);
  }
  
  public BaseViewHolder(View paramView, boolean paramBoolean)
  {
    super(paramView);
    if (paramBoolean) {
      ButterKnife.inject(this, paramView);
    }
  }
  
  public String toString()
  {
    return super.toString() + " with class name: " + getClass().getName();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */