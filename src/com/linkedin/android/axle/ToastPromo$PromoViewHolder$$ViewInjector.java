package com.linkedin.android.axle;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class ToastPromo$PromoViewHolder$$ViewInjector<T extends ToastPromo.PromoViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    logo = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131758662, "field 'logo'"), 2131758662, "field 'logo'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131758663, "field 'title'"), 2131758663, "field 'title'"));
    prompt = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131758664, "field 'prompt'"), 2131758664, "field 'prompt'"));
    cancel = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131758661, "field 'cancel'"), 2131758661, "field 'cancel'"));
    cancelArea = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131758660, "field 'cancelArea'"), 2131758660, "field 'cancelArea'"));
  }
  
  public void reset(T paramT)
  {
    logo = null;
    title = null;
    prompt = null;
    cancel = null;
    cancelArea = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.ToastPromo.PromoViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */