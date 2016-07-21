package com.linkedin.android.feed.shared.imageviewer;

import com.linkedin.android.imageviewer.ImageViewerController;
import com.linkedin.android.imageviewer.ImageViewerController.ImageViewerListener;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;

final class ImageViewerFragment$4
  implements ImageViewerController.ImageViewerListener
{
  ImageViewerFragment$4(ImageViewerFragment paramImageViewerFragment) {}
  
  public final void dismiss()
  {
    NavigationUtils.onUpPressed(this$0.getActivity(), true);
  }
  
  public final void moved()
  {
    ImageViewerFragment.access$700(this$0).stopDelayedExecution(ImageViewerFragment.access$400(this$0));
    new ControlInteractionEvent(this$0.tracker, "richmedia_viewer_container", ControlType.GESTURE_AREA, InteractionType.DRAG).send();
  }
  
  public final void tapped()
  {
    ImageViewerFragment.access$500(this$0).stopDelayedExecution(ImageViewerFragment.access$400(this$0));
    if (ImageViewerFragment.access$000(this$0) != null) {
      ImageViewerFragment.access$000(this$0).toggleFullscreenMode();
    }
    ImageViewerFragment.access$600(this$0, "richmedia_viewer_container");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */