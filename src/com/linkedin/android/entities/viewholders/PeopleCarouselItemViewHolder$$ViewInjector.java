package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PeopleCarouselItemViewHolder$$ViewInjector<T extends PeopleCarouselItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    profileImage = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755436, "field 'profileImage'"), 2131755436, "field 'profileImage'"));
  }
  
  public void reset(T paramT)
  {
    profileImage = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PeopleCarouselItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */