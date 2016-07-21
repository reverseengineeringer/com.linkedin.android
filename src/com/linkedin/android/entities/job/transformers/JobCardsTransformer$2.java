package com.linkedin.android.entities.job.transformers;

import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent;

final class JobCardsTransformer$2
  implements Closure<ImpressionData, TrackingEventBuilder<PremiumUpsellImpressionEvent>>
{}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobCardsTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */