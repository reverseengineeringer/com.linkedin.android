package com.google.android.exoplayer.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource
  implements UriDataSource
{
  private long bytesRemaining;
  private RandomAccessFile file;
  private final TransferListener listener;
  private boolean opened;
  private String uriString;
  
  public FileDataSource()
  {
    this(null);
  }
  
  public FileDataSource(TransferListener paramTransferListener)
  {
    listener = paramTransferListener;
  }
  
  public final void close()
    throws FileDataSource.FileDataSourceException
  {
    uriString = null;
    if (file != null) {}
    try
    {
      file.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new FileDataSourceException(localIOException);
    }
    finally
    {
      file = null;
      if (opened)
      {
        opened = false;
        if (listener != null) {
          listener.onTransferEnd();
        }
      }
    }
  }
  
  public final String getUri()
  {
    return uriString;
  }
  
  public final long open(DataSpec paramDataSpec)
    throws FileDataSource.FileDataSourceException
  {
    for (;;)
    {
      try
      {
        uriString = uri.toString();
        file = new RandomAccessFile(uri.getPath(), "r");
        file.seek(position);
        if (length == -1L)
        {
          l = file.length() - position;
          bytesRemaining = l;
          if (bytesRemaining >= 0L) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException paramDataSpec)
      {
        throw new FileDataSourceException(paramDataSpec);
      }
      long l = length;
    }
    opened = true;
    if (listener != null) {
      listener.onTransferStart();
    }
    return bytesRemaining;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws FileDataSource.FileDataSourceException
  {
    if (bytesRemaining == 0L) {
      paramInt1 = -1;
    }
    for (;;)
    {
      return paramInt1;
      try
      {
        paramInt2 = file.read(paramArrayOfByte, paramInt1, (int)Math.min(bytesRemaining, paramInt2));
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          continue;
        }
        bytesRemaining -= paramInt2;
        paramInt1 = paramInt2;
        if (listener == null) {
          continue;
        }
        listener.onBytesTransferred(paramInt2);
        return paramInt2;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new FileDataSourceException(paramArrayOfByte);
      }
    }
  }
  
  public static final class FileDataSourceException
    extends IOException
  {
    public FileDataSourceException(IOException paramIOException)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.FileDataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */