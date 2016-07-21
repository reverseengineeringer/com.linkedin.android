package com.linkedin.android.perftimer;

import android.app.Application;
import com.linkedin.android.perf.commons.IHttpStack;
import com.linkedin.android.perf.commons.network.NetworkMonitor;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class PerfTimer
{
  public static ConcurrentHashMap<String, Queue<PerfHttpMetricsMapObject>> perfHttpMetricsMap = new ConcurrentHashMap();
  public static Queue<MetricsMapObject> perfNativeTimingsArray = new ConcurrentLinkedQueue();
  public static ConcurrentHashMap<String, Queue<PerfNativeTimingsMapObject>> perfNativeTimingsMap;
  private static PerfTimer perftimer = null;
  public static ConcurrentHashMap<String, Long> timeMap = new ConcurrentHashMap();
  final IHttpStack httpStack;
  private final NetworkMonitor networkMonitor;
  
  static
  {
    perfNativeTimingsMap = new ConcurrentHashMap();
  }
  
  private PerfTimer(Application paramApplication, IHttpStack paramIHttpStack)
  {
    httpStack = paramIHttpStack;
    networkMonitor = NetworkMonitor.getInstance(paramApplication);
  }
  
  public static final PerfTimer getInstance()
  {
    if (perftimer == null) {
      throw new IllegalStateException("PerfTimer accessed before initialization");
    }
    return perftimer;
  }
  
  public static void initialize(Application paramApplication, IHttpStack paramIHttpStack)
  {
    perftimer = new PerfTimer(paramApplication, paramIHttpStack);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.perftimer.PerfTimer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */