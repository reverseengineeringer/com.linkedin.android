package com.linkedin.android.feed.shared.videoviewer;

import android.os.Handler;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

final class VideoControl$4
  implements SeekBar.OnSeekBarChangeListener
{
  VideoControl$4(VideoControl paramVideoControl) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l = VideoControl.access$000(this$0).getDuration() * paramInt / 1000L;
      VideoControl.access$000(this$0).seekTo((int)l);
      this$0.currentTimeText.setText(VideoControl.access$500(this$0, (int)l));
    }
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this$0.show(3600000);
    VideoControl.access$302(this$0, true);
    VideoControl.access$400(this$0).removeMessages(2);
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    VideoControl.access$302(this$0, false);
    VideoControl.access$100(this$0);
    VideoControl.access$600(this$0);
    this$0.show(3000);
    VideoControl.access$400(this$0).sendEmptyMessage(2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoControl.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */