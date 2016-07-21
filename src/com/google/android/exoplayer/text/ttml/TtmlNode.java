package com.google.android.exoplayer.text.ttml;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

final class TtmlNode
{
  private List<TtmlNode> children;
  public final long endTimeUs;
  public final boolean isTextNode;
  public final long startTimeUs;
  public final String tag;
  public final String text;
  
  TtmlNode(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    tag = paramString1;
    text = paramString2;
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      isTextNode = bool;
      startTimeUs = paramLong1;
      endTimeUs = paramLong2;
      return;
    }
  }
  
  private static void endParagraph(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramSpannableStringBuilder.length() - 1;
    while ((i >= 0) && (paramSpannableStringBuilder.charAt(i) == ' ')) {
      i -= 1;
    }
    if ((i >= 0) && (paramSpannableStringBuilder.charAt(i) != '\n')) {
      paramSpannableStringBuilder.append('\n');
    }
  }
  
  private void getEventTimes(TreeSet<Long> paramTreeSet, boolean paramBoolean)
  {
    boolean bool2 = "p".equals(tag);
    if ((paramBoolean) || (bool2))
    {
      if (startTimeUs != -1L) {
        paramTreeSet.add(Long.valueOf(startTimeUs));
      }
      if (endTimeUs != -1L) {
        paramTreeSet.add(Long.valueOf(endTimeUs));
      }
    }
    if (children == null) {
      return;
    }
    int i = 0;
    label76:
    TtmlNode localTtmlNode;
    if (i < children.size())
    {
      localTtmlNode = (TtmlNode)children.get(i);
      if ((!paramBoolean) && (!bool2)) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      localTtmlNode.getEventTimes(paramTreeSet, bool1);
      i += 1;
      break label76;
      break;
    }
  }
  
  public final void addChild(TtmlNode paramTtmlNode)
  {
    if (children == null) {
      children = new ArrayList();
    }
    children.add(paramTtmlNode);
  }
  
  public final long[] getEventTimesUs()
  {
    Object localObject = new TreeSet();
    getEventTimes((TreeSet)localObject, false);
    long[] arrayOfLong = new long[((TreeSet)localObject).size()];
    localObject = ((TreeSet)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfLong[i] = ((Long)((Iterator)localObject).next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  final SpannableStringBuilder getText(long paramLong, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    if ((isTextNode) && (paramBoolean)) {
      paramSpannableStringBuilder.append(text);
    }
    label144:
    boolean bool2;
    label199:
    label201:
    do
    {
      do
      {
        return paramSpannableStringBuilder;
        if (("br".equals(tag)) && (paramBoolean))
        {
          paramSpannableStringBuilder.append('\n');
          return paramSpannableStringBuilder;
        }
      } while ("metadata".equals(tag));
      int i;
      int j;
      if (((startTimeUs == -1L) && (endTimeUs == -1L)) || ((startTimeUs <= paramLong) && (endTimeUs == -1L)) || ((startTimeUs == -1L) && (paramLong < endTimeUs)) || ((startTimeUs <= paramLong) && (paramLong < endTimeUs)))
      {
        i = 1;
        if (i == 0) {
          break label199;
        }
        bool2 = "p".equals(tag);
        i = 0;
        if (children != null) {
          break label201;
        }
        j = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          if (children == null)
          {
            throw new IndexOutOfBoundsException();
            i = 0;
            break label144;
            break;
            j = children.size();
            continue;
          }
          TtmlNode localTtmlNode = (TtmlNode)children.get(i);
          if ((paramBoolean) || (bool2)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            localTtmlNode.getText(paramLong, paramSpannableStringBuilder, bool1);
            i += 1;
            break;
          }
        }
      }
    } while (!bool2);
    endParagraph(paramSpannableStringBuilder);
    return paramSpannableStringBuilder;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.ttml.TtmlNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */