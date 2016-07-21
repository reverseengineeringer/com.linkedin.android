package com.linkedin.android.feed.page.feed.hero;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FeedHeroViewHolder$$ViewInjector<T extends FeedHeroViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    logo = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755803, "field 'logo'"), 2131755803, "field 'logo'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755804, "field 'title'"), 2131755804, "field 'title'"));
    text = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755805, "field 'text'"), 2131755805, "field 'text'"));
    boltOns = ((ViewGroup)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755806, "field 'boltOns'"), 2131755806, "field 'boltOns'"));
    prompt = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755810, "field 'prompt'"), 2131755810, "field 'prompt'"));
    dismiss = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755809, "field 'dismiss'"), 2131755809, "field 'dismiss'"));
    div1 = ((View)paramFinder.findRequiredView(paramObject, 2131755807, "field 'div1'"));
    div2 = ((View)paramFinder.findRequiredView(paramObject, 2131755812, "field 'div2'"));
  }
  
  public void reset(T paramT)
  {
    logo = null;
    title = null;
    text = null;
    boltOns = null;
    prompt = null;
    dismiss = null;
    div1 = null;
    div2 = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.FeedHeroViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */