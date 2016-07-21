package com.linkedin.android.growth.abi.splash;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;

public final class AcceptInviteAbiSplashViewModel
  extends ViewModel<AcceptInviteAbiSplashViewHolder>
{
  public String disclaimerText;
  public CharSequence headingText;
  public View.OnClickListener learnMoreListener;
  public ImageModel profileImage;
  public String rationaleMessageText;
  public View.OnClickListener viewProfileClickListener;
  public CharSequence viewProfileText;
  
  public final ViewHolderCreator<AcceptInviteAbiSplashViewHolder> getCreator()
  {
    return AcceptInviteAbiSplashViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$6427a5a2(MediaCenter paramMediaCenter, AcceptInviteAbiSplashViewHolder paramAcceptInviteAbiSplashViewHolder)
  {
    heading.setText(headingText);
    profileImage.setImageView(paramMediaCenter, profileImage);
    viewProfile.setText(viewProfileText);
    viewProfile.setOnClickListener(viewProfileClickListener);
    rationalMessage.setText(rationaleMessageText);
    disclaimer.setText(disclaimerText);
    learnMore.setOnClickListener(learnMoreListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AcceptInviteAbiSplashViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */