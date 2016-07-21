package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.util.Assertions;

final class TrackSampleTable
{
  public final int[] flags;
  public final long[] offsets;
  public final int sampleCount;
  public final int[] sizes;
  public final long[] timestampsUs;
  
  TrackSampleTable(long[] paramArrayOfLong1, int[] paramArrayOfInt1, long[] paramArrayOfLong2, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length == paramArrayOfLong2.length)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        break label88;
      }
      bool1 = true;
      label32:
      Assertions.checkArgument(bool1);
      if (paramArrayOfInt2.length != paramArrayOfLong2.length) {
        break label94;
      }
    }
    label88:
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      offsets = paramArrayOfLong1;
      sizes = paramArrayOfInt1;
      timestampsUs = paramArrayOfLong2;
      flags = paramArrayOfInt2;
      sampleCount = paramArrayOfLong1.length;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.TrackSampleTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */