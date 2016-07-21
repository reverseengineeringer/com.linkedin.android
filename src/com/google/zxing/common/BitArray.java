package com.google.zxing.common;

public final class BitArray
{
  public int[] bits;
  public int size;
  
  public BitArray()
  {
    size = 0;
    bits = new int[1];
  }
  
  public BitArray(int paramInt)
  {
    size = paramInt;
    bits = makeArray(paramInt);
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > bits.length * 32)
    {
      int[] arrayOfInt = makeArray(paramInt);
      System.arraycopy(bits, 0, arrayOfInt, 0, bits.length);
      bits = arrayOfInt;
    }
  }
  
  private static int[] makeArray(int paramInt)
  {
    return new int[(paramInt + 31) / 32];
  }
  
  public final void appendBit(boolean paramBoolean)
  {
    ensureCapacity(size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = bits;
      int i = size / 32;
      arrayOfInt[i] |= 1 << (size & 0x1F);
    }
    size += 1;
  }
  
  public final void appendBitArray(BitArray paramBitArray)
  {
    int j = size;
    ensureCapacity(size + j);
    int i = 0;
    while (i < j)
    {
      appendBit(paramBitArray.get(i));
      i += 1;
    }
  }
  
  public final void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    ensureCapacity(size + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        appendBit(bool);
        paramInt2 -= 1;
        break;
      }
    }
  }
  
  public final boolean get(int paramInt)
  {
    return (bits[(paramInt / 32)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public final int getSizeInBytes()
  {
    return (size + 7) / 8;
  }
  
  public final void toBytes$101cc16b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      int k = 0;
      j = 0;
      while (j < 8)
      {
        int m = k;
        if (get(i)) {
          m = k | 1 << 7 - j;
        }
        i += 1;
        j += 1;
        k = m;
      }
      paramArrayOfByte[(paramInt1 + 0)] = ((byte)k);
      paramInt1 += 1;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(size);
    int i = 0;
    if (i < size)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      if (get(i)) {}
      for (char c = 'X';; c = '.')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.common.BitArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */