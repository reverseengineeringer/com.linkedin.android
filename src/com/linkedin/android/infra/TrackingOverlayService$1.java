package com.linkedin.android.infra;

import com.linkedin.android.litrackinglib.TrackingEventListener;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;

final class TrackingOverlayService$1
  implements TrackingEventListener
{
  TrackingOverlayService$1(TrackingOverlayService paramTrackingOverlayService) {}
  
  public final void onTrackingEventReceived(TrackingEventBuilder paramTrackingEventBuilder)
  {
    try
    {
      TrackingOverlayService.access$000(this$0, TrackingOverlayService.access$100$5a17cfa9(paramTrackingEventBuilder.build()), 2131623940);
      return;
    }
    catch (BuilderException paramTrackingEventBuilder)
    {
      TrackingOverlayService.access$000(this$0, paramTrackingEventBuilder.getMessage(), 2131623940);
    }
  }
  
  public final void onTrackingEventReceived(String paramString)
  {
    TrackingOverlayService.access$000(this$0, paramString, 2131623943);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.TrackingOverlayService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */