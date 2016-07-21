package com.linkedin.android.publishing.sharing;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import javax.inject.Inject;

public final class ShareIntent
  extends IntentFactory<ShareBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    if (paramArrayMap != null)
    {
      paramArrayMap = (String)paramArrayMap.get("updateUrn");
      if (paramArrayMap != null) {
        return paramContext.putExtras(ShareBundle.createFeedShare(ShareComposeBundle.createReshare(paramArrayMap, null, null, false)).build());
      }
    }
    return paramContext.putExtras(ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShare()).build());
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ShareActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.ShareIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */