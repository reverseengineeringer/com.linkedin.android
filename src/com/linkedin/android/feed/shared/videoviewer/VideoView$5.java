package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final class VideoView$5
  implements MediaPlayer.OnErrorListener
{
  VideoView$5(VideoView paramVideoView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoView.access$202(this$0, -1);
    VideoView.access$602(this$0, -1);
    if (VideoView.access$1200(this$0) != null) {
      VideoView.access$1200(this$0).onError(VideoView.access$400(this$0), paramInt1, paramInt2);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */