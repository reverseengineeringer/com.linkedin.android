package com.fasterxml.jackson.core.util;

public final class BufferRecycler
{
  private static final int[] BYTE_BUFFER_LENGTHS = { 8000, 8000, 2000, 2000 };
  private static final int[] CHAR_BUFFER_LENGTHS = { 4000, 4000, 200, 200 };
  protected final byte[][] _byteBuffers = new byte[4][];
  protected final char[][] _charBuffers = new char[4][];
  
  public BufferRecycler()
  {
    this((byte)0);
  }
  
  private BufferRecycler(byte paramByte) {}
  
  public final byte[] allocByteBuffer(int paramInt)
  {
    int i = BYTE_BUFFER_LENGTHS[paramInt];
    if (i > 0) {}
    for (;;)
    {
      byte[] arrayOfByte = _byteBuffers[paramInt];
      if ((arrayOfByte == null) || (arrayOfByte.length < i)) {
        return new byte[i];
      }
      _byteBuffers[paramInt] = null;
      return arrayOfByte;
      i = 0;
    }
  }
  
  public final char[] allocCharBuffer(int paramInt)
  {
    return allocCharBuffer(paramInt, 0);
  }
  
  public final char[] allocCharBuffer(int paramInt1, int paramInt2)
  {
    int j = CHAR_BUFFER_LENGTHS[paramInt1];
    int i = paramInt2;
    if (paramInt2 < j) {
      i = j;
    }
    char[] arrayOfChar = _charBuffers[paramInt1];
    if ((arrayOfChar == null) || (arrayOfChar.length < i)) {
      return new char[i];
    }
    _charBuffers[paramInt1] = null;
    return arrayOfChar;
  }
  
  public final void releaseByteBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    _byteBuffers[paramInt] = paramArrayOfByte;
  }
  
  public final void releaseCharBuffer(int paramInt, char[] paramArrayOfChar)
  {
    _charBuffers[paramInt] = paramArrayOfChar;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.BufferRecycler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */