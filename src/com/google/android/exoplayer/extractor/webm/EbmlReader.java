package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.ExtractorInput;
import java.io.IOException;

abstract interface EbmlReader
{
  public abstract void init(EbmlReaderOutput paramEbmlReaderOutput);
  
  public abstract boolean read(ExtractorInput paramExtractorInput)
    throws ParserException, IOException, InterruptedException;
  
  public abstract void reset();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.EbmlReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */