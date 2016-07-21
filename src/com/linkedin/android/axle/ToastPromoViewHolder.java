package com.linkedin.android.axle;

import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class ToastPromoViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<ToastPromoViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130969443;
    }
  };
  @InjectView(2131756510)
  public ViewGroup container;
  
  public ToastPromoViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromoViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */