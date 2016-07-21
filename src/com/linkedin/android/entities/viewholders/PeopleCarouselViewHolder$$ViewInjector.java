package com.linkedin.android.entities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PeopleCarouselViewHolder$$ViewInjector<T extends PeopleCarouselViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    cardTitleView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755428, "field 'cardTitleView'"), 2131755428, "field 'cardTitleView'"));
    recyclerView = ((RecyclerView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755429, "field 'recyclerView'"), 2131755429, "field 'recyclerView'"));
    infoContainer = ((View)paramFinder.findRequiredView(paramObject, 2131755430, "field 'infoContainer'"));
    nameView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755431, "field 'nameView'"), 2131755431, "field 'nameView'"));
    headlineView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755432, "field 'headlineView'"), 2131755432, "field 'headlineView'"));
    captionView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755434, "field 'captionView'"), 2131755434, "field 'captionView'"));
    ctaButton = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755435, "field 'ctaButton'"), 2131755435, "field 'ctaButton'"));
    separator = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755433, "field 'separator'"), 2131755433, "field 'separator'"));
  }
  
  public void reset(T paramT)
  {
    cardTitleView = null;
    recyclerView = null;
    infoContainer = null;
    nameView = null;
    headlineView = null;
    captionView = null;
    ctaButton = null;
    separator = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PeopleCarouselViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */