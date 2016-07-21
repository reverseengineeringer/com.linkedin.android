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

public final class ConnectedIntent
  extends IntentFactory<HomeBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramString = new HomeBundle();
    activeTab = HomeTabInfo.RELATIONSHIPS;
    if (paramArrayMap != null)
    {
      paramLinkingRoutes = new RelationshipsBundleBuilder();
      propId = ((String)paramArrayMap.get("propId"));
      activeTabBundleBuilder = paramLinkingRoutes;
    }
    paramContext = provideIntent(paramContext);
    paramContext.putExtras(paramString.build());
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, HomeActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.ConnectedIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */