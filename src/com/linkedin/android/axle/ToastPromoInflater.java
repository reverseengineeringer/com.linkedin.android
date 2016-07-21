package com.linkedin.android.axle;

import android.view.ViewGroup;
import com.linkedin.CrossPromoLib.api.PromoBase.BasePromo;
import com.linkedin.CrossPromoLib.api.PromoInflater;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.crosspromo.fe.api.android.Promo;

public final class ToastPromoInflater
  extends PromoInflater
{
  private final Bus bus;
  
  public ToastPromoInflater(ViewGroup paramViewGroup, Bus paramBus)
  {
    super(paramViewGroup);
    bus = paramBus;
  }
  
  public static boolean isToastPromo(Promo paramPromo)
  {
    return (paramPromo != null) && ("toast".equals(tType));
  }
  
  public final BasePromo getPromo(PromoSource paramPromoSource)
  {
    ToastPromo localToastPromo = null;
    if (getPromoModelpromo == null) {
      return null;
    }
    if ("toast".equals(getPromoModelpromo.tType)) {
      localToastPromo = new ToastPromo(paramPromoSource, bus);
    }
    return localToastPromo;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromoInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */