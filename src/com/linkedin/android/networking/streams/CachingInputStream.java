package com.linkedin.android.networking.streams;

import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class CachingInputStream
  extends FilterInputStream
{
  public final ChunkableByteArrayOutputStream outputStream;
  
  public CachingInputStream(InputStream paramInputStream, ByteArrayPool paramByteArrayPool, int paramInt)
  {
    super(paramInputStream);
    outputStream = new ChunkableByteArrayOutputStream(paramByteArrayPool, paramInt);
  }
  
  public final int read()
    throws IOException
  {
    int i = super.read();
    if (i != -1) {
      outputStream.write(i);
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 != -1) {
      outputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public final void returnBuf(byte[] paramArrayOfByte)
  {
    outputStream.pool.returnBuf(paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.streams.CachingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */