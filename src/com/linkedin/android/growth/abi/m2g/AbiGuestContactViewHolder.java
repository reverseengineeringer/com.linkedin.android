package com.linkedin.android.growth.abi.m2g;

import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.ui.TintableImageView;

public class AbiGuestContactViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<AbiGuestContactViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968783;
    }
  };
  @InjectView(2131755946)
  @Optional
  TextView connectText;
  @InjectView(2131755944)
  View invitationIconContainer;
  @InjectView(2131755945)
  @Optional
  TintableImageView inviteButtonInternational;
  @InjectView(2131755910)
  @Optional
  AppCompatImageButton inviteButtonInternationalClicked;
  @InjectView(2131755947)
  @Optional
  Button invitedText;
  @InjectView(2131755921)
  View m2gItemContainer;
  @InjectView(2131755922)
  FrameLayout m2gItemPictureContainer;
  @InjectView(2131755923)
  ImageView m2gItemPictureImageView;
  @InjectView(2131755924)
  TextView m2gItemPictureTextView;
  @InjectView(2131755928)
  TextView subtitle;
  @InjectView(2131755927)
  TextView title;
  
  public AbiGuestContactViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.AbiGuestContactViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */