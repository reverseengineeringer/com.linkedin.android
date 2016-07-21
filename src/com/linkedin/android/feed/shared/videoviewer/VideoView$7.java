package com.linkedin.android.feed.shared.videoviewer;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

final class VideoView$7
  implements SurfaceHolder.Callback
{
  VideoView$7(VideoView paramVideoView) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    VideoView.access$702(this$0, paramInt2);
    VideoView.access$802(this$0, paramInt3);
    if (VideoView.access$600(this$0) == 3)
    {
      paramInt1 = 1;
      if ((VideoView.access$000(this$0) != paramInt2) || (VideoView.access$100(this$0) != paramInt3)) {
        break label112;
      }
    }
    label112:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if ((VideoView.access$400(this$0) != null) && (paramInt1 != 0) && (paramInt2 != 0))
      {
        if (VideoView.access$500(this$0) != 0) {
          this$0.seekTo(VideoView.access$500(this$0));
        }
        this$0.start();
      }
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    VideoView.access$1402(this$0, paramSurfaceHolder);
    VideoView.access$1500(this$0);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    VideoView.access$1402(this$0, null);
    if (VideoView.access$1600(this$0) != null) {
      VideoView.access$1600(this$0).hide();
    }
    VideoView.access$1700$7a87e2ee(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */