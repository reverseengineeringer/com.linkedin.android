package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Platform;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.tls.TrustRootIndex;

public class OkHttpClient
  implements Cloneable
{
  private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1 });
  public final Authenticator authenticator;
  final Cache cache;
  public final CertificatePinner certificatePinner;
  public final int connectTimeout;
  public final ConnectionPool connectionPool;
  public final List<ConnectionSpec> connectionSpecs;
  public final CookieJar cookieJar;
  public final Dispatcher dispatcher;
  public final Dns dns;
  public final boolean followRedirects;
  public final boolean followSslRedirects;
  public final HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors;
  final InternalCache internalCache;
  public final List<Interceptor> networkInterceptors;
  public final List<Protocol> protocols;
  public final Proxy proxy;
  public final Authenticator proxyAuthenticator;
  public final ProxySelector proxySelector;
  public final int readTimeout;
  public final boolean retryOnConnectionFailure;
  public final SocketFactory socketFactory;
  public final SSLSocketFactory sslSocketFactory;
  final TrustRootIndex trustRootIndex;
  public final int writeTimeout;
  
  static
  {
    DEFAULT_CONNECTION_SPECS = Util.immutableList(new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT });
    Internal.instance = new Internal()
    {
      public final void addLenient(Headers.Builder paramAnonymousBuilder, String paramAnonymousString)
      {
        paramAnonymousBuilder.addLenient(paramAnonymousString);
      }
      
      public final void apply(ConnectionSpec paramAnonymousConnectionSpec, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        String[] arrayOfString1;
        if (cipherSuites != null)
        {
          arrayOfString1 = (String[])Util.intersect(String.class, cipherSuites, paramAnonymousSSLSocket.getEnabledCipherSuites());
          if (tlsVersions == null) {
            break label145;
          }
        }
        label145:
        for (String[] arrayOfString2 = (String[])Util.intersect(String.class, tlsVersions, paramAnonymousSSLSocket.getEnabledProtocols());; arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols())
        {
          String[] arrayOfString3 = arrayOfString1;
          if (paramAnonymousBoolean)
          {
            arrayOfString3 = arrayOfString1;
            if (Util.contains(paramAnonymousSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
              arrayOfString3 = Util.concat(arrayOfString1, "TLS_FALLBACK_SCSV");
            }
          }
          paramAnonymousConnectionSpec = new ConnectionSpec.Builder(paramAnonymousConnectionSpec).cipherSuites(arrayOfString3).tlsVersions(arrayOfString2).build();
          if (tlsVersions != null) {
            paramAnonymousSSLSocket.setEnabledProtocols(tlsVersions);
          }
          if (cipherSuites != null) {
            paramAnonymousSSLSocket.setEnabledCipherSuites(cipherSuites);
          }
          return;
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
          break;
        }
      }
      
      public final boolean connectionBecameIdle(ConnectionPool paramAnonymousConnectionPool, RealConnection paramAnonymousRealConnection)
      {
        if ((!ConnectionPool.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousConnectionPool))) {
          throw new AssertionError();
        }
        if ((noNewStreams) || (maxIdleConnections == 0))
        {
          connections.remove(paramAnonymousRealConnection);
          return true;
        }
        paramAnonymousConnectionPool.notifyAll();
        return false;
      }
      
      public final RealConnection get(ConnectionPool paramAnonymousConnectionPool, Address paramAnonymousAddress, StreamAllocation paramAnonymousStreamAllocation)
      {
        if ((!ConnectionPool.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousConnectionPool))) {
          throw new AssertionError();
        }
        paramAnonymousConnectionPool = connections.iterator();
        while (paramAnonymousConnectionPool.hasNext())
        {
          RealConnection localRealConnection = (RealConnection)paramAnonymousConnectionPool.next();
          if ((allocations.size() < allocationLimit) && (paramAnonymousAddress.equals(route.address)) && (!noNewStreams))
          {
            paramAnonymousStreamAllocation.acquire(localRealConnection);
            return localRealConnection;
          }
        }
        return null;
      }
      
      public final InternalCache internalCache(OkHttpClient paramAnonymousOkHttpClient)
      {
        if (cache != null) {
          return cache.internalCache;
        }
        return internalCache;
      }
      
      public final void put(ConnectionPool paramAnonymousConnectionPool, RealConnection paramAnonymousRealConnection)
      {
        if ((!ConnectionPool.$assertionsDisabled) && (!Thread.holdsLock(paramAnonymousConnectionPool))) {
          throw new AssertionError();
        }
        if (!cleanupRunning)
        {
          cleanupRunning = true;
          ConnectionPool.executor.execute(cleanupRunnable);
        }
        connections.add(paramAnonymousRealConnection);
      }
      
      public final RouteDatabase routeDatabase(ConnectionPool paramAnonymousConnectionPool)
      {
        return routeDatabase;
      }
    };
  }
  
  public OkHttpClient()
  {
    this(new Builder());
  }
  
  private OkHttpClient(Builder paramBuilder)
  {
    dispatcher = dispatcher;
    proxy = proxy;
    protocols = protocols;
    connectionSpecs = connectionSpecs;
    interceptors = Util.immutableList(interceptors);
    networkInterceptors = Util.immutableList(networkInterceptors);
    proxySelector = proxySelector;
    cookieJar = cookieJar;
    cache = cache;
    internalCache = internalCache;
    socketFactory = socketFactory;
    int i = 0;
    Object localObject = connectionSpecs.iterator();
    if (((Iterator)localObject).hasNext())
    {
      ConnectionSpec localConnectionSpec = (ConnectionSpec)((Iterator)localObject).next();
      if ((i != 0) || (tls)) {}
      for (i = 1;; i = 0) {
        break;
      }
    }
    if ((sslSocketFactory != null) || (i == 0)) {
      sslSocketFactory = sslSocketFactory;
    }
    for (;;)
    {
      if ((sslSocketFactory == null) || (trustRootIndex != null)) {
        break label402;
      }
      localObject = Platform.get().trustManager(sslSocketFactory);
      if (localObject == null)
      {
        throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        try
        {
          localObject = SSLContext.getInstance("TLS");
          ((SSLContext)localObject).init(null, null, null);
          sslSocketFactory = ((SSLContext)localObject).getSocketFactory();
        }
        catch (GeneralSecurityException paramBuilder)
        {
          throw new AssertionError();
        }
      }
    }
    trustRootIndex = Platform.get().trustRootIndex((X509TrustManager)localObject);
    localObject = new CertificatePinner.Builder(certificatePinner);
    trustRootIndex = trustRootIndex;
    for (certificatePinner = ((CertificatePinner.Builder)localObject).build();; certificatePinner = certificatePinner)
    {
      hostnameVerifier = hostnameVerifier;
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
      return;
      label402:
      trustRootIndex = trustRootIndex;
    }
  }
  
  public final Call newCall(Request paramRequest)
  {
    return new RealCall(this, paramRequest);
  }
  
  public static final class Builder
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
    
    public Builder()
    {
      dispatcher = new Dispatcher();
      protocols = OkHttpClient.DEFAULT_PROTOCOLS;
      connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
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
    
    public Builder(OkHttpClient paramOkHttpClient)
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
}

/* Location:
 * Qualified Name:     okhttp3.OkHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */