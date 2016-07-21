package com.google.android.exoplayer.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class AudioTrack$AudioTrackUtilV19
  extends AudioTrack.AudioTrackUtil
{
  private final AudioTimestamp audioTimestamp = new AudioTimestamp();
  private long lastRawTimestampFramePosition;
  private long lastTimestampFramePosition;
  private long rawTimestampFramePositionWrapCount;
  
  public AudioTrack$AudioTrackUtilV19()
  {
    super((byte)0);
  }
  
  public final long getTimestampFramePosition()
  {
    return lastTimestampFramePosition;
  }
  
  public final long getTimestampNanoTime()
  {
    return audioTimestamp.nanoTime;
  }
  
  public final void reconfigure(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    super.reconfigure(paramAudioTrack, paramBoolean);
    rawTimestampFramePositionWrapCount = 0L;
    lastRawTimestampFramePosition = 0L;
    lastTimestampFramePosition = 0L;
  }
  
  public final boolean updateTimestamp()
  {
    boolean bool = audioTrack.getTimestamp(audioTimestamp);
    if (bool)
    {
      long l = audioTimestamp.framePosition;
      if (lastRawTimestampFramePosition > l) {
        rawTimestampFramePositionWrapCount += 1L;
      }
      lastRawTimestampFramePosition = l;
      lastTimestampFramePosition = ((rawTimestampFramePositionWrapCount << 32) + l);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioTrack.AudioTrackUtilV19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */