package com.linkedin.android.feed.tracking;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FeedTracking$5
  extends TrackingOnClickListener
{
  FeedTracking$5(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Update paramUpdate, SocialDetail paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (val$fragmentComponent.context() != null)
    {
      paramView = val$update;
      SocialDetail localSocialDetail = val$socialDetail;
      Bundle localBundle = new Bundle();
      if (tracking != null) {
        RecordParceler.quietParcel(tracking, "trackingData", localBundle);
      }
      RecordParceler.quietParcel(localSocialDetail, "socialDetail", localBundle);
      localBundle.putString("updateUrn", urn.toString());
      if (entityUrn != null) {
        localBundle.putString("updateEntityUrn", entityUrn.toString());
      }
      localBundle.putInt("feedType", 13);
      paramView = new LikesDetailBundleBuilder(localBundle);
      FeedBundleBuilder.saveUpdateToCache(val$fragmentComponent.dataManager(), val$update);
      paramView = val$fragmentComponent.intentRegistry().likesDetailViewer.newIntent(val$fragmentComponent.context(), paramView);
      val$fragmentComponent.context().startActivity(paramView);
    }
    FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, "viewCommentLikers");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */