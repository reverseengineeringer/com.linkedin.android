package com.linkedin.android.litrackinglib.network;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.util.ArrayMap;
import android.widget.Toast;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.app.TrackingAppInterface;
import com.linkedin.android.tracking.v2.network.TrackingNetworkStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MetricQueueIntentService
  extends IntentService
{
  private static long batchTime = 10000L;
  private static Object lock = new Object();
  private static int queueSize = 10;
  private static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  private static ScheduledFuture scheduledTimer = null;
  private final DelayTracker delayTracker = new DelayTracker((byte)0);
  private boolean isDebugBuild;
  private String metricPrefPrefix;
  private final ArrayList<String> metricQueue = new ArrayList();
  
  public MetricQueueIntentService()
  {
    super("MetricQueueIntentService");
  }
  
  private void cancelSleepTimer(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    setAlarm(0L, true, paramString1, paramString2, paramHashMap);
  }
  
  private void clearPendingMetrics()
  {
    try
    {
      metricQueue.clear();
      SharedPreferences.Editor localEditor = getSharedPreferences("com.linkedin.android.litrackinglib.QUEUE_PREFS", 0).edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void handleRequest(String paramString1, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean1) {}
    try
    {
      FeatureLog.d("MetricQueueIntentService", "Cleared all pending metrics", "Tracking");
      clearPendingMetrics();
      return;
    }
    finally {}
    if (metricPrefPrefix == null) {
      metricPrefPrefix = "";
    }
    metricQueue.clear();
    if (paramArrayList != null)
    {
      FeatureLog.d("MetricQueueIntentService", "Loaded requeued metrics", "Tracking");
      metricQueue.addAll(paramArrayList);
    }
    loadPendingMetrics();
    if (paramString1 != null) {
      metricQueue.add(paramString1);
    }
    int i;
    if (paramBoolean2)
    {
      FeatureLog.d("MetricQueueIntentService", "!! Metric sending is delayed", "Tracking");
      cancelSleepTimer(paramString2, paramString3, paramHashMap);
      if (paramString1 != null)
      {
        i = 1;
        break label511;
      }
    }
    for (;;)
    {
      label118:
      if (i == 0)
      {
        FeatureLog.d("MetricQueueIntentService", "New metric failed for first time while metrics were already delayed. Will not extend delay.", "Tracking");
        label133:
        i = delayTracker.getTimesThroughThisMethod();
        if (i <= 10) {
          break label227;
        }
        setAlarm(0L, true, paramString2, paramString3, paramHashMap);
        handleRequest(null, null, true, false, false, paramString2, paramString3, paramHashMap);
        delayTracker.reset();
        FeatureLog.d("MetricQueueIntentService", "*** Canceled delay and all pending metrics because we've delayed for too long. ***", "Tracking");
        label193:
        savePendingMetrics();
        break;
        i = 0;
      }
      label227:
      label511:
      while (i != 0)
      {
        i = 0;
        break label118;
        delayTracker.updateTimeToFire();
        break label133;
        long l = delayTracker.getTimeToFire();
        setAlarm(l, false, paramString2, paramString3, paramHashMap);
        FeatureLog.d("MetricQueueIntentService", "Now: " + System.currentTimeMillis() + " Will Fire: " + l + ", Times through: " + i, "Tracking");
        break label193;
        if ((paramBoolean3) || (metricQueue.size() >= queueSize))
        {
          if (metricQueue.size() <= 0) {
            FeatureLog.d("MetricQueueIntentService", "Not force sending the metric. Metric size is " + metricQueue.size(), "Tracking");
          }
          paramString1 = ((ConnectivityManager)getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
          paramBoolean1 = false;
          if (paramString1 != null) {
            paramBoolean1 = paramString1.isConnected();
          }
          if (paramBoolean1)
          {
            FeatureLog.d("MetricQueueIntentService", "Sending metrics to server: force = " + paramBoolean3, "Tracking");
            cancelSleepTimer(paramString2, paramString3, paramHashMap);
            paramString1 = new ArrayList(metricQueue);
            metricQueue.clear();
            postToNetwork(paramString1, paramString2, paramString3, paramHashMap);
            break;
          }
          FeatureLog.d("MetricQueueIntentService", "No network. Will not attempt to send metrics now.", "Tracking");
          setAlarm(System.currentTimeMillis() + 300000L, false, paramString2, paramString3, paramHashMap);
          break;
        }
        savePendingMetrics();
        setAlarm(System.currentTimeMillis() + batchTime, false, paramString2, paramString3, paramHashMap);
        break;
      }
      i = 1;
    }
  }
  
  private void loadPendingMetrics()
  {
    try
    {
      SharedPreferences localSharedPreferences = getSharedPreferences("com.linkedin.android.litrackinglib.QUEUE_PREFS", 0);
      int i = 0;
      String str;
      int j;
      do
      {
        str = localSharedPreferences.getString(metricPrefPrefix + i, null);
        j = i;
        if (str != null)
        {
          metricQueue.add(str);
          j = i + 1;
        }
        i = j;
      } while (str != null);
      FeatureLog.d("MetricQueueIntentService", "Loaded " + j + " items from cache.", "Tracking");
      localSharedPreferences.edit().clear().commit();
      return;
    }
    finally {}
  }
  
  private void postToNetwork(final ArrayList<String> paramArrayList, final String paramString1, final String paramString2, final HashMap<String, String> paramHashMap)
  {
    for (;;)
    {
      try
      {
        FeatureLog.d("MetricQueueIntentService", "Sending to network...", "Tracking");
        Object localObject1 = new StringBuilder("[");
        int i = 0;
        if (i < paramArrayList.size())
        {
          ((StringBuilder)localObject1).append((String)paramArrayList.get(i));
          if (i < paramArrayList.size() - 1) {
            ((StringBuilder)localObject1).append(",");
          }
        }
        else
        {
          ((StringBuilder)localObject1).append("]");
          Object localObject2 = new ArrayMap();
          ((Map)localObject2).put("CSRF-Token", "nocheck");
          if (paramHashMap != null) {
            ((Map)localObject2).putAll(paramHashMap);
          }
          localObject2 = new RequestData(paramString1, (Map)localObject2, ((StringBuilder)localObject1).toString());
          localObject1 = getApplicationContext();
          if (!(localObject1 instanceof TrackingAppInterface))
          {
            Log.e("MetricQueueIntentService", "Host application class needs to implement TrackingAppInterface");
            localObject1 = null;
            if (localObject1 == null) {
              Log.e("MetricQueueIntentService", "Tracker was not initialized with a NetworkClient. This should never happen.");
            }
          }
          else
          {
            localObject1 = ((TrackingAppInterface)localObject1).getTrackingNetworkStack();
            continue;
          }
          ((TrackingNetworkStack)localObject1).postData((IRequestData)localObject2, new IResponseHandler()
          {
            public final void handleResponse(IRequestData paramAnonymousIRequestData, IResponseData paramAnonymousIResponseData)
            {
              if (paramAnonymousIResponseData != null) {}
              for (int i = paramAnonymousIResponseData.getResponseStatusCode(); (i >= 200) && (i <= 299); i = 0)
              {
                delayTracker.reset();
                return;
              }
              if (i == 400)
              {
                delayTracker.reset();
                paramAnonymousIRequestData = "Tracking FE statusCode = " + paramAnonymousIResponseData.getResponseStatusCode() + "\nserverUrl = " + paramAnonymousIRequestData.getRequestUrl() + "\nrequestBody = " + paramAnonymousIRequestData.getPostBody() + "\nrequestHeaders = " + paramAnonymousIRequestData.getRequestHeaders() + "\nresponseString = " + paramAnonymousIResponseData.getResponseString() + "\nresponseHeaders = " + paramAnonymousIResponseData.getResponseHeaders();
                if (isDebugBuild)
                {
                  Log.e("MetricQueueIntentService", paramAnonymousIRequestData);
                  paramAnonymousIRequestData = "Tracking FE returned " + paramAnonymousIResponseData.getResponseStatusCode() + ": Critical Tracking failure, please check the logs";
                  Toast.makeText(getApplicationContext(), paramAnonymousIRequestData, 1).show();
                  return;
                }
                FeatureLog.d(getClass().getName(), paramAnonymousIRequestData, "Tracking");
                return;
              }
              paramAnonymousIRequestData = "Tracking FE statusCode = " + paramAnonymousIResponseData.getResponseStatusCode() + "\nserverUrl = " + paramAnonymousIRequestData.getRequestUrl() + "\nrequestBody = " + paramAnonymousIRequestData.getPostBody() + "\nrequestHeaders = " + paramAnonymousIRequestData.getRequestHeaders() + "\nresponseString = " + paramAnonymousIResponseData.getResponseString() + "\nresponseHeaders = " + paramAnonymousIResponseData.getResponseHeaders();
              if (isDebugBuild)
              {
                Log.e("MetricQueueIntentService", paramAnonymousIRequestData);
                paramAnonymousIRequestData = "Tracking FE returned " + paramAnonymousIResponseData.getResponseStatusCode() + ": Critical Tracking failure, please check the logs";
                Toast.makeText(getApplicationContext(), paramAnonymousIRequestData, 1).show();
              }
              for (;;)
              {
                FeatureLog.d(getClass().getName(), "Metric posting failed", "Tracking");
                MetricQueueIntentService.this.handleRequest(paramArrayList, paramString1, paramString2, paramHashMap);
                return;
                FeatureLog.d(getClass().getName(), paramAnonymousIRequestData, "Tracking");
              }
            }
          });
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  private void savePendingMetrics()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("com.linkedin.android.litrackinglib.QUEUE_PREFS", 0).edit();
      localEditor.clear();
      int i = 0;
      while (i < metricQueue.size())
      {
        localEditor.putString(metricPrefPrefix + i, (String)metricQueue.get(i));
        i += 1;
      }
      FeatureLog.d("MetricQueueIntentService", "Wrote " + metricQueue.size() + " items to cache.", "Tracking");
      localEditor.commit();
      return;
    }
    finally {}
  }
  
  private void setAlarm(long paramLong, boolean paramBoolean, final String paramString1, final String paramString2, final HashMap<String, String> paramHashMap)
  {
    for (;;)
    {
      synchronized (lock)
      {
        FeatureLog.d("MetricQueueIntentService", "ScheduledTimer is " + scheduledTimer, "Tracking");
        if (scheduledTimer != null)
        {
          boolean bool = scheduledTimer.cancel(true);
          FeatureLog.d("MetricQueueIntentService", "Kill scheduled future. instance: " + scheduledTimer + ". Task cancelled " + bool, "Tracking");
          scheduledTimer = null;
          if (paramBoolean) {
            FeatureLog.d("MetricQueueIntentService", "Canceled scheduled future", "Tracking");
          }
        }
        else
        {
          FeatureLog.d("MetricQueueIntentService", "Timer already null", "Tracking");
        }
      }
      Long localLong = Long.valueOf(paramLong - System.currentTimeMillis());
      scheduledTimer = scheduledExecutorService.schedule(new Runnable()
      {
        public final void run()
        {
          FeatureLog.d("MetricQueueIntentService", "Executing task. instance: " + this, "Tracking");
          MetricQueueIntentService.access$400$545e8359(MetricQueueIntentService.this, paramString1, paramString2, paramHashMap);
        }
      }, localLong.longValue(), TimeUnit.MILLISECONDS);
      FeatureLog.d("MetricQueueIntentService", "Set sleep timer. instance: " + scheduledTimer, "Tracking");
      FeatureLog.d("MetricQueueIntentService", " Will Sleep for " + localLong + "ms", "Tracking");
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    FeatureLog.d("MetricQueueIntentService", "Created Service", "Tracking");
  }
  
  public void onDestroy()
  {
    savePendingMetrics();
    FeatureLog.d("MetricQueueIntentService", "Destroyed Service", "Tracking");
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    FeatureLog.d("MetricQueueIntentService", "onHandleIntent", "Tracking");
    if (paramIntent == null)
    {
      FeatureLog.d("MetricQueueIntentService", "Intent is null, this should not happen", "Tracking");
      return;
    }
    String str1 = paramIntent.getStringExtra("newQueueData");
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("requeuedData");
    boolean bool1 = paramIntent.getBooleanExtra("actionReset", false);
    boolean bool2 = paramIntent.getBooleanExtra("force", false);
    String str2 = paramIntent.getStringExtra("serverUrl");
    String str3 = paramIntent.getStringExtra("networkClass");
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("headers");
    boolean bool3 = delayTracker.isDelayed();
    metricPrefPrefix = paramIntent.getStringExtra("prefsPrefix");
    isDebugBuild = paramIntent.getBooleanExtra("debugOn", false);
    if (str2 == null)
    {
      FeatureLog.d("MetricQueueIntentService", "The server URL is null, ignoring intent", "Tracking");
      return;
    }
    handleRequest(str1, localArrayList, bool1, bool3, bool2, str2, str3, localHashMap);
  }
  
  private static final class DelayTracker
  {
    private long timeToFire = 0L;
    private int timesThroughThisMethod = 0;
    
    public final long getTimeToFire()
    {
      try
      {
        long l = timeToFire;
        return l;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final int getTimesThroughThisMethod()
    {
      try
      {
        int i = timesThroughThisMethod;
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public final boolean isDelayed()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 19	com/linkedin/android/litrackinglib/network/MetricQueueIntentService$DelayTracker:timesThroughThisMethod	I
      //   6: istore_1
      //   7: iload_1
      //   8: ifle +9 -> 17
      //   11: iconst_1
      //   12: istore_2
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_2
      //   16: ireturn
      //   17: iconst_0
      //   18: istore_2
      //   19: goto -6 -> 13
      //   22: astore_3
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_3
      //   26: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	27	0	this	DelayTracker
      //   6	2	1	i	int
      //   12	7	2	bool	boolean
      //   22	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	22	finally
    }
    
    public final void reset()
    {
      try
      {
        timeToFire = 0L;
        timesThroughThisMethod = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final void updateTimeToFire()
    {
      try
      {
        timesThroughThisMethod += 1;
        timeToFire = (System.currentTimeMillis() + MetricQueueIntentService.batchTime * timesThroughThisMethod);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.network.MetricQueueIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */