package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.util.Util;

public final class ExtractorSampleSource$UnrecognizedInputFormatException
  extends ParserException
{
  public ExtractorSampleSource$UnrecognizedInputFormatException(Extractor[] paramArrayOfExtractor)
  {
    super("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(paramArrayOfExtractor) + ") could read the stream.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ExtractorSampleSource.UnrecognizedInputFormatException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */