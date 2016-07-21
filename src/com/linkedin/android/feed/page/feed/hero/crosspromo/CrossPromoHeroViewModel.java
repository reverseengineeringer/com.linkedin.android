package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoTracker;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CrossPromoHeroViewModel
  extends FeedItemViewModel<CrossPromoHeroViewHolder>
{
  private final Bus bus;
  private final AtomicBoolean dismissed;
  private FragmentComponent fragmentComponent;
  private final AtomicBoolean impressed;
  private final String pageKey;
  private FeedPromoInflater promoInflater;
  private final PromoModel promoModel;
  
  public CrossPromoHeroViewModel(String paramString, Promo paramPromo, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2, Bus paramBus, FragmentComponent paramFragmentComponent)
  {
    dismissed = paramAtomicBoolean1;
    impressed = paramAtomicBoolean2;
    pageKey = paramString;
    promoModel = new PromoModel(paramPromo);
    bus = paramBus;
    fragmentComponent = paramFragmentComponent;
  }
  
  public final ViewHolderCreator<CrossPromoHeroViewHolder> getCreator()
  {
    return CrossPromoHeroViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$1c57c46f(CrossPromoHeroViewHolder paramCrossPromoHeroViewHolder)
  {
    if (dismissed.get())
    {
      container.removeAllViews();
      return;
    }
    promoInflater = new FeedPromoInflater(container, dismissed, bus, fragmentComponent);
    promoInflater.renderPromoModel(pageKey, null, promoModel);
  }
  
  public final void trackImpression()
  {
    if ((promoInflater != null) && (promoModel.promo != null) && (!dismissed.get()) && (impressed.compareAndSet(false, true))) {
      FeedPromoInflater.getPromoTracker().trackImpression(promoModel, null, null);
    }
  }
  
  public static final class HeroDismissedEvent {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */