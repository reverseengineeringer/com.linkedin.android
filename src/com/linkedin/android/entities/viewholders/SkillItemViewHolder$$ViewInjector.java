package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SkillItemViewHolder$$ViewInjector<T extends SkillItemViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    name = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755518, "field 'name'"), 2131755518, "field 'name'"));
    check = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755519, "field 'check'"), 2131755519, "field 'check'"));
  }
  
  public void reset(T paramT)
  {
    name = null;
    check = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.SkillItemViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */