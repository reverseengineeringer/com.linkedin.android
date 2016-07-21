package com.linkedin.android.feed.shared.videoviewer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class VideoViewerFragment$3
  implements MediaPlayer.OnPreparedListener
{
  VideoViewerFragment$3(VideoViewerFragment paramVideoViewerFragment) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this$0.videoViewer.start();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */