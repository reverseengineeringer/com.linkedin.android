package com.linkedin.android.networking.streams;

import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class PoolingBufferedInputStream
  extends FilterInputStream
{
  private volatile byte[] buf;
  private final ByteArrayPool byteArrayPool;
  protected int count;
  protected int marklimit;
  protected int markpos = -1;
  protected int pos;
  
  public PoolingBufferedInputStream(InputStream paramInputStream, ByteArrayPool paramByteArrayPool)
  {
    super(paramInputStream);
    byteArrayPool = paramByteArrayPool;
    buf = paramByteArrayPool.getBuf(4096);
  }
  
  private int fillbuf(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((markpos == -1) || (pos - markpos >= marklimit))
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (i > 0)
      {
        markpos = -1;
        pos = 0;
        count = i;
      }
      return i;
    }
    int j;
    byte[] arrayOfByte;
    if ((markpos == 0) && (marklimit > paramArrayOfByte.length))
    {
      j = paramArrayOfByte.length * 2;
      i = j;
      if (j > marklimit) {
        i = marklimit;
      }
      arrayOfByte = byteArrayPool.getBuf(i);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = arrayOfByte;
      byteArrayPool.returnBuf(buf);
      buf = arrayOfByte;
      arrayOfByte = paramArrayOfByte;
      pos -= markpos;
      markpos = 0;
      count = 0;
      j = paramInputStream.read(arrayOfByte, pos, arrayOfByte.length - pos);
      if (j > 0) {
        break label227;
      }
    }
    label227:
    for (int i = pos;; i = pos + j)
    {
      count = i;
      return j;
      arrayOfByte = paramArrayOfByte;
      if (markpos <= 0) {
        break;
      }
      System.arraycopy(paramArrayOfByte, markpos, paramArrayOfByte, 0, paramArrayOfByte.length - markpos);
      arrayOfByte = paramArrayOfByte;
      break;
    }
  }
  
  private static IOException streamClosed()
    throws IOException
  {
    throw new IOException("BufferedInputStream is closed");
  }
  
  public final int available()
    throws IOException
  {
    try
    {
      InputStream localInputStream = in;
      if ((buf == null) || (localInputStream == null)) {
        throw streamClosed();
      }
    }
    finally {}
    int i = count;
    int j = pos;
    int k = ((InputStream)localObject).available();
    return i - j + k;
  }
  
  public final void close()
    throws IOException
  {
    byteArrayPool.returnBuf(buf);
    if (in != null) {
      in.close();
    }
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      marklimit = paramInt;
      markpos = pos;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
    throws IOException
  {
    int i = -1;
    byte[] arrayOfByte2;
    try
    {
      arrayOfByte2 = buf;
      InputStream localInputStream1 = in;
      if ((arrayOfByte2 == null) || (localInputStream1 == null)) {
        throw streamClosed();
      }
    }
    finally {}
    if (pos >= count)
    {
      int j = fillbuf(localInputStream2, arrayOfByte2);
      if (j != -1) {}
    }
    for (;;)
    {
      return i;
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 != buf)
      {
        arrayOfByte2 = buf;
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          throw streamClosed();
        }
      }
      if (count - pos > 0)
      {
        i = pos;
        pos = (i + 1);
        i = arrayOfByte1[i];
        i &= 0xFF;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject2;
    try
    {
      localObject2 = buf;
      if (localObject2 == null) {
        throw streamClosed();
      }
    }
    finally {}
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      InputStream localInputStream = in;
      if (localInputStream == null) {
        throw streamClosed();
      }
      int j;
      label133:
      int k;
      Object localObject1;
      if (pos < count)
      {
        if (count - pos >= paramInt2) {}
        for (j = paramInt2;; j = count - pos)
        {
          System.arraycopy(localObject2, pos, paramArrayOfByte, paramInt1, j);
          pos += j;
          i = j;
          if (j == paramInt2) {
            break;
          }
          i = j;
          if (localInputStream.available() == 0) {
            break;
          }
          paramInt1 += j;
          i = paramInt2 - j;
          if ((markpos != -1) || (i < localObject2.length)) {
            break label200;
          }
          k = localInputStream.read(paramArrayOfByte, paramInt1, i);
          localObject1 = localObject2;
          j = k;
          if (k != -1) {
            break label372;
          }
          if (i != paramInt2) {
            break label354;
          }
          i = -1;
          break;
        }
        label200:
        if (fillbuf(localInputStream, (byte[])localObject2) == -1)
        {
          if (i != paramInt2) {
            break label363;
          }
          i = -1;
          continue;
        }
        localObject1 = localObject2;
        if (localObject2 != buf)
        {
          localObject2 = buf;
          localObject1 = localObject2;
          if (localObject2 == null) {
            throw streamClosed();
          }
        }
        if (count - pos >= i) {}
        for (j = i;; j = count - pos)
        {
          System.arraycopy(localObject1, pos, paramArrayOfByte, paramInt1, j);
          pos += j;
          break;
        }
      }
      label354:
      label363:
      label372:
      do
      {
        k = localInputStream.available();
        if (k == 0)
        {
          i = paramInt2 - i;
          break;
        }
        paramInt1 += j;
        localObject2 = localObject1;
        break label133;
        i = paramInt2;
        break label133;
        i = paramInt2 - i;
        break;
        i = paramInt2 - i;
        break;
        i -= j;
      } while (i != 0);
      i = paramInt2;
    }
  }
  
  public final void reset()
    throws IOException
  {
    try
    {
      if (buf == null) {
        throw new IOException("Stream is closed");
      }
    }
    finally {}
    if (markpos == -1) {
      throw new IOException("Mark has been invalidated.");
    }
    pos = markpos;
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    InputStream localInputStream;
    try
    {
      byte[] arrayOfByte1 = buf;
      localInputStream = in;
      if (arrayOfByte1 == null) {
        throw streamClosed();
      }
    }
    finally {}
    if (paramLong < 1L) {
      paramLong = 0L;
    }
    for (;;)
    {
      return paramLong;
      if (localInputStream == null) {
        throw streamClosed();
      }
      if (count - pos >= paramLong)
      {
        pos = ((int)(pos + paramLong));
      }
      else
      {
        long l = count - pos;
        pos = count;
        if ((markpos != -1) && (paramLong <= marklimit))
        {
          if (fillbuf(localInputStream, arrayOfByte2) == -1)
          {
            paramLong = l;
          }
          else if (count - pos >= paramLong - l)
          {
            pos = ((int)(pos + (paramLong - l)));
          }
          else
          {
            paramLong = count - pos;
            pos = count;
            paramLong = l + paramLong;
          }
        }
        else
        {
          paramLong = localInputStream.skip(paramLong - l);
          paramLong = l + paramLong;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.streams.PoolingBufferedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */