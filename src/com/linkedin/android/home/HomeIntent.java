package com.linkedin.android.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.messaging.MessagingBundleBuilder;
import javax.inject.Inject;

public final class HomeIntent
  extends IntentFactory<HomeBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    switch (HomeIntent.1.$SwitchMap$com$linkedin$android$deeplink$routes$LinkingRoutes[paramLinkingRoutes.ordinal()])
    {
    default: 
      return new Intent(paramContext, HomeActivity.class);
    case 1: 
      return provideIntent(paramContext);
    case 2: 
      paramArrayMap = new MessagingBundleBuilder();
      return provideIntent(paramContext).putExtras(paramArrayMap.build());
    }
    paramArrayMap = new HomeBundle();
    activeTab = HomeTabInfo.FEED;
    return provideIntent(paramContext).putExtras(paramArrayMap.build());
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, HomeActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.home.HomeIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */