package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix
{
  final byte[][] bytes;
  public final int height;
  public final int width;
  
  public ByteMatrix(int paramInt1, int paramInt2)
  {
    bytes = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    width = paramInt1;
    height = paramInt2;
  }
  
  public final byte get(int paramInt1, int paramInt2)
  {
    return bytes[paramInt2][paramInt1];
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3)
  {
    bytes[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public final void set(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = bytes[paramInt2];
    if (paramBoolean) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      arrayOfByte[paramInt1] = ((byte)paramInt2);
      return;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(width * 2 * height + 2);
    int i = 0;
    while (i < height)
    {
      int j = 0;
      if (j < width)
      {
        switch (bytes[i][j])
        {
        default: 
          localStringBuilder.append("  ");
        }
        for (;;)
        {
          j += 1;
          break;
          localStringBuilder.append(" 0");
          continue;
          localStringBuilder.append(" 1");
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.encoder.ByteMatrix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */