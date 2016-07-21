package com.linkedin.android.axle;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.crosspromo.fe.api.android.MetricsInfo;

final class ToastPromo$PromoViewHolder$1
  implements View.OnClickListener
{
  ToastPromo$PromoViewHolder$1(ToastPromo.PromoViewHolder paramPromoViewHolder, MetricsInfo paramMetricsInfo, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    if ((val$dismissMetric != null) && (val$dismissRunnable != null)) {
      val$dismissRunnable.run();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromo.PromoViewHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */