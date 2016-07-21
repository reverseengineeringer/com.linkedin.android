package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.ExtractorInput;
import java.io.IOException;

abstract interface EbmlReaderOutput
{
  public abstract void binaryElement(int paramInt1, int paramInt2, ExtractorInput paramExtractorInput)
    throws ParserException, IOException, InterruptedException;
  
  public abstract void endMasterElement(int paramInt)
    throws ParserException;
  
  public abstract void floatElement(int paramInt, double paramDouble)
    throws ParserException;
  
  public abstract int getElementType(int paramInt);
  
  public abstract void integerElement(int paramInt, long paramLong)
    throws ParserException;
  
  public abstract void startMasterElement(int paramInt, long paramLong1, long paramLong2)
    throws ParserException;
  
  public abstract void stringElement(int paramInt, String paramString)
    throws ParserException;
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.EbmlReaderOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */