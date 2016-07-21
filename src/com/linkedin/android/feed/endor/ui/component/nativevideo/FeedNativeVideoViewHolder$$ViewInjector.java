package com.linkedin.android.feed.endor.ui.component.nativevideo;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ui.TintableImageButton;

public class FeedNativeVideoViewHolder$$ViewInjector<T extends FeedNativeVideoViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    videoFrame = ((FrameLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755707, "field 'videoFrame'"), 2131755707, "field 'videoFrame'"));
    thumbnail = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755708, "field 'thumbnail'"), 2131755708, "field 'thumbnail'"));
    playButton = ((TintableImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755709, "field 'playButton'"), 2131755709, "field 'playButton'"));
    spinner = ((ProgressBar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755710, "field 'spinner'"), 2131755710, "field 'spinner'"));
  }
  
  public void reset(T paramT)
  {
    videoFrame = null;
    thumbnail = null;
    playButton = null;
    spinner = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */