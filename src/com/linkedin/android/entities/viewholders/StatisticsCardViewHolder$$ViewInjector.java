package com.linkedin.android.entities.viewholders;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.entities.cards.StatisticsView;

public class StatisticsCardViewHolder$$ViewInjector<T extends StatisticsCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    statisticsView = ((StatisticsView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755446, "field 'statisticsView'"), 2131755446, "field 'statisticsView'"));
  }
  
  public void reset(T paramT)
  {
    statisticsView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.StatisticsCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */