package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RTALikeCardViewHolder$$ViewInjector<T extends RTALikeCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755216, "field 'title'"), 2131755216, "field 'title'"));
    dismiss = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755217, "field 'dismiss'"), 2131755217, "field 'dismiss'"));
    send = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755218, "field 'send'"), 2131755218, "field 'send'"));
  }
  
  public void reset(T paramT)
  {
    title = null;
    dismiss = null;
    send = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTALikeCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */