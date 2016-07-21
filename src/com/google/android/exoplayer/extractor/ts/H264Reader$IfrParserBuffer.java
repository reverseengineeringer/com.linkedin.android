package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.util.ParsableBitArray;

final class H264Reader$IfrParserBuffer
{
  byte[] ifrData = new byte[''];
  int ifrLength;
  boolean isFilling;
  final ParsableBitArray scratchSliceType = new ParsableBitArray(ifrData);
  int sliceType;
  
  public H264Reader$IfrParserBuffer()
  {
    reset();
  }
  
  public final void reset()
  {
    isFilling = false;
    ifrLength = 0;
    sliceType = -1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.H264Reader.IfrParserBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */