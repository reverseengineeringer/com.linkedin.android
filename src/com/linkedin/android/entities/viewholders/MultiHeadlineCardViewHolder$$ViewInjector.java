package com.linkedin.android.entities.viewholders;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.expandableview.ExpandableView;

public class MultiHeadlineCardViewHolder$$ViewInjector<T extends MultiHeadlineCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    multiHeadlineView = ((ExpandableView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755422, "field 'multiHeadlineView'"), 2131755422, "field 'multiHeadlineView'"));
  }
  
  public void reset(T paramT)
  {
    multiHeadlineView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.MultiHeadlineCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */