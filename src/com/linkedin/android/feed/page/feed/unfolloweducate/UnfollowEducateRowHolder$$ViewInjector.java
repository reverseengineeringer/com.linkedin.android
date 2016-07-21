package com.linkedin.android.feed.page.feed.unfolloweducate;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.imageloader.LiImageView;

public class UnfollowEducateRowHolder$$ViewInjector<T extends UnfollowEducateRowHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    image = ((LiImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755856, "field 'image'"), 2131755856, "field 'image'"));
    followStatus = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755859, "field 'followStatus'"), 2131755859, "field 'followStatus'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755857, "field 'title'"), 2131755857, "field 'title'"));
    subTitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755858, "field 'subTitle'"), 2131755858, "field 'subTitle'"));
  }
  
  public void reset(T paramT)
  {
    image = null;
    followStatus = null;
    title = null;
    subTitle = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateRowHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */