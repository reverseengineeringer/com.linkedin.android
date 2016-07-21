package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class EmptyStateViewHolder$$ViewInjector<T extends EmptyStateViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    message = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755463, "field 'message'"), 2131755463, "field 'message'"));
    image = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755462, "field 'image'"), 2131755462, "field 'image'"));
  }
  
  public void reset(T paramT)
  {
    message = null;
    image = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EmptyStateViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */