package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EntityMultiHeadlineItemViewHolder$$ViewInjector<T extends EntityMultiHeadlineItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    header = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755507, "field 'header'"), 2131755507, "field 'header'"));
    body = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755508, "field 'body'"), 2131755508, "field 'body'"));
  }
  
  public void reset(T paramT)
  {
    header = null;
    body = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityMultiHeadlineItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */