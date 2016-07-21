package com.linkedin.android.entities.shared;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class WebViewerOnClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  private final String title;
  private final String url;
  
  public WebViewerOnClickListener(String paramString1, String paramString2, FragmentComponent paramFragmentComponent, String paramString3, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString3, paramVarArgs);
    url = paramString1;
    title = paramString2;
    fragmentComponent = paramFragmentComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = WebViewerBundle.create(url, title, null, -1);
    fragmentComponent.webRouterUtil().launchWebViewer(paramView, fragmentComponent, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.WebViewerOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */