package com.linkedin.android.relationships;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class PymkIntent
  extends IntentFactory<HomeBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramArrayMap = new HomeBundle();
    activeTab = HomeTabInfo.RELATIONSHIPS;
    paramContext = provideIntent(paramContext);
    paramContext.putExtras(paramArrayMap.build());
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, HomeActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.PymkIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */