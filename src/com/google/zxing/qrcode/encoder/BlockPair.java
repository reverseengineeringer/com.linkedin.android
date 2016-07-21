package com.google.zxing.qrcode.encoder;

final class BlockPair
{
  final byte[] dataBytes;
  final byte[] errorCorrectionBytes;
  
  BlockPair(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    dataBytes = paramArrayOfByte1;
    errorCorrectionBytes = paramArrayOfByte2;
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.encoder.BlockPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */