package com.linkedin.android.feed.endor.ui.component.commentary;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.ExpandableTextView;

public class FeedCommentaryViewHolder$$ViewInjector<T extends FeedCommentaryViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    commentary = ((ExpandableTextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755643, "field 'commentary'"), 2131755643, "field 'commentary'"));
  }
  
  public void reset(T paramT)
  {
    commentary = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */