package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EntityListCardViewHolder$$ViewInjector<T extends EntityListCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    header = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755396, "field 'header'"), 2131755396, "field 'header'"));
    container = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755398, "field 'container'"), 2131755398, "field 'container'"));
    viewAllButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755400, "field 'viewAllButton'"), 2131755400, "field 'viewAllButton'"));
    divider = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755399, "field 'divider'"), 2131755399, "field 'divider'"));
  }
  
  public void reset(T paramT)
  {
    header = null;
    container = null;
    viewAllButton = null;
    divider = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityListCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */