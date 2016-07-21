package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class MainAbiSplashViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<MainAbiSplashViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968797;
    }
  };
  @InjectView(2131755959)
  TextView abiSplashDisclaimerText;
  @InjectView(2131755964)
  TextView abiSplashHeadingText;
  @InjectView(2131755960)
  TextView learnMoreButton;
  
  public MainAbiSplashViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */