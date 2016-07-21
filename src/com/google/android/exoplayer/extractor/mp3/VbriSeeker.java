package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;

final class VbriSeeker
  implements Mp3Extractor.Seeker
{
  private final long basePosition;
  private final long durationUs;
  private final long[] positions;
  private final long[] timesUs;
  
  private VbriSeeker(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long paramLong1, long paramLong2)
  {
    timesUs = paramArrayOfLong1;
    positions = paramArrayOfLong2;
    basePosition = paramLong1;
    durationUs = paramLong2;
  }
  
  public static VbriSeeker create(MpegAudioHeader paramMpegAudioHeader, ParsableByteArray paramParsableByteArray, long paramLong)
  {
    paramParsableByteArray.skipBytes(10);
    int i = paramParsableByteArray.readInt();
    if (i <= 0) {
      return null;
    }
    int j = sampleRate;
    long l1 = i;
    if (j >= 32000) {}
    long l2;
    int m;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    long l3;
    for (i = 1152;; i = 576)
    {
      l2 = Util.scaleLargeTimestamp(l1, 1000000L * i, j);
      int k = paramParsableByteArray.readUnsignedShort();
      m = paramParsableByteArray.readUnsignedShort();
      int n = paramParsableByteArray.readUnsignedShort();
      arrayOfLong1 = new long[k];
      arrayOfLong2 = new long[k];
      l3 = l2 / k;
      l1 = 0L;
      j = 0;
      if (j >= k) {
        break;
      }
      switch (n)
      {
      default: 
        return null;
      }
    }
    i = paramParsableByteArray.readUnsignedByte();
    for (;;)
    {
      l1 += l3;
      arrayOfLong1[j] = l1;
      paramLong += i * m;
      arrayOfLong2[j] = paramLong;
      j += 1;
      break;
      i = paramParsableByteArray.readUnsignedShort();
      continue;
      i = paramParsableByteArray.readUnsignedInt24();
      continue;
      i = paramParsableByteArray.readUnsignedIntToInt();
    }
    return new VbriSeeker(arrayOfLong1, arrayOfLong2, frameSize + paramLong, l2);
  }
  
  public final long getDurationUs()
  {
    return durationUs;
  }
  
  public final long getPosition(long paramLong)
  {
    int i = Util.binarySearchFloor(timesUs, paramLong, false, false);
    long l = basePosition;
    if (i == -1) {}
    for (paramLong = 0L;; paramLong = positions[i]) {
      return paramLong + l;
    }
  }
  
  public final long getTimeUs(long paramLong)
  {
    return timesUs[Util.binarySearchFloor(positions, paramLong, true, true)];
  }
  
  public final boolean isSeekable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp3.VbriSeeker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */