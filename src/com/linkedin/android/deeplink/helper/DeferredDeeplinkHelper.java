package com.linkedin.android.deeplink.helper;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.util.Log;
import com.linkedin.android.deeplink.services.DeferredDeeplinkingService;
import com.linkedin.android.deeplink.services.DeferredDeeplinkingServiceBindingListener;
import com.linkedin.android.deeplink.services.DeferredDeeplinkingServiceConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeferredDeeplinkHelper
{
  public static final String TAG = DeferredDeeplinkHelper.class.getSimpleName();
  private static DeferredDeeplinkHelper instance;
  private static final Object instanceLock = new Object();
  private Context applicationContext;
  private volatile int bindCount = 0;
  public Map<String, DeferredDeeplinkingServiceConnection> connections = new ConcurrentHashMap();
  protected ArrayMap<String, Pair<String, Long>> deferredUriMap = new ArrayMap();
  private volatile boolean isUnbound = true;
  
  private DeferredDeeplinkHelper(Context paramContext)
  {
    applicationContext = paramContext.getApplicationContext();
  }
  
  public static DeferredDeeplinkHelper create(Context paramContext)
  {
    synchronized (instanceLock)
    {
      if (instance == null) {
        instance = new DeferredDeeplinkHelper(paramContext);
      }
      return instance;
    }
  }
  
  public static DeferredDeeplinkHelper getInstance()
  {
    return instance;
  }
  
  public final void clearDeferredLink(String paramString)
  {
    Log.i(TAG, "Cleared deferred deeplink for package: " + paramString);
    deferredUriMap.remove(paramString);
  }
  
  public final void doBindService(final DeferredDeeplinkingServiceBindingListener paramDeferredDeeplinkingServiceBindingListener)
  {
    Object localObject1;
    final Object localObject2;
    Object localObject3;
    try
    {
      isUnbound = false;
      localObject1 = new ArrayList();
      localObject2 = new Intent("com.linkedin.android.deeplink.DEFERRED_DEEPLINK_ACTION");
      localObject2 = applicationContext.getPackageManager().queryIntentServices((Intent)localObject2, 4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResolveInfo)((Iterator)localObject2).next();
        if ((serviceInfo != null) && ("com.linkedin.android.deeplink.services.DeferredDeeplinkingService".equalsIgnoreCase(serviceInfo.name))) {
          ((List)localObject1).add(serviceInfo.packageName);
        }
      }
      if (!((List)localObject1).isEmpty()) {
        break label128;
      }
    }
    finally {}
    paramDeferredDeeplinkingServiceBindingListener.onBindSuccess();
    for (;;)
    {
      return;
      label128:
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        try
        {
          localObject3 = new DeferredDeeplinkingServiceConnection(new DeferredDeeplinkingServiceBindingListener()
          {
            public final void onBindSuccess()
            {
              DeferredDeeplinkHelper.access$010(DeferredDeeplinkHelper.this);
              if (isUnbound) {
                doUnbindService(localObject2);
              }
              while (bindCount != 0) {
                return;
              }
              paramDeferredDeeplinkingServiceBindingListener.onBindSuccess();
            }
          });
          Intent localIntent = new Intent();
          localIntent.addCategory("com.linkedin.android.deeplink.DEFERRED_DEEPLINK_CATEGORY");
          localIntent.setClassName((String)localObject2, DeferredDeeplinkingService.class.getName());
          if (applicationContext.bindService(localIntent, (ServiceConnection)localObject3, 1))
          {
            bindCount += 1;
            connections.put(localObject2, localObject3);
          }
        }
        catch (SecurityException localSecurityException)
        {
          Log.e(TAG, "SecurityException while binding to Deferred Deeplinking Service with packageName=" + (String)localObject2 + "; Ignoring.");
        }
      }
    }
  }
  
  public final void doUnbindService(String paramString)
  {
    try
    {
      paramString = (DeferredDeeplinkingServiceConnection)connections.remove(paramString);
      if (paramString != null) {
        applicationContext.unbindService(paramString);
      }
      return;
    }
    finally {}
  }
  
  public final Pair<String, Long> getLocalDeferredDeeplink(String paramString)
  {
    return (Pair)deferredUriMap.get(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.helper.DeferredDeeplinkHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */