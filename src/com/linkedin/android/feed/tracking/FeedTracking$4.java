package com.linkedin.android.feed.tracking;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class FeedTracking$4
  extends TrackingOnClickListener
{
  FeedTracking$4(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Update paramUpdate, Like paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    ActivityComponent localActivityComponent = val$fragmentComponent.activity().activityComponent;
    Object localObject = val$update;
    Bundle localBundle = new Bundle();
    if (tracking != null) {
      RecordParceler.quietParcel(tracking, "trackingData", localBundle);
    }
    RecordParceler.quietParcel(socialDetail, "socialDetail", localBundle);
    localBundle.putString("updateUrn", urn.toString());
    if (entityUrn != null) {
      localBundle.putString("updateEntityUrn", entityUrn.toString());
    }
    if (value.propUpdateValue != null) {
      localBundle.putInt("feedType", 8);
    }
    for (;;)
    {
      localObject = new LikesDetailBundleBuilder(localBundle);
      if (val$highlightedLike != null) {
        RecordParceler.quietParcel(val$highlightedLike, "highlightedLike", bundle);
      }
      FeedBundleBuilder.saveUpdateToCache(val$fragmentComponent.dataManager(), val$update);
      paramView = intentRegistrylikesDetailViewer.newIntent(paramView.getContext(), (BundleBuilder)localObject);
      localActivityComponent.context().startActivity(paramView);
      FeedTracking.trackSponsoredAction(Tracker.createPageInstanceHeader(val$fragmentComponent.tracker().getCurrentPageInstance()), val$fragmentComponent, val$update.tracking, "viewLikers");
      return;
      if (value.discussionUpdateValue != null) {
        localBundle.putInt("feedType", 9);
      } else {
        localBundle.putInt("feedType", 1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.FeedTracking.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */