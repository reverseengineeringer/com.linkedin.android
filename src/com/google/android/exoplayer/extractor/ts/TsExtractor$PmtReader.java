package com.google.android.exoplayer.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;

final class TsExtractor$PmtReader
  extends TsExtractor.TsPayloadReader
{
  private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
  
  public TsExtractor$PmtReader(TsExtractor paramTsExtractor)
  {
    super((byte)0);
  }
  
  public final void consume(ParsableByteArray paramParsableByteArray, boolean paramBoolean, ExtractorOutput paramExtractorOutput)
  {
    if (paramBoolean) {
      paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedByte());
    }
    paramParsableByteArray.readBytes(pmtScratch, 3);
    pmtScratch.skipBits(12);
    int i = pmtScratch.readBits(12);
    paramParsableByteArray.skipBytes(7);
    paramParsableByteArray.readBytes(pmtScratch, 2);
    pmtScratch.skipBits(4);
    int j = pmtScratch.readBits(12);
    paramParsableByteArray.skipBytes(j);
    if (this$0.id3Reader == null) {
      this$0.id3Reader = new Id3Reader(paramExtractorOutput.track(21));
    }
    i = i - 9 - j - 4;
    while (i > 0)
    {
      paramParsableByteArray.readBytes(pmtScratch, 5);
      int k = pmtScratch.readBits(8);
      pmtScratch.skipBits(3);
      int m = pmtScratch.readBits(13);
      pmtScratch.skipBits(4);
      j = pmtScratch.readBits(12);
      paramParsableByteArray.skipBytes(j);
      j = i - (j + 5);
      i = j;
      if (!this$0.streamTypes.get(k))
      {
        Object localObject = null;
        switch (k)
        {
        }
        for (;;)
        {
          i = j;
          if (localObject == null) {
            break;
          }
          this$0.streamTypes.put(k, true);
          this$0.tsPayloadReaders.put(m, new TsExtractor.PesReader(this$0, (ElementaryStreamReader)localObject));
          i = j;
          break;
          localObject = new MpegAudioReader(paramExtractorOutput.track(3));
          continue;
          localObject = new MpegAudioReader(paramExtractorOutput.track(4));
          continue;
          localObject = new AdtsReader(paramExtractorOutput.track(15));
          continue;
          i = j;
          if (!this$0.allowedPassthroughStreamTypes.get(k)) {
            break;
          }
          localObject = new Ac3Reader(paramExtractorOutput.track(k));
          continue;
          localObject = new H264Reader(paramExtractorOutput.track(27), new SeiReader(paramExtractorOutput.track(256)), TsExtractor.access$100(this$0));
          continue;
          localObject = new H265Reader(paramExtractorOutput.track(36), new SeiReader(paramExtractorOutput.track(256)));
          continue;
          localObject = this$0.id3Reader;
        }
      }
    }
    paramExtractorOutput.endTracks();
  }
  
  public final void seek() {}
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.TsExtractor.PmtReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */