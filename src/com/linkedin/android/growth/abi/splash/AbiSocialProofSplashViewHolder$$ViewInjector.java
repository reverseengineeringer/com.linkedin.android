package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AbiSocialProofSplashViewHolder$$ViewInjector<T extends AbiSocialProofSplashViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    subheader = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755977, "field 'subheader'"), 2131755977, "field 'subheader'"));
    socialProofImagesContainer = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755971, "field 'socialProofImagesContainer'"), 2131755971, "field 'socialProofImagesContainer'"));
  }
  
  public void reset(T paramT)
  {
    subheader = null;
    socialProofImagesContainer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AbiSocialProofSplashViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */