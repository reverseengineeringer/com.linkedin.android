package com.linkedin.android.networking.streams;

import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

public final class MarkableInputStream
  extends InputStream
{
  public boolean allowExpire = true;
  private long defaultMark = -1L;
  private final InputStream in;
  private long limit;
  private int limitIncrement = -1;
  private long offset;
  private long reset;
  
  public MarkableInputStream(InputStream paramInputStream, ByteArrayPool paramByteArrayPool)
  {
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new PoolingBufferedInputStream(paramInputStream, paramByteArrayPool);
    }
    in = ((InputStream)localObject);
    limitIncrement = 1024;
  }
  
  /* Error */
  private void setLimit(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/linkedin/android/networking/streams/MarkableInputStream:reset	J
    //   4: aload_0
    //   5: getfield 47	com/linkedin/android/networking/streams/MarkableInputStream:offset	J
    //   8: lcmp
    //   9: ifge +54 -> 63
    //   12: aload_0
    //   13: getfield 47	com/linkedin/android/networking/streams/MarkableInputStream:offset	J
    //   16: aload_0
    //   17: getfield 49	com/linkedin/android/networking/streams/MarkableInputStream:limit	J
    //   20: lcmp
    //   21: ifgt +42 -> 63
    //   24: aload_0
    //   25: getfield 38	com/linkedin/android/networking/streams/MarkableInputStream:in	Ljava/io/InputStream;
    //   28: invokevirtual 51	java/io/InputStream:reset	()V
    //   31: aload_0
    //   32: getfield 38	com/linkedin/android/networking/streams/MarkableInputStream:in	Ljava/io/InputStream;
    //   35: lload_1
    //   36: aload_0
    //   37: getfield 45	com/linkedin/android/networking/streams/MarkableInputStream:reset	J
    //   40: lsub
    //   41: l2i
    //   42: invokevirtual 55	java/io/InputStream:mark	(I)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 45	com/linkedin/android/networking/streams/MarkableInputStream:reset	J
    //   50: aload_0
    //   51: getfield 47	com/linkedin/android/networking/streams/MarkableInputStream:offset	J
    //   54: invokespecial 59	com/linkedin/android/networking/streams/MarkableInputStream:skip	(JJ)V
    //   57: aload_0
    //   58: lload_1
    //   59: putfield 49	com/linkedin/android/networking/streams/MarkableInputStream:limit	J
    //   62: return
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 47	com/linkedin/android/networking/streams/MarkableInputStream:offset	J
    //   68: putfield 45	com/linkedin/android/networking/streams/MarkableInputStream:reset	J
    //   71: aload_0
    //   72: getfield 38	com/linkedin/android/networking/streams/MarkableInputStream:in	Ljava/io/InputStream;
    //   75: lload_1
    //   76: aload_0
    //   77: getfield 47	com/linkedin/android/networking/streams/MarkableInputStream:offset	J
    //   80: lsub
    //   81: l2i
    //   82: invokevirtual 55	java/io/InputStream:mark	(I)V
    //   85: goto -28 -> 57
    //   88: astore_3
    //   89: new 61	java/lang/IllegalStateException
    //   92: dup
    //   93: new 63	java/lang/StringBuilder
    //   96: dup
    //   97: ldc 65
    //   99: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: aload_3
    //   103: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 77	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	MarkableInputStream
    //   0	113	1	paramLong	long
    //   88	15	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	57	88	java/io/IOException
    //   57	62	88	java/io/IOException
    //   63	85	88	java/io/IOException
  }
  
  private void skip(long paramLong1, long paramLong2)
    throws IOException
  {
    while (paramLong1 < paramLong2)
    {
      long l2 = in.skip(paramLong2 - paramLong1);
      long l1 = l2;
      if (l2 == 0L)
      {
        if (read() == -1) {
          break;
        }
        l1 = 1L;
      }
      paramLong1 += l1;
    }
  }
  
  public final int available()
    throws IOException
  {
    return in.available();
  }
  
  public final void close()
    throws IOException
  {
    in.close();
  }
  
  public final void mark(int paramInt)
  {
    defaultMark = savePosition(paramInt);
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
    throws IOException
  {
    if ((!allowExpire) && (offset + 1L > limit)) {
      setLimit(limit + limitIncrement);
    }
    int i = in.read();
    if (i != -1) {
      offset += 1L;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
    throws IOException
  {
    if ((!allowExpire) && (offset + paramArrayOfByte.length > limit)) {
      setLimit(offset + paramArrayOfByte.length + limitIncrement);
    }
    int i = in.read(paramArrayOfByte);
    if (i != -1) {
      offset += i;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((!allowExpire) && (offset + paramInt2 > limit)) {
      setLimit(offset + paramInt2 + limitIncrement);
    }
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      offset += paramInt1;
    }
    return paramInt1;
  }
  
  public final void reset()
    throws IOException
  {
    reset(defaultMark);
  }
  
  public final void reset(long paramLong)
    throws IOException
  {
    if ((offset > limit) || (paramLong < reset)) {
      throw new IOException("Cannot reset");
    }
    in.reset();
    skip(reset, paramLong);
    offset = paramLong;
  }
  
  public final long savePosition(int paramInt)
  {
    long l = offset + paramInt;
    if (limit < l) {
      setLimit(l);
    }
    return offset;
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    if ((!allowExpire) && (offset + paramLong > limit)) {
      setLimit(offset + paramLong + limitIncrement);
    }
    paramLong = in.skip(paramLong);
    offset += paramLong;
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.streams.MarkableInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */