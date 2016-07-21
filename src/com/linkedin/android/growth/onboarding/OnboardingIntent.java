package com.linkedin.android.growth.onboarding;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class OnboardingIntent
  extends IntentFactory<OnboardingBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    if ((paramLinkingRoutes.equals(LinkingRoutes.ONBOARDING_EMAIL)) || (paramLinkingRoutes.equals(LinkingRoutes.COMM_ONBOARDING_EMAIL))) {
      paramContext.putExtras(OnboardingBundleBuilder.create$5df52dcd(paramString).build());
    }
    return paramContext;
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, OnboardingActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */