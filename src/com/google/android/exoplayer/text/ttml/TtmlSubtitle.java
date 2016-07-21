package com.google.android.exoplayer.text.ttml;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.List;

public final class TtmlSubtitle
  implements Subtitle
{
  private final long[] eventTimesUs;
  private final TtmlNode root;
  private final long startTimeUs;
  
  public TtmlSubtitle(TtmlNode paramTtmlNode, long paramLong)
  {
    root = paramTtmlNode;
    startTimeUs = paramLong;
    eventTimesUs = paramTtmlNode.getEventTimesUs();
  }
  
  public final List<Cue> getCues(long paramLong)
  {
    Object localObject = root.getText(paramLong - startTimeUs, new SpannableStringBuilder(), false);
    int i = ((SpannableStringBuilder)localObject).length();
    int j = 0;
    int k;
    if (j < i)
    {
      if (((SpannableStringBuilder)localObject).charAt(j) != ' ') {
        break label422;
      }
      k = j + 1;
      while ((k < ((SpannableStringBuilder)localObject).length()) && (((SpannableStringBuilder)localObject).charAt(k) == ' ')) {
        k += 1;
      }
      k -= j + 1;
      if (k <= 0) {
        break label422;
      }
      ((SpannableStringBuilder)localObject).delete(j, j + k);
      i -= k;
    }
    label422:
    for (;;)
    {
      j += 1;
      break;
      j = i;
      if (i > 0)
      {
        j = i;
        if (((SpannableStringBuilder)localObject).charAt(0) == ' ')
        {
          ((SpannableStringBuilder)localObject).delete(0, 1);
          j = i - 1;
        }
      }
      i = j;
      j = 0;
      while (j < i - 1)
      {
        k = i;
        if (((SpannableStringBuilder)localObject).charAt(j) == '\n')
        {
          k = i;
          if (((SpannableStringBuilder)localObject).charAt(j + 1) == ' ')
          {
            ((SpannableStringBuilder)localObject).delete(j + 1, j + 2);
            k = i - 1;
          }
        }
        j += 1;
        i = k;
      }
      j = i;
      if (i > 0)
      {
        j = i;
        if (((SpannableStringBuilder)localObject).charAt(i - 1) == ' ')
        {
          ((SpannableStringBuilder)localObject).delete(i - 1, i);
          j = i - 1;
        }
      }
      k = 0;
      for (i = j; k < i - 1; i = j)
      {
        j = i;
        if (((SpannableStringBuilder)localObject).charAt(k) == ' ')
        {
          j = i;
          if (((SpannableStringBuilder)localObject).charAt(k + 1) == '\n')
          {
            ((SpannableStringBuilder)localObject).delete(k, k + 1);
            j = i - 1;
          }
        }
        k += 1;
      }
      j = i;
      if (i > 0)
      {
        j = i;
        if (((SpannableStringBuilder)localObject).charAt(i - 1) == '\n')
        {
          ((SpannableStringBuilder)localObject).delete(i - 1, i);
          j = i - 1;
        }
      }
      localObject = ((SpannableStringBuilder)localObject).subSequence(0, j);
      if (localObject == null) {
        return Collections.emptyList();
      }
      return Collections.singletonList(new Cue((CharSequence)localObject));
    }
  }
  
  public final long getEventTime(int paramInt)
  {
    return eventTimesUs[paramInt] + startTimeUs;
  }
  
  public final int getEventTimeCount()
  {
    return eventTimesUs.length;
  }
  
  public final int getNextEventTimeIndex(long paramLong)
  {
    int i = Util.binarySearchCeil$7476434d(eventTimesUs, paramLong - startTimeUs, false);
    if (i < eventTimesUs.length) {
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
 * Qualified Name:     com.google.android.exoplayer.text.ttml.TtmlSubtitle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */