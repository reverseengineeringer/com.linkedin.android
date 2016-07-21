package com.linkedin.android.feed.endor.ui.component.basictext;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedBasicTextViewHolder$$ViewInjector<T extends FeedBasicTextViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    textView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755612, "field 'textView'"), 2131755612, "field 'textView'"));
  }
  
  public void reset(T paramT)
  {
    textView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */