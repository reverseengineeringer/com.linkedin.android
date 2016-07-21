package com.linkedin.CrossPromoLib.api.PromoBase;

import com.linkedin.CrossPromoLib.api.PromoInflater;
import com.linkedin.CrossPromoLib.api.PromoSource;
import com.linkedin.CrossPromoLib.api.PromoTracker;
import com.linkedin.CrossPromoLib.utils.EventTypes;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;

final class BasePromo$EventTracker
  implements Runnable
{
  private final MetricsInfo metrics;
  private final EventTypes type;
  
  BasePromo$EventTracker(BasePromo paramBasePromo, EventTypes paramEventTypes, MetricsInfo paramMetricsInfo)
  {
    type = paramEventTypes;
    metrics = paramMetricsInfo;
  }
  
  public final void run()
  {
    final PromoInflater localPromoInflater = this$0.source.getPromoInflater();
    switch (BasePromo.5.$SwitchMap$com$linkedin$CrossPromoLib$utils$EventTypes[type.ordinal()])
    {
    default: 
      return;
    case 1: 
      PromoInflater.getPromoTracker().trackAction(this$0.getPromoModel(), metrics, null);
      return;
    case 2: 
      PromoInflater.getPromoTracker().trackAction(this$0.getPromoModel(), metrics, new Runnable()
      {
        public final void run()
        {
          localPromoInflater.fetchPromo(this$0.source.getPageKey(), this$0.source.getQueryParameters());
        }
      });
      return;
    case 3: 
      PromoInflater.getPromoTracker().trackImpression(this$0.getPromoModel(), metrics, null);
      return;
    }
    PromoInflater.getPromoTracker().trackImpression(this$0.getPromoModel(), metrics, new Runnable()
    {
      public final void run()
      {
        localPromoInflater.fetchPromo(this$0.source.getPageKey(), this$0.source.getQueryParameters());
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.BasePromo.EventTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */