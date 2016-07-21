package com.linkedin.android.feed.shared.articleviewer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.infra.webviewer.WebViewerUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.publishing.reader.ArticleBundle;
import com.linkedin.android.publishing.reader.ArticleIntent;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

public class ShareArticleOnClickListener
  extends TrackingOnClickListener
{
  private String articleUrn;
  private final WeakReference<FragmentComponent> fragmentComponent;
  private final boolean shouldOpenNativeReader;
  private String subtitle;
  private String title;
  private Update update;
  private String url;
  
  public ShareArticleOnClickListener(String paramString1, String paramString2, String paramString3, String paramString4, Update paramUpdate, FragmentComponent paramFragmentComponent, String paramString5, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString5, paramVarArgs);
    articleUrn = paramString1;
    url = paramString2;
    title = paramString3;
    subtitle = paramString4;
    update = paramUpdate;
    fragmentComponent = new WeakReference(paramFragmentComponent);
    if (TextUtils.isEmpty(paramString2))
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("URL for article click listener should not be empty!"));
    }
    if ((!"control".equals(paramFragmentComponent.lixManager().getTreatment(Lix.PUBLISHING_USE_NATIVE_READER))) && (WebViewerUtils.isLinkedInArticleUrl(paramString2))) {}
    for (boolean bool = true;; bool = false)
    {
      shouldOpenNativeReader = bool;
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = (FragmentComponent)fragmentComponent.get();
    if ((update != null) && (update.urn != null))
    {
      paramView.eventBus();
      Bus.publish(new ClickEvent(19, update.urn.toString()));
    }
    if ((paramView != null) && (!TextUtils.isEmpty(url)))
    {
      if (shouldOpenNativeReader)
      {
        localObject = ArticleBundle.createFeedViewer(articleUrn, url, title, subtitle, update);
        BaseActivity localBaseActivity = paramView.activity();
        localBaseActivity.startActivity(intentRegistryarticle.newIntent(localBaseActivity, (BundleBuilder)localObject));
      }
    }
    else {
      return;
    }
    Object localObject = WebViewerBundle.createFeedViewer(url, title, subtitle, update, 0);
    paramView.webRouterUtil().launchWebViewer((WebViewerBundle)localObject, paramView, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.articleviewer.ShareArticleOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */