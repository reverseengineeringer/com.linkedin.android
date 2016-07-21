package com.linkedin.android.feed.shared.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class ImageViewerIntent
  extends IntentFactory<ImageViewerBundle>
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
        paramContext.putExtras(ImageViewerBundle.create(paramArrayMap, null, false).build());
        return paramContext;
      }
      Util.safeThrow$7a8b4789(new IllegalArgumentException("received no update ID for an update rich media deep link!"));
      return paramContext;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("received a null arrayMap for deep linking"));
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ImageViewerActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */