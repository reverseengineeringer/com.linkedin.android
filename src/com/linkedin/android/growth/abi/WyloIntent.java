package com.linkedin.android.growth.abi;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class WyloIntent
  extends IntentFactory<AbiIntentBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    paramContext.putExtras(new AbiIntentBundle().forceLaunchPastImportedContacts().abiSource("mobile-voyager-wylo-email-deeplink").build());
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, AbiActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.WyloIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */