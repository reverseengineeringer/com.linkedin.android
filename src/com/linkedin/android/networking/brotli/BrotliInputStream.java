package com.linkedin.android.networking.brotli;

import com.linkedin.android.networking.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

public final class BrotliInputStream
  extends InputStream
{
  private final BrotliStreamDecompressor brotliStreamDecompressor;
  private final ByteArrayPool byteArrayPool;
  private final InputStream inputStream;
  private boolean isEndOfInputStream = false;
  private InputStream uncompressedInputStream;
  
  public BrotliInputStream(InputStream paramInputStream, ByteArrayPool paramByteArrayPool)
    throws IOException
  {
    inputStream = paramInputStream;
    brotliStreamDecompressor = new BrotliStreamDecompressor();
    byteArrayPool = paramByteArrayPool;
  }
  
  public final int available()
    throws IOException
  {
    int i = 0;
    if ((isEndOfInputStream) && ((uncompressedInputStream == null) || (uncompressedInputStream.available() == 0))) {
      return 0;
    }
    if (uncompressedInputStream == null) {}
    for (;;)
    {
      return i + 1;
      i = uncompressedInputStream.available();
    }
  }
  
  public final void close()
    throws IOException
  {
    inputStream.close();
    brotliStreamDecompressor.close();
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      throw new UnsupportedOperationException("mark unsupported");
    }
    finally {}
  }
  
  public final boolean markSupported()
  {
    return false;
  }
  
  /* Error */
  public final int read()
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 37	com/linkedin/android/networking/brotli/BrotliInputStream:uncompressedInputStream	Ljava/io/InputStream;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 37	com/linkedin/android/networking/brotli/BrotliInputStream:uncompressedInputStream	Ljava/io/InputStream;
    //   13: invokevirtual 39	java/io/InputStream:available	()I
    //   16: ifne +71 -> 87
    //   19: aload_0
    //   20: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   23: ldc 56
    //   25: invokevirtual 62	com/linkedin/android/networking/util/ByteArrayPool:getBuf	(I)[B
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 29	com/linkedin/android/networking/brotli/BrotliInputStream:brotliStreamDecompressor	Lcom/linkedin/android/networking/brotli/BrotliStreamDecompressor;
    //   34: getfield 65	com/linkedin/android/networking/brotli/BrotliStreamDecompressor:needsMoreOutput	Z
    //   37: ifeq +58 -> 95
    //   40: aload_0
    //   41: new 67	java/io/ByteArrayInputStream
    //   44: dup
    //   45: aload 5
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 29	com/linkedin/android/networking/brotli/BrotliInputStream:brotliStreamDecompressor	Lcom/linkedin/android/networking/brotli/BrotliStreamDecompressor;
    //   52: iconst_0
    //   53: newarray <illegal type>
    //   55: iconst_0
    //   56: aload 5
    //   58: iconst_0
    //   59: ldc 56
    //   61: invokevirtual 71	com/linkedin/android/networking/brotli/BrotliStreamDecompressor:decompress$589a364a	([BI[BII)I
    //   64: invokespecial 74	java/io/ByteArrayInputStream:<init>	([BII)V
    //   67: putfield 37	com/linkedin/android/networking/brotli/BrotliInputStream:uncompressedInputStream	Ljava/io/InputStream;
    //   70: aload_0
    //   71: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   74: aload 5
    //   76: invokevirtual 78	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   79: aload_0
    //   80: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   83: aconst_null
    //   84: invokevirtual 78	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   87: aload_0
    //   88: getfield 37	com/linkedin/android/networking/brotli/BrotliInputStream:uncompressedInputStream	Ljava/io/InputStream;
    //   91: invokevirtual 80	java/io/InputStream:read	()I
    //   94: ireturn
    //   95: aload_0
    //   96: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   99: sipush 4096
    //   102: invokevirtual 62	com/linkedin/android/networking/util/ByteArrayPool:getBuf	(I)[B
    //   105: astore 4
    //   107: aload_0
    //   108: getfield 22	com/linkedin/android/networking/brotli/BrotliInputStream:isEndOfInputStream	Z
    //   111: ifne +87 -> 198
    //   114: iload_1
    //   115: ifeq +13 -> 128
    //   118: aload_0
    //   119: getfield 29	com/linkedin/android/networking/brotli/BrotliInputStream:brotliStreamDecompressor	Lcom/linkedin/android/networking/brotli/BrotliStreamDecompressor;
    //   122: getfield 83	com/linkedin/android/networking/brotli/BrotliStreamDecompressor:needsMoreInput	Z
    //   125: ifeq +73 -> 198
    //   128: aload_0
    //   129: getfield 24	com/linkedin/android/networking/brotli/BrotliInputStream:inputStream	Ljava/io/InputStream;
    //   132: aload 4
    //   134: iconst_0
    //   135: sipush 4096
    //   138: invokevirtual 86	java/io/InputStream:read	([BII)I
    //   141: istore_2
    //   142: iload_2
    //   143: ifle +26 -> 169
    //   146: iload_1
    //   147: aload_0
    //   148: getfield 29	com/linkedin/android/networking/brotli/BrotliInputStream:brotliStreamDecompressor	Lcom/linkedin/android/networking/brotli/BrotliStreamDecompressor;
    //   151: aload 4
    //   153: iload_2
    //   154: aload 5
    //   156: iload_1
    //   157: ldc 56
    //   159: iload_1
    //   160: isub
    //   161: invokevirtual 71	com/linkedin/android/networking/brotli/BrotliStreamDecompressor:decompress$589a364a	([BI[BII)I
    //   164: iadd
    //   165: istore_1
    //   166: goto -59 -> 107
    //   169: aload_0
    //   170: iconst_1
    //   171: putfield 22	com/linkedin/android/networking/brotli/BrotliInputStream:isEndOfInputStream	Z
    //   174: goto -67 -> 107
    //   177: astore_3
    //   178: aload_0
    //   179: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   182: aload 5
    //   184: invokevirtual 78	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   187: aload_0
    //   188: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   191: aload 4
    //   193: invokevirtual 78	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   196: aload_3
    //   197: athrow
    //   198: aload_0
    //   199: new 67	java/io/ByteArrayInputStream
    //   202: dup
    //   203: aload 5
    //   205: iconst_0
    //   206: iload_1
    //   207: invokespecial 74	java/io/ByteArrayInputStream:<init>	([BII)V
    //   210: putfield 37	com/linkedin/android/networking/brotli/BrotliInputStream:uncompressedInputStream	Ljava/io/InputStream;
    //   213: aload_0
    //   214: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   217: aload 5
    //   219: invokevirtual 78	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   222: aload_0
    //   223: getfield 31	com/linkedin/android/networking/brotli/BrotliInputStream:byteArrayPool	Lcom/linkedin/android/networking/util/ByteArrayPool;
    //   226: aload 4
    //   228: invokevirtual 78	com/linkedin/android/networking/util/ByteArrayPool:returnBuf	([B)V
    //   231: goto -144 -> 87
    //   234: astore_3
    //   235: aconst_null
    //   236: astore 4
    //   238: aconst_null
    //   239: astore 5
    //   241: goto -63 -> 178
    //   244: astore_3
    //   245: aconst_null
    //   246: astore 4
    //   248: goto -70 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	BrotliInputStream
    //   1	206	1	i	int
    //   141	13	2	j	int
    //   177	20	3	localObject1	Object
    //   234	1	3	localObject2	Object
    //   244	1	3	localObject3	Object
    //   105	142	4	arrayOfByte1	byte[]
    //   28	212	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	114	177	finally
    //   118	128	177	finally
    //   128	142	177	finally
    //   146	166	177	finally
    //   169	174	177	finally
    //   198	213	177	finally
    //   19	30	234	finally
    //   30	70	244	finally
    //   95	107	244	finally
  }
  
  public final void reset()
    throws IOException
  {
    try
    {
      throw new UnsupportedOperationException("reset unsupported");
    }
    finally {}
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    throw new UnsupportedOperationException("skip unsupported");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.brotli.BrotliInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */