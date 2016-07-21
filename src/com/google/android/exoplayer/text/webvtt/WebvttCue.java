package com.google.android.exoplayer.text.webvtt;

import android.text.Layout.Alignment;
import com.google.android.exoplayer.text.Cue;

final class WebvttCue
  extends Cue
{
  public final long endTime;
  public final long startTime;
  
  public WebvttCue(long paramLong1, long paramLong2, CharSequence paramCharSequence, int paramInt1, int paramInt2, Layout.Alignment paramAlignment, int paramInt3)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramAlignment, paramInt3);
    startTime = paramLong1;
    endTime = paramLong2;
  }
  
  public WebvttCue(CharSequence paramCharSequence)
  {
    this(paramCharSequence, (byte)0);
  }
  
  private WebvttCue(CharSequence paramCharSequence, byte paramByte)
  {
    this(-1L, -1L, paramCharSequence, -1, -1, null, -1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.webvtt.WebvttCue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */