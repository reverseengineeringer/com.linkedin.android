package com.linkedin.android.growth.login;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class LoginIntent
  extends IntentFactory<LoginIntentBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    return new Intent(paramContext, LoginActivity.class);
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, LoginActivity.class).setFlags(268533760);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */