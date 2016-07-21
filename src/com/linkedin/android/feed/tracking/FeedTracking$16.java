package com.linkedin.android.feed.tracking;

import android.content.Context;
import android.view.View;
import com.linkedin.android.feed.actorlist.FeedActorListBundleBuilder;
import com.linkedin.android.feed.actorlist.FeedActorListIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

final class FeedTracking$16
  extends TrackingOnClickListener
{
  FeedTracking$16(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, WeakReference paramWeakReference, AggregatedConnectionUpdate paramAggregatedConnectionUpdate, IntentRegistry paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    Context localContext = (Context)val$contextRef.get();
    if (localContext != null)
    {
      FeedActorListBundleBuilder localFeedActorListBundleBuilder = FeedActorListBundleBuilder.createConnectionUpdates(val$aggregatedConnectionUpdate);
      localContext.startActivity(val$intentRegistry.feedActorList.newIntent(paramView.getContext(), localFeedActorListBundleBuilder));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */