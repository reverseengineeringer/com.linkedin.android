package com.google.android.exoplayer.extractor;

import java.io.EOFException;
import java.io.IOException;

final class ExtractorSampleSource$ExtractorHolder
{
  private Extractor extractor;
  private final ExtractorOutput extractorOutput;
  private final Extractor[] extractors;
  
  public ExtractorSampleSource$ExtractorHolder(Extractor[] paramArrayOfExtractor, ExtractorOutput paramExtractorOutput)
  {
    extractors = paramArrayOfExtractor;
    extractorOutput = paramExtractorOutput;
  }
  
  public final Extractor selectExtractor(ExtractorInput paramExtractorInput)
    throws ExtractorSampleSource.UnrecognizedInputFormatException, IOException, InterruptedException
  {
    if (extractor != null) {
      return extractor;
    }
    Extractor[] arrayOfExtractor = extractors;
    int j = arrayOfExtractor.length;
    int i = 0;
    for (;;)
    {
      Extractor localExtractor;
      if (i < j) {
        localExtractor = arrayOfExtractor[i];
      }
      try
      {
        if (localExtractor.sniff(paramExtractorInput))
        {
          extractor = localExtractor;
          if (extractor != null) {
            break;
          }
          throw new ExtractorSampleSource.UnrecognizedInputFormatException(extractors);
        }
      }
      catch (EOFException localEOFException)
      {
        paramExtractorInput.resetPeekPosition();
        i += 1;
      }
    }
    extractor.init(extractorOutput);
    return extractor;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ExtractorSampleSource.ExtractorHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */