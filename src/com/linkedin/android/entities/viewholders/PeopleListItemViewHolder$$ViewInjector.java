package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class PeopleListItemViewHolder$$ViewInjector<T extends PeopleListItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    icon = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755509, "field 'icon'"), 2131755509, "field 'icon'"));
    name = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755511, "field 'name'"), 2131755511, "field 'name'"));
    headline = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755512, "field 'headline'"), 2131755512, "field 'headline'"));
    cta = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755510, "field 'cta'"), 2131755510, "field 'cta'"));
  }
  
  public void reset(T paramT)
  {
    icon = null;
    name = null;
    headline = null;
    cta = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PeopleListItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */