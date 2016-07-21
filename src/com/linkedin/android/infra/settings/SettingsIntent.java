package com.linkedin.android.infra.settings;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.settings.ui.SettingsActivity;
import javax.inject.Inject;

public final class SettingsIntent
  extends IntentFactory<SettingsTabBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    switch (SettingsIntent.1.$SwitchMap$com$linkedin$android$deeplink$routes$LinkingRoutes[paramLinkingRoutes.ordinal()])
    {
    default: 
      return provideIntent(paramContext);
    case 1: 
      return provideIntent(paramContext).putExtras(SettingsTabBundleBuilder.create(0).build());
    case 2: 
      return provideIntent(paramContext).putExtras(SettingsTabBundleBuilder.create(2).build());
    }
    return provideIntent(paramContext).putExtras(SettingsTabBundleBuilder.create(1).build());
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, SettingsActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.settings.SettingsIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */