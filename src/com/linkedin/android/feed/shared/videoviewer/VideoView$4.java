package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;

final class VideoView$4
  implements MediaPlayer.OnInfoListener
{
  VideoView$4(VideoView paramVideoView) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (VideoView.access$1100(this$0) != null) {
      VideoView.access$1100(this$0).onInfo(paramMediaPlayer, paramInt1, paramInt2);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */