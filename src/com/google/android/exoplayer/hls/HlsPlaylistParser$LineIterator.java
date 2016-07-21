package com.google.android.exoplayer.hls;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;

final class HlsPlaylistParser$LineIterator
{
  private final Queue<String> extraLines;
  private String next;
  private final BufferedReader reader;
  
  public HlsPlaylistParser$LineIterator(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    extraLines = paramQueue;
    reader = paramBufferedReader;
  }
  
  public final boolean hasNext()
    throws IOException
  {
    if (next != null) {
      return true;
    }
    if (!extraLines.isEmpty())
    {
      next = ((String)extraLines.poll());
      return true;
    }
    do
    {
      String str = reader.readLine();
      next = str;
      if (str == null) {
        break;
      }
      next = next.trim();
    } while (next.isEmpty());
    return true;
    return false;
  }
  
  public final String next()
    throws IOException
  {
    String str = null;
    if (hasNext())
    {
      str = next;
      next = null;
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsPlaylistParser.LineIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */