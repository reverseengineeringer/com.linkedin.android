package com.linkedin.android.perftimer;

import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import com.linkedin.android.perf.commons.device.DeviceClass;
import com.linkedin.android.perf.commons.network.NetworkMonitor;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.CrossLinkValue;
import com.linkedin.gen.avro2pegasus.events.DeepLinkValue;
import com.linkedin.gen.avro2pegasus.events.GranularMetrics.Builder;
import com.linkedin.gen.avro2pegasus.events.NativeRealUserMonitoringEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.NetworkQuality;
import com.linkedin.gen.avro2pegasus.events.isCacheHit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RUMBuilder
{
  private static final String TAG = RUMBuilder.class.getSimpleName();
  private static volatile long sAppStart = -1L;
  private static volatile int sDeviceClassYear = 0;
  private static volatile FOREGROUNDING_MODE sForegroundingMode = null;
  private static volatile RUMBuilder.LAUNCH_TYPE sLaunchType = null;
  private final ConcurrentMap<String, Object> customMarkerMap = new ConcurrentHashMap();
  private final ConcurrentMap<String, GranularMetrics> granularMetricsMap = new ConcurrentHashMap();
  volatile boolean mAggregateMultipleRenders = false;
  private volatile long mAppStart = -1L;
  private volatile long mCacheRenderEnd = -1L;
  volatile List<Long> mCacheRenderEndTimestamps = new ArrayList();
  private volatile long mCacheRenderStart = -1L;
  private volatile List<Long> mCacheRenderStartTimestamps = new ArrayList();
  Context mContext;
  private volatile FOREGROUNDING_MODE mForegroundingMode = null;
  private volatile RUMBuilder.LAUNCH_TYPE mLaunchType = null;
  private volatile boolean mModelBindingRecorded = false;
  volatile String mPageKey = null;
  volatile long mPageStart = -1L;
  volatile boolean mParseRecorded = false;
  volatile String mPointOfPresenceId = null;
  volatile String mProcessId = null;
  private volatile long mRenderEnd = -1L;
  volatile List<Long> mRenderEndTimestamps = new ArrayList();
  private volatile long mRenderStart = -1L;
  private volatile List<Long> mRenderStartTimestamps = new ArrayList();
  volatile boolean mRenderStarted = false;
  volatile String mSessionId = null;
  volatile long mTotalDuration = -1L;
  private volatile long mViewBecameInteractive = -1L;
  
  public RUMBuilder(Context paramContext, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    mPageKey = paramString;
    mPageStart = SystemClock.elapsedRealtime();
    if (sDeviceClassYear == 0) {
      sDeviceClassYear = DeviceClass.get(mContext);
    }
  }
  
  public static long appStarted()
  {
    long l = SystemClock.elapsedRealtime();
    sAppStart = l;
    return l;
  }
  
  private long getRenderDuration(List<Long> paramList1, List<Long> paramList2)
  {
    for (;;)
    {
      int i;
      long l3;
      long l4;
      try
      {
        long l5 = paramList1.size();
        long l6 = paramList2.size();
        if (mAggregateMultipleRenders)
        {
          l2 = 0L;
          l1 = 0L;
          i = 0;
          if (i < l5)
          {
            l3 = l1;
            l4 = l2;
            if (i < l6)
            {
              long l7 = RUMUtils.getDuration(((Long)paramList1.get(i)).longValue(), ((Long)paramList2.get(i)).longValue());
              l3 = l1;
              l4 = l2;
              if (l7 != -1L)
              {
                l4 = l2 + l7;
                l3 = l1 + 1L;
              }
            }
          }
          else
          {
            if (l1 <= 0L) {
              break;
            }
            return l2 / l1;
          }
        }
        else
        {
          if ((l5 <= 0L) || (l6 <= 0L)) {
            break;
          }
          l1 = RUMUtils.getDuration(((Long)Collections.min(paramList1)).longValue(), ((Long)Collections.max(paramList2)).longValue());
          return l1;
        }
      }
      catch (Exception paramList1)
      {
        Log.e(TAG, "Exception in calculating render duration", paramList1);
        return -1L;
      }
      i += 1;
      long l1 = l3;
      long l2 = l4;
    }
    return -1L;
  }
  
  static boolean isValidTreeId(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      if (paramString.length() == 16) {
        return true;
      }
      try
      {
        int i = Base64.decode(paramString, 0).length;
        if (i == 16) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        Log.e(TAG, "Tree id not encoded in base 64 format", paramString);
      }
    }
    return false;
  }
  
  public static void setForegroundingMode(FOREGROUNDING_MODE paramFOREGROUNDING_MODE)
  {
    sForegroundingMode = paramFOREGROUNDING_MODE;
  }
  
  public static void setLaunchType(RUMBuilder.LAUNCH_TYPE paramLAUNCH_TYPE)
  {
    sLaunchType = paramLAUNCH_TYPE;
  }
  
  public final void associateAppLaunchToMe()
  {
    mForegroundingMode = sForegroundingMode;
    mLaunchType = sLaunchType;
    if (mLaunchType == RUMBuilder.LAUNCH_TYPE.COLD_LAUNCH) {
      mAppStart = sAppStart;
    }
  }
  
  final GranularMetrics getGranularMetricsFromMap(String paramString)
  {
    if (!granularMetricsMap.containsKey(paramString))
    {
      GranularMetrics localGranularMetrics = new GranularMetrics();
      granularMetricsMap.putIfAbsent(paramString, localGranularMetrics);
    }
    return (GranularMetrics)granularMetricsMap.get(paramString);
  }
  
  public final RUMBuilder renderStart(boolean paramBoolean)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramBoolean)
    {
      mCacheRenderStartTimestamps.add(Long.valueOf(l));
      return this;
    }
    mRenderStartTimestamps.add(Long.valueOf(l));
    return this;
  }
  
  final void sendEventsToTracker()
  {
    int i = 1;
    RUMTracking.getInstance();
    ExperimentalTiming.sendExperimentalTimingEvents(mSessionId, mContext, mPageKey);
    if (granularMetricsMap.size() > 0) {
      if (i == 0) {}
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      long l;
      Object localObject3;
      Object localObject5;
      Object localObject4;
      Object localObject6;
      try
      {
        NativeRealUserMonitoringEvent.Builder localBuilder = new NativeRealUserMonitoringEvent.Builder();
        l = getRenderDuration(mRenderStartTimestamps, mRenderEndTimestamps);
        if (l != -1L)
        {
          if (!mAggregateMultipleRenders) {
            break label1467;
          }
          localBuilder.setRenderStartTimestamp((Long)Collections.max(mRenderStartTimestamps));
          localObject1 = Long.valueOf(l);
          if (localObject1 != null) {
            break label1486;
          }
          hasRenderDuration = false;
          renderDuration = 0L;
        }
        l = getRenderDuration(mCacheRenderStartTimestamps, mCacheRenderEndTimestamps);
        if (l != -1L)
        {
          if (!mAggregateMultipleRenders) {
            break label1505;
          }
          localBuilder.setCacheRenderStartTimestamp((Long)Collections.max(mCacheRenderStartTimestamps));
          localObject1 = Long.valueOf(l);
          if (localObject1 != null) {
            break label1524;
          }
          hasCacheRenderDuration = false;
          cacheRenderDuration = 0L;
        }
        if (mForegroundingMode != FOREGROUNDING_MODE.DEEP_LINKED) {
          break label1543;
        }
        localBuilder.setIsDeepLinked(DeepLinkValue.TRUE);
        if (mForegroundingMode != FOREGROUNDING_MODE.CROSS_LINKED) {
          break label1555;
        }
        localBuilder.setIsCrossLinked(CrossLinkValue.TRUE);
        if (mAppStart != -1L)
        {
          localObject1 = Long.valueOf(mAppStart);
          if (localObject1 != null) {
            break label1567;
          }
          hasAppLaunchStartTimestamp = false;
          appLaunchStartTimestamp = 0L;
          l = RUMUtils.getDuration(mAppStart, mPageStart);
          if (l != -2L)
          {
            if (mLaunchType != RUMBuilder.LAUNCH_TYPE.COLD_LAUNCH) {
              break label1605;
            }
            localObject1 = Long.valueOf(l);
            if (localObject1 != null) {
              break label1586;
            }
            hasAppColdLaunchDuration = false;
            appColdLaunchDuration = 0L;
          }
        }
        localObject1 = new ArrayList();
        localObject2 = granularMetricsMap.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label2227;
        }
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject5 = (String)((Map.Entry)localObject3).getKey();
        localObject4 = (GranularMetrics)((Map.Entry)localObject3).getValue();
        localObject3 = new GranularMetrics.Builder();
        l = RUMUtils.getDuration(mDiskCacheLookupStart, mDiskCacheLookupEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mDiskCacheLookupStart);
          if (localObject6 != null) {
            break label1670;
          }
          hasDiskCacheLookupStartTimestamp = false;
          diskCacheLookupStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label1689;
          }
          hasDiskCacheLookupDuration = false;
          diskCacheLookupDuration = 0L;
        }
        l = RUMUtils.getDuration(mMemoryCacheLookupStart, mMemoryCacheLookupEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mMemoryCacheLookupStart);
          if (localObject6 != null) {
            break label1708;
          }
          hasMemoryCacheLookupStartTimestamp = false;
          memoryCacheLookupStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label1727;
          }
          hasMemoryCacheLookupDuration = false;
          memoryCacheLookupDuration = 0L;
        }
        if (!mCacheHit) {
          break label1746;
        }
        ((GranularMetrics.Builder)localObject3).setIsCacheHit(isCacheHit.HIT);
        l = RUMUtils.getDuration(mParseStart, mParseEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mParseStart);
          if (localObject6 != null) {
            break label1758;
          }
          hasParseStartTimestamp = false;
          parseStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label1777;
          }
          hasParseDuration = false;
          parseDuration = 0L;
        }
        l = RUMUtils.getDuration(mCacheParseStart, mCacheParseEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mCacheParseStart);
          if (localObject6 != null) {
            break label1796;
          }
          hasCachedParseStartTimestamp = false;
          cachedParseStartTimestamp = 0L;
          ((GranularMetrics.Builder)localObject3).setCachedParseDuration(Long.valueOf(l));
        }
        l = RUMUtils.getDuration(mModelBindingStart, mModelBindingEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mModelBindingStart);
          if (localObject6 != null) {
            break label1815;
          }
          hasModelBindingStartTimestamp = false;
          modelBindingStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label1834;
          }
          hasModelBindingDuration = false;
          modelBindingDuration = 0L;
        }
        l = RUMUtils.getDuration(mCacheModelBindingStart, mCacheModelBindingEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mCacheModelBindingStart);
          if (localObject6 != null) {
            break label1853;
          }
          hasCacheModelBindingStartTimestamp = false;
          cacheModelBindingStartTimestamp = 0L;
          ((GranularMetrics.Builder)localObject3).setCachedParseDuration(Long.valueOf(l));
        }
        l = RUMUtils.getDuration(mNetworkRequestStart, mNetworkRequestEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mNetworkRequestStart);
          if (localObject6 != null) {
            break label1872;
          }
          hasNetworkRequestStartTimestamp = false;
          networkRequestStartTimestamp = 0L;
          localObject6 = Long.valueOf(mTimeToFirstChunk);
          if (localObject6 != null) {
            break label1891;
          }
          hasReceivedFirstByteTimestamp = false;
          receivedFirstByteTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label1910;
          }
          hasNetworkRequestDuration = false;
          networkRequestDuration = 0L;
        }
        localObject6 = Long.valueOf(mServerDurationInMS);
        if (localObject6 != null) {
          break label1929;
        }
        hasServerDuration = false;
        serverDuration = 0L;
        localObject6 = Long.valueOf(mResponseSize);
        if (localObject6 != null) {
          break label1948;
        }
        hasResponseSize = false;
        responseSize = 0L;
        localObject6 = Integer.valueOf((int)mStatusCode);
        if (localObject6 != null) {
          break label1967;
        }
        hasHttpStatusCode = false;
        httpStatusCode = 0;
        l = RUMUtils.getDuration(mDNSLookupStart, mDNSLookupEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mDNSLookupStart);
          if (localObject6 != null) {
            break label1986;
          }
          hasDnsLookupStartTimestamp = false;
          dnsLookupStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label2005;
          }
          hasDnsLookupDuration = false;
          dnsLookupDuration = 0L;
        }
        l = RUMUtils.getDuration(mImageDecodeStart, mImageDecodeEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mImageDecodeStart);
          if (localObject6 != null) {
            break label2024;
          }
          hasImageDecodingStartTimestamp = false;
          imageDecodingStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label2043;
          }
          hasImageDecodingDuration = false;
          imageDecodingDuration = 0L;
        }
        l = RUMUtils.getDuration(mImagePostProcessingStart, mImagePostProcessingEnd);
        if (l != -2L)
        {
          localObject6 = Long.valueOf(mImagePostProcessingStart);
          if (localObject6 != null) {
            break label2062;
          }
          hasImagePostprocessingStartTimestamp = false;
          imagePostprocessingStartTimestamp = 0L;
          localObject6 = Long.valueOf(l);
          if (localObject6 != null) {
            break label2081;
          }
          hasImagePostprocessingDuration = false;
          imagePostprocessingDuration = 0L;
        }
        if (mConnectionStart != -1L)
        {
          localObject6 = Long.valueOf(mConnectionStart);
          if (localObject6 != null) {
            break label2100;
          }
          hasConnectionStartTimestamp = false;
          connectionStartTimestamp = 0L;
        }
        if (mTreeid != null)
        {
          localObject6 = mTreeid;
          if (localObject6 != null) {
            break label2119;
          }
          hasRequestTreeId = false;
          requestTreeId = null;
        }
        if (localObject5 != null) {
          break label2135;
        }
        hasRequestUrl = false;
        requestUrl = null;
        localObject5 = Integer.valueOf(mNetworkTimeoutCount);
        if (localObject5 != null) {
          break label2151;
        }
        hasNetworkTimeoutCount = false;
        networkTimeoutCount = 0;
        localObject5 = Integer.valueOf(mConnectionDropCount);
        if (localObject5 != null) {
          break label2170;
        }
        hasConnectionDropCount = false;
        connectionDropCount = 0;
        if (mConnectionTimeoutDuration != -1L)
        {
          localObject5 = Long.valueOf(mConnectionTimeoutDuration);
          if (localObject5 != null) {
            break label2189;
          }
          hasConnectionTimeoutDuration = false;
          connectionTimeoutDuration = 0L;
        }
        if (mConnectionDropDuration != -1L)
        {
          localObject4 = Long.valueOf(mConnectionDropDuration);
          if (localObject4 != null) {
            break label2208;
          }
          hasConnectionDropDuration = false;
          connectionDropDuration = 0L;
        }
        ((List)localObject1).add(((GranularMetrics.Builder)localObject3).build(RecordTemplate.Flavor.RECORD));
        continue;
        return;
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(TAG, "Error creating JSON for RUM beacon", localBuilderException);
      }
      i = 0;
      break;
      label1467:
      localBuilderException.setRenderStartTimestamp((Long)Collections.min(mRenderStartTimestamps));
      continue;
      label1486:
      hasRenderDuration = true;
      renderDuration = ((Long)localObject1).longValue();
      continue;
      label1505:
      localBuilderException.setCacheRenderStartTimestamp((Long)Collections.min(mCacheRenderStartTimestamps));
      continue;
      label1524:
      hasCacheRenderDuration = true;
      cacheRenderDuration = ((Long)localObject1).longValue();
      continue;
      label1543:
      localBuilderException.setIsDeepLinked(DeepLinkValue.FALSE);
      continue;
      label1555:
      localBuilderException.setIsCrossLinked(CrossLinkValue.FALSE);
      continue;
      label1567:
      hasAppLaunchStartTimestamp = true;
      appLaunchStartTimestamp = ((Long)localObject1).longValue();
      continue;
      label1586:
      hasAppColdLaunchDuration = true;
      appColdLaunchDuration = ((Long)localObject1).longValue();
      continue;
      label1605:
      if ((mLaunchType == RUMBuilder.LAUNCH_TYPE.WARM_LAUNCH) && (mForegroundingMode != FOREGROUNDING_MODE.ORGANIC))
      {
        localObject1 = Long.valueOf(l);
        if (localObject1 == null)
        {
          hasAppWarmLaunchDuration = false;
          appWarmLaunchDuration = 0L;
        }
        else
        {
          hasAppWarmLaunchDuration = true;
          appWarmLaunchDuration = ((Long)localObject1).longValue();
          continue;
          label1670:
          hasDiskCacheLookupStartTimestamp = true;
          diskCacheLookupStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1689:
          hasDiskCacheLookupDuration = true;
          diskCacheLookupDuration = ((Long)localObject6).longValue();
          continue;
          label1708:
          hasMemoryCacheLookupStartTimestamp = true;
          memoryCacheLookupStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1727:
          hasMemoryCacheLookupDuration = true;
          memoryCacheLookupDuration = ((Long)localObject6).longValue();
          continue;
          label1746:
          ((GranularMetrics.Builder)localObject3).setIsCacheHit(isCacheHit.MISS);
          continue;
          label1758:
          hasParseStartTimestamp = true;
          parseStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1777:
          hasParseDuration = true;
          parseDuration = ((Long)localObject6).longValue();
          continue;
          label1796:
          hasCachedParseStartTimestamp = true;
          cachedParseStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1815:
          hasModelBindingStartTimestamp = true;
          modelBindingStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1834:
          hasModelBindingDuration = true;
          modelBindingDuration = ((Long)localObject6).longValue();
          continue;
          label1853:
          hasCacheModelBindingStartTimestamp = true;
          cacheModelBindingStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1872:
          hasNetworkRequestStartTimestamp = true;
          networkRequestStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label1891:
          hasReceivedFirstByteTimestamp = true;
          receivedFirstByteTimestamp = ((Long)localObject6).longValue();
          continue;
          label1910:
          hasNetworkRequestDuration = true;
          networkRequestDuration = ((Long)localObject6).longValue();
          continue;
          label1929:
          hasServerDuration = true;
          serverDuration = ((Long)localObject6).longValue();
          continue;
          label1948:
          hasResponseSize = true;
          responseSize = ((Long)localObject6).longValue();
          continue;
          label1967:
          hasHttpStatusCode = true;
          httpStatusCode = ((Integer)localObject6).intValue();
          continue;
          label1986:
          hasDnsLookupStartTimestamp = true;
          dnsLookupStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label2005:
          hasDnsLookupDuration = true;
          dnsLookupDuration = ((Long)localObject6).longValue();
          continue;
          label2024:
          hasImageDecodingStartTimestamp = true;
          imageDecodingStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label2043:
          hasImageDecodingDuration = true;
          imageDecodingDuration = ((Long)localObject6).longValue();
          continue;
          label2062:
          hasImagePostprocessingStartTimestamp = true;
          imagePostprocessingStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label2081:
          hasImagePostprocessingDuration = true;
          imagePostprocessingDuration = ((Long)localObject6).longValue();
          continue;
          label2100:
          hasConnectionStartTimestamp = true;
          connectionStartTimestamp = ((Long)localObject6).longValue();
          continue;
          label2119:
          hasRequestTreeId = true;
          requestTreeId = ((String)localObject6);
          continue;
          label2135:
          hasRequestUrl = true;
          requestUrl = ((String)localObject5);
          continue;
          label2151:
          hasNetworkTimeoutCount = true;
          networkTimeoutCount = ((Integer)localObject5).intValue();
          continue;
          label2170:
          hasConnectionDropCount = true;
          connectionDropCount = ((Integer)localObject5).intValue();
          continue;
          label2189:
          hasConnectionTimeoutDuration = true;
          connectionTimeoutDuration = ((Long)localObject5).longValue();
          continue;
          label2208:
          hasConnectionDropDuration = true;
          connectionDropDuration = ((Long)localObject4).longValue();
        }
      }
    }
    label2227:
    if (mSessionId != null)
    {
      localObject2 = mSessionId;
      if (localObject2 == null)
      {
        hasUserSessionId = false;
        userSessionId = null;
      }
    }
    else
    {
      localObject2 = getInstancemContext).mDownloadQuality;
      localObject2 = NetworkQuality.values()[localObject2.ordinal()];
      if (localObject2 != null) {
        break label2550;
      }
      hasNetworkQuality = false;
      networkQuality = null;
      label2297:
      localObject2 = Integer.valueOf(sDeviceClassYear);
      if (localObject2 != null) {
        break label2566;
      }
      hasDeviceClassYear = false;
      deviceClassYear = 0;
      label2322:
      hasGranularMetrics = true;
      granularMetrics = ((List)localObject1);
      localObject1 = Long.valueOf(mTotalDuration);
      if (localObject1 != null) {
        break label2585;
      }
      hasTotalPageDuration = false;
      totalPageDuration = 0L;
      label2361:
      localObject1 = RUMHelper.getCarrierName(mContext);
      if (localObject1 != null) {
        break label2604;
      }
      hasCarrierName = false;
      carrierName = null;
      label2387:
      localObject1 = RUMHelper.getConnectionType(mContext);
      if (localObject1 != null) {
        break label2620;
      }
      hasConnectionType = false;
      connectionType = null;
      label2413:
      localObject1 = Integer.valueOf(Runtime.getRuntime().availableProcessors());
      if (localObject1 != null) {
        break label2636;
      }
      hasNumberOfCores = false;
      numberOfCores = 0;
      label2441:
      localObject1 = Long.valueOf(mPageStart);
      if (localObject1 != null) {
        break label2655;
      }
      hasPageLoadStartTimestamp = false;
      pageLoadStartTimestamp = 0L;
      label2467:
      localObject1 = mPointOfPresenceId;
      if (localObject1 != null) {
        break label2674;
      }
      hasPointOfPresenceId = false;
      pointOfPresenceId = null;
      label2490:
      if (mProcessId != null)
      {
        localObject1 = mProcessId;
        if (localObject1 != null) {
          break label2690;
        }
        hasAndroidProcessId = false;
      }
    }
    for (androidProcessId = null;; androidProcessId = ((String)localObject1))
    {
      RUMTracking.send(localBuilderException, mContext, mPageKey);
      return;
      hasUserSessionId = true;
      userSessionId = ((String)localObject2);
      break;
      label2550:
      hasNetworkQuality = true;
      networkQuality = ((NetworkQuality)localObject2);
      break label2297;
      label2566:
      hasDeviceClassYear = true;
      deviceClassYear = ((Integer)localObject2).intValue();
      break label2322;
      label2585:
      hasTotalPageDuration = true;
      totalPageDuration = ((Long)localObject1).longValue();
      break label2361;
      label2604:
      hasCarrierName = true;
      carrierName = ((String)localObject1);
      break label2387;
      label2620:
      hasConnectionType = true;
      connectionType = ((String)localObject1);
      break label2413;
      label2636:
      hasNumberOfCores = true;
      numberOfCores = ((Integer)localObject1).intValue();
      break label2441;
      label2655:
      hasPageLoadStartTimestamp = true;
      pageLoadStartTimestamp = ((Long)localObject1).longValue();
      break label2467;
      label2674:
      hasPointOfPresenceId = true;
      pointOfPresenceId = ((String)localObject1);
      break label2490;
      label2690:
      hasAndroidProcessId = true;
    }
  }
  
  public static enum FOREGROUNDING_MODE
  {
    CROSS_LINKED,  DEEP_LINKED,  ORGANIC;
    
    private FOREGROUNDING_MODE() {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.perftimer.RUMBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */