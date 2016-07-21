package com.linkedin.android.publishing.reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.infra.webviewer.WebViewerFragmentFactory;
import com.linkedin.android.infra.webviewer.WebViewerUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public class ArticleActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      return;
    }
    setContentView(2130969334);
    Object localObject2 = getIntent().getExtras();
    Object localObject1 = ((Bundle)localObject2).getString("urn", "");
    paramBundle = ArticleBundle.getUrl((Bundle)localObject2);
    String str1 = ArticleBundle.getTitle((Bundle)localObject2);
    String str2 = ((Bundle)localObject2).getString("subtitle");
    String str3 = ((Bundle)localObject2).getString("pageKeySuffix", "");
    localObject2 = ArticleBundle.getUpdate((Bundle)localObject2);
    boolean bool1 = applicationComponent.lixManager().getTreatment(Lix.PUBLISHING_USE_NATIVE_READER).equals("control");
    boolean bool2 = "enabled".equals(applicationComponent.lixManager().getTreatment(Lix.INFRA_USE_WEB_ROUTER));
    if ((!bool1) && (WebViewerUtils.isLinkedInArticleUrl(paramBundle))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramBundle = new ArticleBundle((String)localObject1, paramBundle, str1, str2, str3, (Update)localObject2);
      paramBundle = fragmentRegistry.internalArticleViewer.newFragment(paramBundle);
      getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
      return;
    }
    if (bool2)
    {
      localObject1 = new WebViewerBundle(paramBundle, str1, str2, str3, (Update)localObject2, 0);
      activityComponent.webRouterUtil().launchWebViewer((WebViewerBundle)localObject1, activityComponent, WebRouterUtil.shouldForceIgnoreDeeplink(paramBundle));
      finish();
      return;
    }
    paramBundle = new WebViewerBundle(paramBundle, str1, str2, str3, (Update)localObject2, 0);
    paramBundle = fragmentRegistry.externalArticleViewer.newFragment(paramBundle);
    getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.reader.ArticleActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */