package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import okhttp3.internal.DiskLruCache.Editor;
import okhttp3.internal.Util;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StatusLine;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Cache$Entry
{
  final int code;
  final Handshake handshake;
  final String message;
  final Protocol protocol;
  final String requestMethod;
  final Headers responseHeaders;
  final String url;
  final Headers varyHeaders;
  
  public Cache$Entry(Response paramResponse)
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
  
  public Cache$Entry(Source paramSource)
    throws IOException
  {
    try
    {
      BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
      url = localBufferedSource1.readUtf8LineStrict();
      requestMethod = localBufferedSource1.readUtf8LineStrict();
      localObject = new Headers.Builder();
      int j = Cache.access$1000(localBufferedSource1);
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
      j = Cache.access$1000(localBufferedSource1);
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

/* Location:
 * Qualified Name:     okhttp3.Cache.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */