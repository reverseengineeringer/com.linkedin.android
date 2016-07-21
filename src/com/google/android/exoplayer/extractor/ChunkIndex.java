package com.google.android.exoplayer.extractor;

public final class ChunkIndex
  implements SeekMap
{
  public final long[] durationsUs;
  public final int length;
  public final long[] offsets;
  public final int[] sizes;
  public final long[] timesUs;
  
  public ChunkIndex(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    length = paramArrayOfInt.length;
    sizes = paramArrayOfInt;
    offsets = paramArrayOfLong1;
    durationsUs = paramArrayOfLong2;
    timesUs = paramArrayOfLong3;
  }
  
  public final long getPosition(long paramLong)
  {
    return offsets[com.google.android.exoplayer.util.Util.binarySearchFloor(timesUs, paramLong, true, true)];
  }
  
  public final boolean isSeekable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ChunkIndex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */