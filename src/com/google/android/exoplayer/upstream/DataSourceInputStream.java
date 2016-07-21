package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public final class DataSourceInputStream
  extends InputStream
{
  private boolean closed = false;
  private final DataSource dataSource;
  private final DataSpec dataSpec;
  private boolean opened = false;
  private final byte[] singleByteArray;
  
  public DataSourceInputStream(DataSource paramDataSource, DataSpec paramDataSpec)
  {
    dataSource = paramDataSource;
    dataSpec = paramDataSpec;
    singleByteArray = new byte[1];
  }
  
  final void checkOpened()
    throws IOException
  {
    if (!opened)
    {
      dataSource.open(dataSpec);
      opened = true;
    }
  }
  
  public final void close()
    throws IOException
  {
    if (!closed)
    {
      dataSource.close();
      closed = true;
    }
  }
  
  public final int read()
    throws IOException
  {
    if (read(singleByteArray) == -1) {
      return -1;
    }
    return singleByteArray[0] & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!closed) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      return dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    if (!closed) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      return super.skip(paramLong);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DataSourceInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */