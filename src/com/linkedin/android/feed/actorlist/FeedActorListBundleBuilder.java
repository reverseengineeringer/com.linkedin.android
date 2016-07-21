package com.linkedin.android.feed.actorlist;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedPymkUpdate;

public final class FeedActorListBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  FeedActorListBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static FeedActorListBundleBuilder createConnectionUpdates(AggregatedConnectionUpdate paramAggregatedConnectionUpdate)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("listType", 1);
    RecordParceler.quietParcel(paramAggregatedConnectionUpdate, "connectionUpdates", localBundle);
    return new FeedActorListBundleBuilder(localBundle);
  }
  
  public static FeedActorListBundleBuilder createPymkUpdates(AggregatedPymkUpdate paramAggregatedPymkUpdate)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("listType", 2);
    RecordParceler.quietParcel(paramAggregatedPymkUpdate, "pymkUpdates", localBundle);
    return new FeedActorListBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.FeedActorListBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */