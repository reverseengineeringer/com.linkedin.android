package com.linkedin.android.growth.boost.splash;

import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class BoostSplashFragmentViewModel
  extends ViewModel<BoostSplashFragmentViewHolder>
{
  public String body;
  public String footer;
  public String heading;
  
  public final ViewHolderCreator<BoostSplashFragmentViewHolder> getCreator()
  {
    return BoostSplashFragmentViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$2889d6ff(BoostSplashFragmentViewHolder paramBoostSplashFragmentViewHolder)
  {
    messageHeading.setText(heading);
    messageBody.setText(body);
    messageFooter.setText(footer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragmentViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */