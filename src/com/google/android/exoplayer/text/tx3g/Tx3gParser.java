package com.google.android.exoplayer.text.tx3g;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Tx3gParser
  implements SubtitleParser
{
  public final boolean canParse(String paramString)
  {
    return "application/x-quicktime-tx3g".equals(paramString);
  }
  
  public final Subtitle parse$70e760a9(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    return new Tx3gSubtitle(paramLong, new Cue(new DataInputStream(paramInputStream).readUTF()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.tx3g.Tx3gParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */