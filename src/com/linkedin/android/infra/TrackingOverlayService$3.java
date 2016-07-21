package com.linkedin.android.infra;

import android.widget.ScrollView;

final class TrackingOverlayService$3
  implements Runnable
{
  TrackingOverlayService$3(TrackingOverlayService paramTrackingOverlayService) {}
  
  public final void run()
  {
    if (this$0.scrollView != null) {
      this$0.scrollView.fullScroll(130);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.TrackingOverlayService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */