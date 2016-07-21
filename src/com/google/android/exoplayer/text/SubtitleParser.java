package com.google.android.exoplayer.text;

import java.io.IOException;
import java.io.InputStream;

public abstract interface SubtitleParser
{
  public abstract boolean canParse(String paramString);
  
  public abstract Subtitle parse$70e760a9(InputStream paramInputStream, long paramLong)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.SubtitleParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */