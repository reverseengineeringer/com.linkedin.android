package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.SurfaceHolder;

final class VideoView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoView$1(VideoView paramVideoView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoView.access$002(this$0, paramMediaPlayer.getVideoWidth());
    VideoView.access$102(this$0, paramMediaPlayer.getVideoHeight());
    if ((VideoView.access$000(this$0) != 0) && (VideoView.access$100(this$0) != 0))
    {
      this$0.getHolder().setFixedSize(VideoView.access$000(this$0), VideoView.access$100(this$0));
      this$0.requestLayout();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */