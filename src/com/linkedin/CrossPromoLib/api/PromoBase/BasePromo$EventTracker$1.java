package com.linkedin.CrossPromoLib.api.PromoBase;

import com.linkedin.CrossPromoLib.api.PromoInflater;
import com.linkedin.CrossPromoLib.api.PromoSource;

final class BasePromo$EventTracker$1
  implements Runnable
{
  BasePromo$EventTracker$1(BasePromo.EventTracker paramEventTracker, PromoInflater paramPromoInflater) {}
  
  public final void run()
  {
    val$inflater.fetchPromo(this$1.this$0.source.getPageKey(), this$1.this$0.source.getQueryParameters());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoBase.BasePromo.EventTracker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */