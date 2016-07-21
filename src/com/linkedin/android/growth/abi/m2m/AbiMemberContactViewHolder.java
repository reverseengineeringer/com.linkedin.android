package com.linkedin.android.growth.abi.m2m;

import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.ui.TintableImageView;

public class AbiMemberContactViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<AbiMemberContactViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968784;
    }
  };
  @InjectView(2131755945)
  @Optional
  TintableImageView connectButtonInternational;
  @InjectView(2131755946)
  @Optional
  TextView connectText;
  @InjectView(2131755944)
  View invitationIconContainer;
  @InjectView(2131755910)
  @Optional
  AppCompatImageButton inviteButtonInternationalClicked;
  @InjectView(2131755947)
  @Optional
  Button invitedText;
  @InjectView(2131755929)
  View m2mItemContainer;
  @InjectView(2131755930)
  ImageView picture;
  @InjectView(2131755933)
  TextView subtitle;
  @InjectView(2131755932)
  TextView title;
  
  public AbiMemberContactViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.AbiMemberContactViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */