package com.linkedin.android.axle;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;

public class SplashPromoScreenshotCardViewHolder$$ViewInjector<T extends SplashPromoScreenshotCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755219, "field 'title'"), 2131755219, "field 'title'"));
    image = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755220, "field 'image'"), 2131755220, "field 'image'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    image = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoScreenshotCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */