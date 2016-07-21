package okhttp3.internal;

import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers.Builder;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;

public abstract class Internal
{
  public static Internal instance;
  public static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
  
  public abstract void addLenient(Headers.Builder paramBuilder, String paramString);
  
  public abstract void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation);
  
  public abstract InternalCache internalCache(OkHttpClient paramOkHttpClient);
  
  public abstract void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract RouteDatabase routeDatabase(ConnectionPool paramConnectionPool);
}

/* Location:
 * Qualified Name:     okhttp3.internal.Internal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */