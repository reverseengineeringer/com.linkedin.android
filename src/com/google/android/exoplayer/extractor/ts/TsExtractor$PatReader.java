package com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

final class TsExtractor$PatReader
  extends TsExtractor.TsPayloadReader
{
  private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);
  
  public TsExtractor$PatReader(TsExtractor paramTsExtractor)
  {
    super((byte)0);
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput)
  {
    if (paramBoolean) {
      paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedByte());
    }
    paramParsableByteArray.readBytes(patScratch, 3);
    patScratch.skipBits(12);
    int i = patScratch.readBits(12);
    paramParsableByteArray.skipBytes(5);
    int j = (i - 9) / 4;
    i = 0;
    while (i < j)
    {
      paramParsableByteArray.readBytes(patScratch, 4);
      patScratch.skipBits(19);
      int k = patScratch.readBits(13);
      this$0.tsPayloadReaders.put(k, new TsExtractor.PmtReader(this$0));
      i += 1;
    }
  }
  
  public final void seek() {}
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.TsExtractor.PatReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */