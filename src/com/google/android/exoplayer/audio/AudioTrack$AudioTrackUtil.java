package com.google.android.exoplayer.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer.util.Util;

public class AudioTrack$AudioTrackUtil
{
  protected AudioTrack audioTrack;
  private boolean isPassthrough;
  private long lastRawPlaybackHeadPosition;
  private long passthroughWorkaroundPauseOffset;
  private long rawPlaybackHeadWrapCount;
  private int sampleRate;
  
  public final long getPlaybackHeadPosition()
  {
    long l2 = 0xFFFFFFFF & audioTrack.getPlaybackHeadPosition();
    long l1 = l2;
    if (Util.SDK_INT <= 22)
    {
      l1 = l2;
      if (isPassthrough)
      {
        if (audioTrack.getPlayState() != 1) {
          break label89;
        }
        lastRawPlaybackHeadPosition = l2;
      }
    }
    for (;;)
    {
      l1 = l2 + passthroughWorkaroundPauseOffset;
      if (lastRawPlaybackHeadPosition > l1) {
        rawPlaybackHeadWrapCount += 1L;
      }
      lastRawPlaybackHeadPosition = l1;
      return (rawPlaybackHeadWrapCount << 32) + l1;
      label89:
      if ((audioTrack.getPlayState() == 2) && (l2 == 0L)) {
        passthroughWorkaroundPauseOffset = lastRawPlaybackHeadPosition;
      }
    }
  }
  
  public final long getPlaybackHeadPositionUs()
  {
    return getPlaybackHeadPosition() * 1000000L / sampleRate;
  }
  
  public long getTimestampFramePosition()
  {
    throw new UnsupportedOperationException();
  }
  
  public long getTimestampNanoTime()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean overrideHasPendingData()
  {
    return (Util.SDK_INT <= 22) && (isPassthrough) && (audioTrack.getPlayState() == 2) && (audioTrack.getPlaybackHeadPosition() == 0);
  }
  
  public void reconfigure(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    audioTrack = paramAudioTrack;
    isPassthrough = paramBoolean;
    lastRawPlaybackHeadPosition = 0L;
    rawPlaybackHeadWrapCount = 0L;
    passthroughWorkaroundPauseOffset = 0L;
    if (paramAudioTrack != null) {
      sampleRate = paramAudioTrack.getSampleRate();
    }
  }
  
  public boolean updateTimestamp()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioTrack.AudioTrackUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */