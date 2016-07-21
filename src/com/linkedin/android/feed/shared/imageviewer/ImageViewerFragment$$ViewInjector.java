package com.linkedin.android.feed.shared.imageviewer;

import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.imageloader.LiImageView;

public class ImageViewerFragment$$ViewInjector<T extends ImageViewerFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    toolbar = ((Toolbar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755468, "field 'toolbar'"), 2131755468, "field 'toolbar'"));
    imageView = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755817, "field 'imageView'"), 2131755817, "field 'imageView'"));
    backgroundOverlay = ((View)paramFinder.findRequiredView(paramObject, 2131755816, "field 'backgroundOverlay'"));
    bottomContainer = ((FeedComponentsView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755818, "field 'bottomContainer'"), 2131755818, "field 'bottomContainer'"));
  }
  
  public void reset(T paramT)
  {
    toolbar = null;
    imageView = null;
    backgroundOverlay = null;
    bottomContainer = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */