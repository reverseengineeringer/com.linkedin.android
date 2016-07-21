package com.google.android.exoplayer.extractor.webm;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer
{
  int peekLength;
  final ParsableByteArray scratch = new ParsableByteArray(8);
  
  final long readUint(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    paramExtractorInput.peekFully(scratch.data, 0, 1);
    int k = scratch.data[0] & 0xFF;
    if (k == 0) {
      return Long.MIN_VALUE;
    }
    int j = 128;
    int i = 0;
    while ((k & j) == 0)
    {
      j >>= 1;
      i += 1;
    }
    k &= (j ^ 0xFFFFFFFF);
    paramExtractorInput.peekFully(scratch.data, 1, i);
    j = 0;
    while (j < i)
    {
      k = (k << 8) + (scratch.data[(j + 1)] & 0xFF);
      j += 1;
    }
    peekLength += i + 1;
    return k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.webm.Sniffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */