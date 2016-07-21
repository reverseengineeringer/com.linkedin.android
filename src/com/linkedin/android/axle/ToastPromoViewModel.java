package com.linkedin.android.axle;

import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.crosspromo.fe.api.android.Promo;

public final class ToastPromoViewModel
  extends ViewModel<ToastPromoViewHolder>
{
  private final Bus bus;
  private final String pageKey;
  private ToastPromoInflater promoInflater;
  private final PromoModel promoModel;
  
  public ToastPromoViewModel(String paramString, Promo paramPromo, Bus paramBus)
  {
    pageKey = paramString;
    promoModel = new PromoModel(paramPromo);
    bus = paramBus;
  }
  
  public final ViewHolderCreator<ToastPromoViewHolder> getCreator()
  {
    return ToastPromoViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$3557d260(ToastPromoViewHolder paramToastPromoViewHolder)
  {
    promoInflater = new ToastPromoInflater(container, bus);
    promoInflater.renderPromoModel(pageKey, null, promoModel);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromoViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */