package okhttp3.internal.http;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.util.List;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.io.RealConnection;

public final class StreamAllocation
{
  public final Address address;
  private boolean canceled;
  RealConnection connection;
  private final ConnectionPool connectionPool;
  private boolean released;
  private Route route;
  RouteSelector routeSelector;
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress)
  {
    connectionPool = paramConnectionPool;
    address = paramAddress;
    routeSelector = new RouteSelector(paramAddress, routeDatabase());
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException, RouteException
  {
    synchronized (connectionPool)
    {
      if (released) {
        throw new IllegalStateException("released");
      }
    }
    if (stream != null) {
      throw new IllegalStateException("stream != null");
    }
    if (canceled) {
      throw new IOException("Canceled");
    }
    ??? = connection;
    if ((??? != null) && (!noNewStreams)) {
      return (RealConnection)???;
    }
    ??? = Internal.instance.get(connectionPool, address, this);
    if (??? != null)
    {
      connection = ((RealConnection)???);
      return (RealConnection)???;
    }
    ??? = route;
    ??? = ???;
    if (??? == null) {
      ??? = routeSelector.next();
    }
    synchronized (connectionPool)
    {
      route = ((Route)???);
      ??? = new RealConnection((Route)???);
      acquire((RealConnection)???);
      synchronized (connectionPool)
      {
        Internal.instance.put(connectionPool, (RealConnection)???);
        connection = ((RealConnection)???);
        if (canceled) {
          throw new IOException("Canceled");
        }
      }
    }
    localRealConnection.connect(paramInt1, paramInt2, paramInt3, address.connectionSpecs, paramBoolean);
    routeDatabase().connected(route);
    return localRealConnection;
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, RouteException
  {
    for (;;)
    {
      RealConnection localRealConnection1 = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (connectionPool)
      {
        if (successCount == 0) {
          return localRealConnection1;
        }
        if (!localRealConnection1.isHealthy(paramBoolean2)) {
          connectionFailed(new IOException());
        }
      }
    }
    return localRealConnection2;
  }
  
  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(connectionPool);
  }
  
  public final void acquire(RealConnection paramRealConnection)
  {
    allocations.add(new WeakReference(this));
  }
  
  public final RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void connectionFailed(IOException paramIOException)
  {
    synchronized (connectionPool)
    {
      if ((connection != null) && (connection.successCount == 0))
      {
        if ((route != null) && (paramIOException != null))
        {
          RouteSelector localRouteSelector = routeSelector;
          Route localRoute = route;
          if ((proxy.type() != Proxy.Type.DIRECT) && (address.proxySelector != null)) {
            address.proxySelector.connectFailed(address.url.uri(), proxy.address(), paramIOException);
          }
          routeDatabase.failed(localRoute);
        }
        route = null;
      }
      deallocate(true, false, true);
      return;
    }
  }
  
  public final void deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    ConnectionPool localConnectionPool = connectionPool;
    if (paramBoolean3) {}
    try
    {
      stream = null;
      if (paramBoolean2) {
        released = true;
      }
      Object localObject1 = localObject4;
      int j;
      int i;
      if (connection != null)
      {
        if (paramBoolean1) {
          connection.noNewStreams = true;
        }
        localObject1 = localObject4;
        if (stream == null) {
          if (!released)
          {
            localObject1 = localObject4;
            if (!connection.noNewStreams) {}
          }
          else
          {
            localObject1 = connection;
            j = allocations.size();
            i = 0;
          }
        }
      }
      while (i < j)
      {
        if (((Reference)allocations.get(i)).get() == this)
        {
          allocations.remove(i);
          localObject1 = localObject3;
          if (connection.allocations.isEmpty())
          {
            connection.idleAtNanos = System.nanoTime();
            localObject1 = localObject3;
            if (Internal.instance.connectionBecameIdle(connectionPool, connection)) {
              localObject1 = connection;
            }
          }
          connection = null;
          if (localObject1 != null) {
            Util.closeQuietly(socket);
          }
          return;
        }
        i += 1;
      }
      throw new IllegalStateException();
    }
    finally {}
  }
  
  /* Error */
  public final HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws RouteException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: iload 5
    //   8: invokespecial 249	okhttp3/internal/http/StreamAllocation:findHealthyConnection	(IIIZZ)Lokhttp3/internal/io/RealConnection;
    //   11: astore 6
    //   13: aload 6
    //   15: getfield 253	okhttp3/internal/io/RealConnection:framedConnection	Lokhttp3/internal/framed/FramedConnection;
    //   18: ifnull +39 -> 57
    //   21: new 255	okhttp3/internal/http/Http2xStream
    //   24: dup
    //   25: aload_0
    //   26: aload 6
    //   28: getfield 253	okhttp3/internal/io/RealConnection:framedConnection	Lokhttp3/internal/framed/FramedConnection;
    //   31: invokespecial 258	okhttp3/internal/http/Http2xStream:<init>	(Lokhttp3/internal/http/StreamAllocation;Lokhttp3/internal/framed/FramedConnection;)V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 26	okhttp3/internal/http/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   40: astore 7
    //   42: aload 7
    //   44: monitorenter
    //   45: aload_0
    //   46: aload 6
    //   48: putfield 56	okhttp3/internal/http/StreamAllocation:stream	Lokhttp3/internal/http/HttpStream;
    //   51: aload 7
    //   53: monitorexit
    //   54: aload 6
    //   56: areturn
    //   57: aload 6
    //   59: getfield 238	okhttp3/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   62: iload_2
    //   63: invokevirtual 264	java/net/Socket:setSoTimeout	(I)V
    //   66: aload 6
    //   68: getfield 268	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   71: invokeinterface 274 1 0
    //   76: iload_2
    //   77: i2l
    //   78: getstatic 280	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   81: invokevirtual 285	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   84: pop
    //   85: aload 6
    //   87: getfield 289	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   90: invokeinterface 292 1 0
    //   95: iload_3
    //   96: i2l
    //   97: getstatic 280	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   100: invokevirtual 285	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   103: pop
    //   104: new 294	okhttp3/internal/http/Http1xStream
    //   107: dup
    //   108: aload_0
    //   109: aload 6
    //   111: getfield 268	okhttp3/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   114: aload 6
    //   116: getfield 289	okhttp3/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   119: invokespecial 297	okhttp3/internal/http/Http1xStream:<init>	(Lokhttp3/internal/http/StreamAllocation;Lokio/BufferedSource;Lokio/BufferedSink;)V
    //   122: astore 6
    //   124: goto -88 -> 36
    //   127: astore 6
    //   129: aload 7
    //   131: monitorexit
    //   132: aload 6
    //   134: athrow
    //   135: astore 6
    //   137: new 46	okhttp3/internal/http/RouteException
    //   140: dup
    //   141: aload 6
    //   143: invokespecial 299	okhttp3/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	StreamAllocation
    //   0	147	1	paramInt1	int
    //   0	147	2	paramInt2	int
    //   0	147	3	paramInt3	int
    //   0	147	4	paramBoolean1	boolean
    //   0	147	5	paramBoolean2	boolean
    //   11	112	6	localObject1	Object
    //   127	6	6	localObject2	Object
    //   135	7	6	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   45	54	127	finally
    //   129	132	127	finally
    //   0	36	135	java/io/IOException
    //   36	45	135	java/io/IOException
    //   57	124	135	java/io/IOException
    //   132	135	135	java/io/IOException
  }
  
  public final void release()
  {
    deallocate(false, true, false);
  }
  
  public final void streamFinished(boolean paramBoolean, HttpStream paramHttpStream)
  {
    ConnectionPool localConnectionPool = connectionPool;
    if (paramHttpStream != null) {}
    try
    {
      if (paramHttpStream != stream) {
        throw new IllegalStateException("expected " + stream + " but was " + paramHttpStream);
      }
    }
    finally
    {
      throw paramHttpStream;
      if (!paramBoolean)
      {
        paramHttpStream = connection;
        successCount += 1;
      }
    }
  }
  
  public final String toString()
  {
    return address.toString();
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.http.StreamAllocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */