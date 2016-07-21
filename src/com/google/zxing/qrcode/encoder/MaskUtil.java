package com.google.zxing.qrcode.encoder;

final class MaskUtil
{
  static int applyMaskPenaltyRule1Internal(ByteMatrix paramByteMatrix, boolean paramBoolean)
  {
    int i = 0;
    int m;
    int n;
    label22:
    int i1;
    if (paramBoolean)
    {
      m = height;
      if (!paramBoolean) {
        break label113;
      }
      n = width;
      paramByteMatrix = bytes;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= m) {
        return i;
      }
      int i3 = 0;
      int k = -1;
      int i2 = 0;
      label46:
      if (i2 < n)
      {
        if (paramBoolean)
        {
          j = paramByteMatrix[i1][i2];
          label65:
          if (j != k) {
            break label133;
          }
          i3 += 1;
          j = k;
          k = i;
        }
        for (i = i3;; i = 1)
        {
          i2 += 1;
          i3 = i;
          i = k;
          k = j;
          break label46;
          m = width;
          break;
          label113:
          n = height;
          break label22;
          j = paramByteMatrix[i2][i1];
          break label65;
          label133:
          k = i;
          if (i3 >= 5) {
            k = i + (i3 - 5 + 3);
          }
        }
      }
      int j = i;
      if (i3 >= 5) {
        j = i + (i3 - 5 + 3);
      }
      i1 += 1;
      i = j;
    }
    return i;
  }
  
  static boolean isWhiteHorizontal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramInt1 < paramInt2)
      {
        if ((paramInt1 >= 0) && (paramInt1 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt1] == 1)) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      paramInt1 += 1;
    }
  }
  
  static boolean isWhiteVertical(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramInt2 < paramInt3)
      {
        if ((paramInt2 >= 0) && (paramInt2 < paramArrayOfByte.length) && (paramArrayOfByte[paramInt2][paramInt1] == 1)) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      paramInt2 += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.encoder.MaskUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */