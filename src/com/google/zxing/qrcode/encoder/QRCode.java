package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode
{
  ErrorCorrectionLevel ecLevel;
  int maskPattern = -1;
  public ByteMatrix matrix;
  Mode mode;
  Version version;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(mode);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(ecLevel);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(version);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(maskPattern);
    if (matrix == null) {
      localStringBuilder.append("\n matrix: null\n");
    }
    for (;;)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(matrix.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.encoder.QRCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */