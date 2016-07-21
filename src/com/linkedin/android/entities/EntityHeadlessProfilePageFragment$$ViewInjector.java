package com.linkedin.android.entities;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EntityHeadlessProfilePageFragment$$ViewInjector<T extends EntityHeadlessProfilePageFragment>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    backButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755480, "field 'backButton'"), 2131755480, "field 'backButton'"));
  }
  
  public void reset(T paramT)
  {
    backButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityHeadlessProfilePageFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */