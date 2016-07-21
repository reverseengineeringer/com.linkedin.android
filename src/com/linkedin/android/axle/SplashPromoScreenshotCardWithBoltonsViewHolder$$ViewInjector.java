package com.linkedin.android.axle;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;

public class SplashPromoScreenshotCardWithBoltonsViewHolder$$ViewInjector<T extends SplashPromoScreenshotCardWithBoltonsViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755221, "field 'title'"), 2131755221, "field 'title'"));
    image = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755222, "field 'image'"), 2131755222, "field 'image'"));
    boltonText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755224, "field 'boltonText'"), 2131755224, "field 'boltonText'"));
    facePile = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755223, "field 'facePile'"), 2131755223, "field 'facePile'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    image = null;
    boltonText = null;
    facePile = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.SplashPromoScreenshotCardWithBoltonsViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */