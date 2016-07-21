package com.linkedin.android.entities.company.transformers;

import android.view.View;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class CompanyTransformer$2
  extends TrackingOnClickListener
{
  CompanyTransformer$2(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, TrackingClosure paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    val$clickClosure.apply(null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */