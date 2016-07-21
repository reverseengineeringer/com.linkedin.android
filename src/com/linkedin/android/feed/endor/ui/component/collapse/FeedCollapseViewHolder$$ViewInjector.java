package com.linkedin.android.feed.endor.ui.component.collapse;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedCollapseViewHolder$$ViewInjector<T extends FeedCollapseViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755615, "field 'title'"), 2131755615, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755616, "field 'subtitle'"), 2131755616, "field 'subtitle'"));
    undo = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755617, "field 'undo'"), 2131755617, "field 'undo'"));
    improveMyFeed = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755618, "field 'improveMyFeed'"), 2131755618, "field 'improveMyFeed'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    subtitle = null;
    undo = null;
    improveMyFeed = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.collapse.FeedCollapseViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */