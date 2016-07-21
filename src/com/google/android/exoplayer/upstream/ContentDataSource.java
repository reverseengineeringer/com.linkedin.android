package com.google.android.exoplayer.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentDataSource
  implements UriDataSource
{
  private long bytesRemaining;
  private InputStream inputStream;
  private final TransferListener listener;
  private boolean opened;
  private final ContentResolver resolver;
  private String uriString;
  
  public ContentDataSource(Context paramContext, TransferListener paramTransferListener)
  {
    resolver = paramContext.getContentResolver();
    listener = paramTransferListener;
  }
  
  public final void close()
    throws ContentDataSource.ContentDataSourceException
  {
    uriString = null;
    if (inputStream != null) {}
    try
    {
      inputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new ContentDataSourceException(localIOException);
    }
    finally
    {
      inputStream = null;
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
    throws ContentDataSource.ContentDataSourceException
  {
    try
    {
      uriString = uri.toString();
      inputStream = new FileInputStream(resolver.openAssetFileDescriptor(uri, "r").getFileDescriptor());
      if (inputStream.skip(position) < position) {
        throw new EOFException();
      }
    }
    catch (IOException paramDataSpec)
    {
      throw new ContentDataSourceException(paramDataSpec);
    }
    if (length != -1L) {
      bytesRemaining = length;
    }
    for (;;)
    {
      opened = true;
      if (listener != null) {
        listener.onTransferStart();
      }
      return bytesRemaining;
      bytesRemaining = inputStream.available();
      if (bytesRemaining == 0L) {
        bytesRemaining = -1L;
      }
    }
  }
  
  /* Error */
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ContentDataSource.ContentDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	com/google/android/exoplayer/upstream/ContentDataSource:bytesRemaining	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +7 -> 13
    //   9: iconst_m1
    //   10: istore_2
    //   11: iload_2
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 110	com/google/android/exoplayer/upstream/ContentDataSource:bytesRemaining	J
    //   17: ldc2_w 107
    //   20: lcmp
    //   21: ifne +63 -> 84
    //   24: aload_0
    //   25: getfield 44	com/google/android/exoplayer/upstream/ContentDataSource:inputStream	Ljava/io/InputStream;
    //   28: aload_1
    //   29: iload_2
    //   30: iload_3
    //   31: invokevirtual 121	java/io/InputStream:read	([BII)I
    //   34: istore_3
    //   35: iload_3
    //   36: istore_2
    //   37: iload_3
    //   38: ifle -27 -> 11
    //   41: aload_0
    //   42: getfield 110	com/google/android/exoplayer/upstream/ContentDataSource:bytesRemaining	J
    //   45: ldc2_w 107
    //   48: lcmp
    //   49: ifeq +14 -> 63
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 110	com/google/android/exoplayer/upstream/ContentDataSource:bytesRemaining	J
    //   57: iload_3
    //   58: i2l
    //   59: lsub
    //   60: putfield 110	com/google/android/exoplayer/upstream/ContentDataSource:bytesRemaining	J
    //   63: iload_3
    //   64: istore_2
    //   65: aload_0
    //   66: getfield 36	com/google/android/exoplayer/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer/upstream/TransferListener;
    //   69: ifnull -58 -> 11
    //   72: aload_0
    //   73: getfield 36	com/google/android/exoplayer/upstream/ContentDataSource:listener	Lcom/google/android/exoplayer/upstream/TransferListener;
    //   76: iload_3
    //   77: invokeinterface 125 2 0
    //   82: iload_3
    //   83: ireturn
    //   84: aload_0
    //   85: getfield 110	com/google/android/exoplayer/upstream/ContentDataSource:bytesRemaining	J
    //   88: iload_3
    //   89: i2l
    //   90: invokestatic 131	java/lang/Math:min	(JJ)J
    //   93: lstore 4
    //   95: lload 4
    //   97: l2i
    //   98: istore_3
    //   99: goto -75 -> 24
    //   102: astore_1
    //   103: new 8	com/google/android/exoplayer/upstream/ContentDataSource$ContentDataSourceException
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 58	com/google/android/exoplayer/upstream/ContentDataSource$ContentDataSourceException:<init>	(Ljava/io/IOException;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ContentDataSource
    //   0	112	1	paramArrayOfByte	byte[]
    //   0	112	2	paramInt1	int
    //   0	112	3	paramInt2	int
    //   93	3	4	l	long
    // Exception table:
    //   from	to	target	type
    //   13	24	102	java/io/IOException
    //   24	35	102	java/io/IOException
    //   84	95	102	java/io/IOException
  }
  
  public static final class ContentDataSourceException
    extends IOException
  {
    public ContentDataSourceException(IOException paramIOException)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.ContentDataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */