package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.IOException;

public abstract interface TrackOutput
{
  public abstract void format(MediaFormat paramMediaFormat);
  
  public abstract int sampleData(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException;
  
  public abstract void sampleData(ParsableByteArray paramParsableByteArray, int paramInt);
  
  public abstract void sampleMetadata(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.TrackOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */