package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

public final class Dispatcher
{
  private ExecutorService executorService;
  private int maxRequests = 64;
  private int maxRequestsPerHost = 5;
  private final Deque<Object> readyAsyncCalls = new ArrayDeque();
  private final Deque<Object> runningAsyncCalls = new ArrayDeque();
  private final Deque<RealCall> runningSyncCalls = new ArrayDeque();
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService)
  {
    executorService = paramExecutorService;
  }
  
  final void executed(RealCall paramRealCall)
  {
    try
    {
      runningSyncCalls.add(paramRealCall);
      return;
    }
    finally
    {
      paramRealCall = finally;
      throw paramRealCall;
    }
  }
  
  public final ExecutorService executorService()
  {
    try
    {
      if (executorService == null) {
        executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = executorService;
      return localExecutorService;
    }
    finally {}
  }
  
  final void finished(Call paramCall)
  {
    try
    {
      if (!runningSyncCalls.remove(paramCall)) {
        throw new AssertionError("Call wasn't in-flight!");
      }
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     okhttp3.Dispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */