package com.google.android.exoplayer.util;

public final class ParsableByteArray
{
  public byte[] data;
  public int limit;
  public int position;
  
  public ParsableByteArray() {}
  
  public ParsableByteArray(int paramInt)
  {
    data = new byte[paramInt];
    limit = data.length;
  }
  
  public ParsableByteArray(byte[] paramArrayOfByte)
  {
    data = paramArrayOfByte;
    limit = paramArrayOfByte.length;
  }
  
  public ParsableByteArray(byte[] paramArrayOfByte, int paramInt)
  {
    data = paramArrayOfByte;
    limit = paramInt;
  }
  
  public final int bytesLeft()
  {
    return limit - position;
  }
  
  public final void readBytes(ParsableBitArray paramParsableBitArray, int paramInt)
  {
    readBytes(data, 0, paramInt);
    paramParsableBitArray.setPosition$13462e();
  }
  
  public final void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(data, position, paramArrayOfByte, paramInt1, paramInt2);
    position += paramInt2;
  }
  
  public final int readInt()
  {
    byte[] arrayOfByte = data;
    int i = position;
    position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = data;
    int j = position;
    position = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = data;
    int k = position;
    position = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = data;
    int m = position;
    position = (m + 1);
    return (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
  }
  
  public final long readLong()
  {
    byte[] arrayOfByte = data;
    int i = position;
    position = (i + 1);
    long l1 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l2 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l3 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l4 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l5 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l6 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l7 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | arrayOfByte[i] & 0xFF;
  }
  
  public final int readSynchSafeInt()
  {
    return readUnsignedByte() << 21 | readUnsignedByte() << 14 | readUnsignedByte() << 7 | readUnsignedByte();
  }
  
  public final int readUnsignedByte()
  {
    byte[] arrayOfByte = data;
    int i = position;
    position = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final long readUnsignedInt()
  {
    byte[] arrayOfByte = data;
    int i = position;
    position = (i + 1);
    long l1 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l2 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    long l3 = arrayOfByte[i];
    arrayOfByte = data;
    i = position;
    position = (i + 1);
    return (l1 & 0xFF) << 24 | (l2 & 0xFF) << 16 | (l3 & 0xFF) << 8 | arrayOfByte[i] & 0xFF;
  }
  
  public final int readUnsignedInt24()
  {
    byte[] arrayOfByte = data;
    int i = position;
    position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = data;
    int j = position;
    position = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = data;
    int k = position;
    position = (k + 1);
    return (i & 0xFF) << 16 | (j & 0xFF) << 8 | arrayOfByte[k] & 0xFF;
  }
  
  public final int readUnsignedIntToInt()
  {
    int i = readInt();
    if (i < 0) {
      throw new IllegalStateException("Top bit not zero: " + i);
    }
    return i;
  }
  
  public final long readUnsignedLongToLong()
  {
    long l = readLong();
    if (l < 0L) {
      throw new IllegalStateException("Top bit not zero: " + l);
    }
    return l;
  }
  
  public final int readUnsignedShort()
  {
    byte[] arrayOfByte = data;
    int i = position;
    position = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = data;
    int j = position;
    position = (j + 1);
    return (i & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
  }
  
  public final void reset()
  {
    position = 0;
    limit = 0;
  }
  
  public final void reset(byte[] paramArrayOfByte, int paramInt)
  {
    data = paramArrayOfByte;
    limit = paramInt;
    position = 0;
  }
  
  public final void setLimit(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= data.length)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      limit = paramInt;
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= limit)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      position = paramInt;
      return;
    }
  }
  
  public final void skipBytes(int paramInt)
  {
    setPosition(position + paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.ParsableByteArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */