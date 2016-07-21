package com.google.android.exoplayer.text;

import android.text.Layout.Alignment;

public class Cue
{
  public final Layout.Alignment alignment;
  public final int line;
  public final int position;
  public final int size;
  public final CharSequence text;
  
  public Cue()
  {
    this(null);
  }
  
  public Cue(CharSequence paramCharSequence)
  {
    this(paramCharSequence, -1, -1, null, -1);
  }
  
  public Cue(CharSequence paramCharSequence, int paramInt1, int paramInt2, Layout.Alignment paramAlignment, int paramInt3)
  {
    text = paramCharSequence;
    line = paramInt1;
    position = paramInt2;
    alignment = paramAlignment;
    size = paramInt3;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.Cue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */