package com.linkedin.android.premium.profinder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.webviewer.WebViewerActivity;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import javax.inject.Inject;

public final class ProfinderServiceProposalActivityIntent
  extends IntentFactory<WebViewerBundle>
  implements DeeplinkIntent
{
  @Inject
  I18NManager i18NManager;
  
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramArrayMap = new WebViewerBundle(paramString, i18NManager.getString(2131233078), null, "profinder_service_proposal", null, 8);
    paramContext = provideIntent(paramContext);
    paramContext.putExtras(paramArrayMap.build());
    return paramContext;
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, WebViewerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.profinder.ProfinderServiceProposalActivityIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */