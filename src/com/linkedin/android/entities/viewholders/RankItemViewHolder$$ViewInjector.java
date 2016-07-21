package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RankItemViewHolder$$ViewInjector<T extends RankItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    rank = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755514, "field 'rank'"), 2131755514, "field 'rank'"));
    description = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755515, "field 'description'"), 2131755515, "field 'description'"));
    caption = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755516, "field 'caption'"), 2131755516, "field 'caption'"));
  }
  
  public void reset(T paramT)
  {
    rank = null;
    description = null;
    caption = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.RankItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */