package com.google.android.exoplayer.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WebvttSubtitle
  implements Subtitle
{
  private final long[] cueTimesUs;
  private final List<WebvttCue> cues;
  private final int numCues;
  private final long[] sortedCueTimesUs;
  private final long startTimeUs;
  
  public WebvttSubtitle(List<WebvttCue> paramList, long paramLong)
  {
    cues = paramList;
    startTimeUs = paramLong;
    numCues = paramList.size();
    cueTimesUs = new long[numCues * 2];
    int i = 0;
    while (i < numCues)
    {
      WebvttCue localWebvttCue = (WebvttCue)paramList.get(i);
      int j = i * 2;
      cueTimesUs[j] = startTime;
      cueTimesUs[(j + 1)] = endTime;
      i += 1;
    }
    sortedCueTimesUs = Arrays.copyOf(cueTimesUs, cueTimesUs.length);
    Arrays.sort(sortedCueTimesUs);
  }
  
  public final List<Cue> getCues(long paramLong)
  {
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    int i = 0;
    if (i < numCues)
    {
      Object localObject5 = localObject4;
      Object localObject1 = localObject2;
      Object localObject6 = localObject3;
      int j;
      if (cueTimesUs[(i * 2)] <= paramLong)
      {
        localObject5 = localObject4;
        localObject1 = localObject2;
        localObject6 = localObject3;
        if (paramLong < cueTimesUs[(i * 2 + 1)])
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          localObject5 = (WebvttCue)cues.get(i);
          if ((line != -1) || (position != -1)) {
            break label158;
          }
          j = 1;
          label125:
          if (j == 0) {
            break label236;
          }
          if (localObject4 != null) {
            break label164;
          }
          localObject6 = localObject3;
        }
      }
      for (;;)
      {
        i += 1;
        localObject4 = localObject5;
        localObject2 = localObject1;
        localObject3 = localObject6;
        break;
        label158:
        j = 0;
        break label125;
        label164:
        if (localObject3 == null)
        {
          localObject6 = new SpannableStringBuilder();
          ((SpannableStringBuilder)localObject6).append(text).append("\n").append(text);
          localObject5 = localObject4;
        }
        else
        {
          ((SpannableStringBuilder)localObject3).append("\n").append(text);
          localObject5 = localObject4;
          localObject6 = localObject3;
          continue;
          label236:
          ((ArrayList)localObject1).add(localObject5);
          localObject5 = localObject4;
          localObject6 = localObject3;
        }
      }
    }
    if (localObject3 != null) {
      ((ArrayList)localObject2).add(new WebvttCue((CharSequence)localObject3));
    }
    while (localObject2 != null)
    {
      return (List<Cue>)localObject2;
      if (localObject4 != null) {
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    return Collections.emptyList();
  }
  
  public final long getEventTime(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramInt >= sortedCueTimesUs.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      return sortedCueTimesUs[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public final int getEventTimeCount()
  {
    return sortedCueTimesUs.length;
  }
  
  public final int getNextEventTimeIndex(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      int i = Util.binarySearchCeil$7476434d(sortedCueTimesUs, paramLong, false);
      if (i >= sortedCueTimesUs.length) {
        break;
      }
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
 * Qualified Name:     com.google.android.exoplayer.text.webvtt.WebvttSubtitle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */