package com.linkedin.android.feed.shared.videoviewer;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class VideoViewerFragment$$ViewInjector<T extends VideoViewerFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    rootLayout = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755885, "field 'rootLayout'"), 2131755885, "field 'rootLayout'"));
    videoViewer = ((VideoView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755886, "field 'videoViewer'"), 2131755886, "field 'videoViewer'"));
    videoControl = ((VideoControl)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755887, "field 'videoControl'"), 2131755887, "field 'videoControl'"));
  }
  
  public void reset(T paramT)
  {
    rootLayout = null;
    videoViewer = null;
    videoControl = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */