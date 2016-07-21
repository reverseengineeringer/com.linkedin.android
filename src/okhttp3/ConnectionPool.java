package okhttp3;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.io.RealConnection;

public final class ConnectionPool
{
  static final Executor executor;
  final Runnable cleanupRunnable = new Runnable()
  {
    public final void run()
    {
      long l1;
      do
      {
        l1 = cleanup(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
      } while (l1 <= 0L);
      long l2 = l1 / 1000000L;
      try
      {
        synchronized (ConnectionPool.this)
        {
          wait(l2, (int)(l1 - l2 * 1000000L));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  };
  boolean cleanupRunning;
  final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  final int maxIdleConnections = 5;
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  static
  {
    if (!ConnectionPool.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
      return;
    }
  }
  
  public ConnectionPool()
  {
    this(TimeUnit.MINUTES);
  }
  
  private ConnectionPool(TimeUnit paramTimeUnit)
  {
    keepAliveDurationNs = paramTimeUnit.toNanos(5L);
    if (5L <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: 5");
    }
  }
  
  final long cleanup(long paramLong)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    long l1 = Long.MIN_VALUE;
    for (;;)
    {
      int k;
      try
      {
        Iterator localIterator = connections.iterator();
        if (localIterator.hasNext())
        {
          RealConnection localRealConnection = (RealConnection)localIterator.next();
          List localList = allocations;
          k = 0;
          if (k < localList.size())
          {
            if (((Reference)localList.get(k)).get() != null)
            {
              k += 1;
              continue;
            }
            Internal.logger.warning("A connection to " + route.address.url + " was leaked. Did you forget to close a response body?");
            localList.remove(k);
            noNewStreams = true;
            if (!localList.isEmpty()) {
              continue;
            }
            idleAtNanos = (paramLong - keepAliveDurationNs);
            k = 0;
            break label318;
          }
          k = localList.size();
          break label318;
          k = i + 1;
          long l2 = paramLong - idleAtNanos;
          i = k;
          if (l2 <= l1) {
            continue;
          }
          l1 = l2;
          localObject1 = localRealConnection;
          i = k;
          continue;
        }
        if ((l1 >= keepAliveDurationNs) || (i > maxIdleConnections))
        {
          connections.remove(localObject1);
          Util.closeQuietly(socket);
          return 0L;
        }
        if (i > 0)
        {
          paramLong = keepAliveDurationNs;
          return paramLong - l1;
        }
      }
      finally {}
      if (j > 0)
      {
        paramLong = keepAliveDurationNs;
        return paramLong;
      }
      cleanupRunning = false;
      return -1L;
      label318:
      if (k > 0) {
        j += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.ConnectionPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */