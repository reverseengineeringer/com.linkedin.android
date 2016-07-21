package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import okhttp3.internal.DiskLruCache;
import okhttp3.internal.DiskLruCache.Editor;
import okhttp3.internal.DiskLruCache.Snapshot;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.http.CacheRequest;
import okhttp3.internal.http.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache
  implements Closeable, Flushable
{
  private final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public final Response get(Request paramAnonymousRequest)
      throws IOException
    {
      return Cache.this.get(paramAnonymousRequest);
    }
    
    public final CacheRequest put(Response paramAnonymousResponse)
      throws IOException
    {
      return Cache.this.put(paramAnonymousResponse);
    }
    
    public final void remove(Request paramAnonymousRequest)
      throws IOException
    {
      Cache.this.remove(paramAnonymousRequest);
    }
    
    public final void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }
    
    public final void trackResponse(CacheStrategy paramAnonymousCacheStrategy)
    {
      Cache.this.trackResponse(paramAnonymousCacheStrategy);
    }
    
    public final void update(Response paramAnonymousResponse1, Response paramAnonymousResponse2)
      throws IOException
    {
      Cache.access$200$2d360e6(paramAnonymousResponse1, paramAnonymousResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  private int writeAbortCount;
  int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  private Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    cache = DiskLruCache.create$bcfeaba(paramFileSystem, paramFile, paramLong);
  }
  
  private static void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  private CacheRequest put(Response paramResponse)
    throws IOException
  {
    Object localObject = request.method;
    if (HttpMethod.invalidatesCache(request.method)) {}
    for (;;)
    {
      try
      {
        remove(request);
        return null;
      }
      catch (IOException paramResponse) {}
      if ((((String)localObject).equals("GET")) && (!OkHeaders.hasVaryAll(paramResponse)))
      {
        Entry localEntry = new Entry(paramResponse);
        localObject = null;
        try
        {
          paramResponse = cache.edit(urlToKey(request), -1L);
          if (paramResponse != null)
          {
            localObject = paramResponse;
            localEntry.writeTo(paramResponse);
            localObject = paramResponse;
            paramResponse = new CacheRequestImpl(paramResponse);
            return paramResponse;
          }
        }
        catch (IOException paramResponse)
        {
          abortQuietly((DiskLruCache.Editor)localObject);
          return null;
        }
      }
    }
    return null;
  }
  
  private static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    long l;
    try
    {
      l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l < 0L) || (l > 2147483647L) || (!paramBufferedSource.isEmpty())) {
        throw new IOException("expected an int but was \"" + l + paramBufferedSource + "\"");
      }
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
    return (int)l;
  }
  
  private void remove(Request paramRequest)
    throws IOException
  {
    cache.remove(urlToKey(paramRequest));
  }
  
  private void trackConditionalCacheHit()
  {
    try
    {
      hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void trackResponse(CacheStrategy paramCacheStrategy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 227	okhttp3/Cache:requestCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 227	okhttp3/Cache:requestCount	I
    //   12: aload_1
    //   13: getfield 232	okhttp3/internal/http/CacheStrategy:networkRequest	Lokhttp3/Request;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 234	okhttp3/Cache:networkCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 234	okhttp3/Cache:networkCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 238	okhttp3/internal/http/CacheStrategy:cacheResponse	Lokhttp3/Response;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 225	okhttp3/Cache:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 225	okhttp3/Cache:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Cache
    //   0	57	1	paramCacheStrategy	CacheStrategy
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  private static String urlToKey(Request paramRequest)
  {
    return Util.md5Hex(url.toString());
  }
  
  public final void close()
    throws IOException
  {
    cache.close();
  }
  
  public final void flush()
    throws IOException
  {
    cache.flush();
  }
  
  final Response get(Request paramRequest)
  {
    int j = 0;
    Object localObject1 = urlToKey(paramRequest);
    for (;;)
    {
      try
      {
        localObject1 = cache.get((String)localObject1);
        if (localObject1 == null)
        {
          paramRequest = null;
          return paramRequest;
        }
      }
      catch (IOException paramRequest)
      {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(sources[0]);
        String str1 = responseHeaders.get("Content-Type");
        String str2 = responseHeaders.get("Content-Length");
        Object localObject2 = new Request.Builder().url(url).method(requestMethod, null);
        headers = varyHeaders.newBuilder();
        localObject2 = ((Request.Builder)localObject2).build();
        Response.Builder localBuilder = new Response.Builder();
        request = ((Request)localObject2);
        protocol = protocol;
        code = code;
        message = message;
        localObject2 = localBuilder.headers(responseHeaders);
        body = new CacheResponseBody((DiskLruCache.Snapshot)localObject1, str1, str2);
        handshake = handshake;
        localObject1 = ((Response.Builder)localObject2).build();
        int i = j;
        if (url.equals(url.toString()))
        {
          i = j;
          if (requestMethod.equals(method))
          {
            i = j;
            if (OkHeaders.varyMatches((Response)localObject1, varyHeaders, paramRequest)) {
              i = 1;
            }
          }
        }
        paramRequest = (Request)localObject1;
        if (i == 0)
        {
          Util.closeQuietly(body);
          return null;
        }
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Closeable)localObject1);
      }
    }
    return null;
  }
  
  private final class CacheRequestImpl
    implements CacheRequest
  {
    private Sink body;
    private Sink cacheOut;
    boolean done;
    private final DiskLruCache.Editor editor;
    
    public CacheRequestImpl(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      editor = paramEditor;
      cacheOut = paramEditor.newSink(1);
      body = new Cache.CacheRequestImpl.1(this, cacheOut, Cache.this, paramEditor);
    }
    
    public final void abort()
    {
      synchronized (Cache.this)
      {
        if (done) {
          return;
        }
        done = true;
        Cache.access$908(Cache.this);
        Util.closeQuietly(cacheOut);
        try
        {
          editor.abort();
          return;
        }
        catch (IOException localIOException) {}
      }
    }
    
    public final Sink body()
    {
      return body;
    }
  }
  
  private static final class CacheResponseBody
    extends ResponseBody
  {
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    final DiskLruCache.Snapshot snapshot;
    
    public CacheResponseBody(DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      snapshot = paramSnapshot;
      contentType = paramString1;
      contentLength = paramString2;
      bodySource = Okio.buffer(new Cache.CacheResponseBody.1(this, sources[1], paramSnapshot));
    }
    
    public final long contentLength()
    {
      long l = -1L;
      try
      {
        if (contentLength != null) {
          l = Long.parseLong(contentLength);
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
      return -1L;
    }
    
    public final MediaType contentType()
    {
      if (contentType != null) {
        return MediaType.parse(contentType);
      }
      return null;
    }
    
    public final BufferedSource source()
    {
      return bodySource;
    }
  }
  
  private static final class Entry
  {
    final int code;
    final Handshake handshake;
    final String message;
    final Protocol protocol;
    final String requestMethod;
    final Headers responseHeaders;
    final String url;
    final Headers varyHeaders;
    
    public Entry(Response paramResponse)
    {
      url = request.url.toString();
      varyHeaders = OkHeaders.varyHeaders(paramResponse);
      requestMethod = request.method;
      protocol = protocol;
      code = code;
      message = message;
      responseHeaders = headers;
      handshake = handshake;
    }
    
    public Entry(Source paramSource)
      throws IOException
    {
      try
      {
        BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
        url = localBufferedSource1.readUtf8LineStrict();
        requestMethod = localBufferedSource1.readUtf8LineStrict();
        localObject = new Headers.Builder();
        int j = Cache.readInt(localBufferedSource1);
        int i = 0;
        while (i < j)
        {
          ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
        }
        varyHeaders = ((Headers.Builder)localObject).build();
        localObject = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
        protocol = protocol;
        code = code;
        message = message;
        localObject = new Headers.Builder();
        j = Cache.readInt(localBufferedSource1);
        i = 0;
        while (i < j)
        {
          ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
        }
        responseHeaders = ((Headers.Builder)localObject).build();
        if (!isHttps()) {
          break label333;
        }
        localObject = localBufferedSource1.readUtf8LineStrict();
        if (((String)localObject).length() > 0) {
          throw new IOException("expected \"\" but was \"" + (String)localObject + "\"");
        }
      }
      finally
      {
        paramSource.close();
      }
      Object localObject = CipherSuite.forJavaName(localBufferedSource2.readUtf8LineStrict());
      List localList1 = readCertificateList(localBufferedSource2);
      List localList2 = readCertificateList(localBufferedSource2);
      if (!localBufferedSource2.exhausted()) {}
      for (TlsVersion localTlsVersion = TlsVersion.forJavaName(localBufferedSource2.readUtf8LineStrict());; localTlsVersion = null)
      {
        if (localObject == null) {
          throw new IllegalArgumentException("cipherSuite == null");
        }
        label333:
        for (handshake = new Handshake(localTlsVersion, (CipherSuite)localObject, Util.immutableList(localList1), Util.immutableList(localList2));; handshake = null)
        {
          paramSource.close();
          return;
        }
      }
    }
    
    private boolean isHttps()
    {
      return url.startsWith("https://");
    }
    
    /* Error */
    private static List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 95	okhttp3/Cache:access$1000	(Lokio/BufferedSource;)I
      //   4: istore_2
      //   5: iload_2
      //   6: iconst_m1
      //   7: if_icmpne +9 -> 16
      //   10: invokestatic 191	java/util/Collections:emptyList	()Ljava/util/List;
      //   13: astore_3
      //   14: aload_3
      //   15: areturn
      //   16: ldc -63
      //   18: invokestatic 199	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
      //   21: astore 5
      //   23: new 201	java/util/ArrayList
      //   26: dup
      //   27: iload_2
      //   28: invokespecial 204	java/util/ArrayList:<init>	(I)V
      //   31: astore 4
      //   33: iconst_0
      //   34: istore_1
      //   35: aload 4
      //   37: astore_3
      //   38: iload_1
      //   39: iload_2
      //   40: if_icmpge -26 -> 14
      //   43: aload_0
      //   44: invokeinterface 88 1 0
      //   49: astore_3
      //   50: new 206	okio/Buffer
      //   53: dup
      //   54: invokespecial 207	okio/Buffer:<init>	()V
      //   57: astore 6
      //   59: aload 6
      //   61: aload_3
      //   62: invokestatic 213	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
      //   65: invokevirtual 217	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
      //   68: pop
      //   69: aload 4
      //   71: aload 5
      //   73: aload 6
      //   75: invokevirtual 221	okio/Buffer:inputStream	()Ljava/io/InputStream;
      //   78: invokevirtual 225	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      //   81: invokeinterface 231 2 0
      //   86: pop
      //   87: iload_1
      //   88: iconst_1
      //   89: iadd
      //   90: istore_1
      //   91: goto -56 -> 35
      //   94: astore_0
      //   95: new 77	java/io/IOException
      //   98: dup
      //   99: aload_0
      //   100: invokevirtual 234	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
      //   103: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   106: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	paramBufferedSource	BufferedSource
      //   34	57	1	i	int
      //   4	37	2	j	int
      //   13	49	3	localObject	Object
      //   31	39	4	localArrayList	java.util.ArrayList
      //   21	51	5	localCertificateFactory	java.security.cert.CertificateFactory
      //   57	17	6	localBuffer	okio.Buffer
      // Exception table:
      //   from	to	target	type
      //   16	33	94	java/security/cert/CertificateException
      //   43	87	94	java/security/cert/CertificateException
    }
    
    private static void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramBufferedSink.writeDecimalLong(paramList.size());
        paramBufferedSink.writeByte(10);
        int i = 0;
        int j = paramList.size();
        while (i < j)
        {
          paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64());
          paramBufferedSink.writeByte(10);
          i += 1;
        }
        return;
      }
      catch (CertificateEncodingException paramBufferedSink)
      {
        throw new IOException(paramBufferedSink.getMessage());
      }
    }
    
    public final void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      paramEditor = Okio.buffer(paramEditor.newSink(0));
      paramEditor.writeUtf8(url);
      paramEditor.writeByte(10);
      paramEditor.writeUtf8(requestMethod);
      paramEditor.writeByte(10);
      paramEditor.writeDecimalLong(varyHeaders.namesAndValues.length / 2);
      paramEditor.writeByte(10);
      int i = 0;
      int j = varyHeaders.namesAndValues.length / 2;
      while (i < j)
      {
        paramEditor.writeUtf8(varyHeaders.name(i));
        paramEditor.writeUtf8(": ");
        paramEditor.writeUtf8(varyHeaders.value(i));
        paramEditor.writeByte(10);
        i += 1;
      }
      paramEditor.writeUtf8(new StatusLine(protocol, code, message).toString());
      paramEditor.writeByte(10);
      paramEditor.writeDecimalLong(responseHeaders.namesAndValues.length / 2);
      paramEditor.writeByte(10);
      i = 0;
      j = responseHeaders.namesAndValues.length / 2;
      while (i < j)
      {
        paramEditor.writeUtf8(responseHeaders.name(i));
        paramEditor.writeUtf8(": ");
        paramEditor.writeUtf8(responseHeaders.value(i));
        paramEditor.writeByte(10);
        i += 1;
      }
      if (isHttps())
      {
        paramEditor.writeByte(10);
        paramEditor.writeUtf8(handshake.cipherSuite.javaName);
        paramEditor.writeByte(10);
        writeCertList(paramEditor, handshake.peerCertificates);
        writeCertList(paramEditor, handshake.localCertificates);
        if (handshake.tlsVersion != null)
        {
          paramEditor.writeUtf8(handshake.tlsVersion.javaName);
          paramEditor.writeByte(10);
        }
      }
      paramEditor.close();
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.Cache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */