package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;

final class VideoView$2
  implements MediaPlayer.OnPreparedListener
{
  VideoView$2(VideoView paramVideoView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    VideoView.access$202(this$0, 2);
    if (VideoView.access$300(this$0) != null) {
      VideoView.access$300(this$0).onPrepared(VideoView.access$400(this$0));
    }
    VideoView.access$002(this$0, paramMediaPlayer.getVideoWidth());
    VideoView.access$102(this$0, paramMediaPlayer.getVideoHeight());
    int i = VideoView.access$500(this$0);
    if (i != 0) {
      this$0.seekTo(i);
    }
    if ((VideoView.access$000(this$0) == 0) || (VideoView.access$100(this$0) == 0)) {
      if (VideoView.access$600(this$0) == 3) {
        this$0.start();
      }
    }
    do
    {
      do
      {
        return;
        this$0.getHolder().setFixedSize(VideoView.access$000(this$0), VideoView.access$100(this$0));
      } while ((VideoView.access$700(this$0) != VideoView.access$000(this$0)) || (VideoView.access$800(this$0) != VideoView.access$100(this$0)));
      if (VideoView.access$600(this$0) == 3)
      {
        this$0.start();
        return;
      }
    } while ((this$0.isPlaying()) || ((i == 0) && (this$0.getCurrentPosition() <= 0)));
    VideoView.access$900$7a8822bf(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */