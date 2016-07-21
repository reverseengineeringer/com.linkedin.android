package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoInflater;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FeedPromoInflater
  extends PromoInflater
{
  private static final Set<String> HERO_TTYPES = new HashSet() {};
  private final Bus bus;
  private final AtomicBoolean dismissed;
  private FragmentComponent fragmentComponent;
  private BasePromo renderedPromo;
  
  public FeedPromoInflater(ViewGroup paramViewGroup, AtomicBoolean paramAtomicBoolean, Bus paramBus, FragmentComponent paramFragmentComponent)
  {
    super(paramViewGroup);
    dismissed = paramAtomicBoolean;
    bus = paramBus;
    fragmentComponent = paramFragmentComponent;
  }
  
  public static boolean isHeroPromo(Promo paramPromo)
  {
    return (paramPromo != null) && (HERO_TTYPES.contains(tType));
  }
  
  public final BasePromo getPromo(PromoSource paramPromoSource)
  {
    if (isHeroPromo(getPromoModelpromo)) {
      renderedPromo = new FeedSuperHeroPromo(paramPromoSource, dismissed, bus, fragmentComponent);
    }
    return renderedPromo;
  }
  
  public final void renderPromoModel(String paramString, Map<String, String> paramMap, PromoModel paramPromoModel)
  {
    renderedPromo = null;
    try
    {
      super.renderPromoModel(paramString, paramMap, paramPromoModel);
      return;
    }
    finally
    {
      if (renderedPromo == null)
      {
        dismissed.set(true);
        Bus.publish(new CrossPromoHeroViewModel.HeroDismissedEvent());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.FeedPromoInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */