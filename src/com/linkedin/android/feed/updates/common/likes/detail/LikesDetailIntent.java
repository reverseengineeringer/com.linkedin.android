package com.linkedin.android.feed.updates.common.likes.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class LikesDetailIntent
  extends IntentFactory<LikesDetailBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    if (paramArrayMap != null)
    {
      paramArrayMap = (String)paramArrayMap.get("updateUrn");
      if (paramArrayMap != null)
      {
        paramString = new Bundle();
        paramString.putString("updateUrn", paramArrayMap);
        paramString.putString("updateEntityUrn", null);
        paramString.putInt("feedType", 1);
        paramContext.putExtras(new LikesDetailBundleBuilder(paramString).build());
        return paramContext;
      }
      Util.safeThrow$7a8b4789(new IllegalArgumentException("received no update ID for an update likes detail deep link!"));
      return paramContext;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("received a null arrayMap for deep linking"));
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, LikesDetailActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */