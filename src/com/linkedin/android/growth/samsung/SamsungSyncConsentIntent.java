package com.linkedin.android.growth.samsung;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class SamsungSyncConsentIntent
  extends IntentFactory<SamsungSyncConsentIntentBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    return provideIntent(paramContext);
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, SamsungSyncConsentActivity.class).setFlags(268435456);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.samsung.SamsungSyncConsentIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */