package com.google.android.exoplayer.extractor;

import java.io.IOException;

public abstract interface Extractor
{
  public abstract void init(ExtractorOutput paramExtractorOutput);
  
  public abstract int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException;
  
  public abstract void seek();
  
  public abstract boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException;
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.Extractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */