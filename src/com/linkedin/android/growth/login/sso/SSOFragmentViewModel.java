package com.linkedin.android.growth.login.sso;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.ImageRequest.ImageRequestListener;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class SSOFragmentViewModel
  extends ViewModel<SSOFragmentViewHolder>
{
  public View.OnClickListener continueListener;
  public String continueText;
  public View.OnClickListener joinNowListener;
  public String profilePictureUrl;
  public View.OnClickListener signInListener;
  public String signInText;
  
  public final ViewHolderCreator<SSOFragmentViewHolder> getCreator()
  {
    return SSOFragmentViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, final SSOFragmentViewHolder paramSSOFragmentViewHolder)
  {
    if (!TextUtils.isEmpty(profilePictureUrl))
    {
      GhostImage localGhostImage = GhostImageUtils.getAnonymousPerson(2131492962);
      paramMediaCenter = paramMediaCenter.loadUrl(profilePictureUrl).into(profilePicture);
      placeholderDrawable = localGhostImage.getDrawable(paramLayoutInflater.getContext());
      requestListener = new ImageRequest.ImageRequestListener()
      {
        public final void onErrorResponse(Object paramAnonymousObject, String paramAnonymousString, Exception paramAnonymousException)
        {
          paramSSOFragmentViewHolderprofilePicture.setVisibility(8);
          paramSSOFragmentViewHolderplusIcon.setVisibility(8);
        }
        
        public final void onResponse(Object paramAnonymousObject, String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
        {
          paramSSOFragmentViewHolderprofilePicture.setVisibility(0);
          paramSSOFragmentViewHolderplusIcon.setVisibility(0);
        }
      };
    }
    for (;;)
    {
      continueButton.setText(continueText);
      continueButton.setOnClickListener(continueListener);
      signIn.setText(signInText);
      signIn.setOnClickListener(signInListener);
      joinNow.setOnClickListener(joinNowListener);
      return;
      profilePicture.setVisibility(8);
      plusIcon.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.sso.SSOFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */