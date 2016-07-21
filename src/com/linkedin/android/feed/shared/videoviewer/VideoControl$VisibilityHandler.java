package com.linkedin.android.feed.shared.videoviewer;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class VideoControl$VisibilityHandler
  extends Handler
{
  private WeakReference<VideoControl> videoControl;
  
  private VideoControl$VisibilityHandler(VideoControl paramVideoControl)
  {
    videoControl = new WeakReference(paramVideoControl);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (videoControl.get() == null) {}
    VideoControl localVideoControl;
    do
    {
      return;
      localVideoControl = (VideoControl)videoControl.get();
      switch (what)
      {
      default: 
        return;
      case 1: 
        localVideoControl.hide();
        return;
      }
      VideoControl.access$100(localVideoControl);
    } while ((VideoControl.access$300(localVideoControl)) || (!VideoControl.access$800(localVideoControl)) || (!VideoControl.access$000(localVideoControl).isPlaying()));
    sendMessageDelayed(obtainMessage(2), 200L);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoControl.VisibilityHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */