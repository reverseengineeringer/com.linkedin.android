package com.linkedin.android.entities.jymbii;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class JymbiiIntent
  extends IntentFactory<JymbiiBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    paramContext.putExtras(JymbiiBundleBuilder.create().build());
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, JymbiiActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */