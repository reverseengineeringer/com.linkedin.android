package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import java.util.ArrayList;
import java.util.List;

public final class AbiSocialProofSplashViewModel
  extends ViewModel<AbiSocialProofSplashViewHolder>
{
  public MainAbiSplashViewModel mainAbiSplashViewModel;
  public List<ImageModel> socialProofImages = new ArrayList();
  public String subheaderText;
  
  public final ViewHolderCreator<AbiSocialProofSplashViewHolder> getCreator()
  {
    return AbiSocialProofSplashViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$2ba32518(MediaCenter paramMediaCenter, AbiSocialProofSplashViewHolder paramAbiSocialProofSplashViewHolder)
  {
    subheader.setText(subheaderText);
    List localList = socialProofImages;
    int i = 0;
    int j = socialProofImagesContainer.getChildCount() - 1;
    View localView;
    int k;
    if (j >= 0)
    {
      localView = socialProofImagesContainer.getChildAt(j);
      k = i;
      if ((localView instanceof ImageView))
      {
        if ((localList == null) || (i >= localList.size())) {
          break label121;
        }
        ImageModel localImageModel = (ImageModel)localList.get(i);
        if (localImageModel == null) {
          break label162;
        }
        localImageModel.setImageView(paramMediaCenter, (ImageView)localView);
        i += 1;
      }
    }
    label121:
    label162:
    for (;;)
    {
      for (k = i;; k = i)
      {
        j -= 1;
        i = k;
        break;
        ((ImageView)localView).setImageDrawable(GhostImageUtils.getAnonymousPerson(2131492967).getDrawable(socialProofImagesContainer.getContext()));
      }
      mainAbiSplashViewModel.onBindViewHolder$70b7bbd6(mainAbiSplashViewHolder);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSocialProofSplashViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */