package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RTADislikeConfirmCardViewHolder$$ViewInjector<T extends RTADislikeConfirmCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755192, "field 'title'"), 2131755192, "field 'title'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeConfirmCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */