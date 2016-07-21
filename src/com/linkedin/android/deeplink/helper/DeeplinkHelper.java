package com.linkedin.android.deeplink.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.exceptions.DeeplinkException;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntentChain;
import com.linkedin.android.litrackinglib.metric.Tracker;
import java.util.ArrayList;
import java.util.List;

public final class DeeplinkHelper
{
  private static DeeplinkHelper instance;
  private static final Object instanceLock = new Object();
  protected ArrayMap<LinkingRoutes, DeeplinkIntentChain> deeplinkIntentsMap = new ArrayMap();
  Tracker tracker;
  
  private DeeplinkHelper(Tracker paramTracker)
  {
    tracker = paramTracker;
  }
  
  public static DeeplinkHelper create(Tracker paramTracker)
  {
    synchronized (instanceLock)
    {
      if (instance == null) {
        instance = new DeeplinkHelper(paramTracker);
      }
      return instance;
    }
  }
  
  public static DeeplinkHelper getInstance()
  {
    return instance;
  }
  
  @Deprecated
  public static List<Intent> getIntentForUrl$53956ba3(Context paramContext, Intent paramIntent)
    throws DeeplinkException
  {
    return LaunchHelper.getIntentFromDeeplink(paramContext, paramIntent);
  }
  
  public final ArrayList<Intent> getAllRegisteredDeeplinkIntents(Context paramContext, LinkingRoutes paramLinkingRoutes, ArrayMap<String, String> paramArrayMap, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    DeeplinkIntentChain localDeeplinkIntentChain = (DeeplinkIntentChain)deeplinkIntentsMap.get(paramLinkingRoutes);
    if (localDeeplinkIntentChain != null)
    {
      if ((followupIntents != null) && (!paramBoolean)) {
        localArrayList.addAll(followupIntents);
      }
      localArrayList.add(deeplinkIntent.getDeeplinkIntent(paramContext, paramArrayMap, paramString, paramLinkingRoutes));
    }
    return localArrayList;
  }
  
  public final void registerDeeplinkIntent(LinkingRoutes paramLinkingRoutes, DeeplinkIntent paramDeeplinkIntent)
  {
    registerDeeplinkIntent(paramLinkingRoutes, paramDeeplinkIntent, null);
  }
  
  public final void registerDeeplinkIntent(LinkingRoutes paramLinkingRoutes, DeeplinkIntent paramDeeplinkIntent, ArrayList<Intent> paramArrayList)
  {
    if (paramLinkingRoutes != null) {
      deeplinkIntentsMap.put(paramLinkingRoutes, new DeeplinkIntentChain(paramDeeplinkIntent, paramArrayList));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.helper.DeeplinkHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */