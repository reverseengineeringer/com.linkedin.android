package com.google.android.exoplayer.util;

public final class ParsableBitArray
{
  private int bitOffset;
  private int byteLimit;
  private int byteOffset;
  public byte[] data;
  
  public ParsableBitArray() {}
  
  public ParsableBitArray(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private ParsableBitArray(byte[] paramArrayOfByte, int paramInt)
  {
    data = paramArrayOfByte;
    byteLimit = paramInt;
  }
  
  private void assertValidOffset()
  {
    if ((byteOffset >= 0) && (bitOffset >= 0) && (bitOffset < 8) && ((byteOffset < byteLimit) || ((byteOffset == byteLimit) && (bitOffset == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      return;
    }
  }
  
  public final int bitsLeft()
  {
    return (byteLimit - byteOffset) * 8 - bitOffset;
  }
  
  public final int peekExpGolombCodedNumLength()
  {
    int k = byteOffset;
    int m = bitOffset;
    int i = 0;
    while ((byteOffset < byteLimit) && (!readBit())) {
      i += 1;
    }
    if (byteOffset == byteLimit) {}
    for (int j = 1;; j = 0)
    {
      byteOffset = k;
      bitOffset = m;
      if (j == 0) {
        break;
      }
      return -1;
    }
    return i * 2 + 1;
  }
  
  public final boolean readBit()
  {
    return readBits(1) == 1;
  }
  
  public final int readBits(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (i >= 8)
    {
      if (bitOffset != 0) {}
      for (j = (data[byteOffset] & 0xFF) << bitOffset | (data[(byteOffset + 1)] & 0xFF) >>> 8 - bitOffset;; j = data[byteOffset])
      {
        i -= 8;
        paramInt |= (j & 0xFF) << i;
        byteOffset += 1;
        break;
      }
    }
    j = paramInt;
    if (i > 0)
    {
      j = bitOffset + i;
      i = (byte)(255 >> 8 - i);
      if (j <= 8) {
        break label208;
      }
      paramInt |= ((data[byteOffset] & 0xFF) << j - 8 | (data[(byteOffset + 1)] & 0xFF) >> 16 - j) & i;
      byteOffset += 1;
    }
    for (;;)
    {
      bitOffset = (j % 8);
      j = paramInt;
      assertValidOffset();
      return j;
      label208:
      i = paramInt | (data[byteOffset] & 0xFF) >> 8 - j & i;
      paramInt = i;
      if (j == 8)
      {
        byteOffset += 1;
        paramInt = i;
      }
    }
  }
  
  public final int readExpGolombCodeNum()
  {
    int i = 0;
    while (!readBit()) {
      i += 1;
    }
    if (i > 0) {}
    for (int j = readBits(i);; j = 0) {
      return j + ((1 << i) - 1);
    }
  }
  
  public final int readSignedExpGolombCodedInt()
  {
    int j = readExpGolombCodeNum();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1) {
      return i * ((j + 1) / 2);
    }
  }
  
  public final int readUnsignedExpGolombCodedInt()
  {
    return readExpGolombCodeNum();
  }
  
  public final void reset(byte[] paramArrayOfByte, int paramInt)
  {
    data = paramArrayOfByte;
    byteOffset = 0;
    bitOffset = 0;
    byteLimit = paramInt;
  }
  
  public final void setPosition$13462e()
  {
    byteOffset = 0;
    bitOffset = (0 - byteOffset * 8);
    assertValidOffset();
  }
  
  public final void skipBits(int paramInt)
  {
    byteOffset += paramInt / 8;
    bitOffset += paramInt % 8;
    if (bitOffset > 7)
    {
      byteOffset += 1;
      bitOffset -= 8;
    }
    assertValidOffset();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.ParsableBitArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */