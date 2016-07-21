package com.linkedin.android.growth.newtovoyager.banner;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class NewToVoyagerBannerViewTransformer$4
  extends TrackingOnClickListener
{
  NewToVoyagerBannerViewTransformer$4(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, NewToVoyagerFeedCardViewModel paramNewToVoyagerFeedCardViewModel, FragmentComponent paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (val$viewModel.legoTrackingToken != null) {
      NewToVoyagerBannerViewTransformer.access$000(val$fragmentComponent, val$viewModel.legoTrackingToken);
    }
    val$fragmentComponent.flagshipSharedPreferences().resetNewToVoyagerLegoTrackingToken();
    val$fragmentComponent.eventBus();
    Bus.publish(new NewToVoyagerFeedDismissEvent(false));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerBannerViewTransformer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */