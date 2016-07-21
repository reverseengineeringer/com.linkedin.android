package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class AbiSocialProofSplashViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<AbiSocialProofSplashViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968801;
    }
  };
  MainAbiSplashViewHolder mainAbiSplashViewHolder;
  @InjectView(2131755971)
  FrameLayout socialProofImagesContainer;
  @InjectView(2131755977)
  TextView subheader;
  
  public AbiSocialProofSplashViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSocialProofSplashViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */