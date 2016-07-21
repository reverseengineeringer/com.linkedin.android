package com.linkedin.android.axle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.infra.FragmentReferencingStatePagerAdapter;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.crosspromo.fe.api.android.SubPromo;
import java.util.List;

public final class SplashPromoViewPagerAdapter
  extends FragmentReferencingStatePagerAdapter
{
  protected SplashPromo promoTemplate;
  
  public SplashPromoViewPagerAdapter(SplashPromo paramSplashPromo, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    promoTemplate = paramSplashPromo;
  }
  
  public final int getCount()
  {
    List localList = promoTemplate.getPromoModel().promo.subPromos;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final Fragment getItem(int paramInt)
  {
    SplashPromoPagerFragment localSplashPromoPagerFragment = new SplashPromoPagerFragment();
    SplashPromo localSplashPromo = promoTemplate;
    SubPromo localSubPromo = (SubPromo)promoTemplate.getPromoModel().promo.subPromos.get(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      promoTemplate = localSplashPromo;
      subPromo = localSubPromo;
      isFirstCard = bool;
      return localSplashPromoPagerFragment;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoViewPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */