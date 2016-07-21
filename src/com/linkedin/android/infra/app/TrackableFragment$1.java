package com.linkedin.android.infra.app;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.perftimer.RUMTiming;
import org.greenrobot.eventbus.Subscribe;

final class TrackableFragment$1
{
  TrackableFragment$1(TrackableFragment paramTrackableFragment) {}
  
  @Subscribe
  public final void onEvent(CollectionDataEvent paramCollectionDataEvent)
  {
    if (TrackableFragment.access$000(this$0).equals(subscriberId)) {
      this$0.onCollectionDataEvent(requestState, changedCollectionModel, type, collectionRoute, rumSessionId);
    }
  }
  
  @Subscribe
  public final void onEvent(DataErrorEvent paramDataErrorEvent)
  {
    if (TrackableFragment.access$000(this$0).equals(subscriberId)) {
      this$0.onDataError(type, routes, error);
    }
  }
  
  @Subscribe
  public final void onEvent(DataReceivedEvent paramDataReceivedEvent)
  {
    int i;
    if (TrackableFragment.access$000(this$0).equals(subscriberId))
    {
      if ((this$0.rumSessionId == null) || (rumSessionId == null) || (!this$0.rumSessionId.equals(rumSessionId))) {
        break label122;
      }
      i = 1;
      if (type == DataStore.Type.NETWORK) {
        break label127;
      }
    }
    label122:
    label127:
    for (boolean bool = true;; bool = false)
    {
      if (i != 0) {
        RUMTiming.renderStart(this$0.rumSessionId, bool, this$0.shouldAggregateMultipleRenders());
      }
      this$0.onDataReady(type, routes, responseMap);
      if (i != 0) {
        RUMHelper.callRenderEndOnNextLoop(this$0.rumSessionId, bool);
      }
      return;
      i = 0;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.TrackableFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */