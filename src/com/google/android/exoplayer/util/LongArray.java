package com.google.android.exoplayer.util;

import java.util.Arrays;

public final class LongArray
{
  public int size;
  public long[] values = new long[32];
  
  public LongArray()
  {
    this((byte)0);
  }
  
  private LongArray(byte paramByte) {}
  
  public final void add(long paramLong)
  {
    if (size == values.length) {
      values = Arrays.copyOf(values, size * 2);
    }
    long[] arrayOfLong = values;
    int i = size;
    size = (i + 1);
    arrayOfLong[i] = paramLong;
  }
  
  public final long get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size)) {
      throw new IndexOutOfBoundsException("Invalid size " + paramInt + ", size is " + size);
    }
    return values[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.LongArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */