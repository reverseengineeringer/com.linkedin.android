package com.linkedin.android.feed.tracking;

import android.content.Context;
import android.view.View;
import com.linkedin.android.entities.jymbii.JymbiiBundleBuilder;
import com.linkedin.android.entities.jymbii.JymbiiIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

final class FeedTracking$15
  extends TrackingOnClickListener
{
  FeedTracking$15(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, WeakReference paramWeakReference, IntentRegistry paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = (Context)val$contextRef.get();
    if (paramView != null)
    {
      JymbiiBundleBuilder localJymbiiBundleBuilder = JymbiiBundleBuilder.create();
      paramView.startActivity(val$intentRegistry.jymbii.newIntent(paramView, localJymbiiBundleBuilder));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */