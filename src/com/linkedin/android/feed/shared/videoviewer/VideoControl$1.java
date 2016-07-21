package com.linkedin.android.feed.shared.videoviewer;

import android.view.View;
import android.view.View.OnClickListener;

final class VideoControl$1
  implements View.OnClickListener
{
  VideoControl$1(VideoControl paramVideoControl) {}
  
  public final void onClick(View paramView)
  {
    int i = VideoControl.access$000(this$0).getCurrentPosition();
    VideoControl.access$000(this$0).seekTo(i - 5000);
    VideoControl.access$100(this$0);
    this$0.show(3000);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoControl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */