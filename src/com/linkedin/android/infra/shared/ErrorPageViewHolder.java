package com.linkedin.android.infra.shared;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class ErrorPageViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<ErrorPageViewHolder> CREATOR = new ErrorPageViewHolder.1();
  @InjectView(2131756536)
  Button errorActionButton;
  @InjectView(2131756535)
  TextView errorDescriptionTextView;
  @InjectView(2131756534)
  TextView errorHeaderTextView;
  @InjectView(2131756533)
  ImageView errorImage;
  
  public ErrorPageViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.ErrorPageViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */