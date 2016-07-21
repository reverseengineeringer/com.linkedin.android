package com.linkedin.android.axle;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoInflater;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.HashSet;
import java.util.Set;

public final class SplashPromoInflater
  extends PromoInflater
{
  private static final Set<String> SPLASH_TTYPES = new HashSet() {};
  private FragmentComponent fragmentComponent;
  private boolean isDogfoodSplash;
  
  public SplashPromoInflater(ViewGroup paramViewGroup, FragmentComponent paramFragmentComponent)
  {
    this(paramViewGroup, paramFragmentComponent, false);
  }
  
  public SplashPromoInflater(ViewGroup paramViewGroup, FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    super(paramViewGroup);
    fragmentComponent = paramFragmentComponent;
    isDogfoodSplash = paramBoolean;
    activityapplicationComponent.crossPromoManager();
  }
  
  public static boolean isSplashPromo(Promo paramPromo)
  {
    return (paramPromo != null) && (SPLASH_TTYPES.contains(tType));
  }
  
  public final BasePromo getPromo(PromoSource paramPromoSource)
  {
    SplashPromo localSplashPromo = null;
    if (getPromoModelpromo == null) {}
    while ((fragmentComponent.fragment().getActivity() == null) || (fragmentComponent.fragment().getResources().getConfiguration().orientation != 1)) {
      return null;
    }
    String str = getPromoModelpromo.tType;
    if (SPLASH_TTYPES.contains(str)) {
      localSplashPromo = new SplashPromo(paramPromoSource, fragmentComponent, isDogfoodSplash);
    }
    return localSplashPromo;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */