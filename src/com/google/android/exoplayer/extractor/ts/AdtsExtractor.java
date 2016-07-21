package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

public final class AdtsExtractor
  implements Extractor
{
  private AdtsReader adtsReader;
  private boolean firstPacket;
  private final long firstSampleTimestampUs;
  private final ParsableByteArray packetBuffer;
  
  public AdtsExtractor()
  {
    this(0L);
  }
  
  public AdtsExtractor(long paramLong)
  {
    firstSampleTimestampUs = paramLong;
    packetBuffer = new ParsableByteArray(200);
    firstPacket = true;
  }
  
  public final void init(ExtractorOutput paramExtractorOutput)
  {
    adtsReader = new AdtsReader(paramExtractorOutput.track(0));
    paramExtractorOutput.endTracks();
    paramExtractorOutput.seekMap(SeekMap.UNSEEKABLE);
  }
  
  public final int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
    throws IOException, InterruptedException
  {
    int i = paramExtractorInput.read(packetBuffer.data, 0, 200);
    if (i == -1) {
      return -1;
    }
    packetBuffer.setPosition(0);
    packetBuffer.setLimit(i);
    adtsReader.consume(packetBuffer, firstSampleTimestampUs, firstPacket);
    firstPacket = false;
    return 0;
  }
  
  public final void seek()
  {
    firstPacket = true;
    adtsReader.seek();
  }
  
  public final boolean sniff(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    boolean bool = false;
    ParsableByteArray localParsableByteArray = new ParsableByteArray(10);
    paramExtractorInput.peekFully(data, 0, 10);
    int i = localParsableByteArray.readUnsignedInt24();
    if (i != Util.getIntegerCodeForString("ID3")) {
      i >>= 8;
    }
    for (;;)
    {
      if ((0xFFF6 & i) == 65520) {
        bool = true;
      }
      return bool;
      paramExtractorInput.advancePeekPosition((data[6] & 0x7F) << 21 | (data[7] & 0x7F) << 14 | (data[8] & 0x7F) << 7 | data[9] & 0x7F);
      paramExtractorInput.peekFully(data, 0, 2);
      localParsableByteArray.setPosition(0);
      i = localParsableByteArray.readUnsignedShort();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.AdtsExtractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */