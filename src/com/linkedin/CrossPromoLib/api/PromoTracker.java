package com.linkedin.CrossPromoLib.api;

import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;

public abstract interface PromoTracker
{
  public abstract void trackAction(PromoModel paramPromoModel, MetricsInfo paramMetricsInfo, Runnable paramRunnable);
  
  public abstract void trackImpression(PromoModel paramPromoModel, MetricsInfo paramMetricsInfo, Runnable paramRunnable);
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */