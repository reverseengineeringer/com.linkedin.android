package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

final class XingSeeker
  implements Mp3Extractor.Seeker
{
  private final long durationUs;
  private final long firstFramePosition;
  private final long inputLength;
  private final long sizeBytes;
  private final long[] tableOfContents;
  
  private XingSeeker(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    tableOfContents = paramArrayOfLong;
    firstFramePosition = paramLong1;
    sizeBytes = paramLong2;
    durationUs = paramLong3;
    inputLength = paramLong4;
  }
  
  public static XingSeeker create(MpegAudioHeader paramMpegAudioHeader, ParsableByteArray paramParsableByteArray, long paramLong1, long paramLong2)
  {
    int i = samplesPerFrame;
    int j = sampleRate;
    long l1 = frameSize;
    if ((paramParsableByteArray.readInt() & 0x7) != 7) {
      return null;
    }
    int k = paramParsableByteArray.readUnsignedIntToInt();
    if (k == 0) {
      return null;
    }
    long l2 = Util.scaleLargeTimestamp(k, i * 1000000L, j);
    long l3 = paramParsableByteArray.readUnsignedIntToInt();
    paramParsableByteArray.skipBytes(1);
    paramMpegAudioHeader = new long[99];
    i = 0;
    while (i < 99)
    {
      paramMpegAudioHeader[i] = paramParsableByteArray.readUnsignedByte();
      i += 1;
    }
    return new XingSeeker(paramMpegAudioHeader, paramLong1 + l1, l3, l2, paramLong2);
  }
  
  private long getTimeUsForTocIndex(int paramInt)
  {
    return durationUs * (paramInt + 1) / 100L;
  }
  
  public final long getDurationUs()
  {
    return durationUs;
  }
  
  public final long getPosition(long paramLong)
  {
    float f3 = (float)paramLong * 100.0F / (float)durationUs;
    if (f3 <= 0.0F) {}
    for (float f1 = 0.0F;; f1 = 256.0F)
    {
      long l = (0.00390625F * f1 * (float)sizeBytes) + firstFramePosition;
      paramLong = l;
      if (inputLength != -1L) {
        paramLong = Math.min(l, inputLength - 1L);
      }
      return paramLong;
      if (f3 < 100.0F) {
        break;
      }
    }
    int i = (int)f3;
    if (i == 0)
    {
      f1 = 0.0F;
      label94:
      if (i >= 99) {
        break label142;
      }
    }
    label142:
    for (float f2 = (float)tableOfContents[i];; f2 = 256.0F)
    {
      f1 += (f2 - f1) * (f3 - i);
      break;
      f1 = (float)tableOfContents[(i - 1)];
      break label94;
    }
  }
  
  public final long getTimeUs(long paramLong)
  {
    long l1 = 256L * (paramLong - firstFramePosition) / sizeBytes;
    int i = Util.binarySearchFloor(tableOfContents, l1, true, false);
    long l2 = getTimeUsForTocIndex(i);
    if (i == 98) {
      return l2;
    }
    if (i == -1) {}
    for (paramLong = 0L;; paramLong = tableOfContents[i])
    {
      long l3 = tableOfContents[(i + 1)];
      return l2 + (getTimeUsForTocIndex(i + 1) - l2) * (l1 - paramLong) / (l3 - paramLong);
    }
  }
  
  public final boolean isSeekable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp3.XingSeeker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */