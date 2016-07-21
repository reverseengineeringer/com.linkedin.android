package com.google.zxing.qrcode;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;

public final class QRCodeWriter
{
  public static BitMatrix renderResult(QRCode paramQRCode, int paramInt1, int paramInt2, int paramInt3)
  {
    paramQRCode = matrix;
    if (paramQRCode == null) {
      throw new IllegalStateException();
    }
    int k = width;
    int m = height;
    int i = k + (paramInt3 << 1);
    int j = m + (paramInt3 << 1);
    paramInt3 = Math.max(paramInt1, i);
    paramInt2 = Math.max(paramInt2, j);
    int n = Math.min(paramInt3 / i, paramInt2 / j);
    j = (paramInt3 - k * n) / 2;
    paramInt1 = (paramInt2 - m * n) / 2;
    BitMatrix localBitMatrix = new BitMatrix(paramInt3, paramInt2);
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      i = 0;
      paramInt3 = j;
      while (i < k)
      {
        if (paramQRCode.get(i, paramInt2) == 1) {
          localBitMatrix.setRegion(paramInt3, paramInt1, n, n);
        }
        i += 1;
        paramInt3 += n;
      }
      paramInt2 += 1;
      paramInt1 += n;
    }
    return localBitMatrix;
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.QRCodeWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */