package com.google.zxing.common;

public final class BitMatrix
{
  public final int[] bits;
  public final int height;
  public final int rowSize;
  public final int width;
  
  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
    width = paramInt1;
    height = paramInt2;
    rowSize = (paramInt1 + 31 >> 5);
    bits = new int[rowSize * paramInt2];
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitMatrix)) {}
    do
    {
      return false;
      paramObject = (BitMatrix)paramObject;
    } while ((width != width) || (height != height) || (rowSize != rowSize) || (bits.length != bits.length));
    int i = 0;
    for (;;)
    {
      if (i >= bits.length) {
        break label93;
      }
      if (bits[i] != bits[i]) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  public final int hashCode()
  {
    int j = ((width * 31 + width) * 31 + height) * 31 + rowSize;
    int[] arrayOfInt = bits;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public final void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0)) {
      throw new IllegalArgumentException("Left and top must be nonnegative");
    }
    if ((paramInt4 <= 0) || (paramInt3 <= 0)) {
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > height) || (i > width)) {
      throw new IllegalArgumentException("The region must fit inside the matrix");
    }
    while (paramInt2 < paramInt4)
    {
      int j = rowSize;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        int[] arrayOfInt = bits;
        int k = (paramInt3 >> 5) + paramInt2 * j;
        arrayOfInt[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
      paramInt2 += 1;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(height * (width + 1));
    int i = 0;
    while (i < height)
    {
      int j = 0;
      if (j < width)
      {
        int k = rowSize;
        if ((bits[(k * i + (j >> 5))] >>> (j & 0x1F) & 0x1) != 0)
        {
          k = 1;
          label69:
          if (k == 0) {
            break label97;
          }
        }
        label97:
        for (String str = "X ";; str = "  ")
        {
          localStringBuilder.append(str);
          j += 1;
          break;
          k = 0;
          break label69;
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.common.BitMatrix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */