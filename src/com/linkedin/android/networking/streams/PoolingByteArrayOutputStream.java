package com.linkedin.android.networking.streams;

import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoolingByteArrayOutputStream
  extends ByteArrayOutputStream
{
  private final ByteArrayPool mPool;
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool)
  {
    this(paramByteArrayPool, 256);
  }
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    mPool = paramByteArrayPool;
    buf = mPool.getBuf(Math.max(paramInt, 256));
  }
  
  private void expand(int paramInt)
  {
    if (count + paramInt <= buf.length) {
      return;
    }
    byte[] arrayOfByte = mPool.getBuf((count + paramInt) * 2);
    System.arraycopy(buf, 0, arrayOfByte, 0, count);
    mPool.returnBuf(buf);
    buf = arrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    mPool.returnBuf(buf);
    buf = null;
    super.close();
  }
  
  public void finalize()
  {
    mPool.returnBuf(buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      expand(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      expand(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.streams.PoolingByteArrayOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */