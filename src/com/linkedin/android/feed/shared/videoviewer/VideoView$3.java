package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class VideoView$3
  implements MediaPlayer.OnCompletionListener
{
  VideoView$3(VideoView paramVideoView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    VideoView.access$202(this$0, 5);
    VideoView.access$602(this$0, 5);
    if (VideoView.access$1000(this$0) != null) {
      VideoView.access$1000(this$0).onCompletion(VideoView.access$400(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */