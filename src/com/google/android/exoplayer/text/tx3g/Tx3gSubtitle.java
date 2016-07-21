package com.google.android.exoplayer.text.tx3g;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import java.util.Collections;
import java.util.List;

final class Tx3gSubtitle
  implements Subtitle
{
  private final List<Cue> cues;
  private final long startTimeUs;
  
  public Tx3gSubtitle(long paramLong, Cue paramCue)
  {
    startTimeUs = paramLong;
    cues = Collections.singletonList(paramCue);
  }
  
  public final List<Cue> getCues(long paramLong)
  {
    if (paramLong >= startTimeUs) {
      return cues;
    }
    return Collections.emptyList();
  }
  
  public final long getEventTime(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      return startTimeUs;
    }
  }
  
  public final int getEventTimeCount()
  {
    return 1;
  }
  
  public final int getNextEventTimeIndex(long paramLong)
  {
    if (paramLong < startTimeUs) {
      return 0;
    }
    return -1;
  }
  
  public final long getStartTime()
  {
    return startTimeUs;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.tx3g.Tx3gSubtitle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */