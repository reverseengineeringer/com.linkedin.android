package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

final class VideoView$6
  implements MediaPlayer.OnBufferingUpdateListener
{
  VideoView$6(VideoView paramVideoView) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    VideoView.access$1302(this$0, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */