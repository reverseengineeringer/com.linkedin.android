package com.linkedin.android.perftimer;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap.Builder;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.perf.commons.network.MovingAverage;
import com.linkedin.android.perf.commons.network.NetworkMonitor;
import com.linkedin.android.perf.commons.network.NetworkQuality;
import java.util.List;
import java.util.UUID;

public class RUMTiming
{
  private static final String TAG;
  private static volatile boolean sAppBackgrounded;
  private static volatile long sAppStartTime;
  private static volatile boolean sAppWasStarted = false;
  private static volatile long sColdLaunchThreshold;
  private static volatile String sProcessId;
  private static ConcurrentLinkedHashMap<String, RUMBuilder> sRumBuilderMap = new ConcurrentLinkedHashMap.Builder().initialCapacity$5a8ffd72().maximumWeightedCapacity$401f0453().build();
  private static volatile boolean sSendInProgress;
  private static final Object sendRumBeaconsLock;
  
  static
  {
    sAppBackgrounded = false;
    sSendInProgress = false;
    sProcessId = null;
    sAppStartTime = -1L;
    sColdLaunchThreshold = 500L;
    TAG = RUMTiming.class.getSimpleName();
    sendRumBeaconsLock = new Object();
  }
  
  public static void appBackgrounded()
  {
    sAppBackgrounded = true;
  }
  
  public static void appStarted()
  {
    sAppWasStarted = true;
    sAppStartTime = RUMBuilder.appStarted();
  }
  
  public static void cacheLookUpEnd(String paramString1, String paramString2, RUMBuilder.CACHE_TYPE paramCACHE_TYPE, boolean paramBoolean)
  {
    paramString1 = getRUMBuilder(paramString1);
    long l;
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      l = SystemClock.elapsedRealtime();
      paramString1 = paramString1.getGranularMetricsFromMap(paramString2);
      if (paramCACHE_TYPE != RUMBuilder.CACHE_TYPE.MEMORY) {
        break label48;
      }
      mMemoryCacheLookupEnd = l;
    }
    for (;;)
    {
      mCacheHit |= paramBoolean;
      return;
      label48:
      if (paramCACHE_TYPE == RUMBuilder.CACHE_TYPE.DISK) {
        mDiskCacheLookupEnd = l;
      }
    }
  }
  
  public static void cacheLookUpStart(String paramString1, String paramString2, RUMBuilder.CACHE_TYPE paramCACHE_TYPE)
  {
    paramString1 = getRUMBuilder(paramString1);
    long l;
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      l = SystemClock.elapsedRealtime();
      paramString1 = paramString1.getGranularMetricsFromMap(paramString2);
      if (paramCACHE_TYPE != RUMBuilder.CACHE_TYPE.MEMORY) {
        break label36;
      }
      mMemoryCacheLookupStart = l;
    }
    label36:
    while (paramCACHE_TYPE != RUMBuilder.CACHE_TYPE.DISK) {
      return;
    }
    mDiskCacheLookupStart = l;
  }
  
  public static void connectionDropped(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      paramString1 = paramString1.getGranularMetricsFromMap(paramString2);
      mConnectionDropCount += 1;
      mConnectionDropDuration = l;
    }
  }
  
  public static void customMarkerEnd(String paramString1, String paramString2)
  {
    if (getRUMBuilder(paramString1) != null) {
      ExperimentalTiming.stopTimingForFunctionName(paramString1, paramString2);
    }
  }
  
  public static void customMarkerStart(String paramString1, String paramString2)
  {
    if (getRUMBuilder(paramString1) != null) {
      ExperimentalTiming.startTimingForFunctionName(paramString1, paramString2);
    }
  }
  
  public static void dnsLookupEnd(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmDNSLookupEnd = l;
    }
  }
  
  public static void dnsLookupStart(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmDNSLookupStart = l;
    }
  }
  
  private static RUMBuilder getRUMBuilder(String paramString)
  {
    if (paramString != null) {
      return (RUMBuilder)sRumBuilderMap.get(paramString);
    }
    return null;
  }
  
  public static ConcurrentLinkedHashMap getRumBuilderMap()
  {
    return sRumBuilderMap;
  }
  
  public static void httpMetricEnd$379e7088(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      paramString1 = paramString1.getGranularMetricsFromMap(paramString2);
      mNetworkRequestEnd = l;
      mResponseSize = 0L;
      mStatusCode = paramInt;
    }
  }
  
  public static void httpMetricStart(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmNetworkRequestStart = l;
    }
  }
  
  public static void imageDecodeEnd(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmImageDecodeEnd = l;
    }
  }
  
  public static void imageDecodeStart(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmImageDecodeStart = l;
    }
  }
  
  public static void imagePostProcessingEnd(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmImagePostProcessingEnd = l;
    }
  }
  
  public static void imagePostProcessingStart(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmImagePostProcessingStart = l;
    }
  }
  
  public static String initialize(Context paramContext, String paramString)
  {
    String str = UUID.randomUUID().toString();
    paramContext = new RUMBuilder(paramContext, paramString);
    mSessionId = str;
    mProcessId = sProcessId;
    if (sAppWasStarted) {
      if (SystemClock.elapsedRealtime() - sAppStartTime <= sColdLaunchThreshold)
      {
        RUMBuilder.setLaunchType(RUMBuilder.LAUNCH_TYPE.COLD_LAUNCH);
        paramContext.associateAppLaunchToMe();
        sAppWasStarted = false;
        sAppBackgrounded = false;
      }
    }
    for (;;)
    {
      sRumBuilderMap.putIfAbsent(str, paramContext);
      if ((!RUMConfig.DO_NOT_SEND_RUM_BEACONS) && (sRumBuilderMap.size() > 40) && (!sSendInProgress)) {
        break label133;
      }
      return str;
      RUMBuilder.setLaunchType(RUMBuilder.LAUNCH_TYPE.WARM_LAUNCH);
      break;
      if (sAppBackgrounded)
      {
        RUMBuilder.setLaunchType(RUMBuilder.LAUNCH_TYPE.WARM_LAUNCH);
        paramContext.associateAppLaunchToMe();
        sAppBackgrounded = false;
      }
    }
    label133:
    new Thread(new RUMTiming.1()).start();
    return str;
  }
  
  public static void networkRequestInfo(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      paramString1 = paramString1.getGranularMetricsFromMap(paramString2);
      mResponseSize = paramLong1;
      mServerDurationInMS = paramLong2;
      if (RUMBuilder.isValidTreeId(paramString3)) {
        mTreeid = paramString3;
      }
    }
  }
  
  public static void parseEnd$3b99f9eb(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmParseEnd = l;
      mParseRecorded = true;
    }
  }
  
  public static void parseStart$3b99f9eb(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmParseStart = l;
    }
  }
  
  static void removeRUMBuilderFromLRUMap(String paramString)
  {
    if (paramString != null) {
      sRumBuilderMap.remove(paramString);
    }
  }
  
  public static void renderEnd(String paramString, boolean paramBoolean)
  {
    paramString = getRUMBuilder(paramString);
    long l;
    if (paramString != null)
    {
      l = SystemClock.elapsedRealtime();
      if (!mRenderStarted)
      {
        mTotalDuration = RUMUtils.getDuration(mPageStart, l);
        mRenderStarted = true;
      }
      if (paramBoolean) {
        mCacheRenderEndTimestamps.add(Long.valueOf(l));
      }
    }
    else
    {
      return;
    }
    mRenderEndTimestamps.add(Long.valueOf(l));
  }
  
  public static void renderStart(String paramString, boolean paramBoolean)
  {
    paramString = getRUMBuilder(paramString);
    if (paramString != null) {
      paramString.renderStart(paramBoolean);
    }
  }
  
  public static void renderStart(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = getRUMBuilder(paramString);
    if (paramString != null)
    {
      if (!mAggregateMultipleRenders) {
        mAggregateMultipleRenders = paramBoolean2;
      }
      paramString.renderStart(paramBoolean1);
    }
  }
  
  public static void requestEnd(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    paramString1 = getRUMBuilder(paramString1);
    double d1;
    double d2;
    double d3;
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      paramString2 = paramString1.getGranularMetricsFromMap(paramString2);
      mResponseSize = paramLong1;
      mServerDurationInMS = paramLong2;
      mNetworkRequestEnd = l;
      if (RUMBuilder.isValidTreeId(paramString3)) {
        mTreeid = paramString3;
      }
      if ((mNetworkRequestStart != -1L) && (paramLong2 > 0L))
      {
        paramLong2 = l - mNetworkRequestStart - paramLong2;
        if (paramLong2 > 0L)
        {
          paramString2 = NetworkMonitor.getInstance(mContext);
          if (paramLong2 != 0L)
          {
            d1 = 8L * paramLong1 / paramLong2;
            paramString3 = mDownloadQuality;
            paramString1 = mDownloadMovingAverage;
            d2 = 1.0D - mDecayConstant;
            if (mCount <= mCutover) {
              break label266;
            }
            d3 = Math.log(mValue);
            double d4 = mDecayConstant;
            mValue = Math.exp(Math.log(d1) * d4 + d2 * d3);
            mCount += 1;
            paramString1 = mDownloadMovingAverage;
            if (mValue >= 0.0D) {
              break label335;
            }
            paramString1 = NetworkQuality.UNKNOWN;
          }
        }
      }
    }
    for (;;)
    {
      mDownloadQuality = paramString1;
      if (paramString3 != mDownloadQuality)
      {
        paramString1 = new Intent("DOWNLOAD_NETWORK_QUALITY_CHANGED");
        paramString1.putExtra("NETWORK_QUALITY", mDownloadQuality.ordinal());
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(paramString1);
      }
      return;
      label266:
      if (mCount > 0)
      {
        d2 = d2 * mCount / (mCount + 1.0D);
        d3 = Math.log(mValue);
        mValue = Math.exp(Math.log(d1) * (1.0D - d2) + d2 * d3);
        break;
      }
      mValue = d1;
      break;
      label335:
      if (mValue < 150.0D) {
        paramString1 = NetworkQuality.POOR;
      } else if (mValue < 550.0D) {
        paramString1 = NetworkQuality.AVERAGE;
      } else if (mValue < 2048.0D) {
        paramString1 = NetworkQuality.GOOD;
      } else {
        paramString1 = NetworkQuality.EXCELLENT;
      }
    }
  }
  
  public static void requestStart(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmNetworkRequestStart = l;
    }
  }
  
  public static void sendRUMBeacons(Tracker paramTracker)
  {
    RUMTracking.setAppTracker(paramTracker);
    if (!RUMConfig.DO_NOT_SEND_RUM_BEACONS) {
      new Thread(new RUMTiming.2()).start();
    }
  }
  
  public static void setColdLaunchThreshold(long paramLong)
  {
    sColdLaunchThreshold = paramLong;
  }
  
  public static void setForegroundingMode(RUMBuilder.FOREGROUNDING_MODE paramFOREGROUNDING_MODE)
  {
    RUMBuilder.setForegroundingMode(paramFOREGROUNDING_MODE);
  }
  
  public static void setPOPId(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (paramString1 != null) {
      mPointOfPresenceId = paramString2;
    }
  }
  
  public static void setPageKey(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (paramString1 != null) {
      mPageKey = paramString2;
    }
  }
  
  public static void setProcessId(String paramString)
  {
    sProcessId = paramString;
  }
  
  public static void timeToFirstchunk(String paramString1, String paramString2)
  {
    paramString1 = getRUMBuilder(paramString1);
    if (validRUMBuilderAndUrl(paramString1, paramString2))
    {
      long l = SystemClock.elapsedRealtime();
      getGranularMetricsFromMapmTimeToFirstChunk = l;
    }
  }
  
  private static boolean validRUMBuilderAndUrl(RUMBuilder paramRUMBuilder, String paramString)
  {
    return (paramRUMBuilder != null) && (paramString != null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.perftimer.RUMTiming
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */