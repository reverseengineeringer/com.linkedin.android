package com.linkedin.android.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.infra.webviewer.WebViewerUtils;
import com.linkedin.android.publishing.reader.ArticleActivity;
import com.linkedin.android.publishing.reader.ArticleBundle;
import javax.inject.Inject;

public final class DeepLinkArticleIntent
  extends IntentFactory<ArticleBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    Intent localIntent = provideIntent(paramContext);
    if ((paramArrayMap != null) && (paramString != null))
    {
      if ((!((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent().lixManager().getTreatment(Lix.PUBLISHING_USE_NATIVE_READER).equals("control")) && (WebViewerUtils.isLinkedInArticleUrl(paramString))) {}
      for (int i = 1;; i = 0)
      {
        boolean bool = paramLinkingRoutes.equals(LinkingRoutes.PULSE_CED);
        paramContext = paramString;
        int j = i;
        if (bool)
        {
          paramArrayMap = WebViewerUtils.parsePulseArticleFromEmail(paramString);
          paramContext = paramArrayMap;
          j = i;
          if (paramArrayMap == null)
          {
            paramContext = paramString;
            j = 0;
          }
        }
        if (j == 0) {
          break;
        }
        localIntent.putExtras(new ArticleBundle(null, paramContext, null, null, null, null).build());
        return localIntent;
      }
      localIntent.putExtras(WebViewerBundle.createFeedViewer(paramContext, null, null, null, 0).build());
      return localIntent;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap / originalUrl should not be null"));
    return localIntent;
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ArticleActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.DeepLinkArticleIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */