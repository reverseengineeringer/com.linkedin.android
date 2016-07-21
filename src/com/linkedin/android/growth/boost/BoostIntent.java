package com.linkedin.android.growth.boost;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.growth.login.LoginActivity;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import javax.inject.Inject;

public final class BoostIntent
  extends IntentFactory<DefaultBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    if (((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent().auth().isAuthenticated()) {
      return provideIntent(paramContext);
    }
    return new Intent(paramContext, LoginActivity.class);
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, BoostActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.BoostIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */