package com.linkedin.android.growth.abi.splash;

import android.view.View.OnClickListener;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class MainAbiSplashViewModel
  extends ViewModel<MainAbiSplashViewHolder>
{
  public String disclaimerText;
  public String headingText;
  public View.OnClickListener learnMoreListener;
  
  public final ViewHolderCreator<MainAbiSplashViewHolder> getCreator()
  {
    return MainAbiSplashViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$70b7bbd6(MainAbiSplashViewHolder paramMainAbiSplashViewHolder)
  {
    abiSplashHeadingText.setText(headingText);
    abiSplashDisclaimerText.setText(disclaimerText);
    learnMoreButton.setOnClickListener(learnMoreListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.MainAbiSplashViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */