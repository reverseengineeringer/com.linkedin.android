package com.linkedin.android.messaging.compose;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class InmailComposeIntent
  extends IntentFactory<InmailComposeBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramArrayMap = new InmailComposeBundleBuilder();
    return provideIntent(paramContext).putExtras(paramArrayMap.build());
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, InmailComposeActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.compose.InmailComposeIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */