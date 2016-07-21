package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class AcceptInviteAbiSplashViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<AcceptInviteAbiSplashViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968802;
    }
  };
  @InjectView(2131755959)
  TextView disclaimer;
  @InjectView(2131755968)
  TextView heading;
  @InjectView(2131755960)
  TextView learnMore;
  @InjectView(2131755979)
  ImageView profileImage;
  @InjectView(2131755970)
  TextView rationalMessage;
  @InjectView(2131755969)
  TextView viewProfile;
  
  public AcceptInviteAbiSplashViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AcceptInviteAbiSplashViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */