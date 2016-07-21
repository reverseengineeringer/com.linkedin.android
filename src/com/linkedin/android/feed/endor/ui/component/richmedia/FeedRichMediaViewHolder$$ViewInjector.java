package com.linkedin.android.feed.endor.ui.component.richmedia;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.AspectRatioImageView;
import com.linkedin.android.infra.ui.TintableImageButton;

public class FeedRichMediaViewHolder$$ViewInjector<T extends FeedRichMediaViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    imageView = ((AspectRatioImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755722, "field 'imageView'"), 2131755722, "field 'imageView'"));
    playButton = ((TintableImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755723, "field 'playButton'"), 2131755723, "field 'playButton'"));
  }
  
  public void reset(T paramT)
  {
    imageView = null;
    playButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */