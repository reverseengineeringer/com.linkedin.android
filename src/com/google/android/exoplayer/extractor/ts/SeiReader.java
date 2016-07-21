package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.text.eia608.Eia608Parser;
import com.google.android.exoplayer.util.ParsableByteArray;

final class SeiReader
  extends ElementaryStreamReader
{
  public SeiReader(TrackOutput paramTrackOutput)
  {
    super(paramTrackOutput);
    paramTrackOutput.format(MediaFormat.createTextFormat("application/eia-608", -1L));
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, long paramLong, boolean paramBoolean)
  {
    while (paramParsableByteArray.bytesLeft() > 1)
    {
      int i = 0;
      int k;
      int j;
      do
      {
        k = paramParsableByteArray.readUnsignedByte();
        j = i + k;
        i = j;
      } while (k == 255);
      i = 0;
      int m;
      do
      {
        m = paramParsableByteArray.readUnsignedByte();
        k = i + m;
        i = k;
      } while (m == 255);
      if (Eia608Parser.isSeiMessageEia608(j, k, paramParsableByteArray))
      {
        output.sampleData(paramParsableByteArray, k);
        output.sampleMetadata(paramLong, 1, k, 0, null);
      }
      else
      {
        paramParsableByteArray.skipBytes(k);
      }
    }
  }
  
  public final void packetFinished() {}
  
  public final void seek() {}
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.SeiReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */