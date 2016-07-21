package com.linkedin.android.feed.shared.videoviewer;

import android.content.Context;
import android.view.View;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class ShareVideoOnClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  private final String subtitle;
  private final String title;
  private final Update update;
  private final String url;
  
  public ShareVideoOnClickListener(Update paramUpdate, String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent, String paramString4, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString4, paramVarArgs);
    update = paramUpdate;
    url = paramString1;
    title = paramString2;
    subtitle = paramString3;
    fragmentComponent = paramFragmentComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = fragmentComponent.activity();
    Object localObject = url;
    if ((((String)localObject).endsWith(".mp4")) || (((String)localObject).endsWith(".3gp"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = VideoViewerBundle.create(url, title, subtitle);
      paramView.startActivity(fragmentComponent.intentRegistry().videoViewer.newIntent(paramView, (BundleBuilder)localObject));
      return;
    }
    paramView = WebViewerBundle.createFeedViewer(url, title, subtitle, update, 1);
    fragmentComponent.webRouterUtil().launchWebViewer(paramView, fragmentComponent, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.ShareVideoOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */