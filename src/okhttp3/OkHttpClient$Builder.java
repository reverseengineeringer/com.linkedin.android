package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.InternalCache;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.tls.TrustRootIndex;

public final class OkHttpClient$Builder
{
  Authenticator authenticator;
  public Cache cache;
  CertificatePinner certificatePinner;
  public int connectTimeout;
  ConnectionPool connectionPool;
  List<ConnectionSpec> connectionSpecs;
  public CookieJar cookieJar;
  public Dispatcher dispatcher;
  public Dns dns;
  boolean followRedirects;
  boolean followSslRedirects;
  HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors = new ArrayList();
  public InternalCache internalCache;
  final List<Interceptor> networkInterceptors = new ArrayList();
  List<Protocol> protocols;
  Proxy proxy;
  Authenticator proxyAuthenticator;
  ProxySelector proxySelector;
  int readTimeout;
  boolean retryOnConnectionFailure;
  SocketFactory socketFactory;
  SSLSocketFactory sslSocketFactory;
  TrustRootIndex trustRootIndex;
  int writeTimeout;
  
  public OkHttpClient$Builder()
  {
    dispatcher = new Dispatcher();
    protocols = OkHttpClient.access$000();
    connectionSpecs = OkHttpClient.access$100();
    proxySelector = ProxySelector.getDefault();
    cookieJar = CookieJar.NO_COOKIES;
    socketFactory = SocketFactory.getDefault();
    hostnameVerifier = OkHostnameVerifier.INSTANCE;
    certificatePinner = CertificatePinner.DEFAULT;
    proxyAuthenticator = Authenticator.NONE;
    authenticator = Authenticator.NONE;
    connectionPool = new ConnectionPool();
    dns = Dns.SYSTEM;
    followSslRedirects = true;
    followRedirects = true;
    retryOnConnectionFailure = true;
    connectTimeout = 10000;
    readTimeout = 10000;
    writeTimeout = 10000;
  }
  
  public OkHttpClient$Builder(OkHttpClient paramOkHttpClient)
  {
    dispatcher = dispatcher;
    proxy = proxy;
    protocols = protocols;
    connectionSpecs = connectionSpecs;
    interceptors.addAll(interceptors);
    networkInterceptors.addAll(networkInterceptors);
    proxySelector = proxySelector;
    cookieJar = cookieJar;
    internalCache = internalCache;
    cache = cache;
    socketFactory = socketFactory;
    sslSocketFactory = sslSocketFactory;
    trustRootIndex = trustRootIndex;
    hostnameVerifier = hostnameVerifier;
    certificatePinner = certificatePinner;
    proxyAuthenticator = proxyAuthenticator;
    authenticator = authenticator;
    connectionPool = connectionPool;
    dns = dns;
    followSslRedirects = followSslRedirects;
    followRedirects = followRedirects;
    retryOnConnectionFailure = retryOnConnectionFailure;
    connectTimeout = connectTimeout;
    readTimeout = readTimeout;
    writeTimeout = writeTimeout;
  }
  
  public final Builder addInterceptor(Interceptor paramInterceptor)
  {
    interceptors.add(paramInterceptor);
    return this;
  }
  
  public final OkHttpClient build()
  {
    return new OkHttpClient(this, (byte)0);
  }
  
  public final Builder readTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    readTimeout = ((int)l);
    return this;
  }
  
  public final Builder writeTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    long l = paramTimeUnit.toMillis(paramLong);
    if (l > 2147483647L) {
      throw new IllegalArgumentException("Timeout too large.");
    }
    if ((l == 0L) && (paramLong > 0L)) {
      throw new IllegalArgumentException("Timeout too small.");
    }
    writeTimeout = ((int)l);
    return this;
  }
}

/* Location:
 * Qualified Name:     okhttp3.OkHttpClient.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */