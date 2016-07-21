package com.linkedin.android.imageloader;

import java.io.IOException;
import java.io.InputStream;

final class LiImageHeaderParser$StreamReader
{
  final InputStream is;
  
  public LiImageHeaderParser$StreamReader(InputStream paramInputStream)
  {
    is = paramInputStream;
  }
  
  public final int getUInt16()
    throws IOException
  {
    return is.read() << 8 & 0xFF00 | is.read() & 0xFF;
  }
  
  public final short getUInt8()
    throws IOException
  {
    return (short)(is.read() & 0xFF);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramInt;
    while (i > 0)
    {
      int j = is.read(paramArrayOfByte, paramInt - i, i);
      if (j == -1) {
        break;
      }
      i -= j;
    }
    return paramInt - i;
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      return 0L;
    }
    long l1 = paramLong;
    while (l1 > 0L)
    {
      long l2 = is.skip(l1);
      if (l2 > 0L)
      {
        l1 -= l2;
      }
      else
      {
        if (is.read() == -1) {
          break;
        }
        l1 -= 1L;
      }
    }
    return paramLong - l1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageHeaderParser.StreamReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */