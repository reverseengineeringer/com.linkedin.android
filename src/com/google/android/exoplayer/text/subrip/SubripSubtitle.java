package com.google.android.exoplayer.text.subrip;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle
  implements Subtitle
{
  private final long[] cueTimesUs;
  private final Cue[] cues;
  private final long startTimeUs;
  
  public SubripSubtitle(long paramLong, Cue[] paramArrayOfCue, long[] paramArrayOfLong)
  {
    startTimeUs = paramLong;
    cues = paramArrayOfCue;
    cueTimesUs = paramArrayOfLong;
  }
  
  public final List<Cue> getCues(long paramLong)
  {
    int i = Util.binarySearchFloor(cueTimesUs, paramLong, true, false);
    if ((i == -1) || (i % 2 == 1)) {
      return Collections.emptyList();
    }
    return Collections.singletonList(cues[(i / 2)]);
  }
  
  public final long getEventTime(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramInt >= cueTimesUs.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      return cueTimesUs[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public final int getEventTimeCount()
  {
    return cueTimesUs.length;
  }
  
  public final int getNextEventTimeIndex(long paramLong)
  {
    int i = Util.binarySearchCeil$7476434d(cueTimesUs, paramLong, false);
    if (i < cueTimesUs.length) {
      return i;
    }
    return -1;
  }
  
  public final long getStartTime()
  {
    return startTimeUs;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.subrip.SubripSubtitle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */