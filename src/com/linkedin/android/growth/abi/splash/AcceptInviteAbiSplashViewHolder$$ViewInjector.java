package com.linkedin.android.growth.abi.splash;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AcceptInviteAbiSplashViewHolder$$ViewInjector<T extends AcceptInviteAbiSplashViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    heading = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755968, "field 'heading'"), 2131755968, "field 'heading'"));
    profileImage = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755979, "field 'profileImage'"), 2131755979, "field 'profileImage'"));
    viewProfile = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755969, "field 'viewProfile'"), 2131755969, "field 'viewProfile'"));
    learnMore = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755960, "field 'learnMore'"), 2131755960, "field 'learnMore'"));
    rationalMessage = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755970, "field 'rationalMessage'"), 2131755970, "field 'rationalMessage'"));
    disclaimer = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755959, "field 'disclaimer'"), 2131755959, "field 'disclaimer'"));
  }
  
  public void reset(T paramT)
  {
    heading = null;
    profileImage = null;
    viewProfile = null;
    learnMore = null;
    rationalMessage = null;
    disclaimer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.splash.AcceptInviteAbiSplashViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */