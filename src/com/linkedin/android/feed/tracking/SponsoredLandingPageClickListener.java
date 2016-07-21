package com.linkedin.android.feed.tracking;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

public class SponsoredLandingPageClickListener
  extends TrackingOnClickListener
{
  private final WeakReference<FragmentComponent> fragmentComponent;
  private final String landingUrl;
  private final String title;
  private final Update update;
  
  public SponsoredLandingPageClickListener(FragmentComponent paramFragmentComponent, Update paramUpdate, String paramString1, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString1, paramVarArgs);
    update = paramUpdate;
    landingUrl = paramString2;
    title = paramString2;
    fragmentComponent = new WeakReference(paramFragmentComponent);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
    if (localFragmentComponent == null) {}
    for (paramView = null; paramView == null; paramView = localFragmentComponent.context()) {
      return;
    }
    paramView = WebViewerBundle.createFeedViewer(landingUrl, title, null, update, 2);
    localFragmentComponent.webRouterUtil().launchWebViewer(paramView, localFragmentComponent, WebRouterUtil.shouldForceIgnoreDeeplink(landingUrl));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.tracking.SponsoredLandingPageClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */