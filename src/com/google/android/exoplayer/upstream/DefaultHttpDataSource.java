package com.google.android.exoplayer.upstream;

import android.net.Uri;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Predicate;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class DefaultHttpDataSource
  implements HttpDataSource
{
  private static final Pattern CONTENT_RANGE_HEADER = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> skipBufferReference = new AtomicReference();
  private final boolean allowCrossProtocolRedirects;
  private long bytesRead;
  private long bytesSkipped;
  private long bytesToRead;
  private long bytesToSkip;
  private final int connectTimeoutMillis;
  private HttpURLConnection connection;
  private final Predicate<String> contentTypePredicate;
  private DataSpec dataSpec;
  private InputStream inputStream;
  private final TransferListener listener;
  private boolean opened;
  private final int readTimeoutMillis;
  private final HashMap<String, String> requestProperties;
  private final String userAgent;
  
  public DefaultHttpDataSource(String paramString, TransferListener paramTransferListener)
  {
    userAgent = Assertions.checkNotEmpty(paramString);
    contentTypePredicate = null;
    listener = paramTransferListener;
    requestProperties = new HashMap();
    connectTimeoutMillis = 8000;
    readTimeoutMillis = 8000;
    allowCrossProtocolRedirects = false;
  }
  
  private void closeConnection()
  {
    if (connection != null)
    {
      connection.disconnect();
      connection = null;
    }
  }
  
  /* Error */
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc2_w 97
    //   3: lstore_3
    //   4: aload_0
    //   5: ldc 100
    //   7: invokevirtual 103	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: lload_3
    //   13: lstore_1
    //   14: aload 7
    //   16: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +9 -> 28
    //   22: aload 7
    //   24: invokestatic 115	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   27: lstore_1
    //   28: aload_0
    //   29: ldc 117
    //   31: invokevirtual 103	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_0
    //   35: lload_1
    //   36: lstore_3
    //   37: aload_0
    //   38: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +60 -> 101
    //   44: getstatic 50	com/google/android/exoplayer/upstream/DefaultHttpDataSource:CONTENT_RANGE_HEADER	Ljava/util/regex/Pattern;
    //   47: aload_0
    //   48: invokevirtual 121	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 8
    //   53: lload_1
    //   54: lstore_3
    //   55: aload 8
    //   57: invokevirtual 127	java/util/regex/Matcher:find	()Z
    //   60: ifeq +41 -> 101
    //   63: aload 8
    //   65: iconst_2
    //   66: invokevirtual 131	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   69: invokestatic 115	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: lstore_3
    //   73: aload 8
    //   75: iconst_1
    //   76: invokevirtual 131	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   79: invokestatic 115	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore 5
    //   84: lload_3
    //   85: lload 5
    //   87: lsub
    //   88: lconst_1
    //   89: ladd
    //   90: lstore 5
    //   92: lload_1
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge +43 -> 138
    //   98: lload 5
    //   100: lstore_3
    //   101: lload_3
    //   102: lreturn
    //   103: astore 8
    //   105: ldc -123
    //   107: new 135	java/lang/StringBuilder
    //   110: dup
    //   111: ldc -119
    //   113: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload 7
    //   118: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc -110
    //   123: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: lload_3
    //   134: lstore_1
    //   135: goto -107 -> 28
    //   138: lload_1
    //   139: lstore_3
    //   140: lload_1
    //   141: lload 5
    //   143: lcmp
    //   144: ifeq -43 -> 101
    //   147: ldc -123
    //   149: new 135	java/lang/StringBuilder
    //   152: dup
    //   153: ldc -98
    //   155: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 7
    //   160: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc -96
    //   165: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc -110
    //   174: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 163	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: lload_1
    //   185: lload 5
    //   187: invokestatic 169	java/lang/Math:max	(JJ)J
    //   190: lstore_3
    //   191: lload_3
    //   192: lreturn
    //   193: astore 7
    //   195: ldc -123
    //   197: new 135	java/lang/StringBuilder
    //   200: dup
    //   201: ldc -85
    //   203: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc -110
    //   212: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: lload_1
    //   223: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramHttpURLConnection	HttpURLConnection
    //   13	210	1	l1	long
    //   3	189	3	l2	long
    //   82	104	5	l3	long
    //   10	149	7	str	String
    //   193	1	7	localNumberFormatException1	NumberFormatException
    //   51	23	8	localMatcher	java.util.regex.Matcher
    //   103	1	8	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   22	28	103	java/lang/NumberFormatException
    //   63	84	193	java/lang/NumberFormatException
    //   147	191	193	java/lang/NumberFormatException
  }
  
  private HttpURLConnection makeConnection(URL arg1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)???.openConnection();
    localHttpURLConnection.setConnectTimeout(connectTimeoutMillis);
    localHttpURLConnection.setReadTimeout(readTimeoutMillis);
    Object localObject;
    synchronized (requestProperties)
    {
      localObject = requestProperties.entrySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject = "bytes=" + paramLong1 + "-";
      ??? = (URL)localObject;
      if (paramLong2 != -1L) {
        ??? = (String)localObject + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", ???);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localHttpURLConnection.setDoOutput(paramBoolean1);
      if (paramArrayOfByte == null) {
        break;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      ??? = localHttpURLConnection.getOutputStream();
      ???.write(paramArrayOfByte);
      ???.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }
  
  /* Error */
  public final void close()
    throws HttpDataSource.HttpDataSourceException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 268	com/google/android/exoplayer/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   4: ifnull +36 -> 40
    //   7: aload_0
    //   8: getfield 87	com/google/android/exoplayer/upstream/DefaultHttpDataSource:connection	Ljava/net/HttpURLConnection;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 270	com/google/android/exoplayer/upstream/DefaultHttpDataSource:bytesToRead	J
    //   16: ldc2_w 97
    //   19: lcmp
    //   20: ifne +58 -> 78
    //   23: aload_0
    //   24: getfield 270	com/google/android/exoplayer/upstream/DefaultHttpDataSource:bytesToRead	J
    //   27: lstore_1
    //   28: aload_3
    //   29: lload_1
    //   30: invokestatic 276	com/google/android/exoplayer/util/Util:maybeTerminateInputStream	(Ljava/net/HttpURLConnection;J)V
    //   33: aload_0
    //   34: getfield 268	com/google/android/exoplayer/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   37: invokevirtual 279	java/io/InputStream:close	()V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 268	com/google/android/exoplayer/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   45: aload_0
    //   46: invokespecial 281	com/google/android/exoplayer/upstream/DefaultHttpDataSource:closeConnection	()V
    //   49: aload_0
    //   50: getfield 283	com/google/android/exoplayer/upstream/DefaultHttpDataSource:opened	Z
    //   53: ifeq +24 -> 77
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 283	com/google/android/exoplayer/upstream/DefaultHttpDataSource:opened	Z
    //   61: aload_0
    //   62: getfield 72	com/google/android/exoplayer/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer/upstream/TransferListener;
    //   65: ifnull +12 -> 77
    //   68: aload_0
    //   69: getfield 72	com/google/android/exoplayer/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer/upstream/TransferListener;
    //   72: invokeinterface 288 1 0
    //   77: return
    //   78: aload_0
    //   79: getfield 270	com/google/android/exoplayer/upstream/DefaultHttpDataSource:bytesToRead	J
    //   82: aload_0
    //   83: getfield 290	com/google/android/exoplayer/upstream/DefaultHttpDataSource:bytesRead	J
    //   86: lsub
    //   87: lstore_1
    //   88: goto -60 -> 28
    //   91: astore_3
    //   92: new 266	com/google/android/exoplayer/upstream/HttpDataSource$HttpDataSourceException
    //   95: dup
    //   96: aload_3
    //   97: aload_0
    //   98: getfield 292	com/google/android/exoplayer/upstream/DefaultHttpDataSource:dataSpec	Lcom/google/android/exoplayer/upstream/DataSpec;
    //   101: invokespecial 295	com/google/android/exoplayer/upstream/HttpDataSource$HttpDataSourceException:<init>	(Ljava/io/IOException;Lcom/google/android/exoplayer/upstream/DataSpec;)V
    //   104: athrow
    //   105: astore_3
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 268	com/google/android/exoplayer/upstream/DefaultHttpDataSource:inputStream	Ljava/io/InputStream;
    //   111: aload_0
    //   112: invokespecial 281	com/google/android/exoplayer/upstream/DefaultHttpDataSource:closeConnection	()V
    //   115: aload_0
    //   116: getfield 283	com/google/android/exoplayer/upstream/DefaultHttpDataSource:opened	Z
    //   119: ifeq +24 -> 143
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 283	com/google/android/exoplayer/upstream/DefaultHttpDataSource:opened	Z
    //   127: aload_0
    //   128: getfield 72	com/google/android/exoplayer/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer/upstream/TransferListener;
    //   131: ifnull +12 -> 143
    //   134: aload_0
    //   135: getfield 72	com/google/android/exoplayer/upstream/DefaultHttpDataSource:listener	Lcom/google/android/exoplayer/upstream/TransferListener;
    //   138: invokeinterface 288 1 0
    //   143: aload_3
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	DefaultHttpDataSource
    //   27	61	1	l	long
    //   11	18	3	localHttpURLConnection	HttpURLConnection
    //   91	6	3	localIOException	IOException
    //   105	39	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	91	java/io/IOException
    //   0	28	105	finally
    //   28	33	105	finally
    //   33	40	105	finally
    //   78	88	105	finally
    //   92	105	105	finally
  }
  
  public final String getUri()
  {
    if (connection == null) {
      return null;
    }
    return connection.getURL().toString();
  }
  
  public final long open(DataSpec paramDataSpec)
    throws HttpDataSource.HttpDataSourceException
  {
    dataSpec = paramDataSpec;
    bytesRead = 0L;
    bytesSkipped = 0L;
    long l1;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = new URL(uri.toString());
        arrayOfByte = postBody;
        l1 = position;
        l2 = length;
        if ((flags & 0x1) != 0)
        {
          bool = true;
          if (allowCrossProtocolRedirects) {
            continue;
          }
          localObject2 = makeConnection((URL)localObject1, arrayOfByte, l1, l2, bool, true);
          connection = ((HttpURLConnection)localObject2);
        }
      }
      catch (IOException localIOException1)
      {
        Object localObject1;
        byte[] arrayOfByte;
        long l2;
        boolean bool;
        throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + uri.toString(), localIOException1, paramDataSpec);
      }
      try
      {
        i = connection.getResponseCode();
        if ((i >= 200) && (i <= 299)) {
          break label437;
        }
        localObject1 = connection.getHeaderFields();
        closeConnection();
        throw new HttpDataSource.InvalidResponseCodeException(i, (Map)localObject1, paramDataSpec);
      }
      catch (IOException localIOException2)
      {
        closeConnection();
        throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + uri.toString(), localIOException2, paramDataSpec);
      }
      bool = false;
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (i <= 20)
      {
        HttpURLConnection localHttpURLConnection = makeConnection((URL)localObject1, arrayOfByte, l1, l2, bool, false);
        i = localHttpURLConnection.getResponseCode();
        if ((i != 300) && (i != 301) && (i != 302) && (i != 303))
        {
          localObject2 = localHttpURLConnection;
          if (arrayOfByte != null) {
            break;
          }
          if (i != 307)
          {
            localObject2 = localHttpURLConnection;
            if (i != 308) {
              break;
            }
          }
        }
        arrayOfByte = null;
        localObject2 = localHttpURLConnection.getHeaderField("Location");
        localHttpURLConnection.disconnect();
        if (localObject2 == null) {
          throw new ProtocolException("Null location redirect");
        }
        URL localURL = new URL(localIOException1, (String)localObject2);
        localObject2 = localURL.getProtocol();
        if (("https".equals(localObject2)) || ("http".equals(localObject2))) {
          continue;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + (String)localObject2);
      }
      throw new NoRouteToHostException("Too many redirects: " + j);
      label437:
      String str = connection.getContentType();
      if ((contentTypePredicate != null) && (!contentTypePredicate.evaluate(str)))
      {
        closeConnection();
        throw new HttpDataSource.InvalidContentTypeException(str, paramDataSpec);
      }
      if ((i == 200) && (position != 0L))
      {
        l1 = position;
        bytesToSkip = l1;
        if ((flags & 0x1) != 0) {
          break label623;
        }
        l1 = getContentLength(connection);
        if (length == -1L) {
          break label594;
        }
        l1 = length;
      }
      label545:
      for (bytesToRead = l1;; bytesToRead = length)
      {
        try
        {
          inputStream = connection.getInputStream();
          opened = true;
          if (listener != null) {
            listener.onTransferStart();
          }
          return bytesToRead;
        }
        catch (IOException localIOException3)
        {
          label594:
          label623:
          closeConnection();
          throw new HttpDataSource.HttpDataSourceException(localIOException3, paramDataSpec);
        }
        l1 = 0L;
        break;
        if (l1 != -1L)
        {
          l1 -= bytesToSkip;
          break label545;
        }
        l1 = -1L;
        break label545;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws HttpDataSource.HttpDataSourceException
  {
    byte[] arrayOfByte1;
    for (;;)
    {
      int i;
      try
      {
        if (bytesSkipped == bytesToSkip) {
          break label168;
        }
        byte[] arrayOfByte2 = (byte[])skipBufferReference.getAndSet(null);
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          arrayOfByte1 = new byte['က'];
        }
        if (bytesSkipped == bytesToSkip) {
          break;
        }
        i = (int)Math.min(bytesToSkip - bytesSkipped, arrayOfByte1.length);
        i = inputStream.read(arrayOfByte1, 0, i);
        if (Thread.interrupted()) {
          throw new InterruptedIOException();
        }
      }
      catch (IOException paramArrayOfByte)
      {
        throw new HttpDataSource.HttpDataSourceException(paramArrayOfByte, dataSpec);
      }
      if (i == -1) {
        throw new EOFException();
      }
      bytesSkipped += i;
      if (listener != null) {
        listener.onBytesTransferred(i);
      }
    }
    skipBufferReference.set(arrayOfByte1);
    label168:
    if (bytesToRead != -1L) {
      paramInt2 = (int)Math.min(paramInt2, bytesToRead - bytesRead);
    }
    while (paramInt2 != 0)
    {
      paramInt2 = inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 == -1)
      {
        if ((bytesToRead == -1L) || (bytesToRead == bytesRead)) {
          break label288;
        }
        throw new EOFException();
      }
      bytesRead += paramInt2;
      paramInt1 = paramInt2;
      if (listener == null) {
        break;
      }
      listener.onBytesTransferred(paramInt2);
      return paramInt2;
    }
    paramInt1 = -1;
    return paramInt1;
    label288:
    return -1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DefaultHttpDataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */