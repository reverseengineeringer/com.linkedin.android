package okhttp3;

import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;

final class OkHttpClient$1
  extends Internal
{
  public final void addLenient(Headers.Builder paramBuilder, String paramString)
  {
    paramBuilder.addLenient(paramString);
  }
  
  public final void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (cipherSuites != null)
    {
      arrayOfString1 = (String[])Util.intersect(String.class, cipherSuites, paramSSLSocket.getEnabledCipherSuites());
      if (tlsVersions == null) {
        break label145;
      }
    }
    label145:
    for (String[] arrayOfString2 = (String[])Util.intersect(String.class, tlsVersions, paramSSLSocket.getEnabledProtocols());; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (Util.contains(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
          arrayOfString3 = Util.concat(arrayOfString1, "TLS_FALLBACK_SCSV");
        }
      }
      paramConnectionSpec = new ConnectionSpec.Builder(paramConnectionSpec).cipherSuites(arrayOfString3).tlsVersions(arrayOfString2).build();
      if (tlsVersions != null) {
        paramSSLSocket.setEnabledProtocols(tlsVersions);
      }
      if (cipherSuites != null) {
        paramSSLSocket.setEnabledCipherSuites(cipherSuites);
      }
      return;
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  public final boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection)
  {
    if ((!ConnectionPool.$assertionsDisabled) && (!Thread.holdsLock(paramConnectionPool))) {
      throw new AssertionError();
    }
    if ((noNewStreams) || (maxIdleConnections == 0))
    {
      connections.remove(paramRealConnection);
      return true;
    }
    paramConnectionPool.notifyAll();
    return false;
  }
  
  public final RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    if ((!ConnectionPool.$assertionsDisabled) && (!Thread.holdsLock(paramConnectionPool))) {
      throw new AssertionError();
    }
    paramConnectionPool = connections.iterator();
    while (paramConnectionPool.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)paramConnectionPool.next();
      if ((allocations.size() < allocationLimit) && (paramAddress.equals(route.address)) && (!noNewStreams))
      {
        paramStreamAllocation.acquire(localRealConnection);
        return localRealConnection;
      }
    }
    return null;
  }
  
  public final InternalCache internalCache(OkHttpClient paramOkHttpClient)
  {
    if (cache != null) {
      return cache.internalCache;
    }
    return internalCache;
  }
  
  public final void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection)
  {
    if ((!ConnectionPool.$assertionsDisabled) && (!Thread.holdsLock(paramConnectionPool))) {
      throw new AssertionError();
    }
    if (!cleanupRunning)
    {
      cleanupRunning = true;
      ConnectionPool.executor.execute(cleanupRunnable);
    }
    connections.add(paramRealConnection);
  }
  
  public final RouteDatabase routeDatabase(ConnectionPool paramConnectionPool)
  {
    return routeDatabase;
  }
}

/* Location:
 * Qualified Name:     okhttp3.OkHttpClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */