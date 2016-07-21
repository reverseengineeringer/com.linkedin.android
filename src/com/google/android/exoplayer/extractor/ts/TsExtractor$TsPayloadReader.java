package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableByteArray;

abstract class TsExtractor$TsPayloadReader
{
  public abstract void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput);
  
  public abstract void seek();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.TsExtractor.TsPayloadReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */